package mas.agri.food.juice;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import mas.agri.ItemConfiguration;
import mas.agri.Main;
import mas.agri.food.HungerMan;
import mas.agri.tools.juicer.UsingJuicerGUI;

public class AppleJuice implements Listener {
	Main pl;

	public AppleJuice(Main plugin) {
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
		if (!inv.getName().equals("Agri+ Juicer"))
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
		} else if (clicked.getType() == Material.PAPER) {
			e.setCancelled(true);
			return;
		} else if (clicked.getType() == Material.POTION) {
			e.setCancelled(true);
			ItemStack item = inv.getItem(0);
			ItemStack bottle = inv.getItem(2);
			try {
				item.getType().equals(Material.APPLE);
				bottle.getType().equals(Material.APPLE);
			} catch (Exception ex) {
				return;
			}

			if (bottle.getType() != Material.GLASS_BOTTLE)
				return;
			if (item.getType() != Material.APPLE)
				return;
			if (item.getItemMeta().hasDisplayName())
				return;
			if (item.getAmount() != 1)
				return;

			ItemStack output = new ItemStack(Material.POTION, item.getAmount());
			ItemConfiguration.nameItem(output, ChatColor.GREEN + "Apple Juice");

			for (int a = 0; a <= 7; a++) {
				int step = a;
				Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
					@Override
					public void run() {
						UsingJuicerGUI.useStove((Player) e.getWhoClicked(), step, output);
					}
				}, a * 5);
			}
		}
	}

	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem();
		if (item.getType() != Material.POTION)
			return;
		if (!item.getItemMeta().hasDisplayName())
			return;
		if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Apple Juice"))
			return;

		if (p.getInventory().getItemInMainHand().getType() == Material.POTION)
			p.getInventory().setItemInMainHand(null);
		else if (p.getInventory().getItemInOffHand().getType() == Material.POTION)
			p.getInventory().setItemInOffHand(null);
		p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1 * 20, 3, true), true);
		HungerMan.addHunger(p, 4);
	}
}

