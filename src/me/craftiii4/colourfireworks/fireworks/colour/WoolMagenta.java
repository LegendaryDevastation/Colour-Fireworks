package me.craftiii4.colourfireworks.fireworks.colour;

import java.util.Random;

import me.craftiii4.colourfireworks.colourfireworks;

import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class WoolMagenta {
	
	public static void RunWoolMagenta(final colourfireworks plugin,
			final Entity entity, Random rand, int dyeamount, int itemspread,
			boolean pickup, boolean setonfire, boolean remove,
			final boolean effect, int ticksuntillremove) {

		if (plugin.getConfig().getBoolean("Fireworks.Dye.PotionEffects")) {
			
		Entity e = entity;
		World w = e.getWorld();
		Location l = e.getLocation();


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
		
		}
		int magentalol1;

		magentalol1 = 0;

		int magentalol;

		magentalol = dyeamount;

		while (magentalol > magentalol1) {
			
			final ItemStack magentaloldyeitem = new ItemStack(Material.INK_SACK, 1,
					(short) (15 - DyeColor.MAGENTA.getData()));
			
			final ItemStack cake = new ItemStack(Material.CAKE, 1);

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

			final Item magentafire = entity.getWorld().dropItemNaturally(
					entity.getLocation(), magentaloldyeitem);

			magentafire.setItemStack(cake);

			if (pickup == false) {
				magentafire.setTicksLived(999999999);
			}

			magentafire.setVelocity(new Vector(r1, r3, r2));
			
			plugin.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(plugin,
					new Runnable() {

						public void run() {

							magentafire.setItemStack(magentaloldyeitem);

						}
					}, 20);

			if (remove == true) {

				plugin.getServer().getScheduler()
						.scheduleSyncDelayedTask(plugin, new Runnable() {

							public void run() {
								if (effect == true) {
									magentafire
											.getLocation()
											.getWorld()
											.playEffect(
													magentafire.getLocation(),
													Effect.MOBSPAWNER_FLAMES,
													60);
								}
								magentafire.remove();

							}
						}, ticksuntillremove);

			}

			if (setonfire == true) {

				magentafire.setFireTicks(300);
			}

			magentalol1++;
		}

	}


}
