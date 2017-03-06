package mas.agri.commands.machine.machine_help;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class Stove {
	public static void help(Player p) {
		Inventory inv = Bukkit.createInventory(null, 36, "Agri+ Machine Help -- Stove");

		// Icons
		ItemStack stove = new ItemStack(Material.FURNACE);
		ItemConfiguration.nameItem(stove, ChatColor.YELLOW + "Stove -- Multi Block");
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemConfiguration.nameItem(paper, ChatColor.GREEN + "Desctiption:");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_PURPLE + "Need description for stove :(");
		ItemConfiguration.arrayLoreItem(paper, lore);

		// MB
		ItemStack iron_pressure_plate = new ItemStack(Material.IRON_PLATE);
		ItemStack stone_slab = new ItemStack(Material.STEP);
		ItemConfiguration.loreItem(stone_slab, ChatColor.DARK_PURPLE + "Top Stone Slab");
		ItemStack fire = new ItemStack(Material.BLAZE_POWDER);
		ItemConfiguration.nameItem(fire, ChatColor.WHITE + "Fire");

		// Back
		ItemStack back = new ItemStack(Material.REDSTONE);
		ItemConfiguration.nameItem(back, ChatColor.RED + "Back");

		inv.setItem(10, stove);
		inv.setItem(19, paper);

		inv.setItem(13, iron_pressure_plate);
		inv.setItem(22, stone_slab);
		inv.setItem(31, fire);
		inv.setItem(35, back);

		p.openInventory(inv);
	}
}
