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

public class BigStove {
	public static void help(Player p) {
		Inventory inv = Bukkit.createInventory(null, 36, "Agri+ Machine Help -- Big Stove");

		// Icons
		ItemStack BigStove = new ItemStack(Material.BRICK);
		ItemConfiguration.nameItem(BigStove, ChatColor.YELLOW + "BigStove -- Multi Block");
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemConfiguration.nameItem(paper, ChatColor.GREEN + "Desctiption:");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_PURPLE + "BigStove is the crafting grid of Agri+");
		ItemConfiguration.arrayLoreItem(paper, lore);

		// MB
		ItemStack iron_trap_door = new ItemStack(Material.IRON_TRAPDOOR);
		ItemStack stone_slab = new ItemStack(Material.STEP);
		ItemConfiguration.loreItem(stone_slab, ChatColor.DARK_PURPLE + "Bottom Stone Slab");
		ItemStack fire = new ItemStack(Material.BLAZE_POWDER);
		ItemConfiguration.nameItem(fire, ChatColor.WHITE + "Fire");
		ItemStack brick = new ItemStack(Material.BRICK);
		ItemStack daylight = new ItemStack(Material.DAYLIGHT_DETECTOR);

		// Back
		ItemStack back = new ItemStack(Material.REDSTONE);
		ItemConfiguration.nameItem(back, ChatColor.RED + "Back");

		inv.setItem(10, BigStove);
		inv.setItem(19, paper);

		inv.setItem(13, stone_slab);
		inv.setItem(22, iron_trap_door);
		inv.setItem(31, fire);

		inv.setItem(12, daylight);
		inv.setItem(21, brick);
		inv.setItem(30, brick);

		inv.setItem(14, daylight);
		inv.setItem(23, brick);
		inv.setItem(40, brick);
		
		inv.setItem(35, back);

		p.openInventory(inv);
	}
}
