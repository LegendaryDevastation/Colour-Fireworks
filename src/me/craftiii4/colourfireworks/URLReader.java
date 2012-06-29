package me.craftiii4.colourfireworks;

import java.net.*;
import java.io.*;

public class URLReader {

	public static String latestversion = null;

	public static void main() throws Exception {
		
		URL craftiii4 = new URL(
				"http://www.craftiii4.co.uk/eng/colourfireworks/version");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				craftiii4.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			String newinputLine = inputLine.replace("<p>", "")
					.replace("</p>", "").replace("&nbsp;", "");
			if (!newinputLine.contains("2.0.0")) {
				System.out.println("[ColourFireWorks] V" + newinputLine
						+ " is out!");
				colourfireworks.latestversion = false;
				latestversion = newinputLine;
			} else {
				System.out
						.println("[ColourFireWorks] You are running the latest version!");
				colourfireworks.latestversion = true;
			}
		}

		in.close();
	}
	
	public static void main2() throws Exception {

		URL craftiii4 = new URL(
				"http://www.craftiii4.co.uk/eng/colourfireworks/version");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				craftiii4.openStream()));
		

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			String newinputLine = inputLine.replace("<p>", "")
					.replace("</p>", "").replace("&nbsp;", "");
			if (!newinputLine.contains("2.0.0")) {
				
				colourfireworks.latestversion = false;
				latestversion = newinputLine;
			} else {
				colourfireworks.latestversion = true;
			}
		}

		in.close();
	}

}
    
