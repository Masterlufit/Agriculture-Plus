package mas.agri.tools.stove;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class ExitStove implements Listener {
	@EventHandler
	public void onExit(InventoryCloseEvent e) {
		if (!(e.getPlayer() instanceof Player))
			return;
		Player p = (Player) e.getPlayer();

		Inventory inv = e.getInventory();
		try {
			inv.getName().equals("");
		} catch (Exception ex) {
			return;
		}

		if (inv.getName().equals("Agri+ Stove Cooking")) {
			int[] slots = new int[] { 8 };
			for (int a = 0; a < slots.length; a++) {
				if (inv.getItem(slots[a]) != null) {
					if (inv.getItem(slots[a]).getType() != Material.BARRIER)
						p.getWorld().dropItem(p.getLocation(), inv.getItem(slots[a]));
				}
			}
		}

	}
}
