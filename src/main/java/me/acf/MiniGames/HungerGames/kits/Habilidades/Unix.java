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

import me.acf.MiniGames.HungerGames.kits.Kit;
import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Unix extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Unix(JavaPlugin plugin) {
		super("Kit Anchor", plugin);
		// TODO Auto-generated constructor stub
	}
	 @EventHandler
	  public void hitar(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof LivingEntity)))
	    {
	      LivingEntity entity = (LivingEntity)e.getEntity();
	      Player p = (Player)e.getDamager();
	      if (Kit.verkit(p).contains("Unix"))
	      {
	        Random r = new Random();
	        int percent = r.nextInt(200);
	        if (percent <= 20)
	        {
	        if (e.getEntity() instanceof Player)
	        {
	        	Player d = (Player)e.getEntity();
	        	e.getEntity().sendMessage("§cVocê recebeu o attack Unix..");
	        	e.getEntity().sendMessage("§c§oMelhor você fugir!");
	        	d.setHealth(d.getHealth() - 9.0D);
	        	
	        }
	        	 
	        }
	        if (percent <= 10)
	        {
	        	p.setHealth(p.getHealth() - 4.0D);
	        	e.getEntity().sendMessage("§cVocê recebeu um contra attack do Unix..");
	        }
	      }
	    }
	  }
}
