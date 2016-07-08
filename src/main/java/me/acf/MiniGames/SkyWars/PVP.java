package me.acf.MiniGames.SkyWars;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import me.acf.MiniGames.SkyWars.Scoreboard.Scoreboard;
import me.acf.MiniGames.Style.Utils.MGPVP;
import me.acf.MiniGames.Style.Utils.MGPremios;
import me.acf.MiniGames.Style.Utils.MGSpectator;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.Scoreboard.ScoreboardAPI;

/**
 * @author adriancf
 *
 */
public class PVP extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	
	public static List<Entity> arena = new ArrayList<>();
	
	public PVP(JavaPlugin plugin) {
		super("PVP", plugin);
		// TODO Auto-generated constructor stub
	}
	
	
	@EventHandler
	public void respawn(PlayerRespawnEvent e)
	{
		e.getPlayer().getInventory().setArmorContents(null);
		e.getPlayer().getInventory().clear();
		Scoreboard.CriarScoreboard(e.getPlayer());
		final Player p = e.getPlayer();
		p.playSound(p.getLocation(), Sound.SKELETON_DEATH, 10.0F, 2.0F);
	    p.setFireTicks(0);
	    Conta.Reload(p);
	    ScoreboardAPI.remover(p);
	    p.closeInventory();
	    Scoreboard.CriarScoreboard(p);
	}
	
	@EventHandler
	public void SetarMorto(final PlayerDeathEvent event)
	{
		MGPVP.Morreu(event);
		MGPremios.Givar(event.getEntity(), false);
		
	    Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
		      public void run() {
			   
			      Player p = event.getEntity();
		          
			      Conta.AddMorreu(p);
			      Conta.Reload(p);
			      ScoreboardAPI.remover(p);
			      Scoreboard.CriarScoreboard(p);
			      MGSpectator.AddSpectator(p);
			      clearEffects(p); 
		      }
		    }
		    , 5L);
	    
	} 
	  
	  
	 public static void clearEffects(Player p) {
		   for (PotionEffect effect : p.getActivePotionEffects())
		     p.removePotionEffect(effect.getType());
		 }

	  
	  

	    

}
