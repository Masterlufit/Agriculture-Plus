package mas.agri;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mas.agri.Events.onJoinEvent;
import mas.agri.commands.Handler_agri;
import mas.agri.commands.machine.Click_Machine_GUI;
import mas.agri.commands.machine.machine_help._machine_help_NoClick;
import mas.agri.food.CookBread;
import mas.agri.food.burger.SteakBurger;
import mas.agri.food.cheese.CookCheese;
import mas.agri.food.dough.BlockThrowDough;
import mas.agri.food.dough.MakeDough;
import mas.agri.food.juice.AppleJuice;
import mas.agri.food.juice.CarrotJuice;
import mas.agri.food.juice.OrangeJuice;
import mas.agri.food.juice.SugarCaneJuice;
import mas.agri.food.juice.WatermelonJuice;
import mas.agri.food.mutation.FMT_Gapple;
import mas.agri.food.mutation.FMT_NotchApple;
import mas.agri.food.pizza.CheesePizza;
import mas.agri.food.pizza.EatCheesePizza;
import mas.agri.food.potato.chips.CookPotatoChips;
import mas.agri.food.potato.chips.CutChips;
import mas.agri.food.potato.chips.EatChips;
import mas.agri.food.toast.CookToast;
import mas.agri.food.toast.EatToast;
import mas.agri.harvest.Craft_Harvest_Staff;
import mas.agri.harvest.blocks.Cactus_Fruit;
import mas.agri.harvest.mobs.VillagerNose;
import mas.agri.other.FMT_Leather;
import mas.agri.raw_material.mill.WheatToFlour;
import mas.agri.tools.big_stove.ExitBigStove;
import mas.agri.tools.big_stove.OpenBigStove;
import mas.agri.tools.cutting_station.ClickUsingCSGUI;
import mas.agri.tools.cutting_station.ExitCS;
import mas.agri.tools.cutting_station.OpenCS;
import mas.agri.tools.food_mutation_table.ClickUsingFMTGUI;
import mas.agri.tools.food_mutation_table.ExitFMT;
import mas.agri.tools.food_mutation_table.OpenFMT;
import mas.agri.tools.juicer.ClickUsingJuicerGUI;
import mas.agri.tools.juicer.ExitJuicer;
import mas.agri.tools.juicer.OpenJuicer;
import mas.agri.tools.mill.ClickUsingMillGUI;
import mas.agri.tools.mill.ExitMill;
import mas.agri.tools.mill.OpenMill;
import mas.agri.tools.stove.ClickUsingStoveGUI;
import mas.agri.tools.stove.ExitStove;
import mas.agri.tools.stove.OpenStove;

public class Main extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdFile = getDescription();
		Logger logger = getLogger();

		logger.info("Enabling AgriPlus");
		logger.info(pdFile.getName() + "has been enabled! [Version " + pdFile.getVersion() + "]");
		logger.info("This plugin is still work in progress");

		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new onJoinEvent(), this);
		
		registerCommands();
		registerEvents();
		registerConfig();
	}

	private void registerConfig() {

	}

	public void onDisable() {
		PluginDescriptionFile pdFile = getDescription();
		Logger logger = getLogger();

		logger.info("Disabling AgriPlus");
		logger.info(pdFile.getName() + "has been disabled!");
	}

	private void registerCommands() {
		getCommand("aplus").setExecutor(new Handler_agri());
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		// Help Events
		pm.registerEvents(new Click_Machine_GUI(), this);
		pm.registerEvents(new _machine_help_NoClick(), this);

		/**
		 * Register Machines & Recipe
		 */
		// Stove
		pm.registerEvents(new OpenStove(), this);
		pm.registerEvents(new ClickUsingStoveGUI(), this);
		pm.registerEvents(new ExitStove(), this);
		// Use Stove
		pm.registerEvents(new CookBread(this), this);
		pm.registerEvents(new CookToast(this), this);
		pm.registerEvents(new CookCheese(this), this);
		pm.registerEvents(new CookPotatoChips(this), this);

		// FMT
		pm.registerEvents(new OpenFMT(), this);
		pm.registerEvents(new ClickUsingFMTGUI(), this);
		pm.registerEvents(new ExitFMT(), this);
		// Use FMT
		pm.registerEvents(new FMT_Gapple(this), this);
		pm.registerEvents(new FMT_NotchApple(this), this);
		pm.registerEvents(new FMT_Leather(this), this);

		// Mill
		pm.registerEvents(new OpenMill(), this);
		pm.registerEvents(new ClickUsingMillGUI(), this);
		pm.registerEvents(new ExitMill(), this);
		// Use Mill
		pm.registerEvents(new WheatToFlour(this), this);

		// Big Stove
		pm.registerEvents(new OpenBigStove(), this);
		pm.registerEvents(new ExitBigStove(), this);
		// Use Big Stove
		pm.registerEvents(new SteakBurger(), this);
		pm.registerEvents(new CheesePizza(), this);

		// Juicer
		pm.registerEvents(new OpenJuicer(), this);
		pm.registerEvents(new ClickUsingJuicerGUI(), this);
		pm.registerEvents(new ExitJuicer(), this);
		// Use Juicer
		pm.registerEvents(new SugarCaneJuice(this), this);
		pm.registerEvents(new AppleJuice(this), this);
		pm.registerEvents(new OrangeJuice(this), this);
		pm.registerEvents(new CarrotJuice(this), this);
		pm.registerEvents(new WatermelonJuice(this), this);

		// Cutting Station
		pm.registerEvents(new OpenCS(), this);
		pm.registerEvents(new ClickUsingCSGUI(), this);
		pm.registerEvents(new ExitCS(), this);
		// Use Cutting Station
		pm.registerEvents(new CutChips(this), this);

		/**
		 * Register Food
		 */
		pm.registerEvents(new EatToast(), this);
		pm.registerEvents(new EatCheesePizza(), this);
		pm.registerEvents(new EatChips(), this);

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
