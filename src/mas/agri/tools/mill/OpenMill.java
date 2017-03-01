package mas.agri.tools.mill;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.ItemConfiguration;

public class OpenMill implements Listener {
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

	@EventHandler
	public void click(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();

		if (b.getType() != Material.FENCE)
			return;
		if (b.getLocation().add(0, -1, 0).getBlock().getType() != Material.STONE)
			return;

		if (p.isSneaking())
			return;
		e.setCancelled(true);

		int cooldownTime = 1;
		if (cooldowns.containsKey(p.getName())) {
			long secondsLeft = ((cooldowns.get(p.getName()) / 1000) + cooldownTime)
					- (System.currentTimeMillis() / 1000);
			if (secondsLeft > 0)
				return;
		}
		cooldowns.put(p.getName(), System.currentTimeMillis());

		Inventory inv = Bukkit.createInventory(null, 9, "Agri+ Mill");
		ItemStack gear = new ItemStack(Material.CLAY_BALL);
		ItemConfiguration.nameItem(gear, ChatColor.GREEN + "Grind");
		ItemStack barrier = new ItemStack(Material.BARRIER);
		ItemConfiguration.nameItem(barrier, ChatColor.RED + "Output");

		for (int a = 0; a < 9; a++)
			inv.setItem(a, ItemConfiguration.blackGlass());
		inv.setItem(4, gear);
		inv.setItem(0, null);
		inv.setItem(8, barrier);

		p.openInventory(inv);
	}
}
