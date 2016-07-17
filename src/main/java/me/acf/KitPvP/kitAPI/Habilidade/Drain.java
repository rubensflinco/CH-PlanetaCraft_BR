/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Material;
import org.bukkit.Sound;
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
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.recharge.Recharge;

/**
 * @author adriancf
 *
 */
public class Drain extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Drain(JavaPlugin plugin) {
		super("Kit Drain", plugin);
		// TODO Auto-generated constructor stub
	}
	
	  @EventHandler
	  public void ForceField(PlayerInteractEvent event)
	  {
	    if (event.getAction().name().contains("RIGHT"))
	    {
	      final Player p = event.getPlayer();
	      if ((Kit.PoderUsar(p, "drain")) &&  
	        (event.getItem() != null) && (event.getItem().getType() == Material.EYE_OF_ENDER))
	      {
	        event.setCancelled(true);
	 	   if (!Recharge.Instance.use(p, "drain", 46900L, true, false)) {
             return;
           }

	 	  final BukkitTask bc = new BukkitRunnable()
	   	    {
			 	  int i = 10;
		      @SuppressWarnings({ "deprecation", "unused" })
		      public void run()
	  	       {
		    	  i--;
			        for (Entity ent : p.getNearbyEntities(10.0D, 10.0D, 10.0D)) {
		                if ((ent instanceof Player))
		                {
		                   Player d = (Player)ent;
		                	if (p.getHealth() < 19) {
		                		if (Kit.PoderUsar(p, "drain")) {
		                   d.damage(3,p);
		                   p.setHealth(p.getHealth()+3);
		                   UtilSound.playSound(d, Sounds.AMBIENCE_CAVE, 1.0F, 1.0F);
		                		}
		                		}
		                	if (i < 0)
		                		this.cancel();
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
