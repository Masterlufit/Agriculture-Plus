package mas.agri.raw_material.mill;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.ItemConfiguration;
import mas.agri.Main;
import mas.agri.tools.mill.UsingMillGUI;

public class WheatToFlour implements Listener {
	Main pl;

	public WheatToFlour(Main plugin) {
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
		if (!inv.getName().equals("Agri+ Mill"))
			return;
		ItemStack clicked = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();
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
		}
		if (clicked.getType() == Material.CLAY_BALL) {
			e.setCancelled(true);
			ItemStack item = inv.getItem(0);
			try {
				item.getType().equals(Material.APPLE);
			} catch (Exception ex) {
				return;
			}

			if (item.getType() != Material.WHEAT)
				return;

			if (item.getItemMeta().hasDisplayName())
				return;

			ItemStack output = new ItemStack(Material.SUGAR, item.getAmount() * 2);

			if (item.getAmount() > 32) {
				inv.setItem(0, new ItemStack(Material.WHEAT, 32));
				p.getInventory().addItem(new ItemStack(Material.WHEAT, item.getAmount() - 32));
				output.setAmount(64);
			}

			ItemConfiguration.nameItem(output, ChatColor.GREEN + "Flour");

			for (int a = 0; a <= 7; a++) {
				int step = a;
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						UsingMillGUI.useStove((Player) e.getWhoClicked(), step, output);
					}
				}, a * 5);
			}
		}
	}
}
