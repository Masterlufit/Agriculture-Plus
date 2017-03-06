package mas.agri.z_plugin_develop_tools;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemConfiguration {
	public static ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack loreItem(ItemStack item, String lore) {
		ItemMeta meta = item.getItemMeta();
		List<String> oLore = meta.getLore();
		try {
			oLore.add(lore);
		} catch (Exception ex) {
			meta.setLore(Arrays.asList(lore));
		}
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack doubleLoreItem(ItemStack item, String lore1, String lore2) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(Arrays.asList(lore1, lore2));
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack arrayLoreItem(ItemStack item, List<String> lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack glowItem(ItemStack item) {
		item.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack blackGlass() {
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		nameItem(item, " ");
		return item;
	}

	public static ItemStack redGlass() {
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		return item;
	}

	public static ItemStack orangeGlass() {
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		nameItem(item, ChatColor.GRAY + "[Agri+]");
		return item;
	}

	public static int getDurability(ItemStack item) {
		if (item.getType() == Material.DIAMOND_AXE || item.getType() == Material.DIAMOND_PICKAXE
				|| item.getType() == Material.DIAMOND_SPADE || item.getType() == Material.DIAMOND_HOE
				|| item.getType() == Material.DIAMOND_SWORD)
			return 1562;
		if (item.getType() == Material.IRON_AXE || item.getType() == Material.IRON_PICKAXE
				|| item.getType() == Material.IRON_SPADE || item.getType() == Material.IRON_HOE
				|| item.getType() == Material.IRON_SWORD)
			return 251;
		if (item.getType() == Material.STONE_AXE || item.getType() == Material.STONE_PICKAXE
				|| item.getType() == Material.STONE_SPADE || item.getType() == Material.STONE_HOE
				|| item.getType() == Material.STONE_SWORD)
			return 132;
		if (item.getType() == Material.WOOD_AXE || item.getType() == Material.WOOD_PICKAXE
				|| item.getType() == Material.WOOD_SPADE || item.getType() == Material.WOOD_HOE
				|| item.getType() == Material.WOOD_SWORD)
			return 60;
		if (item.getType() == Material.GOLD_AXE || item.getType() == Material.GOLD_PICKAXE
				|| item.getType() == Material.GOLD_SPADE || item.getType() == Material.GOLD_HOE
				|| item.getType() == Material.GOLD_SWORD)
			return 33;

		// Armor
		if (item.getType() == Material.DIAMOND_HELMET)
			return 364;

		return 0;
	}
}
