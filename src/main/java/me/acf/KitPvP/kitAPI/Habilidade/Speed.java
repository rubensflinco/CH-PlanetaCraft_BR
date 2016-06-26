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
public class Speed extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Speed(JavaPlugin plugin) {
		super("Kit Speed", plugin);
		// TODO Auto-generated constructor stub
	}

	 @EventHandler
	  public void Snail(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof LivingEntity)))
	    {
	      LivingEntity entity = (LivingEntity)e.getEntity();
	      Player p = (Player)e.getDamager();
	      if (Kit.PoderUsar(p, "speed"))
	      {
	        Random r = new Random();
	        int percent = r.nextInt(100);
	        if (percent <= 33)
	        {
	        	if (entity.hasPotionEffect(PotionEffectType.SLOW_DIGGING))
	        	{
	        		entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 80, 1));
	        		return;
	        	}
	         p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 0));
	         entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 60, 0));
	        }
	      }
	    }
	  }
}
