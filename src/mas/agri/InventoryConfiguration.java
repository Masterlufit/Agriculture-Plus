package mas.agri;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryConfiguration {
	public static void boarderInventory(Inventory inv, int size, ItemStack boarder) {
		for (int a = 0; a < 9; a++) {
			inv.setItem(a, boarder);
		}

		for (int a = size - 9; a < size; a++) {
			inv.setItem(a, boarder);
		}

		for (int a = 0; a < size; a += 9) {
			inv.setItem(a, boarder);
		}

		for (int a = 8; a < size; a += 9) {
			inv.setItem(a, boarder);
		}
	}
}
