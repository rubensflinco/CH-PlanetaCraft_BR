/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Fisherman extends MiniPlugin {

	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Fisherman(JavaPlugin plugin) {
		super("Kit Fisherman", plugin);
		// TODO Auto-generated constructor stub
	}

	  @EventHandler
	  public void onPlayerFish(PlayerFishEvent event)
	  {
	    Entity caught = event.getCaught();
	    Block block = event.getHook().getLocation().getBlock();
	    if ((caught != null) && (caught != block) && 
	      (Kit.PoderUsar(event.getPlayer(), "fisherman"))) {
	      caught.teleport(event.getPlayer().getLocation());
	    }
	  }
}
