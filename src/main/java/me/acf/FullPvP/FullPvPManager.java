/**
 * 
 */
package me.acf.FullPvP;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.PluginAwareness.Flags;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import me.acf.FormatText.Format;
import me.acf.FullPvP.Kits.Kits;
import me.acf.FullPvP.Mina.Mina;
import me.acf.FullPvP.VIP.AreaVIP;
import me.acf.FullPvP.comandos.dropinv;
import me.acf.FullPvP.loja.LojaManager;
import me.acf.FullPvP.scoreboard.Scoreboard;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.lobby.Lag.TPS;
import me.acf.lobby.patentes.Patente;
import me.antiHack.autoclick.Click;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilPlayer;
import me.hub.API.Util.UtilServer;
import me.hub.Admin.Admin;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.blood.Blood;
import me.hub.comandos.CriadorComandos;
import me.site.account.Account;
import me.site.account.AccountWeb;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class FullPvPManager extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	
	public static int Tempo = 500;
	public static int prox = 36000;
	
	public FullPvPManager(JavaPlugin plugin) {
		super("FullPvPManager", plugin);
		Entrar entra = new Entrar(plugin);
		Kits kit = new Kits(plugin);
		LojaManager loja = new LojaManager(plugin);
		AreaVIP areaVIP = new AreaVIP(plugin);
		Mina mina = new Mina(plugin);
		Blood blod = new Blood(plugin);
		PVP pvp = new PVP(plugin);
		Sair sair = new Sair(plugin);
		Baltop bal = new Baltop(plugin);
		
		new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.FullPvP.comandos");
	    new CriadorComandos().Ler_Comandos(Main.plugin, "me.security.registrar.comandos");
		 me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
		 
	   	  List<Entity> entities = Bukkit.getWorld("world").getEntities();
	   	  for (Entity ov : entities){
	   	  if (ov.getType() == EntityType.ENDERMITE)
	   			  ov.remove();
	         }
		  	  
			MiniGamesMananger.PlanetsWEB(EntityType.ENDERMITE, "§fTecnologia §7§lPlanets§1§lWEB", new Location(Bukkit.getWorld("world"),-4,104,-12));
	}
	

	  @EventHandler
	  public void Teleport(PlayerTeleportEvent event)
	  {
		  if (CombatLog.EstaEmCombat(event.getPlayer()))
		  {
			  event.setCancelled(true);
		  }
	  }
	
	  @EventHandler
	  public void Comandos(PlayerCommandPreprocessEvent event) {
		  if (CombatLog.EstaEmCombat(event.getPlayer()))
		  {
			Format.Erro("Você esta em pvp com o §a" + CombatLog.combat.get(event.getPlayer()).getName(), event.getPlayer());
			  return;
		  }
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
	    public void Evento_1(Atualizar event)  {
	      if (event.getType() != ModosUpdate.MIN_16) {
	        return;
	      }
	      for (Player p : UtilServer.Jogadores())
	      {
	    	  if (AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=ADD-dinheiro&nick=" + p.getName() + "&quantidade=100","OK").contains("OK"))
	    	  {
	    		  
	    	  }
	      }
	  }

	  @EventHandler
	    public void Evento(Atualizar event)  {
	      if (event.getType() != ModosUpdate.MIN_08) {
	        return;
	      }
	      Random r = new Random();
    	  List<Entity> entities = Bukkit.getWorld("world").getEntities();
    	  for (Entity ov : entities){
    	  if (ov.getType() == EntityType.ARROW)
    		 ov.remove();
    	  }
	      for (Player p : UtilServer.Jogadores())
	      {
	    	  UtilInv.save(p);
	      }
	  }
	  
	  
	    @EventHandler
	    public void EventoDROPER(Atualizar event)  {
	      if (event.getType() != ModosUpdate.SEC) {
	        return;
	      }
	      Tempo--;
           if (Tempo < 0)
           {
        	   dropinv.Droper();
        	   Tempo = prox;
        	   prox += 500;
        	   Calendar calendario = new GregorianCalendar();
        	   int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);  
        	   if (pesquisarDiaSemana(diaSemana).equals("Sabado"))
        	   {
        		   Tempo = 9200;
        	   }
           }
	    }
	    @EventHandler
	    public void Utils(Atualizar event)  {
	      if (event.getType() != ModosUpdate.FAST) {
	        return;
	      }

	      new TPS();

	      Scoreboard.UpdateScoreboard();
	      
	      Bukkit.getWorld("world").setThunderDuration(0);
	      Bukkit.getWorld("world").setThundering(false);
	      Bukkit.getWorld("world").setWeatherDuration(0);
	      Bukkit.getWorld("world").setStorm(false);
	      Admin.SumirStaff();
	    
		  for (Player p : UtilServer.Jogadores())
		  {
			  if (CombatLog.EstaEmCombat(p))
			  {
				  me.hub.API.Chat.ActionBar(p, "§f§lVOCÊ ESTA EM PVP");
			  }
			  if (UtilPlayer.Ping(p) > 800)
			  {
				  me.hub.API.Chat.ActionBar(p, "§f§lVOCÊ ESTA COM §c§lLAG §f§lSEU PING É DE §6§l" + UtilPlayer.Ping(p) + " / 1500");
				  
			  }
			  if (UtilPlayer.Ping(p) > 1500)
			  {
				  p.kickPlayer("§c§lEXTREMO LAG\n§f§lMS: §a§l"+ UtilPlayer.Ping(p));
			  }
				 if (p.getInventory().firstEmpty() == -1) {
					  me.hub.API.Chat.ActionBar(p, "§f§lSEU INVENTARIO ESTA LOTADO!");
					   p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
				 }
			  
		  
		  }
	    	 
	    }
		   @EventHandler(priority=EventPriority.HIGH)
		   public void SemDano(EntityDamageEvent event) {
			     if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
				       event.setCancelled(true);
			           event.getEntity().teleport(Bukkit.getWorld("world").getSpawnLocation());
			           if ((event.getEntity() instanceof Player))
					    {
				        	 Player p = (Player)event.getEntity();
				        	 p.setBedSpawnLocation(Bukkit.getWorld("world").getSpawnLocation());
					    }
			     }
		   }
	    @EventHandler(priority=EventPriority.MONITOR)
		  public void Dano(EntityDamageByEntityEvent event)
		  {
		    if ((event.getDamager() instanceof Player))
		    {
		        Player jogador = (Player)event.getDamager();

		      if ((event.getEntity() instanceof Player))
			    {
		        	 Player p = (Player)event.getEntity();
		               if (areaPvP(p))
		        		 CombatLog.AddCombat(jogador, p);
		        	 
		  		   if ((Account.getRank(jogador)).Has(jogador, Rank.VIPM, false))
				   {
		  				if ((Account.getPatente(jogador)).Has(jogador, Patente.unix, false))
		 			   {
		  					Random r = new Random();
		  					if (r.nextInt(100) < 30)
		  					{
		  						event.setDamage(event.getDamage()*2);
		  					}
		  				   p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1));
		 			   }
		  				if ((Account.getPatente(jogador)).Has(jogador, Patente.Legendario, false))
			 			   {
		  					p.setFireTicks(50);
			 			   }
		  				if ((Account.getPatente(jogador)).Has(jogador, Patente.Ultra, false))
			 			   {
		  					jogador.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 1));
			 			   }
		  				if ((Account.getPatente(jogador)).Has(jogador, Patente.DeadKill, false))
			 			   {
		  					p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
			 			   }
		  				if ((Account.getPatente(jogador)).Has(p, Patente.Jotinha, false))
			 			   {
		  					p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 1));
			 			   }
				   }
			    }
		    }
		  }
	    
	    public static boolean areaPvP(Player p)
	    {
			for(ProtectedRegion r : WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation())) {
	            if ((r.getId().contains("pvp")) || (r.getId().contains("arena"))) {
	            	return true;
	            }
	        return false;
	      }
			if (p.getWorld().getName().equals("world"))
			{
				return false;
			}
	      return false;
	    }
	    
	    public String pesquisarDiaSemana(int _diaSemana)  
	    {  
	      String diaSemana = null;  
	    
	      switch (_diaSemana)  
	      {  
	    
	      case 1:  
	      {  
	        diaSemana = "Domingo";  
	        break;  
	      }  
	      case 2:  
	      {  
	        diaSemana = "Segunda";  
	        break;  
	      }  
	      case 3:  
	      {  
	        diaSemana = "Terça";  
	        break;  
	      }  
	      case 4:  
	      {  
	        diaSemana = "Quarta";  
	        break;  
	      }  
	      case 5:  
	      {  
	        diaSemana = "Quinta";  
	        break;  
	      }  
	      case 6:  
	      {  
	        diaSemana = "Sexta";  
	        break;  
	      }  
	      case 7:  
	      {  
	        diaSemana = "Sabado";  
	        break;  
	      }  
	    
	      }  
	      return diaSemana;  
	    
	    }  
}
