//You may not copy the exact code!
//You can use the code to understand how it works!
//CopyWrited


package me.craftiii4.colourfireworks;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;

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
	
	FileConfiguration customConfig = null;
	private File customConfigFile = null;
	
	
	
    public boolean vaultcheck = false;
    
	public static HashMap<Player, ArrayList<Block>> colourfireworkusers = new HashMap<Player, ArrayList<Block>>();
	
	
	public static HashMap<String, Boolean> droppartychestplace = new HashMap<String, Boolean>();
	public static HashMap<Location, Boolean> droppartychestlocation = new HashMap<Location, Boolean>();
	
	public static HashMap<String, Boolean> allreadyone = new HashMap<String, Boolean>();
	
	//ItemStack
	public static HashMap<Location, ItemStack> itemsinchest = new HashMap<Location, ItemStack>();
	
	public WorldGuardPlugin getWorldGuard() {
		Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");

		// WorldGuard may not be loaded
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null; // Maybe you want throw an exception instead
		}
		return (WorldGuardPlugin) plugin;
		
		
	}

	
	
	
	public void reloadCustomConfig() {
	    if (customConfigFile == null) {
	    customConfigFile = new File(getDataFolder(), "CustomFireWorks.yml");
	    }
	    customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
	 
	    // Look for defaults in the jar
	    InputStream defConfigStream = getResource("customConfig.yml");
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
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
	        Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + customConfigFile, ex);
	    }
	}
	

	@Override
	public void onDisable() {
		System.out.println("[ColourFireWorks] ColourFireWorks v"
				+ getDescription().getVersion() + " disabled!");

	}

	@Override
	public void onEnable() {
		

        
    
		
		loadConfiguration();
		
		
		new colourfireworksPlayerListener(this);
		new colourfireworksEntityListener(this);
		new colourfireworksBlockListener(this);
		
		if (getWorldGuard() != null) {
			System.out.println("[ColourFireWorks] WorldGuard Found!, Linked!");
		} else {
			System.out.println("[ColourFireWorks] WorldGuard Not Found!, Not Linked!");
		}
		
        Plugin x = this.getServer().getPluginManager().getPlugin("Vault");
        if(x != null & x instanceof Vault) {
    		System.out.println("[ColourFireWorks] Vault Found!, Linked!");
    		vaultcheck = true;
        } else {
    		System.out.println("[ColourFireWorks] Vault Not Found!, Not Linked!");
    		vaultcheck = false;            
        }
		
		System.out.println("[ColourFireWorks] ColourFireWorks v"
				+ getDescription().getVersion() + " activated!");


	}

	public void loadConfiguration() {
		
		getCustomConfig();

		String ItemIdNeededInHand = "Fireworks.ItemIdNeededInHand";
		getConfig().addDefault(ItemIdNeededInHand, 288);
		String Damageblocks = "Fireworks.DamageBlocks";
		getConfig().addDefault(Damageblocks, true);
		String DropsDye = "Fireworks.Dye.Drops";
		getConfig().addDefault(DropsDye, 24);
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
		String DropsPumpkin = "Fireworks.Pumpkin.Drops";
		getConfig().addDefault(DropsPumpkin, 32);
		String DropsSpiders = "Fireworks.Pumpkin.Spiders";
		getConfig().addDefault(DropsSpiders, 4);
		String fireworkheight = "Fireworks.Height";
		getConfig().addDefault(fireworkheight, 1.5);
		
		String exp1 = "Fireworks.Exp.Ammount";
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

		
		String snowDropsalight = "Fireworks.Snow.SetAlight.SnowBalls";
		getConfig().addDefault(snowDropsalight, false);
		String snowdiamondDropsalight = "Fireworks.Snow.SetAlight.Diamonds";
		getConfig().addDefault(snowdiamondDropsalight, false);
		String snowgoldiDropsalight = "Fireworks.Snow.SetAlight.Gold";
		getConfig().addDefault(snowgoldiDropsalight, false);

		String snowDropspickup = "Fireworks.Snow.CanBePickedUp.SnowBalls";
		getConfig().addDefault(snowDropspickup, true);
		String snowdiamondsDropspickup = "Fireworks.Snow.CanBePickedUp.Diamonds";
		getConfig().addDefault(snowdiamondsDropspickup, true);
		String snowgoldiDropspickup = "Fireworks.Snow.CanBePickedUp.Gold";
		getConfig().addDefault(snowgoldiDropspickup, true);

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
		String customdmg = "Fireworks.Custom.DamageBlocks";
		getConfig().addDefault(customdmg, true);
		String custommsg01 = "Fireworks.Message.SendOnLaunch";
		getConfig().addDefault(custommsg01, true);
		
		String dropparty = "DropParty.Message.Radius";
		getConfig().addDefault(dropparty, 50);
		
		int tickcheck;
		tickcheck = getConfig().getInt("Fireworks.Dye.Remove.Ticks");
		
		if (tickcheck < 0) {						
				System.out.println("[ColourFireWorks] Error, Remove Ticks Below 0, set to default");
				getConfig().set("Fireworks.Dye.Remove.Ticks", 30);
			
		}
		
		if (tickcheck > 600) {						
			System.out.println("[ColourFireWorks] Error, Remove Ticks Above 600 (30 sec), set to default");
			getConfig().set("Fireworks.Dye.Remove.Ticks", 30);
		
	}
		
		
		int iteminhandcheck;
		iteminhandcheck = getConfig().getInt("Fireworks.ItemIdNeededInHand");
		
		if (iteminhandcheck > 385) {					
			if (iteminhandcheck < 2266) {
				System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
				getConfig().set("Fireworks.ItemIdNeededInHand", 288);
			}
			
		}
		
		if (iteminhandcheck > 124) {					
			if (iteminhandcheck < 256) {
				System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
				getConfig().set("Fireworks.ItemIdNeededInHand", 288);
			}
			
		}
		
		if (iteminhandcheck < 0) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		
		if (iteminhandcheck > 2266) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		
		if (iteminhandcheck == 62) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}				
		if (iteminhandcheck == 74) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 93 || iteminhandcheck == 94)  {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 117) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 118) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 119) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 120) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		
		int fireworkdyeammountcheck;
		fireworkdyeammountcheck = getConfig().getInt("Fireworks.Dye.Drops");
		
		if (fireworkdyeammountcheck > 128) {			
			System.out.println("[ColourFireWorks] Error, Dye Drops above 128, set to default");
			getConfig().set("Fireworks.Dye.Drops", 24);			
		}
		if (fireworkdyeammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Dye Drops below 0, set to default");
			getConfig().set("Fireworks.Dye.Drops", 24);			
		}
		
		int pumpkinammountcheck;
		pumpkinammountcheck = getConfig().getInt("Fireworks.Pumpkin.Drops");
		
		if (pumpkinammountcheck > 256) {			
			System.out.println("[ColourFireWorks] Error, Pumpkin Drops above 256, set to default");
			getConfig().set("Fireworks.Pumpkin.Drops", 32);			
		}
		if (pumpkinammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Pumpkin Drops below 0, set to default");
			getConfig().set("Fireworks.Pumpkin.Drops", 32);			
		}
		
		int spiderammountcheck;
		spiderammountcheck = getConfig().getInt("Fireworks.Pumpkin.Spiders");
		
		if (spiderammountcheck > 32) {			
			System.out.println("[ColourFireWorks] Error, Spiders to spawn above 32, set to default");
			getConfig().set("Fireworks.Pumpkin.Spiders", 4);			
		}
		if (spiderammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Spiders to spawn below 0, set to default");
			getConfig().set("Fireworks.Pumpkin.Spiders", 4);			
		}
		
		int fireworkheightcheck;
		fireworkheightcheck = getConfig().getInt("Fireworks.Height");
		
		if (fireworkheightcheck > 16) {			
			System.out.println("[ColourFireWorks] Error, Firework Height above 16, set to default");
			getConfig().set("Fireworks.Height", 1.5);			
		}
		if (fireworkheightcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Fireworks Height below 0, set to default");
			getConfig().set("Fireworks.Height", 1.5);			
		}
		
		int snowammountcheck;
		snowammountcheck = getConfig().getInt("Fireworks.Snow.Drops.Snowball");
		
		if (snowammountcheck > 256) {			
			System.out.println("[ColourFireWorks] Error, Snow Ball Drops above 256, set to default");
			getConfig().set("Fireworks.Snow.Drops.Snowball", 24);			
		}
		if (snowammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Snow Ball Drops below 0, set to default");
			getConfig().set("Fireworks.Snow.Drops.Snowball", 24);			
		}
		
		int diamondammountcheck;
		diamondammountcheck = getConfig().getInt("Fireworks.Snow.Drops.Diamond");
		
		if (diamondammountcheck > 256) {			
			System.out.println("[ColourFireWorks] Error, Diamond Drops above 256, set to default");
			getConfig().set("Fireworks.Snow.Drops.Diamond", 6);			
		}
		if (diamondammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Diamond Drops below 0, set to default");
			getConfig().set("Fireworks.Snow.Drops.Diamond", 6);			
		}
		
		int goldammountcheck;
		goldammountcheck = getConfig().getInt("Fireworks.Snow.Drops.Gold");
		
		if (goldammountcheck > 256) {			
			System.out.println("[ColourFireWorks] Error, Gold Drops above 256, set to default");
			getConfig().set("Fireworks.Snow.Drops.Gold", 12);			
		}
		if (goldammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Gold Drops below 0, set to default");
			getConfig().set("Fireworks.Snow.Drops.Gold", 12);			
		}
		
		int snowmenammountcheck;
		snowmenammountcheck = getConfig().getInt("Fireworks.Snow.SnowMen");
		
		if (snowmenammountcheck > 32) {			
			System.out.println("[ColourFireWorks] Error, SnowMen above 32, set to default");
			getConfig().set("Fireworks.Snow.SnowMen", 4);			
		}
		if (snowmenammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, SnowMen below 0, set to default");
			getConfig().set("Fireworks.Snow.SnowMen", 4);			
		}
		
		int itemspreadcheck;
		itemspreadcheck = getConfig().getInt("Fireworks.Snow.ItemSpread");
		
		if (itemspreadcheck > 16) {			
			System.out.println("[ColourFireWorks] Error, SnowBlock Item Spread above 16, set to default");
			getConfig().set("Fireworks.Snow.ItemSpread", 4);			
		}
		if (itemspreadcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, SnowBlock Item Spread below 0, set to default");
			getConfig().set("Fireworks.Snow.ItemSpread", 4);			
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
			
			String customfireworksmessage = "Custom.Firework" + cf + ".LaunchMessage";
			customConfig.addDefault(customfireworksmessage, "The Firework Goes off!");

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
			String customfireworks4 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Ammount";
			customConfig.addDefault(customfireworks4, 16);
			String customfireworks6 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.CanBePickedUp";
			customConfig.addDefault(customfireworks6, true);
			String customfireworks7 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.SetAlight";
			customConfig.addDefault(customfireworks7, false);

			String customfireworks8 = "Custom.Firework" + cf
					+ ".Mob1.use";
			customConfig.addDefault(customfireworks8, false);
			String customfireworks9 = "Custom.Firework" + cf
					+ ".Mob1.Mobname";
			customConfig.addDefault(customfireworks9, "PIG");
			String customfireworks10 = "Custom.Firework" + cf
					+ ".Mob1.Ammount";
			customConfig.addDefault(customfireworks10, 1);
			String customfireworks12 = "Custom.Firework" + cf
					+ ".ExpOrp.Ammount";				
			customConfig.addDefault(customfireworks12, 0);
			String customfireworks13 = "Custom.Firework" + cf
					+ ".ExpOrp.Value";				
			customConfig.addDefault(customfireworks13, 0);
		}
		
		
		int addnew1 = 1;
		
		while (customConfig.getBoolean("Custom.Firework" + addnew1 + ".use") == true) {
			
			
			if (customConfig.contains("Custom.Firework" + addnew1
					+ ".FireworkBlockID-Raw-Data") == false) {
				String customfireworksnew01 = "Custom.Firework" + addnew1
						+ ".FireworkBlockID-Raw-Data";
				customConfig.addDefault(customfireworksnew01, -1);
				
			}
			if (customConfig.contains("Custom.Firework" + addnew1 + ".LaunchMessage") == false) {
				String customfireworksnew02 = "Custom.Firework" + addnew1 + ".LaunchMessage";
				customConfig.addDefault(customfireworksnew02, "The Firework Goes off!");
				
			}
			
			
			addnew1 = addnew1 + 1;
			
		}
		
		int addnew2 = 1;
		
		while (customConfig.contains("Custom.Firework" + addnew2 + ".use") == true) {
			
			
			if (customConfig.contains("Custom.Firework" + addnew2
					+ ".ExpOrp.Ammount") == false) {
				
				String customfireworks12 = "Custom.Firework" + addnew2
						+ ".ExpOrp.Ammount";				
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
			
			String customfireworksmessage = "Custom.Firework" + cf + ".LaunchMessage";
			customConfig.addDefault(customfireworksmessage, "The Firework Goes off!");

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
			String customfireworks4 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Ammount";
			customConfig.addDefault(customfireworks4, 16);
			String customfireworks6 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.CanBePickedUp";
			customConfig.addDefault(customfireworks6, true);
			String customfireworks7 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.SetAlight";
			customConfig.addDefault(customfireworks7, false);
			
			String customfireworks8 = "Custom.Firework" + cf
					+ ".Mob1.use";
			customConfig.addDefault(customfireworks8, false);
			String customfireworks9 = "Custom.Firework" + cf
					+ ".Mob1.Mobname";
			customConfig.addDefault(customfireworks9, "PIG");
			String customfireworks10 = "Custom.Firework" + cf
					+ ".Mob1.Ammount";				
			customConfig.addDefault(customfireworks10, 1);
			String customfireworks12 = "Custom.Firework" + cf
					+ ".ExpOrp.Ammount";				
			customConfig.addDefault(customfireworks12, 0);
			String customfireworks13 = "Custom.Firework" + cf
					+ ".ExpOrp.Value";				
			customConfig.addDefault(customfireworks13, 0);

		}
		
		int firework;
		firework = 1;

		
		while (customConfig.contains("Custom.Firework" + firework + ".use") == true) {
			
			
			int blockid = getConfig().getInt("Custom.Firework" + firework
					+ ".FireworkBlockID");
			
			if (blockid == 35) {
				System.out.println("[ColourFireWorks] Wool Blocks not allowed! Changing to -1");
				customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
			}
						
			if (blockid == 80) {
				System.out.println("[ColourFireWorks] Snow Blocks not allowed! Changing to -1");
				customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
			}
			
			if (blockid == 86) {
				System.out.println("[ColourFireWorks] Pumpkin Blocks not allowed! Changing to -1");
				customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
			}
			
			firework = firework + 1;

		}
		

		int cf2;
		cf2 = 1;
		int idnumber;
		idnumber = 1;

		while (customConfig.contains("Custom.Firework" + cf2 + ".use") == true) {
			
			idnumber = 1;
			
			while (customConfig.getBoolean(
					"Custom.Firework" + cf2 + ".ItemsDroped.ID" + idnumber
							+ ".use") == true) {
				idnumber = idnumber + 1;
				String customfireworks5 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".use";
				customConfig.addDefault(customfireworks5, false);
				String customfireworks3 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".ItemID";
				customConfig.addDefault(customfireworks3, 1);
				String customfireworks4 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".Ammount";
				customConfig.addDefault(customfireworks4, 16);
				String customfireworks6 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".CanBePickedUp";
				customConfig.addDefault(customfireworks6, true);
				String customfireworks7 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".SetAlight";
				customConfig.addDefault(customfireworks7, false);

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
			
			while (customConfig.getBoolean(
					"Custom.Firework" + cfmob
						+ ".Mob" + idnumbermob + ".use") == true) {
				idnumbermob = idnumbermob + 1;
				
				String customfireworks8 = "Custom.Firework" + cfmob
						+ ".Mob" + idnumbermob + ".use";
				customConfig.addDefault(customfireworks8, false);
				String customfireworks9 = "Custom.Firework" + cfmob
						+ ".Mob" + idnumbermob + ".Mobname";
				customConfig.addDefault(customfireworks9, "PIG");
				String customfireworks10 = "Custom.Firework" + cfmob
						+ ".Mob" + idnumbermob + ".Ammount";
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
			
			while (customConfig.getBoolean(
					"Custom.Firework" + cf3mob
						+ ".Mob" + idnumber2mob + ".use") == true) {
				
				String mobid;	
				mobid = customConfig.getString("Custom.Firework" + cf3mob + ".Mob" + idnumber2mob + ".Mobname").toUpperCase();
				
				correct54mob = 1;	

				if (mobid.equals("BLAZE")) {									
					correct54mob = 0;									
				}	
				if (mobid.equals("CAVE_SPIDER")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("CAVESPIDER")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
						+ ".Mob" + idnumber2mob + ".Mobname", "CAVE_SPIDER");
					System.out.println("[ColourFireWorks] Renamed CAVESPIDER to CAVE_SPIDER");
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
						System.out.println("[ColourFireWorks] Warning, an ENDER_DRAGON is in use");
				}
				if (mobid.equals("ENDERDRAGON")) {									
					correct54mob = 0;		
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "ENDER_DRAGON");
					System.out.println("[ColourFireWorks] Renamed ENDERDRAGON to ENDER_DRAGON");
						System.out.println("[ColourFireWorks] Warning, an ENDER_DRAGON is in use");
				}
				if (mobid.equals("ENDERMAN")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("ENDERMEN")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "ENDERMAN");
						System.out.println("[ColourFireWorks] Renamed ENDERMEN to ENDERMAN");
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
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "MAGMA_CUBE");
						System.out.println("[ColourFireWorks] Renamed MAGMACUBE to MAGMA_CUBE");
				}
				if (mobid.equals("MUSHROOM_COW")) {									
					correct54mob = 0;		
				}
				if (mobid.equals("MUSHROOMCOW")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "MUSHROOM_COW");
						System.out.println("[ColourFireWorks] Renamed MUSHROOMCOW to MUSHROOM_COW");
				}
				if (mobid.equals("MOOSHROOM")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "MUSHROOM_COW");
						System.out.println("[ColourFireWorks] Renamed MOOSHROOM to MUSHROOM_COW");
				}
				if (mobid.equals("PIG")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("PIG_ZOMBIE")) {									
					correct54mob = 0;		
				}
				if (mobid.equals("PIGZOMBIE")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
						System.out.println("[ColourFireWorks] Renamed PIGZOMBIE to PIG_ZOMBIE");
				}
				if (mobid.equals("PIGMAN")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
						System.out.println("[ColourFireWorks] Renamed PIGMAN to PIG_ZOMBIE");
				}
				if (mobid.equals("PIG_MAN")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
						System.out.println("[ColourFireWorks] Renamed PIG_MAN to PIG_ZOMBIE");
				}
				if (mobid.equals("SHEEP")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("SILVERFISH")) {									
					correct54mob = 0;		
				}
				if (mobid.equals("SILVER_FISH")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SILVERFISH");
						System.out.println("[ColourFireWorks] Renamed SILVER_FISH to SILVERFISH");
				}
				if (mobid.equals("SILVER")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SILVERFISH");
						System.out.println("[ColourFireWorks] Renamed SILVER to SILVERFISH");
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
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
						System.out.println("[ColourFireWorks] Renamed SNOW_MAN to SNOWMAN");
				}
				if (mobid.equals("SNOWGOLEM")) {									
					correct54mob = 0;		
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
						System.out.println("[ColourFireWorks] Renamed SNOWGOLEM to SNOWMAN");
				}
				if (mobid.equals("SNOW_GOLEM")) {									
					correct54mob = 0;		
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
						System.out.println("[ColourFireWorks] Renamed SNOW_GOLEM to SNOWMAN");
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
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "VILLAGER");
						System.out.println("[ColourFireWorks] Renamed NPC to VILLAGER");
				}
				if (mobid.equals("HUMAN")) {									
					correct54mob = 0;		
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "VILLAGER");
						System.out.println("[ColourFireWorks] Renamed HUMAN to VILLAGER");
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
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
						System.out.println("[ColourFireWorks] Renamed CAT to OCELOT");
				}
				
				if (mobid.equals("KITTEN")) {									
					correct54mob = 0;			
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
						System.out.println("[ColourFireWorks] Renamed KITTEN to OCELOT");
				}
				if (mobid.equals("CHEETA")) {									
					correct54mob = 0;		
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
						System.out.println("[ColourFireWorks] Renamed CHEETA to OCELOT");
				}
				if (mobid.equals("IRON_GOLEM")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("IRON")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "IRON_GOLEM");
						System.out.println("[ColourFireWorks] Renamed IRON to IRONGOLEM");
				}
				if (mobid.equals("IRONGOLEM")) {									
					correct54mob = 0;	
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "IRON_GOLEM");
						System.out.println("[ColourFireWorks] Renamed IRONGOLEM to IRON_GOLEM");
				}
				if (correct54mob == 1) {
					
					String whatisitthen;
					whatisitthen = getConfig().getString("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname");
					
					customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "PIG");
					System.out.println("[ColourFireWorks] Error in CustomFireWork" + cf3mob + " | Mob" + idnumber2mob);
					System.out.println("[ColourFireWorks] " + whatisitthen + " Is not a known Mob, Reset to PIG");
					
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

			while (customConfig.getBoolean(
					"Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber2
							+ ".use") == true) {
				
				
				int itemid;	
				itemid = customConfig.getInt(
					"Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber2
							+ ".ItemID");
				

				
				if (itemid > 385) {					
					if (itemid < 2256) {
						System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
						correct54 = 1;
					}
					
				}
				
				if (itemid > 122) {					
					if (itemid < 256) {
						System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
						correct54 = 1;
					}
					
				}
				
				if (itemid < 0) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
					correct54 = 1;
				}
				
				if (itemid > 2256) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
					correct54 = 1;
				}
				
				if (itemid == 62) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " A Lit Furnace can not be used!");
					correct54 = 1;
				}				
				if (itemid == 74) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Glowing Redstone Ore can not be used!");
					correct54 = 1;
				}
				if (itemid == 93 || itemid == 94)  {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " A Dioide Block can not be used!");
					correct54 = 1;
				}
				if (itemid == 117) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Brewing Stands Blocks can not be used!");
					correct54 = 1;
				}
				if (itemid == 118) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Cauldron Block can not be used!");
					correct54 = 1;
				}
				if (itemid == 119) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " End Portal can not be used!");
					correct54 = 1;
				}
				if (itemid == 120) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " End Portal Frame can not be used!");
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
		if (commandName.equals("colourfireworks")
				|| (commandName.equals("colourfirework")
						|| (commandName.equals("colorfireworks")) || (commandName
							.equals("colorfirework")))) {

			if (args.length == 0) {
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
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");
			}

			if (args.length > 1) {

				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");
				sender.sendMessage(ChatColor.GOLD + "ColourFireWorks");
				sender.sendMessage(ChatColor.GOLD + "Created By Craftiii4");
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");
				sender.sendMessage(ChatColor.DARK_PURPLE + "Commands:");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks"
						+ ChatColor.GREEN + " - Shows the credits");
				sender.sendMessage(ChatColor.BLUE + "/colourfireworks reload"
						+ ChatColor.GREEN + " - Reloads the config file");
				sender.sendMessage(ChatColor.WHITE
						+ "--------------------------------------------------");

			}

			if (args.length == 1) {

				String reload;
				reload = args[0];
				
				//if (reload.equalsIgnoreCase("dropparty") || (reload.equalsIgnoreCase("dp")||(reload.equalsIgnoreCase("drop")))) {
					
				//	if (player.hasPermission("colourfirework.dropparty") || (player.hasPermission("colourfirework.*")
				//			|| (player
				//					.isOp()))) {
						
				//		player.sendMessage(ChatColor.GREEN
				//				+ "Please place a chest");
						
				//		colourfireworks.droppartychestplace.put(player.getName(), true);
						
						
				//	} else {
				//		player.sendMessage(ChatColor.RED
				//				+ "You can not create drop partys!");
				//	}
					
					
				//}

				if (reload.equalsIgnoreCase("reload")) {
					
					
					

					if (player.hasPermission("colourfireworks.reload") || (player.hasPermission("colourfirework.*")
							|| (player.hasPermission("colourfirework.reload") || (player
									.isOp())))) {
						
						

						System.out.println("[ColourFireWorks] "
								+ player.getName() + " Is reloading config");
						player.sendMessage(ChatColor.GREEN
								+ "Reloading ColourFireWorks!");
						reloadConfig();
						reloadCustomConfig();
						int tickcheck;
						tickcheck = getConfig().getInt("Fireworks.Dye.Remove.Ticks");
						
						if (tickcheck < 0) {						
								System.out.println("[ColourFireWorks] Error, Remove Ticks Below 0, set to default");
								getConfig().set("Fireworks.Dye.Remove.Ticks", 30);
							
						}
						
						if (tickcheck > 600) {						
							System.out.println("[ColourFireWorks] Error, Remove Ticks Above 600 (30 sec), set to default");
							getConfig().set("Fireworks.Dye.Remove.Ticks", 30);
						
					}
						
						
						int iteminhandcheck;
						iteminhandcheck = getConfig().getInt("Fireworks.ItemIdNeededInHand");
						
						if (iteminhandcheck > 385) {					
							if (iteminhandcheck < 2266) {
								System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
								getConfig().set("Fireworks.ItemIdNeededInHand", 288);
							}
							
						}
						
						if (iteminhandcheck > 124) {					
							if (iteminhandcheck < 256) {
								System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
								getConfig().set("Fireworks.ItemIdNeededInHand", 288);
							}
							
						}
						
						if (iteminhandcheck < 0) {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}
						
						if (iteminhandcheck > 2266) {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}
						
						if (iteminhandcheck == 62) {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}				
						if (iteminhandcheck == 74) {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}
						if (iteminhandcheck == 93 || iteminhandcheck == 94)  {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}
						if (iteminhandcheck == 117) {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}
						if (iteminhandcheck == 118) {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}
						if (iteminhandcheck == 119) {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}
						if (iteminhandcheck == 120) {
							System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
							getConfig().set("Fireworks.ItemIdNeededInHand", 288);
						}
						
						int fireworkdyeammountcheck;
						fireworkdyeammountcheck = getConfig().getInt("Fireworks.Dye.Drops");
						
						if (fireworkdyeammountcheck > 128) {			
							System.out.println("[ColourFireWorks] Error, Dye Drops above 128, set to default");
							getConfig().set("Fireworks.Dye.Drops", 24);			
						}
						if (fireworkdyeammountcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, Dye Drops below 0, set to default");
							getConfig().set("Fireworks.Dye.Drops", 24);			
						}
						
						int pumpkinammountcheck;
						pumpkinammountcheck = getConfig().getInt("Fireworks.Pumpkin.Drops");
						
						if (pumpkinammountcheck > 256) {			
							System.out.println("[ColourFireWorks] Error, Pumpkin Drops above 256, set to default");
							getConfig().set("Fireworks.Pumpkin.Drops", 32);			
						}
						if (pumpkinammountcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, Pumpkin Drops below 0, set to default");
							getConfig().set("Fireworks.Pumpkin.Drops", 32);			
						}
						
						int spiderammountcheck;
						spiderammountcheck = getConfig().getInt("Fireworks.Pumpkin.Spiders");
						
						if (spiderammountcheck > 32) {			
							System.out.println("[ColourFireWorks] Error, Spiders to spawn above 32, set to default");
							getConfig().set("Fireworks.Pumpkin.Spiders", 4);			
						}
						if (spiderammountcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, Spiders to spawn below 0, set to default");
							getConfig().set("Fireworks.Pumpkin.Spiders", 4);			
						}
						
						int fireworkheightcheck;
						fireworkheightcheck = getConfig().getInt("Fireworks.Height");
						
						if (fireworkheightcheck > 16) {			
							System.out.println("[ColourFireWorks] Error, Firework Height above 16, set to default");
							getConfig().set("Fireworks.Height", 1.5);			
						}
						if (fireworkheightcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, Fireworks Height below 0, set to default");
							getConfig().set("Fireworks.Height", 1.5);			
						}
						
						int snowammountcheck;
						snowammountcheck = getConfig().getInt("Fireworks.Snow.Drops.Snowball");
						
						if (snowammountcheck > 256) {			
							System.out.println("[ColourFireWorks] Error, Snow Ball Drops above 256, set to default");
							getConfig().set("Fireworks.Snow.Drops.Snowball", 24);			
						}
						if (snowammountcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, Snow Ball Drops below 0, set to default");
							getConfig().set("Fireworks.Snow.Drops.Snowball", 24);			
						}
						
						int diamondammountcheck;
						diamondammountcheck = getConfig().getInt("Fireworks.Snow.Drops.Diamond");
						
						if (diamondammountcheck > 256) {			
							System.out.println("[ColourFireWorks] Error, Diamond Drops above 256, set to default");
							getConfig().set("Fireworks.Snow.Drops.Diamond", 6);			
						}
						if (diamondammountcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, Diamond Drops below 0, set to default");
							getConfig().set("Fireworks.Snow.Drops.Diamond", 6);			
						}
						
						int goldammountcheck;
						goldammountcheck = getConfig().getInt("Fireworks.Snow.Drops.Gold");
						
						if (goldammountcheck > 256) {			
							System.out.println("[ColourFireWorks] Error, Gold Drops above 256, set to default");
							getConfig().set("Fireworks.Snow.Drops.Gold", 12);			
						}
						if (goldammountcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, Gold Drops below 0, set to default");
							getConfig().set("Fireworks.Snow.Drops.Gold", 12);			
						}
						
						int snowmenammountcheck;
						snowmenammountcheck = getConfig().getInt("Fireworks.Snow.SnowMen");
						
						if (snowmenammountcheck > 32) {			
							System.out.println("[ColourFireWorks] Error, SnowMen above 32, set to default");
							getConfig().set("Fireworks.Snow.SnowMen", 4);			
						}
						if (snowmenammountcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, SnowMen below 0, set to default");
							getConfig().set("Fireworks.Snow.SnowMen", 4);			
						}
						
						int itemspreadcheck;
						itemspreadcheck = getConfig().getInt("Fireworks.Snow.ItemSpread");
						
						if (itemspreadcheck > 16) {			
							System.out.println("[ColourFireWorks] Error, SnowBlock Item Spread above 16, set to default");
							getConfig().set("Fireworks.Snow.ItemSpread", 4);			
						}
						if (itemspreadcheck < 0) {			
							System.out.println("[ColourFireWorks] Error, SnowBlock Item Spread below 0, set to default");
							getConfig().set("Fireworks.Snow.ItemSpread", 4);			
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
							
							String customfireworksmessage = "Custom.Firework" + cf + ".LaunchMessage";
							customConfig.addDefault(customfireworksmessage, "The Firework Goes off!");

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
							String customfireworks4 = "Custom.Firework" + cf
									+ ".ItemsDroped.ID1.Ammount";
							customConfig.addDefault(customfireworks4, 16);
							String customfireworks6 = "Custom.Firework" + cf
									+ ".ItemsDroped.ID1.CanBePickedUp";
							customConfig.addDefault(customfireworks6, true);
							String customfireworks7 = "Custom.Firework" + cf
									+ ".ItemsDroped.ID1.SetAlight";
							customConfig.addDefault(customfireworks7, false);

							String customfireworks8 = "Custom.Firework" + cf
									+ ".Mob1.use";
							customConfig.addDefault(customfireworks8, false);
							String customfireworks9 = "Custom.Firework" + cf
									+ ".Mob1.Mobname";
							customConfig.addDefault(customfireworks9, "PIG");
							String customfireworks10 = "Custom.Firework" + cf
									+ ".Mob1.Ammount";
							customConfig.addDefault(customfireworks10, 1);
							String customfireworks12 = "Custom.Firework" + cf
									+ ".ExpOrp.Ammount";				
							customConfig.addDefault(customfireworks12, 0);
							String customfireworks13 = "Custom.Firework" + cf
									+ ".ExpOrp.Value";				
							customConfig.addDefault(customfireworks13, 0);
						}
						
						int addnew1 = 1;
						
						while (customConfig.getBoolean("Custom.Firework" + addnew1 + ".use") == true) {
							
							if (customConfig.contains("Custom.Firework" + addnew1
									+ ".FireworkBlockID-Raw-Data") == false) {
								String customfireworksnew01 = "Custom.Firework" + addnew1
										+ ".FireworkBlockID-Raw-Data";
								customConfig.addDefault(customfireworksnew01, -1);
								
							}
							if (customConfig.contains("Custom.Firework" + addnew1 + ".LaunchMessage") == false) {
								String customfireworksnew02 = "Custom.Firework" + addnew1 + ".LaunchMessage";
								customConfig.addDefault(customfireworksnew02, "The Firework Goes off!");
								
							}
							
							
							addnew1 = addnew1 + 1;
							
						}
						
						int addnew2 = 1;
						
						while (customConfig.contains("Custom.Firework" + addnew2 + ".use") == true) {
							
							
							if (customConfig.contains("Custom.Firework" + addnew2
									+ ".ExpOrp.Ammount") == false) {
								
								String customfireworks12 = "Custom.Firework" + addnew2
										+ ".ExpOrp.Ammount";				
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
							
							String customfireworksmessage = "Custom.Firework" + cf + ".LaunchMessage";
							customConfig.addDefault(customfireworksmessage, "The Firework Goes off!");

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
							String customfireworks4 = "Custom.Firework" + cf
									+ ".ItemsDroped.ID1.Ammount";
							customConfig.addDefault(customfireworks4, 16);
							String customfireworks6 = "Custom.Firework" + cf
									+ ".ItemsDroped.ID1.CanBePickedUp";
							customConfig.addDefault(customfireworks6, true);
							String customfireworks7 = "Custom.Firework" + cf
									+ ".ItemsDroped.ID1.SetAlight";
							customConfig.addDefault(customfireworks7, false);
							
							String customfireworks8 = "Custom.Firework" + cf
									+ ".Mob1.use";
							customConfig.addDefault(customfireworks8, false);
							String customfireworks9 = "Custom.Firework" + cf
									+ ".Mob1.Mobname";
							customConfig.addDefault(customfireworks9, "PIG");
							String customfireworks10 = "Custom.Firework" + cf
									+ ".Mob1.Ammount";
							customConfig.addDefault(customfireworks10, 1);
							String customfireworks12 = "Custom.Firework" + cf
									+ ".ExpOrp.Ammount";				
							customConfig.addDefault(customfireworks12, 0);
							String customfireworks13 = "Custom.Firework" + cf
									+ ".ExpOrp.Value";				
							customConfig.addDefault(customfireworks13, 0);

						}
						
						
						int firework;
						firework = 1;

						
						while (customConfig.contains("Custom.Firework" + firework + ".use") == true) {
							
							
							int blockid = customConfig.getInt("Custom.Firework" + firework
									+ ".FireworkBlockID");
							
							if (blockid == 35) {
								System.out.println("[ColourFireWorks] Wool Blocks not allowed! Changing to -1");
								customConfig.set("Custom.Firework" + firework
										+ ".FireworkBlockID", -1);
								System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
							}
										
							if (blockid == 80) {
								System.out.println("[ColourFireWorks] Snow Blocks not allowed! Changing to -1");
								customConfig.set("Custom.Firework" + firework
										+ ".FireworkBlockID", -1);
								System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
							}
							
							if (blockid == 86) {
								System.out.println("[ColourFireWorks] Pumpkin Blocks not allowed! Changing to -1");
								customConfig.set("Custom.Firework" + firework
										+ ".FireworkBlockID", -1);
								System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
							}
							
							firework = firework + 1;

						}
						
						

						int cf2;
						cf2 = 1;
						int idnumber;
						idnumber = 1;

						while (customConfig.contains("Custom.Firework" + cf2 + ".use") == true) {
							
							idnumber = 1;
							
							while (customConfig.getBoolean(
									"Custom.Firework" + cf2 + ".ItemsDroped.ID" + idnumber
											+ ".use") == true) {
								idnumber = idnumber + 1;
								String customfireworks5 = "Custom.Firework" + cf2
										+ ".ItemsDroped.ID" + idnumber + ".use";
								customConfig.addDefault(customfireworks5, false);
								String customfireworks3 = "Custom.Firework" + cf2
										+ ".ItemsDroped.ID" + idnumber + ".ItemID";
								customConfig.addDefault(customfireworks3, 1);
								String customfireworks4 = "Custom.Firework" + cf2
										+ ".ItemsDroped.ID" + idnumber + ".Ammount";
								customConfig.addDefault(customfireworks4, 16);
								String customfireworks6 = "Custom.Firework" + cf2
										+ ".ItemsDroped.ID" + idnumber + ".CanBePickedUp";
								customConfig.addDefault(customfireworks6, true);
								String customfireworks7 = "Custom.Firework" + cf2
										+ ".ItemsDroped.ID" + idnumber + ".SetAlight";
								customConfig.addDefault(customfireworks7, false);

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
							
							while (customConfig.getBoolean(
									"Custom.Firework" + cfmob
										+ ".Mob" + idnumbermob + ".use") == true) {
								idnumbermob = idnumbermob + 1;
								
								String customfireworks8 = "Custom.Firework" + cfmob
										+ ".Mob" + idnumbermob + ".use";
								customConfig.addDefault(customfireworks8, false);
								String customfireworks9 = "Custom.Firework" + cfmob
										+ ".Mob" + idnumbermob + ".Mobname";
								customConfig.addDefault(customfireworks9, "PIG");
								String customfireworks10 = "Custom.Firework" + cfmob
										+ ".Mob" + idnumbermob + ".Ammount";
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
							
							while (customConfig.getBoolean(
									"Custom.Firework" + cf3mob
										+ ".Mob" + idnumber2mob + ".use") == true) {
								
								String mobid;	
								mobid = customConfig.getString("Custom.Firework" + cf3mob + ".Mob" + idnumber2mob + ".Mobname").toUpperCase();
								
								correct54mob = 1;	

								if (mobid.equals("BLAZE")) {									
									correct54mob = 0;									
								}	
								if (mobid.equals("CAVE_SPIDER")) {									
									correct54mob = 0;									
								}
								if (mobid.equals("CAVESPIDER")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
										+ ".Mob" + idnumber2mob + ".Mobname", "CAVE_SPIDER");
									System.out.println("[ColourFireWorks] Renamed CAVESPIDER to CAVE_SPIDER");									
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
										System.out.println("[ColourFireWorks] Warning, an ENDER_DRAGON is in use");
								}
								if (mobid.equals("ENDERDRAGON")) {									
									correct54mob = 0;		
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "ENDER_DRAGON");
									System.out.println("[ColourFireWorks] Renamed ENDERDRAGON to ENDER_DRAGON");
										System.out.println("[ColourFireWorks] Warning, an ENDER_DRAGON is in use");
								}
								if (mobid.equals("ENDERMAN")) {									
									correct54mob = 0;									
								}
								if (mobid.equals("ENDERMEN")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "ENDERMAN");
										System.out.println("[ColourFireWorks] Renamed ENDERMEN to ENDERMAN");
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
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "MAGMA_CUBE");
										System.out.println("[ColourFireWorks] Renamed MAGMACUBE to MAGMA_CUBE");
								}
								if (mobid.equals("MUSHROOM_COW")) {									
									correct54mob = 0;		
								}
								if (mobid.equals("MUSHROOMCOW")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "MUSHROOM_COW");
										System.out.println("[ColourFireWorks] Renamed MUSHROOMCOW to MUSHROOM_COW");
								}
								if (mobid.equals("MOOSHROOM")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "MUSHROOM_COW");
										System.out.println("[ColourFireWorks] Renamed MOOSHROOM to MUSHROOM_COW");
								}
								if (mobid.equals("PIG")) {									
									correct54mob = 0;									
								}
								if (mobid.equals("PIG_ZOMBIE")) {									
									correct54mob = 0;		
								}
								if (mobid.equals("PIGZOMBIE")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
										System.out.println("[ColourFireWorks] Renamed PIGZOMBIE to PIG_ZOMBIE");
								}
								if (mobid.equals("PIGMAN")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
										System.out.println("[ColourFireWorks] Renamed PIGMAN to PIG_ZOMBIE");
								}
								if (mobid.equals("PIG_MAN")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
										System.out.println("[ColourFireWorks] Renamed PIG_MAN to PIG_ZOMBIE");
								}
								if (mobid.equals("SHEEP")) {									
									correct54mob = 0;									
								}
								if (mobid.equals("SILVERFISH")) {									
									correct54mob = 0;		
								}
								if (mobid.equals("SILVER_FISH")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "SILVERFISH");
										System.out.println("[ColourFireWorks] Renamed SILVER_FISH to SILVERFISH");
								}
								if (mobid.equals("SILVER")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "SILVERFISH");
										System.out.println("[ColourFireWorks] Renamed SILVER to SILVERFISH");
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
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
										System.out.println("[ColourFireWorks] Renamed SNOW_MAN to SNOWMAN");
								}
								if (mobid.equals("SNOWGOLEM")) {									
									correct54mob = 0;		
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
										System.out.println("[ColourFireWorks] Renamed SNOWGOLEM to SNOWMAN");
								}
								if (mobid.equals("SNOW_GOLEM")) {									
									correct54mob = 0;		
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
										System.out.println("[ColourFireWorks] Renamed SNOW_GOLEM to SNOWMAN");
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
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "VILLAGER");
										System.out.println("[ColourFireWorks] Renamed NPC to VILLAGER");
								}
								if (mobid.equals("HUMAN")) {									
									correct54mob = 0;		
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "VILLAGER");
										System.out.println("[ColourFireWorks] Renamed HUMAN to VILLAGER");
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
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
										System.out.println("[ColourFireWorks] Renamed CAT to OCELOT");
								}
								
								if (mobid.equals("KITTEN")) {									
									correct54mob = 0;			
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
										System.out.println("[ColourFireWorks] Renamed KITTEN to OCELOT");
								}
								if (mobid.equals("CHEETA")) {									
									correct54mob = 0;		
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
										System.out.println("[ColourFireWorks] Renamed CHEETA to OCELOT");
								}
								if (mobid.equals("IRON_GOLEM")) {									
									correct54mob = 0;									
								}
								if (mobid.equals("IRON")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "IRON_GOLEM");
										System.out.println("[ColourFireWorks] Renamed IRON to IRONGOLEM");
								}
								if (mobid.equals("IRONGOLEM")) {									
									correct54mob = 0;	
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "IRON_GOLEM");
										System.out.println("[ColourFireWorks] Renamed IRONGOLEM to IRON_GOLEM");
								}
								
								if (correct54mob == 1) {
									
									String whatisitthen;
									whatisitthen = customConfig.getString("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname");
									
									customConfig.set("Custom.Firework" + cf3mob
											+ ".Mob" + idnumber2mob + ".Mobname", "PIG");
										System.out.println("[ColourFireWorks] " + whatisitthen + " Is not a known Mob, Reset to PIG");
										System.out.println("[ColourFireWorks] Error in CustomFireWork" + cf3mob + " | Mob" + idnumber2mob);
									
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

							while (customConfig.getBoolean(
									"Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber2
											+ ".use") == true) {
								
								
								int itemid;	
								itemid = customConfig.getInt(
									"Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber2
											+ ".ItemID");
								

								
								if (itemid > 385) {					
									if (itemid < 2256) {
										System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
										correct54 = 1;
									}
									
								}
								
								if (itemid > 122) {					
									if (itemid < 256) {
										System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
										correct54 = 1;
									}
									
								}
								
								if (itemid < 0) {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
									correct54 = 1;
								}
								
								if (itemid > 2256) {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
									correct54 = 1;
								}
								
								if (itemid == 62) {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " A Lit Furnace can not be used!");
									correct54 = 1;
								}				
								if (itemid == 74) {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Glowing Redstone Ore can not be used!");
									correct54 = 1;
								}
								if (itemid == 93 || itemid == 94)  {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " A Dioide Block can not be used!");
									correct54 = 1;
								}
								if (itemid == 117) {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Brewing Stands Blocks can not be used!");
									correct54 = 1;
								}
								if (itemid == 118) {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Cauldron Block can not be used!");
									correct54 = 1;
								}
								if (itemid == 119) {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " End Portal can not be used!");
									correct54 = 1;
								}
								if (itemid == 120) {
									System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " End Portal Frame can not be used!");
									correct54 = 1;
								}
											

								idnumber2 = idnumber2 + 1;

							}

							idnumber2 = 1;
							cf3 = cf3 + 1;
						}
						
						if (correct54 == 1) {
							System.out.println("[ColourFireWorks] Error ITEM_CHECK_FAIL");
							player.sendMessage(ChatColor.RED
									+ "[ColourFireWorks] Error ITEM_CHECK_FAIL");
							player.sendMessage(ChatColor.RED
									+ "[ColourFireWorks] DISABLING");
							Bukkit.getPluginManager().disablePlugin(this);
							player.sendMessage(ChatColor.RED
									+ "[ColourFireWorks] DISABLED");
						} else {

							getConfig().options().copyDefaults(true);
							saveConfig();
							this.getCustomConfig().options().copyDefaults(true);		
							saveCustomConfig();
							player.sendMessage(ChatColor.GREEN
									+ "ColourFireWorks Reloaded!");
							System.out
									.println("[ColourFireWorks] Config Loaded");
						}

					} else {
						player.sendMessage(ChatColor.RED
								+ "You do not have permission to do that!");
					}
				} else {
					sender.sendMessage(ChatColor.GREEN + "Did you mean"
							+ ChatColor.BLUE + " '/colourfireworks reload'"
							+ ChatColor.GREEN + "?");
				}

			}
		}
		return false;

	}


}
	
	

