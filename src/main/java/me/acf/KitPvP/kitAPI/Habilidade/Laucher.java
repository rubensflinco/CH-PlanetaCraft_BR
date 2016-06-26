/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Laucher extends MiniPlugin {

	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Laucher(JavaPlugin plugin) {
		super("Kit Laucher", plugin);
		// TODO Auto-generated constructor stub
	}

	  @EventHandler
	  public void onPlayerFish(PlayerFishEvent event)
	  {
	    Entity caught = event.getCaught();
	    Block block = event.getHook().getLocation().getBlock();
	    if ((caught != null) && (caught != block) && 
	      (Kit.PoderUsar(event.getPlayer(), "laucher"))) {
	    	caught.setVelocity(new Vector(0, 2, 0));
	    }
	  }
}
