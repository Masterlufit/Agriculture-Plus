package mas.agri.commands.machine;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import mas.agri.commands.machine.machine_help.BigStove;
import mas.agri.commands.machine.machine_help.CuttingStation;
import mas.agri.commands.machine.machine_help.FMT;
import mas.agri.commands.machine.machine_help.Juicer;
import mas.agri.commands.machine.machine_help.Mill;
import mas.agri.commands.machine.machine_help.Stove;

public class Click_Machine_GUI implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		try {
			inv.getName().equals("");
		} catch (Exception ex) {
			return;
		}
		if (!inv.getName().equals("Agri+ Machine Help"))
			return;
		e.setCancelled(true);
		ItemStack clicked = e.getCurrentItem();

		if (clicked == null || !clicked.hasItemMeta() || !clicked.getItemMeta().hasDisplayName())
			return;

		Player p = (Player) e.getWhoClicked();
		String display_name = clicked.getItemMeta().getDisplayName();

		if (display_name.equals(ChatColor.YELLOW + "Stove")) {
			Stove.help(p);
		} else if (display_name.equals(ChatColor.YELLOW + "Mill")) {
			Mill.help(p);
		} else if (display_name.equals(ChatColor.YELLOW + "Food Mutation Table")) {
			FMT.help(p);
		} else if (display_name.equals(ChatColor.YELLOW + "Big Stove")) {
			BigStove.help(p);
		} else if (display_name.equals(ChatColor.YELLOW + "Cutting Station")) {
			CuttingStation.help(p);
		} else if (display_name.equals(ChatColor.YELLOW + "Juicer")) {
			Juicer.help(p);
		} else if (display_name.equals(ChatColor.YELLOW + "Notch")) {
			// Place Holder
		} else if (display_name.equals(ChatColor.RED + "Nothing to see here :P")) {
			p.closeInventory();
			p.sendMessage(ChatColor.RED + "I told you nothing to see here >:O");
			p.damage(1);
		} else {
			return;
		}
		p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10, 1);
	}
}
