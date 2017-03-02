package mas.agri.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Handler_agri implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
			return false;
		}
		Player p = (Player) sender;
		String subCat;
		try {
			subCat = args[0];
		} catch (Exception e) {
			p.sendMessage(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			p.sendMessage(ChatColor.YELLOW + "Agri+ Commands:");
			p.sendMessage(ChatColor.AQUA + "/aplus reload -- reload plugin");
			p.sendMessage(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			return false;
		}
		if (subCat == null || subCat.equalsIgnoreCase("help")) {
			p.sendMessage(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			p.sendMessage(ChatColor.YELLOW + "Agri+ Commands:");
			p.sendMessage(ChatColor.AQUA + "/aplus reload -- reload plugin");
			p.sendMessage(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		} else if (subCat.equalsIgnoreCase("reload")) {
			p.performCommand("plugman reload AgriPlus");
		}
		p.playSound(p.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 10, 1);
		return false;

	}

}
