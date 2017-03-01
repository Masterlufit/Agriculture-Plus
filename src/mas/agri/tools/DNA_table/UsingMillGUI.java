package mas.agri.tools.DNA_table;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.ItemConfiguration;

public class UsingMillGUI {
	public static void useStove(Player p, int progress, ItemStack output) {
		Inventory inv = Bukkit.createInventory(null, 9, "Agri+ Mill Grinding");
		ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		ItemConfiguration.nameItem(redGlass, " ");
		ItemStack greenGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		ItemConfiguration.nameItem(greenGlass, " ");
		ItemStack barrier = new ItemStack(Material.BARRIER);
		ItemConfiguration.nameItem(barrier, ChatColor.RED + " ");

		inv.setItem(0, barrier);
		for (int a = 1; a <= 1 + progress; a++) {
			inv.setItem(a, greenGlass);
		}
		for (int a = 1 + progress; a < 9; a++) {
			inv.setItem(a, redGlass);
		}
		inv.setItem(8, null);
		if (progress == 7) {
			for (int a = 1; a <= 1 + progress; a++) {
				inv.setItem(a, greenGlass);
			}
			for (int a = 1 + progress; a < 9; a++) {
				inv.setItem(a, redGlass);
			}
			inv.setItem(8, output);
		}
		p.openInventory(inv);
		p.playSound(p.getLocation(), Sound.BLOCK_GRAVEL_STEP, 10, 0);
	}
}
