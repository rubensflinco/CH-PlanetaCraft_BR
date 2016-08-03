/**
 * 
 */
package me.acf.SkyBlock;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.acf.MiniGames.MiniGamesMananger;
import me.acf.lobby.Lag.TPS;
import me.antiHack.autoclick.Click;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilActionBar;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilPlayer;
import me.hub.API.Util.UtilServer;
import me.hub.Admin.Admin;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.comandos.CriadorComandos;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
/**
 * @author adriancf
 *
 */
public class SkyBlock extends MiniPlugin {

	public static Economy econ = null;
	
	/**
	 * @param moduleName
	 * @param plugin
	 */
	public SkyBlock(JavaPlugin plugin) {
		super("SkyBlockManager", plugin);
          Entrar entrar = new Entrar(plugin);
          me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
			 new CriadorComandos().Ler_Comandos(Main.plugin, "me.security.registrar.comandos");
          Sair sair = new Sair(plugin);
          PVP pvp = new PVP(plugin);
  		new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.SkyBlock.comandos");
  		
	   	  List<Entity> entities = Bukkit.getWorld("world").getEntities();
	   	  for (Entity ov : entities){
	   	  if (ov.getType() == EntityType.ENDERMITE)
	   			  ov.remove();
	         }
		  	  
			MiniGamesMananger.PlanetsWEB(EntityType.ENDERMITE, "§fTecnologia §7§lPlanets§1§lWEB", new Location(Bukkit.getWorld("world"),1002,108,1012));
	}
	
	

	  @EventHandler
	  public void Comandos(PlayerCommandPreprocessEvent event) {
	    if ((event.getMessage().toLowerCase().startsWith("/me")) || 
	      (event.getMessage().toLowerCase().startsWith("/bukkit")))
	    {
	      event.getPlayer().sendMessage("§e§lVocê não pode fazer isto..!");
	      event.setCancelled(true);
	    }
	    if (event.getMessage().toLowerCase().startsWith("/ping"))
	    {
	      event.getPlayer().sendMessage("§e§lPong..");
	      event.setCancelled(true);
	    }
	    if (event.getMessage().toLowerCase().startsWith("/pong"))
	    {
	      event.getPlayer().sendMessage("§e§lPing..");
	      event.setCancelled(true);
	    }
	    if (event.getMessage().toLowerCase().startsWith("/ms"))
	    {
	      event.getPlayer().sendMessage("§f§lMS §6§l" + UtilPlayer.Ping(event.getPlayer()));
	      event.setCancelled(true);
	    }
	    
	  }


	  @EventHandler
	    public void Evento(Atualizar event)  {
	      if (event.getType() != ModosUpdate.MIN_08) {
	        return;
	      }
	      Random r = new Random();
	      for (Player p : UtilServer.Jogadores())
	      {
	    	  UtilInv.save(p);
	      }
	  }
	  
	  
	    @EventHandler
	    public void Utils(Atualizar event)  {
	      if (event.getType() != ModosUpdate.FAST) {
	        return;
	      }

	      new TPS();
	      Click.Click.clear();
	      Scoreboard.UpdateScoreboard();
	      
	      Bukkit.getWorld("world").setThunderDuration(0);
	      Bukkit.getWorld("world").setThundering(false);
	      Bukkit.getWorld("world").setWeatherDuration(0);
	      Bukkit.getWorld("world").setStorm(false);
	      Admin.SumirStaff();
	    
		  for (Player p : UtilServer.Jogadores())
		  {
			  if (UtilPlayer.Ping(p) > 800)
			  {				  
				  UtilActionBar.ActionBar(p, "§f§lVOCÊ ESTA COM §c§lLAG §f§lSEU PING É DE §6§l" + UtilPlayer.Ping(p) + " / 1500");
				  
			  }
			  if (UtilPlayer.Ping(p) > 1500)
			  {
				  p.kickPlayer("§c§lEXTREMO LAG\n§f§lMS: §a§l"+ UtilPlayer.Ping(p));
			  }
				 if (p.getInventory().firstEmpty() == -1) {
					  UtilActionBar.ActionBar(p, "§f§lSEU INVENTARIO ESTA LOTADO!");
					   p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 2));
				 }
			  
		  
		  }
	    	 
	    }
		   @EventHandler(priority=EventPriority.HIGH)
		   public void SemDano(EntityDamageEvent event) {
			     if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
			    	 if (event.getEntity().getWorld().getName().equals("world")) {
				       event.setCancelled(true);
			           event.getEntity().teleport(Bukkit.getWorld("world").getSpawnLocation());
			     }
			     }
		   }
	   
}
