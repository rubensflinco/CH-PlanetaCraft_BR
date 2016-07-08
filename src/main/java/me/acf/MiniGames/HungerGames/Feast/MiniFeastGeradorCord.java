package me.acf.MiniGames.HungerGames.Feast;

import java.util.Random;

import me.hub.Main;

public class MiniFeastGeradorCord {

	private static int randomtask;
	
	public static void RandomCord()
	  {
	        Random r = new Random();
	        for (int PlanetaCraft8 = 1; PlanetaCraft8 <= 1; PlanetaCraft8++)
	        {
	          int PlanetaCraft81 = 1 + r.nextInt(5);
	          if (PlanetaCraft81 == 1)
	          {
	        	    Main.plugin.getConfig().set("MiniFeast.nome", "MiniFeast.schematic");
	        	    Main.plugin.getConfig().set("MiniFeast.cord.X", Integer.valueOf(31));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Z", Integer.valueOf(31));
	      	        Main.plugin.saveConfig();
	          }
	          else if (PlanetaCraft81 == 2)
	          {
	        	    Main.plugin.getConfig().set("MiniFeast.nome", "MiniFeast.schematic");
	        	    Main.plugin.getConfig().set("MiniFeast.cord.X", Integer.valueOf(-300));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Z", Integer.valueOf(400));
	      	        Main.plugin.saveConfig();
	          }
	          else if (PlanetaCraft81 == 3)
	          {
	        	    Main.plugin.getConfig().set("MiniFeast.nome", "MiniFeast.schematic");
	        	    Main.plugin.getConfig().set("MiniFeast.cord.X", Integer.valueOf(-1));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Z", Integer.valueOf(300));
	      	        Main.plugin.saveConfig();
	          }
	          else if (PlanetaCraft81 == 4)
	          {
	        	    Main.plugin.getConfig().set("MiniFeast.nome", "MiniFeast.schematic");
	        	    Main.plugin.getConfig().set("MiniFeast.cord.X", Integer.valueOf(200));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Z", Integer.valueOf(90));
	      	        Main.plugin.saveConfig();
	          }
	          else if (PlanetaCraft81 == 5)
	          {
	        	    Main.plugin.getConfig().set("MiniFeast.nome", "MiniFeast.schematic");
	        	    Main.plugin.getConfig().set("MiniFeast.cord.X", Integer.valueOf(100));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Y", Integer.valueOf(65));
	        	    Main.plugin.getConfig().set("MiniFeast.cord.Z", Integer.valueOf(-100));
	      	        Main.plugin.saveConfig();
	          }
	      }

	  }
	
	
}
