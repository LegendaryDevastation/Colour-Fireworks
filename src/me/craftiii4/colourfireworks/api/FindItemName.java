package me.craftiii4.colourfireworks.api;

import java.util.List;

import me.craftiii4.colourfireworks.colourfireworks;
import me.craftiii4.colourfireworks.colourfireworksBlockListener;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;



public class FindItemName {
	
	
	public static void RunFindItemName(final colourfireworks plugin,
			final Player player, final String itemname, final Integer itemid,
			final Integer itemsubid, final Integer howmany2) {

		int radius = plugin.getdroppartyConfig().getInt(
				"DropParty.Message.Radius");

		// Block block = colourfireworksBlockListener.location.getBlock();

		// Entity chicken = block.getWorld().spawnCreature(block.getLocation(),
		// EntityType.CHICKEN);
		List<Entity> list = player.getNearbyEntities(radius, radius, radius);

		// chicken.remove();

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
			if (itemsubid > 3) {
				itemnamebackup23 = "Unknown Wooden Plank";
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
			if (itemsubid > 3) {
				itemnamebackup23 = "Unknown Sapling";
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
			if (itemsubid > 3) {
				itemnamebackup23 = "Unknown Wood";
			}
		}

		if (itemid == 18) {
			manualnameset = true;
			if (itemsubid == 0 || itemsubid == 4) {
				itemnamebackup23 = "Oak Leaves";
			}
			if (itemsubid == 1 || itemsubid == 5) {
				itemnamebackup23 = "Spruce Leaves";
			}
			if (itemsubid == 2 || itemsubid == 6) {
				itemnamebackup23 = "Birch Leaves";
			}
			if (itemsubid == 3 || itemsubid == 7) {
				itemnamebackup23 = "Jungle Leaves";
			}
			if (itemsubid > 7) {
				itemnamebackup23 = "Unknown Leaves";
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
			if (itemsubid > 2) {
				itemnamebackup23 = "Unknown Sandstone";
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
			if (itemsubid > 2) {
				itemnamebackup23 = "Unknown Grass";
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
			if (itemsubid > 15) {
				itemnamebackup23 = "Unknown Wool";
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
			if (itemsubid > 5) {
				itemnamebackup23 = "Unknown Double Slab";
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
			if (itemsubid > 5) {
				itemnamebackup23 = "Unknown Slab";
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
			if (itemsubid > 2) {
				itemnamebackup23 = "Unknown Silverfish Block";
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
			if (itemsubid > 3) {
				itemnamebackup23 = "Unknown Stone Brick";
			}
		}
		if (itemid == 125) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Oak-Wood Slab (Double)";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Pine-Wood Slab (Double)";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Birch-Wood Slab (Double)";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Jungle-Wood Slab (Double)";
			}
			if (itemsubid > 3) {
				itemnamebackup23 = "Unknown Wood Slab (Double)";
			}
		}
		if (itemid == 126) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "Oak-Wood Slab";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "Pine-Wood Slab";
			}
			if (itemsubid == 2) {
				itemnamebackup23 = "Birch-Wood Slab";
			}
			if (itemsubid == 3) {
				itemnamebackup23 = "Jungle-Wood Slab";
			}
			if (itemsubid > 3) {
				itemnamebackup23 = "Unknown Wood Slab";
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
			if (itemsubid > 1) {
				itemnamebackup23 = "Unknown Char/coal";
			}
		}
		if (itemid == 322) {
			manualnameset = true;
			if (itemsubid == 0) {
				itemnamebackup23 = "§6Golden §4Apple";
			}
			if (itemsubid == 1) {
				itemnamebackup23 = "§aEnchanted §6Golden §4Apple";
			}
			if (itemsubid > 1) {
				itemnamebackup23 = "Unknown §6Golden §4Apple";
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
			if (itemsubid > 15) {
				itemnamebackup23 = "Unknown Dye";
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
			if (itemsubid == 8193 || itemsubid == 16273) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Potion (0:45)";
			}
			if (itemsubid == 8194 || itemsubid == 16274) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Potion (3:00)";
			}
			if (itemsubid == 8195 || itemsubid == 16307) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Potion (3:00)";
			}
			if (itemsubid == 8196 || itemsubid == 16276) {
				isapotion = true;
				itemnamebackup23 = "Poison Potion (0:45)";
			}
			if (itemsubid == 8197) {
				isapotion = true;
				itemnamebackup23 = "Healing Potion";
			}
			if (itemsubid == 8200 || itemsubid == 16312) {
				isapotion = true;
				itemnamebackup23 = "Weakness Potion (1:30)";
			}
			if (itemsubid == 8201 || itemsubid == 16281) {
				isapotion = true;
				itemnamebackup23 = "Strength Potion (3:00)";
			}
			if (itemsubid == 8202 || itemsubid == 16314) {
				isapotion = true;
				itemnamebackup23 = "Slowness Potion (1:30)";
			}
			if (itemsubid == 8204) {
				isapotion = true;
				itemnamebackup23 = "Harming Potion";
			}
			if (itemsubid == 8225 || itemsubid == 16305) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Potion II (0:22)";
			}
			if (itemsubid == 8226 || itemsubid == 16306) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Potion II (1:30)";
			}
			if (itemsubid == 8227) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Potion (3:00)";
			}
			if (itemsubid == 8228 || itemsubid == 16308) {
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
			if (itemsubid == 8233 || itemsubid == 16313) {
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
			if (itemsubid == 8257 || itemsubid == 16337) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Potion (2:00)";
			}
			if (itemsubid == 8258 || itemsubid == 16338) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Potion (8:00)";
			}
			if (itemsubid == 8259 || itemsubid == 16371) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Potion (8:00)";
			}
			if (itemsubid == 8260 || itemsubid == 16340) {
				isapotion = true;
				itemnamebackup23 = "Poison Potion (2:00)";
			}
			if (itemsubid == 8261) {
				isapotion = true;
				itemnamebackup23 = "Healing Potion)";
			}
			if (itemsubid == 8264 || itemsubid == 16376) {
				isapotion = true;
				itemnamebackup23 = "Weakness Potion (4:00)";
			}
			if (itemsubid == 8265 || itemsubid == 16345) {
				isapotion = true;
				itemnamebackup23 = "Strength Potion (8:00)";
			}
			if (itemsubid == 8266 || itemsubid == 16378) {
				isapotion = true;
				itemnamebackup23 = "Slowness Potion (4:00)";
			}
			if (itemsubid == 8268) {
				isapotion = true;
				itemnamebackup23 = "Harming Potion";
			}

			//

			if (itemsubid == 16369) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Potion II (1:00)";
			}

			if (itemsubid == 16370) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Potion II (4:00)";
			}

			if (itemsubid == 16372) {
				isapotion = true;
				itemnamebackup23 = "Poison Potion II (1:00)";
			}

			if (itemsubid == 16377) {
				isapotion = true;
				itemnamebackup23 = "Strength Potion II (4:00)";
			}

			//

			//

			if (itemsubid == 16385 || itemsubid == 32657) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Splash (0:33)";
			}
			if (itemsubid == 16386 || itemsubid == 32658) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Splash (2:15)";
			}
			if (itemsubid == 16387 || itemsubid == 32691) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Splash (2:15)";
			}
			if (itemsubid == 16388 || itemsubid == 32660) {
				isapotion = true;
				itemnamebackup23 = "Poison Splash (0:33)";
			}
			if (itemsubid == 16389 || itemsubid == 32725) {
				isapotion = true;
				itemnamebackup23 = "Instant Health Splash";
			}
			if (itemsubid == 16392 || itemsubid == 32696) {
				isapotion = true;
				itemnamebackup23 = "Weakness Splash (1:07))";
			}
			if (itemsubid == 16393 || itemsubid == 32665) {
				isapotion = true;
				itemnamebackup23 = "Strength Splash (2:15)";
			}
			if (itemsubid == 16394 || itemsubid == 32698) {
				isapotion = true;
				itemnamebackup23 = "Slowness Splash (1:07)";
			}
			if (itemsubid == 16396 || itemsubid == 32732) {
				isapotion = true;
				itemnamebackup23 = "Instant Damage Splash";
			}
			if (itemsubid == 16417 || itemsubid == 32689) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Splash II (0:16)";
			}
			if (itemsubid == 16418 || itemsubid == 32690) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Splash II (1:07)";
			}
			if (itemsubid == 16419) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Splash (2:15)";
			}
			if (itemsubid == 16420 || itemsubid == 32692) {
				isapotion = true;
				itemnamebackup23 = "Poison Splash II (0:16)";
			}
			if (itemsubid == 16421 || itemsubid == 32757) {
				isapotion = true;
				itemnamebackup23 = "Instant Health Splash II";
			}
			if (itemsubid == 16424) {
				isapotion = true;
				itemnamebackup23 = "Weakness Splash (1:07)";
			}
			if (itemsubid == 16425 || itemsubid == 32697) {
				isapotion = true;
				itemnamebackup23 = "Strength Splash II (1:07)";
			}
			if (itemsubid == 16426) {
				isapotion = true;
				itemnamebackup23 = "Slowness Splash (1:07)";
			}
			if (itemsubid == 16428 || itemsubid == 32764) {
				isapotion = true;
				itemnamebackup23 = "Instant Damage Splash II";
			}
			if (itemsubid == 16449 || itemsubid == 32721) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Splash (1:30)";
			}
			if (itemsubid == 16450 || itemsubid == 32722) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Splash (6:00)";
			}
			if (itemsubid == 16451 || itemsubid == 32755) {
				isapotion = true;
				itemnamebackup23 = "Fire Resistance Splash (6:00)";
			}
			if (itemsubid == 16452 || itemsubid == 32724) {
				isapotion = true;
				itemnamebackup23 = "Poison Splash (1:30)";
			}
			if (itemsubid == 16453) {
				isapotion = true;
				itemnamebackup23 = "Instant Health Splash";
			}
			if (itemsubid == 16456 || itemsubid == 32760) {
				isapotion = true;
				itemnamebackup23 = "Weakness Splash (3:00)";
			}
			if (itemsubid == 16457 || itemsubid == 32729) {
				isapotion = true;
				itemnamebackup23 = "Strength Splash (6:00)";
			}
			if (itemsubid == 16458 || itemsubid == 32762) {
				isapotion = true;
				itemnamebackup23 = "Slowness Splash (3:00)";
			}
			if (itemsubid == 16460) {
				isapotion = true;
				itemnamebackup23 = "Instant Damage Splash";
			}
			if (itemsubid == 32753) {
				isapotion = true;
				itemnamebackup23 = "Regeneration Splash II (0:45)";
			}
			if (itemsubid == 32754) {
				isapotion = true;
				itemnamebackup23 = "Swiftness Splash II (3:00)";
			}
			if (itemsubid == 32756) {
				isapotion = true;
				itemnamebackup23 = "Poison Splash II (0:45)";
			}
			if (itemsubid == 32761) {
				isapotion = true;
				itemnamebackup23 = "Strength Splash II (3:00)";
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

		if (itemid == 2256) {
			manualnameset = true;
			itemnamebackup23 = "13 Music Disk §7(§6Gold§7)§6";
		}
		if (itemid == 2257) {
			manualnameset = true;
			itemnamebackup23 = "Cat Music Disk §7(§aGreen§7)§6";
		}
		if (itemid == 2258) {
			manualnameset = true;
			itemnamebackup23 = "Blocks Music Disk §7(§cOrange§7)§6";
		}
		if (itemid == 2259) {
			manualnameset = true;
			itemnamebackup23 = "Chirp Music Disk §7(§4Red§7)§6";
		}
		if (itemid == 2260) {
			manualnameset = true;
			itemnamebackup23 = "Far Music Disk §7(§aG§7/§eY§7/§fW§7)§6";
		}
		if (itemid == 2261) {
			manualnameset = true;
			itemnamebackup23 = "Mall Music Disk §7(§5Purple§7)§6";
		}
		if (itemid == 2262) {
			manualnameset = true;
			itemnamebackup23 = "Mellohi Music Disk §7(§dP§7/§fW§7)§6";
		}

		if (itemid == 2263) {
			manualnameset = true;
			itemnamebackup23 = "Stal Music Disk §7(§0Black§7)§6";
		}

		if (itemid == 2264) {
			manualnameset = true;
			itemnamebackup23 = "Stard Music Disk §7(§fWhite§7)§6";
		}
		if (itemid == 2265) {
			manualnameset = true;
			itemnamebackup23 = "Stard Music Disk §7(§2G§7/§aG§7)§6";
		}
		if (itemid == 2266) {
			manualnameset = true;
			itemnamebackup23 = "13 Music Disk §7(§3Broken§7)§6";
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
						"DropParty.Items." + itemname + ".AddedTime")
						* howmany2;

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

			if (plugin.getdroppartyConfig().contains(
					"DropParty.Items." + itemname2 + ".AddedTime")) {

				int timetoadd = plugin.getdroppartyConfig().getInt(
						"DropParty.Items." + itemname2 + ".AddedTime")
						* howmany2;

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
												.getInt("DropParty.Items.POTION.AddedTime")
												* howmany2;

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

						int timetoadd = plugin.getdroppartyConfig().getInt(
								"DropParty.Items.SPLASH.AddedTime")
								* howmany2;

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

				if (itemname2.contains("SPAWNER_EGG")) {

					if (plugin.getdroppartyConfig().contains(
							"DropParty.Items.SPAWNER_EGG.AddedTime")) {

						other = true;

						int timetoadd = plugin.getdroppartyConfig().getInt(
								"DropParty.Items.SPAWNER_EGG.AddedTime")
								* howmany2;

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
								"DropParty.Items.WOOL.AddedTime")
								* howmany2;

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
								"DropParty.Items.DYE.AddedTime")
								* howmany2;

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

			if (manualnameset == true) {

				if (plugin.getdroppartyConfig().contains(
						"DropParty.Items." + itemname2 + ".Message")) {

					if (plugin.getdroppartyConfig().getBoolean(
							"DropParty.Items." + itemname2 + ".Message") == false) {

						message = null;

					}

				}

			}

		}

		if (manualnameset == false) {

			if (plugin.getdroppartyConfig().contains(
					"DropParty.Items." + itemname + ".Message")) {

				if (plugin.getdroppartyConfig().getBoolean(
						"DropParty.Items." + itemname + ".Message") == false) {

					message = null;

				}

			}

		}

		if (message != null) {

			String enchantmentstoadd = "";

			if (player.getItemInHand().containsEnchantment(
					Enchantment.ARROW_DAMAGE)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.ARROW_DAMAGE);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Arrow Damage " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.ARROW_FIRE)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.ARROW_FIRE);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Fire Arrows " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.ARROW_INFINITE)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.ARROW_INFINITE);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Infinite Arrows " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}

			if (player.getItemInHand().containsEnchantment(
					Enchantment.ARROW_KNOCKBACK)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.ARROW_KNOCKBACK);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Arrow Knockback " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.DAMAGE_ALL)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.DAMAGE_ALL);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "More Damage " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.DAMAGE_ARTHROPODS)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.DAMAGE_ARTHROPODS);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Arthropods " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.DAMAGE_UNDEAD)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.DAMAGE_UNDEAD);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Undead Damage " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.DIG_SPEED)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.DIG_SPEED);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Dig Speed " + ChatColor.GRAY + "["
						+ ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.DURABILITY)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.DURABILITY);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Durability " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.FIRE_ASPECT)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.FIRE_ASPECT);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Fire " + ChatColor.GRAY + "["
						+ ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.KNOCKBACK)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.KNOCKBACK);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Knockback " + ChatColor.GRAY + "["
						+ ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.LOOT_BONUS_BLOCKS)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.LOOT_BONUS_BLOCKS);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Block Loot " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.LOOT_BONUS_MOBS)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.LOOT_BONUS_MOBS);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Mob Loot " + ChatColor.GRAY + "["
						+ ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(Enchantment.OXYGEN)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.OXYGEN);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Oxygen " + ChatColor.GRAY + "["
						+ ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.PROTECTION_ENVIRONMENTAL)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.PROTECTION_ENVIRONMENTAL);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Environment Protection "
						+ ChatColor.GRAY + "[" + ChatColor.RED + level
						+ ChatColor.GRAY + "]" + ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.PROTECTION_EXPLOSIONS)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.PROTECTION_EXPLOSIONS);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Explosion Protection "
						+ ChatColor.GRAY + "[" + ChatColor.RED + level
						+ ChatColor.GRAY + "]" + ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.PROTECTION_FALL)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.PROTECTION_FALL);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Fall Protection " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.PROTECTION_FIRE)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.PROTECTION_FIRE);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Fire Protection " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.PROTECTION_PROJECTILE)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.PROTECTION_PROJECTILE);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Projectile Protection "
						+ ChatColor.GRAY + "[" + ChatColor.RED + level
						+ ChatColor.GRAY + "]" + ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.SILK_TOUCH)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.SILK_TOUCH);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Silk Touch " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}
			if (player.getItemInHand().containsEnchantment(
					Enchantment.WATER_WORKER)) {
				int level = player.getItemInHand().getEnchantmentLevel(
						Enchantment.WATER_WORKER);
				enchantmentstoadd = enchantmentstoadd + ChatColor.GOLD + " ("
						+ ChatColor.GREEN + "Water Worker " + ChatColor.GRAY
						+ "[" + ChatColor.RED + level + ChatColor.GRAY + "]"
						+ ChatColor.GOLD + ")";
			}

			String newmessage = message.replace(player.getName(), "").replace(
					"just", "You");

			player.sendMessage(newmessage + enchantmentstoadd);

			while (test02 > test01) {

				Entity entity = list.get(test01);
				if (entity instanceof Player) {
					((Player) entity).getPlayer().sendMessage(
							message + enchantmentstoadd);

				}

				test01++;
			}

		}

	}

}
