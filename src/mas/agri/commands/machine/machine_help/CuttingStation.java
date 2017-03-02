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

public class CuttingStation {
	public static void help(Player p) {
		Inventory inv = Bukkit.createInventory(null, 36, "Agri+ Machine Help -- Cutting Station");

		// Icons
		ItemStack CuttingStation = new ItemStack(Material.DISPENSER);
		ItemConfiguration.nameItem(CuttingStation, ChatColor.YELLOW + "CuttingStation -- Multi Block");
		ItemStack paper = new ItemStack(Material.PAPER);
		ItemConfiguration.nameItem(paper, ChatColor.GREEN + "Desctiption:");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.DARK_PURPLE + "Need description for Cutting Station :(");

		// MB
		ItemStack iron_pressure_plate = new ItemStack(Material.IRON_PLATE);
		ItemStack piston = new ItemStack(Material.PISTON_BASE);

		// Back
		ItemStack back = new ItemStack(Material.REDSTONE);
		ItemConfiguration.nameItem(back, ChatColor.RED + "Back");

		inv.setItem(10, CuttingStation);
		inv.setItem(19, paper);

		inv.setItem(13, iron_pressure_plate);
		inv.setItem(22, piston);
		inv.setItem(35, back);

		p.openInventory(inv);
	}
}
