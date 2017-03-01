package mas.agri.food.potato.chips;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import mas.agri.food.HungerMan;

public class EatChips implements Listener {
	@EventHandler
	public void onEat(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem();
		if (item.getType() != Material.POTATO_ITEM)
			return;
		if (!item.getItemMeta().hasDisplayName())
			return;
		if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Potato Slice")) {
			HungerMan.minusHunger(p, 1);
		} else if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Potato Chip")) {
			HungerMan.addHunger(p, 3);
		}
	}
}
