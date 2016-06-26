/**
 * 
 */
package me.acf.FullPvP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilNumber;

/**
 * @author adriancf
 *
 */
public class Baltop extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Baltop(JavaPlugin plugin) {
		super("Top3", plugin);
		Loader(Main.site+ "/API/MG/FP.php?modo=TOP-dinheiro&quantidade=10");
		LoaderIndividual(Main.site+ "/API/MG/FP.php?modo=TOP-dinheiro&quantidade=500");
	}
	
	public static HashMap<String,String> rank = new HashMap<>();
	public static HashMap<Integer,String> top10 = new HashMap<>();
	public static HashMap<String,String> Grana = new HashMap<>();
	public static int top = 0;
	public static int topindividual = 0;
	
	public void LoaderIndividual(String url)
	{
		 URL host = null;
	     String texto = "{'ERRO':'NADA'}";
	      try
	      {
	        host = new URL(url);
	       
	      }
	      catch (MalformedURLException e1)
	      {
	    	   e1.printStackTrace();
	      }
	      URLConnection connection = null;
	      try
	      {
	        connection = host.openConnection();
	   
	        BufferedReader reader = null;
	     
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	         
	        String inputLine;
	        while ((inputLine = reader.readLine()) != null)
	        {
	            
	            	topindividual++;
	            	rank.put(inputLine, "" + topindividual+"º");
	            
	        }
	        reader.close();
	       
	      }
	      catch (IOException e)
	      {
              e.printStackTrace();
	      }
	}
	
	public static void MostrarTOP(Player p)
	{
		p.sendMessage("§f§lOs §a§l10 §f§lmais ricos do Full-PvP");
		for (int i = 0; i <= 10; i++)
		{
			if (i >= 1)
			p.sendMessage("§b§l" + i +"º §a§l" + top10.get(i) + " - §6§l " + UtilNumber.getNumber(Grana.get(top10.get(i)) ));
		}
		p.sendMessage("§f");
		if (rank.containsKey(p.getName()))
		p.sendMessage("§f§lVocê esta em §6§l " + rank.get(p.getName()) + "§f§l no top.");
		else
			p.sendMessage("§f§lVocê esta em §6§l+500");
	}
	
	public void Loader(String url)
	{
		 URL host = null;
	     String texto = "{'ERRO':'NADA'}";
	      try
	      {
	        host = new URL(url);
	       
	      }
	      catch (MalformedURLException e1)
	      {
	    	   e1.printStackTrace();
	      }
	      URLConnection connection = null;
	      try
	      {
	        connection = host.openConnection();
	   
	        BufferedReader reader = null;
	     
	        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	         
	        String inputLine;
	        while ((inputLine = reader.readLine()) != null)
	        {
	         
	            	top++;
	               top10.put(top, inputLine);
	               Grana.put(inputLine, Conta.MostrarDinheiroOFF(inputLine));
	        }
	        reader.close();
	       
	      }
	      catch (IOException e)
	      {
              e.printStackTrace();
	      }
	}
	

	
}
