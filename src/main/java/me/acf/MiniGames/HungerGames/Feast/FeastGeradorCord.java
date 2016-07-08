package me.acf.MiniGames.HungerGames.Feast;

import java.util.Random;

import me.hub.Main;

public class FeastGeradorCord {

	private static int randomtask;
	
	public static void RandomCord()
	  {
	        Random r = new Random();
	        for (int PlanetaCraft8 = 1; PlanetaCraft8 <= 1; PlanetaCraft8++)
	        {
	          int PlanetaCraft81 = 1 + r.nextInt(5);
	          if (PlanetaCraft81 == 1)
	          {
	        	    Main.plugin.getConfig().set("Feast.nome", "Feast.schematic");
	        	    Main.plugin.getConfig().set("Feast.cord.X", Integer.valueOf(31));
	        	    Main.plugin.getConfig().set("Feast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("Feast.cord.Z", Integer.valueOf(31));
	      	        Main.plugin.saveConfig();
	          }
	          else if (PlanetaCraft81 == 2)
	          {
	        	    Main.plugin.getConfig().set("Feast.nome", "Feast.schematic");
	        	    Main.plugin.getConfig().set("Feast.cord.X", Integer.valueOf(-342));
	        	    Main.plugin.getConfig().set("Feast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("Feast.cord.Z", Integer.valueOf(416));
	      	        Main.plugin.saveConfig();
	          }
	          else if (PlanetaCraft81 == 3)
	          {
	        	    Main.plugin.getConfig().set("Feast.nome", "Feast.schematic");
	        	    Main.plugin.getConfig().set("Feast.cord.X", Integer.valueOf(-4));
	        	    Main.plugin.getConfig().set("Feast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("Feast.cord.Z", Integer.valueOf(355));
	      	        Main.plugin.saveConfig();
	          }
	          else if (PlanetaCraft81 == 4)
	          {
	        	    Main.plugin.getConfig().set("Feast.nome", "Feast.schematic");
	        	    Main.plugin.getConfig().set("Feast.cord.X", Integer.valueOf(226));
	        	    Main.plugin.getConfig().set("Feast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("Feast.cord.Z", Integer.valueOf(97));
	      	        Main.plugin.saveConfig();
	          }
	          else if (PlanetaCraft81 == 5)
	          {
	        	    Main.plugin.getConfig().set("Feast.nome", "Feast.schematic");
	        	    Main.plugin.getConfig().set("Feast.cord.X", Integer.valueOf(112));
	        	    Main.plugin.getConfig().set("Feast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("Feast.cord.Z", Integer.valueOf(-145));
	      	        Main.plugin.saveConfig();
	          }
	        }
	      

	  }
	
	
}
