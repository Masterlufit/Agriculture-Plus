package mas.agri.food.dough;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import mas.agri.Main;
import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class MakeDough implements Listener {
	Main pl;

	public MakeDough(Main plugin) {
		pl = plugin;
	}

	ArrayList<Item> doughItem = new ArrayList<Item>();

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		Item item = e.getItemDrop();
		ItemStack itemstack = item.getItemStack();

		if (p.getLocation().getBlock().getType() != Material.STATIONARY_WATER)
			return;
		if (itemstack.getType() != Material.SUGAR)
			return;
		if (!itemstack.getItemMeta().hasDisplayName())
			return;
		if (!itemstack.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Flour"))
			return;
		item.setPickupDelay(32767);
		Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
			@Override
			public void run() {
				ItemStack dough = new ItemStack(Material.SNOW_BALL, itemstack.getAmount());
				ItemConfiguration.nameItem(dough, ChatColor.GREEN + "Dough");
				item.setItemStack(dough);
				item.setPickupDelay(0);
			}
		}, 5 * 20);
	}
}
