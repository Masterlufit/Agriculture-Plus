package mas.agri.food.pizza;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class CheesePizza implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		try {
			inv.getName().equals("");
		} catch (Exception ex) {
			return;
		}
		if (!inv.getName().equals("Agri+ Big Stove"))
			return;
		ItemStack clicked = e.getCurrentItem();

		try {
			clicked.getType().equals(Material.APPLE);
		} catch (Exception ex) {
			return;
		}

		if (clicked.getType() == Material.BLAZE_POWDER) {
			e.setCancelled(true);
			int[] doughSlot = new int[] { 10, 11, 12, 19, 21, 28, 29, 30 };
			int[] cheeseSlot = new int[] { 20 };

			for (int a = 0; a < doughSlot.length; a++) {
				ItemStack toast = inv.getItem(doughSlot[a]);
				try {
					toast.getType().equals(Material.APPLE);
				} catch (NullPointerException ex) {
					return;
				}
				if (toast.getType() != Material.SNOW_BALL)
					return;
				if (!toast.getItemMeta().hasDisplayName())
					return;
				if (!toast.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Dough"))
					return;
			}
			for (int a = 0; a < cheeseSlot.length; a++) {
				ItemStack steak = inv.getItem(cheeseSlot[a]);
				try {
					steak.getType().equals(Material.APPLE);
				} catch (NullPointerException ex) {
					return;
				}
				if (steak.getType() != Material.PORK)
					return;
			}
			int[] allCraftingSlot = new int[] { 10, 11, 12, 19, 20, 21, 28, 29, 30 };
			int min = inv.getItem(allCraftingSlot[0]).getAmount();

			for (int a = 0; a < allCraftingSlot.length; a++) {
				if (inv.getItem(allCraftingSlot[a]).getAmount() < min) {
					min = inv.getItem(allCraftingSlot[a]).getAmount();
				}
			}

			for (int a = 0; a < allCraftingSlot.length; a++) {
				if (inv.getItem(allCraftingSlot[a]).getAmount() == min) {
					inv.setItem(allCraftingSlot[a], null);
				} else
					inv.getItem(allCraftingSlot[a]).setAmount(inv.getItem(allCraftingSlot[a]).getAmount() - min);
			}

			ItemStack pizza = new ItemStack(Material.COOKIE, min);
			ItemConfiguration.nameItem(pizza, ChatColor.GREEN + "Cheese Pizza");
			inv.setItem(24, pizza);

		} else if (clicked.getType() == Material.STAINED_GLASS_PANE) {
			e.setCancelled(true);
			return;
		} else if (clicked.getType() == Material.BARRIER) {
			e.setCancelled(true);
			return;
		}

	}
}
