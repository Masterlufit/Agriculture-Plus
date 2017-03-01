package mas.agri.food.dough;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BlockThrowDough implements Listener {
	@EventHandler
	public void onThrow(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			ItemStack item = e.getItem();
			try {
				item.getType().equals(Material.APPLE);
			} catch (Exception ex) {
				return;
			}
			if (item.getType() != Material.SNOW_BALL)
				return;
			if (!item.getItemMeta().hasDisplayName())
				return;
			if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Dough"))
				return;
			e.setCancelled(true);
		}
	}
}
