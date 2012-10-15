package me.craftiii4.colourfireworks;

import java.net.*;
import java.io.*;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class URLReader {

	public static String latestversion = null;

	public static boolean sendupdatemessage;

	public static void main(colourfireworks plugin) throws Exception {
		// URL craftiii4 = new URL(
		// "http://www.craftiii4.co.uk/eng/colourfireworks/version");

		URL craftiii4 = new URL(
				"http://dev.bukkit.org/server-mods/miscfun-colourfireworks-v1-01-tu/pages/info-for-plugin/");

		BufferedReader in = new BufferedReader(new InputStreamReader(
				craftiii4.openStream()));

		String inputLine;

		while ((inputLine = in.readLine()) != null) {

			if (inputLine.contains("Latest Version = ")) {

				String newinputLine = inputLine
						.replace(
								"<div class=\"content-box\"><div class=\"content-box-inner\"><p>Latest Version = \"",
								"").replace("\"</p>", "").replace(" ", "");

				String version = plugin.getDescription().getVersion();

				if (version.equals(newinputLine)) {
					System.out
							.println("[ColourFireWorks] You are running the latest version!");
					colourfireworks.latestversion = true;
				} else {
					System.out
							.println("[ColourFireWorks] A new version is out - v"
									+ newinputLine);
					latestversion = newinputLine;
					colourfireworks.latestversion = false;
				}

			}

			// String newinputLine = inputLine.replace("<p>", "")
			// .replace("</p>", "").replace("&nbsp;", "");

			// Latest Version =

			// if (!newinputLine.contains("2.0.1")) {

			// System.out.println("[ColourFireWorks] V" + newinputLine
			// + " is out!");
			// colourfireworks.latestversion = false;
			// latestversion = newinputLine;
			// } else {
			// System.out
			// .println("[ColourFireWorks] You are running the latest version!");
			// colourfireworks.latestversion = true;
			// }
		}

		in.close();
	}

	public static void main2(colourfireworks plugin, Player player)
			throws Exception {
		// URL craftiii4 = new URL(
		// "http://www.craftiii4.co.uk/eng/colourfireworks/version");

		URL craftiii4 = new URL(
				"http://dev.bukkit.org/server-mods/miscfun-colourfireworks-v1-01-tu/pages/info-for-plugin/");

		BufferedReader in = new BufferedReader(new InputStreamReader(
				craftiii4.openStream()));

		String inputLine;

		while ((inputLine = in.readLine()) != null) {

			if (inputLine.contains("Latest Version = ")) {

				String newinputLine = inputLine
						.replace(
								"<div class=\"content-box\"><div class=\"content-box-inner\"><p>Latest Version = \"",
								"").replace("\"</p>", "").replace(" ", "");

				String version = plugin.getDescription().getVersion();

				if (version.equals(newinputLine)) {
					// player.sendMessage("[ColourFireWorks] You are running the latest version!");
					colourfireworks.latestversion = true;
				} else {
					player.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD
							+ "Colour" + ChatColor.RED + "FireWorks"
							+ ChatColor.AQUA + "]" + ChatColor.GREEN
							+ " A new version is out " + ChatColor.AQUA + "-"
							+ ChatColor.GRAY + " v" + ChatColor.LIGHT_PURPLE
							+ newinputLine);
					latestversion = newinputLine;
					colourfireworks.latestversion = false;
				}

			}

			if (inputLine.contains("Send Update Message = ")) {

				String newinputLine = inputLine.replace(
						"<p>Send Update Message = \"", "")
						.replace("\"</p>", "");

				if (newinputLine.equals("true")) {
					sendupdatemessage = true;
				}
				if (newinputLine.equals("false")) {
					sendupdatemessage = false;
				}
			}

			if (inputLine.contains("What is Update Message = ")) {

				if (sendupdatemessage == true) {
					
					if (colourfireworks.latestversion == false) {

					String newinputLine = inputLine
							.replace("<p>What is Update Message = \"", "")
							.replace("\"</p>", "")
							.replace("{name}", player.getName())
							.replace("{black}", "§0")
							.replace("{darkblue}", "§1")
							.replace("{darkgreen}", "§2")
							.replace("{darkaqua}", "§3")
							.replace("{darkred}", "§4")
							.replace("{darkpurple}", "§5")
							.replace("{gold}", "§6").replace("{gray}", "§7")
							.replace("{darkgray}", "§8")
							.replace("{blue}", "§9").replace("{green}", "§a")
							.replace("{aqua}", "§b").replace("{red}", "§c")
							.replace("{lightpurple}", "§d")
							.replace("{yellow}", "§e").replace("{white}", "§f")
							.replace("{magic}", "§k").replace("{bold}", "§l")
							.replace("{strikethrough}", "§m")
							.replace("{underline}", "§n")
							.replace("{italic}", "§o");
					player.sendMessage(newinputLine);
					}
				
				}

			}
			
			if (inputLine.contains("Send Other Message = ")) {

				String newinputLine = inputLine.replace(
						"<p>Send Other Message = \"", "")
						.replace("\"</p>", "");

				if (newinputLine.equals("true")) {
					sendupdatemessage = true;
				}
				if (newinputLine.equals("false")) {
					sendupdatemessage = false;
				}
			}
			
			if (inputLine.contains("What is Other Message = ")) {

				if (sendupdatemessage == true) {
					

					String newinputLine = inputLine
							.replace("<p>What is Other Message = \"", "")
							.replace("\"</p>", "")
							.replace("{name}", player.getName())
							.replace("{black}", "§0")
							.replace("{darkblue}", "§1")
							.replace("{darkgreen}", "§2")
							.replace("{darkaqua}", "§3")
							.replace("{darkred}", "§4")
							.replace("{darkpurple}", "§5")
							.replace("{gold}", "§6").replace("{gray}", "§7")
							.replace("{darkgray}", "§8")
							.replace("{blue}", "§9").replace("{green}", "§a")
							.replace("{aqua}", "§b").replace("{red}", "§c")
							.replace("{lightpurple}", "§d")
							.replace("{yellow}", "§e").replace("{white}", "§f")
							.replace("{magic}", "§k").replace("{bold}", "§l")
							.replace("{strikethrough}", "§m")
							.replace("{underline}", "§n")
							.replace("{italic}", "§o");
					player.sendMessage(newinputLine);
					
				
				}

			}

			// String newinputLine = inputLine.replace("<p>", "")
			// .replace("</p>", "").replace("&nbsp;", "");

			// Latest Version =

			// if (!newinputLine.contains("2.0.1")) {

			// System.out.println("[ColourFireWorks] V" + newinputLine
			// + " is out!");
			// colourfireworks.latestversion = false;
			// latestversion = newinputLine;
			// } else {
			// System.out
			// .println("[ColourFireWorks] You are running the latest version!");
			// colourfireworks.latestversion = true;
			// }
		}

		in.close();
	}

	// public static void main2() throws Exception {

	// URL craftiii4 = new URL(
	// "http://www.craftiii4.co.uk/eng/colourfireworks/version");
	// BufferedReader in = new BufferedReader(new InputStreamReader(
	// craftiii4.openStream()));

	// String inputLine;
	// while ((inputLine = in.readLine()) != null) {
	// String newinputLine = inputLine.replace("<p>", "")
	// .replace("</p>", "").replace("&nbsp;", "");
	// if (!newinputLine.contains("2.0.2")) {

	// colourfireworks.latestversion = false;
	// latestversion = newinputLine;
	// } else {
	// colourfireworks.latestversion = true;
	// }
	// }

	// in.close();
	// }

}
