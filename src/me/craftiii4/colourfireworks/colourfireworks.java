package me.craftiii4.colourfireworks;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import me.craftiii4.colourfireworks.api.ReloadCommand;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class colourfireworks extends JavaPlugin {

	public FileConfiguration customConfig = null;
	public File customConfigFile = null;

	public boolean vaultcheck = false;

	public String whatworld = "";

	public static boolean latestversion = true;

	public static Permission perms = null;
	public static Economy econ = null;

	public static HashMap<Player, ArrayList<Block>> colourfireworkusers = new HashMap<Player, ArrayList<Block>>();

	public static HashMap<Integer, Integer> WhatIsSlotItemsID = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer> WhatIsSlotItemsSUBID = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer> HowManySlotItems = new HashMap<Integer, Integer>();

	public static HashMap<Integer, String> Enchantments = new HashMap<Integer, String>();

	public static HashMap<String, Integer> HowManyItemsInTotal = new HashMap<String, Integer>();

	public static HashMap<String, Integer> Max = new HashMap<String, Integer>();

	public static HashMap<String, Boolean> Hide = new HashMap<String, Boolean>();

	public static HashMap<String, Integer> MaxandMin = new HashMap<String, Integer>();

	public static HashMap<String, String> dpworld = new HashMap<String, String>();

	public static HashMap<String, Integer> BlockSignOn = new HashMap<String, Integer>();

	public static HashMap<String, Boolean> allreadyone = new HashMap<String, Boolean>();

	// ItemStack
	public static HashMap<Location, ItemStack> itemsinchest = new HashMap<Location, ItemStack>();

	public WorldGuardPlugin getWorldGuard() {
		Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");

		// WorldGuard may not be loaded
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null; // Maybe you want throw an exception instead
		}
		return (WorldGuardPlugin) plugin;

	}

	private void loadVault() {
		if (!setupEconomy()) {
			System.out.println("No economy found");
			return;
		}
		setupPermission();
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer()
				.getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private boolean setupPermission() {
		RegisteredServiceProvider<Permission> rsp = getServer()
				.getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	public FileConfiguration dropparty = null;
	public File droppartyFile = null;

	public FileConfiguration ecoparty = null;
	public File ecoFile = null;

	public void reloadEconomyConfig() {
		if (ecoFile == null) {
			ecoFile = new File(getDataFolder(), "Economy.yml");
		}
		ecoparty = YamlConfiguration.loadConfiguration(ecoFile);

		// Look for defaults in the jar
		InputStream defConfigStream22 = getResource("Economy.yml");
		if (defConfigStream22 != null) {
			YamlConfiguration defConfig2 = YamlConfiguration
					.loadConfiguration(defConfigStream22);
			ecoparty.setDefaults(defConfig2);
		}
	}

	public FileConfiguration getEconomyConfig() {
		if (ecoparty == null) {
			reloadEconomyConfig();
		}
		return ecoparty;
	}

	public void saveEconomyConfig() {
		if (ecoparty == null || ecoFile == null) {
			return;
		}
		try {
			ecoparty.save(ecoFile);
		} catch (IOException ex) {
			Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
					"Could not save config to " + ecoFile, ex);
		}
	}

	public void reloadDropPartyConfig() {
		if (droppartyFile == null) {
			droppartyFile = new File(getDataFolder(), "DropParty.yml");
		}
		dropparty = YamlConfiguration.loadConfiguration(droppartyFile);

		// Look for defaults in the jar
		InputStream defConfigStream2 = getResource("DropParty.yml");
		if (defConfigStream2 != null) {
			YamlConfiguration defConfig2 = YamlConfiguration
					.loadConfiguration(defConfigStream2);
			dropparty.setDefaults(defConfig2);
		}
	}

	public FileConfiguration getdroppartyConfig() {
		if (dropparty == null) {
			reloadDropPartyConfig();
		}
		return dropparty;
	}

	public void savedroppartyConfig() {
		if (dropparty == null || droppartyFile == null) {
			return;
		}
		try {
			dropparty.save(droppartyFile);
		} catch (IOException ex) {
			Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
					"Could not save config to " + droppartyFile, ex);
		}
	}

	public void reloadCustomConfig() {
		if (customConfigFile == null) {
			customConfigFile = new File(getDataFolder(), "CustomFireWorks.yml");
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);

		// Look for defaults in the jar
		InputStream defConfigStream = getResource("CustomFireWorks.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration
					.loadConfiguration(defConfigStream);
			customConfig.setDefaults(defConfig);
		}
	}

	public FileConfiguration getCustomConfig() {
		if (customConfig == null) {
			reloadCustomConfig();
		}
		return customConfig;
	}

	public void saveCustomConfig() {
		if (customConfig == null || customConfigFile == null) {
			return;
		}
		try {
			customConfig.save(customConfigFile);
		} catch (IOException ex) {
			Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE,
					"Could not save config to " + customConfigFile, ex);
		}
	}

	@Override
	public void onDisable() {
		System.out.println("[ColourFireWorks] ColourFireWorks v"
				+ getDescription().getVersion() + " disabled!");

		saveCustomConfig();
		savedroppartyConfig();
	}

	@Override
	public void onEnable() {

		loadVault();
		loadConfiguration();

		if (getConfig().getBoolean("Config.CheckforUpdate.Start") == true) {

			try {
				URLReader.main(this);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		new colourfireworksPlayerListener(this);
		new colourfireworksEntityListener(this);
		new colourfireworksBlockListener(this);

		if (getWorldGuard() != null) {
			System.out.println("[ColourFireWorks] WorldGuard Found!, Linked!");
		} else {
			System.out
					.println("[ColourFireWorks] WorldGuard Not Found!, Not Linked!");
		}

		Plugin x = this.getServer().getPluginManager().getPlugin("Vault");
		if (x != null & x instanceof Vault) {
			System.out.println("[ColourFireWorks] Vault Found!, Linked!");
			vaultcheck = true;
		} else {
			System.out
					.println("[ColourFireWorks] Vault Not Found!, Not Linked!");
			vaultcheck = false;
		}

		System.out.println("[ColourFireWorks] ColourFireWorks v"
				+ getDescription().getVersion() + " activated!");

	}

	public void loadConfiguration() {

		getCustomConfig();
		getdroppartyConfig();
		getEconomyConfig();

		String checkupdate = "Config.CheckforUpdate.Start";
		getConfig().addDefault(checkupdate, true);
		String checkupdatep = "Config.CheckforUpdate.Permission";
		getConfig().addDefault(checkupdatep, true);

		String ItemIdNeededInHand = "Fireworks.ItemIdNeededInHand";
		getConfig().addDefault(ItemIdNeededInHand, 288);

		String Damageblocks = "Fireworks.DamageBlocks";
		getConfig().addDefault(Damageblocks, true);

		String EntityDamage01 = "Fireworks.EntityDamage.Misc.Arrow";
		getConfig().addDefault(EntityDamage01, true);
		String EntityDamage02 = "Fireworks.EntityDamage.Misc.Boat";
		getConfig().addDefault(EntityDamage02, true);
		String EntityDamage03 = "Fireworks.EntityDamage.Misc.ExperienceOrb";
		getConfig().addDefault(EntityDamage03, false);
		String EntityDamage04 = "Fireworks.EntityDamage.Misc.Fireball";
		getConfig().addDefault(EntityDamage04, true);
		String EntityDamage05 = "Fireworks.EntityDamage.Misc.Item";
		getConfig().addDefault(EntityDamage05, false);
		String EntityDamage06 = "Fireworks.EntityDamage.Misc.Minecart";
		getConfig().addDefault(EntityDamage06, true);
		String EntityDamage061 = "Fireworks.EntityDamage.Misc.NPC";
		getConfig().addDefault(EntityDamage061, true);
		String EntityDamage07 = "Fireworks.EntityDamage.Misc.Painting";
		getConfig().addDefault(EntityDamage07, true);
		String EntityDamage071 = "Fireworks.EntityDamage.Misc.Player";
		getConfig().addDefault(EntityDamage071, true);
		String EntityDamage08 = "Fireworks.EntityDamage.Misc.Snowball";
		getConfig().addDefault(EntityDamage08, true);
		String EntityDamage09 = "Fireworks.EntityDamage.Misc.TNTPrimed";
		getConfig().addDefault(EntityDamage09, false);

		String EntityDamage10 = "Fireworks.EntityDamage.Animal.Chicken";
		getConfig().addDefault(EntityDamage10, false);
		String EntityDamage11 = "Fireworks.EntityDamage.Animal.Cow";
		getConfig().addDefault(EntityDamage11, false);
		String EntityDamage12 = "Fireworks.EntityDamage.Animal.IronGolem";
		getConfig().addDefault(EntityDamage12, false);
		String EntityDamage13 = "Fireworks.EntityDamage.Animal.Ocelot";
		getConfig().addDefault(EntityDamage13, false);
		String EntityDamage14 = "Fireworks.EntityDamage.Animal.Pig";
		getConfig().addDefault(EntityDamage14, false);
		String EntityDamage15 = "Fireworks.EntityDamage.Animal.Sheep";
		getConfig().addDefault(EntityDamage15, false);
		String EntityDamage16 = "Fireworks.EntityDamage.Animal.Snowman";
		getConfig().addDefault(EntityDamage16, false);
		String EntityDamage17 = "Fireworks.EntityDamage.Animal.Squid";
		getConfig().addDefault(EntityDamage17, false);
		String EntityDamage18 = "Fireworks.EntityDamage.Animal.Villager";
		getConfig().addDefault(EntityDamage18, false);
		String EntityDamage19 = "Fireworks.EntityDamage.Animal.Wolf";
		getConfig().addDefault(EntityDamage19, false);

		String EntityDamage20 = "Fireworks.EntityDamage.Hostile.Blaze";
		getConfig().addDefault(EntityDamage20, false);
		String EntityDamage21 = "Fireworks.EntityDamage.Hostile.CaveSpider";
		getConfig().addDefault(EntityDamage21, false);
		String EntityDamage22 = "Fireworks.EntityDamage.Hostile.Creeper";
		getConfig().addDefault(EntityDamage22, false);
		String EntityDamage23 = "Fireworks.EntityDamage.Hostile.EnderDragon";
		getConfig().addDefault(EntityDamage23, false);
		String EntityDamage24 = "Fireworks.EntityDamage.Hostile.Enderman";
		getConfig().addDefault(EntityDamage24, false);
		String EntityDamage25 = "Fireworks.EntityDamage.Hostile.Ghast";
		getConfig().addDefault(EntityDamage25, false);
		String EntityDamage26 = "Fireworks.EntityDamage.Hostile.Giant";
		getConfig().addDefault(EntityDamage26, false);
		String EntityDamage27 = "Fireworks.EntityDamage.Hostile.MagmaCube";
		getConfig().addDefault(EntityDamage27, false);
		String EntityDamage28 = "Fireworks.EntityDamage.Hostile.PigZombie";
		getConfig().addDefault(EntityDamage28, false);
		String EntityDamage29 = "Fireworks.EntityDamage.Hostile.Silverfish";
		getConfig().addDefault(EntityDamage29, false);
		String EntityDamage30 = "Fireworks.EntityDamage.Hostile.Skeleton";
		getConfig().addDefault(EntityDamage30, false);
		String EntityDamage31 = "Fireworks.EntityDamage.Hostile.Slime";
		getConfig().addDefault(EntityDamage31, false);
		String EntityDamage32 = "Fireworks.EntityDamage.Hostile.Spider";
		getConfig().addDefault(EntityDamage32, false);
		String EntityDamage33 = "Fireworks.EntityDamage.Hostile.Zombie";
		getConfig().addDefault(EntityDamage33, false);

		String DropsDye = "Fireworks.Dye.Drops";
		getConfig().addDefault(DropsDye, 24);

		String PotionDrops = "Fireworks.Dye.PotionEffects";
		getConfig().addDefault(PotionDrops, true);

		String removedye = "Fireworks.Dye.Remove.Allow";
		getConfig().addDefault(removedye, false);
		String removedye2 = "Fireworks.Dye.Remove.Ticks";
		getConfig().addDefault(removedye2, 30);
		String removedye3 = "Fireworks.Dye.Remove.PlayEffect";
		getConfig().addDefault(removedye3, false);
		String Dropsalight = "Fireworks.Dye.SetAlight";
		getConfig().addDefault(Dropsalight, false);
		String Dropspickup = "Fireworks.Dye.CanBePickedUp";
		getConfig().addDefault(Dropspickup, true);
		String DyeItemSpread = "Fireworks.Dye.ItemSpread";
		getConfig().addDefault(DyeItemSpread, 4);
		String fireworkheight = "Fireworks.Dye.Height";
		getConfig().addDefault(fireworkheight, 2);

		String DropsPumpkin = "Fireworks.Pumpkin.Drops";
		getConfig().addDefault(DropsPumpkin, 32);
		String SpreadPumpkin = "Fireworks.Pumpkin.ItemSpread";
		getConfig().addDefault(SpreadPumpkin, 4);
		String DropsSpiders = "Fireworks.Pumpkin.Spiders";
		getConfig().addDefault(DropsSpiders, 4);
		String PumpkinHeight = "Fireworks.Pumpkin.Height";
		getConfig().addDefault(PumpkinHeight, 2);
		String PotionDrops1 = "Fireworks.Pumpkin.PotionEffects";
		getConfig().addDefault(PotionDrops1, true);

		String exp1 = "Fireworks.Exp.Amount";
		getConfig().addDefault(exp1, 64);
		String exp2 = "Fireworks.Exp.Remove.Allow";
		getConfig().addDefault(exp2, false);
		String exp3 = "Fireworks.Exp.Remove.PlayEffect";
		getConfig().addDefault(exp3, false);
		String exp4 = "Fireworks.Exp.Remove.Ticks";
		getConfig().addDefault(exp4, 30);
		String exp5 = "Fireworks.Exp.Height";
		getConfig().addDefault(exp5, 3);
		String exp6 = "Fireworks.Exp.Worth";
		getConfig().addDefault(exp6, 0);
		String exp7 = "Fireworks.Exp.Spread";
		getConfig().addDefault(exp7, 4);
		String PotionDrops2 = "Fireworks.Exp.PotionEffects";
		getConfig().addDefault(PotionDrops2, true);

		//
		// ECONOMY //

		// -1 = Dissabled

		String economy0 = "Economy.ItemNeededInHand.ID";
		getEconomyConfig().addDefault(economy0, 339);

		String economy1 = "Economy.Wool.Cost";
		getEconomyConfig().addDefault(economy1, -1);
		String economywool1 = "Economy.Wool.Height";
		getEconomyConfig().addDefault(economywool1, 1.5);
		String economywool2 = "Economy.Wool.Drops";
		getEconomyConfig().addDefault(economywool2, 16);
		String economywool3 = "Economy.Wool.ItemSpread";
		getEconomyConfig().addDefault(economywool3, 4);
		String economywool7 = "Economy.Wool.SetAlight";
		getEconomyConfig().addDefault(economywool7, false);
		String economywool8 = "Economy.Wool.CanBePickedUp";
		getEconomyConfig().addDefault(economywool8, true);
		String economywool4 = "Economy.Wool.Remove.Allow";
		getEconomyConfig().addDefault(economywool4, false);
		String economywool5 = "Economy.Wool.Remove.PlayEffect";
		getEconomyConfig().addDefault(economywool5, false);
		String economywool6 = "Economy.Wool.Remove.Ticks";
		getEconomyConfig().addDefault(economywool6, 30);

		String economy2 = "Economy.Pumpkin.Cost";
		getEconomyConfig().addDefault(economy2, -1);
		String economypumpkin1 = "Economy.Pumpkin.Height";
		getEconomyConfig().addDefault(economypumpkin1, 1.5);
		String economypumpkin2 = "Economy.Pumpkin.Drops";
		getEconomyConfig().addDefault(economypumpkin2, 32);
		String economypumpkin3 = "Economy.Pumpkin.ItemSpread";
		getEconomyConfig().addDefault(economypumpkin3, 4);
		String economypumpkin4 = "Economy.Pumpkin.Spiders";
		getEconomyConfig().addDefault(economypumpkin4, 4);

		String economy3 = "Economy.SnowBlock.Cost";
		getEconomyConfig().addDefault(economy3, -1);
		String economysnowblock1 = "Economy.SnowBlock.Height";
		getEconomyConfig().addDefault(economysnowblock1, 1.5);
		String economysnowblock2 = "Economy.SnowBlock.Drops.SnowBall";
		getEconomyConfig().addDefault(economysnowblock2, 16);
		String economysnowblock3 = "Economy.SnowBlock.Drops.Gold";
		getEconomyConfig().addDefault(economysnowblock3, 8);
		String economysnowblock4 = "Economy.SnowBlock.Drops.Diamond";
		getEconomyConfig().addDefault(economysnowblock4, 4);
		String economysnowblock5 = "Economy.SnowBlock.Drops.ItemSpread";
		getEconomyConfig().addDefault(economysnowblock5, 4);
		String economysnowblock6 = "Economy.SnowBlock.Spawn.SnowGolem";
		getEconomyConfig().addDefault(economysnowblock6, 4);

		String economy4 = "Economy.Exp.Cost";
		getEconomyConfig().addDefault(economy4, -1);
		String economyexp1 = "Economy.Exp.Height";
		getEconomyConfig().addDefault(economyexp1, 1.5);
		String economyexp2 = "Economy.Exp.Amount";
		getEconomyConfig().addDefault(economyexp2, 64);
		String economyexp3 = "Economy.Exp.Remove.Allow";
		getEconomyConfig().addDefault(economyexp3, false);
		String economyexp4 = "Economy.Exp.Remove.PlayEffect";
		getEconomyConfig().addDefault(economyexp4, false);
		String economyexp5 = "Economy.Exp.Remove.Ticks";
		getEconomyConfig().addDefault(economyexp5, 30);
		String economyexp6 = "Economy.Exp.Worth";
		getEconomyConfig().addDefault(economyexp6, 0);
		String economyexp7 = "Economy.Exp.Spread";
		getEconomyConfig().addDefault(economyexp7, 4);

		// ECONOMY //
		//

		String snowDropsDye = "Fireworks.Snow.Drops.Snowball";
		getConfig().addDefault(snowDropsDye, 24);
		String snowDropsdiamond = "Fireworks.Snow.Drops.Diamond";
		getConfig().addDefault(snowDropsdiamond, 6);
		String snowDropsgold = "Fireworks.Snow.Drops.Gold";
		getConfig().addDefault(snowDropsgold, 12);
		String snowmen = "Fireworks.Snow.SnowMen";
		getConfig().addDefault(snowmen, 4);
		String itemspread = "Fireworks.Snow.ItemSpread";
		getConfig().addDefault(itemspread, 4);
		String SnowHeight = "Fireworks.Snow.Height";
		getConfig().addDefault(SnowHeight, 2);
		String PotionDrops3 = "Fireworks.Snow.PotionEffects";
		getConfig().addDefault(PotionDrops3, true);

		String customdmg = "Custom.Config.DamageBlocks";
		getCustomConfig().addDefault(customdmg, true);

		String custommsg01 = "Fireworks.Message.SendOnLaunch";
		getConfig().addDefault(custommsg01, true);

		if (getdroppartyConfig().contains("DropParty.Message.Radius") == false) {
			String dropparty = "DropParty.Message.Radius";
			getdroppartyConfig().addDefault(dropparty, 50);
		}
		String spreaddp = "DropParty.ItemSpread.Spread";
		getdroppartyConfig().addDefault(spreaddp, 6);
		String heightdp = "DropParty.ItemSpread.SecondsReleasedOver";
		getdroppartyConfig().addDefault(heightdp, 4);

		if (getdroppartyConfig().contains("DropParty.Time.StartingTime") == false) {
			String droppartyst = "DropParty.Time.StartingTime";
			getdroppartyConfig().addDefault(droppartyst, 60);
		}
		if (getdroppartyConfig().contains("DropParty.Time.MaxTime") == false) {
			String droppartymax = "DropParty.Time.MaxTime";
			getdroppartyConfig().addDefault(droppartymax, 300);
		}
		if (getdroppartyConfig().contains("DropParty.BlockItemsId") == false) {
			String[] dplist = { "7", "8", "9", "10", "11", "26", "36", "55",
					"74", "75", "83", "115", "117", "118", "119", "120" };
			getdroppartyConfig().addDefault("DropParty.BlockItemsId",
					Arrays.asList(dplist));
		}

		if (getdroppartyConfig().contains("DropParty.Max") == false) {
			String maxin = "DropParty.Max";
			getdroppartyConfig().addDefault(maxin, 512);
		}

		if (getdroppartyConfig().contains("DropParty.Items") == false) {
			String diamondtime = "DropParty.Items.DIAMOND.AddedTime";
			getdroppartyConfig().addDefault(diamondtime, 5);
			String diamond1time = "DropParty.Items.DIAMOND_AXE.AddedTime";
			getdroppartyConfig().addDefault(diamond1time, 8);
			String diamond2time = "DropParty.Items.DIAMOND_HOE.AddedTime";
			getdroppartyConfig().addDefault(diamond2time, 3);
			String diamond3time = "DropParty.Items.DIAMOND_PICKAXE.AddedTime";
			getdroppartyConfig().addDefault(diamond3time, 10);
			String diamond4time = "DropParty.Items.DIAMOND_SPADE.AddedTime";
			getdroppartyConfig().addDefault(diamond4time, 5);
			String diamond5time = "DropParty.Items.DIAMOND_SWORD.AddedTime";
			getdroppartyConfig().addDefault(diamond5time, 10);

			String goldtime = "DropParty.Items.GOLD_INGOT.AddedTime";
			getdroppartyConfig().addDefault(goldtime, 3);
			String gold1time = "DropParty.Items.GOLD_AXE.AddedTime";
			getdroppartyConfig().addDefault(gold1time, 4);
			String gold2time = "DropParty.Items.GOLD_HOE.AddedTime";
			getdroppartyConfig().addDefault(gold2time, 1);
			String gold3time = "DropParty.Items.GOLD_PICKAXE.AddedTime";
			getdroppartyConfig().addDefault(gold3time, 5);
			String gold4time = "DropParty.Items.GOLD_SPADE.AddedTime";
			getdroppartyConfig().addDefault(gold4time, 2);
			String gold5time = "DropParty.Items.GOLD_SWORD.AddedTime";
			getdroppartyConfig().addDefault(gold5time, 5);

			String irontime = "DropParty.Items.IRON_INGOT.AddedTime";
			getdroppartyConfig().addDefault(irontime, 4);
			String iron1time = "DropParty.Items.IRON_AXE.AddedTime";
			getdroppartyConfig().addDefault(iron1time, 6);
			String iron2time = "DropParty.Items.IRON_HOE.AddedTime";
			getdroppartyConfig().addDefault(iron2time, 2);
			String iron3time = "DropParty.Items.IRON_PICKAXE.AddedTime";
			getdroppartyConfig().addDefault(iron3time, 7);
			String iron4time = "DropParty.Items.IRON_SPADE.AddedTime";
			getdroppartyConfig().addDefault(iron4time, 3);
			String iron5time = "DropParty.Items.IRON_SWORD.AddedTime";
			getdroppartyConfig().addDefault(iron5time, 7);
		}

		String help = "Help";
		getdroppartyConfig().addDefault(help,
				"http://craftiii4.co.uk/mw/index.php?title=DropParty_File");

		colourfireworks.Max.put("Max",
				getdroppartyConfig().getInt("DropParty.Max"));

		int tickcheck;
		tickcheck = getConfig().getInt("Fireworks.Dye.Remove.Ticks");

		if (tickcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Remove Ticks Below 0, set to default");
			getConfig().set("Fireworks.Dye.Remove.Ticks", 30);

		}

		if (tickcheck > 600) {
			System.out
					.println("[ColourFireWorks] Error, Remove Ticks Above 600 (30 sec), set to default");
			getConfig().set("Fireworks.Dye.Remove.Ticks", 30);

		}

		int iteminhandcheck;
		iteminhandcheck = getConfig().getInt("Fireworks.ItemIdNeededInHand");

		if (iteminhandcheck > 388) {
			if (iteminhandcheck < 2256) {
				System.out
						.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
				getConfig().set("Fireworks.ItemIdNeededInHand", 288);
			}

		}

		if (iteminhandcheck > 133) {
			if (iteminhandcheck < 256) {
				System.out
						.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
				getConfig().set("Fireworks.ItemIdNeededInHand", 288);
			}

		}

		if (iteminhandcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}

		if (iteminhandcheck > 2266) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}

		if (iteminhandcheck == 62) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 74) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 93 || iteminhandcheck == 94) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 117) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 118) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 119) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 120) {
			System.out
					.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}

		int fireworkdyeammountcheck;
		fireworkdyeammountcheck = getConfig().getInt("Fireworks.Dye.Drops");

		if (fireworkdyeammountcheck > 128) {
			System.out
					.println("[ColourFireWorks] Error, Dye Drops above 128, set to default");
			getConfig().set("Fireworks.Dye.Drops", 24);
		}
		if (fireworkdyeammountcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Dye Drops below 0, set to default");
			getConfig().set("Fireworks.Dye.Drops", 24);
		}

		int pumpkinammountcheck;
		pumpkinammountcheck = getConfig().getInt("Fireworks.Pumpkin.Drops");

		if (pumpkinammountcheck > 256) {
			System.out
					.println("[ColourFireWorks] Error, Pumpkin Drops above 256, set to default");
			getConfig().set("Fireworks.Pumpkin.Drops", 32);
		}
		if (pumpkinammountcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Pumpkin Drops below 0, set to default");
			getConfig().set("Fireworks.Pumpkin.Drops", 32);
		}

		int spiderammountcheck;
		spiderammountcheck = getConfig().getInt("Fireworks.Pumpkin.Spiders");

		if (spiderammountcheck > 32) {
			System.out
					.println("[ColourFireWorks] Error, Spiders to spawn above 32, set to default");
			getConfig().set("Fireworks.Pumpkin.Spiders", 4);
		}
		if (spiderammountcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Spiders to spawn below 0, set to default");
			getConfig().set("Fireworks.Pumpkin.Spiders", 4);
		}

		int pumpkinfireworkheightcheck;
		pumpkinfireworkheightcheck = getConfig().getInt(
				"Fireworks.Pumpkin.Height");

		if (pumpkinfireworkheightcheck > 16) {
			System.out
					.println("[ColourFireWorks] Error, Pumpkin Firework Height above 16, set to default");
			getConfig().set("Fireworks.Pumpkin.Height", 1.5);
		}
		if (pumpkinfireworkheightcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Pumpkin Fireworks Height below 0, set to default");
			getConfig().set("Fireworks.Pumpkin.Height", 1.5);
		}

		int snowfireworkheightcheck;
		snowfireworkheightcheck = getConfig().getInt("Fireworks.Snow.Height");

		if (snowfireworkheightcheck > 16) {
			System.out
					.println("[ColourFireWorks] Error, Snow Firework Height above 16, set to default");
			getConfig().set("Fireworks.Snow.Height", 1.5);
		}
		if (snowfireworkheightcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Snow Fireworks Height below 0, set to default");
			getConfig().set("Fireworks.Snow.Height", 1.5);
		}

		int woolfireworkheightcheck;
		woolfireworkheightcheck = getConfig().getInt("Fireworks.Wool.Height");

		if (woolfireworkheightcheck > 16) {
			System.out
					.println("[ColourFireWorks] Error, Wool Firework Height above 16, set to default");
			getConfig().set("Fireworks.Snow.Height", 1.5);
		}
		if (woolfireworkheightcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Wool Fireworks Height below 0, set to default");
			getConfig().set("Fireworks.Snow.Height", 1.5);
		}

		int snowammountcheck;
		snowammountcheck = getConfig().getInt("Fireworks.Snow.Drops.Snowball");

		if (snowammountcheck > 256) {
			System.out
					.println("[ColourFireWorks] Error, Snow Ball Drops above 256, set to default");
			getConfig().set("Fireworks.Snow.Drops.Snowball", 24);
		}
		if (snowammountcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Snow Ball Drops below 0, set to default");
			getConfig().set("Fireworks.Snow.Drops.Snowball", 24);
		}

		int diamondammountcheck;
		diamondammountcheck = getConfig()
				.getInt("Fireworks.Snow.Drops.Diamond");

		if (diamondammountcheck > 256) {
			System.out
					.println("[ColourFireWorks] Error, Diamond Drops above 256, set to default");
			getConfig().set("Fireworks.Snow.Drops.Diamond", 6);
		}
		if (diamondammountcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Diamond Drops below 0, set to default");
			getConfig().set("Fireworks.Snow.Drops.Diamond", 6);
		}

		int goldammountcheck;
		goldammountcheck = getConfig().getInt("Fireworks.Snow.Drops.Gold");

		if (goldammountcheck > 256) {
			System.out
					.println("[ColourFireWorks] Error, Gold Drops above 256, set to default");
			getConfig().set("Fireworks.Snow.Drops.Gold", 12);
		}
		if (goldammountcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Gold Drops below 0, set to default");
			getConfig().set("Fireworks.Snow.Drops.Gold", 12);
		}

		int snowmenammountcheck;
		snowmenammountcheck = getConfig().getInt("Fireworks.Snow.SnowMen");

		if (snowmenammountcheck > 32) {
			System.out
					.println("[ColourFireWorks] Error, SnowMen above 32, set to default");
			getConfig().set("Fireworks.Snow.SnowMen", 4);
		}
		if (snowmenammountcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, SnowMen below 0, set to default");
			getConfig().set("Fireworks.Snow.SnowMen", 4);
		}

		int snowitemspreadcheck;
		snowitemspreadcheck = getConfig().getInt("Fireworks.Snow.ItemSpread");

		if (snowitemspreadcheck > 16) {
			System.out
					.println("[ColourFireWorks] Error, SnowBlock Item Spread above 16, set to default");
			getConfig().set("Fireworks.Snow.ItemSpread", 4);
		}
		if (snowitemspreadcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, SnowBlock Item Spread below 0, set to default");
			getConfig().set("Fireworks.Snow.ItemSpread", 4);
		}

		int dyeitemspreadcheck;
		dyeitemspreadcheck = getConfig().getInt("Fireworks.Dye.ItemSpread");

		if (dyeitemspreadcheck > 16) {
			System.out
					.println("[ColourFireWorks] Error, Dye Item Spread above 16, set to default");
			getConfig().set("Fireworks.Dye.ItemSpread", 4);
		}
		if (dyeitemspreadcheck < 0) {
			System.out
					.println("[ColourFireWorks] Error, Dye Item Spread below 0, set to default");
			getConfig().set("Fireworks.Dye.ItemSpread", 4);
		}

		int pumpkinitemspreadcheck1;
		pumpkinitemspreadcheck1 = getConfig().getInt(
				"Fireworks.Pumpkin.ItemSpread");

		if (pumpkinitemspreadcheck1 > 16) {
			System.out
					.println("[ColourFireWorks] Error, Pumpkin Item Spread above 16, set to default");
			getConfig().set("Fireworks.Pumpkin.ItemSpread", 4);
		}
		if (pumpkinitemspreadcheck1 < 0) {
			System.out
					.println("[ColourFireWorks] Error, Pumpkin Item Spread below 0, set to default");
			getConfig().set("Fireworks.Pumpkin.ItemSpread", 4);
		}

		int cf;
		cf = 1;

		int ticks;
		ticks = 201;

		System.out.println("[ColourFireWorks] Loading Custom Fireworks");

		if (customConfig.contains("Custom.Firework" + cf + ".use") == false) {
			String customfireworks = "Custom.Firework" + cf + ".use";
			customConfig.addDefault(customfireworks, false);
			String customfireworksticks = "Custom.Firework" + cf + ".fireticks";
			customConfig.addDefault(customfireworksticks, 201);
			String customfireworkprice = "Custom.Firework" + cf + ".Price";
			customConfig.addDefault(customfireworkprice, -1);

			String customfireworks14 = "Custom.Firework" + cf + ".Height";
			customConfig.addDefault(customfireworks14, 1.5);

			String customfireworksmessage = "Custom.Firework" + cf
					+ ".LaunchMessage";
			customConfig.addDefault(customfireworksmessage,
					"The Firework Goes off!");

			String customfireworks2 = "Custom.Firework" + cf
					+ ".FireworkBlockID";
			customConfig.addDefault(customfireworks2, -1);
			String customfireworks11 = "Custom.Firework" + cf
					+ ".FireworkBlockID-Raw-Data";
			customConfig.addDefault(customfireworks11, -1);

			String customfireworks5 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.use";
			customConfig.addDefault(customfireworks5, false);
			String customfireworks3 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemID";
			customConfig.addDefault(customfireworks3, 1);
			String customfireworks15 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemSubID";
			customConfig.addDefault(customfireworks15, -1);
			String customfireworks4 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Amount";
			customConfig.addDefault(customfireworks4, 16);
			String customfireworks6 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.CanBePickedUp";
			customConfig.addDefault(customfireworks6, true);
			String customfireworks7 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.SetAlight";
			customConfig.addDefault(customfireworks7, false);
			String customfireworks16 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Enchantment1.Type";
			customConfig.addDefault(customfireworks16, "NONE");
			String customfireworks17 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Enchantment1.Level";
			customConfig.addDefault(customfireworks17, 1);
			String customfireworks18 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemSpread";
			customConfig.addDefault(customfireworks18, 4);

			String customfireworks8 = "Custom.Firework" + cf + ".Mob1.use";
			customConfig.addDefault(customfireworks8, false);
			String customfireworks9 = "Custom.Firework" + cf + ".Mob1.Mobname";
			customConfig.addDefault(customfireworks9, "PIG");
			String customfireworks10 = "Custom.Firework" + cf + ".Mob1.Amount";
			customConfig.addDefault(customfireworks10, 1);
			String customfireworks12 = "Custom.Firework" + cf
					+ ".ExpOrp.Amount";
			customConfig.addDefault(customfireworks12, 0);
			String customfireworks13 = "Custom.Firework" + cf + ".ExpOrp.Value";
			customConfig.addDefault(customfireworks13, 0);

		}

		int addnew12 = 1;

		while (customConfig.contains("Custom.Firework" + addnew12 + ".use") == true) {

			if (customConfig.contains("Custom.Firework" + addnew12 + ".Height") == false) {
				String customfireworksnew01 = "Custom.Firework" + addnew12
						+ ".Height";
				customConfig.addDefault(customfireworksnew01, 1.5);

			}
			if (customConfig.contains("Custom.Firework" + addnew12 + ".Price") == false) {
				String customfireworksnew01 = "Custom.Firework" + addnew12
						+ ".Price";
				customConfig.addDefault(customfireworksnew01, -1);

			}

			addnew12++;

		}

		int addnew1 = 1;

		while (customConfig.contains("Custom.Firework" + addnew1 + ".use") == true) {

			if (customConfig.contains("Custom.Firework" + addnew1
					+ ".FireworkBlockID-Raw-Data") == false) {
				String customfireworksnew01 = "Custom.Firework" + addnew1
						+ ".FireworkBlockID-Raw-Data";
				customConfig.addDefault(customfireworksnew01, -1);

			}
			if (customConfig.contains("Custom.Firework" + addnew1
					+ ".LaunchMessage") == false) {
				String customfireworksnew02 = "Custom.Firework" + addnew1
						+ ".LaunchMessage";
				customConfig.addDefault(customfireworksnew02,
						"The Firework Goes off!");

			}
			if (customConfig.contains("Custom.Firework" + addnew1
					+ ".ItemsDroped.ID1.ItemSubID") == false) {
				String customfireworksnew01 = "Custom.Firework" + addnew1
						+ ".ItemsDroped.ID1.ItemSubID";
				customConfig.addDefault(customfireworksnew01, -1);

			}

			addnew1++;

		}

		int addnew2 = 1;

		while (customConfig.contains("Custom.Firework" + addnew2 + ".use") == true) {

			if (customConfig.contains("Custom.Firework" + addnew2
					+ ".ExpOrp.Amount") == false) {

				String customfireworks12 = "Custom.Firework" + addnew2
						+ ".ExpOrp.Amount";
				customConfig.addDefault(customfireworks12, 0);
				String customfireworks13 = "Custom.Firework" + addnew2
						+ ".ExpOrp.Value";
				customConfig.addDefault(customfireworks13, 0);

			}

			addnew2++;

		}

		while (customConfig.getBoolean("Custom.Firework" + cf + ".use") == true) {

			cf = cf + 1;
			ticks = ticks + 1;

			String customfireworks = "Custom.Firework" + cf + ".use";
			customConfig.addDefault(customfireworks, false);

			String customfireworksticks = "Custom.Firework" + cf + ".fireticks";
			customConfig.addDefault(customfireworksticks, ticks);

			String customfireworkprice = "Custom.Firework" + cf + ".Price";
			customConfig.addDefault(customfireworkprice, -1);

			String customfireworksmessage = "Custom.Firework" + cf
					+ ".LaunchMessage";
			customConfig.addDefault(customfireworksmessage,
					"The Firework Goes off!");

			String customfireworks2 = "Custom.Firework" + cf
					+ ".FireworkBlockID";
			customConfig.addDefault(customfireworks2, -1);
			String customfireworks11 = "Custom.Firework" + cf
					+ ".FireworkBlockID-Raw-Data";
			customConfig.addDefault(customfireworks11, -1);

			String customfireworks5 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.use";
			customConfig.addDefault(customfireworks5, false);
			String customfireworks3 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemID";
			String customfireworks15 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemSubID";
			customConfig.addDefault(customfireworks15, -1);
			customConfig.addDefault(customfireworks3, 1);
			String customfireworks4 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Amount";
			customConfig.addDefault(customfireworks4, 16);
			String customfireworks6 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.CanBePickedUp";
			customConfig.addDefault(customfireworks6, true);
			String customfireworks7 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.SetAlight";
			customConfig.addDefault(customfireworks7, false);
			String customfireworks16 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Enchantment1.Type";
			customConfig.addDefault(customfireworks16, "NONE");
			String customfireworks17 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Enchantment1.Level";
			customConfig.addDefault(customfireworks17, 1);
			String customfireworks18 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemSpread";
			customConfig.addDefault(customfireworks18, 4);

			String customfireworks8 = "Custom.Firework" + cf + ".Mob1.use";
			customConfig.addDefault(customfireworks8, false);
			String customfireworks9 = "Custom.Firework" + cf + ".Mob1.Mobname";
			customConfig.addDefault(customfireworks9, "PIG");
			String customfireworks10 = "Custom.Firework" + cf + ".Mob1.Amount";
			customConfig.addDefault(customfireworks10, 1);
			String customfireworks12 = "Custom.Firework" + cf
					+ ".ExpOrp.Amount";
			customConfig.addDefault(customfireworks12, 0);
			String customfireworks13 = "Custom.Firework" + cf + ".ExpOrp.Value";
			customConfig.addDefault(customfireworks13, 0);

			String customfireworks14 = "Custom.Firework" + cf + ".Height";
			customConfig.addDefault(customfireworks14, 1.5);

		}

		int firework;
		firework = 1;

		while (customConfig.contains("Custom.Firework" + firework + ".use") == true) {

			int blockid = getConfig().getInt(
					"Custom.Firework" + firework + ".FireworkBlockID");

			int fireworkheight23 = getConfig().getInt(
					"Custom.Firework" + firework + ".Height");

			if (fireworkheight23 > 16) {
				System.out
						.println("[ColourFireWorks] Error, Firework Height above 16, set to default");
				customConfig.set("Custom.Firework" + firework + ".Height", 1.5);
				System.out
						.println("[ColourFireWorks] Error occured in customfirework "
								+ firework);
			}
			if (fireworkheight23 < 0) {
				System.out
						.println("[ColourFireWorks] Error, Firework Height below 0, set to default");
				customConfig.set("Custom.Firework" + firework + ".Height", 1.5);
				System.out
						.println("[ColourFireWorks] Error occured in customfirework "
								+ firework);
			}

			if (blockid == 35) {
				System.out
						.println("[ColourFireWorks] Wool Blocks not allowed! Changing to -1");
				customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out
						.println("[ColourFireWorks] Error occured in customfirework "
								+ firework);
			}

			if (blockid == 80) {
				System.out
						.println("[ColourFireWorks] Snow Blocks not allowed! Changing to -1");
				customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out
						.println("[ColourFireWorks] Error occured in customfirework "
								+ firework);
			}

			if (blockid == 86) {
				System.out
						.println("[ColourFireWorks] Pumpkin Blocks not allowed! Changing to -1");
				customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out
						.println("[ColourFireWorks] Error occured in customfirework "
								+ firework);
			}

			firework = firework + 1;

		}

		int cf2;
		cf2 = 1;
		int idnumber;
		idnumber = 1;

		while (customConfig.contains("Custom.Firework" + cf2 + ".use") == true) {

			idnumber = 1;

			while (customConfig.getBoolean("Custom.Firework" + cf2
					+ ".ItemsDroped.ID" + idnumber + ".use") == true) {
				idnumber = idnumber + 1;
				String customfireworks5 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".use";
				customConfig.addDefault(customfireworks5, false);
				String customfireworks3 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".ItemID";
				customConfig.addDefault(customfireworks3, 1);
				String customfireworks15 = "Custom.Firework" + cf
						+ ".ItemsDroped.ID" + idnumber + ".ItemSubID";
				customConfig.addDefault(customfireworks15, -1);
				String customfireworks4 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".Amount";
				customConfig.addDefault(customfireworks4, 16);
				String customfireworks6 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".CanBePickedUp";
				customConfig.addDefault(customfireworks6, true);
				String customfireworks7 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".SetAlight";
				customConfig.addDefault(customfireworks7, false);
				String customfireworks16 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".Enchantment1.Type";
				customConfig.addDefault(customfireworks16, "NONE");
				String customfireworks17 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".Enchantment1.Level";
				customConfig.addDefault(customfireworks17, 1);
				String customfireworks18 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".ItemSpread";
				customConfig.addDefault(customfireworks18, 4);

			}

			idnumber = 1;
			cf2 = cf2 + 1;

		}

		int cfmob;
		cfmob = 1;
		int idnumbermob;
		idnumbermob = 1;

		while (customConfig.contains("Custom.Firework" + cfmob + ".use") == true) {

			idnumbermob = 1;

			while (customConfig.getBoolean("Custom.Firework" + cfmob + ".Mob"
					+ idnumbermob + ".use") == true) {
				idnumbermob = idnumbermob + 1;

				String customfireworks8 = "Custom.Firework" + cfmob + ".Mob"
						+ idnumbermob + ".use";
				customConfig.addDefault(customfireworks8, false);
				String customfireworks9 = "Custom.Firework" + cfmob + ".Mob"
						+ idnumbermob + ".Mobname";
				customConfig.addDefault(customfireworks9, "PIG");
				String customfireworks10 = "Custom.Firework" + cfmob + ".Mob"
						+ idnumbermob + ".Amount";
				customConfig.addDefault(customfireworks10, 1);

			}

			idnumbermob = 1;
			cfmob = cfmob + 1;

		}

		System.out.println("[ColourFireWorks] Checking Mob Names");

		int cf3mob;
		cf3mob = 1;
		int idnumber2mob;
		idnumber2mob = 1;
		int correct54mob;
		correct54mob = 1;

		while (customConfig.contains("Custom.Firework" + cf3mob + ".use") == true) {

			while (customConfig.getBoolean("Custom.Firework" + cf3mob + ".Mob"
					+ idnumber2mob + ".use") == true) {

				String mobid;
				mobid = customConfig.getString(
						"Custom.Firework" + cf3mob + ".Mob" + idnumber2mob
								+ ".Mobname").toUpperCase();

				correct54mob = 1;

				if (mobid.equals("BLAZE")) {
					correct54mob = 0;
				}
				if (mobid.equals("CAVE_SPIDER")) {
					correct54mob = 0;
				}
				if (mobid.equals("CAVESPIDER")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "CAVE_SPIDER");
					System.out
							.println("[ColourFireWorks] Renamed CAVESPIDER to CAVE_SPIDER");
				}
				if (mobid.equals("CHICKEN")) {
					correct54mob = 0;
				}
				if (mobid.equals("COW")) {
					correct54mob = 0;
				}
				if (mobid.equals("CREEPER")) {
					correct54mob = 0;
				}
				if (mobid.equals("ENDER_DRAGON")) {
					correct54mob = 0;
					System.out
							.println("[ColourFireWorks] Warning, an ENDER_DRAGON is in use");
				}
				if (mobid.equals("ENDERDRAGON")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "ENDER_DRAGON");
					System.out
							.println("[ColourFireWorks] Renamed ENDERDRAGON to ENDER_DRAGON");
					System.out
							.println("[ColourFireWorks] Warning, an ENDER_DRAGON is in use");
				}
				if (mobid.equals("ENDERMAN")) {
					correct54mob = 0;
				}
				if (mobid.equals("ENDERMEN")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "ENDERMAN");
					System.out
							.println("[ColourFireWorks] Renamed ENDERMEN to ENDERMAN");
				}
				if (mobid.equals("GHAST")) {
					correct54mob = 0;
				}
				if (mobid.equals("GIANT")) {
					correct54mob = 0;
				}
				if (mobid.equals("MAGMA_CUBE")) {
					correct54mob = 0;
				}
				if (mobid.equals("MAGMACUBE")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "MAGMA_CUBE");
					System.out
							.println("[ColourFireWorks] Renamed MAGMACUBE to MAGMA_CUBE");
				}
				if (mobid.equals("MUSHROOM_COW")) {
					correct54mob = 0;
				}
				if (mobid.equals("MUSHROOMCOW")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "MUSHROOM_COW");
					System.out
							.println("[ColourFireWorks] Renamed MUSHROOMCOW to MUSHROOM_COW");
				}
				if (mobid.equals("MOOSHROOM")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "MUSHROOM_COW");
					System.out
							.println("[ColourFireWorks] Renamed MOOSHROOM to MUSHROOM_COW");
				}
				if (mobid.equals("PIG")) {
					correct54mob = 0;
				}
				if (mobid.equals("PIG_ZOMBIE")) {
					correct54mob = 0;
				}
				if (mobid.equals("PIGZOMBIE")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "PIG_ZOMBIE");
					System.out
							.println("[ColourFireWorks] Renamed PIGZOMBIE to PIG_ZOMBIE");
				}
				if (mobid.equals("PIGMAN")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "PIG_ZOMBIE");
					System.out
							.println("[ColourFireWorks] Renamed PIGMAN to PIG_ZOMBIE");
				}
				if (mobid.equals("PIG_MAN")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "PIG_ZOMBIE");
					System.out
							.println("[ColourFireWorks] Renamed PIG_MAN to PIG_ZOMBIE");
				}
				if (mobid.equals("SHEEP")) {
					correct54mob = 0;
				}
				if (mobid.equals("SILVERFISH")) {
					correct54mob = 0;
				}
				if (mobid.equals("SILVER_FISH")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "SILVERFISH");
					System.out
							.println("[ColourFireWorks] Renamed SILVER_FISH to SILVERFISH");
				}
				if (mobid.equals("SILVER")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "SILVERFISH");
					System.out
							.println("[ColourFireWorks] Renamed SILVER to SILVERFISH");
				}
				if (mobid.equals("SKELETON")) {
					correct54mob = 0;
				}
				if (mobid.equals("SLIME")) {
					correct54mob = 0;
				}
				if (mobid.equals("SNOWMAN")) {
					correct54mob = 0;
				}
				if (mobid.equals("SNOW_MAN")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "SNOWMAN");
					System.out
							.println("[ColourFireWorks] Renamed SNOW_MAN to SNOWMAN");
				}
				if (mobid.equals("SNOWGOLEM")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "SNOWMAN");
					System.out
							.println("[ColourFireWorks] Renamed SNOWGOLEM to SNOWMAN");
				}
				if (mobid.equals("SNOW_GOLEM")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "SNOWMAN");
					System.out
							.println("[ColourFireWorks] Renamed SNOW_GOLEM to SNOWMAN");
				}
				if (mobid.equals("SPIDER")) {
					correct54mob = 0;
				}
				if (mobid.equals("SQUID")) {
					correct54mob = 0;
				}
				if (mobid.equals("VILLAGER")) {
					correct54mob = 0;
				}
				if (mobid.equals("NPC")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "VILLAGER");
					System.out
							.println("[ColourFireWorks] Renamed NPC to VILLAGER");
				}
				if (mobid.equals("HUMAN")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "VILLAGER");
					System.out
							.println("[ColourFireWorks] Renamed HUMAN to VILLAGER");
				}
				if (mobid.equals("WOLF")) {
					correct54mob = 0;
				}
				if (mobid.equals("ZOMBIE")) {
					correct54mob = 0;
				}

				if (mobid.equals("OCELOT")) {
					correct54mob = 0;
				}

				if (mobid.equals("CAT")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "OCELOT");
					System.out
							.println("[ColourFireWorks] Renamed CAT to OCELOT");
				}

				if (mobid.equals("KITTEN")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "OCELOT");
					System.out
							.println("[ColourFireWorks] Renamed KITTEN to OCELOT");
				}
				if (mobid.equals("CHEETA")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "OCELOT");
					System.out
							.println("[ColourFireWorks] Renamed CHEETA to OCELOT");
				}
				if (mobid.equals("IRON_GOLEM")) {
					correct54mob = 0;
				}
				if (mobid.equals("IRON")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "IRON_GOLEM");
					System.out
							.println("[ColourFireWorks] Renamed IRON to IRONGOLEM");
				}
				if (mobid.equals("IRONGOLEM")) {
					correct54mob = 0;
					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "IRON_GOLEM");
					System.out
							.println("[ColourFireWorks] Renamed IRONGOLEM to IRON_GOLEM");
				}
				if (correct54mob == 1) {

					String whatisitthen;
					whatisitthen = getConfig().getString(
							"Custom.Firework" + cf3mob + ".Mob" + idnumber2mob
									+ ".Mobname");

					customConfig.set("Custom.Firework" + cf3mob + ".Mob"
							+ idnumber2mob + ".Mobname", "PIG");
					System.out
							.println("[ColourFireWorks] Error in CustomFireWork"
									+ cf3mob + " | Mob" + idnumber2mob);
					System.out.println("[ColourFireWorks] " + whatisitthen
							+ " Is not a known Mob, Reset to PIG");

				}

				idnumber2mob = idnumber2mob + 1;

			}

			idnumber2mob = 1;
			cf3mob = cf3mob + 1;

		}

		System.out.println("[ColourFireWorks] Checking Item IDS");

		int cf3;
		cf3 = 1;
		int idnumber2;
		idnumber2 = 1;
		int correct54;
		correct54 = 0;

		while (customConfig.contains("Custom.Firework" + cf3 + ".use") == true) {

			while (customConfig.getBoolean("Custom.Firework" + cf3
					+ ".ItemsDroped.ID" + idnumber2 + ".use") == true) {

				int itemid;
				itemid = customConfig.getInt("Custom.Firework" + cf3
						+ ".ItemsDroped.ID" + idnumber2 + ".ItemID");

				int enchantmentexist = 1;

				while (getCustomConfig().contains(
						"Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber
								+ ".Enchantment" + enchantmentexist + ".Type")) {

					String EnchantmentToAdd = getCustomConfig().getString(
							"Custom.Firework" + cf3 + ".ItemsDroped.ID"
									+ idnumber + ".Enchantment"
									+ enchantmentexist + ".Type").toUpperCase();

					int LevelEnchantmentToAdd = getCustomConfig().getInt(
							"Custom.Firework" + cf3 + ".ItemsDroped.ID"
									+ idnumber + ".Enchantment"
									+ enchantmentexist + ".Level");

					boolean correctenchantment = false;
					boolean correctenid = false;

					if (EnchantmentToAdd.equals("ARROW_DAMAGE")) {
						correctenchantment = true;
						if (itemid == 261) {
							correctenid = true;

							if (LevelEnchantmentToAdd > 5
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] ARROW_DAMAGE Level must be between 1 and 5 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}

						}
					}
					if (EnchantmentToAdd.equals("ARROW_FIRE")) {
						correctenchantment = true;
						if (itemid == 261) {
							correctenid = true;
							if (LevelEnchantmentToAdd != 1) {
								System.out
										.println("[ColourFireWorks] ARROW_DAMAGE Level must be 1 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("ARROW_INFINITE")) {
						correctenchantment = true;
						if (itemid == 261) {
							correctenid = true;
							if (LevelEnchantmentToAdd != 1) {
								System.out
										.println("[ColourFireWorks] ARROW_INFINITE Level must be 1 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("ARROW_KNOCKBACK")) {
						correctenchantment = true;
						if (itemid == 261) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 2
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] ARROW_KNOCKBACK Level must be between 1 and 2 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("PROTECTION_ENVIRONMENTAL")) {
						correctenchantment = true;
						if (itemid >= 298 && itemid <= 317) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 4
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] PROTECTION_ENVIRONMENTAL Level must be between 1 and 4 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("PROTECTION_EXPLOSIONS")) {
						correctenchantment = true;
						if (itemid >= 298 && itemid <= 317) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 4
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] PROTECTION_EXPLOSIONS Level must be between 1 and 4 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("PROTECTION_FALL")) {
						correctenchantment = true;
						if (itemid == 301 || itemid == 305 || itemid == 309
								|| itemid == 313 || itemid == 317) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 4
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] PROTECTION_FALL Level must be between 1 and 4 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("PROTECTION_FIRE")) {
						correctenchantment = true;
						if (itemid >= 298 && itemid <= 317) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 4
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] PROTECTION_FIRE Level must be between 1 and 4 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("PROTECTION_PROJECTILE")) {
						correctenchantment = true;
						if (itemid >= 298 && itemid <= 317) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 4
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] PROTECTION_PROJECTILE Level must be between 1 and 4 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("OXYGEN")) {
						correctenchantment = true;
						if (itemid == 298 || itemid == 302 || itemid == 306
								|| itemid == 310 || itemid == 314) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 3
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] OXYGEN Level must be between 1 and 3 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("WATER_WORKER")) {
						correctenchantment = true;
						if (itemid == 298 || itemid == 302 || itemid == 306
								|| itemid == 310 || itemid == 314) {
							correctenid = true;
							if (LevelEnchantmentToAdd != 1) {
								System.out
										.println("[ColourFireWorks] WATER_WORKER Level must be 1 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("DURABILITY")) {
						correctenchantment = true;
						if (itemid == 269 || itemid == 270 || itemid == 271
								|| itemid == 273 || itemid == 274
								|| itemid == 275 || itemid == 277
								|| itemid == 278 || itemid == 279
								|| itemid == 284 || itemid == 285
								|| itemid == 286 || itemid == 256
								|| itemid == 257 || itemid == 258) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 3
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] DURABILITY Level must be between 1 and 3 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("DIG_SPEED")) {
						correctenchantment = true;
						if (itemid == 269 || itemid == 270 || itemid == 271
								|| itemid == 273 || itemid == 274
								|| itemid == 275 || itemid == 277
								|| itemid == 278 || itemid == 279
								|| itemid == 284 || itemid == 285
								|| itemid == 286 || itemid == 256
								|| itemid == 257 || itemid == 258) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 5
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] DIG_SPEED Level must be between 1 and 5 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("LOOT_BONUS_BLOCKS")) {
						correctenchantment = true;
						if (itemid == 269 || itemid == 270 || itemid == 271
								|| itemid == 273 || itemid == 274
								|| itemid == 275 || itemid == 277
								|| itemid == 278 || itemid == 279
								|| itemid == 284 || itemid == 285
								|| itemid == 286 || itemid == 256
								|| itemid == 257 || itemid == 258) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 3
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] LOOT_BONUS_BLOCKS Level must be between 1 and 3 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("SILK_TOUCH")) {
						correctenchantment = true;
						if (itemid == 269 || itemid == 270 || itemid == 271
								|| itemid == 273 || itemid == 274
								|| itemid == 275 || itemid == 277
								|| itemid == 278 || itemid == 279
								|| itemid == 284 || itemid == 285
								|| itemid == 286 || itemid == 256
								|| itemid == 257 || itemid == 258) {
							correctenid = true;
							if (LevelEnchantmentToAdd != 1) {
								System.out
										.println("[ColourFireWorks] SILK_TOUCH Level must be 1 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("FIRE_ASPECT")) {
						correctenchantment = true;
						if (itemid == 267 || itemid == 268 || itemid == 272
								|| itemid == 276 || itemid == 283) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 2
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] FIRE_ASPECT Level must be between 1 and 2 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("KNOCKBACK")) {
						correctenchantment = true;
						if (itemid == 267 || itemid == 268 || itemid == 272
								|| itemid == 276 || itemid == 283) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 2
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] KNOCKBACK Level must be between 1 and 2 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("LOOT_BONUS_MOBS")) {
						correctenchantment = true;
						if (itemid == 267 || itemid == 268 || itemid == 272
								|| itemid == 276 || itemid == 283) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 3
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] LOOT_BONUS_MOBS Level must be between 1 and 3 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("DAMAGE_ARTHROPODS")) {
						correctenchantment = true;
						if (itemid == 267 || itemid == 268 || itemid == 272
								|| itemid == 276 || itemid == 283) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 5
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] DAMAGE_ARTHROPODS Level must be between 1 and 5 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("DAMAGE_ALL")) {
						correctenchantment = true;
						if (itemid == 267 || itemid == 268 || itemid == 272
								|| itemid == 276 || itemid == 283) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 5
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] DAMAGE_ALL Level must be between 1 and 5 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("DAMAGE_UNDEAD")) {
						correctenchantment = true;
						if (itemid == 267 || itemid == 268 || itemid == 272
								|| itemid == 276 || itemid == 283) {
							correctenid = true;
							if (LevelEnchantmentToAdd > 5
									|| LevelEnchantmentToAdd < 1) {
								System.out
										.println("[ColourFireWorks] DAMAGE_UNDEAD Level must be between 1 and 5 - Set to default");
								getCustomConfig().set(
										"Custom.Firework" + cf3
												+ ".ItemsDroped.ID" + idnumber
												+ ".Enchantment"
												+ enchantmentexist + ".Level",
										1);
							}
						}
					}
					if (EnchantmentToAdd.equals("NONE")) {
						correctenchantment = true;
						correctenid = true;
					}

					if (correctenchantment == false) {
						System.out
								.println("[ColourFireWorks] "
										+ EnchantmentToAdd
										+ " Is not a known Enchantment! - Set to 'NONE'");
						getCustomConfig().set(
								"Custom.Firework" + cf3 + ".ItemsDroped.ID"
										+ idnumber + ".Enchantment"
										+ enchantmentexist + ".Type", "NONE");
					}
					if (correctenchantment == true) {
						if (correctenid == false) {
							System.out.println("[ColourFireWorks] "
									+ EnchantmentToAdd
									+ " Will not go on the item " + itemid
									+ " - Set to 'NONE'");
							getCustomConfig().set(
									"Custom.Firework" + cf3 + ".ItemsDroped.ID"
											+ idnumber + ".Enchantment"
											+ enchantmentexist + ".Type",
									"NONE");
						}
					}

					enchantmentexist++;
				}

				if (itemid > 388) {
					if (itemid < 2256) {
						System.out
								.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
										+ cf3 + ", Item " + idnumber2);
						correct54 = 1;
					}

				}

				if (itemid > 133) {
					if (itemid < 256) {
						System.out
								.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
										+ cf3 + ", Item " + idnumber2);
						correct54 = 1;
					}

				}

				if (itemid < 0) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3 + ", Item " + idnumber2);
					correct54 = 1;
				}

				if (itemid > 2266) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3 + ", Item " + idnumber2);
					correct54 = 1;
				}

				if (itemid == 62) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3
									+ ", Item "
									+ idnumber2
									+ " A Lit Furnace can not be used!");
					correct54 = 1;
				}
				if (itemid == 74) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3
									+ ", Item "
									+ idnumber2
									+ " Glowing Redstone Ore can not be used!");
					correct54 = 1;
				}
				if (itemid == 93 || itemid == 94) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3
									+ ", Item "
									+ idnumber2
									+ " A Dioide Block can not be used!");
					correct54 = 1;
				}
				if (itemid == 117) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3
									+ ", Item "
									+ idnumber2
									+ " Brewing Stands Blocks can not be used!");
					correct54 = 1;
				}
				if (itemid == 118) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3
									+ ", Item "
									+ idnumber2
									+ " Cauldron Block can not be used!");
					correct54 = 1;
				}
				if (itemid == 119) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3
									+ ", Item "
									+ idnumber2
									+ " End Portal can not be used!");
					correct54 = 1;
				}
				if (itemid == 120) {
					System.out
							.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork"
									+ cf3
									+ ", Item "
									+ idnumber2
									+ " End Portal Frame can not be used!");
					correct54 = 1;
				}

				idnumber2 = idnumber2 + 1;

			}

			idnumber2 = 1;
			cf3 = cf3 + 1;
		}

		if (correct54 == 1) {
			System.out.println("[ColourFireWorks] Error ITEM_CHECK_FAIL");
			Bukkit.getPluginManager().disablePlugin(this);
		} else {

			getConfig().options().copyDefaults(true);
			saveConfig();
			this.getCustomConfig().options().copyDefaults(true);
			saveCustomConfig();
			this.getdroppartyConfig().options().copyDefaults(true);
			savedroppartyConfig();
			this.getEconomyConfig().options().copyDefaults(true);
			saveEconomyConfig();
			System.out.println("[ColourFireWorks] Config Loaded");
		}

	}

	public boolean onCommand(CommandSender sender, Command command,
			String commandLabel, String args[]) {
		String commandName = command.getName().toLowerCase();
		Player player;
		if (sender instanceof Player) {
			player = (Player) sender;
		} else {
			return true;
		}

		if (commandName.equals("dropcast")) {
			if (player.hasPermission("colourfireworks.dropparty.dropcast")) {

				int messagelength = args.length;

				if (messagelength > 0) {

					int lengthon = 0;

					String messagetobroadcast = "";

					while (lengthon < messagelength) {
						messagetobroadcast = messagetobroadcast
								+ args[lengthon] + " ";
						lengthon++;
					}


					String newmessagetobroadcast = messagetobroadcast.replace("&1", "§1").replace("&2", "§2")
							.replace("&3", "§3").replace("&4", "§4")
							.replace("&5", "§5").replace("&6", "§6")
							.replace("&7", "§7").replace("&8", "§8")
							.replace("&9", "§9").replace("&0", "§0")
							.replace("&a", "§a").replace("&b", "§b")
							.replace("&c", "§c").replace("&d", "§d")
							.replace("&e", "§e").replace("&f", "§f")
							.replace("&k", "§k").replace("&l", "§l")
							.replace("&m", "§m").replace("&n", "§n")
							.replace("&o", "§o");

					Bukkit.broadcastMessage("§6[§aDropParty§6]§f "
							+ newmessagetobroadcast);

				}  else {
					player.sendMessage(ChatColor.RED + "Message can not be blank!");
				}
			}  else {
				player.sendMessage(ChatColor.RED + "You lack the permission to dropcast!");
			}
		}

		if (commandName.equals("colourfireworks")
				|| (commandName.equals("colourfirework")
						|| (commandName.equals("colorfireworks")) || (commandName
							.equals("colorfirework")))) {

			Boolean correct = false;

			if (args.length == 0) {

				correct = true;
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");
				sender.sendMessage(ChatColor.AQUA + "ColourFireWorks");
				sender.sendMessage(ChatColor.GOLD + "Created By Craftiii4");
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");
				sender.sendMessage(ChatColor.DARK_PURPLE + "Commands:");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks"
						+ ChatColor.GREEN + " - Shows the credits");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks reload"
						+ ChatColor.GREEN + " - Reloads the config file");
				sender.sendMessage(ChatColor.BLUE
						+ "/colourfireworks dropparty stop" + ChatColor.GREEN
						+ " - Force stop drop party");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks dp ban"
						+ ChatColor.GOLD + " <id>" + ChatColor.GREEN
						+ " - Bans an item from the drop party");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks dp unban"
						+ ChatColor.GOLD + " <id>" + ChatColor.GREEN
						+ " - Unbans an item from the drop party");
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");
			}

			if (args.length > 3) {
				correct = true;
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");
				sender.sendMessage(ChatColor.AQUA + "ColourFireWorks");
				sender.sendMessage(ChatColor.GOLD + "Created By Craftiii4");
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");
				sender.sendMessage(ChatColor.DARK_PURPLE + "Commands:");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks"
						+ ChatColor.GREEN + " - Shows the credits");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks reload"
						+ ChatColor.GREEN + " - Reloads the config file");
				sender.sendMessage(ChatColor.BLUE
						+ "/colourfireworks dropparty stop" + ChatColor.GREEN
						+ " - Force stop drop party");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks dp ban"
						+ ChatColor.GOLD + " <id>" + ChatColor.GREEN
						+ " - Bans an item from the drop party");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks dp unban"
						+ ChatColor.GOLD + " <id>" + ChatColor.GREEN
						+ " - Unbans an item from the drop party");
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");

			}

			if (args.length == 3) {

				String first;
				first = args[0];

				if (first.equalsIgnoreCase("dropparty")
						|| (first.equalsIgnoreCase("dp"))) {
					correct = true;

					boolean rightnow = false;
					String secound;
					secound = args[1];

					if (secound.equalsIgnoreCase("ban")) {
						correct = true;
						rightnow = true;

						if (player
								.hasPermission("colourfireworks.dropparty.banitem")) {

							String third;
							third = args[2];

							try {
								int idint = Integer.parseInt(third);

								List<String> dplist = getdroppartyConfig()
										.getStringList("DropParty.BlockItemsId");

								if (dplist.contains("" + idint) == false) {

									dplist.add("" + idint);
									getdroppartyConfig().set(
											"DropParty.BlockItemsId", dplist);
									player.sendMessage(ChatColor.RED
											+ "Banned the block/item with the id "
											+ ChatColor.GOLD + idint);
									savedroppartyConfig();
								} else {
									player.sendMessage(ChatColor.RED
											+ "That Item/Block is alreadly banned! ("
											+ ChatColor.GOLD + idint
											+ ChatColor.RED + ")");
								}

							} catch (NumberFormatException e) {
								player.sendMessage(ChatColor.RED
										+ "Item/Block to ban must be in its ID form");
							}

						} else {
							player.sendMessage(ChatColor.RED
									+ "You lack permission to ban items!");
						}

					}

					if (secound.equalsIgnoreCase("unban")) {
						correct = true;
						rightnow = true;

						if (player
								.hasPermission("colourfireworks.dropparty.unbanitem")) {

							String third;
							third = args[2];

							try {
								int idint = Integer.parseInt(third);

								List<String> dplist = getdroppartyConfig()
										.getStringList("DropParty.BlockItemsId");

								if (dplist.contains("" + idint) == true) {

									dplist.remove("" + idint);
									getdroppartyConfig().set(
											"DropParty.BlockItemsId", dplist);
									player.sendMessage(ChatColor.RED
											+ "Unbanned the block/item with the id "
											+ ChatColor.GOLD + idint);
									savedroppartyConfig();
								} else {
									player.sendMessage(ChatColor.RED
											+ "That Item/Block is not blocked! ("
											+ ChatColor.GOLD + idint
											+ ChatColor.RED + ")");
								}

							} catch (NumberFormatException e) {
								player.sendMessage(ChatColor.RED
										+ "Item/Block to ban must be in its ID form");
							}

						} else {
							player.sendMessage(ChatColor.RED
									+ "You lack permission to unban items!");
						}

					}

					if (rightnow == false) {
						sender.sendMessage(ChatColor.WHITE
								+ "--------------------------------------------------");
						sender.sendMessage(ChatColor.DARK_PURPLE
								+ "Did you mean:");
						sender.sendMessage(ChatColor.BLUE
								+ "/colourfireworks dp ban" + ChatColor.GOLD
								+ " <id>" + ChatColor.GREEN
								+ " - Bans an item from the drop party");
						sender.sendMessage(ChatColor.BLUE
								+ "/colourfireworks dp unban" + ChatColor.GOLD
								+ " <id>" + ChatColor.GREEN
								+ " - Unbans an item from the drop party");
						sender.sendMessage(ChatColor.WHITE
								+ "--------------------------------------------------");
					}
				}

			}

			if (args.length == 2) {

				String first;
				first = args[0];

				if (first.equalsIgnoreCase("dropparty")
						|| (first.equalsIgnoreCase("dp"))) {

					String secound;
					secound = args[1];

					if (secound.equalsIgnoreCase("stop")) {
						correct = true;
						if (player
								.hasPermission("colourfireworks.dropparty.stop")) {

							if (colourfireworks.allreadyone.containsKey("On")) {
								colourfireworksBlockListener
										.stopDropPartycomplete();
								player.sendMessage(ChatColor.RED
										+ "Stoping Drop Party!");
							} else {
								player.sendMessage(ChatColor.RED
										+ "No Drop Party is active!");
							}

						} else {
							player.sendMessage(ChatColor.RED
									+ "You lack permission to do that!");
						}

					} else {
						sender.sendMessage(ChatColor.WHITE
								+ "--------------------------------------------------");
						sender.sendMessage(ChatColor.AQUA + "ColourFireWorks");
						sender.sendMessage(ChatColor.GOLD
								+ "Created By Craftiii4");
						sender.sendMessage(ChatColor.WHITE
								+ "--------------------------------------------------");
						sender.sendMessage(ChatColor.DARK_PURPLE + "Commands:");
						sender.sendMessage(ChatColor.BLUE + "/colourfireworks"
								+ ChatColor.GREEN + " - Shows the credits");
						sender.sendMessage(ChatColor.BLUE
								+ "/colourfireworks reload" + ChatColor.GREEN
								+ " - Reloads the config file");
						sender.sendMessage(ChatColor.BLUE
								+ "/colourfireworks dropparty stop"
								+ ChatColor.GREEN + " - Force stop drop party");
						sender.sendMessage(ChatColor.BLUE
								+ "/colourfireworks dp ban" + ChatColor.GOLD
								+ " <id>" + ChatColor.GREEN
								+ " - Bans an item from the drop party");
						sender.sendMessage(ChatColor.BLUE
								+ "/colourfireworks dp unban" + ChatColor.GOLD
								+ " <id>" + ChatColor.GREEN
								+ " - Unbans an item from the drop party");
						sender.sendMessage(ChatColor.WHITE
								+ "--------------------------------------------------");
					}

				} else {
					sender.sendMessage(ChatColor.WHITE
							+ "--------------------------------------------------");
					sender.sendMessage(ChatColor.AQUA + "ColourFireWorks");
					sender.sendMessage(ChatColor.GOLD + "Created By Craftiii4");
					sender.sendMessage(ChatColor.WHITE
							+ "--------------------------------------------------");
					sender.sendMessage(ChatColor.DARK_PURPLE + "Commands:");
					sender.sendMessage(ChatColor.BLUE + "/colourfireworks"
							+ ChatColor.GREEN + " - Shows the credits");
					sender.sendMessage(ChatColor.BLUE
							+ "/colourfireworks reload" + ChatColor.GREEN
							+ " - Reloads the config file");
					sender.sendMessage(ChatColor.BLUE
							+ "/colourfireworks dropparty stop"
							+ ChatColor.GREEN + " - Force stop drop party");
					sender.sendMessage(ChatColor.BLUE
							+ "/colourfireworks dp ban" + ChatColor.GOLD
							+ " <id>" + ChatColor.GREEN
							+ " - Bans an item from the drop party");
					sender.sendMessage(ChatColor.BLUE
							+ "/colourfireworks dp unban" + ChatColor.GOLD
							+ " <id>" + ChatColor.GREEN
							+ " - Unbans an item from the drop party");
					sender.sendMessage(ChatColor.WHITE
							+ "--------------------------------------------------");
				}

			}

			if (args.length == 1) {

				String reload;
				reload = args[0];

				if (reload.equalsIgnoreCase("id")) {
					correct = true;

					player.sendMessage("Item ID = "
							+ player.getItemInHand().getTypeId());
					player.sendMessage("Item SUBID = "
							+ player.getItemInHand().getDurability());

				}

				if (reload.equalsIgnoreCase("reload")) {
					correct = true;

					if (player.hasPermission("colourfirework.reload")
							|| (player.isOp())) {

						ReloadCommand.RunReloadCommand(this, player);

					} else {
						player.sendMessage(ChatColor.RED
								+ "You do not have permission to do that!");
					}
				}

				if (correct == false) {
					sender.sendMessage(ChatColor.WHITE
							+ "--------------------------------------------------");
					sender.sendMessage(ChatColor.AQUA + "ColourFireWorks");
					sender.sendMessage(ChatColor.GOLD + "Created By Craftiii4");
					sender.sendMessage(ChatColor.WHITE
							+ "--------------------------------------------------");
					sender.sendMessage(ChatColor.DARK_PURPLE + "Commands:");
					sender.sendMessage(ChatColor.BLUE + "/colourfireworks"
							+ ChatColor.GREEN + " - Shows the credits");
					sender.sendMessage(ChatColor.BLUE
							+ "/colourfireworks reload" + ChatColor.GREEN
							+ " - Reloads the config file");
					sender.sendMessage(ChatColor.BLUE
							+ "/colourfireworks dropparty stop"
							+ ChatColor.GREEN + " - Force stop drop party");
					sender.sendMessage(ChatColor.BLUE
							+ "/colourfireworks dp ban" + ChatColor.GOLD
							+ " <id>" + ChatColor.GREEN
							+ " - Bans an item from the drop party");
					sender.sendMessage(ChatColor.BLUE
							+ "/colourfireworks dp unban" + ChatColor.GOLD
							+ " <id>" + ChatColor.GREEN
							+ " - Unbans an item from the drop party");
					sender.sendMessage(ChatColor.WHITE
							+ "--------------------------------------------------");
				}

			}
		}
		return false;

	}

}
