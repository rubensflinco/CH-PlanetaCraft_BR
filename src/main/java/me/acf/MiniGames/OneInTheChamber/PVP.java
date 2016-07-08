package me.acf.MiniGames.OneInTheChamber;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.API.TeleportPlayer;
import me.acf.MiniGames.OneInTheChamber.Scoreboard.Scoreboard;
import me.acf.MiniGames.OneInTheChamber.kits.Kit;
import me.acf.MiniGames.Style.Utils.MGPVP;
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
	
	public static ArrayList<String> mortos = new ArrayList<String>();
	
	
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
		
	    Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
		      public void run() {
			   
			      Player p = event.getEntity();
		          
			      Conta.AddMorreu(p);
			      Conta.Reload(p);
			      ScoreboardAPI.remover(p);
			      Scoreboard.CriarScoreboard(p);
			      Scoreboard.AtualizarKill(p.getKiller().getPlayer());
			      mortos.add(p.getName());
			      TempoRenacer(p);
			      clearEffects(p);
			      p.setGameMode(GameMode.SPECTATOR);
			   	  MiniGamesMananger.Specter.remove(p);
			   	  MiniGamesMananger.Vivos.remove(p);
			   	  MiniGamesMananger.Vivos.add(p);
			   	  p.getKiller().getInventory().addItem(new ItemStack(Material.ARROW, 1));
		      }
		    }
		    , 5L);
	    
	} 
	
	 public static void clearEffects(Player p) {
		   for (PotionEffect effect : p.getActivePotionEffects())
		     p.removePotionEffect(effect.getType());
		 }
	  
	  
	public static void TempoRenacer(final Player p)
	 {
		 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	     {
	       public void run()
	       {
	    	   if (mortos.contains(p.getName())) {
					mortos.remove(p.getName());
			   		MiniGamesMananger.Specter.remove(p);
			   		MiniGamesMananger.Vivos.remove(p);
			   		MiniGamesMananger.Vivos.add(p);
					clearEffects(p);
			        p.setGameMode(GameMode.ADVENTURE);
			        p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Você voltou dos mortos !");
			        Kit.GiveKit(p);
	    	        TeleportPlayer.JogadorTeleporteRandoOITC(p);
	    	   }
	    	   else
	    	   {
	    		   clearEffects(p); 
	    	   }
	       }
	     }, 200L);
	 }


	  

	    

}
