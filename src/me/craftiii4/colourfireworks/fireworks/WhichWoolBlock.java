package me.craftiii4.colourfireworks.fireworks;

import java.util.Random;

import me.craftiii4.colourfireworks.colourfireworks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;

public class WhichWoolBlock {
	
	public static void RunWhichWoolBlock(final colourfireworks plugin,
			final Player player, final Block block,
			final double fireworkheight, Random rand, Integer fireticks,
			boolean infinite) {

		int build;

		build = 0;

		if (plugin.getWorldGuard() != null) {

			boolean canbuild = plugin.getWorldGuard().canBuild(player,
					block.getLocation().getBlock().getRelative(0, 0, 0));

			if (!canbuild) {
				player.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED
						+ "WARNING" + ChatColor.WHITE + "] " + ChatColor.RED
						+ "You can not set off fireworks in this region!");
				build = 1;
			}
			if (canbuild) {
				build = 0;
			}
		}

		if (build == 0) {

			if (plugin.getConfig().getBoolean("Fireworks.Message.SendOnLaunch") == true) {
				player.sendMessage(ChatColor.GOLD + "The fire work goes off!");
			}
			
			if (infinite == false) {
				block.setType(Material.AIR);
			}

			TNTPrimed firework = block.getLocation().getWorld()
					.spawn(block.getLocation(), TNTPrimed.class);
			firework.setVelocity(new Vector((rand.nextFloat() - 0.5f) / 3, 1.5,
					(rand.nextFloat() - 0.5f) / 3));
			firework.setFuseTicks(35);
			// Set the fire ticks to 99, this also allows
			// the listeners to detect which fire work went
			// off
			firework.setFireTicks(fireticks);

		}
	}
	
	public static void RunWoolBlockExplode(final colourfireworks plugin, final Entity entity, Random rand, int dyeamount, int datavalue, int itemspread, boolean remove, final boolean effect, int ticksuntillremove) {
		
	}
}
