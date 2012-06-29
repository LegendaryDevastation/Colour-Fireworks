package me.craftiii4.colourfireworks.fireworks.colour;

import java.util.Random;

import me.craftiii4.colourfireworks.colourfireworks;

import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class WoolRed {
	
	public static void RunWoolRed(final colourfireworks plugin,
			final Entity entity, Random rand, int dyeamount, int itemspread,
			boolean pickup, boolean setonfire, boolean remove,
			final boolean effect, int ticksuntillremove) {

		ItemStack redloldyeitem = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.RED.getData()));

		int redlol1;

		redlol1 = 0;

		int redlol;

		redlol = dyeamount;

		while (redlol > redlol1) {

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

			final Item redfire = entity.getWorld().dropItemNaturally(
					entity.getLocation(), redloldyeitem);

			if (pickup == false) {
				redfire.setTicksLived(999999999);
			}

			redfire.setVelocity(new Vector(r1, r3, r2));

			if (remove == true) {

				plugin.getServer().getScheduler()
						.scheduleSyncDelayedTask(plugin, new Runnable() {

							public void run() {
								if (effect == true) {
									redfire
											.getLocation()
											.getWorld()
											.playEffect(
													redfire.getLocation(),
													Effect.MOBSPAWNER_FLAMES,
													60);
								}
								redfire.remove();

							}
						}, ticksuntillremove);

			}

			if (setonfire == true) {

				redfire.setFireTicks(300);
			}

			redlol1++;
		}

	}


}
