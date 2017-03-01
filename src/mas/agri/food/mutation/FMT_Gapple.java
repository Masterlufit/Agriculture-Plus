package mas.agri.food.mutation;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.Main;
import mas.agri.tools.food_mutation_table.UsingFMTGUI;

public class FMT_Gapple implements Listener {
	Main pl;

	public FMT_Gapple(Main plugin) {
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
		if (!inv.getName().equals("Agri+ FMT"))
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
		} else if (clicked.getType() == Material.PAPER) {
			e.setCancelled(true);
			return;
		}
		if (clicked.getType() == Material.CLAY_BALL) {
			e.setCancelled(true);
			ItemStack item = inv.getItem(0);
			ItemStack element = inv.getItem(2);
			try {
				item.getType().equals(Material.APPLE);
				element.getType().equals(Material.APPLE);
			} catch (Exception ex) {
				return;
			}

			if (item.getType() != Material.APPLE)
				return;
			if (item.getItemMeta().hasDisplayName())
				return;
			if (item.getAmount() != 1)
				return;

			if (element.getType() != Material.GOLD_INGOT)
				return;
			if (element.getAmount() != 8)
				return;
			if (element.getItemMeta().hasDisplayName())
				return;

			ItemStack output = new ItemStack(Material.GOLDEN_APPLE, 1);

			for (int a = 0; a <= 7; a++) {
				int step = a;
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						UsingFMTGUI.useStove((Player) e.getWhoClicked(), step, output);
					}
				}, a * 5);
			}
		}
	}
}
