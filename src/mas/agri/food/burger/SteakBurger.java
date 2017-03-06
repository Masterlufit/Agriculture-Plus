package mas.agri.food.burger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class SteakBurger implements Listener {
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
			int[] toastSlot = new int[] { 10, 11, 12, 28, 29, 30 };
			int[] steakSlot = new int[] { 19, 20, 21 };

			for (int a = 0; a < toastSlot.length; a++) {
				ItemStack toast = inv.getItem(toastSlot[a]);
				try {
					toast.getType().equals(Material.APPLE);
				} catch (NullPointerException ex) {
					return;
				}
				if (toast.getType() != Material.BREAD)
					return;
				if (!toast.getItemMeta().hasDisplayName())
					return;
				if (!toast.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Toast"))
					return;
			}
			for (int a = 0; a < steakSlot.length; a++) {
				ItemStack steak = inv.getItem(steakSlot[a]);
				try {
					steak.getType().equals(Material.APPLE);
				} catch (NullPointerException ex) {
					return;
				}
				if (steak.getType() != Material.COOKED_BEEF)
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

			if (min * 3 <= 64) {
				ItemStack burger = new ItemStack(Material.BREAD, min * 3);
				ItemConfiguration.nameItem(burger, ChatColor.GREEN + "Steak Burger");
				inv.setItem(24, burger);
			} else {
				int stacks = min * 3 / 64;
				int remain = min * 3 - stacks * 64;
				for (int a = 0; a < stacks; a++) {
					ItemStack burger = new ItemStack(Material.BREAD, 64);
					ItemConfiguration.nameItem(burger, ChatColor.GREEN + "Steak Burger");
					e.getWhoClicked().getWorld().dropItemNaturally(e.getWhoClicked().getLocation(), burger);
				}
				ItemStack rburger = new ItemStack(Material.BREAD, remain);
				ItemConfiguration.nameItem(rburger, ChatColor.GREEN + "Steak Burger");
				inv.setItem(24, rburger);
			}
			return;
		} else if (clicked.getType() == Material.STAINED_GLASS_PANE) {
			e.setCancelled(true);
			return;
		} else if (clicked.getType() == Material.BARRIER) {
			e.setCancelled(true);
			return;
		}

	}
}
