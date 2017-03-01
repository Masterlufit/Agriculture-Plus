package mas.agri.food.cheese;

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
import mas.agri.tools.stove.UsingStoveGUI;

public class CookCheese implements Listener {
	Main pl;

	public CookCheese(Main plugin) {
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
		if (!inv.getName().equals("Agri+ Stove"))
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
		}
		if (clicked.getType() == Material.LAVA_BUCKET) {
			e.setCancelled(true);
			ItemStack item = inv.getItem(0);
			try {
				item.getType().equals(Material.APPLE);
			} catch (Exception ex) {
				return;
			}

			if (item.getType() != Material.MILK_BUCKET)
				return;

			if (item.getItemMeta().hasDisplayName())
				return;

			ItemStack output = new ItemStack(Material.PORK, item.getAmount());
			ItemConfiguration.nameItem(output, ChatColor.GREEN + "Cheese");
			e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(),
					new ItemStack(Material.BUCKET));

			for (int a = 0; a <= 7; a++) {
				int step = a;
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						UsingStoveGUI.useStove((Player) e.getWhoClicked(), step, output);
					}
				}, a * 5);
			}
		}
	}
}
