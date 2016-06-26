/**
 * 
 */
package me.acf.FullPvP.loja;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.acf.FormatText.Format;
import me.acf.FullPvP.FPConfig;
import me.acf.FullPvP.Teleport;
import me.site.account.Account;

/**
 * @author adriancf
 *
 */
public class LojaAPI {

	
	public static String GerarID(Location loc)
	{
		String id = "0";
		int x = (int) loc.getX();
		int y = (int) loc.getY();
		int z = (int) loc.getZ();
		id = loc.getWorld().getName()+x+y+z;
		return id;
	}
	  
	public static void UnixShop(ItemStack item, String valor)
	{
	      YamlConfiguration cfg = null;
		  File file = null;
		  file = new File("plugins/CHub/UserData/unixshop.yml");
		  if(!file.exists())
		  {
			  try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  cfg = YamlConfiguration.loadConfiguration(file);
		  cfg.set("shop." + valor + ".item", item);
      try {
			cfg.save(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    @SuppressWarnings("unchecked")
    public static void setoff(String valor,String p)  {
    	try {
    		if (p.contains("[Loja]"))
    		{
    			 YamlConfiguration cfg = null;
    			  File file = null;
    			  file = new File("plugins/CHub/UserData/unixshop.yml");
    			  if(!file.exists())
    			  {
    				  try {
    					file.createNewFile();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			  }
    			  cfg = YamlConfiguration.loadConfiguration(file);
    			  cfg.set("shop." + valor + ".item", null);
    			  return;
    		}
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("plugins/CHub/UserData/" + Account.getUuidOff(p).replace(" ", "").replace("ORIGINAL:", "").replace("PIRATA:", "")+ ".yml"));
        c.set("shop." + valor + ".item" , null);
        
    	}
    	
    	catch (Exception e) {
    	}
    	
    }
    
    @SuppressWarnings("unchecked")
    public static ItemStack restore(String valor)  {
    	try {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("plugins/CHub/UserData/unixshop.yml"));
        ItemStack item = c.getItemStack("shop." + valor + ".item");
        return item;
    	}
    	
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    @SuppressWarnings("unchecked")
    public static ItemStack restore(String valor,String p)  {
    	try {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("plugins/CHub/UserData/" + Account.getUuidOff(p).replace(" ", "").replace("ORIGINAL:", "").replace("PIRATA:", "")+ ".yml"));
        ItemStack item = c.getItemStack("shop." + valor + ".item");
        return item;
    	}
    	
    	catch (Exception e) {
    	}
    	return null;
    }
    
    public static void save(Player p, ItemStack item, String string) {
        
  	      YamlConfiguration cfg = null;
		  File file = null;
		  file = new File("plugins/CHub/UserData/" + Account.getUuidOff(p.getName()).replace(" ", "").replace("ORIGINAL:", "").replace("PIRATA:", "")+ ".yml");
		  cfg = YamlConfiguration.loadConfiguration(file);
		  
        cfg.set("shop." + string + ".item", item);
        try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
    
 
    public static void TeleportShop(String p, Player jogador)
    {
    	
    	   YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("plugins/CHub/UserData/" + Account.getUuidOff(p).replace(" ", "").replace("ORIGINAL:", "").replace("PIRATA:", "")+ ".yml"));
    		int x = Integer.parseInt(c.getString("fullpvp.loja.X"));
    		int y = Integer.parseInt(c.getString("fullpvp.loja.Y"));
    		int z = Integer.parseInt(c.getString("fullpvp.loja.Z"));
    		String mundo = c.getString("fullpvp.loja.Mundo");
    		Location loc = new Location(Bukkit.getWorld(mundo),x,y,z);
    		Teleport.TeleportTempo(loc,jogador);
  
    	}
    
    public static void TeleportLoja(String p, Player jogador)
    {
    	try {
    	   YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("plugins/CHub/UserData/" + Account.getUuidOff(p).replace(" ", "").replace("ORIGINAL:", "").replace("PIRATA:", "")+ ".yml"));
    		int x = Integer.parseInt(c.getString("fullpvp.loja.X"));
    		int y = Integer.parseInt(c.getString("fullpvp.loja.Y"));
    		int z = Integer.parseInt(c.getString("fullpvp.loja.Z"));
    		String mundo = c.getString("fullpvp.loja.Mundo");
    		Location loc = new Location(Bukkit.getWorld(mundo),x,y,z);
    		Teleport.TeleportTempo(loc,jogador);
    	} catch(Exception e)
    	{
    		Format.Erro("Este jogador não tem nenhuma loja " + p, jogador);
    	}
    	}
    
    public static boolean TemLoja(String p)
    {
    	try {
     	   YamlConfiguration c = YamlConfiguration.loadConfiguration(new File("plugins/CHub/UserData/" + Account.getUuidOff(p).replace(" ", "").replace("ORIGINAL:", "").replace("PIRATA:", "")+ ".yml"));
     		int x = Integer.parseInt(c.getString("fullpvp.loja.X"));
     		int y = Integer.parseInt(c.getString("fullpvp.loja.Y"));
     		int z = Integer.parseInt(c.getString("fullpvp.loja.Z"));
     		String mundo = c.getString("fullpvp.loja.Mundo");
     		Location loc = new Location(Bukkit.getWorld(mundo),x,y,z);
     		return true;
     	
    	} catch(Exception e)
     	{
     	}
    	return false;
    }
	public static void AddLoja(Player p, Location loc)
	{
		FPConfig.FP(p, "loja.X", "" + (int) loc.getX());
		FPConfig.FP(p, "loja.Y", "" + (int) loc.getY());
		FPConfig.FP(p, "loja.Z", "" + (int) loc.getZ());
		FPConfig.FP(p, "loja.Mundo", loc.getWorld().getName());
	}

	public static void RemoveLoja(Player p)
	{
		FPConfig.FP(p, "loja.X", null);
		FPConfig.FP(p, "loja.Y", null);
		FPConfig.FP(p, "loja.Z", null);
		FPConfig.FP(p, "loja.Mundo", null);
	}
    
    
    
}
