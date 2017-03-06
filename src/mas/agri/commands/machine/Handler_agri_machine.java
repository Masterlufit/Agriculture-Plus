package mas.agri.commands.machine;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.z_plugin_develop_tools.InventoryConfiguration;
import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class Handler_agri_machine {
	public static void help(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "Agri+ Machine Help");

		// Boarder the inventory w/ black glass pane
		InventoryConfiguration.boarderInventory(inv, inv.getSize(), ItemConfiguration.blackGlass());

		ItemStack stove = new ItemStack(Material.FURNACE);
		ItemConfiguration.nameItem(stove, ChatColor.YELLOW + "Stove");
		ItemStack mill = new ItemStack(Material.DISPENSER);
		ItemConfiguration.nameItem(mill, ChatColor.YELLOW + "Mill");
		ItemStack FMT = new ItemStack(Material.ENCHANTMENT_TABLE);
		ItemConfiguration.nameItem(FMT, ChatColor.YELLOW + "Food Mutation Table");
		ItemStack big_stove = new ItemStack(Material.BRICK);
		ItemConfiguration.nameItem(big_stove, ChatColor.YELLOW + "Big Stove");
		ItemStack cutting_station = new ItemStack(Material.WORKBENCH);
		ItemConfiguration.nameItem(cutting_station, ChatColor.YELLOW + "Cutting Station");
		ItemStack juicer = new ItemStack(Material.POTION);
		ItemConfiguration.nameItem(juicer, ChatColor.YELLOW + "Juicer");

		// Place Holder
		ItemStack barrier = new ItemStack(Material.BARRIER);
		ItemConfiguration.nameItem(barrier, ChatColor.RED + "Nothing to see here :P");

		int[] middle_row = new int[] { 10, 11, 12, 13, 14, 15, 16 };
		ItemStack[] middle_items = new ItemStack[] { stove, mill, FMT, big_stove, cutting_station, juicer, barrier };

		for (int a = 0; a < middle_row.length; a++) {
			inv.setItem(middle_row[a], middle_items[a]);
		}

		p.openInventory(inv);
	}
}
