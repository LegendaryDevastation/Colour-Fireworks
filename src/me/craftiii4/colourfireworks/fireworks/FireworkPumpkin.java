package me.craftiii4.colourfireworks.fireworks;

import java.util.Random;

import me.craftiii4.colourfireworks.colourfireworks;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class FireworkPumpkin {

	public static void RunFireworkPumpkin(final colourfireworks plugin,
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
				player.sendMessage(ChatColor.GOLD + "The Pumpkin Goes off!");
			}
			if (infinite == false) {
				block.setType(Material.AIR);
			}
			TNTPrimed firework = block.getLocation().getWorld()
					.spawn(block.getLocation(), TNTPrimed.class);
			firework.setVelocity(new Vector((rand.nextFloat() - 0.5f) / 3,
					fireworkheight, (rand.nextFloat() - 0.5f) / 3));
			firework.setFuseTicks(35);

			firework.setFireTicks(fireticks);

		}

	}

	public static void RunPumpkinExplode(final colourfireworks plugin,
			final Entity entity, Random rand, int cookie, int cake,
			int pumpkin, int web, int spider, int itemspread) {

		int weblol;
		weblol = 0;
		int pumpkinlol;
		pumpkinlol = 0;
		int cakelol;
		cakelol = 0;
		int cookielol;
		cookielol = 0;
		int spiderlol;
		spiderlol = 0;

		ItemStack itemweb = new ItemStack(Material.WEB, 1);
		ItemStack itempumpkin = new ItemStack(Material.PUMPKIN, 1);
		ItemStack itemcake = new ItemStack(Material.CAKE, 1);
		ItemStack itemcookie = new ItemStack(Material.COOKIE, 1);

		while (web > weblol) {
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
			
			entity.getWorld().dropItemNaturally(entity.getLocation(), itemweb)
					.setVelocity(new Vector(r1, r3, r2));
			weblol++;

		}

		while (pumpkin > pumpkinlol) {
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
			
			entity.getWorld()
					.dropItemNaturally(entity.getLocation(), itempumpkin)
					.setVelocity(new Vector(r1, r3, r2));
			pumpkinlol++;

		}

		while (cake > cakelol) {
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
			
			entity.getWorld().dropItemNaturally(entity.getLocation(), itemcake)
					.setVelocity(new Vector(r1, r3, r2));
			cakelol++;

		}

		while (cookie > cookielol) {
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
			
			entity.getWorld()
					.dropItemNaturally(entity.getLocation(), itemcookie)
					.setVelocity(new Vector(r1, r3, r2));
			cookielol = (cookielol + 1);

		}
		while (spider > spiderlol) {
			
			int wherex = entity.getLocation().getBlockX();
			int wherez = entity.getLocation().getBlockZ();

			int wherey = entity.getWorld()
					.getHighestBlockYAt(wherex, wherez);

			Location wheretospawnmob = new Location(
					entity.getWorld(), wherex, wherey,
					wherez);
			
			entity.getWorld().spawnCreature(wheretospawnmob, EntityType.SPIDER);
			spiderlol++;
		}

	}

}
