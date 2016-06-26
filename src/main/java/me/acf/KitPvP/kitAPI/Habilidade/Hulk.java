/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;
import me.hub.recharge.Recharge;

/**
 * @author adriancf
 *
 */
public class Hulk extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Hulk(JavaPlugin plugin) {
		super("Kit Hulk", plugin);
		// TODO Auto-generated constructor stub
	}

	
	 @EventHandler
	  public void pegar(PlayerInteractEntityEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((e.getRightClicked() instanceof Player))
	    {
	      Player r = (Player)e.getRightClicked();
	          if (p.getItemInHand().getType() == Material.SADDLE)
	          {
	        	  if (Kit.PoderUsar(p, "hulk")) {
	        	  if (!Recharge.Instance.use(p, "hulk", 10900L, true, false)) {
	                  return;
	                }
	            e.setCancelled(true);
	            p.updateInventory();
	            p.setPassenger(r);
	        	  }
	      }
	    }
	  }
	 @EventHandler
	  public static void playerInteract(PlayerInteractEvent event)
	  {
	    if (!event.getAction().equals(Action.LEFT_CLICK_AIR)) {
	      return;
	    }
	    Player player = event.getPlayer();
	    if ((player.getPassenger() == null) || (!(player.getPassenger() instanceof Player))) {
	      return;
	    }
	    if (Kit.PoderUsar(player, "hulk")) {
	    Player pass = (Player)player.getPassenger();
	    player.eject();
	    pass.damage(0.0D, player);
	    if ((Kit.PoderUsar(pass, "anchor")))
	    {
		    pass.setVelocity(player.getLocation().getDirection().multiply(0.2D));
	    	return;
	    }
	    pass.setVelocity(player.getLocation().getDirection().multiply(2.5D));
	  }
	  }
}
