package me.craftiii4.colourfireworks.api;

import me.craftiii4.colourfireworks.colourfireworks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ReloadCommand {
	
	public static void RunReloadCommand(final colourfireworks plugin, final Player player) {
		
		System.out.println("[ColourFireWorks] "
				+ player.getName() + " Is reloading config");
		player.sendMessage(ChatColor.GREEN
				+ "Reloading ColourFireWorks!");
		plugin.reloadConfig();
		plugin.reloadCustomConfig();
		plugin.reloadDropPartyConfig();
		plugin.reloadEconomyConfig();
		int tickcheck;
		tickcheck = plugin.getConfig().getInt("Fireworks.Dye.Remove.Ticks");
		
		colourfireworks.Max.put("Max", plugin.getdroppartyConfig().getInt("DropParty.Max"));
		
		if (tickcheck < 0) {						
				System.out.println("[ColourFireWorks] Error, Remove Ticks is Below 0, set to default");
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Remove Ticks is Below 0, set to default");
				plugin.getConfig().set("Fireworks.Dye.Remove.Ticks", 30);
			
		}
		
		if (tickcheck > 600) {						
			System.out.println("[ColourFireWorks] Error, Remove Ticks Above 600 (30 sec), set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Remove Ticks Above 600 (30 sec), set to default");
			plugin.getConfig().set("Fireworks.Dye.Remove.Ticks", 30);
		
		}
		
		
		int iteminhandcheck;
		iteminhandcheck = plugin.getConfig().getInt("Fireworks.ItemIdNeededInHand");
		
		if (iteminhandcheck > 385) {					
			if (iteminhandcheck < 2266) {
				System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
				plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
			}
			
		}
		
		if (iteminhandcheck > 124) {					
			if (iteminhandcheck < 256) {
				System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
				plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
			}
			
		}
		
		if (iteminhandcheck < 0) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		
		if (iteminhandcheck > 2266) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		
		if (iteminhandcheck == 62) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}				
		if (iteminhandcheck == 74) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 93 || iteminhandcheck == 94)  {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 117) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 118) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 119) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		if (iteminhandcheck == 120) {
			System.out.println("[ColourFireWorks] Error, Item needed in hand is not reconised, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item needed in hand is not reconised, set to default");
			plugin.getConfig().set("Fireworks.ItemIdNeededInHand", 288);
		}
		
		int fireworkdyeammountcheck;
		fireworkdyeammountcheck = plugin.getConfig().getInt("Fireworks.Dye.Drops");
		
		if (fireworkdyeammountcheck > 128) {			
			System.out.println("[ColourFireWorks] Error, Dye Drops above 128, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Dye Drops above 128, set to default");
			plugin.getConfig().set("Fireworks.Dye.Drops", 24);			
		}
		if (fireworkdyeammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Dye Drops below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Dye Drops below 0, set to default");
			plugin.getConfig().set("Fireworks.Dye.Drops", 24);			
		}
		
		int pumpkinammountcheck;
		pumpkinammountcheck = plugin.getConfig().getInt("Fireworks.Pumpkin.Drops");
		
		if (pumpkinammountcheck > 256) {			
			System.out.println("[ColourFireWorks] Error, Pumpkin Drops above 256, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Pumpkin Drops above 256, set to default");
			plugin.getConfig().set("Fireworks.Pumpkin.Drops", 32);			
		}
		if (pumpkinammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Pumpkin Drops below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Pumpkin Drops below 0, set to default");
			plugin.getConfig().set("Fireworks.Pumpkin.Drops", 32);			
		}
		
		int spiderammountcheck;
		spiderammountcheck = plugin.getConfig().getInt("Fireworks.Pumpkin.Spiders");
		
		if (spiderammountcheck > 32) {			
			System.out.println("[ColourFireWorks] Error, Spiders to spawn above 32, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Spiders to spawn above 32, set to default");
			plugin.getConfig().set("Fireworks.Pumpkin.Spiders", 4);			
		}
		if (spiderammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Spiders to spawn below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Spiders to spawn below 0, set to default");
			plugin.getConfig().set("Fireworks.Pumpkin.Spiders", 4);			
		}		
		
		int pumpkinfireworkheightcheck;
		pumpkinfireworkheightcheck = plugin.getConfig().getInt("Fireworks.Pumpkin.Height");
		
		if (pumpkinfireworkheightcheck > 16) {			
			System.out.println("[ColourFireWorks] Error, Pumpkin Firework Height above 16, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Pumpkin Firework Height above 16, set to default");
			plugin.getConfig().set("Fireworks.Pumpkin.Height", 1.5);			
		}
		if (pumpkinfireworkheightcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Pumpkin Fireworks Height below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Pumpkin Fireworks Height below 0, set to default");
			plugin.getConfig().set("Fireworks.Pumpkin.Height", 1.5);			
		}
		
		int snowfireworkheightcheck;
		snowfireworkheightcheck = plugin.getConfig().getInt("Fireworks.Snow.Height");
		
		if (snowfireworkheightcheck > 16) {			
			System.out.println("[ColourFireWorks] Error, Snow Firework Height above 16, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Snow Firework Height above 16, set to default");
			plugin.getConfig().set("Fireworks.Snow.Height", 1.5);			
		}
		if (snowfireworkheightcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Snow Fireworks Height below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Snow Fireworks Height below 0, set to default");
			plugin.getConfig().set("Fireworks.Snow.Height", 1.5);			
		}
		
		int woolfireworkheightcheck;
		woolfireworkheightcheck = plugin.getConfig().getInt("Fireworks.Dye.Height");
		
		if (woolfireworkheightcheck > 16) {			
			System.out.println("[ColourFireWorks] Error, Wool Firework Height above 16, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Wool Firework Height above 16, set to default");
			plugin.getConfig().set("Fireworks.Dye.Height", 1.5);			
		}
		if (woolfireworkheightcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Wool Fireworks Height below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Wool Fireworks Height below 0, set to default");
			plugin.getConfig().set("Fireworks.Dye.Height", 1.5);			
		}
		
		
		
		
		
		
		int snowammountcheck;
		snowammountcheck = plugin.getConfig().getInt("Fireworks.Snow.Drops.Snowball");
		
		if (snowammountcheck > 256) {			
			System.out.println("[ColourFireWorks] Error, Snow Ball Drops above 256, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Snow Ball Drops above 256, set to default");
			plugin.getConfig().set("Fireworks.Snow.Drops.Snowball", 24);			
		}
		if (snowammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Snow Ball Drops below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Snow Ball Drops below 0, set to default");
			plugin.getConfig().set("Fireworks.Snow.Drops.Snowball", 24);			
		}
		
		int diamondammountcheck;
		diamondammountcheck = plugin.getConfig().getInt("Fireworks.Snow.Drops.Diamond");
		
		if (diamondammountcheck > 256) {			
			System.out.println("[ColourFireWorks] Error, Diamond Drops above 256, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Diamond Drops above 256, set to default");
			plugin.getConfig().set("Fireworks.Snow.Drops.Diamond", 6);			
		}
		if (diamondammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Diamond Drops below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Diamond Drops below 0, set to default");
			plugin.getConfig().set("Fireworks.Snow.Drops.Diamond", 6);			
		}
		
		int goldammountcheck;
		goldammountcheck = plugin.getConfig().getInt("Fireworks.Snow.Drops.Gold");
		
		if (goldammountcheck > 256) {			
			System.out.println("[ColourFireWorks] Error, Gold Drops above 256, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Gold Drops above 256, set to default");
			plugin.getConfig().set("Fireworks.Snow.Drops.Gold", 12);			
		}
		if (goldammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Gold Drops below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Gold Drops below 0, set to default");
			plugin.getConfig().set("Fireworks.Snow.Drops.Gold", 12);			
		}
		
		int snowmenammountcheck;
		snowmenammountcheck = plugin.getConfig().getInt("Fireworks.Snow.SnowMen");
		
		if (snowmenammountcheck > 32) {			
			System.out.println("[ColourFireWorks] Error, SnowMen above 32, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, SnowMen above 32, set to default");
			plugin.getConfig().set("Fireworks.Snow.SnowMen", 4);			
		}
		if (snowmenammountcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, SnowMen below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, SnowMen below 0, set to default");
			plugin.getConfig().set("Fireworks.Snow.SnowMen", 4);			
		}
		
		int snowitemspreadcheck;
		snowitemspreadcheck = plugin.getConfig().getInt("Fireworks.Snow.ItemSpread");
		
		if (snowitemspreadcheck > 16) {			
			System.out.println("[ColourFireWorks] Error, SnowBlock Item Spread above 16, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, SnowBlock Item Spread above 16, set to default");
			plugin.getConfig().set("Fireworks.Snow.ItemSpread", 4);			
		}
		if (snowitemspreadcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, SnowBlock Item Spread below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, SnowBlock Item Spread below 0, set to default");
			plugin.getConfig().set("Fireworks.Snow.ItemSpread", 4);			
		}
		
		int dyeitemspreadcheck;
		dyeitemspreadcheck = plugin.getConfig().getInt("Fireworks.Dye.ItemSpread");
		
		if (dyeitemspreadcheck > 16) {			
			System.out.println("[ColourFireWorks] Error, Dye Item Spread above 16, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Dye Item Spread above 16, set to default");
			plugin.getConfig().set("Fireworks.Dye.ItemSpread", 4);			
		}
		if (dyeitemspreadcheck < 0) {			
			System.out.println("[ColourFireWorks] Error, Dye Item Spread below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Dye Item Spread below 0, set to default");
			plugin.getConfig().set("Fireworks.Dye.ItemSpread", 4);			
		}
		
		int pumpkinitemspreadcheck1;
		pumpkinitemspreadcheck1 = plugin.getConfig().getInt("Fireworks.Pumpkin.ItemSpread");
		
		if (pumpkinitemspreadcheck1 > 16) {			
			System.out.println("[ColourFireWorks] Error, Pumpkin Item Spread above 16, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Pumpkin Item Spread above 16, set to default");
			plugin.getConfig().set("Fireworks.Pumpkin.ItemSpread", 4);			
		}
		if (pumpkinitemspreadcheck1 < 0) {			
			System.out.println("[ColourFireWorks] Error, Pumpkin Item Spread below 0, set to default");
			player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Pumpkin Item Spread below 0, set to default");
			plugin.getConfig().set("Fireworks.Pumpkin.ItemSpread", 4);			
		}

		int cf;
		cf = 1;

		int ticks;
		ticks = 201;

		System.out.println("[ColourFireWorks] Loading Custom Fireworks");

		if (plugin.customConfig.contains("Custom.Firework" + cf + ".use") == false) {
			String customfireworks = "Custom.Firework" + cf + ".use";
			plugin.customConfig.addDefault(customfireworks, false);
			String customfireworksticks = "Custom.Firework" + cf + ".fireticks";
			plugin.customConfig.addDefault(customfireworksticks, 201);
			String customfireworkprice = "Custom.Firework" + cf + ".Price";
			plugin.customConfig.addDefault(customfireworkprice, -1);
			
			String customfireworksmessage = "Custom.Firework" + cf + ".LaunchMessage";
			plugin.customConfig.addDefault(customfireworksmessage, "The Firework Goes off!");

			String customfireworks2 = "Custom.Firework" + cf
					+ ".FireworkBlockID";
			plugin.customConfig.addDefault(customfireworks2, -1);
			String customfireworks11 = "Custom.Firework" + cf
					+ ".FireworkBlockID-Raw-Data";
			plugin.customConfig.addDefault(customfireworks11, -1);

			String customfireworks5 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.use";
			plugin.customConfig.addDefault(customfireworks5, false);
			String customfireworks3 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemID";							
			plugin.customConfig.addDefault(customfireworks3, 1);
			String customfireworks15 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemSubID";
			plugin.customConfig.addDefault(customfireworks15, -1);
			String customfireworks4 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Amount";
			plugin.customConfig.addDefault(customfireworks4, 16);
			String customfireworks6 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.CanBePickedUp";
			plugin.customConfig.addDefault(customfireworks6, true);
			String customfireworks7 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.SetAlight";
			plugin.customConfig.addDefault(customfireworks7, false);
			String customfireworks16 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Enchantment1.Type";
			plugin.customConfig.addDefault(customfireworks16, "NONE");
			String customfireworks17 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Enchantment1.Level";
			plugin.customConfig.addDefault(customfireworks17, 1);
			String customfireworks18 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemSpread";
			plugin.customConfig.addDefault(customfireworks18, 4);

			String customfireworks8 = "Custom.Firework" + cf
					+ ".Mob1.use";
			plugin.customConfig.addDefault(customfireworks8, false);
			String customfireworks9 = "Custom.Firework" + cf
					+ ".Mob1.Mobname";
			plugin.customConfig.addDefault(customfireworks9, "PIG");
			String customfireworks10 = "Custom.Firework" + cf
					+ ".Mob1.Amount";
			plugin.customConfig.addDefault(customfireworks10, 1);
			String customfireworks12 = "Custom.Firework" + cf
					+ ".ExpOrp.Amount";				
			plugin.customConfig.addDefault(customfireworks12, 0);
			String customfireworks13 = "Custom.Firework" + cf
					+ ".ExpOrp.Value";				
			plugin.customConfig.addDefault(customfireworks13, 0);
			
			String customfireworks14 = "Custom.Firework" + cf
					+ ".Height";				
			plugin.customConfig.addDefault(customfireworks14, 1.5);
		}
		
		int addnew12 = 1;
		
		while (plugin.customConfig.getBoolean("Custom.Firework" + addnew12 + ".Height") == true) {
			
			
			if (plugin.customConfig.contains("Custom.Firework" + addnew12
					+ ".Height") == false) {
				String customfireworksnew01 = "Custom.Firework" + addnew12
						+ ".Height";
				plugin.customConfig.addDefault(customfireworksnew01, 1.5);
				
			}			
			
			addnew12++;
			
		}
		
		int addnew1 = 1;
		
		while (plugin.customConfig.getBoolean("Custom.Firework" + addnew1 + ".use") == true) {
			
			if (plugin.customConfig.contains("Custom.Firework" + addnew1
					+ ".FireworkBlockID-Raw-Data") == false) {
				String customfireworksnew01 = "Custom.Firework" + addnew1
						+ ".FireworkBlockID-Raw-Data";
				plugin.customConfig.addDefault(customfireworksnew01, -1);
				
			}
			if (plugin.customConfig.contains("Custom.Firework" + addnew1 + ".LaunchMessage") == false) {
				String customfireworksnew02 = "Custom.Firework" + addnew1 + ".LaunchMessage";
				plugin.customConfig.addDefault(customfireworksnew02, "The Firework Goes off!");
				
			}
			if (plugin.customConfig.contains("Custom.Firework" + addnew1
					+ ".ItemsDroped.ID1.ItemSubID") == false) {
				String customfireworksnew01 = "Custom.Firework" + addnew1
						+ ".ItemsDroped.ID1.ItemSubID";
				plugin.customConfig.addDefault(customfireworksnew01, -1);
				
			}
			
			
			addnew1 = addnew1 + 1;
			
		}
		
		int addnew2 = 1;
		
		while (plugin.customConfig.contains("Custom.Firework" + addnew2 + ".use") == true) {
			
			
			if (plugin.customConfig.contains("Custom.Firework" + addnew2
					+ ".ExpOrp.Amount") == false) {
				
				String customfireworks12 = "Custom.Firework" + addnew2
						+ ".ExpOrp.Amount";				
				plugin.customConfig.addDefault(customfireworks12, 0);
				String customfireworks13 = "Custom.Firework" + addnew2
						+ ".ExpOrp.Value";				
				plugin.customConfig.addDefault(customfireworks13, 0);
				
			}
			
			
			addnew2++;
			
		}

		while (plugin.customConfig.getBoolean("Custom.Firework" + cf + ".use") == true) {

			cf = cf + 1;
			ticks = ticks + 1;

			String customfireworks = "Custom.Firework" + cf + ".use";
			plugin.customConfig.addDefault(customfireworks, false);

			String customfireworksticks = "Custom.Firework" + cf + ".fireticks";
			plugin.customConfig.addDefault(customfireworksticks, ticks);
			
			String customfireworkprice = "Custom.Firework" + cf + ".Price";
			plugin.customConfig.addDefault(customfireworkprice, -1);
			
			String customfireworksmessage = "Custom.Firework" + cf + ".LaunchMessage";
			plugin.customConfig.addDefault(customfireworksmessage, "The Firework Goes off!");

			String customfireworks2 = "Custom.Firework" + cf
					+ ".FireworkBlockID";
			plugin.customConfig.addDefault(customfireworks2, -1);
			String customfireworks11 = "Custom.Firework" + cf
					+ ".FireworkBlockID-Raw-Data";
			plugin.customConfig.addDefault(customfireworks11, -1);

			String customfireworks5 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.use";
			plugin.customConfig.addDefault(customfireworks5, false);
			String customfireworks3 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemID";
			plugin.customConfig.addDefault(customfireworks3, 1);
			String customfireworks15 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemSubID";
			plugin.customConfig.addDefault(customfireworks15, -1);
			String customfireworks4 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Amount";
			plugin.customConfig.addDefault(customfireworks4, 16);
			String customfireworks6 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.CanBePickedUp";
			plugin.customConfig.addDefault(customfireworks6, true);
			String customfireworks7 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.SetAlight";
			plugin.customConfig.addDefault(customfireworks7, false);
			String customfireworks16 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Enchantment1.Type";
			plugin.customConfig.addDefault(customfireworks16, "NONE");
			String customfireworks17 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.Enchantment1.Level";
			plugin.customConfig.addDefault(customfireworks17, 1);
			String customfireworks18 = "Custom.Firework" + cf
					+ ".ItemsDroped.ID1.ItemSpread";
			plugin.customConfig.addDefault(customfireworks18, 4);
			
			String customfireworks8 = "Custom.Firework" + cf
					+ ".Mob1.use";
			plugin.customConfig.addDefault(customfireworks8, false);
			String customfireworks9 = "Custom.Firework" + cf
					+ ".Mob1.Mobname";
			plugin.customConfig.addDefault(customfireworks9, "PIG");
			String customfireworks10 = "Custom.Firework" + cf
					+ ".Mob1.Amount";
			plugin.customConfig.addDefault(customfireworks10, 1);
			String customfireworks12 = "Custom.Firework" + cf
					+ ".ExpOrp.Amount";				
			plugin.customConfig.addDefault(customfireworks12, 0);
			String customfireworks13 = "Custom.Firework" + cf
					+ ".ExpOrp.Value";				
			plugin.customConfig.addDefault(customfireworks13, 0);
			
			String customfireworks14 = "Custom.Firework" + cf
					+ ".Height";				
			plugin.customConfig.addDefault(customfireworks14, 1.5);

		}
		
		
		int firework;
		firework = 1;

		
		while (plugin.customConfig.contains("Custom.Firework" + firework + ".use") == true) {
			
			
			int blockid = plugin.customConfig.getInt("Custom.Firework" + firework
					+ ".FireworkBlockID");
			
			int fireworkheight23 = plugin.getConfig().getInt("Custom.Firework" + firework
					+ ".Height");
			
			if (fireworkheight23 > 16) {
				System.out.println("[ColourFireWorks] Error, Firework Height above 16, set to default");
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Firework Height above 16, set to default");
				plugin.customConfig.set("Custom.Firework" + firework
						+ ".Height", 1.5);
				System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error occured in customfirework " + firework);
			}
			if (fireworkheight23 < 0) {
				System.out.println("[ColourFireWorks] Error, Firework Height below 0, set to default");
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Firework Height below 0, set to default");
				plugin.customConfig.set("Custom.Firework" + firework
						+ ".Height", 1.5);
				
				System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error occured in customfirework " + firework);
			}
			
			if (blockid == 35) {
				System.out.println("[ColourFireWorks] Wool Blocks not allowed! Changing to -1");
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Wool Blocks not allowed! Changing to -1");
				plugin.customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error occured in customfirework " + firework);
			}
						
			if (blockid == 80) {
				System.out.println("[ColourFireWorks] Snow Blocks not allowed! Changing to -1");
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Snow Blocks not allowed! Changing to -1");
				plugin.customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error occured in customfirework " + firework);
			}
			
			if (blockid == 86) {
				System.out.println("[ColourFireWorks] Pumpkin Blocks not allowed! Changing to -1");
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Pumpkin Blocks not allowed! Changing to -1");
				plugin.customConfig.set("Custom.Firework" + firework
						+ ".FireworkBlockID", -1);
				System.out.println("[ColourFireWorks] Error occured in customfirework " + firework);
				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error occured in customfirework " + firework);
			}
			
			firework = firework + 1;

		}
		
		

		int cf2;
		cf2 = 1;
		int idnumber;
		idnumber = 1;

		while (plugin.customConfig.contains("Custom.Firework" + cf2 + ".use") == true) {
			
			idnumber = 1;
			
			while (plugin.customConfig.getBoolean(
					"Custom.Firework" + cf2 + ".ItemsDroped.ID" + idnumber
							+ ".use") == true) {
																										
				idnumber = idnumber + 1;
				String customfireworks5 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".use";
				plugin.customConfig.addDefault(customfireworks5, false);
				String customfireworks3 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".ItemID";
				plugin.customConfig.addDefault(customfireworks3, 1);
				String customfireworks15 = "Custom.Firework" + cf
						+ ".ItemsDroped.ID" + idnumber + ".ItemSubID";
				plugin.customConfig.addDefault(customfireworks15, -1);
				String customfireworks4 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".Amount";
				plugin.customConfig.addDefault(customfireworks4, 16);
				String customfireworks6 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".CanBePickedUp";
				plugin.customConfig.addDefault(customfireworks6, true);
				String customfireworks7 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".SetAlight";
				plugin.customConfig.addDefault(customfireworks7, false);
				String customfireworks16 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".Enchantment1.Type";
				plugin.customConfig.addDefault(customfireworks16, "NONE");
				String customfireworks17 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".Enchantment1.Level";
				plugin.customConfig.addDefault(customfireworks17, 1);
				String customfireworks18 = "Custom.Firework" + cf2
						+ ".ItemsDroped.ID" + idnumber + ".ItemSpread";
				plugin.customConfig.addDefault(customfireworks18, 4);

			}

			idnumber = 1;
			cf2 = cf2 + 1;

		}
		
		int cfmob;
		cfmob = 1;
		int idnumbermob;
		idnumbermob = 1;
		
		while (plugin.customConfig.contains("Custom.Firework" + cfmob + ".use") == true) {
			
			idnumbermob = 1;
			
			while (plugin.customConfig.getBoolean(
					"Custom.Firework" + cfmob
						+ ".Mob" + idnumbermob + ".use") == true) {
				idnumbermob = idnumbermob + 1;
				
				String customfireworks8 = "Custom.Firework" + cfmob
						+ ".Mob" + idnumbermob + ".use";
				plugin.customConfig.addDefault(customfireworks8, false);
				String customfireworks9 = "Custom.Firework" + cfmob
						+ ".Mob" + idnumbermob + ".Mobname";
				plugin.customConfig.addDefault(customfireworks9, "PIG");
				String customfireworks10 = "Custom.Firework" + cfmob
						+ ".Mob" + idnumbermob + ".Amount";
				plugin.customConfig.addDefault(customfireworks10, 1);


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
		
		
		while (plugin.customConfig.contains("Custom.Firework" + cf3mob + ".use") == true) {
			
			while (plugin.customConfig.getBoolean(
					"Custom.Firework" + cf3mob
						+ ".Mob" + idnumber2mob + ".use") == true) {
				
				String mobid;	
				mobid = plugin.customConfig.getString("Custom.Firework" + cf3mob + ".Mob" + idnumber2mob + ".Mobname").toUpperCase();
				
				correct54mob = 1;	

				if (mobid.equals("BLAZE")) {									
					correct54mob = 0;									
				}	
				if (mobid.equals("CAVE_SPIDER")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("CAVESPIDER")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
						+ ".Mob" + idnumber2mob + ".Mobname", "CAVE_SPIDER");
					System.out.println("[ColourFireWorks] Renamed CAVESPIDER to CAVE_SPIDER");		
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed CAVESPIDER to CAVE_SPIDER");
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
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Warning, an ENDER_DRAGON is in use");
				}
				if (mobid.equals("ENDERDRAGON")) {									
					correct54mob = 0;		
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "ENDER_DRAGON");
					System.out.println("[ColourFireWorks] Renamed ENDERDRAGON to ENDER_DRAGON");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed ENDERDRAGON to ENDER_DRAGON");
						System.out.println("[ColourFireWorks] Warning, an ENDER_DRAGON is in use");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Warning, an ENDER_DRAGON is in use");
				}
				if (mobid.equals("ENDERMAN")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("ENDERMEN")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "ENDERMAN");
						System.out.println("[ColourFireWorks] Renamed ENDERMEN to ENDERMAN");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed ENDERMEN to ENDERMAN");
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
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "MAGMA_CUBE");
						System.out.println("[ColourFireWorks] Renamed MAGMACUBE to MAGMA_CUBE");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed MAGMACUBE to MAGMA_CUBE");
				}
				if (mobid.equals("MUSHROOM_COW")) {									
					correct54mob = 0;		
				}
				if (mobid.equals("MUSHROOMCOW")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "MUSHROOM_COW");
						System.out.println("[ColourFireWorks] Renamed MUSHROOMCOW to MUSHROOM_COW");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed MUSHROOMCOW to MUSHROOM_COW");
				}
				if (mobid.equals("MOOSHROOM")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "MUSHROOM_COW");
						System.out.println("[ColourFireWorks] Renamed MOOSHROOM to MUSHROOM_COW");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed MOOSHROOM to MUSHROOM_COW");
				}
				if (mobid.equals("PIG")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("PIG_ZOMBIE")) {									
					correct54mob = 0;		
				}
				if (mobid.equals("PIGZOMBIE")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
						System.out.println("[ColourFireWorks] Renamed PIGZOMBIE to PIG_ZOMBIE");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed PIGZOMBIE to PIG_ZOMBIE");
				}
				if (mobid.equals("PIGMAN")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
						System.out.println("[ColourFireWorks] Renamed PIGMAN to PIG_ZOMBIE");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed PIGMAN to PIG_ZOMBIE");
				}
				if (mobid.equals("PIG_MAN")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "PIG_ZOMBIE");
						System.out.println("[ColourFireWorks] Renamed PIG_MAN to PIG_ZOMBIE");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed PIG_MAN to PIG_ZOMBIE");
				}
				if (mobid.equals("SHEEP")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("SILVERFISH")) {									
					correct54mob = 0;		
				}
				if (mobid.equals("SILVER_FISH")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SILVERFISH");
						System.out.println("[ColourFireWorks] Renamed SILVER_FISH to SILVERFISH");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed SILVER_FISH to SILVERFISH");
				}
				if (mobid.equals("SILVER")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SILVERFISH");
						System.out.println("[ColourFireWorks] Renamed SILVER to SILVERFISH");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed SILVER to SILVERFISH");
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
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
						System.out.println("[ColourFireWorks] Renamed SNOW_MAN to SNOWMAN");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed SNOW_MAN to SNOWMAN");
				}
				if (mobid.equals("SNOWGOLEM")) {									
					correct54mob = 0;		
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
						System.out.println("[ColourFireWorks] Renamed SNOWGOLEM to SNOWMAN");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed SNOWGOLEM to SNOWMAN");
				}
				if (mobid.equals("SNOW_GOLEM")) {									
					correct54mob = 0;		
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "SNOWMAN");
						System.out.println("[ColourFireWorks] Renamed SNOW_GOLEM to SNOWMAN");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed SNOW_GOLEM to SNOWMAN");
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
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "VILLAGER");
						System.out.println("[ColourFireWorks] Renamed NPC to VILLAGER");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed NPC to VILLAGER");
				}
				if (mobid.equals("HUMAN")) {									
					correct54mob = 0;		
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "VILLAGER");
						System.out.println("[ColourFireWorks] Renamed HUMAN to VILLAGER");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed HUMAN to VILLAGER");
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
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
						System.out.println("[ColourFireWorks] Renamed CAT to OCELOT");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed CAT to OCELOT");
				}
				
				if (mobid.equals("KITTEN")) {									
					correct54mob = 0;			
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
						System.out.println("[ColourFireWorks] Renamed KITTEN to OCELOT");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed KITTEN to OCELOT");
				}
				if (mobid.equals("CHEETA")) {									
					correct54mob = 0;		
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "OCELOT");
						System.out.println("[ColourFireWorks] Renamed CHEETA to OCELOT");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed CHEETA to OCELOT");
				}
				if (mobid.equals("IRON_GOLEM")) {									
					correct54mob = 0;									
				}
				if (mobid.equals("IRON")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "IRON_GOLEM");
						System.out.println("[ColourFireWorks] Renamed IRON to IRONGOLEM");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed IRON to IRONGOLEM");
				}
				if (mobid.equals("IRONGOLEM")) {									
					correct54mob = 0;	
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "IRON_GOLEM");
						System.out.println("[ColourFireWorks] Renamed IRONGOLEM to IRON_GOLEM");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Renamed IRONGOLEM to IRONGOLEM");
				}
				
				if (correct54mob == 1) {
					
					String whatisitthen;
					whatisitthen = plugin.customConfig.getString("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname");
					
					plugin.customConfig.set("Custom.Firework" + cf3mob
							+ ".Mob" + idnumber2mob + ".Mobname", "PIG");
						System.out.println("[ColourFireWorks] " + whatisitthen + " Is not a known Mob, Reset to PIG");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + whatisitthen + " Is not a known Mob, Reset to PIG");
						System.out.println("[ColourFireWorks] Error in CustomFireWork" + cf3mob + " | Mob" + idnumber2mob);
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error in CustomFireWork" + cf3mob + " | Mob" + idnumber2mob);
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

		while (plugin.customConfig.contains("Custom.Firework" + cf3 + ".use") == true) {

			while (plugin.customConfig.getBoolean(
					"Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber2
							+ ".use") == true) {
				
				int itemid;	
				itemid = plugin.customConfig.getInt(
					"Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber2
							+ ".ItemID");
				
				
				int enchantmentexist = 1;
				
				while (plugin.getCustomConfig().contains("Custom.Firework" + cf3
						+ ".ItemsDroped.ID"
						+ idnumber + ".Enchantment" + enchantmentexist + ".Type")) {
					
				
				String EnchantmentToAdd = plugin.getCustomConfig().getString("Custom.Firework" + cf3
						+ ".ItemsDroped.ID"
						+ idnumber + ".Enchantment" + enchantmentexist + ".Type").toUpperCase();
				
				
				int LevelEnchantmentToAdd = plugin.getCustomConfig().getInt("Custom.Firework" + cf3
						+ ".ItemsDroped.ID"
						+ idnumber + ".Enchantment" + enchantmentexist + ".Level");
				
				boolean correctenchantment = false;
				boolean correctenid = false;
				
				
				if (EnchantmentToAdd.equals("ARROW_DAMAGE")) {
					correctenchantment = true;
					if (itemid == 261) {										
						correctenid = true;

						if (LevelEnchantmentToAdd > 5 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] ARROW_DAMAGE Level must be between 1 and 5 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "ARROW_DAMAGE Level must be between 1 and 5 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
						
					}										
				}
				if (EnchantmentToAdd.equals("ARROW_FIRE")) {
					correctenchantment = true;
					if (itemid == 261) {
						correctenid = true;		
						if (LevelEnchantmentToAdd != 1) {
							System.out.println("[ColourFireWorks] ARROW_DAMAGE Level must be 1 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "ARROW_DAMAGE Level must be 1 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("ARROW_INFINITE")) {
					correctenchantment = true;
					if (itemid == 261) {
						correctenid = true;	
						if (LevelEnchantmentToAdd != 1) {
							System.out.println("[ColourFireWorks] ARROW_INFINITE Level must be 1 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "ARROW_INFINITE Level must be 1 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("ARROW_KNOCKBACK")) {
					correctenchantment = true;
					if (itemid == 261) {											
						correctenid = true;	
						if (LevelEnchantmentToAdd > 2 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] ARROW_KNOCKBACK Level must be between 1 and 2 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "ARROW_KNOCKBACK Level must be between 1 and 2 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}									
				if (EnchantmentToAdd.equals("PROTECTION_ENVIRONMENTAL")) {
					correctenchantment = true;
					if (itemid >= 298 && itemid <= 317) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 4 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] PROTECTION_ENVIRONMENTAL Level must be between 1 and 4 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "PROTECTION_ENVIRONMENTAL Level must be between 1 and 4 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("PROTECTION_EXPLOSIONS")) {
					correctenchantment = true;
					if (itemid >= 298 && itemid <= 317) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 4 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] PROTECTION_EXPLOSIONS Level must be between 1 and 4 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "PROTECTION_EXPLOSIONS Level must be between 1 and 4 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}	
				if (EnchantmentToAdd.equals("PROTECTION_FALL")) {
					correctenchantment = true;
					if (itemid == 301 || itemid == 305 || itemid == 309 || itemid == 313 || itemid == 317)  {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 4 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] PROTECTION_FALL Level must be between 1 and 4 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "PROTECTION_FALL Level must be between 1 and 4 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}	
				if (EnchantmentToAdd.equals("PROTECTION_FIRE")) {
					correctenchantment = true;
					if (itemid >= 298 && itemid <= 317) {											
						correctenid = true;	
						if (LevelEnchantmentToAdd > 4 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] PROTECTION_FIRE Level must be between 1 and 4 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "PROTECTION_FIRE Level must be between 1 and 4 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("PROTECTION_PROJECTILE")) {
					correctenchantment = true;
					if (itemid >= 298 && itemid <= 317) {											
						correctenid = true;	
						if (LevelEnchantmentToAdd > 4 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] PROTECTION_PROJECTILE Level must be between 1 and 4 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "PROTECTION_PROJECTILE Level must be between 1 and 4 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("OXYGEN")) {
					correctenchantment = true;
					if (itemid == 298 || itemid == 302 || itemid == 306 || itemid == 310 || itemid == 314)  {												
						correctenid = true;		
						if (LevelEnchantmentToAdd > 3 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] OXYGEN Level must be between 1 and 3 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "OXYGEN Level must be between 1 and 3 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("WATER_WORKER")) {
					correctenchantment = true;
					if (itemid == 298 || itemid == 302 || itemid == 306 || itemid == 310 || itemid == 314)  {												
						correctenid = true;	
						if (LevelEnchantmentToAdd != 1) {
							System.out.println("[ColourFireWorks] WATER_WORKER Level must be 1 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "WATER_WORKER Level must be 1 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("DURABILITY")) {
					correctenchantment = true;
					if (itemid == 269 || itemid == 270 || itemid == 271 || itemid == 273 || itemid == 274 || itemid == 275 || itemid == 277 || itemid == 278 || itemid == 279 || itemid == 284 || itemid == 285 || itemid == 286 || itemid == 256 || itemid == 257 || itemid == 258) {											
						correctenid = true;	
						if (LevelEnchantmentToAdd > 3 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] DURABILITY Level must be between 1 and 3 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "DURABILITY Level must be between 1 and 3 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("DIG_SPEED")) {
					correctenchantment = true;
					if (itemid == 269 || itemid == 270 || itemid == 271 || itemid == 273 || itemid == 274 || itemid == 275 || itemid == 277 || itemid == 278 || itemid == 279 || itemid == 284 || itemid == 285 || itemid == 286 || itemid == 256 || itemid == 257 || itemid == 258) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 5 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] DIG_SPEED Level must be between 1 and 5 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "DIG_SPEED Level must be between 1 and 5 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("LOOT_BONUS_BLOCKS")) {
					correctenchantment = true;
					if (itemid == 269 || itemid == 270 || itemid == 271 || itemid == 273 || itemid == 274 || itemid == 275 || itemid == 277 || itemid == 278 || itemid == 279 || itemid == 284 || itemid == 285 || itemid == 286 || itemid == 256 || itemid == 257 || itemid == 258) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 3 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] LOOT_BONUS_BLOCKS Level must be between 1 and 3 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "LOOT_BONUS_BLOCKS Level must be between 1 and 3 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("SILK_TOUCH")) {
					correctenchantment = true;
					if (itemid == 269 || itemid == 270 || itemid == 271 || itemid == 273 || itemid == 274 || itemid == 275 || itemid == 277 || itemid == 278 || itemid == 279 || itemid == 284 || itemid == 285 || itemid == 286 || itemid == 256 || itemid == 257 || itemid == 258) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd != 1) {
							System.out.println("[ColourFireWorks] SILK_TOUCH Level must be 1 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "SILK_TOUCH Level must be 1 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("FIRE_ASPECT")) {
					correctenchantment = true;
					if (itemid == 267 || itemid == 268 || itemid == 272 || itemid == 276 || itemid == 283) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 2 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] FIRE_ASPECT Level must be between 1 and 2 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "FIRE_ASPECT Level must be between 1 and 2 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("KNOCKBACK")) {
					correctenchantment = true;
					if (itemid == 267 || itemid == 268 || itemid == 272 || itemid == 276 || itemid == 283) {											
						correctenid = true;	
						if (LevelEnchantmentToAdd > 2 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] KNOCKBACK Level must be between 1 and 2 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "KNOCKBACK Level must be between 1 and 2 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("LOOT_BONUS_MOBS")) {
					correctenchantment = true;
					if (itemid == 267 || itemid == 268 || itemid == 272 || itemid == 276 || itemid == 283) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 3 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] LOOT_BONUS_MOBS Level must be between 1 and 3 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "LOOT_BONUS_MOBS Level must be between 1 and 3 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("DAMAGE_ARTHROPODS")) {
					correctenchantment = true;
					if (itemid == 267 || itemid == 268 || itemid == 272 || itemid == 276 || itemid == 283) {											
						correctenid = true;	
						if (LevelEnchantmentToAdd > 5 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] DAMAGE_ARTHROPODS Level must be between 1 and 5 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "DAMAGE_ARTHROPODS Level must be between 1 and 5 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				if (EnchantmentToAdd.equals("DAMAGE_ALL")) {
					correctenchantment = true;
					if (itemid == 267 || itemid == 268 || itemid == 272 || itemid == 276 || itemid == 283) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 5 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] DAMAGE_ALL Level must be between 1 and 5 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "DAMAGE_ALL Level must be between 1 and 5 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}	
				}
				if (EnchantmentToAdd.equals("DAMAGE_UNDEAD")) {
					correctenchantment = true;
					if (itemid == 267 || itemid == 268 || itemid == 272 || itemid == 276 || itemid == 283) {											
						correctenid = true;		
						if (LevelEnchantmentToAdd > 5 || LevelEnchantmentToAdd < 1) {
							System.out.println("[ColourFireWorks] DAMAGE_UNDEAD Level must be between 1 and 5 - Set to default");
							player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "DAMAGE_UNDEAD Level must be between 1 and 5 - Set to default");
							plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Level", 1);
						}
					}										
				}
				
				
				
				if (EnchantmentToAdd.equals("NONE")) {
					correctenchantment = true;									
					correctenid = true;										
				}
				
				if (correctenchantment == false) {
					System.out.println("[ColourFireWorks] " + EnchantmentToAdd + " Is not a known Enchantment! - Set to 'NONE'");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + EnchantmentToAdd + " Is not a known Enchantment! - Set to 'NONE'");
					plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Type", "NONE");
				}								
				if (correctenchantment == true) {
					if (correctenid == false) {
						System.out.println("[ColourFireWorks] " + EnchantmentToAdd + " Will not go on the item " + itemid + " - Set to 'NONE'");
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + EnchantmentToAdd + " Will not go on the item " + itemid + " - Set to 'NONE'");
						plugin.getCustomConfig().set("Custom.Firework" + cf3 + ".ItemsDroped.ID" + idnumber + ".Enchantment" + enchantmentexist + ".Type", "NONE");
					}
				}


				
				
				enchantmentexist++;
				}
				
				

				

				
				if (itemid > 385) {					
					if (itemid < 2256) {
						System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
						correct54 = 1;
					}
					
				}
				
				if (itemid > 122) {					
					if (itemid < 256) {
						System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
						player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
						correct54 = 1;
					}
					
				}
				
				if (itemid < 0) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
					correct54 = 1;
				}
				
				if (itemid > 2256) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2);
					correct54 = 1;
				}
				
				if (itemid == 62) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " A Lit Furnace can not be used!");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " A Lit Furnace can not be used!");
					correct54 = 1;
				}				
				if (itemid == 74) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Glowing Redstone Ore can not be used!");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Glowing Redstone Ore can not be used!");
					correct54 = 1;
				}
				if (itemid == 93 || itemid == 94)  {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " A Dioide Block can not be used!");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " A Dioide Block can not be used!");
					correct54 = 1;
				}
				if (itemid == 117) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Brewing Stands Blocks can not be used!");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Brewing Stands Blocks can not be used!");
					correct54 = 1;
				}
				if (itemid == 118) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Cauldron Block can not be used!");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " Cauldron Block can not be used!");
					correct54 = 1;
				}
				if (itemid == 119) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " End Portal can not be used!");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " End Portal can not be used!");
					correct54 = 1;
				}
				if (itemid == 120) {
					System.out.println("[ColourFireWorks] Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " End Portal Frame can not be used!");
					player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GOLD + "ColourFireWorks" + ChatColor.GREEN + "] " + ChatColor.RED + "Error, Item not reconised, CustomFireWork" + cf3 + ", Item " + idnumber2 + " End Portal Frame can not be used!");
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
			System.out.println("[ColourFireWorks] DISABLING");
			Bukkit.getPluginManager().disablePlugin(plugin);
			player.sendMessage(ChatColor.RED
					+ "[ColourFireWorks] DISABLED");
			System.out.println("[ColourFireWorks] DISABLED");
		} else {

			plugin.getConfig().options().copyDefaults(true);
			plugin.saveConfig();
			plugin.getCustomConfig().options().copyDefaults(true);		
			plugin.saveCustomConfig();
			plugin.getdroppartyConfig().options().copyDefaults(true);	
			plugin.savedroppartyConfig();
			plugin.getEconomyConfig().options().copyDefaults(true);	
			plugin.saveEconomyConfig();
			player.sendMessage(ChatColor.GREEN
					+ "ColourFireWorks Reloaded!");
			System.out
					.println("[ColourFireWorks] Config Loaded");
		}
		
		
		
	}

}
