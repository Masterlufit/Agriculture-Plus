package mas.agri.tools.big_stove;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class ExitBigStove implements Listener {
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

		if (inv.getName().equals("Agri+ Big Stove")) {
			int[] slots = new int[] { 10, 11, 12, 19, 20, 21, 28, 29, 30 };
			for (int a = 0; a < slots.length; a++) {
				if (inv.getItem(slots[a]) != null) {
					p.getWorld().dropItem(p.getLocation(), inv.getItem(slots[a]));
				}
			}
		}

	}
}
