package mas.agri.tools.DNA_table;

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

import mas.agri.InventoryConfiguration;
import mas.agri.ItemConfiguration;

public class OpenTable implements Listener {
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

	@EventHandler
	public void click(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();

		if (b.getType() != Material.ENCHANTMENT_TABLE)
			return;
		if (b.getLocation().add(0, -1, 0).getBlock().getType() != Material.BEACON)
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

		Inventory inv = Bukkit.createInventory(null, 45, "Agri+ DNA Table -- Main");

		ItemStack icon = new ItemStack(Material.CLAY_BALL);
		ItemConfiguration.nameItem(icon, ChatColor.GREEN + "Research");

		InventoryConfiguration.boarderInventory(inv, inv.getSize(), ItemConfiguration.blackGlass());

		inv.setItem(20, icon);
		ItemConfiguration.nameItem(icon, ChatColor.GREEN + "Modify");
		inv.setItem(22, icon);
		ItemConfiguration.nameItem(icon, ChatColor.GREEN + "Recycle");
		inv.setItem(24, icon);

		p.openInventory(inv);
	}
}
