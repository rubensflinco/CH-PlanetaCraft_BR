/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Fireman extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Fireman(JavaPlugin plugin) {
		super("Kit Fireman", plugin);
		// TODO Auto-generated constructor stub
	}

	  @EventHandler
	  public void damage(EntityDamageEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if ((Kit.PoderUsar(p, "fireman")) && (
	        (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
	        (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
	        (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK))) {
	        e.setCancelled(true);
	        p.setFireTicks(0);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void Fogo(EntityDamageByEntityEvent e)
	  {
	    if ((e.getDamager() instanceof Player))
	    {
	      Player p = (Player)e.getDamager();
	      if ((Kit.PoderUsar(p, "fireman")) && 
	        (p.getInventory().getItemInHand() != null)  && 
	        ((e.getEntity() instanceof LivingEntity)))
	      {
	        LivingEntity en = (LivingEntity)e.getEntity();
	        if (en.isDead()) {
	          return;
	        }
	        if (en.getFireTicks() > 1)
	        {
	        	en.setFireTicks(en.getFireTicks()+100);
	        	e.setDamage(e.getDamage()+1);
	        }
	        en.setFireTicks(100);
	      }
	    }
	  }

}
