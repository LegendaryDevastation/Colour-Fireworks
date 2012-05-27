//You may not copy the exact code!
//You can use the code to understand how it works!
//CopyWrited



package me.craftiii4.colourfireworks;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class colourfireworksEntityListener implements Listener {

	public static colourfireworks plugin;

	//public colourfireworksEntityListener(colourfireworks instance) {
	//	plugin = instance;
	//	plugin.getServer().getPluginManager().registerEvents(this, plugin);
	//}
	
	public colourfireworksEntityListener(colourfireworks instance) {
		plugin = instance;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	// If an entity has exploded run
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		// Defining all dyes and items
		ItemStack white = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.WHITE.getData()));
		ItemStack orange = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.ORANGE.getData()));
		ItemStack magenta = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.MAGENTA.getData()));
		ItemStack lblue = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.LIGHT_BLUE.getData()));
		ItemStack yellow = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.YELLOW.getData()));
		ItemStack lime = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.LIME.getData()));
		ItemStack pink = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.PINK.getData()));
		ItemStack grey = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.GRAY.getData()));
		ItemStack silver = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.SILVER.getData()));
		ItemStack cyan = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.CYAN.getData()));
		ItemStack purple = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.PURPLE.getData()));
		ItemStack blue = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.BLUE.getData()));
		ItemStack brown = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.BROWN.getData()));
		ItemStack green = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.GREEN.getData()));
		ItemStack red = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.RED.getData()));
		ItemStack black = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.BLACK.getData()));
		ItemStack web = new ItemStack(Material.WEB, 1);
		ItemStack pumpkin = new ItemStack(Material.PUMPKIN, 1);
		ItemStack cake = new ItemStack(Material.CAKE, 1);
		ItemStack cookie = new ItemStack(Material.COOKIE, 1);
		ItemStack snowball = new ItemStack(Material.SNOW_BALL, 1);
		ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
		ItemStack goldi = new ItemStack(Material.GOLD_INGOT, 1);

		// Check to see if the explosion was due to TNT
		if (event.getEntity() instanceof TNTPrimed) {
			
			final int secoundsfordye = plugin.getConfig().getInt("Fireworks.Dye.Remove.Ticks");		
			final int secoundsforexp = plugin.getConfig().getInt("Fireworks.Exp.Remove.Ticks");		

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
			if (plugin.getConfig().getBoolean("Fireworks.Custom.DamageBlocks") == false) {

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
				while (plugin.customConfig.contains(
						"Custom.Firework" + custx + ".use") == true) {
					if (plugin.customConfig.getBoolean(
							"Custom.Firework" + custx + ".use") == true) {

						int customfireworkticks;
						customfireworkticks = plugin.customConfig.getInt(
								"Custom.Firework" + custx + ".fireticks");

						if (block.getFireTicks() == customfireworkticks) {
							
							if (plugin.customConfig.contains("Custom.Firework" + custx + ".ExpOrp.Ammount")) {
								
								double exp;
								exp = 0;

								int exp1;
								exp1 = plugin.customConfig.getInt("Custom.Firework" + custx
										+ ".ExpOrp.Ammount");
								Math.round(exp1);
								int exp2;
								exp2 = plugin.customConfig.getInt("Custom.Firework" + custx
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
								    final ExperienceOrb orb = block.getWorld().spawn(block.getLocation(), ExperienceOrb.class);

								    orb.setExperience(exp2);
								    orb.setVelocity(new Vector(r1, r3, r2));
									
									if (plugin.customConfig.getBoolean("Fireworks.Exp.Remove.Allow") == true) {
										
									
									}
									
									orb.setVelocity(new Vector(r1, r3, r2));
									exp = (exp + 1);
								}
								
							} else {
								String customfireworks12 = "Custom.Firework" + custx
										+ ".ExpOrp.Ammount";				
								plugin.customConfig.addDefault(customfireworks12, 0);
								String customfireworks13 = "Custom.Firework" + custx
										+ ".ExpOrp.Value";				
								plugin.customConfig.addDefault(customfireworks13, 0);
							}

							double item01;
							item01 = 0;

							int idnumber;
							idnumber = 1;

							int item00;

							while (plugin.customConfig.getBoolean(
									"Custom.Firework" + custx
											+ ".ItemsDroped.ID" + idnumber
											+ ".use") == true) {
								item00 = plugin.customConfig.getInt(
										"Custom.Firework" + custx
												+ ".ItemsDroped.ID" + idnumber
												+ ".Ammount");
								item01 = 0;

								while (item00 > item01) {

									double r1;
									double r2;
									r1 = rand.nextDouble();
									r2 = rand.nextDouble();
									r1 = (r1 * 8) - 4;
									r1 = (r1 / 10);
									r2 = (r2 * 8) - 4;
									r2 = (r2 / 10);

									int itemuser;
									itemuser = plugin.customConfig.getInt(
											"Custom.Firework" + custx
													+ ".ItemsDroped.ID"
													+ idnumber + ".ItemID");
									ItemStack itemid2 = new ItemStack(itemuser,
											1);

									Item customfire = block.getWorld()
											.dropItemNaturally(
													block.getLocation(),
													itemid2);
									if (plugin.customConfig.getBoolean(
											"Custom.Firework" + custx
													+ ".ItemsDroped.ID"
													+ idnumber
													+ ".CanBePickedUp") == false) {
										customfire.setTicksLived(999999999);
									}
									customfire
											.setVelocity(new Vector(r1, 0, r2));
									if (plugin.customConfig.getBoolean(
											"Custom.Firework" + custx
													+ ".ItemsDroped.ID"
													+ idnumber + ".SetAlight") == true) {
										customfire.setFireTicks(300);
									}
									item01 = (item01 + 1);
								}
								idnumber = idnumber + 1;

							}
							double mob01;
							mob01 = 0;

							int mobnumber;
							mobnumber = 1;

							int mob00;

							while (plugin.customConfig.getBoolean(
									"Custom.Firework" + custx + ".Mob"
											+ mobnumber + ".use") == true) {
								mob00 = plugin.customConfig.getInt(
										"Custom.Firework" + custx + ".Mob"
												+ mobnumber + ".Ammount");
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
									mobtype = plugin.customConfig.getString(
											"Custom.Firework" + custx + ".Mob"
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

									//block.getWorld().spawnCreature(
									//		wheretospawnmob,
									//		CreatureType.valueOf(mobtype
									//				.toUpperCase()));
									
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

			if (block.getFireTicks() == 102) {

				double snowlol1;
				snowlol1 = 0;
				double diamondlol1;
				diamondlol1 = 0;
				double goldlol1;
				goldlol1 = 0;

				double golemlol;
				golemlol = 0;

				int golemammount;
				golemammount = plugin.getConfig().getInt(
						"Fireworks.Snow.SnowMen");

				int snowlol;
				int diamondlol;
				int goldlol;

				snowlol = plugin.getConfig().getInt(
						"Fireworks.Snow.Drops.Snowball");
				diamondlol = plugin.getConfig().getInt(
						"Fireworks.Snow.Drops.Diamond");
				goldlol = plugin.getConfig()
						.getInt("Fireworks.Snow.Drops.Gold");

				Math.round(snowlol);

				while (golemammount > golemlol) {
					block.getWorld().spawnCreature(
							block.getLocation().subtract(0, 10, 0),
							EntityType.SNOWMAN);
					golemlol = (golemlol + 1);
				}

				while (snowlol > snowlol1) {

					double r1;
					double r2;

					int r01;
					int r02;

					r01 = plugin.getConfig()
							.getInt("Fireworks.Snow.ItemSpread");
					r01 = (r01 * 2);

					r02 = plugin.getConfig()
							.getInt("Fireworks.Snow.ItemSpread");

					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					// r1 = (r1 * 8) - 4;
					// r1 = (r1 / 10);

					r1 = (r1 * r01) - r02;
					r2 = (r2 * r01) - r02;

					r1 = (r1 / 10);
					r2 = (r2 / 10);
					// r2 = (r2 * 8) - 4;
					// r2 = (r2 / 10);

					Item snowfire = block.getWorld().dropItemNaturally(
							block.getLocation(), snowball);
					if (plugin.getConfig().getBoolean(
							"Fireworks.Snow.CanBePickedUp.SnowBalls") == false) {
						snowfire.setTicksLived(999999999);
					}
					snowfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig().getBoolean(
							"Fireworks.Snow.SetAlight.SnowBalls") == true) {
						snowfire.setFireTicks(300);
					}
					snowlol1 = (snowlol1 + 1);
				}
				while (diamondlol > diamondlol1) {

					double r1;
					double r2;

					int r01;
					int r02;

					r01 = plugin.getConfig()
							.getInt("Fireworks.Snow.ItemSpread");
					r01 = (r01 * 2);

					r02 = plugin.getConfig()
							.getInt("Fireworks.Snow.ItemSpread");

					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					// r1 = (r1 * 8) - 4;
					// r1 = (r1 / 10);

					r1 = (r1 * r01) - r02;
					r2 = (r2 * r01) - r02;

					r1 = (r1 / 10);
					r2 = (r2 / 10);
					// r2 = (r2 * 8) - 4;
					// r2 = (r2 / 10);

					Item snowdiamondfire = block.getWorld().dropItemNaturally(
							block.getLocation(), diamond);
					if (plugin.getConfig().getBoolean(
							"Fireworks.Snow.CanBePickedUp.Diamonds") == false) {
						snowdiamondfire.setTicksLived(999999999);
					}
					snowdiamondfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig().getBoolean(
							"Fireworks.Snow.SetAlight.Diamonds") == true) {
						snowdiamondfire.setFireTicks(300);
					}
					diamondlol1 = (diamondlol1 + 1);
				}
				while (goldlol > goldlol1) {

					double r1;
					double r2;

					int r01;
					int r02;

					r01 = plugin.getConfig()
							.getInt("Fireworks.Snow.ItemSpread");
					r01 = (r01 * 2);

					r02 = plugin.getConfig()
							.getInt("Fireworks.Snow.ItemSpread");

					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					// r1 = (r1 * 8) - 4;
					// r1 = (r1 / 10);

					r1 = (r1 * r01) - r02;
					r2 = (r2 * r01) - r02;

					r1 = (r1 / 10);
					r2 = (r2 / 10);
					// r2 = (r2 * 8) - 4;
					// r2 = (r2 / 10);

					Item snowgoldfire = block.getWorld().dropItemNaturally(
							block.getLocation(), goldi);
					if (plugin.getConfig().getBoolean(
							"Fireworks.Snow.CanBePickedUp.Gold") == false) {
						snowgoldfire.setTicksLived(999999999);
					}
					snowgoldfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig().getBoolean(
							"Fireworks.Snow.SetAlight.Gold") == true) {
						snowgoldfire.setFireTicks(300);
					}
					goldlol1 = (goldlol1 + 1);
				}

			}

			// Check to see if the TNT that exploded fire ticks is set to 99
			if (block.getFireTicks() == 99) {
				// If yes, then run white fire work

				// Tell the script that "whitelol1" is a double number
				double whitelol1;
				// Set this number to 0
				whitelol1 = 0;

				// Tell the script that "whitelol" is a int number
				int whitelol;
				// Set this number to what the host has specified in the file
				// for the field "FireWorkDyeDrops"
				whitelol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				// Round this number to the nearest whole number (can't have
				// half an item dropping)
				Math.round(whitelol);

				// Check to see if "whitelol" is greater than "whitelol1"
				while (whitelol > whitelol1) {
					// If yes then run the script

					// Tell the script that r1 is double number
					double r1;
					// Tell the script that r2 is double number
					double r2;

					// Tell the script to generate a random number for r1
					// (between 0 - 1)
					r1 = rand.nextDouble();
					// Tell the script to generate a random number for r2
					// (between 0 - 1)
					r2 = rand.nextDouble();
					// Times r1 by 8, then - 4, this will give the script a
					// number between -4 and 4
					r1 = (r1 * 8) - 4;
					// Dived this new number by 10 to get a decimal between -0.4
					// and 0.4
					r1 = (r1 / 10);

					// Do the same for r2
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);

					// Create an item at the location in world that the TNT with
					// 99 fire ticks exploded
					final Item whitefire = block.getWorld().dropItemNaturally(
							block.getLocation(), white);
					

															
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
					
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	whitefire.getLocation().getWorld().playEffect(whitefire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);	
					    	}
					        	whitefire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						whitefire.setTicksLived(999999999);
					}

					// Set the velocity of this item to, X - r1, Y - 0, Z - r2
					whitefire.setVelocity(new Vector(r1, 0, r2));
					// Check to see if host has set items to catch on fire
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						// If yes alight the items
						whitefire.setFireTicks(300);
					}
					// Add one to whitelol1, If the number is still not greater
					// than "whitelol" then repeat
					whitelol1 = (whitelol1 + 1);
				}
				// When whitelol is no longer greater than whitelol1, end this
				// part of the script
			}
			// If the fire ticks were not 99, then check if they were 98
			if (block.getFireTicks() == 98) {
				// If yes, then run orange fire work

				// Tell the script that "orangelol1" is a double number
				double orangelol1;
				// Set this number to 0
				orangelol1 = 0;

				// Tell the script that "orangelol" is a int number
				int orangelol;
				// Set this number to what the host has specified in the file
				// for the field "FireWorkDyeDrops"
				orangelol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				// Round this number to the nearest whole number (can't have
				// half an item dropping)
				Math.round(orangelol);

				// Check to see if "orangelol" is greater than "orangelol1"
				while (orangelol > orangelol1) {
					// If yes then run the script

					// Tell the script that r1 is double number
					double r1;
					// Tell the script that r2 is double number
					double r2;

					// Tell the script to generate a random number for r1
					// (between 0 - 1)
					r1 = rand.nextDouble();
					// Tell the script to generate a random number for r2
					// (between 0 - 1)
					r2 = rand.nextDouble();
					// Times r1 by 8, then - 4, this will give the script a
					// number between -4 and 4
					r1 = (r1 * 8) - 4;
					// Dived this new number by 10 to get a decimal between -0.4
					// and 0.4
					r1 = (r1 / 10);

					// Do the same for r2
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);

					// Create an item at the location in world that the TNT with
					// 98 fire ticks exploded
					final Item orangefire = block.getWorld().dropItemNaturally(
							block.getLocation(), orange);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	orangefire.getLocation().getWorld().playEffect(orangefire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	orangefire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}

					// Check to see if the host wants users to be able to pick
					// up the dye
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						// If no then set the ticks lives to a high number
						orangefire.setTicksLived(999999999);
					}

					// Set the velocity of this item to, X - r1, Y - 0, Z - r2
					orangefire.setVelocity(new Vector(r1, 0, r2));

					// Check to see if host has set items to catch on fire
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						// If yes alight the items
						orangefire.setFireTicks(300);
					}
					// Add one to orangelol1, If the number is still not greater
					// than "orangelol" then repeat
					orangelol1 = (orangelol1 + 1);
				}
				// When orangelol is no longer greater than orangelol1, end this
				// part of the script
			}
			// If the fire ticks were not 98, then check if they were 97
			if (block.getFireTicks() == 97) {
				double magentalol1;
				magentalol1 = 0;

				int magentalol;
				magentalol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(magentalol);

				while (magentalol > magentalol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item magentafire = block.getWorld().dropItemNaturally(
							block.getLocation(), magenta);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	magentafire.getLocation().getWorld().playEffect(magentafire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	magentafire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						magentafire.setTicksLived(999999999);
					}
					magentafire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						magentafire.setFireTicks(300);
					}
					magentalol1 = (magentalol1 + 1);
				}
			}
			if (block.getFireTicks() == 96) {
				double lbluelol1;
				lbluelol1 = 0;

				int lbluelol;
				lbluelol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(lbluelol);

				while (lbluelol > lbluelol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item lbluefire = block.getWorld().dropItemNaturally(
							block.getLocation(), lblue);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	lbluefire.getLocation().getWorld().playEffect(lbluefire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	lbluefire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						lbluefire.setTicksLived(999999999);
					}
					lbluefire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						lbluefire.setFireTicks(300);
					}
					lbluelol1 = (lbluelol1 + 1);
				}
			}
			if (block.getFireTicks() == 95) {
				double yellowlol1;
				yellowlol1 = 0;

				int yellowlol;
				yellowlol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(yellowlol);

				while (yellowlol > yellowlol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item yellowfire = block.getWorld().dropItemNaturally(
							block.getLocation(), yellow);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	yellowfire.getLocation().getWorld().playEffect(yellowfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	yellowfire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						yellowfire.setTicksLived(999999999);
					}
					yellowfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						yellowfire.setFireTicks(300);
					}
					yellowlol1 = (yellowlol1 + 1);
				}
			}
			if (block.getFireTicks() == 94) {
				double limelol1;
				limelol1 = 0;

				int limelol;
				limelol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(limelol);

				while (limelol > limelol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item limefire = block.getWorld().dropItemNaturally(
							block.getLocation(), lime);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	limefire.getLocation().getWorld().playEffect(limefire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	limefire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						limefire.setTicksLived(999999999);
					}
					limefire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						limefire.setFireTicks(300);
					}
					limelol1 = (limelol1 + 1);
				}
			}
			if (block.getFireTicks() == 93) {
				double pinklol1;
				pinklol1 = 0;

				int pinklol;
				pinklol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(pinklol);

				while (pinklol > pinklol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item pinkfire = block.getWorld().dropItemNaturally(
							block.getLocation(), pink);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	pinkfire.getLocation().getWorld().playEffect(pinkfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	pinkfire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						pinkfire.setTicksLived(999999999);
					}
					pinkfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						pinkfire.setFireTicks(300);
					}
					pinklol1 = (pinklol1 + 1);
				}
			}
			if (block.getFireTicks() == 92) {
				double greylol1;
				greylol1 = 0;

				int greylol;
				greylol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(greylol);

				while (greylol > greylol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item greyfire = block.getWorld().dropItemNaturally(
							block.getLocation(), grey);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	greyfire.getLocation().getWorld().playEffect(greyfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	greyfire.remove();					    
					    	
					}
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						greyfire.setTicksLived(999999999);
					}
					greyfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						greyfire.setFireTicks(300);
					}
					greylol1 = (greylol1 + 1);
				}
			}
			if (block.getFireTicks() == 91) {
				double silverlol1;
				silverlol1 = 0;

				int silverlol;
				silverlol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(silverlol);

				while (silverlol > silverlol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item silverfire = block.getWorld().dropItemNaturally(
							block.getLocation(), silver);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	silverfire.getLocation().getWorld().playEffect(silverfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	silverfire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						silverfire.setTicksLived(999999999);
					}
					silverfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						silverfire.setFireTicks(300);
					}
					silverlol1 = (silverlol1 + 1);
				}
			}
			if (block.getFireTicks() == 90) {
				double cyanlol1;
				cyanlol1 = 0;

				int cyanlol;
				cyanlol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(cyanlol);

				while (cyanlol > cyanlol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item cyanfire = block.getWorld().dropItemNaturally(
							block.getLocation(), cyan);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	cyanfire.getLocation().getWorld().playEffect(cyanfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	cyanfire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						cyanfire.setTicksLived(999999999);
					}
					cyanfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						cyanfire.setFireTicks(300);
					}
					cyanlol1 = (cyanlol1 + 1);
				}
			}
			if (block.getFireTicks() == 89) {
				double purplelol1;
				purplelol1 = 0;

				int purplelol;
				purplelol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(purplelol);

				while (purplelol > purplelol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item purplefire = block.getWorld().dropItemNaturally(
							block.getLocation(), purple);
										
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	purplefire.getLocation().getWorld().playEffect(purplefire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	purplefire.remove();					    
					    
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						purplefire.setTicksLived(999999999);
					}
					purplefire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						purplefire.setFireTicks(300);
					}
					purplelol1 = (purplelol1 + 1);
				}
			}
			if (block.getFireTicks() == 88) {
				double bluelol1;
				bluelol1 = 0;

				int bluelol;
				bluelol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(bluelol);

				while (bluelol > bluelol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item bluefire = block.getWorld().dropItemNaturally(
							block.getLocation(), blue);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	bluefire.getLocation().getWorld().playEffect(bluefire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	bluefire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						bluefire.setTicksLived(999999999);
					}
					bluefire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						bluefire.setFireTicks(300);
					}
					bluelol1 = (bluelol1 + 1);
				}
			}
			if (block.getFireTicks() == 87) {
				double brownlol1;
				brownlol1 = 0;

				int brownlol;
				brownlol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(brownlol);

				while (brownlol > brownlol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item brownfire = block.getWorld().dropItemNaturally(
							block.getLocation(), brown);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	brownfire.getLocation().getWorld().playEffect(brownfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	brownfire.remove();					    
					    	
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						brownfire.setTicksLived(999999999);
					}
					brownfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						brownfire.setFireTicks(300);
					}
					brownlol1 = (brownlol1 + 1);
				}
			}
			if (block.getFireTicks() == 86) {
				double greenlol1;
				greenlol1 = 0;

				int greenlol;
				greenlol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(greenlol);

				while (greenlol > greenlol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item greenfire = block.getWorld().dropItemNaturally(
							block.getLocation(), green);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	greenfire.getLocation().getWorld().playEffect(greenfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	greenfire.remove();	
					    	
					        
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						greenfire.setTicksLived(999999999);
					}
					greenfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						greenfire.setFireTicks(300);
					}
					greenlol1 = (greenlol1 + 1);
				}
			}
			if (block.getFireTicks() == 85) {
				double redlol1;
				redlol1 = 0;

				int redlol;
				redlol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(redlol);

				while (redlol > redlol1) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					final Item redfire = block.getWorld().dropItemNaturally(
							block.getLocation(), red);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	redfire.getLocation().getWorld().playEffect(redfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
					    	}
					    	redfire.remove();	
					    	
					        
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						redfire.setTicksLived(999999999);
					}
					redfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						redfire.setFireTicks(300);
					}
					redlol1 = (redlol1 + 1);
				}
			}

			if (block.getFireTicks() == 84) {

				double blacklol1;
				blacklol1 = 0;

				int blacklol;
				blacklol = plugin.getConfig().getInt("Fireworks.Dye.Drops");
				Math.round(blacklol);

				while (blacklol > blacklol1) {
					double r1;
					double r2;

					r1 = rand.nextDouble();
					r2 = rand.nextDouble();

					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					
					final Item blackfire = block.getWorld().dropItemNaturally(
							block.getLocation(), black);
					
					if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	
							if (plugin.getConfig().getBoolean("Fireworks.Dye.Remove.PlayEffect") == true) {
					    	
					    	blackfire.getLocation().getWorld().playEffect(blackfire.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
							}
					    	blackfire.remove();	
					    	
							
					        
					    }
					}, secoundsfordye);
					
					}
					
					if (plugin.getConfig().getBoolean(
							"Fireworks.Dye.CanBePickedUp") == false) {
						blackfire.setTicksLived(999999999);
					}
					blackfire.setVelocity(new Vector(r1, 0, r2));
					if (plugin.getConfig()
							.getBoolean("Fireworks.Dye.SetAlight") == true) {
						blackfire.setFireTicks(300);
					}
					blacklol1 = (blacklol1 + 1);
				}
			}
			
			if (block.getFireTicks() == 75) {
				
				
				
				
			}
			
			if (block.getFireTicks() == 83) {
				
				
				double exp;
				exp = 0;

				int exp1;
				exp1 = plugin.getConfig().getInt("Fireworks.Exp.Ammount");
				Math.round(exp1);
				
				
				
				while (exp1 > exp) {
					
					double r1;
					double r2;
					double r3;
					
					int r01;
					int r02;

					r01 = plugin.getConfig()
							.getInt("Fireworks.Exp.Spread");
					r01 = (r01 * 2);

					r02 = plugin.getConfig()
							.getInt("Fireworks.Exp.Spread");

					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r3 = rand.nextDouble();
					// r1 = (r1 * 8) - 4;
					// r1 = (r1 / 10);

					r1 = (r1 * r01) - r02;
					r2 = (r2 * r01) - r02;

					r1 = (r1 / 10);
					r2 = (r2 / 10);
					
					r3 = (r3 * r01) - r02;
					r3 = (r3 / 10);
					// r2 = (r2 * 8) - 4;
					// r2 = (r2 / 10);
					

				    final ExperienceOrb orb = block.getWorld().spawn(block.getLocation(), ExperienceOrb.class);
					int exp2;
					exp2 = plugin.getConfig().getInt("Fireworks.Exp.Worth");
				    orb.setExperience(exp2);
				    orb.setVelocity(new Vector(r1, r3, r2));
					
					if (plugin.getConfig().getBoolean("Fireworks.Exp.Remove.Allow") == true) {
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	
							if (plugin.getConfig().getBoolean("Fireworks.Exp.Remove.PlayEffect") == true) {
					    	
								orb.getLocation().getWorld().playEffect(orb.getLocation(), Effect.MOBSPAWNER_FLAMES, 60);					    	
							}
							orb.remove();	
					    	
							
					        
					    }
					}, secoundsforexp);
					
					}
					
					orb.setVelocity(new Vector(r1, r3, r2));
					exp = (exp + 1);
				}
				
			}

			if (block.getFireTicks() == 101) {
				double weblol;
				weblol = 0;
				double pumpkinlol;
				pumpkinlol = 0;
				double cakelol;
				cakelol = 0;
				double cookielol;
				cookielol = 0;
				double spiderlol;
				spiderlol = 0;

				int webammount;
				webammount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Drops");
				webammount = (webammount / 2);
				Math.round(webammount);

				int pumpkinammount;
				pumpkinammount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Drops");
				pumpkinammount = (pumpkinammount / 4);
				Math.round(pumpkinammount);

				int cakeammount;
				cakeammount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Drops");
				cakeammount = (cakeammount / 8);
				Math.round(cakeammount);

				int cookieammount;
				cookieammount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Drops");
				cookieammount = (cookieammount / 8);
				Math.round(cookieammount);

				int spiderammount;
				spiderammount = plugin.getConfig().getInt(
						"Fireworks.Pumpkin.Spiders");

				while (webammount > weblol) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					block.getWorld()
							.dropItemNaturally(block.getLocation(), web)
							.setVelocity(new Vector(r1, 0, r2));
					weblol = (weblol + 1);

				}

				while (pumpkinammount > pumpkinlol) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					block.getWorld()
							.dropItemNaturally(block.getLocation(), pumpkin)
							.setVelocity(new Vector(r1, 0, r2));
					pumpkinlol = (pumpkinlol + 1);

				}

				while (cakeammount > cakelol) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					block.getWorld()
							.dropItemNaturally(block.getLocation(), cake)
							.setVelocity(new Vector(r1, 0, r2));
					cakelol = (cakelol + 1);

				}

				while (cookieammount > cookielol) {
					double r1;
					double r2;
					r1 = rand.nextDouble();
					r2 = rand.nextDouble();
					r1 = (r1 * 8) - 4;
					r1 = (r1 / 10);
					r2 = (r2 * 8) - 4;
					r2 = (r2 / 10);
					block.getWorld()
							.dropItemNaturally(block.getLocation(), cookie)
							.setVelocity(new Vector(r1, 0, r2));
					cookielol = (cookielol + 1);

				}
				while (spiderammount > spiderlol) {
					block.getWorld().spawnCreature(
							block.getLocation().subtract(0, 10, 0),
							EntityType.SPIDER);
					spiderlol = (spiderlol + 1);
				}

			}

		}

	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		final Entity entity = event.getEntity();
		

			if (event.getEntity() instanceof EnderDragon) {
				
				if (event.getEntity().getLastDamage() == 158) {
					
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

					    public void run() {
					    	
					    	
					    	entity.remove();
					    	Bukkit.getWorld(entity.getWorld().getName()).strikeLightningEffect(entity.getLocation());
					    	
							
					        
					    }
					}, 100);
				}
			
		}
	}
	
}
