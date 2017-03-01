package mas.agri.harvest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import mas.agri.ItemConfiguration;

public class Craft_Harvest_Staff {
	public static void CraftHS() {
		ItemStack staff = new ItemStack(Material.STICK);
		ItemConfiguration.nameItem(staff, ChatColor.GREEN + "Harvest Staff");

		ShapedRecipe recipe = new ShapedRecipe(staff);
		recipe.shape("  F", " S ", "S  ");
		recipe.setIngredient('F', Material.CHORUS_FLOWER);
		recipe.setIngredient('S', Material.BLAZE_ROD);
		Bukkit.getServer().addRecipe(recipe);
	}
}
