package mas.agri.tools.DNA_table;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickMainGUI implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		try {
			inv.getName().equals("");
		} catch (Exception ex) {
			return;
		}
		if (!inv.getName().equals("Agri+ DNA Table -- Main"))
			return;
		ItemStack clicked = e.getCurrentItem();

		try {
			clicked.getType().equals(Material.APPLE);
		} catch (Exception ex) {
			return;
		}
		if (clicked.getType() == Material.STAINED_GLASS_PANE) {
			e.setCancelled(true);
			return;
		} else if (clicked.getType() == Material.CLAY_BALL) {
			e.setCancelled(true);
			if (clicked.getItemMeta().hasDisplayName()) {
				String name = clicked.getItemMeta().getDisplayName();
				if (name.equals(ChatColor.GREEN + "Research")) {

				}
				if (name.equals(ChatColor.GREEN + "Modify")) {

				}
				if (name.equals(ChatColor.GREEN + "Recycle")) {

				}
			}
		}
	}
}
