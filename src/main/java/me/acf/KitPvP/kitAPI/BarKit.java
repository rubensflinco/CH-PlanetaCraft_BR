/**
 * 
 */
package me.acf.KitPvP.kitAPI;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.acf.KitPvP.PVP;
import me.hub.API.Util.BarAPI;
import me.hub.comandos.geral.Admin;

/**
 * @author adriancf
 *
 */
public class BarKit {

	public static void BarKit(Player p)
	{
     if (!Kit.arena.contains(p))
    	 return;
		for (Entity r : p.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
            if ((r instanceof Player))   {    
	          if (Admin.admin.contains(r))
	        	  return;
                BarAPI.setMessage(((Player) r).getPlayer(), "§f§o" + p.getName() + " - " + Kit.verkit(p) ,1);
            	
            }
        }
	}
}
