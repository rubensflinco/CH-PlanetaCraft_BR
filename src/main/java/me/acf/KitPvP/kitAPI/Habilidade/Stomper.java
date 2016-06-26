/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;
import me.hub.comandos.geral.Admin;

/**
 * @author adriancf
 *
 */
public class Stomper extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Stomper(JavaPlugin plugin) {
		super("Stomper", plugin);
		// TODO Auto-generated constructor stub
	}
	
	
	  @EventHandler(priority=EventPriority.HIGH)
	  public void Stomper(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getEntity();
	    if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
	    {
	    	if (Kit.PoderUsar(p, "stomper"))
	    	{
	    		e.setCancelled(true);
	            for (Entity ent : p.getNearbyEntities(6.0D, 2.0D, 6.0D)) {
	                if ((ent instanceof Player))
	                {
	                  Player plr = (Player)ent;
	                  if (e.getDamage() <= 4.0D)
	                  {
	                    e.setCancelled(true);
	                    return;
	                  }
	                  if ((plr.getGameMode() != GameMode.CREATIVE) || (!(Admin.admin.contains(plr)))) {
	                	  if (plr.isSneaking())
	                      {
	                		  plr.damage(6.0, p);
	                      }
	                	  else
	                	  plr.damage(e.getDamage(), p);
	                  
	                  }
	                }

	                	
	                }
	    	}
	    }
	  }

}
