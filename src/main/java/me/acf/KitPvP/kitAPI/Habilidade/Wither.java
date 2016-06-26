/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Wither extends MiniPlugin {

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Wither(JavaPlugin plugin) {
		super("Kit Wither", plugin);
		// TODO Auto-generated constructor stub
	}

	  @EventHandler
	  public void onEntityDamage(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Player)) && 
	      ((e.getEntity() instanceof LivingEntity)))
	    {
	      LivingEntity entity = (LivingEntity)e.getEntity();
	      Player p = (Player)e.getDamager();
	      if (Kit.PoderUsar(p, "wither"))
	      {
	        Random rand = new Random();
	        int percent = rand.nextInt(100);
	        if (percent <= 33)
	        {
	          entity.addPotionEffect(new PotionEffect(
	            PotionEffectType.WITHER, 120, 0));
	          return;
	        }
	        return;
	      }
	      return;
	    }
	  }
}
