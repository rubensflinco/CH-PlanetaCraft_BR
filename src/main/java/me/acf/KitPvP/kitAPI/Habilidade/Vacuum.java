/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;
import me.hub.recharge.Recharge;

/**
 * @author adriancf
 *
 */
public class Vacuum extends MiniPlugin {
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Vacuum(JavaPlugin plugin) {
		super("Kit Vacuum", plugin);
		// TODO Auto-generated constructor stub
	}
	
	
	  @EventHandler
	  public void onDeathGod(PlayerInteractEvent event)
	  {
		     final Player p = event.getPlayer();
		     if (Kit.PoderUsar(p, "vacuum")) {
	    	if (p.getItemInHand().getType() == Material.ENDER_PEARL) {
	    		event.setCancelled(true);
	    		p.updateInventory();
		        if (!Recharge.Instance.use(p, "vacuum", 16900L, true, false)) {
		               return;
		             }
	      for (Entity nearby : p.getNearbyEntities(15.0D, 9.0D, 15.0D))
	      {
	        Entity targetplayer = nearby;
	        if ((!(targetplayer instanceof Player)) && (!(targetplayer instanceof Item)) && (!(targetplayer instanceof Block)) && (!(targetplayer instanceof Entity))) {
	          return;
	        }
	        Location lc = targetplayer.getLocation();
	        Location to = p.getLocation();
	        
	        lc.setY(lc.getY() + 0.9D);
	        double g = -0.1D;
	        double d = to.distance(lc);
	        double t = d;
	        double v_x = (2.2D + 0.07000000000000001D * t) * (to.getX() - lc.getX()) / t;
	        double v_y = (1.0D + 0.07000000000000001D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
	        double v_z = (2.2D + 0.07000000000000001D * t) * (to.getZ() - lc.getZ()) / t;
	        Vector v = p.getVelocity();
	        v.setX(v_x);
	        v.setY(v_y);
	        v.setZ(v_z);
	        targetplayer.setVelocity(v);
	      }
	    	}
	    
	  }
	 }
}
