/**
 * 
 */
package me.acf.MiniGames.HungerGames.kits.Habilidades;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.MiniGames.HungerGames.kits.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Kangaroo extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Kangaroo(JavaPlugin plugin) {
		super("Kit Kangaroo", plugin);
		// TODO Auto-generated constructor stub
	}

	 ArrayList<Player> kangaroo = new ArrayList();
	 
	  @EventHandler
	  public void onInteract(PlayerInteractEvent event)
	  {
	    Player p = event.getPlayer();
	    if ((Kit.verkit(p).contains("Kangaroo")) && 
	      (p.getItemInHand().getType() == Material.FIREWORK))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
	        event.setCancelled(true);
	      }
	      if (!kangaroo.contains(p))
	      {
	        if (!p.isSneaking())
	        {
	          p.setFallDistance(-5.0F);
	          Vector vector = p.getEyeLocation().getDirection();
	          vector.multiply(0.6F);
	          vector.setY(1.2F);
	          p.setVelocity(vector);
	        }
	        else
	        {
	          p.setFallDistance(-5.0F);
	          Vector vector = p.getEyeLocation().getDirection();
	          vector.multiply(1.2F);
	          vector.setY(0.8D);
	          p.setVelocity(vector);
	        }
	        kangaroo.add(p);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onMove(PlayerMoveEvent event)
	  {
	    Player p = event.getPlayer();
	    if ((Kit.verkit(p).contains("Kangaroo")) && 
	      (this.kangaroo.contains(p)))
	    {
	      Block b = p.getLocation().getBlock();
	      if ((b.getType() != Material.AIR) || 
	        (b.getRelative(BlockFace.DOWN).getType() != Material.AIR))
	      {
	        this.kangaroo.remove(p);
	        
	        return;
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onDamage(EntityDamageEvent event)
	  {
	    Entity e = event.getEntity();
	    if ((e instanceof Player))
	    {
	      Player player = (Player)e;
	      if (((event.getEntity() instanceof Player)) && 
	        (event.getCause() == EntityDamageEvent.DamageCause.FALL)){
	        
	    	  if (kangaroo.contains(player))
	    	  {
	    		  event.setCancelled(true);
	    	  }
	      }
	    }
	  }

}