package mas.agri.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mas.agri.commands.machine.Handler_agri_machine;

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
			mainHelp(p);
			return false;
		}
		if (subCat == null || subCat.equalsIgnoreCase("help")) {
			mainHelp(p);
		} else if (subCat.equalsIgnoreCase("reload") || subCat.equalsIgnoreCase("r")) {
			p.performCommand("plugman reload AgriPlus");
		} else if (subCat.equals("machine")) {
			Handler_agri_machine.help(p);
		}
		p.playSound(p.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 10, 1);
		return false;

	}

	public static void mainHelp(Player p) {
		p.sendMessage(
				ChatColor.GRAY + "[=-=-=-=-=-=-=-=-=" + ChatColor.GOLD + "oOo" + ChatColor.GRAY + "=-=-=-=-=-=-=-=-=]");
		p.sendMessage(ChatColor.YELLOW + "AgriPlus Help:");
		p.sendMessage(ChatColor.AQUA + "/aplus reload -- reload plugin");
		p.sendMessage(ChatColor.AQUA + "/aplus machine -- list of machines & function");
		p.sendMessage(
				ChatColor.GRAY + "[=-=-=-=-=-=-=-=-=" + ChatColor.GOLD + "oOo" + ChatColor.GRAY + "=-=-=-=-=-=-=-=-=]");
	}
}
