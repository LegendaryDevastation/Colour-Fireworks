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

public class WoolGray {
	
	public static void RunWoolGray(final colourfireworks plugin,
			final Entity entity, Random rand, int dyeamount, int itemspread,
			boolean pickup, boolean setonfire, boolean remove,
			final boolean effect, int ticksuntillremove) {

		ItemStack grayloldyeitem = new ItemStack(Material.INK_SACK, 1,
				(short) (15 - DyeColor.GRAY.getData()));

		int graylol1;

		graylol1 = 0;

		int graylol;

		graylol = dyeamount;

		while (graylol > graylol1) {

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

			final Item grayfire = entity.getWorld().dropItemNaturally(
					entity.getLocation(), grayloldyeitem);

			if (pickup == false) {
				grayfire.setTicksLived(999999999);
			}

			grayfire.setVelocity(new Vector(r1, r3, r2));

			if (remove == true) {

				plugin.getServer().getScheduler()
						.scheduleSyncDelayedTask(plugin, new Runnable() {

							public void run() {
								if (effect == true) {
									grayfire
											.getLocation()
											.getWorld()
											.playEffect(
													grayfire.getLocation(),
													Effect.MOBSPAWNER_FLAMES,
													60);
								}
								grayfire.remove();

							}
						}, ticksuntillremove);

			}

			if (setonfire == true) {

				grayfire.setFireTicks(300);
			}

			graylol1++;
		}

	}


}
