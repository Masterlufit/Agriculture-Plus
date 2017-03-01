package mas.agri.food.pizza;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import mas.agri.food.HungerMan;

public class EatCheesePizza implements Listener {
	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem();
		if (item.getType() != Material.COOKIE)
			return;
		if (!item.getItemMeta().hasDisplayName())
			return;
		if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Cheese Pizza"))
			return;
		HungerMan.addHunger(p, 20);
	}
}
