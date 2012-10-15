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

public class FireworkSnowBlock {
	
	public static void RunFireworkSnowBlock(final colourfireworks plugin,
			final Player player, final Block block,
			final double fireworkheight, Random rand, Integer fireticks,
			boolean infinite) {
		


		int build3;

		build3 = 0;

		if (plugin.getWorldGuard() != null) {

			boolean canbuild = plugin.getWorldGuard().canBuild(player,
					block.getLocation().getBlock().getRelative(0, 0, 0));

			if (!canbuild) {

				player.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED
						+ "WARNING" + ChatColor.WHITE + "] " + ChatColor.RED
						+ "You can not set off fireworks in this region!");
				build3 = 1;
			}
			if (canbuild) {
				build3 = 0;
			}
		}

		if (build3 == 0) {
			// If yes, say:
			if (plugin.getConfig().getBoolean("Fireworks.Message.SendOnLaunch") == true) {
				player.sendMessage(ChatColor.GOLD + "The SnowBlock Goes off!");
			}
			if (infinite == false) {
				block.setType(Material.AIR);
			}
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
	
	
	@SuppressWarnings("deprecation")
	public static void RunSnowBlockExplode(final colourfireworks plugin, final Entity entity, Random rand, int snow, int gold, int diamond, int golem, int itemspread) {



		if (plugin.getConfig().getBoolean("Fireworks.Snow.PotionEffects")) {
			
		Entity e = entity;
		World w = e.getWorld();
		Location l = e.getLocation();


		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX(), l.getY() + 1, l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX(), l.getY() + 2, l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX(), l.getY() - 1, l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX(), l.getY() - 2, l.getZ()), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l.getX() + 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX() + 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX() - 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX() - 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 1), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 2), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 1), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 2), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 7);
		

		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX(), l.getY() + 1, l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX(), l.getY() + 2, l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX(), l.getY() - 1, l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX(), l.getY() - 2, l.getZ()), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l.getX() + 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX() + 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX() - 1, l.getY(), l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX() - 2, l.getY(), l.getZ()), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 1), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() + 2), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 1), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX(), l.getY(), l.getZ() - 2), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX() + 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() - 3), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l.getX() - 3, l.getY(), l.getZ() + 3), Effect.POTION_BREAK, 1);
		
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
		
		//
		
		
		w.playEffect(new Location(w, l2.getX(), l.getY() + 5, l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 4, l.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 3, l.getZ()), Effect.POTION_BREAK, 7);
		
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 7);

		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 7);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 7);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 7);
		
		
		
		
		
		
		w.playEffect(new Location(w, l2.getX(), l.getY() + 5, l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 4, l.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX(), l.getY() + 3, l.getZ()), Effect.POTION_BREAK, 1);
		
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ()), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ()), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l2.getX() - 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX() - 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 1);

		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l2.getX() + 2, l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX() + 4, l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() - 2), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() - 4), Effect.POTION_BREAK, 1);
		
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 4, l2.getZ() + 2), Effect.POTION_BREAK, 1);
		w.playEffect(new Location(w, l2.getX(), l2.getY() + 3, l2.getZ() + 4), Effect.POTION_BREAK, 1);
		
		}
		
		
		int snowlol1;
		snowlol1 = 0;
		int diamondlol1;
		diamondlol1 = 0;
		int goldlol1;
		goldlol1 = 0;

		double golemlol;
		golemlol = 0;
		
		final ItemStack itemsnowball = new ItemStack(Material.SNOW_BALL, 1);
		final ItemStack itemdiamond = new ItemStack(Material.DIAMOND, 1);
		final ItemStack itemgoldi = new ItemStack(Material.GOLD_INGOT, 1);
		final ItemStack itemcake = new ItemStack(Material.CAKE, 1);



		while (golem > golemlol) {
			
			int wherex = entity.getLocation().getBlockX();
			int wherez = entity.getLocation().getBlockZ();

			int wherey = entity.getWorld()
					.getHighestBlockYAt(wherex, wherez);

			Location wheretospawnmob = new Location(
					entity.getWorld(), wherex, wherey,
					wherez);
			
			
			entity.getWorld().spawnCreature(wheretospawnmob,EntityType.SNOWMAN);
			golemlol++;
		}

		while (snow > snowlol1) {

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

			final Item snowballitem = entity.getWorld().dropItemNaturally(
					entity.getLocation(), itemsnowball);
			snowballitem.setItemStack(itemcake);
			snowballitem.setVelocity(new Vector(r1, r3, r2));
						
			plugin.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(plugin,
					new Runnable() {

						public void run() {

							snowballitem.setItemStack(itemsnowball);

						}
					}, 20);
			
			snowlol1++;
		}
		while (diamond > diamondlol1) {

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

			final Item diamonditem = entity.getWorld().dropItemNaturally(
					entity.getLocation(), itemdiamond);
			diamonditem.setItemStack(itemcake);
			diamonditem.setVelocity(new Vector(r1, r3, r2));
			
			plugin.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(plugin,
					new Runnable() {

						public void run() {

							diamonditem.setItemStack(itemdiamond);

						}
					}, 20);
			
			diamondlol1++;
		}
		while (gold > goldlol1) {

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

			final Item goldingotitem = entity.getWorld().dropItemNaturally(
					entity.getLocation(), itemgoldi);
			goldingotitem.setItemStack(itemcake);
			goldingotitem.setVelocity(new Vector(r1, r3, r2));
			
			plugin.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(plugin,
					new Runnable() {

						public void run() {

							goldingotitem.setItemStack(itemgoldi);

						}
					}, 20);
			
			goldlol1++;
		}

		
	}

}
