/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Berserker extends MiniPlugin {

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Berserker(JavaPlugin plugin) {
		super("Kit Berserker", plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	  public void forca(PlayerDeathEvent e)
	  {
	    if ((e.getEntity().getKiller() instanceof Player))
	    {
	      Player p = e.getEntity().getKiller();
	      if (Kit.PoderUsar(p, "berserker"))
	      {
	        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 0));
	        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 0));
	        p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1.0F, 1.0F);
	        return;
	      }
	    }
	  }
}
