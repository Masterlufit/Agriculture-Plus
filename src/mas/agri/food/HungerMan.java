package mas.agri.food;

import org.bukkit.entity.Player;

public class HungerMan {
	public static void addHunger(Player p, int amount) {
		p.setFoodLevel(p.getFoodLevel() + amount);
		p.setSaturation(p.getSaturation() + amount);
	}

	public static void minusHunger(Player p, int amount) {
		p.setFoodLevel(p.getFoodLevel() - amount);
		p.setSaturation(p.getSaturation() - amount);
	}
}
