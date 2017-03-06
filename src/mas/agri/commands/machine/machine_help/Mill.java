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

public class Mill {
	public static void help(Player p) {
		Inventory inv = Bukkit.createInventory(null, 36, "Agri+ Machine Help -- Mill");

		// Icons
		ItemStack mill = new ItemStack(Material.DISPENSER);
		ItemConfiguration.nameItem(mill, ChatColor.YELLOW + "Mill -- Multi Block");
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemConfiguration.nameItem(paper, ChatColor.GREEN + "Desctiption:");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_PURPLE + "Need description for mill :(");
		ItemConfiguration.arrayLoreItem(paper, lore);

		// MB
		ItemStack fence = new ItemStack(Material.FENCE);
		ItemStack iron_block = new ItemStack(Material.IRON_BLOCK);

		// Back
		ItemStack back = new ItemStack(Material.REDSTONE);
		ItemConfiguration.nameItem(back, ChatColor.RED + "Back");

		inv.setItem(10, mill);
		inv.setItem(19, paper);

		inv.setItem(13, fence);
		inv.setItem(22, iron_block);
		inv.setItem(35, back);

		p.openInventory(inv);
	}
}
