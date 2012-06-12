package me.craftiii4.colourfireworks.api;

import java.util.List;

import me.craftiii4.colourfireworks.colourfireworks;
import me.craftiii4.colourfireworks.colourfireworksBlockListener;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;



public class FindItemName {
	
	
	public static void RunFindItemName(final colourfireworks plugin,
			final Player player, final String itemname, final Integer itemid,
			final Integer itemsubid, final Integer howmany2) {

		int radius = plugin.getdroppartyConfig().getInt(
				"DropParty.Message.Radius");

		Block block = colourfireworksBlockListener.location.getBlock();

		Entity chicken = block.getWorld().spawnCreature(block.getLocation(),
				EntityType.CHICKEN);
		List<Entity> list = chicken.getNearbyEntities(radius, radius, radius);
		chicken.remove();

		String itemnamebackup23 = null;


		int test01 = 0;
		int test02 = list.size();

		boolean manualnameset = false;

		if (itemid == 5) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Wooden Plank";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Pine Wooden Plank";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Birch Wooden Plank";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Jungle Wooden Plank";
			}
		}

		if (itemid == 6) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Sapling";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Pine Sapling";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Birch Sapling";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Jungle Sapling";
			}
		}

		if (itemid == 17) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Wood";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Pine Wood";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Birch Wood";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Jungle Wood";
			}
		}

		if (itemid == 18) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Leaves";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Pine Leaves";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Birch Leaves";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Jungle Leaves";
			}
		}

		if (itemid == 24) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Sandstone";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Hieroglyphic Sandstone";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Smooth Sandstone";
			}
		}

		if (itemid == 26) {
			manualnameset = true;
			itemnamebackup23 = ChatColor.RED + "Bed Block";
		}

		if (itemid == 31) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Dead Shrub";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Tall Grass";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Fern Grass";
			}
		}

		if (itemid == 34) {
			manualnameset = true;
			itemnamebackup23 = ChatColor.RED + "Piston Head";
		}

		if (itemid == 35) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "White Wool";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Orange Wool";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Magenta Wool";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Light Blue Wool";
			}
			if (itemsubid == 4) {
				itemnamebackup23 = "Yellow Wool";
			}
			if (itemsubid == 5) {
				itemnamebackup23 = "Lime Wool";
			}
			if (itemsubid == 6) {
				itemnamebackup23 = "Pink Wool";
			}
			if (itemsubid == 7) {
				itemnamebackup23 = "Gray Wool";
			}
			if (itemsubid == 8) {
				itemnamebackup23 = "Light Gray Wool";
			}
			if (itemsubid == 9) {
				itemnamebackup23 = "Cyan Wool";
			}
			if (itemsubid == 10) {
				itemnamebackup23 = "Purple Wool";
			}
			if (itemsubid == 11) {
				itemnamebackup23 = "Blue Wool";
			}
			if (itemsubid == 12) {
				itemnamebackup23 = "Brown Wool";
			}
			if (itemsubid == 13) {
				itemnamebackup23 = "Green Wool";
			}
			if (itemsubid == 14) {
				itemnamebackup23 = "Red Wool";
			}
			if (itemsubid == 15) {
				itemnamebackup23 = "Black Wool";
			}

		}

		if (itemid == 36) {
			manualnameset = true;
			itemnamebackup23 = ChatColor.RED + "Piston Moving";
		}

		if (itemid == 43) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Double Stone Slab";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Double Sandstone Slab";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Double Wooden Slab";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Double Cobblestone Slab";
			}
			if (itemsubid == 4) {
				itemnamebackup23 = "Double Brick Slab";
			}
			if (itemsubid == 5) {
				itemnamebackup23 = "Double Stone Brick Slab";
			}

		}
		if (itemid == 44) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Stone Slab";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Sandstone Slab";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Wooden Slab";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Cobblestone Slab";
			}
			if (itemsubid == 4) {
				itemnamebackup23 = "Brick Slab";
			}
			if (itemsubid == 5) {
				itemnamebackup23 = "Stone Brick Slab";
			}

		}

		if (itemid == 62) {
			manualnameset = true;
			itemnamebackup23 = ChatColor.RED + "Smelting Furnace";
		}
		if (itemid == 63) {
			manualnameset = true;
			itemnamebackup23 = ChatColor.RED + "Sign Block";
		}
		if (itemid == 64) {
			manualnameset = true;
			itemnamebackup23 = ChatColor.RED + "Half Door";
		}
		if (itemid == 68) {
			manualnameset = true;
			itemnamebackup23 = ChatColor.RED + "Sign Wall Block";
		}

		if (itemid == 97) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Silverfish Stone";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Silverfish Cobblestone";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Silverfish Stone Brick";
			}

		}
		if (itemid == 98) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Stone Brick";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Mossy Stone Brick";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Cracked Stone Brick";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Circle Stone Brick";
			}
		}
		if (itemid == 263) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Coal";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Charcoal";
			}
		}

		if (itemid == 351) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Ink Sack";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Rose Red Dye";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Cactus Green Dye";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Coca Bean";
			}
			if (itemsubid == 4) {
				itemnamebackup23 = "Lapis Lazuli";
			}
			if (itemsubid == 5) {
				itemnamebackup23 = "Purple Dye";
			}
			if (itemsubid == 6) {
				itemnamebackup23 = "Cyan Dye";
			}
			if (itemsubid == 7) {
				itemnamebackup23 = "Light Gray Dye";
			}
			if (itemsubid == 8) {
				itemnamebackup23 = "Gray Dye";
			}
			if (itemsubid == 9) {
				itemnamebackup23 = "Pink Dye";
			}
			if (itemsubid == 10) {
				itemnamebackup23 = "Lime Dye";
			}
			if (itemsubid == 11) {
				itemnamebackup23 = "Dandelion Yellow Dye";
			}
			if (itemsubid == 12) {
				itemnamebackup23 = "Light Blue Dye";
			}
			if (itemsubid == 13) {
				itemnamebackup23 = "Magenta Dye";
			}
			if (itemsubid == 14) {
				itemnamebackup23 = "Orange Dye";
			}
			if (itemsubid == 15) {
				itemnamebackup23 = "Bone Meal";
			}

		}

		if (itemid == 373) {
			boolean isapotion = false;
			manualnameset = true;
			if (itemsubid == 0) {
				isapotion = true;
				itemnamebackup23 = "Water Bottle";
			}
			if (itemsubid == 16) {
				isapotion = true;
				itemnamebackup23 = "Awkward Potion";
			}
			if (itemsubid == 32) {
				isapotion = true;
				itemnamebackup23 = "Thick Potion";
			}
			if (itemsubid == 64) {
				isapotion = true;
				itemnamebackup23 = "Mundane Potion";
			}
			if (itemsubid == 8193) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Potion (0:45)";
			}
			if (itemsubid == 8194) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Potion (3:00)";
			}
			if (itemsubid == 8195) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Potion (3:00)";
			}
			if (itemsubid == 8196) {
				isapotion = true;
				itemnamebackup23 = "Poison Potion (0:45)";
			}
			if (itemsubid == 8197) {
				isapotion = true;
				itemnamebackup23 = "Healing Potion";
			}
			if (itemsubid == 8200) {
				isapotion = true;
				itemnamebackup23 = "Weakness Potion (1:30)";
			}
			if (itemsubid == 8201) {
				isapotion = true;
				itemnamebackup23 = "Strength Potion (3:00)";
			}
			if (itemsubid == 8202) {
				isapotion = true;
				itemnamebackup23 = "Slowness Potion (1:30)";
			}
			if (itemsubid == 8204) {
				isapotion = true;
				itemnamebackup23 = "Harming Potion";
			}
			if (itemsubid == 8225) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Potion II (0:22)";
			}
			if (itemsubid == 8226) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Potion II (1:30)";
			}
			if (itemsubid == 8227) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Potion (3:00)";
			}
			if (itemsubid == 8228) {
				isapotion = true;
				itemnamebackup23 = "Poison Potion II (0:22)";
			}
			if (itemsubid == 8229) {
				isapotion = true;
				itemnamebackup23 = "Healing Potion II)";
			}
			if (itemsubid == 8232) {
				isapotion = true;
				itemnamebackup23 = "Weakness Potion (1:30)";
			}
			if (itemsubid == 8233) {
				isapotion = true;
				itemnamebackup23 = "Strength Potion II (1:30)";
			}
			if (itemsubid == 8234) {
				isapotion = true;
				itemnamebackup23 = "Slowness Potion (1:30)";
			}
			if (itemsubid == 8236) {
				isapotion = true;
				itemnamebackup23 = "Harming Potion II";
			}
			if (itemsubid == 8257) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Potion (2:00)";
			}
			if (itemsubid == 8258) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Potion (8:00)";
			}
			if (itemsubid == 8259) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Potion (8:00)";
			}
			if (itemsubid == 8260) {
				isapotion = true;
				itemnamebackup23 = "Poison Potion (2:00)";
			}
			if (itemsubid == 8261) {
				isapotion = true;
				itemnamebackup23 = "Healing Potion)";
			}
			if (itemsubid == 8264) {
				isapotion = true;
				itemnamebackup23 = "Weakness Potion (4:00)";
			}
			if (itemsubid == 8265) {
				isapotion = true;
				itemnamebackup23 = "Strength Potion (8:00)";
			}
			if (itemsubid == 8266) {
				isapotion = true;
				itemnamebackup23 = "Slowness Potion (4:00)";
			}
			if (itemsubid == 8268) {
				isapotion = true;
				itemnamebackup23 = "Harming Potion";
			}

			if (itemsubid == 16385) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Splash (0:33)";
			}
			if (itemsubid == 16386) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Splash (2:15)";
			}
			if (itemsubid == 16387) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Splash (2:15)";
			}
			if (itemsubid == 16388) {
				isapotion = true;
				itemnamebackup23 = "Poison Splash (0:33)";
			}
			if (itemsubid == 16389) {
				isapotion = true;
				itemnamebackup23 = "Healing Splash";
			}
			if (itemsubid == 16392) {
				isapotion = true;
				itemnamebackup23 = "Weakness Splash (1:07))";
			}
			if (itemsubid == 16393) {
				isapotion = true;
				itemnamebackup23 = "Strength Splash (2:15)";
			}
			if (itemsubid == 16394) {
				isapotion = true;
				itemnamebackup23 = "Slowness Splash (1:07)";
			}
			if (itemsubid == 16396) {
				isapotion = true;
				itemnamebackup23 = "Harming Splash";
			}
			if (itemsubid == 16417) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Splash II (0:16)";
			}
			if (itemsubid == 16418) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Splash II (1:07)";
			}
			if (itemsubid == 16419) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Splash (2:15)";
			}
			if (itemsubid == 16420) {
				isapotion = true;
				itemnamebackup23 = "Poison Splash II (0:16)";
			}
			if (itemsubid == 16421) {
				isapotion = true;
				itemnamebackup23 = "Healing Splash II";
			}
			if (itemsubid == 16424) {
				isapotion = true;
				itemnamebackup23 = "Weakness Splash (1:07)";
			}
			if (itemsubid == 16425) {
				isapotion = true;
				itemnamebackup23 = "Strength Splash II (1:07)";
			}
			if (itemsubid == 16426) {
				isapotion = true;
				itemnamebackup23 = "Slowness Splash (1:07)";
			}
			if (itemsubid == 16428) {
				isapotion = true;
				itemnamebackup23 = "Harming Splash II";
			}
			if (itemsubid == 16449) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Splash (1:30)";
			}
			if (itemsubid == 16450) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Splash (6:00)";
			}
			if (itemsubid == 16451) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Splash (6:00)";
			}
			if (itemsubid == 16452) {
				isapotion = true;
				itemnamebackup23 = "Poison Splash (1:30)";
			}
			if (itemsubid == 16453) {
				isapotion = true;
				itemnamebackup23 = "Healing Splash";
			}
			if (itemsubid == 16456) {
				isapotion = true;
				itemnamebackup23 = "Weakness Splash (3:00)";
			}
			if (itemsubid == 16457) {
				isapotion = true;
				itemnamebackup23 = "Strength Splash (6:00)";
			}
			if (itemsubid == 16458) {
				isapotion = true;
				itemnamebackup23 = "Slowness Splash (3:00)";
			}
			if (itemsubid == 16460) {
				isapotion = true;
				itemnamebackup23 = "Harming Splash";
			}
			if (isapotion == false) {
				itemnamebackup23 = "Unknown Potion";
			}			
		}

		if (itemid == 383) {
			boolean isaegg = false;
			manualnameset = true;
			if (itemsubid == 50) {
				isaegg = true;
				itemnamebackup23 = "Creeper Spawner Egg";
			}
			if (itemsubid == 51) {
				isaegg = true;
				itemnamebackup23 = "Skeleton Spawner Egg";
			}
			if (itemsubid == 52) {
				isaegg = true;
				itemnamebackup23 = "Spider Spawner Egg";
			}
			if (itemsubid == 54) {
				isaegg = true;
				itemnamebackup23 = "Zombie Spawner Egg";
			}
			if (itemsubid == 55) {
				isaegg = true;
				itemnamebackup23 = "Slime Spawner Egg";
			}
			if (itemsubid == 56) {
				isaegg = true;
				itemnamebackup23 = "Ghast Spawner Egg";
			}
			if (itemsubid == 57) {
				isaegg = true;
				itemnamebackup23 = "Zombie Pigman Spawner Egg";
			}
			if (itemsubid == 58) {
				isaegg = true;
				itemnamebackup23 = "Enderman Spawner Egg";
			}
			if (itemsubid == 59) {
				isaegg = true;
				itemnamebackup23 = "Cave Spider Spawner Egg";
			}
			if (itemsubid == 60) {
				isaegg = true;
				itemnamebackup23 = "Silverfish Spawner Egg";
			}
			if (itemsubid == 61) {
				isaegg = true;
				itemnamebackup23 = "Blaze Spawner Egg";
			}
			if (itemsubid == 62) {
				isaegg = true;
				itemnamebackup23 = "Magma Cube Spawner Egg";
			}
			if (itemsubid == 90) {
				isaegg = true;
				itemnamebackup23 = "Pig Spawner Egg";
			}
			if (itemsubid == 91) {
				isaegg = true;
				itemnamebackup23 = "Sheep Spawner Egg";
			}
			if (itemsubid == 92) {
				isaegg = true;
				itemnamebackup23 = "Cow Spawner Egg";
			}
			if (itemsubid == 93) {
				isaegg = true;
				itemnamebackup23 = "Chicken Spawner Egg";
			}
			if (itemsubid == 94) {
				isaegg = true;
				itemnamebackup23 = "Squid Spawner Egg";
			}
			if (itemsubid == 95) {
				isaegg = true;
				itemnamebackup23 = "Wolf Spawner Egg";
			}
			if (itemsubid == 96) {
				isaegg = true;
				itemnamebackup23 = "Mooshroom Spawner Egg";
			}
			if (itemsubid == 98) {
				isaegg = true;
				itemnamebackup23 = "Ocelot Spawner Egg";
			}
			if (itemsubid == 120) {
				isaegg = true;
				itemnamebackup23 = "Villager Spawner Egg";
			}

			if (isaegg == false) {
				itemnamebackup23 = "Unknown Spawner Egg";
			}

		}

		if (manualnameset == false) {

			String itemnamebackup = itemname.replace("_", " ");

			String itemnamebackup2 = itemnamebackup.toLowerCase();

			// String itemnamebackup23 =
			// Character.toUpperCase(itemnamebackup2.charAt(0)) +
			// itemnamebackup2.substring(1);

			itemnamebackup23 = WordUtils.capitalize(itemnamebackup2);

			// if (itemnamebackup23.contains(" ")) {
			// itemnamebackup23 =
			// Character.toUpperCase(itemnamebackup2.charAt(1)) +
			// itemnamebackup2.substring(1);
			// }

		}

		String message = null;

		if (manualnameset == false) {
			if (plugin.getdroppartyConfig().contains(
					"DropParty.Items." + itemname + ".AddedTime")) {

				int timetoadd = plugin.getdroppartyConfig().getInt(
						"DropParty.Items." + itemname + ".AddedTime") * howmany2;

				colourfireworksBlockListener.time = colourfireworksBlockListener.time
						+ timetoadd;

				message = ChatColor.GOLD + player.getName() + ChatColor.GRAY
						+ " just put in " + ChatColor.LIGHT_PURPLE + howmany2
						+ " " + ChatColor.AQUA + itemnamebackup23
						+ ChatColor.GREEN + " + " + ChatColor.LIGHT_PURPLE
						+ timetoadd + ChatColor.GRAY + " sec";

			} else {

				message = ChatColor.GOLD + player.getName() + ChatColor.GRAY
						+ " just put in " + ChatColor.LIGHT_PURPLE + howmany2
						+ " " + ChatColor.AQUA + itemnamebackup23;

			}
		}

		if (manualnameset == true) {

			String itemname2 = itemnamebackup23.replace(" ", "_")
					.replace("_(", "").replace(")", "").replace(":", "")
					.replace("0", "").replace("1", "").replace("2", "")
					.replace("3", "").replace("4", "").replace("5", "")
					.replace("6", "").replace("7", "").replace("8", "")
					.replace("9", "").toUpperCase();

			player.sendMessage(itemname2);

			if (plugin.getdroppartyConfig().contains(
					"DropParty.Items." + itemname2 + ".AddedTime")) {

				int timetoadd = plugin.getdroppartyConfig().getInt(
						"DropParty.Items." + itemname2 + ".AddedTime") * howmany2;

				colourfireworksBlockListener.time = colourfireworksBlockListener.time
						+ timetoadd;

				message = ChatColor.GOLD + player.getName() + ChatColor.GRAY
						+ " just put in " + ChatColor.LIGHT_PURPLE + howmany2
						+ " " + ChatColor.AQUA + itemnamebackup23
						+ ChatColor.GREEN + " + " + ChatColor.LIGHT_PURPLE
						+ timetoadd + ChatColor.GRAY + " sec";

			} else {

				boolean other = false;

				if (itemname2.contains("POTION")) {

					if (!itemname2.equals("UNKNOWN_POTION")) {
						if (!itemname2.equals("AWKWARD_POTION")) {
							if (!itemname2.equals("THICK_POTION")) {
								if (!itemname2.equals("MUNDANE_POTION")) {

									if (plugin.getdroppartyConfig().contains(
											"DropParty.Items.POTION.AddedTime")) {

										other = true;

										int timetoadd = plugin
												.getdroppartyConfig()
												.getInt("DropParty.Items.POTION.AddedTime") * howmany2;

										colourfireworksBlockListener.time = colourfireworksBlockListener.time
												+ timetoadd;

										message = ChatColor.GOLD
												+ player.getName()
												+ ChatColor.GRAY
												+ " just put in "
												+ ChatColor.LIGHT_PURPLE
												+ howmany2 + " "
												+ ChatColor.AQUA
												+ itemnamebackup23
												+ ChatColor.GREEN + " + "
												+ ChatColor.LIGHT_PURPLE
												+ timetoadd + ChatColor.GRAY
												+ " sec";
									}
								}
							}
						}
					}

				}
				
				if (itemname2.contains("SPLASH")) {
					
					if (plugin.getdroppartyConfig().contains(
							"DropParty.Items.SPLASH.AddedTime")) {

						other = true;

						int timetoadd = plugin
								.getdroppartyConfig()
								.getInt("DropParty.Items.SPLASH.AddedTime") * howmany2;

						colourfireworksBlockListener.time = colourfireworksBlockListener.time
								+ timetoadd;

						message = ChatColor.GOLD
								+ player.getName()
								+ ChatColor.GRAY
								+ " just put in "
								+ ChatColor.LIGHT_PURPLE
								+ howmany2 + " "
								+ ChatColor.AQUA
								+ itemnamebackup23
								+ ChatColor.GREEN + " + "
								+ ChatColor.LIGHT_PURPLE
								+ timetoadd + ChatColor.GRAY
								+ " sec";
					}
					
					
				}

				if (itemname2.contains("SPAWNER_EGG")) {

					if (plugin.getdroppartyConfig().contains(
							"DropParty.Items.SPAWNER_EGG.AddedTime")) {

						other = true;

						int timetoadd = plugin.getdroppartyConfig().getInt(
								"DropParty.Items.SPAWNER_EGG.AddedTime") * howmany2;

						colourfireworksBlockListener.time = colourfireworksBlockListener.time
								+ timetoadd;

						message = ChatColor.GOLD + player.getName()
								+ ChatColor.GRAY + " just put in "
								+ ChatColor.LIGHT_PURPLE + howmany2 + " "
								+ ChatColor.AQUA + itemnamebackup23
								+ ChatColor.GREEN + " + "
								+ ChatColor.LIGHT_PURPLE + timetoadd
								+ ChatColor.GRAY + " sec";

					}

				}

				if (itemname2.contains("WOOL")) {

					if (plugin.getdroppartyConfig().contains(
							"DropParty.Items.WOOL.AddedTime")) {

						other = true;

						int timetoadd = plugin.getdroppartyConfig().getInt(
								"DropParty.Items.WOOL.AddedTime")* howmany2;

						colourfireworksBlockListener.time = colourfireworksBlockListener.time
								+ timetoadd;

						message = ChatColor.GOLD + player.getName()
								+ ChatColor.GRAY + " just put in "
								+ ChatColor.LIGHT_PURPLE + howmany2 + " "
								+ ChatColor.AQUA + itemnamebackup23
								+ ChatColor.GREEN + " + "
								+ ChatColor.LIGHT_PURPLE + timetoadd
								+ ChatColor.GRAY + " sec";

					}

				}

				if (itemname2.contains("DYE")
						|| (itemname2.contains("INK") || (itemname2
								.equals("LAPIS_LAZULI")))) {

					if (plugin.getdroppartyConfig().contains(
							"DropParty.Items.DYE.AddedTime")) {

						other = true;

						int timetoadd = plugin.getdroppartyConfig().getInt(
								"DropParty.Items.DYE.AddedTime") * howmany2;

						colourfireworksBlockListener.time = colourfireworksBlockListener.time
								+ timetoadd;

						message = ChatColor.GOLD + player.getName()
								+ ChatColor.GRAY + " just put in "
								+ ChatColor.LIGHT_PURPLE + howmany2 + " "
								+ ChatColor.AQUA + itemnamebackup23
								+ ChatColor.GREEN + " + "
								+ ChatColor.LIGHT_PURPLE + timetoadd
								+ ChatColor.GRAY + " sec";

					}

				}

				if (other == false) {

					message = ChatColor.GOLD + player.getName()
							+ ChatColor.GRAY + " just put in "
							+ ChatColor.LIGHT_PURPLE + howmany2 + " "
							+ ChatColor.AQUA + itemnamebackup23;

				}

			}

		}

		while (test02 > test01) {

			Entity entity = list.get(test01);
			if (entity instanceof Player) {
				((Player) entity).getPlayer().sendMessage(message);

			}

			test01++;
		}

	}

}
