/**
 * 
 */
package me.acf.lobby.extend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilHolo;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

/**
 * @author adriancf
 *
 */
public class Top3 extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Top3(JavaPlugin plugin) {
		super("Top3", plugin);
		Loader(Main.site+ "/API/MG/FP.php?modo=TOP-kdr&quantidade=3","fp");
		Loader(Main.site+ "/API/MG/KP.php?modo=TOP-kdr&quantidade=3","kp");
		Loader(Main.site+ "/API/MG/SB.php?modo=TOP-kdr&quantidade=3","sb");
		Loader(Main.site+ "/API/MG/SW.php?modo=TOP-kdr&quantidade=3","sw");
		Loader(Main.site+ "/API/MG/HG.php?modo=TOP-kdr&quantidade=3","hg");
		Loader(Main.site+ "/API/MG/OITC.php?modo=TOP-kdr&quantidade=3","oitc");
		LoaderIndividual(Main.site+ "/API/MG/KP.php?modo=TOP-kdr&quantidade=100","kp");
		LoaderIndividual(Main.site+ "/API/MG/FP.php?modo=TOP-kdr&quantidade=100","fp");
		LoaderIndividual(Main.site+ "/API/MG/SB.php?modo=TOP-kdr&quantidade=100","sb");
		LoaderIndividual(Main.site+ "/API/MG/SW.php?modo=TOP-kdr&quantidade=100","sw");
		LoaderIndividual(Main.site+ "/API/MG/HG.php?modo=TOP-kdr&quantidade=100","hg");
		LoaderIndividual(Main.site+ "/API/MG/OITC.php?modo=TOP-kdr&quantidade=100","oitc");
	}
	
	public static ArrayList<NPC> entitys = new ArrayList<NPC>();
	public static HashMap<String,String> rank_fp = new HashMap<>();
	public static HashMap<String,String> rank_kp = new HashMap<>();	
	public static HashMap<String,String> rank_sb = new HashMap<>();
	public static HashMap<String,String> rank_sw = new HashMap<>();
	public static HashMap<String,String> rank_hg = new HashMap<>();
	public static HashMap<String,String> rank_oitc = new HashMap<>();
	public static int top_fp = 0;
	public static int top_kp = 0;
	public static int top_sb = 0;
	public static int top_sw = 0;
	public static int top_hg = 0;
	public static int top_oitc = 0;
	public static int topindividualfp = 0;
	public static int topindividualkp = 0;	
	public static int topindividualsb = 0;	
	public static int topindividualsw = 0;	
	public static int topindividualhg = 0;	
	public static int topindividualoitc = 0;	
	
	
	@EventHandler
	public void Join(final PlayerJoinEvent event)
	{

	}
	
	public void LoaderIndividual(String url, String modo)
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
	            if (modo.equals("fp"))
	            {
	            	topindividualfp++;
	            	rank_fp.put(inputLine, "" + topindividualfp+"º");
	            }
	            if (modo.equals("kp"))
	            {
	            	topindividualkp++;
	            	rank_kp.put(inputLine, "" + topindividualkp+"º");
	            }
	            if (modo.equals("sb"))
	            {
	            	topindividualsb++;
	            	rank_sb.put(inputLine, "" + topindividualsb+"º");
	            }
	            if (modo.equals("sw"))
	            {
	            	topindividualsw++;
	            	rank_sw.put(inputLine, "" + topindividualsw+"º");
	            }
	            if (modo.equals("hg"))
	            {
	            	topindividualhg++;
	            	rank_hg.put(inputLine, "" + topindividualhg+"º");
	            }
	            if (modo.equals("oitc"))
	            {
	            	topindividualoitc++;
	            	rank_oitc.put(inputLine, "" + topindividualoitc+"º");
	            }
	        }
	        reader.close();
	       
	      }
	      catch (IOException e)
	      {
              e.printStackTrace();
	      }
	}
	
	public void Loader(String url, String modo)
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
	            if (modo.equals("fp"))
	            {
	            	top_fp++;
	            	Top3FullPvP(inputLine);
	            }
	            if (modo.equals("kp"))
	            {
	            	top_kp++;
	            	Top3KitPvP(inputLine);
	            }
	            if (modo.equals("sb"))
	            {
	            	top_sb++;
	            	Top3SkyBlock(inputLine);
	            }
	            if (modo.equals("sw"))
	            {
	            	top_sw++;
	            	Top3SkyWars(inputLine);
	            }
	            if (modo.equals("hg"))
	            {
	            	top_hg++;
	            	Top3HungerGames(inputLine);
	            }
	            if (modo.equals("oitc"))
	            {
	            	top_oitc++;
	            	Top3OneInTheChamber(inputLine);
	            }
	        }
	        reader.close();
	       
	      }
	      catch (IOException e)
	      {
              e.printStackTrace();
	      }
	}
	
	
	public void Top3FullPvP(String nick)
	{
		if (top_fp == 1)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.560,172.50,-71.485,95,3));
		if (top_fp == 2)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.509,171.50,-72.607,86,2));
		if (top_fp == 3)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.492,171.50,-70.427,95,-4));
	}
	public void Top3KitPvP(String nick)
	{
		if (top_kp == 1)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.698,172,-78.498,89,10));
		if (top_kp == 2)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.662,171.50,-79.526,91,11));
		if (top_kp == 3)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.396,171.50,-77.469,92,0));
	}
	public void Top3SkyBlock(String nick)
	{
		if (top_sb == 1)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.698,172,-85.498,89,10));
		if (top_sb == 2)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.662,171.50,-86.526,91,11));
		if (top_sb == 3)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.396,171.50,-84.469,92,0));
	}
	public void Top3SkyWars(String nick)
	{
		if (top_sw == 1)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.698,172,-92.498,89,10));
		if (top_sw == 2)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.662,171.50,-93.526,91,11));
		if (top_sw == 3)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.396,171.50,-91.469,92,0));
	}
	public void Top3HungerGames(String nick)
	{
		if (top_hg == 1)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.698,172,-99.498,89,10));
		if (top_hg == 2)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.662,171.50,-100.526,91,11));
		if (top_hg == 3)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.396,171.50,-98.469,92,0));
	}
	public void Top3OneInTheChamber(String nick)
	{
		if (top_oitc == 1)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.698,172,-105.498,89,10));
		if (top_oitc == 2)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.662,171.50,-106.526,91,11));
		if (top_oitc == 3)
		SpawnEntity(nick,nick, new Location(Bukkit.getWorld("world"),161.396,171.50,-104.469,92,0));
	}
	
	public void SpawnEntity(String nome,String skin, Location loc)
	{
		NPCRegistry re = CitizensAPI.getNPCRegistry();
		NPC entity = re.createNPC(EntityType.PLAYER, nome);
        entity.setName(nome);
		entity.setProtected(true);
        entity.isFlyable();
        entity.data().set(NPC.PLAYER_SKIN_UUID_METADATA, skin);
        entity.despawn(DespawnReason.PENDING_RESPAWN);
		entity.spawn(loc);
        entitys.add(entity);
	
	}
	
}
