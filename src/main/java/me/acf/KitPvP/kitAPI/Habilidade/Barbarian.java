/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import java.util.HashMap;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Barbarian extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Barbarian(JavaPlugin plugin) {
		super("Kit Barbarian", plugin);
		// TODO Auto-generated constructor stub
	}
	
	HashMap<Player, Integer> barbarian = new HashMap<>();
	
	  @EventHandler
	  public void onKill(PlayerDeathEvent e)
	  {
	    if ((e.getEntity().getKiller() instanceof Player))
	    {
		      Player k = e.getEntity().getKiller();
	    	if (Kit.PoderUsar(k, "barbarian")) {
	      if (!barbarian.containsKey(k))
	      {
	    	  barbarian.put(k, 1);
	      }
	      else
	      {
	    	  barbarian.put(k, barbarian.get(k)+1); 
	      }
	      if (k.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL))
          {
	      k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
          if (barbarian.get(k) <= 5)
	      k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, barbarian.get(k));
         
          }
	      else
	      {
	    	  k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, barbarian.get(k)); 
	      }
	    }
	    }
	  }
}
