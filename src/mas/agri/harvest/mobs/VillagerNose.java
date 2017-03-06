package mas.agri.harvest.mobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class VillagerNose implements Listener {
	@EventHandler
	public void onHarvest(PlayerInteractAtEntityEvent e) {
		if (!(e.getRightClicked() instanceof Villager))
			return;
		Player p = e.getPlayer();
		Villager v = (Villager) e.getRightClicked();

		// Check if is harvest staff
		ItemStack item = p.getInventory().getItemInMainHand();
		try {
			item.getType().equals(Material.APPLE);
		} catch (Exception ex) {
			return;
		}
		if (item.getType() != Material.STICK)
			return;
		if (!item.getItemMeta().hasDisplayName())
			return;
		if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Harvest Staff"))
			return;

		// Harvest Nose
		e.setCancelled(true);
		v.setHealth(0);
		Location loc = v.getLocation();

		ItemStack nose = new ItemStack(Material.RABBIT_FOOT);
		ItemConfiguration.nameItem(nose, ChatColor.GREEN + "Villager Nose");

		p.getWorld().dropItemNaturally(loc, nose);
	}
}
