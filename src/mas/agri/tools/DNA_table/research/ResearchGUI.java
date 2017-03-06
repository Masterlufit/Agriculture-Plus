package mas.agri.tools.DNA_table.research;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.z_plugin_develop_tools.InventoryConfiguration;
import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class ResearchGUI {
	public static void openResearch(Player p) {
		Inventory inv = Bukkit.createInventory(null, 45, "Agri+ DNA Table -- Research");

		ItemStack icon = new ItemStack(Material.CLAY_BALL);
		ItemConfiguration.nameItem(icon, ChatColor.GREEN + "Research");

		InventoryConfiguration.boarderInventory(inv, inv.getSize(), ItemConfiguration.blackGlass());

		inv.setItem(20, icon);
		ItemConfiguration.nameItem(icon, ChatColor.GREEN + "Modify");
		inv.setItem(22, icon);
		ItemConfiguration.nameItem(icon, ChatColor.GREEN + "Recycle");
		inv.setItem(24, icon);

		p.openInventory(inv);
	}
}
