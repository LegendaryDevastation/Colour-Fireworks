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

public class WoolLightGray {
	
	public static void RunWoolLightGray(final colourfireworks plugin,
			final Entity entity, Random rand, int dyeamount, int itemspread,
			boolean pickup, boolean setonfire, boolean remove,
			final boolean effect, int ticksuntillremove) {

		if (plugin.getConfig().getBoolean("Fireworks.Dye.PotionEffects")) {
			
		Entity e = entity;
		World w = e.getWorld();
		Location l = e.getLocation();


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
		
		}

		int silverlol1;

		silverlol1 = 0;

		int silverlol;

		silverlol = dyeamount;

		while (silverlol > silverlol1) {
			
			final ItemStack silverloldyeitem = new ItemStack(Material.INK_SACK, 1,
					(short) (15 - DyeColor.SILVER.getData()));
			
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

			final Item silverfire = entity.getWorld().dropItemNaturally(
					entity.getLocation(), silverloldyeitem);
			
			silverfire.setItemStack(cake);

			if (pickup == false) {
				silverfire.setTicksLived(999999999);
			}

			silverfire.setVelocity(new Vector(r1, r3, r2));
			
			plugin.getServer()
			.getScheduler()
			.scheduleSyncDelayedTask(plugin,
					new Runnable() {

						public void run() {

							silverfire.setItemStack(silverloldyeitem);

						}
					}, 20);

			if (remove == true) {

				plugin.getServer().getScheduler()
						.scheduleSyncDelayedTask(plugin, new Runnable() {

							public void run() {
								if (effect == true) {
									silverfire
											.getLocation()
											.getWorld()
											.playEffect(
													silverfire.getLocation(),
													Effect.MOBSPAWNER_FLAMES,
													60);
								}
								silverfire.remove();

							}
						}, ticksuntillremove);

			}

			if (setonfire == true) {

				silverfire.setFireTicks(300);
			}

			silverlol1++;
		}

	}


}
