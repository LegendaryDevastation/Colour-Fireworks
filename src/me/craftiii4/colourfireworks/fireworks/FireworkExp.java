package me.craftiii4.colourfireworks.fireworks;

import java.util.Random;

import me.craftiii4.colourfireworks.colourfireworks;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

public class FireworkExp {

	public static void RunFireworkExp(final colourfireworks plugin,
			final Player player, final Block block,
			final double fireworkheight, Random rand, Integer fireticks,
			boolean infinite) {

		int build2;

		build2 = 0;

		if (plugin.getWorldGuard() != null) {

			boolean canbuild = plugin.getWorldGuard().canBuild(player,
					block.getLocation().getBlock().getRelative(0, 0, 0));

			if (!canbuild) {

				player.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED
						+ "WARNING" + ChatColor.WHITE + "] " + ChatColor.RED
						+ "You can not set off fireworks in this region!");
				build2 = 1;
			}
			if (canbuild) {
				build2 = 0;
			}
		}

		if (build2 == 0) {
			if (plugin.getConfig().getBoolean("Fireworks.Message.SendOnLaunch") == true) {
				player.sendMessage(ChatColor.GOLD
						+ "The Exp Firework Goes off!");
			}
			if (infinite == false) {

				block.setType(Material.AIR);

			}
			// Prime the wool is a TNT
			TNTPrimed firework = block.getLocation().getWorld()
					.spawn(block.getLocation(), TNTPrimed.class);
			// Shoot the TNT up into the air
			firework.setVelocity(new Vector((rand.nextFloat() - 0.5f) / 3,
					fireworkheight, (rand.nextFloat() - 0.5f) / 3));
			// Set the fuse ticks of the TNT to 35
			firework.setFuseTicks(35);
			// Set the fire ticks to 101, this also allows the
			// listeners to detect which fire work went off
			firework.setFireTicks(fireticks);

		}

	}

	public static void RunExpBlockExplode(final colourfireworks plugin,
			final Entity entity, Random rand, int orbamount, int orbvalue,
			int itemspread, boolean remove, final boolean effect,
			int ticksuntillremove) {
		
		if (plugin.getConfig().getBoolean("Fireworks.Exp.PotionEffects")) {
			
			Entity e = entity;
			World w = e.getWorld();
			Location l = e.getLocation();


			w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY() + 1, l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY() + 2, l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY() - 1, l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY() - 2, l.getZ()), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l.getX() + 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() + 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() - 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() - 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 1), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 2), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 1), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 2), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l.getX() + 1, l.getY() - 4, l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() + 2, l.getY() - 4, l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() - 1, l.getY() - 4, l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() - 2, l.getY() - 4, l.getZ()), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l.getX(), l.getY() - 4, l.getZ() + 1), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY() - 4, l.getZ() + 2), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY() - 4, l.getZ() - 1), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX(), l.getY() - 4, l.getZ() - 2), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l.getX() + 3, l.getY() - 4, l.getZ() + 3), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() + 3, l.getY() - 4, l.getZ() - 3), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() - 3, l.getY() - 4, l.getZ() - 3), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l.getX() - 3, l.getY() - 4, l.getZ() + 3), Effect.POTION_BREAK, 4);
			
			
			
			Location l2 = e.getWorld().getHighestBlockAt(l).getLocation();
			
			w.playEffect(new Location(w, l2.getX(), l.getY() + 5, l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX(), l.getY() + 4, l.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX(), l.getY() + 3, l.getZ()), Effect.POTION_BREAK, 4);
			
			
			w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 4);

			w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 4);
			
			w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 4);
			w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 4);
			
			}

		double exp;
		exp = 0;

		int exp1;
		exp1 = orbamount;
		Math.round(exp1);

		while (exp1 > exp) {
			
			

			

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

			final ExperienceOrb orb = entity.getWorld().spawn(
					entity.getLocation(), ExperienceOrb.class);
						
			int exp2;
			exp2 = orbvalue;
			orb.setExperience(exp2);
			orb.setVelocity(new Vector(r1, r3, r2));

			if (remove == true) {

				plugin.getServer().getScheduler()
						.scheduleSyncDelayedTask(plugin, new Runnable() {

							public void run() {

								if (effect == true) {

									orb.getLocation()
											.getWorld()
											.playEffect(orb.getLocation(),
													Effect.MOBSPAWNER_FLAMES,
													60);
								}
								orb.remove();

							}
						}, ticksuntillremove);

			}

			orb.setVelocity(new Vector(r1, r3, r2));
			exp = (exp + 1);
		}

	}

}
