/**
 * 
 */
package me.acf.MiniGames.HungerGames.kits.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.MiniGames.HungerGames.kits.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Poseidon extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Poseidon(JavaPlugin plugin) {
		super("Kit Poseidon", plugin);
		// TODO Auto-generated constructor stub
	}
	
	
	 @EventHandler
	  public void hitar(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof LivingEntity)))
	    {
	      LivingEntity entity = (LivingEntity)e.getEntity();
	      Player p = (Player)e.getDamager();
		   if ((p.getLocation().getBlock().getType() == Material.WATER) || (p.getLocation().getBlock().getType() == Material.STATIONARY_WATER))
	 	      {
	      if (Kit.verkit(p).contains("Poseidon"))
	    		   e.setDamage(e.getDamage()+2);    
	      }
	    }
	  }
}
