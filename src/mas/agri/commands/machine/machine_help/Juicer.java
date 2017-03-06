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

public class Juicer {
	public static void help(Player p) {
		Inventory inv = Bukkit.createInventory(null, 36, "Agri+ Machine Help -- Juicer");

		// Icons
		ItemStack Juicer = new ItemStack(Material.POTION);
		ItemConfiguration.nameItem(Juicer, ChatColor.YELLOW + "Juicer -- Multi Block");
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemConfiguration.nameItem(paper, ChatColor.GREEN + "Desctiption:");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_PURPLE + "Need description for Juicer :(");
		ItemConfiguration.arrayLoreItem(paper, lore);

		// MB
		ItemStack iron_trap_door = new ItemStack(Material.IRON_TRAPDOOR);
		ItemStack stained_glass = new ItemStack(Material.STAINED_GLASS);
		ItemStack end_brick = new ItemStack(Material.END_BRICKS);

		// Back
		ItemStack back = new ItemStack(Material.REDSTONE);
		ItemConfiguration.nameItem(back, ChatColor.RED + "Back");

		inv.setItem(10, Juicer);
		inv.setItem(19, paper);

		inv.setItem(13, iron_trap_door);
		inv.setItem(22, stained_glass);
		inv.setItem(31, end_brick);
		inv.setItem(35, back);

		p.openInventory(inv);
	}
}
