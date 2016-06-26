/**
 * 
 */
package me.acf.MiniGames.HungerGames.kits.Habilidades;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.acf.MiniGames.HungerGames.kits.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Frosty extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Frosty(JavaPlugin plugin) {
		super("Kit Frosty", plugin);
		// TODO Auto-generated constructor stub
	}

	
	  @EventHandler
	  public void frosty(PlayerMoveEvent e)
	  {
	    Player p = e.getPlayer();
	    if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SNOW_BLOCK) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.PACKED_ICE)|| (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.ICE)) )
	    {
	    	if (Kit.verkit(p).contains("Frosty")) {
	  	      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
		      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
	    	}
	    }
	  }
	  
}
