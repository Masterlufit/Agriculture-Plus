package mas.agri.harvest.blocks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import mas.agri.ItemConfiguration;

public class Cactus_Fruit implements Listener {
	@EventHandler
	public void onBreakBlock(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if (b.getType() != Material.CACTUS)
			return;
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
		e.setCancelled(true);
		b.setType(Material.AIR);
		ItemStack drop = new ItemStack(Material.BEETROOT);
		ItemConfiguration.nameItem(drop, ChatColor.GREEN + "Cactus Fruit");
		b.getWorld().dropItemNaturally(b.getLocation(), drop);
		p.playSound(p.getLocation(), Sound.BLOCK_CLOTH_BREAK, 10, 1);
	}
}
