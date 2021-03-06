package mas.agri.food;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.Main;
import mas.agri.tools.stove.UsingStoveGUI;

public class CookBread implements Listener {
	Main pl;

	public CookBread(Main plugin) {
		pl = plugin;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		try {
			inv.getName().equals("");
		} catch (Exception ex) {
			return;
		}
		if (!inv.getName().equals("Agri+ Stove"))
			return;
		ItemStack clicked = e.getCurrentItem();

		try {
			clicked.getType().equals(Material.APPLE);
		} catch (Exception ex) {
			return;
		}

		if (clicked.getType() == Material.BARRIER) {
			e.setCancelled(true);
			return;
		} else if (clicked.getType() == Material.STAINED_GLASS_PANE) {
			e.setCancelled(true);
			return;
		}
		if (clicked.getType() == Material.LAVA_BUCKET) {
			e.setCancelled(true);
			ItemStack item = inv.getItem(0);
			
			if (!item.getItemMeta().hasDisplayName())
				return;
			if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Flour"))
				return;
			if (item.getType() != Material.SUGAR)
				return;
			
			ItemStack output = new ItemStack(Material.BREAD, item.getAmount());

			for (int a = 0; a <= 7; a++) {
				int step = a;
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						UsingStoveGUI.useStove((Player) e.getWhoClicked(), step, output);
					}
				}, a * 5);
			}
		}
	}
}
