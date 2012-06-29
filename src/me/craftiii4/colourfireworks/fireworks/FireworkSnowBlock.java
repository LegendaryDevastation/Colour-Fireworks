package me.craftiii4.colourfireworks.fireworks;

import java.util.Random;

import me.craftiii4.colourfireworks.colourfireworks;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
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
	
	
	public static void RunSnowBlockExplode(final colourfireworks plugin, final Entity entity, Random rand, int snow, int gold, int diamond, int golem, int itemspread) {

		int snowlol1;
		snowlol1 = 0;
		int diamondlol1;
		diamondlol1 = 0;
		int goldlol1;
		goldlol1 = 0;

		double golemlol;
		golemlol = 0;
		
		ItemStack itemsnowball = new ItemStack(Material.SNOW_BALL, 1);
		ItemStack itemdiamond = new ItemStack(Material.DIAMOND, 1);
		ItemStack itemgoldi = new ItemStack(Material.GOLD_INGOT, 1);



		while (golem > golemlol) {
			
			int wherex = entity.getLocation().getBlockX();
			int wherez = entity.getLocation().getBlockZ();

			int wherey = entity.getWorld()
					.getHighestBlockYAt(wherex, wherez);

			Location wheretospawnmob = new Location(
					entity.getWorld(), wherex, wherey,
					wherez);
			
			
			entity.getWorld().spawnCreature(
					wheretospawnmob,
					EntityType.SNOWMAN);
			golemlol++;
		}

		while (snow > snowlol1) {

			double r1;
			double r2;

			int r01;
			int r02;

			r01 = itemspread;
			r01 = (r01 * 2);

			r02 = itemspread;

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

			Item snowballitem = entity.getWorld().dropItemNaturally(
					entity.getLocation(), itemsnowball);
			snowballitem.setVelocity(new Vector(r1, 0, r2));
			snowlol1++;
		}
		while (diamond > diamondlol1) {

			double r1;
			double r2;

			int r01;
			int r02;

			r01 = itemspread;
			r01 = (r01 * 2);

			r02 = itemspread;

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

			Item diamonditem = entity.getWorld().dropItemNaturally(
					entity.getLocation(), itemdiamond);
			diamonditem.setVelocity(new Vector(r1, 0, r2));
			diamondlol1++;
		}
		while (gold > goldlol1) {

			double r1;
			double r2;

			int r01;
			int r02;

			r01 = itemspread;
			r01 = (r01 * 2);

			r02 = itemspread;

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

			Item goldingotitem = entity.getWorld().dropItemNaturally(
					entity.getLocation(), itemgoldi);
			goldingotitem.setVelocity(new Vector(r1, 0, r2));
			goldlol1++;
		}

		
	}

}
