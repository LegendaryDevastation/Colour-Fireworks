


package me.craftiii4.colourfireworks;

import java.util.List;
import java.util.Random;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class colourfireworksBlockListener implements Listener {

	public static colourfireworks plugin;
	

	public static Location location = null;
	
	public static ItemStack itemsindp = null;
	
	public colourfireworksBlockListener(colourfireworks instance) {
		plugin = instance;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	int whiteon = 0;
	int orangeon = 0;
	int magentaon = 0;
	int lightblueon = 0;
	int yellowon = 0;
	int limeon = 0;
	int pinkon = 0;
	int greyon = 0;
	int silveron = 0;
	int cyanon = 0;
	int purpleon = 0;
	int blueon = 0;
	int brownon = 0;
	int greenon = 0;
	int redon = 0;
	int blackon = 0;
	int pumpkinon = 0;
	int snowon = 0;
	int customon = 0;
	int expon = 0;
	
	Random rand = new Random();
	static Random rand2 = new Random();
	
	@EventHandler
	public void onBlockRedstoneChange(BlockRedstoneEvent e) {

		Block block = e.getBlock();
		// Get what blocks are being changed
		doFireWork(block.getRelative(1, 0, 0));
		doFireWork(block.getRelative(-1, 0, 0));
		doFireWork(block.getRelative(0, 0, 1));
		doFireWork(block.getRelative(0, 0, -1));
	}
	
	
	public void doFireWork(Block block) {
		if (block.isBlockIndirectlyPowered() == false) {
			Block newBlock = block;

			if (block.getTypeId() == Material.SIGN.getId()
					|| (block.getTypeId() == Material.SIGN_POST.getId())) {
				Sign signwhite = (Sign) newBlock.getState();
				if (block.isBlockPowered() == false) {
					if (signwhite.getLine(1).equalsIgnoreCase("[FireWork]")) {
						Double fireworkheight;
						fireworkheight = plugin.getConfig().getDouble(
								"Fireworks.Dye.Height");
						Double expfireworkheight;
						expfireworkheight = plugin.getConfig().getDouble(
								"Fireworks.Exp.Height");
						Double fireworkpumpkinheight;
						fireworkpumpkinheight = plugin.getConfig().getDouble(
								"Fireworks.Pumpkin.Height");
						Double fireworksnowheight;
						fireworksnowheight = plugin.getConfig().getDouble(
								"Fireworks.Snow.Height");

						if (block.isBlockPowered() == false) {
							if (signwhite.getLine(2)
									.equalsIgnoreCase("[White]")) {
								if (whiteon == 0) {
									if (block.isBlockPowered() == false) {
										whiteon = 1;
										Location newlocation = block
												.getLocation();

										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);;
										}
										 
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 10);
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 2);


										TNTPrimed whitefirework = (TNTPrimed) newlocation
												.getWorld().spawn(newlocation,
														TNTPrimed.class);
										whitefirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										whitefirework.setFuseTicks(35);
										whitefirework.setFireTicks(99);
										whiteon = 0;
									}
								}
								whiteon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase(
									"[Orange]")) {
								if (orangeon == 0) {
									if (block.isBlockPowered() == false) {
										orangeon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 3);
											
										TNTPrimed orangefirework = (TNTPrimed) newlocation
												.getWorld().spawn(newlocation,
														TNTPrimed.class);
										orangefirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										orangefirework.setFuseTicks(35);
										orangefirework.setFireTicks(98);
										orangeon = 0;
									}
								}
								orangeon = 0;
							}

							if (signwhite.getLine(2).equalsIgnoreCase(
									"[Magenta]")) {
								if (magentaon == 0) {
									if (block.isBlockPowered() == false) {
										magentaon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 1);
										
										
										TNTPrimed magentafirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										magentafirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										magentafirework.setFuseTicks(35);
										magentafirework.setFireTicks(97);
										magentaon = 0;
									}
								}
								magentaon = 0;
							}

							if (signwhite.getLine(2).equalsIgnoreCase(
									"[LightBlue]")) {
								if (lightblueon == 0) {
									if (block.isBlockPowered() == false) {
										lightblueon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 2);
										
										
										TNTPrimed lightbluefirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										lightbluefirework
												.setVelocity(new Vector(
														(rand.nextFloat() - 0.5f) / 3,
														fireworkheight,
														(rand.nextFloat() - 0.5f) / 3));
										lightbluefirework.setFuseTicks(35);
										lightbluefirework.setFireTicks(96);
										lightblueon = 0;
									}
								}
								lightblueon = 0;
							}

							if (signwhite.getLine(2).equalsIgnoreCase(
									"[Yellow]")) {
								if (yellowon == 0) {
									if (block.isBlockPowered() == false) {
										yellowon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 3);
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 10);
										
										TNTPrimed yellowfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										yellowfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										yellowfirework.setFuseTicks(35);
										yellowfirework.setFireTicks(95);
										yellowon = 0;
									}
								}
								yellowon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase("[Lime]")) {
								if (limeon == 0) {
									if (block.isBlockPowered() == false) {
										limeon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 4);
										
										TNTPrimed limefirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										limefirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										limefirework.setFuseTicks(35);
										limefirework.setFireTicks(94);
										limeon = 0;
									}
								}
								limeon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase("[Pink]")) {
								if (pinkon == 0) {
									if (block.isBlockPowered() == false) {
										pinkon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 1);
										
										TNTPrimed pinkfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										pinkfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										pinkfirework.setFuseTicks(35);
										pinkfirework.setFireTicks(93);
										pinkon = 0;
									}
								}
								pinkon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase("[Grey]")) {
								if (greyon == 0) {
									if (block.isBlockPowered() == false) {
										greyon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 8);
										
										TNTPrimed greyfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										greyfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										greyfirework.setFuseTicks(35);
										greyfirework.setFireTicks(92);
										greyon = 0;
									}
								}
								greyon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase(
									"[Silver]")) {
								if (silveron == 0) {
									if (block.isBlockPowered() == false) {
										silveron = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 10);
										
										TNTPrimed silverfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										silverfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										silverfirework.setFuseTicks(35);
										silverfirework.setFireTicks(91);
										silveron = 0;
									}
								}
								silveron = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase("[Cyan]")) {
								if (cyanon == 0) {
									if (block.isBlockPowered() == false) {
										cyanon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 6);
										
										
										TNTPrimed cyanfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										cyanfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										cyanfirework.setFuseTicks(35);
										cyanfirework.setFireTicks(90);
										cyanon = 0;
									}
								}
								cyanon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase(
									"[Purple]")) {
								if (purpleon == 0) {
									if (block.isBlockPowered() == false) {
										purpleon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 9);
										
										TNTPrimed purplefirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										purplefirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										purplefirework.setFuseTicks(35);
										purplefirework.setFireTicks(89);
										purpleon = 0;
									}
								}
								purpleon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase("[Blue]")) {
								if (blueon == 0) {
									if (block.isBlockPowered() == false) {
										blueon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 7);
										
										TNTPrimed bluefirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										bluefirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										bluefirework.setFuseTicks(35);
										bluefirework.setFireTicks(88);
										blueon = 0;
									}
								}
								blueon = 0;
							}
							if (signwhite.getLine(2)
									.equalsIgnoreCase("[Brown]")) {
								if (brownon == 0) {
									if (block.isBlockPowered() == false) {
										brownon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 12);
										
										TNTPrimed brownfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										brownfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										brownfirework.setFuseTicks(35);
										brownfirework.setFireTicks(87);
										brownon = 0;
									}
								}
								brownon = 0;
							}
							if (signwhite.getLine(2)
									.equalsIgnoreCase("[Green]")) {
								if (greenon == 0) {
									if (block.isBlockPowered() == false) {
										greenon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 4);
										
										TNTPrimed greenfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										greenfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										greenfirework.setFuseTicks(35);
										greenfirework.setFireTicks(86);
										greenon = 0;
									}
								}
								greenon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase("[Red]")) {
								if (redon == 0) {
									if (block.isBlockPowered() == false) {
										redon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 5);
										
										TNTPrimed redfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										redfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										redfirework.setFuseTicks(35);
										redfirework.setFireTicks(85);
										redon = 0;
									}
								}
								redon = 0;
							}
							if (signwhite.getLine(2)
									.equalsIgnoreCase("[Black]")) {
								if (blackon == 0) {
									if (block.isBlockPowered() == false) {
										blackon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
										}

										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 12);
										
										TNTPrimed blackfirework = (TNTPrimed)newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										blackfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										blackfirework.setFuseTicks(35);
										blackfirework.setFireTicks(84);
										blackon = 0;
									}
								}
								blackon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase(
									"[Pumpkin]")) {
								if (pumpkinon == 0) {
									if (block.isBlockPowered() == false) {
										pumpkinon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
											
											
										}
										 
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 3);
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 10);
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 2);
										
										TNTPrimed pumpkinfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										pumpkinfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkpumpkinheight,
												(rand.nextFloat() - 0.5f) / 3));
										pumpkinfirework.setFuseTicks(35);
										pumpkinfirework.setFireTicks(101);
										pumpkinon = 0;
									}
								}
								pumpkinon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase(
									"[SnowBlock]")) {
								if (snowon == 0) {
									if (block.isBlockPowered() == false) {
										snowon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
											
											
										}
										 
										 
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 7);
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 1);
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 4);
										
										TNTPrimed blackfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										blackfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworksnowheight,
												(rand.nextFloat() - 0.5f) / 3));
										blackfirework.setFuseTicks(35);
										blackfirework.setFireTicks(102);
										snowon = 0;
									}
								}
								snowon = 0;
							}
							if (signwhite.getLine(2).equalsIgnoreCase("[Exp]")) {
								if (expon == 0) {
									if (block.isBlockPowered() == false) {
										expon = 1;
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
											
											
										}
										 
										Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.POTION_BREAK, 4);
										
										TNTPrimed blackfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);
										blackfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												expfireworkheight,
												(rand.nextFloat() - 0.5f) / 3));
										blackfirework.setFuseTicks(35);
										blackfirework.setFireTicks(83);
										expon = 0;
									}
								}
								expon = 0;
							}
							int firen;
							firen = 1;
							while (plugin.customConfig
									.contains("Custom.Firework" + firen) == true) {

								if (signwhite.getLine(2).contains(
										"[Custom" + firen + "]")) {
									if (block.isBlockPowered() == false) {
										
										Location newlocation = block
												.getLocation();
										
										 while (newlocation.add(0, 1, 0).getBlock().getType() == Material.FENCE) {
											Bukkit.getWorld(newlocation.getWorld().getName()).playEffect(newlocation, Effect.SMOKE, 5);
											newlocation.add(0, 1, 0);
											
											
										}
										 
										
											Double fireworkcustomheight;
											fireworkcustomheight = plugin
													.getCustomConfig().getDouble(
															"Custom.Firework"
																	+ firen
																	+ ".Height");
										
										
										TNTPrimed custfirework = (TNTPrimed) newlocation
												.getWorld()
												.spawn(newlocation,
														TNTPrimed.class);



										custfirework.setVelocity(new Vector(
												(rand.nextFloat() - 0.5f) / 3,
												fireworkcustomheight,
												(rand.nextFloat() - 0.5f) / 3));
										custfirework.setFuseTicks(35);
										custfirework
												.setFireTicks(plugin.customConfig
														.getInt("Custom.Firework"
																+ firen
																+ ".fireticks"));
									}

								}
								firen = firen + 1;
							}

						}
					}
				}

			}

		}
	}
	

	public static int maxtime = 300;
	public static int time = 60;
	static boolean run = false;
	
	static int round1;
	public static void startDropParty(final Player player, boolean hideitems) {
		run = false;
		
		round1 = plugin.getServer().getScheduler()
				.scheduleAsyncRepeatingTask(plugin, new Runnable() {
					public void run() {

						if (run == false) {
							time = plugin.getdroppartyConfig().getInt(
									"DropParty.Time.StartingTime");
							maxtime = plugin.getdroppartyConfig().getInt(
									"DropParty.Time.MaxTime");
							run = true;
						}

						if (time > maxtime) {

							time = maxtime;

							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.RED
																		+ "Max Time Reached!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 900) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "15 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 600) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "10 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 480) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "8 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 420) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "7 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 360) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "6 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 300) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "5 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 240) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "4 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 180) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "3 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 120) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "2 minutes left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 90) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "90 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}
						}

						if (time == 75) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "75 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 60) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "60 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 45) {

							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "45 seconds left");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						// if (time == 45) {
						// int radius = plugin.getdroppartyConfig().getInt(
						// "DropParty.Message.Radius");
						// Block block = location.getBlock();

						// Entity chicken = block.getWorld().spawnCreature(
						// block.getLocation(), EntityType.CHICKEN);

						// int limit = 0;
						// while (chicken == null && limit < 5) {
						// chicken = block.getWorld()
						// .spawnCreature(block.getLocation(),
						// EntityType.CHICKEN);
						// limit++;
						// }

						// if (chicken == null) {
						// System.out
						// .println("[ColourFireworks] Error Occured, Error code = TIME045_CHICKEN_NULL");
						// return;
						// }

						// List<Entity> list = chicken.getNearbyEntities(
						// radius, radius, radius);
						// chicken.remove();

						// int test01 = 0;
						// int test02 = list.size();

						// while (test02 > test01) {

						// Entity entity = list.get(test01);
						// if (entity instanceof Player) {
						// ((Player) entity)
						// .getPlayer()
						// .sendMessage(
						// ChatColor.GOLD
						// + "45 seconds left!");

						// }

						// test01++;
						// }

						// }

						if (time == 30) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "30 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 15) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "15 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 10) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "10 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 5) {

							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "5 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}
						if (time == 4) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "4 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 3) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "3 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 2) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "2 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 1) {
							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "1 seconds left!");
													}
												}
											}
										}
									}
								}

								test01++;

							}

						}

						if (time == 0) {
							Block block = location.getBlock();

							String wname = colourfireworks.dpworld.get("World");

							double maxx = colourfireworks.MaxandMin.get("MaxX");
							double minx = colourfireworks.MaxandMin.get("MinX");

							double maxy = colourfireworks.MaxandMin.get("MaxY");
							double miny = colourfireworks.MaxandMin.get("MinY");

							double maxz = colourfireworks.MaxandMin.get("MaxZ");
							double minz = colourfireworks.MaxandMin.get("MinZ");

							List<Player> playersinworld = Bukkit
									.getWorld(wname).getPlayers();

							int test01 = 0;
							int test02 = playersinworld.size();

							while (test02 > test01) {
								Player playerpicked = playersinworld
										.get(test01);

								if (playerpicked.getLocation().getBlockX() < maxx) {
									if (playerpicked.getLocation().getBlockX() > minx) {
										if (playerpicked.getLocation()
												.getBlockY() < maxy) {
											if (playerpicked.getLocation()
													.getBlockY() > miny) {
												if (playerpicked.getLocation()
														.getBlockZ() < maxz) {
													if (playerpicked
															.getLocation()
															.getBlockZ() > minz) {
														playerpicked
																.sendMessage(ChatColor.GOLD
																		+ "Drop party going up");
													}
												}
											}
										}
									}
								}

								test01++;
							}

							int bedid = colourfireworks.BlockSignOn.get("ID");
							int bedsubid = colourfireworks.BlockSignOn
									.get("SUBID");

							location.getBlock().getLocation().add(0, -1, 0)
									.getBlock().setTypeId(bedid);
							location.getBlock().getLocation().add(0, -1, 0)
									.getBlock().setData((byte) bedsubid);

							if (block.getState() instanceof Sign) {

								Sign sign = (Sign) block.getState();

								Double fireworkheight;

								fireworkheight = plugin.getConfig().getDouble(
										"Fireworks.Dye.Height");

								TNTPrimed firework = block
										.getLocation()
										.getWorld()
										.spawn(block.getLocation(),
												TNTPrimed.class);
								// Shoot the TNT up into the air
								firework.setVelocity(new Vector((rand2
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand2.nextFloat() - 0.5f) / 3));
								// Set the fuse ticks of the TNT to 35
								firework.setFuseTicks(35);
								// Set the fire ticks to 101, this also
								// allows
								// the
								// listeners to detect which fire work went
								// off
								firework.setFireTicks(72);

								if (sign.getLine(0).contains("[A]")) {
									// keep there
								} else {
									block.setTypeId(0);
								}

							} else {
								System.out
										.println("[ColourFireworks] Error Occured - Sign no Longer exists!");
								plugin.getServer()
										.broadcastMessage(
												ChatColor.RED
														+ "Error, The sign did not exist for the drop party - Running anyways");

								Double fireworkheight;

								fireworkheight = plugin.getConfig().getDouble(
										"Fireworks.Dye.Height");

								TNTPrimed firework = block
										.getLocation()
										.getWorld()
										.spawn(block.getLocation(),
												TNTPrimed.class);
								// Shoot the TNT up into the air
								firework.setVelocity(new Vector((rand2
										.nextFloat() - 0.5f) / 3,
										fireworkheight,
										(rand2.nextFloat() - 0.5f) / 3));
								// Set the fuse ticks of the TNT to 35
								firework.setFuseTicks(35);
								// Set the fire ticks to 101, this also
								// allows
								// the
								// listeners to detect which fire work went
								// off
								firework.setFireTicks(72);

							}

							stopDropParty();

						}

						if (time <= 0) {
							time = 1;
						}

						time--;

					}

				}, 0L, 20L);
	}
	
	

	public static void stopDropParty() {
		plugin.getServer().getScheduler().cancelTask(round1);
		Bukkit.getScheduler().cancelTask(round1);
		time = 60;
		location = null;
	}
	
	public static void stopDropPartycomplete() {
		plugin.getServer().getScheduler().cancelTask(round1);
		Bukkit.getScheduler().cancelTask(round1);
		time = 60;

		colourfireworks.allreadyone.clear();
		colourfireworks.HowManyItemsInTotal.clear();
		colourfireworks.HowManySlotItems.clear();
		colourfireworks.WhatIsSlotItemsID.clear();
		colourfireworks.WhatIsSlotItemsSUBID.clear();
		colourfireworks.Max.put("insofar", 0);
		colourfireworks.Hide.clear();
		
		Block sourceblock = Bukkit.getWorld(location.getWorld().getName()).getBlockAt(location);
		sourceblock.setType(Material.AIR);
		
		int bedid = colourfireworks.BlockSignOn.get("ID");
		int bedsubid = colourfireworks.BlockSignOn.get("SUBID");
		
		sourceblock.getLocation().add(0, -1, 0).getBlock().setTypeId(bedid);
		sourceblock.getLocation().add(0, -1, 0).getBlock().setData((byte) bedsubid);
		
		colourfireworks.BlockSignOn.clear();
		
		location = null;
		
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();

		if (block.getState() instanceof Sign) {
			Sign sign = (Sign) block.getState();

			if (sign.getLine(1).equalsIgnoreCase(
					ChatColor.GOLD + "[Drop Party!]")) {

				Location placeofsign = block.getLocation();

				if (colourfireworksBlockListener.location != null) {

					if (placeofsign.toString().equals(
							colourfireworksBlockListener.location.toString())) {

						event.setCancelled(true);
						player.sendMessage(ChatColor.RED
								+ "Can not remove that DP sign!");
						
						String line1 = sign.getLine(0).toUpperCase();

						String finalline = "";
						
						if (line1.contains("A")) {
							finalline = finalline + "[A]";
						} else {
							if (line1.contains("O")) {
								finalline = finalline + "[O]";
							} 
						}


						if (line1.contains("H")) {
							finalline = finalline + "[H]";
						} else {
							if (line1.contains("V")) {
								finalline = finalline + "[V]";
							} 
						}
						sign.setLine(1, ChatColor.GOLD + "[Drop Party!]");
						sign.setLine(2, ChatColor.GREEN + "L = 1 | R = 8");
						sign.setLine(3, "");
						sign.update();

					}
				}
			}
		}

	}


	@EventHandler
	public void onSignChange(SignChangeEvent event) {

		Block block = event.getBlock();
		Player player = event.getPlayer();
		ItemStack sign = new ItemStack(Material.SIGN, 1);

		int signcorrect;

		signcorrect = 0;

		if (event.getLine(1).equalsIgnoreCase("[DP]")
				|| (event.getLine(1).equalsIgnoreCase("[D P]") || (event
						.getLine(1).contains("[Drop Party]") || (event.getLine(
						1).equalsIgnoreCase("[Drop Party]") || (event
						.getLine(1).equalsIgnoreCase("[DropParty]")))))) {
			if (player.hasPermission("colourfireworks.dropparty.create")
					|| player.isOp()) {

				// if (event.getLine(0).equalsIgnoreCase("[A]") ||
				// event.getLine(0).equalsIgnoreCase("[Auto]")) {
				// event.setLine(0, ChatColor.LIGHT_PURPLE + "[Auto][Hidden]");
				// } else {
				// event.setLine(0, "");
				// }

				boolean firstlinecorrect = true;

				boolean hide = true;

				String line1 = event.getLine(0).toUpperCase();

				String finalline = "";

				if (line1.contains("A")) {
					finalline = finalline + "[A]";
				} else {
					if (line1.contains("O")) {
						finalline = finalline + "[O]";
					} else {
						firstlinecorrect = false;
					}
				}

				if (line1.contains("A") && (line1.contains("O"))) {
					firstlinecorrect = false;
					player.sendMessage(ChatColor.RED
							+ "1st Line can not contain both A and O");
				}

				if (line1.contains("H")) {
					finalline = finalline + "[H]";
					hide = true;
				} else {
					if (line1.contains("V")) {
						finalline = finalline + "[V]";
						hide = false;
					} else {
						firstlinecorrect = false;
					}
				}

				if (line1.contains("H") && (line1.contains("V"))) {
					firstlinecorrect = false;
					player.sendMessage(ChatColor.RED
							+ "1st Line can not contain both H and V");
				}

				// if (line1.contains("L")) {
				// finalline = finalline + "[L]";
				// usechicken = false;
				// } else {
				// if (line1.contains("C")) {
				// finalline = finalline + "[C]";
				// usechicken = true;
				// } else {
				// firstlinecorrect = false;
				// }
				// }

				// if (line1.contains("L") && (line1.contains("C"))) {
				// firstlinecorrect = false;
				// player.sendMessage(ChatColor.RED
				// + "1st Line can not contain both L and C");
				// }

				if (firstlinecorrect == false) {

					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(block.getLocation(),
							sign);

					player.sendMessage(ChatColor.RED
							+ "First line must contain two variables");
					player.sendMessage(ChatColor.GOLD + "1. "
							+ ChatColor.LIGHT_PURPLE + "A" + ChatColor.GOLD
							+ " = Auto - Drop party will repeat when clicked");
					player.sendMessage(ChatColor.GOLD + "1. "
							+ ChatColor.LIGHT_PURPLE + "O" + ChatColor.GOLD
							+ " = Once - Drop party will go through once");

					player.sendMessage(ChatColor.GREEN
							+ "2. "
							+ ChatColor.LIGHT_PURPLE
							+ "H"
							+ ChatColor.GREEN
							+ " = Hidden - Items will appear to be the same untill picked up");
					player.sendMessage(ChatColor.GREEN
							+ "2. "
							+ ChatColor.LIGHT_PURPLE
							+ "V"
							+ ChatColor.GREEN
							+ " = Visible - Players can see what the items are before picking up");

					// player.sendMessage(ChatColor.AQUA
					// + "3. "
					// + ChatColor.LIGHT_PURPLE
					// + "L"
					// + ChatColor.AQUA
					// +
					// " = List - Will get every player online and check their location");
					// player.sendMessage(ChatColor.AQUA
					// + "3. "
					// + ChatColor.LIGHT_PURPLE
					// + "C"
					// + ChatColor.AQUA
					// +
					// " = Chicken - Will spawn a chicken to get players nearby");

				} else {

					event.setLine(0, finalline);
					event.setLine(1, ChatColor.GOLD + "[Drop Party!]");
					event.setLine(2, ChatColor.GREEN + "L = 1 | R = 8");
					event.setLine(3, "");

					if (!colourfireworks.allreadyone.containsKey("On")) {

						Sign sign2 = (Sign) block.getState();
						Location placeofchest = sign2.getLocation();

						// if
						// (player.hasPermission("colourfireworks.notifyupdate")
						// || player.isOp()) {

						// if (colourfireworks.latestversion == false) {
						// String latestversion = URLReader.latestversion;
						// player.sendMessage(ChatColor.AQUA + "[" +
						// ChatColor.GOLD
						// + "ColourFireWorks" + ChatColor.AQUA + "]"
						// + ChatColor.RED + " Version " +
						// ChatColor.LIGHT_PURPLE + latestversion
						// + ChatColor.RED + " is out!");
						// player.sendMessage(ChatColor.AQUA + "[" +
						// ChatColor.GOLD
						// + "ColourFireWorks" + ChatColor.AQUA + "]"
						// + ChatColor.RED + " Currently using version " +
						// ChatColor.LIGHT_PURPLE +
						// plugin.getDescription().getVersion());
						// }

						// }

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

						player.sendMessage(ChatColor.GOLD + "DropParty Started");

						location = placeofchest;

						colourfireworks.allreadyone.put("On", true);

						// Entity chicken = block.getWorld().spawnCreature(
						// block.getLocation(), EntityType.CHICKEN);

						// if (chicken == null) {
						// System.out
						// .println("[ColourFireWork LOG] - Chicken = null!");
						// player.sendMessage(ChatColor.RED
						// + "An Error occured, Please try again?");
						// stopDropParty();
						// }

						// if (chicken == null)
						// return;

						// List<Entity> list = chicken.getNearbyEntities(radius,
						// radius, radius);

						// chicken.remove();
						startDropParty(player, hide);

						// int test01 = 0;
						// int test02 = list.size();

						colourfireworks.BlockSignOn.clear();

						colourfireworks.BlockSignOn.put("ID", event.getBlock()
								.getLocation().add(0, -1, 0).getBlock()
								.getTypeId());
						colourfireworks.BlockSignOn.put("SUBID", (int) event
								.getBlock().getLocation().add(0, -1, 0)
								.getBlock().getData());

						event.getBlock().getLocation().add(0, -1, 0).getBlock()
								.setType(Material.BEDROCK);

						colourfireworks.HowManyItemsInTotal.clear();
						colourfireworks.HowManySlotItems.clear();
						colourfireworks.WhatIsSlotItemsID.clear();
						colourfireworks.WhatIsSlotItemsSUBID.clear();
						colourfireworks.Max.put("insofar", 0);

						colourfireworks.Hide.put("hide", hide);

						// while (test02 > test01) {
						// Entity entity = list.get(test01);
						// if (entity instanceof Player) {
						// ((Player) entity)
						// .getPlayer()
						// .sendMessage(
						// ChatColor.GOLD
						// + player.getName()
						// + ChatColor.GREEN
						// + " Has started a drop party! at:");
						// ((Player) entity).getPlayer().sendMessage(
						// ChatColor.AQUA
						// + "X "
						// + ChatColor.LIGHT_PURPLE
						// + block.getLocation()
						// .getBlockX()
						// + ChatColor.GRAY
						// + ", "
						// + ChatColor.AQUA
						// + "Y "
						// + ChatColor.LIGHT_PURPLE
						// + block.getLocation()
						// .getBlockY()
						// + ChatColor.GRAY
						// + ", "
						// + ChatColor.AQUA
						// + "Z "
						// + ChatColor.LIGHT_PURPLE
						// + block.getLocation()
						// .getBlockZ());
						// ((Player) entity).getPlayer().sendMessage(
						// ChatColor.GOLD
						// + "60 Secound timer started!");
						//
						// }
						//
						// test01++;
						// }

					} else {
						player.sendMessage(ChatColor.RED
								+ "Alreadly a drop party in progress!");
						block.setType(Material.AIR);
						block.getWorld().dropItemNaturally(block.getLocation(),
								sign);
					}

				}

			} else {
				block.setType(Material.AIR);
				block.getWorld().dropItemNaturally(block.getLocation(), sign);
				player.sendMessage(ChatColor.RED
						+ "You do not have permission to create a drop party sign!");
			}

		}

		if (event.getLine(1).equalsIgnoreCase("[FireWork]")
				|| (event.getLine(1).equalsIgnoreCase("[Fire Work]"))) {
			if (player.hasPermission("colourfireworks.redstonesign.*")
					|| player.isOp()) {
				event.setLine(1, "[FireWork]");
			} else {
				block.setType(Material.AIR);
				block.getWorld().dropItemNaturally(block.getLocation(), sign);
				player.sendMessage(ChatColor.RED
						+ "You do not have permission to create a firework sign!");
			}
			if (player.hasPermission("colourfireworks.redstonesign.*")
					|| player.isOp()) {
				if (event.getLine(2).equalsIgnoreCase("[white]")
						|| (event.getLine(2).equalsIgnoreCase("[35]"))
						|| (event.getLine(1).equalsIgnoreCase("[35:1]"))) {
					event.setLine(2, "[White]");
					player.sendMessage(ChatColor.GREEN
							+ "White Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[orange]")
						|| (event.getLine(1).equalsIgnoreCase("[35:1]"))) {
					event.setLine(2, "[Orange]");
					player.sendMessage(ChatColor.GREEN
							+ "Orange Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[magenta]")
						|| (event.getLine(2).equalsIgnoreCase("[35:2]"))) {
					event.setLine(2, "[Magenta]");
					player.sendMessage(ChatColor.GREEN
							+ "Magenta Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[lightblue]")
						|| (event.getLine(2).equalsIgnoreCase("[light blue]"))
						|| (event.getLine(2).equalsIgnoreCase("[35:3]"))) {
					event.setLine(2, "[LightBlue]");
					player.sendMessage(ChatColor.GREEN
							+ "Light Blue Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[yellow]")
						|| (event.getLine(2).equalsIgnoreCase("[35:4]"))) {
					event.setLine(2, "[Yellow]");
					player.sendMessage(ChatColor.GREEN
							+ "White Yellow Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[lime]")
						|| (event.getLine(2).equalsIgnoreCase("[35:5]"))) {
					event.setLine(2, "[Lime]");
					player.sendMessage(ChatColor.GREEN
							+ "Lime Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[pink]")
						|| (event.getLine(2).equalsIgnoreCase("[35:6]"))) {
					event.setLine(2, "[Pink]");
					player.sendMessage(ChatColor.GREEN
							+ "Pink Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[grey]")
						|| (event.getLine(2).equalsIgnoreCase("[35:7]"))) {
					event.setLine(2, "[Grey]");
					player.sendMessage(ChatColor.GREEN
							+ "Grey Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[silver]")
						|| (event.getLine(2).equalsIgnoreCase("[35:8]"))) {
					event.setLine(2, "[Silver]");
					player.sendMessage(ChatColor.GREEN
							+ "Silver Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[cyan]")
						|| (event.getLine(2).equalsIgnoreCase("[35:9]"))) {
					event.setLine(2, "[Cyan]");
					player.sendMessage(ChatColor.GREEN
							+ "Cyan Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[purple]")
						|| (event.getLine(2).equalsIgnoreCase("[35:10]"))) {
					event.setLine(2, "[Purple]");
					player.sendMessage(ChatColor.GREEN
							+ "Purple Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[blue]")
						|| (event.getLine(2).equalsIgnoreCase("[35:11]"))) {
					event.setLine(2, "[Blue]");
					player.sendMessage(ChatColor.GREEN
							+ "Blue Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[brown]")
						|| (event.getLine(2).equalsIgnoreCase("[35:12]"))) {
					event.setLine(2, "[Brown]");
					player.sendMessage(ChatColor.GREEN
							+ "Brown Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[green]")
						|| (event.getLine(2).equalsIgnoreCase("[35:13]"))) {
					event.setLine(2, "[Green]");
					player.sendMessage(ChatColor.GREEN
							+ "Green Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[red]")
						|| (event.getLine(2).equalsIgnoreCase("[35:14]"))) {
					event.setLine(2, "[Red]");
					player.sendMessage(ChatColor.GREEN
							+ "Red Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[black]")
						|| (event.getLine(2).equalsIgnoreCase("[35:15]"))) {
					event.setLine(2, "[Black]");
					player.sendMessage(ChatColor.GREEN
							+ "Black Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[pumpkin]")
						|| (event.getLine(2).equalsIgnoreCase("[86]"))) {
					event.setLine(2, "[Pumpkin]");
					player.sendMessage(ChatColor.GREEN
							+ "Pumpkin Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[glass]")
						|| (event.getLine(2).equalsIgnoreCase("[20]"))
						|| (event.getLine(2).equalsIgnoreCase("[exp]") || (event
								.getLine(2).equalsIgnoreCase("[orb]") || (event
								.getLine(2).equalsIgnoreCase("[exporp]") || (event
								.getLine(2).equalsIgnoreCase("[exp orb]")))))) {
					event.setLine(2, "[Exp]");
					player.sendMessage(ChatColor.GREEN
							+ "Exp Firework Sign Created!");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("[snow]")
						|| (event.getLine(2).equalsIgnoreCase("[snowblock]"))
						|| (event.getLine(2).equalsIgnoreCase("[snow block]"))
						|| (event.getLine(2).equalsIgnoreCase("[80]"))) {
					event.setLine(2, "[SnowBlock]");
					player.sendMessage(ChatColor.GREEN
							+ "Snow Block Firework Sign Created!");
					signcorrect = 1;
				}

				int customlol = 1;

				if (event.getLine(2).contains("[Custom")
						|| (event.getLine(2).contains("[custom"))) {
					customlol = 0;
					signcorrect = 3;
				}

				int custq = 1;
				while (plugin.customConfig.contains("Custom.Firework" + custq
						+ ".use") == true) {
					if (plugin.customConfig.getBoolean("Custom.Firework"
							+ custq + ".use") == true) {
						if (event.getLine(2).contains("[custom" + custq + "]")
								|| (event.getLine(2).contains("[Custom" + custq
										+ "]"))) {
							event.setLine(2, "[Custom" + custq + "]");
							player.sendMessage(ChatColor.BLUE
									+ "Custom Firework Sign Created!");
							signcorrect = 2;
							customlol = 1;
						}
					}

					custq = custq + 1;

				}
				if (event.getLine(2).equalsIgnoreCase("")) {
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(block.getLocation(),
							sign);
					player.sendMessage(ChatColor.AQUA
							+ "Nothing found on line 3. Please enter what you want the firework to be");
					player.sendMessage(ChatColor.AQUA
							+ "For example '[Pumpkin]' or '[Red]' or '[35:7]' For a full list imput '[help]'");
					signcorrect = 1;
				}
				if (event.getLine(2).equalsIgnoreCase("help")
						|| (event.getLine(2).equalsIgnoreCase("[help]"))) {
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(block.getLocation(),
							sign);
					player.sendMessage(ChatColor.AQUA
							+ "The possible"
							+ ChatColor.GREEN
							+ " colour "
							+ ChatColor.AQUA
							+ "fireworks are: "
							+ ChatColor.GOLD
							+ "White, Orange, Magenta, LightBlue, Yellow, Lime, Pink, Grey, Sliver, Cyan, Purple, Blue, Brown, Green, Red"
							+ ChatColor.WHITE + " and " + ChatColor.GOLD
							+ "Black");
					player.sendMessage(ChatColor.AQUA + "The possible"
							+ ChatColor.GREEN + " other " + ChatColor.AQUA
							+ "fireworks are: " + ChatColor.GOLD
							+ "Pumpkin and SnowBlock");
					player.sendMessage(ChatColor.LIGHT_PURPLE
							+ "Block ids can be used as well");
					signcorrect = 1;
				}
				if (signcorrect == 0) {
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(block.getLocation(),
							sign);
					player.sendMessage(ChatColor.RED
							+ "Firework was not recognised!");
					player.sendMessage(ChatColor.RED
							+ "For help imput 'help' or '[help]' on to the 3rd line");
				}
				if (customlol == 0) {
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(block.getLocation(),
							sign);
					player.sendMessage(ChatColor.RED
							+ "Custom Fire Work Does not Exist!");
				}
			}

		}

	}


}

