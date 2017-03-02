package mas.agri.commands.machine.machine_help;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.ItemConfiguration;

public class FMT {
	public static void help(Player p) {
		Inventory inv = Bukkit.createInventory(null, 36, "Agri+ Machine Help -- FMT");

		// Icons
		ItemStack FMT = new ItemStack(Material.ENCHANTMENT_TABLE);
		ItemConfiguration.nameItem(FMT, ChatColor.YELLOW + "FMT -- Multi Block");
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemConfiguration.nameItem(paper, ChatColor.GREEN + "Desctiption:");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_PURPLE + "Need description for FMT :(");

		// MB
		ItemStack beacon = new ItemStack(Material.BEACON);
		ItemStack obsidian = new ItemStack(Material.OBSIDIAN);

		// Back
		ItemStack back = new ItemStack(Material.REDSTONE);
		ItemConfiguration.nameItem(back, ChatColor.RED + "Back");

		inv.setItem(10, FMT);
		inv.setItem(19, paper);

		inv.setItem(13, beacon);
		inv.setItem(22, obsidian);
		inv.setItem(35, back);

		p.openInventory(inv);
	}
}
