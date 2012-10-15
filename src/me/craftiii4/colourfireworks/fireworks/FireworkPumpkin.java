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
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
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

	@SuppressWarnings("deprecation")
	public static void RunPumpkinExplode(final colourfireworks plugin,
			final Entity entity, Random rand, int cookie, int cake,
			int pumpkin, int web, int spider, int itemspread) {
		
		
		if (plugin.getConfig().getBoolean("Fireworks.Pumpkin.PotionEffects")) {
			
		Entity e = entity;
		World w = e.getWorld();
		Location l = e.getLocation();


		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX(), l.getY() + 1, l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX(), l.getY() + 2, l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX(), l.getY() - 1, l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX(), l.getY() - 2, l.getZ()), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l.getX() + 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX() + 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX() - 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX() - 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 1), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 2), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 1), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 2), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX(), l.getY() + 1, l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX(), l.getY() + 2, l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX(), l.getY() - 1, l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX(), l.getY() - 2, l.getZ()), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l.getX() + 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX() + 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX() - 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX() - 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 1), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 2), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 1), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 2), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX(), l.getY() + 1, l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX(), l.getY() + 2, l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX(), l.getY() - 1, l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX(), l.getY() - 2, l.getZ()), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l.getX() + 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX() + 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX() - 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX() - 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 1), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 2), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 1), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 2), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 2);
		
		
		Location l2 = e.getWorld().getHighestBlockAt(l).getLocation();
		
		w.playEffect(new Location(w, l2.getX(), l.getY() + 4, l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 5, l.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 3, l.getZ()), Effect.POTION_BREAK, 3);
		
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 3);

		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 3);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 3);
		
		w.playEffect(new Location(w, l2.getX(), l.getY() + 4, l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 5, l.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 3, l.getZ()), Effect.POTION_BREAK, 2);
		
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 2);

		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 2);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 2);
		
		w.playEffect(new Location(w, l2.getX(), l.getY() + 4, l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 5, l.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 3, l.getZ()), Effect.POTION_BREAK, 10);
		
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 10);

		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 10);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 10);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 10);
		
		}

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

		final ItemStack itemweb = new ItemStack(Material.WEB, 1);
		final ItemStack itempumpkin = new ItemStack(Material.PUMPKIN, 1);
		final ItemStack itemcake = new ItemStack(Material.CAKE, 1);
		final ItemStack itemcookie = new ItemStack(Material.COOKIE, 1);

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
			
			final Item web1 = entity.getWorld().dropItemNaturally(entity.getLocation(), itemweb);
			web1.setItemStack(itemcake);
			web1.setVelocity(new Vector(r1, r3, r2));
			
			plugin.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(plugin,
					new Runnable() {

						public void run() {

							web1.setItemStack(itemweb);

						}
					}, 20);
			
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
			
			final Item pumpkin1 = entity.getWorld().dropItemNaturally(entity.getLocation(), itempumpkin);
			pumpkin1.setItemStack(itemcake);
			pumpkin1.setVelocity(new Vector(r1, r3, r2));
			
			plugin.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(plugin,
					new Runnable() {

						public void run() {

							pumpkin1.setItemStack(itempumpkin);

						}
					}, 20);
			
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
			
			final Item cookie1 = entity.getWorld().dropItemNaturally(entity.getLocation(), itemcookie);
			cookie1.setItemStack(itemcake);
			cookie1.setVelocity(new Vector(r1, r3, r2));
			
			plugin.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(plugin,
					new Runnable() {

						public void run() {

							cookie1.setItemStack(itemcookie);

						}
					}, 20);
			
			
			cookielol++;

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
