//You may not copy the exact code!
//You can use the code to understand how it works!
//CopyWrited



package me.craftiii4.colourfireworks;

import java.util.Random;


import org.bukkit.ChatColor;
//import org.bukkit.Location;
import org.bukkit.Material;
//import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.util.Vector;

//import com.sk89q.worldguard.bukkit.WorldGuardPlugin;



public class colourfireworksPlayerListener implements Listener {

	Random rand = new Random();
	public static colourfireworks plugin;

	//public colourfireworksPlayerListener(colourfireworks instance) {
	//	plugin = instance;
	//	plugin.getServer().getPluginManager().registerEvents(this, plugin);
	//}
	
	public colourfireworksPlayerListener(colourfireworks instance) {
		plugin = instance;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	// When a player interacts
	


	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Block block = event.getClickedBlock();
		// Check if the interaction was a player right clicking a block
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

			// Check if the item the player is holding is equals to the ID
			// defined in the config file

			int iteminhand = plugin.getConfig().getInt(
					"Fireworks.ItemIdNeededInHand");

			if (((player.getItemInHand().getTypeId() == iteminhand))) {

				Double fireworkheight;

				fireworkheight = plugin.getConfig().getDouble(
						"Fireworks.Height");
				
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
				// .hasPermission("colourfirework.unlimited.all")) {
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

					while (plugin.customConfig.contains(
							"Custom.Firework" + custx + ".use") == true) {
						if (plugin.customConfig.getBoolean(
								"Custom.Firework" + custx + ".use") == true) {

							int customfirework;
							customfirework = plugin.customConfig.getInt(
									"Custom.Firework" + custx
											+ ".FireworkBlockID");

							int customfireworkraw;
							customfireworkraw = plugin.customConfig.getInt(
									"Custom.Firework" + custx
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
												.hasPermission("colourfirework.limited.all")
												|| player.isOp()
												|| (player
														.hasPermission("colourfirework.limited.custom"
																+ custx))) {
											// If yes, say:
											if (!plugin.customConfig.getString("Custom.Firework" + custx + ".LaunchMessage").equals("")) {
												
												String custommessage = plugin.customConfig.getString("Custom.Firework" + custx + ".LaunchMessage");
												
												
												
												player.sendMessage(ChatColor.GOLD + custommessage);
											}
											// Check if player has unlimited or
											// is an OP
											if (!player
													.hasPermission("colourfirework.unlimited.all")) {
												if (player.isOp()) {
													// If player is OP do
													// nothing :P
												} else {
													if (!player
															.hasPermission("colourfirework.unlimited.custom"
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
											firework.setVelocity(new Vector(
													(rand.nextFloat() - 0.5f) / 3,
													fireworkheight,
													(rand.nextFloat() - 0.5f) / 3));
											// Set the fuse ticks of the TNT to
											// 35
											firework.setFuseTicks(35);
											// Set the fire ticks to 101, this
											// also allows
											// the
											// listeners to detect which fire
											// work went off
											firework.setFireTicks(plugin
													.customConfig
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

					int build3;

					build3 = 0;

					if (plugin.getWorldGuard() != null) {

						boolean canbuild = plugin.getWorldGuard().canBuild(
								player,
								block.getLocation().getBlock()
										.getRelative(0, 0, 0));

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
						if (player.hasPermission("colourfirework.limited.all")
								|| player.isOp()
								|| (player
										.hasPermission("colourfirework.limited.exp"))) {
							// If yes, say:
							if (plugin.getConfig().getBoolean(
									"Fireworks.Message.SendOnLaunch") == true) {
								player.sendMessage(ChatColor.GOLD
										+ "The SnowBlock Goes off!");
							}
							// Check if player has unlimited or is an OP
							if (!player
									.hasPermission("colourfirework.unlimited.all")) {
								if (player.isOp()) {
									// If player is OP do nothing :P
								} else {
									if (!player
											.hasPermission("colourfirework.unlimited.exp")) {

										// if player is not an OP, or doesn't
										// have
										// the
										// permission, set the block to air
										block.setType(Material.AIR);
										// Check to see if the block was a red
										// stone
										// block
									}
									// Do nothing as it was not a red stone
									// block
								}
								// If player has permission do nothing
							}
							// Prime the wool is a TNT
							TNTPrimed firework = event
									.getClickedBlock()
									.getLocation()
									.getWorld()
									.spawn(event.getClickedBlock()
											.getLocation(), TNTPrimed.class);
							// Shoot the TNT up into the air
							firework.setVelocity(new Vector(
									(rand.nextFloat() - 0.5f) / 3,
									fireworkheight,
									(rand.nextFloat() - 0.5f) / 3));
							// Set the fuse ticks of the TNT to 35
							firework.setFuseTicks(35);
							// Set the fire ticks to 101, this also allows the
							// listeners to detect which fire work went off
							firework.setFireTicks(102);

						}
					}
				}
				
				if (event.getClickedBlock().getTypeId() == 20) {

					int build2;

					build2 = 0;

					if (plugin.getWorldGuard() != null) {

						boolean canbuild = plugin.getWorldGuard().canBuild(
								player,
								block.getLocation().getBlock()
										.getRelative(0, 0, 0));

						if (!canbuild) {

							player.sendMessage(ChatColor.WHITE
									+ "["
									+ ChatColor.DARK_RED
									+ "WARNING"
									+ ChatColor.WHITE
									+ "] "
									+ ChatColor.RED
									+ "You can not set off fireworks in this region!");
							build2 = 1;
						}
						if (canbuild) {
							build2 = 0;
						}
					}

					if (build2 == 0) {
						if (player.hasPermission("colourfirework.limited.all")
								|| player.isOp()
								|| (player
										.hasPermission("colourfirework.limited.exp"))) {
							// If yes, say:
							if (plugin.getConfig().getBoolean(
									"Fireworks.Message.SendOnLaunch") == true) {
								player.sendMessage(ChatColor.GOLD
										+ "The Exp Firework Goes off!");
							}
							// Check if player has unlimited or is an OP
							if (!player
									.hasPermission("colourfirework.unlimited.all")) {
								if (player.isOp()) {
									// If player is OP do nothing :P
								} else {
									if (!player
											.hasPermission("colourfirework.unlimited.exp")) {

										// if player is not an OP, or doesn't
										// have
										// the
										// permission, set the block to air
										block.setType(Material.AIR);
										// Check to see if the block was a red
										// stone
										// block
									}
									// Do nothing as it was not a red stone
									// block
								}
								// If player has permission do nothing
							}
							// Prime the wool is a TNT
							TNTPrimed firework = event
									.getClickedBlock()
									.getLocation()
									.getWorld()
									.spawn(event.getClickedBlock()
											.getLocation(), TNTPrimed.class);
							// Shoot the TNT up into the air
							firework.setVelocity(new Vector(
									(rand.nextFloat() - 0.5f) / 3,
									expfireworkheight,
									(rand.nextFloat() - 0.5f) / 3));
							// Set the fuse ticks of the TNT to 35
							firework.setFuseTicks(35);
							// Set the fire ticks to 101, this also allows the
							// listeners to detect which fire work went off
							firework.setFireTicks(83);

						}
					}
				}


				if (event.getClickedBlock().getTypeId() == 86) {

					int build2;

					build2 = 0;

					if (plugin.getWorldGuard() != null) {

						boolean canbuild = plugin.getWorldGuard().canBuild(
								player,
								block.getLocation().getBlock()
										.getRelative(0, 0, 0));

						if (!canbuild) {

							player.sendMessage(ChatColor.WHITE
									+ "["
									+ ChatColor.DARK_RED
									+ "WARNING"
									+ ChatColor.WHITE
									+ "] "
									+ ChatColor.RED
									+ "You can not set off fireworks in this region!");
							build2 = 1;
						}
						if (canbuild) {
							build2 = 0;
						}
					}

					if (build2 == 0) {
						if (player.hasPermission("colourfirework.limited.all")
								|| player.isOp()
								|| (player
										.hasPermission("colourfirework.limited.pumpkin"))) {
							// If yes, say:
							if (plugin.getConfig().getBoolean(
									"Fireworks.Message.SendOnLaunch") == true) {
								player.sendMessage(ChatColor.GOLD
										+ "The Pumpkin Goes off!");
							}
							// Check if player has unlimited or is an OP
							if (!player
									.hasPermission("colourfirework.unlimited.all")) {
								if (player.isOp()) {
									// If player is OP do nothing :P
								} else {
									if (!player
											.hasPermission("colourfirework.unlimited.pumpkin")) {

										// if player is not an OP, or doesn't
										// have
										// the
										// permission, set the block to air
										block.setType(Material.AIR);
										// Check to see if the block was a red
										// stone
										// block
									}
									// Do nothing as it was not a red stone
									// block
								}
								// If player has permission do nothing
							}
							// Prime the wool is a TNT
							TNTPrimed firework = event
									.getClickedBlock()
									.getLocation()
									.getWorld()
									.spawn(event.getClickedBlock()
											.getLocation(), TNTPrimed.class);
							// Shoot the TNT up into the air
							firework.setVelocity(new Vector(
									(rand.nextFloat() - 0.5f) / 3,
									fireworkheight,
									(rand.nextFloat() - 0.5f) / 3));
							// Set the fuse ticks of the TNT to 35
							firework.setFuseTicks(35);
							// Set the fire ticks to 101, this also allows the
							// listeners to detect which fire work went off
							firework.setFireTicks(101);

						}
					}
				}
				// If block isn't a pumpkin, check for wool
				if (event.getClickedBlock().getTypeId() == 35) {

					int build;

					build = 0;

					if (plugin.getWorldGuard() != null) {

						boolean canbuild = plugin.getWorldGuard().canBuild(
								player,
								block.getLocation().getBlock()
										.getRelative(0, 0, 0));

						if (!canbuild) {
							player.sendMessage(ChatColor.WHITE
									+ "["
									+ ChatColor.DARK_RED
									+ "WARNING"
									+ ChatColor.WHITE
									+ "] "
									+ ChatColor.RED
									+ "You can not set off fireworks in this region!");
							build = 1;
						}
						if (canbuild) {
							build = 0;
						}
					}

					if (build == 0) {

						// If block is wool, check the id to see what colour
						// Check for ID 0
						if (event.getClickedBlock().getData() == 0) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.white"))) {
								// If ID is 0, send player the following message
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								// Check if player has unlimited or is an OP
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.white")) {
											block.setType(Material.AIR);
										}
									}
								}

								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3, 1.5, (rand
										.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 99, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(99);
							}
						}
						// Check to see if the wool has ID 1
						if (event.getClickedBlock().getData() == 1) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.orange"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.orange")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 98, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(98);
							}
						}
						// Check to see if the wool has ID 2
						if (event.getClickedBlock().getData() == 2) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.magenta"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.magenta")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 97, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(97);
							}
						}
						// Check to see if the wool has ID 3
						if (event.getClickedBlock().getData() == 3) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.lightblue"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.lightblue")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 96, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(96);
							}
						}
						// Check to see if the wool has ID 4
						if (event.getClickedBlock().getData() == 4) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.yellow"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.yellow")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 95, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(95);
							}
						}
						// Check to see if the wool has ID 5
						if (event.getClickedBlock().getData() == 5) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.lime"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.lime")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 94, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(94);
							}
						}
						// Check to see if the wool has ID 6
						if (event.getClickedBlock().getData() == 6) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.pink"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.pink")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 93, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(93);
							}
						}
						// Check to see if the wool has ID 7
						if (event.getClickedBlock().getData() == 7) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.gray"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.gray")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 92, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(92);

							}
						}
						// Check to see if the wool has ID 8
						if (event.getClickedBlock().getData() == 8) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.silver"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.silver")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 91, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(91);
							}
						}
						// Check to see if the wool has ID 9
						if (event.getClickedBlock().getData() == 9) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.cyan"))) {

								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.cyan")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 90, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(90);
							}
						}
						// Check to see if the wool has ID 10
						if (event.getClickedBlock().getData() == 10) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.purple"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.purple")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 89, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(89);
							}
						}
						// Check to see if the wool has ID 11
						if (event.getClickedBlock().getData() == 11) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.blue"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.blue")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 88, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(88);
							}
						}
						// Check to see if the wool has ID 12
						if (event.getClickedBlock().getData() == 12) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.brown"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.brown")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 87, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(87);
							}
						}
						// Check to see if the wool has ID 13
						if (event.getClickedBlock().getData() == 13) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.green"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.green")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 86, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(86);
							}
						}
						// Check to see if the wool has ID 14
						if (event.getClickedBlock().getData() == 14) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.red"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.red")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 85, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(85);
							}
						}
						// Check to see if the wool has ID 15
						if (event.getClickedBlock().getData() == 15) {
							if (player
									.hasPermission("colourfirework.limited.all")
									|| player.isOp()
									|| (player
											.hasPermission("colourfirework.limited.black"))) {
								if (plugin.getConfig().getBoolean(
										"Fireworks.Message.SendOnLaunch") == true) {
									player.sendMessage(ChatColor.GOLD
											+ "The fire work goes off!");
								}
								if (!player
										.hasPermission("colourfirework.unlimited.all")) {
									if (player.isOp()) {
										// do nothing :P
									} else {
										if (!player
												.hasPermission("colourfirework.unlimited.black")) {
											block.setType(Material.AIR);
										}
									}
								}
								TNTPrimed firework = event
										.getClickedBlock()
										.getLocation()
										.getWorld()
										.spawn(event.getClickedBlock()
												.getLocation(), TNTPrimed.class);
								firework.setVelocity(new Vector((rand
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand.nextFloat() - 0.5f) / 3));
								firework.setFuseTicks(35);
								// Set the fire ticks to 84, this also allows
								// the listeners to detect which fire work went
								// off
								firework.setFireTicks(84);
							}
						}

					}
					// If wool has none of these IDS, do nothing
				}
				// If Block is not wool, do nothing
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

