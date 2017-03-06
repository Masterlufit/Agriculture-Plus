package mas.agri.other_events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {

	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		if (e.getPlayer().isOp()) {
			e.getPlayer()
					.sendMessage(ChatColor.GRAY + "Running " + ChatColor.YELLOW + "Agri" + ChatColor.YELLOW + "Plus"
							+ ChatColor.AQUA + " v1.2.6" + ChatColor.GRAY
							+ " coded and designed by Masterlu & Stormcraftking");
		}
	}

}
