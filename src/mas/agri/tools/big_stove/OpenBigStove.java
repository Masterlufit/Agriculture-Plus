package mas.agri.tools.big_stove;

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

import mas.agri.z_plugin_develop_tools.InventoryConfiguration;
import mas.agri.z_plugin_develop_tools.ItemConfiguration;

public class OpenBigStove implements Listener {
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

	@EventHandler
	public void click(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();

		if (b.getType() != Material.IRON_TRAPDOOR)
			return;
		if (b.getLocation().add(0, 1, 0).getBlock().getType() != Material.STEP)
			return;

		boolean side = false;
		if (b.getLocation().add(1, 0, 0).getBlock().getType() == Material.BRICK
				&& b.getLocation().add(1, 1, 0).getBlock().getType() == Material.DAYLIGHT_DETECTOR
				&& b.getLocation().add(1, -1, 0).getBlock().getType() == Material.BRICK
				&& b.getLocation().add(-1, 0, 0).getBlock().getType() == Material.BRICK
				&& b.getLocation().add(-1, 1, 0).getBlock().getType() == Material.DAYLIGHT_DETECTOR
				&& b.getLocation().add(-1, -1, 0).getBlock().getType() == Material.BRICK)
			side = true;
		if (b.getLocation().add(0, 0, 1).getBlock().getType() == Material.BRICK
				&& b.getLocation().add(0, 1, 1).getBlock().getType() == Material.DAYLIGHT_DETECTOR
				&& b.getLocation().add(0, -1, 1).getBlock().getType() == Material.BRICK
				&& b.getLocation().add(0, 0, -1).getBlock().getType() == Material.BRICK
				&& b.getLocation().add(0, 1, -1).getBlock().getType() == Material.DAYLIGHT_DETECTOR
				&& b.getLocation().add(0, -1, -1).getBlock().getType() == Material.BRICK)
			side = true;

		if (!side)
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

		Inventory inv = Bukkit.createInventory(null, 45, "Agri+ Big Stove");
		ItemStack orangeGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		ItemConfiguration.nameItem(orangeGlass, ChatColor.GREEN + " ");
		InventoryConfiguration.boarderInventory(inv, inv.getSize(), orangeGlass);
		ItemStack yellowGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
		ItemConfiguration.nameItem(yellowGlass, ChatColor.GRAY + "Output");

		boolean fuel = false;
		if (b.getLocation().add(0, -1, 0).getBlock().getType() == Material.FIRE)
			fuel = true;

		ItemStack barrier = new ItemStack(Material.BARRIER);
		ItemConfiguration.nameItem(barrier, ChatColor.RED + "No Fuel");
		ItemStack blazePowder = new ItemStack(Material.BLAZE_POWDER);
		ItemConfiguration.nameItem(blazePowder, ChatColor.GREEN + "Fuel");

		int[] yellowGlassSlot = new int[] { 14, 15, 16, 23, 25, 32, 33, 34 };
		for (int a = 0; a < 8; a++) {
			inv.setItem(yellowGlassSlot[a], yellowGlass);
		}

		if (fuel)
			inv.setItem(22, blazePowder);
		else
			inv.setItem(22, barrier);

		inv.setItem(13, orangeGlass);
		inv.setItem(31, orangeGlass);

		p.openInventory(inv);
	}
}
