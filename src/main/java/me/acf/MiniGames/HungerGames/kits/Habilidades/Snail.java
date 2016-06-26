/**
 * 
 */
package me.acf.MiniGames.HungerGames.kits.Habilidades;

import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.acf.MiniGames.HungerGames.kits.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Snail extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Snail(JavaPlugin plugin) {
		super("Kit Viper", plugin);
		// TODO Auto-generated constructor stub
	}

	 @EventHandler
	  public void Snail(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof LivingEntity)))
	    {
	      LivingEntity entity = (LivingEntity)e.getEntity();
	      Player p = (Player)e.getDamager();
	      if (Kit.verkit(p).contains("Snail"))
	      {
	        Random r = new Random();
	        int percent = r.nextInt(100);
	        if (percent <= 33)
	        {
	        	if (entity.hasPotionEffect(PotionEffectType.SLOW))
	        	{
	        		entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1));
	        		return;
	        	}
	          entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 0));
	        }
	      }
	    }
	  }
}
