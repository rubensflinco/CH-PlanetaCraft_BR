/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.recharge.Recharge;

/**
 * @author adriancf
 *
 */
public class ForceField extends MiniPlugin {

	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public ForceField(JavaPlugin plugin) {
		super("Kit ForceField", plugin);
		// TODO Auto-generated constructor stub
	}

	
	  @EventHandler
	  public void ForceField(PlayerInteractEvent event)
	  {
	    if (event.getAction().name().contains("RIGHT"))
	    {
	      final Player p = event.getPlayer();
	      if ((Kit.PoderUsar(p, "forcefield")) &&  
	        (event.getItem() != null) && (event.getItem().getType() == Material.IRON_FENCE))
	      {
	        event.setCancelled(true);
	 	   if (!Recharge.Instance.use(p, "forcefield", 46900L, true, false)) {
               return;
             }

	 	  final BukkitTask bc = new BukkitRunnable()
	   	    {
			 	  int i = 20;
		      @SuppressWarnings({ "deprecation", "unused" })
		      public void run()
	  	       {
		    	  i -= 1;
		    	  if (i < 0)
		    	  {
		    		  this.cancel();
		    	  }
			        for (Entity ent : p.getNearbyEntities(6.0D, 3.0D, 6.0D)) {
		                if ((ent instanceof Player))
		                {
		                if(Kit.PoderUsar(p, "forcefield")) {
		                   Player d = (Player)ent;
		                	d.damage(2,p);
		                	d.setVelocity(p.getLocation().getDirection().subtract(new Vector(0.02D, 0.0D, 0.03D)));
		                }
		                }
			        }
			        switch  (i)
			        {
			        case 0:
		    		  this.cancel();
		    	  }
	  	       }
		    }
		      .runTaskTimer(Main.plugin, 0L, 20L);
	        
	      }
	    }
	  }
}
