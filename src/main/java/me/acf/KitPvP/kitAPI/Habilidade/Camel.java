/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Camel extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Camel(JavaPlugin plugin) {
		super("Kit Camel", plugin);
		// TODO Auto-generated constructor stub
	}

	
	  @EventHandler
	  public void camel(PlayerMoveEvent e)
	  {
	    Player p = e.getPlayer();
	    if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE)))
	    {
	    	if (Kit.PoderUsar(p, "camel")) {
	      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
	    	}
	    }
	  }
	  
}
