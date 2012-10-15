package me.craftiii4.colourfireworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import me.craftiii4.colourfireworks.api.FindItemName;
import me.craftiii4.colourfireworks.fireworks.FireworkExp;
import me.craftiii4.colourfireworks.fireworks.FireworkPumpkin;
import me.craftiii4.colourfireworks.fireworks.FireworkSnowBlock;
import me.craftiii4.colourfireworks.fireworks.WhichWoolBlock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

//import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class colourfireworksPlayerListener implements Listener {

	Random rand = new Random();
	public static colourfireworks plugin;
	
	public static Boolean AllowItem = null;

	// public colourfireworksPlayerListener(colourfireworks instance) {
	// plugin = instance;
	// plugin.getServer().getPluginManager().registerEvents(this, plugin);
	// }

	public colourfireworksPlayerListener(colourfireworks instance) {
		plugin = instance;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	// When a player interacts

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		
			
		
		if (player.hasPermission("colourfireworks.notifyupdate")
				|| player.isOp()) {

			if (plugin.getConfig().getBoolean(
					"Config.CheckforUpdate.Permission") == true) {
				
				
				plugin.getServer()
				.getScheduler()
				.scheduleSyncDelayedTask(plugin,
						new Runnable() {

							public void run() {

								try {
									URLReader.main2(plugin, player);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}
						}, 40);
				


				

			}

		}

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		// Check if the interaction was a player right clicking a block
		

		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)
				|| (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) {

			if (block.getState() instanceof Sign) {
				Sign sign = (Sign) block.getState();

				if (sign.getLine(1).equalsIgnoreCase(
						ChatColor.GOLD + "[Drop Party!]")) {

					Location placeofsign = block.getLocation();

					if (colourfireworksBlockListener.location != null) {

						if (placeofsign.toString().equals(
								colourfireworksBlockListener.location
										.toString())) {

							if (player
									.hasPermission("colourfireworks.dropparty.add")
									|| player.isOp()) {

								int iteminhandid = player.getItemInHand()
										.getTypeId();
								int iteminhandsubid = player.getItemInHand()
										.getDurability();
								int iteminhandammount = player.getItemInHand()
										.getAmount();

								int type = iteminhandid;
								int typesub = iteminhandsubid;
								int howmany = iteminhandammount;

								boolean correctammount = false;
								boolean alreadlydone = false;

								if (plugin
										.getdroppartyConfig()
										.getStringList("DropParty.BlockItemsId")
										.contains("" + type)) {
									alreadlydone = true;
									correctammount = false;
									player.sendMessage(ChatColor.RED
											+ "Error, That item is blocked!");
									event.setCancelled(true);
								}
								
								if (type == 387) {
									player.sendMessage(ChatColor.RED + "Written Books are not yet supported, sorry :(");
									alreadlydone = true;
									correctammount = false;
									event.setCancelled(true);
								}

								String enchantments = "";

								if (alreadlydone == false) {

									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.ARROW_DAMAGE)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.ARROW_DAMAGE);
										enchantments = enchantments
												+ "ARROW_DAMAGE:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.ARROW_FIRE)) {
										int level = player.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.ARROW_FIRE);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "ARROW_FIRE:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.ARROW_INFINITE)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.ARROW_INFINITE);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "ARROW_INFINITE:" + level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.ARROW_KNOCKBACK)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.ARROW_KNOCKBACK);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "ARROW_KNOCKBACK:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.DAMAGE_ALL)) {
										int level = player.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.DAMAGE_ALL);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "DAMAGE_ALL:" + level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.DAMAGE_ARTHROPODS)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.DAMAGE_ARTHROPODS);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "DAMAGE_ARTHROPODS:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.DAMAGE_UNDEAD)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.DAMAGE_UNDEAD);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "DAMAGE_UNDEAD:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.DIG_SPEED)) {
										int level = player.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.DIG_SPEED);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "DIG_SPEED:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.DURABILITY)) {
										int level = player.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.DURABILITY);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "DURABILITY:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.FIRE_ASPECT)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.FIRE_ASPECT);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "FIRE_ASPECT:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.KNOCKBACK)) {
										int level = player.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.KNOCKBACK);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "KNOCKBACK:" + level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.LOOT_BONUS_BLOCKS)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.LOOT_BONUS_BLOCKS);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "LOOT_BONUS_BLOCKS:" + level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.LOOT_BONUS_MOBS)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.LOOT_BONUS_MOBS);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "LOOT_BONUS_MOBS:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.OXYGEN)) {
										int level = player.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.OXYGEN);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments + "OXYGEN:"
												+ level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.PROTECTION_ENVIRONMENTAL)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.PROTECTION_ENVIRONMENTAL);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "PROTECTION_ENVIRONMENTAL:"
												+ level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.PROTECTION_EXPLOSIONS)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.PROTECTION_EXPLOSIONS);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "PROTECTION_EXPLOSIONS:"
												+ level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.PROTECTION_FALL)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.PROTECTION_FALL);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "PROTECTION_FALL:" + level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.PROTECTION_FIRE)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.PROTECTION_FIRE);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "PROTECTION_FIRE:" + level;
									}
									if (player
											.getItemInHand()
											.containsEnchantment(
													Enchantment.PROTECTION_PROJECTILE)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.PROTECTION_PROJECTILE);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "PROTECTION_PROJECTILE:"
												+ level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.SILK_TOUCH)) {
										int level = player.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.SILK_TOUCH);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "SILK_TOUCH:" + level;
									}
									if (player.getItemInHand()
											.containsEnchantment(
													Enchantment.WATER_WORKER)) {
										int level = player
												.getItemInHand()
												.getEnchantmentLevel(
														Enchantment.WATER_WORKER);

										if (!enchantments.equals("")) {
											enchantments = enchantments + ",";
										}
										enchantments = enchantments
												+ "WATER_WORKER:" + level;
									}

								}
								if (alreadlydone == false) {
									if (iteminhandammount > 8) {
										alreadlydone = true;
										if (event.getAction().equals(
												Action.RIGHT_CLICK_BLOCK)) {
											howmany = 8;
											correctammount = true;
											// player.getItemInHand()
											// .setAmount(
											// player.getItemInHand()
											// .getAmount() - 6);
										}
										if (event.getAction().equals(
												Action.LEFT_CLICK_BLOCK)) {
											howmany = 1;
											correctammount = true;
											// player.getItemInHand()
											// .setAmount(
											// player.getItemInHand()
											// .getAmount() - 1);
										}

									}
								}

								if (alreadlydone == false) {
									if (iteminhandammount < 8) {
										if (iteminhandammount > 1) {
											alreadlydone = true;
											if (event.getAction().equals(
													Action.RIGHT_CLICK_BLOCK)) {
												howmany = 0;
												correctammount = false;
												player.sendMessage(ChatColor.RED
														+ "Error, You need to be holding 8 of that item!");
												event.setCancelled(true);
											}
											if (event.getAction().equals(
													Action.LEFT_CLICK_BLOCK)) {
												howmany = 1;
												correctammount = true;
												// player.getItemInHand().setAmount(
												// player.getItemInHand()
												// .getAmount() - 1);
											}

										}

									}
								}

								if (alreadlydone == false) {
									if (iteminhandammount == 1) {

										alreadlydone = true;
										if (event.getAction().equals(
												Action.RIGHT_CLICK_BLOCK)) {
											howmany = 0;
											correctammount = false;
											player.sendMessage(ChatColor.RED
													+ "Error, You need to be holding 8 of that item!");
											event.setCancelled(true);
										}
										if (event.getAction().equals(
												Action.LEFT_CLICK_BLOCK)) {
											howmany = 1;
											correctammount = true;
											// ItemStack test = new
											// ItemStack(type,
											// howmany);
											// test.setDurability((short)
											// typesub);
											// player.getInventory().removeItem(test);
										}

									}

								}

								if (alreadlydone == false) {
									if (iteminhandammount == 8) {

										alreadlydone = true;
										if (event.getAction().equals(
												Action.RIGHT_CLICK_BLOCK)) {
											howmany = 8;
											correctammount = true;
											// ItemStack test = new
											// ItemStack(type,
											// howmany);
											// test.setDurability((short)
											// typesub);
											// player.getInventory().removeItem(test);
										}
										if (event.getAction().equals(
												Action.LEFT_CLICK_BLOCK)) {
											howmany = 1;
											correctammount = true;
											// player.getItemInHand().setAmount(
											// player.getItemInHand()
											// .getAmount() - 1);
										}

									}

								}
								if (correctammount == true) {
									if (colourfireworks.Max
											.containsKey("insofar") == false) {
										colourfireworks.Max.put("insofar", 0);
									}

									int insofar = colourfireworks.Max
											.get("insofar") + howmany;
									int maxallowed = colourfireworks.Max
											.get("Max");

									if (insofar > maxallowed) {
										correctammount = false;
										player.sendMessage(ChatColor.RED
												+ "Error, That would go over the max allowed!");
										event.setCancelled(true);
									}
								}

								if (correctammount == true) {

									if (colourfireworks.HowManyItemsInTotal
											.containsKey("total") == false) {
										colourfireworks.HowManyItemsInTotal
												.put("total", 0);
									}

									int slot = colourfireworks.HowManyItemsInTotal
											.get("total");

									if (type != 0) {

										slot = slot + 1;

										ItemStack test = new ItemStack(type,
												howmany);
										test.setDurability((short) typesub);

										if (!enchantments.equals("")) {

											List<String> list = new ArrayList<String>(
													Arrays.asList(enchantments
															.split(",")));

											int enchant = 0;

											int enchantother = list.size();

											while (enchantother > enchant) {

												String enchantment = list
														.get(enchant);

												String enchantment2 = enchantment
														.replace(",", "");
												String levelstring = enchantment2
														.substring(enchantment2
																.lastIndexOf(':') + 1);

												String completeenchant = enchantment2
														.replace(":", "")
														.replace(levelstring,
																"");

												int level = Integer
														.parseInt(levelstring);

												if (completeenchant
														.equals("ARROW_DAMAGE")) {
													test.addEnchantment(
															Enchantment.ARROW_DAMAGE,
															level);
												}
												if (completeenchant
														.equals("ARROW_FIRE")) {
													test.addEnchantment(
															Enchantment.ARROW_FIRE,
															level);
												}
												if (completeenchant
														.equals("ARROW_INFINITE")) {
													test.addEnchantment(
															Enchantment.ARROW_INFINITE,
															level);
												}
												if (completeenchant
														.equals("ARROW_KNOCKBACK")) {
													test.addEnchantment(
															Enchantment.ARROW_KNOCKBACK,
															level);
												}
												if (completeenchant
														.equals("PROTECTION_ENVIRONMENTAL")) {
													test.addEnchantment(
															Enchantment.PROTECTION_ENVIRONMENTAL,
															level);
												}
												if (completeenchant
														.equals("PROTECTION_EXPLOSIONS")) {
													test.addEnchantment(
															Enchantment.PROTECTION_EXPLOSIONS,
															level);
												}
												if (completeenchant
														.equals("PROTECTION_FALL")) {
													test.addEnchantment(
															Enchantment.PROTECTION_FALL,
															level);
												}
												if (completeenchant
														.equals("PROTECTION_FIRE")) {
													test.addEnchantment(
															Enchantment.PROTECTION_FIRE,
															level);
												}
												if (completeenchant
														.equals("PROTECTION_PROJECTILE")) {
													test.addEnchantment(
															Enchantment.PROTECTION_PROJECTILE,
															level);
												}
												if (completeenchant
														.equals("OXYGEN")) {
													test.addEnchantment(
															Enchantment.OXYGEN,
															level);
												}
												if (completeenchant
														.equals("WATER_WORKER")) {
													test.addEnchantment(
															Enchantment.WATER_WORKER,
															level);
												}
												if (completeenchant
														.equals("DURABILITY")) {
													test.addEnchantment(
															Enchantment.DURABILITY,
															level);
												}
												if (completeenchant
														.equals("DIG_SPEED")) {
													test.addEnchantment(
															Enchantment.DIG_SPEED,
															level);
												}
												if (completeenchant
														.equals("LOOT_BONUS_BLOCKS")) {
													test.addEnchantment(
															Enchantment.LOOT_BONUS_BLOCKS,
															level);
												}
												if (completeenchant
														.contains("SILK_TOUCH")) {
													test.addEnchantment(
															Enchantment.SILK_TOUCH,
															level);
												}
												if (completeenchant
														.equals("FIRE_ASPECT")) {
													test.addEnchantment(
															Enchantment.FIRE_ASPECT,
															level);
												}
												if (completeenchant
														.equals("KNOCKBACK")) {
													test.addEnchantment(
															Enchantment.KNOCKBACK,
															level);
												}
												if (completeenchant
														.equals("LOOT_BONUS_MOBS")) {
													test.addEnchantment(
															Enchantment.LOOT_BONUS_MOBS,
															level);
												}
												if (completeenchant
														.equals("DAMAGE_ARTHROPODS")) {
													test.addEnchantment(
															Enchantment.DAMAGE_ARTHROPODS,
															level);
												}
												if (completeenchant
														.equals("DAMAGE_ALL")) {
													test.addEnchantment(
															Enchantment.DAMAGE_ALL,
															level);
												}
												if (completeenchant
														.equals("DAMAGE_UNDEAD")) {
													test.addEnchantment(
															Enchantment.DAMAGE_UNDEAD,
															level);
												}

												enchant++;
											}
										}

										FindItemName.RunFindItemName(plugin,
												player, player.getItemInHand()
														.getType().toString(),
												type, typesub, howmany);

										player.getInventory().removeItem(test);
										player.updateInventory();

										colourfireworks.WhatIsSlotItemsID.put(
												slot, type);
										colourfireworks.WhatIsSlotItemsSUBID
												.put(slot, typesub);
										colourfireworks.HowManySlotItems.put(
												slot, howmany);
										colourfireworks.Enchantments.put(slot,
												enchantments);

										colourfireworks.HowManyItemsInTotal
												.put("total", slot);

										int insofar = colourfireworks.Max
												.get("insofar") + howmany;
										colourfireworks.Max.put("insofar",
												insofar);

										event.setCancelled(true);

									} else {

										player.sendMessage(ChatColor.RED
												+ "Error, You must have an item in your hand!");

									}

								}

							} else {
								player.sendMessage(ChatColor.RED
										+ "You do not have permission to add to drop parties!");
							}

						} else {
							player.sendMessage(ChatColor.RED
									+ "An error occured! Sign not found!");
							block.setType(Material.AIR);
						}

					} else {
						
						if (sign.getLine(0).contains("[A]")) {
							if (!colourfireworks.allreadyone.containsKey("On")) {
								Sign sign2 = (Sign) block.getState();
								Location placeofchest = sign2.getLocation();
								

								player.sendMessage(ChatColor.GOLD
										+ "DropParty Started");
								
								colourfireworksBlockListener.location = placeofchest;
								
								colourfireworks.allreadyone.put("On", true);
								
								int radius = plugin.getdroppartyConfig().getInt(
										"DropParty.Message.Radius");

								colourfireworks.MaxandMin.clear();
								colourfireworks.dpworld.clear();
								
								
								colourfireworks.MaxandMin.put("MaxX", block
										.getLocation().getBlockX() + radius);
								
								colourfireworks.MaxandMin.put("MinX", block
										.getLocation().getBlockX() - radius);

								colourfireworks.MaxandMin.put("MaxZ", block
										.getLocation().getBlockZ() + radius);
								colourfireworks.MaxandMin.put("MinZ", block
										.getLocation().getBlockZ() - radius);

								colourfireworks.MaxandMin.put("MaxY", block
										.getLocation().getBlockY() + radius);
								colourfireworks.MaxandMin.put("MinY", block
										.getLocation().getBlockY() - radius);

								colourfireworks.dpworld.put("World", block.getWorld()
										.getName());

								String wname = colourfireworks.dpworld.get("World");

								double maxx = colourfireworks.MaxandMin.get("MaxX");
								double minx = colourfireworks.MaxandMin.get("MinX");

								double maxy = colourfireworks.MaxandMin.get("MaxY");
								double miny = colourfireworks.MaxandMin.get("MinY");

								double maxz = colourfireworks.MaxandMin.get("MaxZ");
								double minz = colourfireworks.MaxandMin.get("MinZ");
								
								List<Player> playersinworld = Bukkit.getWorld(wname)
										.getPlayers();

								int test01 = 0;
								int test02 = playersinworld.size();

								while (test02 > test01) {
									Player playerpicked = playersinworld.get(test01);

									if (playerpicked.getLocation().getBlockX() < maxx) {
										if (playerpicked.getLocation().getBlockX() > minx) {
											if (playerpicked.getLocation().getBlockY() < maxy) {
												if (playerpicked.getLocation().getBlockY() > miny) {
													if (playerpicked.getLocation()
															.getBlockZ() < maxz) {
														if (playerpicked.getLocation()
																.getBlockZ() > minz) {
															playerpicked
																	.sendMessage(ChatColor.GOLD
																			+ player.getName()
																			+ ChatColor.GREEN
																			+ " Has started a drop party! at:");
															playerpicked
																	.sendMessage(ChatColor.AQUA
																			+ "X "
																			+ ChatColor.LIGHT_PURPLE
																			+ block.getLocation()
																					.getBlockX()
																			+ ChatColor.GRAY
																			+ ", "
																			+ ChatColor.AQUA
																			+ "Y "
																			+ ChatColor.LIGHT_PURPLE
																			+ block.getLocation()
																					.getBlockY()
																			+ ChatColor.GRAY
																			+ ", "
																			+ ChatColor.AQUA
																			+ "Z "
																			+ ChatColor.LIGHT_PURPLE
																			+ block.getLocation()
																					.getBlockZ());

															playerpicked.sendMessage(ChatColor.GOLD+ "60 Secound timer started!");
														}
													}
												}
											}
										}
									}

									test01++;

								}
								
								if (sign.getLine(0).contains("[H]")) {
									colourfireworksBlockListener.startDropParty(player, true);
								}
								
								if (sign.getLine(0).contains("[V]")) {
									colourfireworksBlockListener.startDropParty(player, false);
								}

								colourfireworks.BlockSignOn.clear();
								
								colourfireworks.BlockSignOn.put("ID", sign.getBlock().getLocation().add(0, -1, 0).getBlock().getTypeId());
								colourfireworks.BlockSignOn.put("SUBID", (int) sign.getBlock().getLocation().add(0, -1, 0).getBlock().getData());
								
								sign.getBlock().getLocation().add(0, -1, 0).getBlock().setType(Material.BEDROCK);
								
								colourfireworks.HowManyItemsInTotal.clear();
								colourfireworks.HowManySlotItems.clear();
								colourfireworks.WhatIsSlotItemsID.clear();
								colourfireworks.WhatIsSlotItemsSUBID.clear();
								colourfireworks.Max.put("insofar", 0);


							} else {
								player.sendMessage(ChatColor.RED
										+ "Alreadly a drop party in progress!");
							}
						} else {
							player.sendMessage(ChatColor.RED
									+ "An error occured! No Drop Party currently active!");
							
							if (block.getLocation().add(0,-1,0).getBlock().getType() == Material.BEDROCK) {
								block.getLocation().add(0,-1,0).getBlock().setType(Material.DIRT);
							}
							
							block.setType(Material.AIR);
						}
						


					}
				}

			}

		}

		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

			// Check if the item the player is holding is equals to the ID
			// defined in the config file

			int iteminhand = plugin.getConfig().getInt(
					"Fireworks.ItemIdNeededInHand");

			if (((player.getItemInHand().getTypeId() == iteminhand))) {

				Double expfireworkheight;

				expfireworkheight = plugin.getConfig().getDouble(
						"Fireworks.Exp.Height");

				// Check if the player has the permission needed, or is OP

				// if (event.getClickedBlock().getTypeId() == 57) {
				// if (!canbuild) {
				// player.sendMessage("You can not build!");
				// }
				// player.sendMessage(ChatColor.WHITE + "[" +
				// ChatColor.DARK_RED
				// + "WARNING" + ChatColor.WHITE + "] " + ChatColor.RED
				// + "You can not set off fireworks in this region!");
				// event.setCancelled(false);
				// if (canbuild) {
				// Do nothing
				// }
				// player.sendMessage(ChatColor.GOLD
				// + "The Random Drop Goes off!");
				// Check if player has unlimited or is an OP
				// if (!player
				// .hasPermission("colourfireworks.unlimited.*")) {
				// if (player.isOp()) {
				// If player is OP do nothing :P
				// } else {
				// if player is not an OP, or doesn't have the
				// permission, set the block to air
				// block.setType(Material.AIR);
				// }
				// If player has permission do nothing
				// }
				// Prime the wool as a TNT
				// TNTPrimed randomdrop = event
				// .getClickedBlock()
				// .getLocation()
				// .getWorld()
				// .spawn(event.getClickedBlock().getLocation(),
				// TNTPrimed.class);
				// Shoot the TNT up into the air
				// randomdrop.setVelocity(new Vector(
				// (rand.nextFloat() - 0.5f) / 3, 2, (rand
				// .nextFloat() - 0.5f) / 3));
				// Set the fuse ticks of the TNT to 35
				// randomdrop.setFuseTicks(35);
				// Set the fire ticks to 102, this also allows the
				// listeners to detect which fire work went off
				// randomdrop.setFireTicks(102);

				// }
				// Check if the blocked clicked is a pumpkin
				if (plugin.customConfig.contains("Custom.Firework1.use") == true) {

					int custx;

					custx = 1;

					while (plugin.customConfig.contains("Custom.Firework"
							+ custx + ".use") == true) {
						if (plugin.customConfig.getBoolean("Custom.Firework"
								+ custx + ".use") == true) {

							int customfirework;
							customfirework = plugin.customConfig
									.getInt("Custom.Firework" + custx
											+ ".FireworkBlockID");

							int customfireworkraw;
							customfireworkraw = plugin.customConfig
									.getInt("Custom.Firework" + custx
											+ ".FireworkBlockID-Raw-Data");

							if (event.getClickedBlock().getTypeId() == customfirework) {

								int correctraw;
								correctraw = 0;

								if (customfireworkraw > -1) {
									correctraw = 1;
									if (event.getClickedBlock().getData() == customfireworkraw) {
										correctraw = 0;
									}
								}

								if (correctraw == 0) {

									int build3;

									build3 = 0;

									if (plugin.getWorldGuard() != null) {

										boolean canbuild = plugin
												.getWorldGuard().canBuild(
														player,
														block.getLocation()
																.getBlock()
																.getRelative(0,
																		0, 0));

										if (!canbuild) {

											player.sendMessage(ChatColor.WHITE
													+ "["
													+ ChatColor.DARK_RED
													+ "WARNING"
													+ ChatColor.WHITE
													+ "] "
													+ ChatColor.RED
													+ "You can not set off fireworks in this region!");
											build3 = 1;
										}
										if (canbuild) {
											build3 = 0;
										}
									}

									if (build3 == 0) {
										if (player
												.hasPermission("colourfireworks.limited.*")
												|| player.isOp()
												|| (player
														.hasPermission("colourfireworks.limited.custom"
																+ custx))) {
											// If yes, say:
											if (!plugin.customConfig.getString(
													"Custom.Firework" + custx
															+ ".LaunchMessage")
													.equals("")) {

												String custommessage = plugin.customConfig
														.getString("Custom.Firework"
																+ custx
																+ ".LaunchMessage");

												player.sendMessage(ChatColor.GOLD
														+ custommessage);
											}
											// Check if player has unlimited or
											// is an OP
											if (!player
													.hasPermission("colourfireworks.unlimited.*")) {
												if (player.isOp()) {
													// If player is OP do
													// nothing :P
												} else {
													if (!player
															.hasPermission("colourfireworks.unlimited.custom"
																	+ custx)) {

														// if player is not an
														// OP, or
														// doesn't
														// have
														// the
														// permission, set the
														// block to air
														block.setType(Material.AIR);
														// Check to see if the
														// block was a
														// red
														// stone
														// block
													}
													// Do nothing as it was not
													// a red stone
													// block
												}
												// If player has permission do
												// nothing
											}
											// Prime the wool is a TNT
											TNTPrimed firework = event
													.getClickedBlock()
													.getLocation()
													.getWorld()
													.spawn(event
															.getClickedBlock()
															.getLocation(),
															TNTPrimed.class);
											// Shoot the TNT up into the air

											double customfireworkheight;
											customfireworkheight = plugin.customConfig
													.getInt("Custom.Firework"
															+ custx + ".Height");

											firework.setVelocity(new Vector(
													(rand.nextFloat() - 0.5f) / 3,
													customfireworkheight,
													(rand.nextFloat() - 0.5f) / 3));
											// Set the fuse ticks of the TNT to
											// 35
											firework.setFuseTicks(35);
											// Set the fire ticks to 101, this
											// also allows
											// the
											// listeners to detect which fire
											// work went off
											firework.setFireTicks(plugin.customConfig
													.getInt("Custom.Firework"
															+ custx
															+ ".fireticks"));

										}
									}
								}
							}

						}
						custx = custx + 1;

					}
				}
				if (event.getClickedBlock().getTypeId() == 80) {

					if (player
							.hasPermission("colourfireworks.limited.snowblock")
							|| player.isOp()) {

						int snowfireworkheight = plugin.getConfig().getInt(
								"Fireworks.Snow.Height");

						boolean infinite = false;

						if (player
								.hasPermission("colourfireworks.unlimited.snowblock")
								|| player.isOp()) {
							infinite = true;
						}

						FireworkSnowBlock.RunFireworkSnowBlock(plugin, player,
								block, snowfireworkheight, rand, 102, infinite);
					}

				}

				if (event.getClickedBlock().getTypeId() == 20) {

					if (player.hasPermission("colourfireworks.limited.exp")
							|| player.isOp()) {

						boolean infinite = false;
						if (player
								.hasPermission("colourfireworks.unlimited.exp")
								|| player.isOp()) {
							infinite = true;
						}

						FireworkExp.RunFireworkExp(plugin, player, block,
								expfireworkheight, rand, 83, infinite);

					}

				}

				if (event.getClickedBlock().getTypeId() == 86) {

					if (player.hasPermission("colourfireworks.limited.pumpkin")
							|| player.isOp()) {

						int pumpkinfireworkheight = plugin.getConfig().getInt(
								"Fireworks.Pumpkin.Height");

						boolean infinite = false;
						if (player
								.hasPermission("colourfireworks.unlimited.pumpkin")
								|| player.isOp()) {
							infinite = true;
						}

						FireworkPumpkin.RunFireworkPumpkin(plugin, player,
								block, pumpkinfireworkheight, rand, 101,
								infinite);

					}

				}
				if (event.getClickedBlock().getTypeId() == 35) {

					int fireticks = 0;
					boolean infinte = false;

					if (player.isOp()) {
						infinte = true;
						if (block.getData() == 0) {
							fireticks = 99;
						}
						if (block.getData() == 1) {
							fireticks = 98;
						}
						if (block.getData() == 2) {
							fireticks = 97;
						}
						if (block.getData() == 3) {
							fireticks = 96;
						}
						if (block.getData() == 4) {
							fireticks = 95;
						}
						if (block.getData() == 5) {
							fireticks = 94;
						}
						if (block.getData() == 6) {
							fireticks = 93;
						}
						if (block.getData() == 7) {
							fireticks = 92;
						}
						if (block.getData() == 8) {
							fireticks = 91;
						}
						if (block.getData() == 9) {
							fireticks = 90;
						}
						if (block.getData() == 10) {
							fireticks = 89;
						}
						if (block.getData() == 11) {
							fireticks = 88;
						}
						if (block.getData() == 12) {
							fireticks = 87;
						}
						if (block.getData() == 13) {
							fireticks = 86;
						}
						if (block.getData() == 14) {
							fireticks = 85;
						}
						if (block.getData() == 15) {
							fireticks = 84;
						}
					}

					if (block.getData() == 0) {
						if (player
								.hasPermission("colourfireworks.limited.white")) {
							fireticks = 99;
							if (player
									.hasPermission("colourfireworks.unlimited.white")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 1) {
						if (player
								.hasPermission("colourfireworks.limited.orange")) {
							fireticks = 98;
							if (player
									.hasPermission("colourfireworks.unlimited.orange")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 2) {
						if (player
								.hasPermission("colourfireworks.limited.magenta")) {
							fireticks = 97;
							if (player
									.hasPermission("colourfireworks.unlimited.magenta")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 3) {
						if (player
								.hasPermission("colourfireworks.limited.lightblue")) {
							fireticks = 96;
							if (player
									.hasPermission("colourfireworks.unlimited.lightblue")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 4) {
						if (player
								.hasPermission("colourfireworks.limited.yellow")) {
							fireticks = 95;
							if (player
									.hasPermission("colourfireworks.unlimited.yellow")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 5) {
						if (player
								.hasPermission("colourfireworks.limited.lime")) {
							fireticks = 94;
							if (player
									.hasPermission("colourfireworks.unlimited.lime")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 6) {
						if (player
								.hasPermission("colourfireworks.limited.pink")) {
							fireticks = 93;
							if (player
									.hasPermission("colourfireworks.unlimited.pink")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 7) {
						if (player
								.hasPermission("colourfireworks.limited.gray")) {
							fireticks = 92;
							if (player
									.hasPermission("colourfireworks.unlimited.gray")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 8) {
						if (player
								.hasPermission("colourfireworks.limited.silver")) {
							fireticks = 91;
							if (player
									.hasPermission("colourfireworks.unlimited.silver")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 9) {
						if (player
								.hasPermission("colourfireworks.limited.cyan")) {
							fireticks = 90;
							if (player
									.hasPermission("colourfireworks.unlimited.cyan")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 10) {
						if (player
								.hasPermission("colourfireworks.limited.purple")) {
							fireticks = 89;
							if (player
									.hasPermission("colourfireworks.unlimited.purple")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 11) {
						if (player
								.hasPermission("colourfireworks.limited.blue")) {
							fireticks = 88;
							if (player
									.hasPermission("colourfireworks.unlimited.blue")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 12) {
						if (player
								.hasPermission("colourfireworks.limited.brown")) {
							fireticks = 87;
							if (player
									.hasPermission("colourfireworks.unlimited.brown")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 13) {
						if (player
								.hasPermission("colourfireworks.limited.green")) {
							fireticks = 86;
							if (player
									.hasPermission("colourfireworks.unlimited.green")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 14) {
						if (player.hasPermission("colourfireworks.limited.red")) {
							fireticks = 85;
							if (player
									.hasPermission("colourfireworks.unlimited.red")) {
								infinte = true;
							}
						}
					}
					if (block.getData() == 15) {
						if (player
								.hasPermission("colourfireworks.limited.black")) {
							fireticks = 84;
							if (player
									.hasPermission("colourfireworks.unlimited.black")) {
								infinte = true;
							}
						}
					}

					if (fireticks > 0) {

						Double woolfireworkheight;

						woolfireworkheight = plugin.getConfig().getDouble(
								"Fireworks.Dye.Height");

						if (infinte == true) {
							WhichWoolBlock.RunWhichWoolBlock(plugin, player,
									block, woolfireworkheight, rand, fireticks,
									true);
						}
						if (infinte == false) {
							WhichWoolBlock.RunWhichWoolBlock(plugin, player,
									block, woolfireworkheight, rand, fireticks,
									false);
						}
					}

				}
			} else {

				int iteminhand2 = plugin.getEconomyConfig().getInt(
						"Economy.ItemNeededInHand.ID");

				if (((player.getItemInHand().getTypeId() == iteminhand2))) {

					if (plugin.vaultcheck == true) {

						double playerbalace = colourfireworks.econ
								.getBalance(player.getName());

						if (plugin.customConfig
								.contains("Custom.Firework1.use") == true) {

							int custx;

							custx = 1;

							while (plugin.customConfig
									.contains("Custom.Firework" + custx
											+ ".use") == true) {
								if (plugin.customConfig
										.getBoolean("Custom.Firework" + custx
												+ ".use") == true) {

									int customfirework;
									customfirework = plugin.customConfig
											.getInt("Custom.Firework" + custx
													+ ".FireworkBlockID");

									int customfireworkraw;
									customfireworkraw = plugin.customConfig
											.getInt("Custom.Firework"
													+ custx
													+ ".FireworkBlockID-Raw-Data");

									if (event.getClickedBlock().getTypeId() == customfirework) {

										int correctraw;
										correctraw = 0;

										if (customfireworkraw > -1) {
											correctraw = 1;
											if (event.getClickedBlock()
													.getData() == customfireworkraw) {
												correctraw = 0;
											}
										}

										if (correctraw == 0) {

											int build3;

											build3 = 0;

											if (plugin.getWorldGuard() != null) {

												boolean canbuild = plugin
														.getWorldGuard()
														.canBuild(
																player,
																block.getLocation()
																		.getBlock()
																		.getRelative(
																				0,
																				0,
																				0));

												if (!canbuild) {

													player.sendMessage(ChatColor.WHITE
															+ "["
															+ ChatColor.DARK_RED
															+ "WARNING"
															+ ChatColor.WHITE
															+ "] "
															+ ChatColor.RED
															+ "You can not set off fireworks in this region!");
													build3 = 1;
												}
												if (canbuild) {
													build3 = 0;
												}
											}

											if (build3 == 0) {
												if (player
														.hasPermission("colourfireworks.economy.*")
														|| player.isOp()
														|| (player
																.hasPermission("colourfireworks.economy.custom"
																		+ custx))) {

													int price = plugin
															.getCustomConfig()
															.getInt("Custom.Firework"
																	+ custx
																	+ ".Price");

													if (price >= 0) {

														if (playerbalace >= price) {

															if (!plugin.customConfig
																	.getString(
																			"Custom.Firework"
																					+ custx
																					+ ".LaunchMessage")
																	.equals("")) {

																String custommessage = plugin.customConfig
																		.getString("Custom.Firework"
																				+ custx
																				+ ".LaunchMessage");

																player.sendMessage(ChatColor.GOLD
																		+ custommessage);

															}
															
															block.setType(Material.AIR);
															
															TNTPrimed firework = event
																	.getClickedBlock()
																	.getLocation()
																	.getWorld()
																	.spawn(event
																			.getClickedBlock()
																			.getLocation(),
																			TNTPrimed.class);

															double customfireworkheight;
															customfireworkheight = plugin.customConfig
																	.getInt("Custom.Firework"
																			+ custx
																			+ ".Height");

															firework.setVelocity(new Vector(
																	(rand.nextFloat() - 0.5f) / 3,
																	customfireworkheight,
																	(rand.nextFloat() - 0.5f) / 3));
															firework.setFuseTicks(35);
															
															firework.setFireTicks(plugin.customConfig
																	.getInt("Custom.Firework"
																			+ custx
																			+ ".fireticks"));
															
															
															colourfireworks.econ.withdrawPlayer(
																	player.getName(), price);
															double newecon = colourfireworks.econ
																	.getBalance(player.getName());
															
															player.sendMessage(ChatColor.GOLD
																	+ "That Cost you "
																	+ ChatColor.LIGHT_PURPLE + price
																	+ ChatColor.GOLD
																	+ " Yor balance is now "
																	+ ChatColor.LIGHT_PURPLE
																	+ newecon);
														}
													}

												}
											}
										}
									}

								}
								custx = custx + 1;

							}
						}

						if (event.getClickedBlock().getTypeId() == 80) {

							if (player
									.hasPermission("colourfireworks.economy.snowblock")
									|| player.isOp()) {

								int cost = plugin.getEconomyConfig().getInt(
										"Economy.SnowBlock.Cost");

								if (cost >= 0) {

									if (playerbalace >= cost) {

										int fireworkheight = plugin
												.getEconomyConfig()
												.getInt("Economy.SnowBlock.Height");

										FireworkSnowBlock.RunFireworkSnowBlock(
												plugin, player, block,
												fireworkheight, rand, 501,
												false);

										colourfireworks.econ.withdrawPlayer(
												player.getName(), cost);
										double newecon = colourfireworks.econ
												.getBalance(player.getName());
										player.sendMessage(ChatColor.GOLD
												+ "That Cost you "
												+ ChatColor.LIGHT_PURPLE + cost
												+ ChatColor.GOLD
												+ " Yor balance is now "
												+ ChatColor.LIGHT_PURPLE
												+ newecon);

									}

								}

							}

						}

						if (event.getClickedBlock().getTypeId() == 20) {

							if (player
									.hasPermission("colourfireworks.economy.exp")
									|| player.isOp()) {

								int cost = plugin.getEconomyConfig().getInt(
										"Economy.Exp.Cost");

								if (cost >= 0) {

									if (playerbalace >= cost) {

										int expfireworkheight = plugin
												.getEconomyConfig().getInt(
														"Economy.Exp.Height");

										FireworkExp.RunFireworkExp(plugin,
												player, block,
												expfireworkheight, rand, 502,
												false);

										colourfireworks.econ.withdrawPlayer(
												player.getName(), cost);
										double newecon = colourfireworks.econ
												.getBalance(player.getName());
										player.sendMessage(ChatColor.GOLD
												+ "That Cost you "
												+ ChatColor.LIGHT_PURPLE + cost
												+ ChatColor.GOLD
												+ " Yor balance is now "
												+ ChatColor.LIGHT_PURPLE
												+ newecon);

									}

								}

							}

						}

						if (event.getClickedBlock().getTypeId() == 86) {

							if (player
									.hasPermission("colourfireworks.economy.pumpkin")
									|| player.isOp()) {

								int cost = plugin.getEconomyConfig().getInt(
										"Economy.Pumpkin.Cost");

								if (cost >= 0) {

									if (playerbalace >= cost) {

										int fireworkheight = plugin
												.getEconomyConfig()
												.getInt("Economy.Pumpkin.Height");

										FireworkPumpkin.RunFireworkPumpkin(
												plugin, player, block,
												fireworkheight, rand, 503,
												false);

										colourfireworks.econ.withdrawPlayer(
												player.getName(), cost);
										double newecon = colourfireworks.econ
												.getBalance(player.getName());
										player.sendMessage(ChatColor.GOLD
												+ "That Cost you "
												+ ChatColor.LIGHT_PURPLE + cost
												+ ChatColor.GOLD
												+ " Yor balance is now "
												+ ChatColor.LIGHT_PURPLE
												+ newecon);

									}
								}
							}

						}
						if (event.getClickedBlock().getTypeId() == 35) {

							int fireworkheight = plugin.getEconomyConfig()
									.getInt("Economy.Wool.Height");

							int fireticks = 0;

							if (player.isOp()) {
								if (block.getData() == 0) {
									fireticks = 504;
								}
								if (block.getData() == 1) {
									fireticks = 505;
								}
								if (block.getData() == 2) {
									fireticks = 506;
								}
								if (block.getData() == 3) {
									fireticks = 507;
								}
								if (block.getData() == 4) {
									fireticks = 508;
								}
								if (block.getData() == 5) {
									fireticks = 509;
								}
								if (block.getData() == 6) {
									fireticks = 510;
								}
								if (block.getData() == 7) {
									fireticks = 511;
								}
								if (block.getData() == 8) {
									fireticks = 512;
								}
								if (block.getData() == 9) {
									fireticks = 513;
								}
								if (block.getData() == 10) {
									fireticks = 514;
								}
								if (block.getData() == 11) {
									fireticks = 515;
								}
								if (block.getData() == 12) {
									fireticks = 516;
								}
								if (block.getData() == 13) {
									fireticks = 517;
								}
								if (block.getData() == 14) {
									fireticks = 518;
								}
								if (block.getData() == 15) {
									fireticks = 519;
								}
							}

							if (block.getData() == 0) {
								if (player
										.hasPermission("colourfireworks.economy.wool.white")) {
									fireticks = 504;
								}
							}
							if (block.getData() == 1) {
								if (player
										.hasPermission("colourfireworks.economy.wool.orange")) {
									fireticks = 505;
								}
							}
							if (block.getData() == 2) {
								if (player
										.hasPermission("colourfireworks.economy.wool.magenta")) {
									fireticks = 506;
								}
							}
							if (block.getData() == 3) {
								if (player
										.hasPermission("colourfireworks.economy.wool.lightblue")) {
									fireticks = 507;
								}
							}
							if (block.getData() == 4) {
								if (player
										.hasPermission("colourfireworks.economy.wool.yellow")) {
									fireticks = 508;
								}
							}
							if (block.getData() == 5) {
								if (player
										.hasPermission("colourfireworks.economy.wool.lime")) {
									fireticks = 509;
								}
							}
							if (block.getData() == 6) {
								if (player
										.hasPermission("colourfireworks.economy.wool.pink")) {
									fireticks = 510;
								}
							}
							if (block.getData() == 7) {
								if (player
										.hasPermission("colourfireworks.economy.wool.gray")) {
									fireticks = 511;
								}
							}
							if (block.getData() == 8) {
								if (player
										.hasPermission("colourfireworks.economy.wool.silver")) {
									fireticks = 512;
								}
							}
							if (block.getData() == 9) {
								if (player
										.hasPermission("colourfireworks.economy.wool.cyan")) {
									fireticks = 513;
								}
							}
							if (block.getData() == 10) {
								if (player
										.hasPermission("colourfireworks.economy.wool.purple")) {
									fireticks = 514;
								}
							}
							if (block.getData() == 11) {
								if (player
										.hasPermission("colourfireworks.economy.wool.blue")) {
									fireticks = 515;
								}
							}
							if (block.getData() == 12) {
								if (player
										.hasPermission("colourfireworks.economy.wool.brown")) {
									fireticks = 516;
								}
							}
							if (block.getData() == 13) {
								if (player
										.hasPermission("colourfireworks.economy.wool.green")) {
									fireticks = 517;
								}
							}
							if (block.getData() == 14) {
								if (player
										.hasPermission("colourfireworks.economy.wool.red")) {
									fireticks = 518;
								}
							}
							if (block.getData() == 15) {
								if (player
										.hasPermission("colourfireworks.economy.wool.black")) {
									fireticks = 519;
								}
							}

							if (fireticks > 0) {

								if (player
										.hasPermission("colourfireworks.economy.wool")
										|| player.isOp()) {

									int cost = plugin.getEconomyConfig()
											.getInt("Economy.Wool.Cost");

									if (cost >= 0) {

										if (playerbalace >= cost) {

											WhichWoolBlock.RunWhichWoolBlock(
													plugin, player, block,
													fireworkheight, rand,
													fireticks, false);

											colourfireworks.econ.withdrawPlayer(
													player.getName(), cost);
											double newecon = colourfireworks.econ
													.getBalance(player
															.getName());
											player.sendMessage(ChatColor.GOLD
													+ "That Cost you "
													+ ChatColor.LIGHT_PURPLE
													+ cost + ChatColor.GOLD
													+ " Yor balance is now "
													+ ChatColor.LIGHT_PURPLE
													+ newecon);

										}
									}
								}
							}

						}

					}

				}

			}
		}
	}

	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent event) {
		Item item = event.getItem();

		if (item.getTicksLived() > 999999998) {
			item.remove();
			event.setCancelled(true);
		}
	}

}
