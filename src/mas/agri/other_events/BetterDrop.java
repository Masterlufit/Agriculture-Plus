package mas.agri.other_events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class BetterDrop implements Listener {
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (p.getInventory().getItemInMainHand().getAmount() == 0) {
			p.getInventory().setItemInMainHand(null);
		}
	}
}
