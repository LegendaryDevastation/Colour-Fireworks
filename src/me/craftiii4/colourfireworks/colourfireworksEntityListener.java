

package me.craftiii4.colourfireworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.craftiii4.colourfireworks.fireworks.FireworkExp;
import me.craftiii4.colourfireworks.fireworks.FireworkPumpkin;
import me.craftiii4.colourfireworks.fireworks.FireworkSnowBlock;
import me.craftiii4.colourfireworks.fireworks.colour.WoolBlack;
import me.craftiii4.colourfireworks.fireworks.colour.WoolBlue;
import me.craftiii4.colourfireworks.fireworks.colour.WoolBrown;
import me.craftiii4.colourfireworks.fireworks.colour.WoolCyan;
import me.craftiii4.colourfireworks.fireworks.colour.WoolGray;
import me.craftiii4.colourfireworks.fireworks.colour.WoolGreen;
import me.craftiii4.colourfireworks.fireworks.colour.WoolLightBlue;
import me.craftiii4.colourfireworks.fireworks.colour.WoolLightGray;
import me.craftiii4.colourfireworks.fireworks.colour.WoolLime;
import me.craftiii4.colourfireworks.fireworks.colour.WoolMagenta;
import me.craftiii4.colourfireworks.fireworks.colour.WoolOrange;
import me.craftiii4.colourfireworks.fireworks.colour.WoolPink;
import me.craftiii4.colourfireworks.fireworks.colour.WoolPurple;
import me.craftiii4.colourfireworks.fireworks.colour.WoolRed;
import me.craftiii4.colourfireworks.fireworks.colour.WoolWhite;
import me.craftiii4.colourfireworks.fireworks.colour.WoolYellow;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Boat;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Item;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class colourfireworksEntityListener implements Listener {

	public static colourfireworks plugin;
	public String EntityAttack;

	//public colourfireworksEntityListener(colourfireworks instance) {
	//	plugin = instance;
	//	plugin.getServer().getPluginManager().registerEvents(this, plugin);
	//}
	
	public colourfireworksEntityListener(colourfireworks instance) {
		plugin = instance;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		EntityAttack = null;
	}
	

	
	// If an entity has exploded run
	

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		
		final ItemStack cake = new ItemStack(Material.CAKE, 1);


		// Check to see if the explosion was due to TNT
		if (event.getEntity() instanceof TNTPrimed) {

			// Check to see if fireworks damage is set to false or true
			if (plugin.getConfig().getBoolean("Fireworks.DamageBlocks") == false) {

				// }
				// if (!main.getBoolean("FireworksDamage")) {
				Entity block2 = event.getEntity();
				// If false then check if it was a fire work

				int wasitafirework1;

				wasitafirework1 = block2.getFireTicks();

				if (wasitafirework1 > 82) {
					if (wasitafirework1 < 103) {
						// If it was a fire work then cancel the explosion, and
						// create a new one with no damage
						event.setCancelled(true);
						event.getEntity().getWorld()
								.createExplosion(event.getLocation(), 0.0F);
					}

				}

			}
			if (plugin.getConfig().getBoolean("Custom.Config.DamageBlocks") == false) {

				// }
				// if (!main.getBoolean("FireworksDamage")) {
				Entity block2 = event.getEntity();
				// If false then check if it was a fire work

				int wasitafirework1;

				wasitafirework1 = block2.getFireTicks();

				if (wasitafirework1 > 200) {
					if (wasitafirework1 < 300) {
						// If it was a fire work then cancel the explosion, and
						// create a new one with no damage
						event.setCancelled(true);
						event.getEntity().getWorld()
								.createExplosion(event.getLocation(), 0.0F);
					}

				}

			}

			// If yes then find if it was a fire work
			Entity block = event.getEntity();

			// Tell the script that "rand" is a random figure
			Random rand = new Random();

			if (plugin.customConfig.contains("Custom.Firework1.use") == true) {

				int custx;
				custx = 1;
				while (plugin.customConfig.contains("Custom.Firework" + custx
						+ ".use") == true) {
					if (plugin.customConfig.getBoolean("Custom.Firework"
							+ custx + ".use") == true) {

						int customfireworkticks;
						customfireworkticks = plugin.customConfig
								.getInt("Custom.Firework" + custx
										+ ".fireticks");

						if (block.getFireTicks() == customfireworkticks) {

							if (plugin.customConfig.contains("Custom.Firework"
									+ custx + ".ExpOrp.Amount")) {

								double exp;
								exp = 0;

								int exp1;
								exp1 = plugin.customConfig
										.getInt("Custom.Firework" + custx
												+ ".ExpOrp.Amount");
								Math.round(exp1);
								int exp2;
								exp2 = plugin.customConfig
										.getInt("Custom.Firework" + custx
												+ ".ExpOrp.Value");

								while (exp1 > exp) {
									double r1;
									double r2;
									double r3;
									r1 = rand.nextDouble();
									r2 = rand.nextDouble();
									r3 = rand.nextDouble();
									r1 = (r1 * 8) - 4;
									r1 = (r1 / 10);
									r2 = (r2 * 8) - 4;
									r2 = (r2 / 10);

									r3 = (r3 * 8) - 4;
									r3 = (r3 / 10);
									final ExperienceOrb orb = block.getWorld()
											.spawn(block.getLocation(),
													ExperienceOrb.class);

									orb.setExperience(exp2);
									orb.setVelocity(new Vector(r1, r3, r2));

									if (plugin.customConfig
											.getBoolean("Fireworks.Exp.Remove.Allow") == true) {

									}

									orb.setVelocity(new Vector(r1, r3, r2));
									exp = (exp + 1);
								}

							} else {
								String customfireworks12 = "Custom.Firework"
										+ custx + ".ExpOrp.Amount";
								plugin.customConfig.addDefault(
										customfireworks12, 0);
								String customfireworks13 = "Custom.Firework"
										+ custx + ".ExpOrp.Value";
								plugin.customConfig.addDefault(
										customfireworks13, 0);
							}

							int item01;
							item01 = 0;

							int idnumber;
							idnumber = 1;

							int item00;

							while (plugin.customConfig
									.getBoolean("Custom.Firework" + custx
											+ ".ItemsDroped.ID" + idnumber
											+ ".use") == true) {
								item00 = plugin.customConfig
										.getInt("Custom.Firework" + custx
												+ ".ItemsDroped.ID" + idnumber
												+ ".Amount");
								
								int itemspread = plugin.customConfig
										.getInt("Custom.Firework" + custx
												+ ".ItemsDroped.ID" + idnumber
												+ ".ItemSpread");
								
								item01 = 0;

								while (item00 > item01) {


									double r1;
									double r2;
									double r3;

									int r01;
									int r02;

									r01 = itemspread;
									r01 = (r01 * 2);

									r02 = itemspread;

									r1 = rand.nextDouble();
									r2 = rand.nextDouble();
									r3 = rand.nextDouble();

									r1 = (r1 * r01) - r02;
									r2 = (r2 * r01) - r02;

									r1 = (r1 / 10);
									r2 = (r2 / 10);

									r3 = (r3 * r01) - r02;
									r3 = (r3 / 10);

									int itemuser;
									itemuser = plugin.customConfig
											.getInt("Custom.Firework" + custx
													+ ".ItemsDroped.ID"
													+ idnumber + ".ItemID");
									ItemStack itemid2 = new ItemStack(itemuser,
											1);

									int enchantmentexist = 1;

									while (plugin.getCustomConfig().contains(
											"Custom.Firework" + custx
													+ ".ItemsDroped.ID"
													+ idnumber + ".Enchantment"
													+ enchantmentexist
													+ ".Type")) {

										String EnchantmentToAdd = plugin
												.getCustomConfig()
												.getString(
														"Custom.Firework"
																+ custx
																+ ".ItemsDroped.ID"
																+ idnumber
																+ ".Enchantment"
																+ enchantmentexist
																+ ".Type")
												.toUpperCase();

										int LevelEnchantmentToAdd = plugin
												.getCustomConfig()
												.getInt("Custom.Firework"
														+ custx
														+ ".ItemsDroped.ID"
														+ idnumber
														+ ".Enchantment"
														+ enchantmentexist
														+ ".Level");

										if (EnchantmentToAdd
												.equals("ARROW_DAMAGE")) {
											if (itemuser == 261) {
												itemid2.addEnchantment(
														Enchantment.ARROW_DAMAGE,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("ARROW_FIRE")) {
											if (itemuser == 261) {
												itemid2.addEnchantment(
														Enchantment.ARROW_FIRE,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("ARROW_INFINITE")) {
											if (itemuser == 261) {
												itemid2.addEnchantment(
														Enchantment.ARROW_INFINITE,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("ARROW_KNOCKBACK")) {
											if (itemuser == 261) {
												itemid2.addEnchantment(
														Enchantment.ARROW_KNOCKBACK,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("PROTECTION_ENVIRONMENTAL")) {
											if (itemuser >= 298
													&& itemuser <= 317) {
												itemid2.addEnchantment(
														Enchantment.PROTECTION_ENVIRONMENTAL,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("PROTECTION_EXPLOSIONS")) {
											if (itemuser >= 298
													&& itemuser <= 317) {
												itemid2.addEnchantment(
														Enchantment.PROTECTION_EXPLOSIONS,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("PROTECTION_FALL")) {
											if (itemuser == 301
													|| itemuser == 305
													|| itemuser == 309
													|| itemuser == 313
													|| itemuser == 317) {
												itemid2.addEnchantment(
														Enchantment.PROTECTION_FALL,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("PROTECTION_FIRE")) {
											if (itemuser >= 298
													&& itemuser <= 317) {
												itemid2.addEnchantment(
														Enchantment.PROTECTION_FIRE,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("PROTECTION_PROJECTILE")) {
											if (itemuser >= 298
													&& itemuser <= 317) {
												itemid2.addEnchantment(
														Enchantment.PROTECTION_PROJECTILE,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd.equals("OXYGEN")) {
											if (itemuser == 298
													|| itemuser == 302
													|| itemuser == 306
													|| itemuser == 310
													|| itemuser == 314) {
												itemid2.addEnchantment(
														Enchantment.OXYGEN,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("WATER_WORKER")) {
											if (itemuser == 298
													|| itemuser == 302
													|| itemuser == 306
													|| itemuser == 310
													|| itemuser == 314) {
												itemid2.addEnchantment(
														Enchantment.WATER_WORKER,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("DURABILITY")) {
											if (itemuser == 269
													|| itemuser == 270
													|| itemuser == 271
													|| itemuser == 273
													|| itemuser == 274
													|| itemuser == 275
													|| itemuser == 277
													|| itemuser == 278
													|| itemuser == 279
													|| itemuser == 284
													|| itemuser == 285
													|| itemuser == 286
													|| itemuser == 256
													|| itemuser == 257
													|| itemuser == 258) {
												itemid2.addEnchantment(
														Enchantment.DURABILITY,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("DIG_SPEED")) {
											if (itemuser == 269
													|| itemuser == 270
													|| itemuser == 271
													|| itemuser == 273
													|| itemuser == 274
													|| itemuser == 275
													|| itemuser == 277
													|| itemuser == 278
													|| itemuser == 279
													|| itemuser == 284
													|| itemuser == 285
													|| itemuser == 286
													|| itemuser == 256
													|| itemuser == 257
													|| itemuser == 258) {
												itemid2.addEnchantment(
														Enchantment.DIG_SPEED,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("LOOT_BONUS_BLOCKS")) {
											if (itemuser == 269
													|| itemuser == 270
													|| itemuser == 271
													|| itemuser == 273
													|| itemuser == 274
													|| itemuser == 275
													|| itemuser == 277
													|| itemuser == 278
													|| itemuser == 279
													|| itemuser == 284
													|| itemuser == 285
													|| itemuser == 286
													|| itemuser == 256
													|| itemuser == 257
													|| itemuser == 258) {
												itemid2.addEnchantment(
														Enchantment.LOOT_BONUS_BLOCKS,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("SILK_TOUCH")) {
											if (itemuser == 269
													|| itemuser == 270
													|| itemuser == 271
													|| itemuser == 273
													|| itemuser == 274
													|| itemuser == 275
													|| itemuser == 277
													|| itemuser == 278
													|| itemuser == 279
													|| itemuser == 284
													|| itemuser == 285
													|| itemuser == 286
													|| itemuser == 256
													|| itemuser == 257
													|| itemuser == 258) {
												itemid2.addEnchantment(
														Enchantment.SILK_TOUCH,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("FIRE_ASPECT")) {
											if (itemuser == 267
													|| itemuser == 268
													|| itemuser == 272
													|| itemuser == 276
													|| itemuser == 283) {
												itemid2.addEnchantment(
														Enchantment.FIRE_ASPECT,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("KNOCKBACK")) {
											if (itemuser == 267
													|| itemuser == 268
													|| itemuser == 272
													|| itemuser == 276
													|| itemuser == 283) {
												itemid2.addEnchantment(
														Enchantment.KNOCKBACK,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("LOOT_BONUS_MOBS")) {
											if (itemuser == 267
													|| itemuser == 268
													|| itemuser == 272
													|| itemuser == 276
													|| itemuser == 283) {
												itemid2.addEnchantment(
														Enchantment.LOOT_BONUS_MOBS,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("DAMAGE_ARTHROPODS")) {
											if (itemuser == 267
													|| itemuser == 268
													|| itemuser == 272
													|| itemuser == 276
													|| itemuser == 283) {
												itemid2.addEnchantment(
														Enchantment.DAMAGE_ARTHROPODS,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("DAMAGE_ALL")) {
											if (itemuser == 267
													|| itemuser == 268
													|| itemuser == 272
													|| itemuser == 276
													|| itemuser == 283) {
												itemid2.addEnchantment(
														Enchantment.DAMAGE_ALL,
														LevelEnchantmentToAdd);
											}
										}
										if (EnchantmentToAdd
												.equals("DAMAGE_UNDEAD")) {
											if (itemuser == 267
													|| itemuser == 268
													|| itemuser == 272
													|| itemuser == 276
													|| itemuser == 283) {
												itemid2.addEnchantment(
														Enchantment.DAMAGE_UNDEAD,
														LevelEnchantmentToAdd);
											}
										}
										enchantmentexist++;
									}

									if (plugin.customConfig
											.getInt("Custom.Firework" + custx
													+ ".ItemsDroped.ID"
													+ idnumber + ".ItemSubID") >= 0) {
										int whattosetitto = (plugin.customConfig
												.getInt("Custom.Firework"
														+ custx
														+ ".ItemsDroped.ID"
														+ idnumber
														+ ".ItemSubID"));

										itemid2.setDurability((short) whattosetitto);

									}

									final Item customfire = block.getWorld()
											.dropItemNaturally(
													block.getLocation(),
													itemid2);
									
									customfire.setItemStack(cake);
									
									final ItemStack itemid2final = itemid2;
									
									
									if (plugin.customConfig
											.getBoolean("Custom.Firework"
													+ custx + ".ItemsDroped.ID"
													+ idnumber
													+ ".CanBePickedUp") == false) {
										customfire.setTicksLived(999999999);
									}
									customfire
											.setVelocity(new Vector(r1, 0, r2));
									if (plugin.customConfig
											.getBoolean("Custom.Firework"
													+ custx + ".ItemsDroped.ID"
													+ idnumber + ".SetAlight") == true) {
										customfire.setFireTicks(300);
									}
									
									plugin.getServer()
									.getScheduler()
									.scheduleSyncDelayedTask(plugin,
											new Runnable() {

												public void run() {

													customfire.setItemStack(itemid2final);

												}
											}, 20);
									
									
									item01 = (item01 + 1);
								}
								idnumber = idnumber + 1;

							}
							double mob01;
							mob01 = 0;

							int mobnumber;
							mobnumber = 1;

							int mob00;

							while (plugin.customConfig
									.getBoolean("Custom.Firework" + custx
											+ ".Mob" + mobnumber + ".use") == true) {
								mob00 = plugin.customConfig
										.getInt("Custom.Firework" + custx
												+ ".Mob" + mobnumber
												+ ".Amount");
								mob01 = 0;
								while (mob00 > mob01) {

									double r1;
									double r2;
									r1 = rand.nextDouble();
									r2 = rand.nextDouble();
									r1 = (r1 * 8) - 4;
									r1 = (r1 / 10);
									r2 = (r2 * 8) - 4;
									r2 = (r2 / 10);

									String mobtype;
									mobtype = plugin.customConfig
											.getString("Custom.Firework"
													+ custx + ".Mob"
													+ mobnumber + ".Mobname");

									int wherey;
									int wherex;
									int wherez;

									wherex = block.getLocation().getBlockX();
									wherez = block.getLocation().getBlockZ();

									wherey = block.getWorld()
											.getHighestBlockYAt(wherex, wherez);

									Location wheretospawnmob = new Location(
											block.getWorld(), wherex, wherey,
											wherez);

									// block.getWorld().spawnCreature(
									// wheretospawnmob,
									// CreatureType.valueOf(mobtype
									// .toUpperCase()));

									block.getWorld().spawnCreature(
											wheretospawnmob,
											EntityType.valueOf(mobtype
													.toUpperCase()));

									mob01 = (mob01 + 1);
								}
								mobnumber = mobnumber + 1;

							}

						}
					}
					custx = custx + 1;
				}
			}

			// Check to see if the TNT that exploded fire ticks is set to 99
			if (block.getFireTicks() <= 99 && block.getFireTicks() >= 84) {

				int dyeamount = plugin.getConfig()
						.getInt("Fireworks.Dye.Drops");
				boolean remove = plugin.getConfig().getBoolean(
						"Fireworks.Dye.Remove.Allow");
				boolean effect = plugin.getConfig().getBoolean(
						"Fireworks.Dye.Remove.PlayEffect");
				boolean pickup = plugin.getConfig().getBoolean(
						"Fireworks.Dye.CanBePickedUp");
				boolean setonfire = plugin.getConfig().getBoolean(
						"Fireworks.Dye.SetAlight");

				int ticksuntillremove = plugin.getConfig().getInt(
						"Fireworks.Dye.Remove.Ticks");

				int itemspread = plugin.getConfig().getInt(
						"Fireworks.Dye.ItemSpread");

				if (block.getFireTicks() == 99) {
					WoolWhite.RunWoolWhite(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 98) {
					WoolOrange.RunWoolOrange(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 97) {
					WoolMagenta.RunWoolMagenta(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 96) {
					WoolLightBlue.RunWoolLightBlue(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 95) {
					WoolYellow.RunWoolYellow(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 94) {
					WoolLime.RunWoolLime(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 93) {
					WoolPink.RunWoolPink(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 92) {
					WoolGray.RunWoolGray(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 91) {
					WoolLightGray.RunWoolLightGray(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 90) {
					WoolCyan.RunWoolCyan(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 89) {
					WoolPurple.RunWoolPurple(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 88) {
					WoolBlue.RunWoolBlue(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 87) {
					WoolBrown.RunWoolBrown(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 86) {
					WoolGreen.RunWoolGreen(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 85) {
					WoolRed.RunWoolRed(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
				if (block.getFireTicks() == 84) {
					WoolBlack.RunWoolBlack(plugin, block, rand, dyeamount,
							itemspread, pickup, setonfire, remove, effect,
							ticksuntillremove);
				}
			}

			if (block.getFireTicks() == 72) {

				int slot = 0;

				int other = colourfireworks.HowManyItemsInTotal.get("total");

				while (other > slot) {

					slot++;

					int itemid;
					int itemidsub;
					int itemammount;

					itemid = colourfireworks.WhatIsSlotItemsID.get(slot);

					itemidsub = colourfireworks.WhatIsSlotItemsSUBID.get(slot);

					itemammount = colourfireworks.HowManySlotItems.get(slot);
					
					String enchantments = colourfireworks.Enchantments.get(slot);
					
					List<String> list = new ArrayList<String>(Arrays.asList(enchantments.split(",")));
										
					
					
					
					

					if (itemid == 0) {
						// ignore
					} else {

						int howmany = 0;
						
						int itemspread = plugin.getdroppartyConfig().getInt("DropParty.ItemSpread.Spread");
						int itemspread2 = plugin.getdroppartyConfig().getInt("DropParty.ItemSpread.SecondsReleasedOver");
						
						while (itemammount > howmany) {
							
							double r1;
							double r2;
							double r3;

							int r01;
							int r02;

							r01 = itemspread;
							r01 = (r01 * 2);

							r02 = itemspread;

							r1 = rand.nextDouble();
							r2 = rand.nextDouble();
							r3 = rand.nextDouble();

							r1 = (r1 * r01) - r02;
							r2 = (r2 * r01) - r02;

							r1 = (r1 / 10);
							r2 = (r2 / 10);

							r3 = (r3 * itemspread2);
							
							
							//double r1;
							//double r2;
							//double r3;
							//r1 = rand.nextDouble();
							//r2 = rand.nextDouble();
							//r3 = rand.nextDouble();
							//r1 = (r1 * 10) - 5;
							//r1 = (r1 / 8);
							//r2 = (r2 * 10) - 5;
							//r2 = (r2 / 8);

							//r3 = (r3 * 6) - 4;
							//r3 = (r3 / 8);
							
							
							ItemStack itemid2 = new ItemStack(itemid, 1);
							itemid2.setDurability((short) itemidsub);
							
							int enchant = 0;

							int enchantother = list.size();

							while (enchantother > enchant) {
								
								String enchantment = list.get(enchant);
								
								if (!enchantment.equals("")) {
								
								String enchantment2 = enchantment.replace(",", "");
								String levelstring = enchantment2.substring(enchantment2.lastIndexOf(':') + 1);
								
								String completeenchant = enchantment2.replace(":", "").replace(levelstring, "");								
								
								int level = Integer.parseInt(levelstring);
								
								if (completeenchant
										.equals("ARROW_DAMAGE")) {
									itemid2.addEnchantment(Enchantment.ARROW_DAMAGE, level);
								}
								if (completeenchant
										.equals("ARROW_FIRE")) {
									itemid2.addEnchantment(Enchantment.ARROW_FIRE, level);
								}
								if (completeenchant
										.equals("ARROW_INFINITE")) {
									itemid2.addEnchantment(Enchantment.ARROW_INFINITE, level);
								}
								if (completeenchant
										.equals("ARROW_KNOCKBACK")) {
									itemid2.addEnchantment(Enchantment.ARROW_KNOCKBACK, level);
								}
								if (completeenchant
										.equals("PROTECTION_ENVIRONMENTAL")) {
									itemid2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, level);
								}
								if (completeenchant
										.equals("PROTECTION_EXPLOSIONS")) {
									itemid2.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, level);
								}
								if (completeenchant
										.equals("PROTECTION_FALL")) {
									itemid2.addEnchantment(Enchantment.PROTECTION_FALL, level);
								}
								if (completeenchant
										.equals("PROTECTION_FIRE")) {
									itemid2.addEnchantment(Enchantment.PROTECTION_FIRE, level);
								}
								if (completeenchant
										.equals("PROTECTION_PROJECTILE")) {
									itemid2.addEnchantment(Enchantment.PROTECTION_PROJECTILE, level);
								}
								if (completeenchant.equals("OXYGEN")) {
									itemid2.addEnchantment(Enchantment.OXYGEN, level);
								}
								if (completeenchant
										.equals("WATER_WORKER")) {
									itemid2.addEnchantment(Enchantment.WATER_WORKER, level);
								}
								if (completeenchant
										.equals("DURABILITY")) {
									itemid2.addEnchantment(Enchantment.DURABILITY, level);
								}
								if (completeenchant
										.equals("DIG_SPEED")) {
									itemid2.addEnchantment(Enchantment.DIG_SPEED, level);
								}
								if (completeenchant
										.equals("LOOT_BONUS_BLOCKS")) {
									itemid2.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, level);
								}
								if (completeenchant
										.equals("SILK_TOUCH")) {
									itemid2.addEnchantment(Enchantment.SILK_TOUCH, level);
								}
								if (completeenchant
										.equals("FIRE_ASPECT")) {
									itemid2.addEnchantment(Enchantment.FIRE_ASPECT, level);
								}
								if (completeenchant
										.equals("KNOCKBACK")) {
									itemid2.addEnchantment(Enchantment.KNOCKBACK, level);
								}
								if (completeenchant
										.equals("LOOT_BONUS_MOBS")) {
									itemid2.addEnchantment(Enchantment.LOOT_BONUS_MOBS, level);
								}
								if (completeenchant
										.equals("DAMAGE_ARTHROPODS")) {
									itemid2.addEnchantment(Enchantment.DAMAGE_ARTHROPODS, level);
								}
								if (completeenchant
										.equals("DAMAGE_ALL")) {
									itemid2.addEnchantment(Enchantment.DAMAGE_ALL, level);
								}
								if (completeenchant
										.equals("DAMAGE_UNDEAD")) {
									itemid2.addEnchantment(Enchantment.DAMAGE_UNDEAD, level);
								}
								
								}
					
								enchant++;
							}
							
							boolean hideon = colourfireworks.Hide.get("hide");
							
							final Item customdropfire;
							
							if (hideon == true) {
								customdropfire = block.getWorld()
										.dropItemNaturally(block.getLocation(),
												cake);
							}  else {
							
							customdropfire = block.getWorld()
									.dropItemNaturally(block.getLocation(),
											itemid2);
							}
							
							
							
							final ItemStack dropitemid2final = itemid2;
							
							customdropfire.setItemStack(cake);	
											
							customdropfire.setVelocity(new Vector(r1, r3, r2));
							
							plugin.getServer()
							.getScheduler()
							.scheduleSyncDelayedTask(plugin,
									new Runnable() {

										public void run() {

											customdropfire.setItemStack(dropitemid2final);
											

										}
									}, 20);
							
							howmany++;

						}

					}

				}

				colourfireworks.allreadyone.clear();
				colourfireworks.HowManyItemsInTotal.clear();
				colourfireworks.HowManySlotItems.clear();
				colourfireworks.WhatIsSlotItemsID.clear();
				colourfireworks.WhatIsSlotItemsSUBID.clear();
				colourfireworks.Enchantments.clear();
				colourfireworks.Max.put("insofar", 0);

			}

			if (block.getFireTicks() == 102) {

				int golemammount;
				golemammount = plugin.getConfig().getInt(
						"Fireworks.Snow.SnowMen");

				int itemspread;
				itemspread = plugin.getConfig().getInt(
						"Fireworks.Snow.ItemSpread");

				int snowlol;
				int diamondlol;
				int goldlol;

				snowlol = plugin.getConfig().getInt(
						"Fireworks.Snow.Drops.Snowball");
				diamondlol = plugin.getConfig().getInt(
						"Fireworks.Snow.Drops.Diamond");
				goldlol = plugin.getConfig()
						.getInt("Fireworks.Snow.Drops.Gold");

				FireworkSnowBlock.RunSnowBlockExplode(plugin, block, rand,
						snowlol, goldlol, diamondlol, golemammount, itemspread);

			}
			if (block.getFireTicks() == 501) {

				int golemammount;
				golemammount = plugin.getEconomyConfig().getInt(
						"Economy.SnowBlock.Spawn.SnowGolem");

				int itemspread;
				itemspread = plugin.getEconomyConfig().getInt(
						"Economy.SnowBlock.Drops.ItemSpread");

				int snowlol;
				int diamondlol;
				int goldlol;

				snowlol = plugin.getEconomyConfig().getInt(
						"Economy.SnowBlock.Drops.SnowBall");
				diamondlol = plugin.getEconomyConfig().getInt(
						"Economy.SnowBlock.Drops.Diamond");
				goldlol = plugin.getEconomyConfig().getInt(
						"Economy.SnowBlock.Drops.Gold");

				FireworkSnowBlock.RunSnowBlockExplode(plugin, block, rand,
						snowlol, goldlol, diamondlol, golemammount, itemspread);

			}

			if (block.getFireTicks() == 83) {

				int orbamount = plugin.getConfig().getInt(
						"Fireworks.Exp.Amount");
				int orbvalue = plugin.getConfig().getInt("Fireworks.Exp.Worth");
				int itemspread = plugin.getConfig().getInt(
						"Fireworks.Exp.Spread");
				int ticksuntillremove = plugin.getConfig().getInt(
						"Fireworks.Exp.Remove.Ticks");

				boolean remove = plugin.getConfig().getBoolean(
						"Fireworks.Exp.Remove.Allow");
				boolean effect = plugin.getConfig().getBoolean(
						"Fireworks.Exp.Remove.PlayEffect");

				FireworkExp
						.RunExpBlockExplode(plugin, block, rand, orbamount,
								orbvalue, itemspread, remove, effect,
								ticksuntillremove);

			}
			if (block.getFireTicks() == 502) {

				int orbamount = plugin.getEconomyConfig().getInt(
						"Economy.Exp.Amount");
				int orbvalue = plugin.getEconomyConfig().getInt(
						"Economy.Exp.Worth");
				int itemspread = plugin.getEconomyConfig().getInt(
						"Economy.Exp.Spread");
				int ticksuntillremove = plugin.getEconomyConfig().getInt(
						"Economy.Exp.Remove.Ticks");

				boolean remove = plugin.getEconomyConfig().getBoolean(
						"Economy.Exp.Remove.Allow");
				boolean effect = plugin.getEconomyConfig().getBoolean(
						"Economy.Exp.Remove.PlayEffect");

				FireworkExp
						.RunExpBlockExplode(plugin, block, rand, orbamount,
								orbvalue, itemspread, remove, effect,
								ticksuntillremove);

			}
			
			if (block.getFireTicks() >= 504 && block.getFireTicks() <= 519) {
				int dyeamount = plugin.getEconomyConfig().getInt(
						"Economy.Wool.Drops");
				int itemspread = plugin.getEconomyConfig().getInt(
						"Economy.Wool.ItemSpread");
				int ticksuntillremove = plugin.getEconomyConfig().getInt(
						"Economy.Wool.Remove.Ticks");

				boolean remove = plugin.getEconomyConfig().getBoolean(
						"Economy.Wool.Remove.Allow");
				boolean effect = plugin.getEconomyConfig().getBoolean(
						"Economy.Wool.Remove.PlayEffect");
				
				boolean pickup = plugin.getEconomyConfig().getBoolean(
						"Economy.Wool.CanBePickedUp");
				boolean setonfire = plugin.getEconomyConfig().getBoolean(
						"Economy.Wool.SetAlight");
				if (block.getFireTicks() == 504) {		
					WoolWhite.RunWoolWhite(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 505) {		
					WoolOrange.RunWoolOrange(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 506) {		
					WoolMagenta.RunWoolMagenta(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 507) {		
					WoolLightBlue.RunWoolLightBlue(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 508) {		
					WoolYellow.RunWoolYellow(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 509) {		
					WoolLime.RunWoolLime(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 510) {		
					WoolPink.RunWoolPink(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 511) {		
					WoolGray.RunWoolGray(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 512) {		
					WoolLightGray.RunWoolLightGray(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 513) {		
					WoolCyan.RunWoolCyan(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 514) {		
					WoolPurple.RunWoolPurple(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 515) {		
					WoolBlue.RunWoolBlue(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 516) {		
					WoolBrown.RunWoolBrown(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 517) {		
					WoolGreen.RunWoolGreen(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 518) {		
					WoolRed.RunWoolRed(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
				if (block.getFireTicks() == 519) {		
					WoolBlack.RunWoolBlack(plugin, block, rand, dyeamount, itemspread, pickup, setonfire, remove, effect, ticksuntillremove);
				}
			}
			

			if (block.getFireTicks() == 101) {

				int webamount;
				webamount = plugin.getConfig()
						.getInt("Fireworks.Pumpkin.Drops");
				webamount = (webamount / 2);
				Math.round(webamount);

				int pumpkinamount;
				pumpkinamount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Drops");
				pumpkinamount = (pumpkinamount / 4);
				Math.round(pumpkinamount);

				int cakeamount;
				cakeamount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Drops");
				cakeamount = (cakeamount / 8);
				Math.round(cakeamount);

				int cookieamount;
				cookieamount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Drops");
				cookieamount = (cookieamount / 8);
				Math.round(cookieamount);

				int spideramount;
				spideramount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Spiders");

				int itemspread;
				itemspread = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.ItemSpread");

				FireworkPumpkin.RunPumpkinExplode(plugin, block, rand,
						cookieamount, cakeamount, pumpkinamount, webamount,
						spideramount, itemspread);

			}

			if (block.getFireTicks() == 503) {

				int webamount;
				webamount = plugin.getEconomyConfig().getInt(
						"Economy.Pumpkin.Drops");
				webamount = (webamount / 2);
				Math.round(webamount);

				int pumpkinamount;
				pumpkinamount = plugin.getEconomyConfig().getInt(
						"Economy.Pumpkin.Drops");
				pumpkinamount = (pumpkinamount / 4);
				Math.round(pumpkinamount);

				int cakeamount;
				cakeamount = plugin.getEconomyConfig().getInt(
						"Economy.Pumpkin.Drops");
				cakeamount = (cakeamount / 8);
				Math.round(cakeamount);

				int cookieamount;
				cookieamount = plugin.getEconomyConfig().getInt(
						"Economy.Pumpkin.Drops");
				cookieamount = (cookieamount / 8);
				Math.round(cookieamount);

				int spideramount;
				spideramount = plugin.getEconomyConfig().getInt(
						"Economy.Pumpkin.Spiders");

				int itemspread;
				itemspread = plugin.getEconomyConfig().getInt(
						"Economy.Pumpkin.ItemSpread");

				FireworkPumpkin.RunPumpkinExplode(plugin, block, rand,
						cookieamount, cakeamount, pumpkinamount, webamount,
						spideramount, itemspread);

			}

		}

	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
			
		
		//if (!(event instanceof EntityDamageByEntityEvent)
		//		|| !(event.getEntity() instanceof Player)) {
		//	EntityAttack = event.getCause().name();
		//}
		
		//if (event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent) {
		
		if (event instanceof EntityDamageByEntityEvent) {
			
			
			EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) event;
			
			
			if (damageEvent.getDamager() instanceof TNTPrimed) {
				
				

				if (damageEvent.getDamager().getFireTicks() >= 72) {
					

					if (event.getEntity() instanceof Player) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.Player") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof NPC) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.NPC") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Item) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.Item") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Boat) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.Boat") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Minecart) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.Minecart") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof ExperienceOrb) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.ExperienceOrb") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof TNTPrimed) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.TNTPrimed") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Arrow) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.Arrow") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Fireball) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.Fireball") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Painting) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.Painting") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Snowball) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Misc.Snowball") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Chicken) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.Chicken") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Cow) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.Cow") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof IronGolem) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.IronGolem") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Ocelot) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.Ocelot") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Pig) {
						if (event.getEntity() instanceof PigZombie) {
						} else {
							if (plugin.getConfig().getBoolean(
									"Fireworks.EntityDamage.Animal.Pig") == false) {
								event.setCancelled(true);
							}
						}
					}
					if (event.getEntity() instanceof Sheep) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.Sheep") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Snowman) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.Snowman") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Squid) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.Squid") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Villager) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.Villager") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Wolf) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Animal.Wolf") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Blaze) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Blaze") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof CaveSpider) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.CaveSpider") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Creeper) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Creeper") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof EnderDragon) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.EnderDragon") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Enderman) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Enderman") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Ghast) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Ghast") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Giant) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Giant") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof MagmaCube) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.MagmaCube") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof PigZombie) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.PigZombie") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Silverfish) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Silverfish") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Skeleton) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Skeleton") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Slime) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Slime") == false) {
							event.setCancelled(true);
						}
					}
					if (event.getEntity() instanceof Spider) {
						if (event.getEntity() instanceof CaveSpider) {
						} else {
							if (plugin.getConfig().getBoolean(
									"Fireworks.EntityDamage.Hostile.Spider") == false) {
								event.setCancelled(true);
							}
						}
					}
					if (event.getEntity() instanceof Zombie) {
						if (plugin.getConfig().getBoolean(
								"Fireworks.EntityDamage.Hostile.Zombie") == false) {
							event.setCancelled(true);
						}
					}
				}
			}
		}

	}
	
}
