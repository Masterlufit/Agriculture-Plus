package mas.agri.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {

	@EventHandler
	public void onJoinEvent(PlayerJoinEvent e) {
		if (e.getPlayer().isOp()){
			e.getPlayer().sendMessage(ChatColor.YELLOW + "AgriPlus v1.2.6 coded and designed by Masterlu & Stormcraftking");
		}
	}

}

