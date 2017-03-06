package mas.agri.food.potato.chips;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.Main;
import mas.agri.tools.cutting_station.UsingCSGUI;
import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class CutChips implements Listener {
	Main pl;

	public CutChips(Main plugin) {
		pl = plugin;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		try {
			inv.getName().equals("");
		} catch (Exception ex) {
			return;
		}
		if (!inv.getName().equals("Agri+ CS"))
			return;
		ItemStack clicked = e.getCurrentItem();

		try {
			clicked.getType().equals(Material.APPLE);
		} catch (Exception ex) {
			return;
		}

		if (clicked.getType() == Material.BARRIER) {
			e.setCancelled(true);
			return;
		} else if (clicked.getType() == Material.STAINED_GLASS_PANE) {
			e.setCancelled(true);
			return;
		} else if (clicked.getType() == Material.CLAY_BALL) {
			e.setCancelled(true);
			ItemStack item = inv.getItem(0);
			try {
				item.getType().equals(Material.APPLE);
			} catch (Exception ex) {
				return;
			}

			if (item.getType() != Material.POTATO_ITEM)
				return;

			if (item.getItemMeta().hasDisplayName())
				return;

			if (item.getAmount() * 3 <= 64) {
				ItemStack output = new ItemStack(Material.POTATO_ITEM, item.getAmount() * 3);
				ItemConfiguration.nameItem(output, ChatColor.GREEN + "Potato Slice");
				for (int a = 0; a <= 7; a++) {
					int step = a;
					Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
						@Override
						public void run() {
							UsingCSGUI.useStove((Player) e.getWhoClicked(), step, output);
						}
					}, a * 5);
				}
			} else {
				int stacks = item.getAmount() * 3 / 64;
				int remain = item.getAmount() * 3 - stacks * 64;
				for (int a = 0; a < stacks; a++) {
					ItemStack output = new ItemStack(Material.POTATO_ITEM, 64);
					ItemConfiguration.nameItem(output, ChatColor.GREEN + "Potato Slice");
					e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), output);
				}

				ItemStack remainItem = new ItemStack(Material.POTATO_ITEM, remain);
				ItemConfiguration.nameItem(remainItem, ChatColor.GREEN + "Potato Slice");
				for (int a = 0; a <= 7; a++) {
					int step = a;
					Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
						@Override
						public void run() {
							UsingCSGUI.useStove((Player) e.getWhoClicked(), step, remainItem);
						}
					}, a * 5);
				}

			}

		}
	}
}
