package mas.agri.food.toast;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import mas.agri.food.HungerMan;

public class EatToast implements Listener {
	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem();
		if (!item.getItemMeta().hasDisplayName())
			return;
		if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Toast"))
			return;
		HungerMan.addHunger(p, 3);
	}
}
