/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.Main;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Anchor extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Anchor(JavaPlugin plugin) {
		super("Kit Anchor", plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler(priority=EventPriority.MONITOR)
	  public void Anchor(EntityDamageByEntityEvent e)
	  {
		
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    final Player p = (Player)e.getEntity();
	    if (e.getDamager() instanceof Arrow){
	    	p.setVelocity(new Vector());
		      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
		      {
		        public void run()
		        {
		          p.setVelocity(new Vector());
		        }
		      }, 1L);
	    }
	    
	    if (!(e.getDamager() instanceof Player)) {
	      return;
	    }
	    final Player a = (Player)e.getDamager();
	    if ((Kit.PoderUsar(a, "anchor")))
	    {
	    	 p.setVelocity(new Vector());
		      a.setVelocity(new Vector());
		      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
		      {
		        public void run()
		        {
		          p.setVelocity(new Vector());
		          a.setVelocity(new Vector()); 
		        }
		      }, 1L);
	    }
	    if ((Kit.PoderUsar(p, "anchor")))
	    {
	      p.setVelocity(new Vector());
	      a.setVelocity(new Vector());
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.setVelocity(new Vector());
	          a.setVelocity(new Vector()); 
	        }
	      }, 1L);
	    }
	  }
}
