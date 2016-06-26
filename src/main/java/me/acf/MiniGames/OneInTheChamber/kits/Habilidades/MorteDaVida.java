package me.acf.MiniGames.OneInTheChamber.kits.Habilidades;

import me.acf.MiniGames.OneInTheChamber.kits.Kit;
import me.hub.MiniPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class MorteDaVida extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public MorteDaVida(JavaPlugin plugin) {
		super("MorteDaVida", plugin);
		// TODO Auto-generated constructor stub
	}
	
	
	  private float heal = 10.0F;
	  private float feed = 20.0F;

	@EventHandler
	 public void onPlayerKillerVida(PlayerDeathEvent e)
	 {
	    if ((e.getEntity().getKiller() instanceof Player))
	    {
	      Player p = e.getEntity();
	      Player k = p.getKiller();
		  if (Kit.verkit(k).contains("MorteDaVida"))
		    {
	        	  k.setHealth(k.getHealth() + this.heal);
		    }
	    }
	 }
	  
}
