package mas.agri.commands.machine.machine_help;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import mas.agri.commands.machine.Handler_agri_machine;

public class _machine_help_NoClick implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		try {
			inv.getName().equals("");
		} catch (Exception ex) {
			return;
		}
		if (inv.getName().equals("Agri+ Machine Help -- Stove") || inv.getName().equals("Agri+ Machine Help -- Mill")
				|| inv.getName().equals("Agri+ Machine Help -- FMT")
				|| inv.getName().equals("Agri+ Machine Help -- Big Stove")
				|| inv.getName().equals("Agri+ Machine Help -- Cutting Station")
				|| inv.getName().equals("Agri+ Machine Help -- Juicer")) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.REDSTONE
					&& e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName()
					&& e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Back")) {
				Handler_agri_machine.help((Player) e.getWhoClicked());
			}
		}
	}
}
