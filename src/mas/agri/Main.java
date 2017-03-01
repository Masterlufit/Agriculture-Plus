package mas.agri;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mas.agri.commands.Handler_agri;
import mas.agri.food.CookBread;
import mas.agri.food.burger.SteakBurger;
import mas.agri.food.cheese.CookCheese;
import mas.agri.food.dough.BlockThrowDough;
import mas.agri.food.dough.MakeDough;
import mas.agri.food.juice.SugarCaneJuice;
import mas.agri.food.mutation.FMT_Gapple;
import mas.agri.food.mutation.FMT_NotchApple;
import mas.agri.food.pizza.CheesePizza;
import mas.agri.food.pizza.EatCheesePizza;
import mas.agri.food.toast.CookToast;
import mas.agri.food.toast.EatToast;
import mas.agri.harvest.Craft_Harvest_Staff;
import mas.agri.harvest.blocks.Cactus_Fruit;
import mas.agri.harvest.mobs.VillagerNose;
import mas.agri.other.FMT_Leather;
import mas.agri.raw_material.mill.WheatToFlour;
import mas.agri.tools.big_stove.OpenBigStove;
import mas.agri.tools.food_mutation_table.ClickUsingFMTGUI;
import mas.agri.tools.food_mutation_table.OpenFMT;
import mas.agri.tools.juicer.ClickUsingJuicerGUI;
import mas.agri.tools.juicer.OpenJuicer;
import mas.agri.tools.mill.ClickUsingMillGUI;
import mas.agri.tools.mill.OpenMill;
import mas.agri.tools.stove.ClickUsingStoveGUI;
import mas.agri.tools.stove.OpenStove;

public class Main extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdFile.getName() + "has been enabled! [Version " + pdFile.getVersion() + "]");
		logger.info("This plugin is still work in progress");

		registerCommands();
		registerEvents();
		registerConfig();
	}

	private void registerConfig() {

	}

	public void onDisable() {
		PluginDescriptionFile pdFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdFile.getName() + "has been disabled!");
	}

	private void registerCommands() {
		getCommand("agriculture").setExecutor(new Handler_agri());
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		/**
		 * Register Machines & Recipe
		 */
		// Stove
		pm.registerEvents(new OpenStove(), this);
		pm.registerEvents(new ClickUsingStoveGUI(), this);
		// Use Stove
		pm.registerEvents(new CookBread(this), this);
		pm.registerEvents(new CookToast(this), this);
		pm.registerEvents(new CookCheese(this), this);

		// FMT
		pm.registerEvents(new OpenFMT(), this);
		pm.registerEvents(new ClickUsingFMTGUI(), this);
		// Use FMT
		pm.registerEvents(new FMT_Gapple(this), this);
		pm.registerEvents(new FMT_NotchApple(this), this);
		pm.registerEvents(new FMT_Leather(this), this);

		// Mill
		pm.registerEvents(new OpenMill(), this);
		pm.registerEvents(new ClickUsingMillGUI(), this);
		// Use Mill
		pm.registerEvents(new WheatToFlour(this), this);

		// Big Stove
		pm.registerEvents(new OpenBigStove(), this);
		// Use Big Stove
		pm.registerEvents(new SteakBurger(), this);
		pm.registerEvents(new CheesePizza(), this);

		// Juicer
		pm.registerEvents(new OpenJuicer(), this);
		pm.registerEvents(new ClickUsingJuicerGUI(), this);
		// Use Juicer
		pm.registerEvents(new SugarCaneJuice(this), this);

		/**
		 * Register Food
		 */
		pm.registerEvents(new EatToast(), this);
		pm.registerEvents(new EatCheesePizza(), this);

		// Harvest from Blocks
		pm.registerEvents(new Cactus_Fruit(), this);

		// Harvest from Entity
		pm.registerEvents(new VillagerNose(), this);

		/**
		 * Others
		 */
		Craft_Harvest_Staff.CraftHS();
		pm.registerEvents(new BetterDrop(), this);

		// Dough
		pm.registerEvents(new BlockThrowDough(), this);
		pm.registerEvents(new MakeDough(this), this);
	}

}
