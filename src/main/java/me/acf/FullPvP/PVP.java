/**
 * 
 */
package me.acf.FullPvP;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.FullPvP.scoreboard.Scoreboard;
import me.acf.lobby.patentes.Patente;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;
import me.hub.Scoreboard.ScoreboardAPI;
import me.hub.config.Config;
import me.site.account.Account;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class PVP extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public PVP(JavaPlugin plugin) {
		super("PVP - FP", plugin);
		// TODO Auto-generated constructor stub
	}


	@EventHandler
	public void Respawn(PlayerRespawnEvent event)
	{
		event.getPlayer().teleport(Bukkit.getWorld("world").getSpawnLocation());
		event.getPlayer().getInventory().clear();
		UtilInv.save(event.getPlayer());
			   }
			
	
	@EventHandler
	public void Morte(final PlayerDeathEvent event)
	{
		final Player p = event.getEntity();
		try {
			p.getInventory().clear();
	     Conta.AddMorreu(p);
	     CombatLog.combat.remove(p);
	     CombatLog.combat.remove(p.getKiller());
		
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	     {
	       public void run()
	       {
		p.teleport(Bukkit.getWorld("world").getSpawnLocation());
		UtilInv.save(p);

		if ((event.getEntity().getKiller() instanceof Player))
	    {
			  final Player k = event.getEntity().getKiller();
				AddLogKill(p,k);
			     Scoreboard.CriarScoreboard(k);
			     Scoreboard.CriarScoreboard(p);
	    }
	       }
	     }, 10L);
	    event.setDeathMessage(null);
	}  catch (Exception e) {
		p.getInventory().clear();
		UtilInv.save(p);
		event.setDeathMessage(null);
	}
	}
	
	  public void AddLogKill(Player p, Player k)
	  {
		     Conta.AddMatou(k);
		     Conta.Reload(k);
		     Config.addn(p.getPlayer(), "fullpvp.morreu." + k.getName(), "0");
		     Config.addn(k, "fullpvp.matou." + p.getName(), "0");
		     int morreu = Integer.parseInt(Config.retornar(p, "fullpvp.morreu." + k.getName()))+1;
		     Config.Set(p.getPlayer(), "fullpvp.morreu." + k.getName(), "" + morreu);
		     int matou = Integer.parseInt(Config.retornar(k, "fullpvp.matou." + p.getName()))+1;
		     Config.Set(k.getPlayer(), "fullpvp.matou." + p.getName(), "" + matou);
		     if (k.getItemInHand().getItemMeta() == null)
		     {
		    	 p.sendMessage("§c§lPVP §7Você morreu para §e" + k.getName() + "§7 (§9" + morreu + "§7)");
			     k.sendMessage("§c§lPVP §7Você matou §e" + p.getName() + "§7 (§9" + matou + "§7)");
			     p.setGameMode(GameMode.ADVENTURE);
		    	 return;
		     }
		     p.sendMessage("§c§lPVP §7Você morreu para §e" + k.getName() + "§7 (§9" + morreu + "§7) usando §e" + k.getItemInHand().getItemMeta().getDisplayName());
		     k.sendMessage("§c§lPVP §7Você matou §e" + p.getName() + "§7 (§9" + matou + "§7) usando §e" + k.getItemInHand().getItemMeta().getDisplayName());
		     p.setGameMode(GameMode.ADVENTURE);
		   try {
		     AddCoins(k);
		     Scoreboard.CriarScoreboard(k);
		     Scoreboard.CriarScoreboard(p);
		   }
		   catch (Exception e) {

			p.sendMessage("§cNão foi possivel setar seu premio!");
			}
	  }
	  
	  
	  
	  
	  public void AddCoins(Player p)
	  {
		  int valor = 10;
		  Random random = new Random();
		  
		   if ((Account.getRank(p)).Has(p, Rank.VIP, false))
		   {			   if ((Account.getPatente(p)).Has(p, Patente.Ultra, false))
		   {
			    if (random.nextInt(50) < 5)
			    {
			    	p.sendMessage("§eVoce ganhou 1 chave.");
			    	Account.AddChave(p, 1);
			    	Account.UpdateAccount(p);
			    }
		   }
			   valor = valor*4;
			   if ((Account.getPatente(p)).Has(p, Patente.Ultra, false))
			   {
				    if (random.nextInt(50) < 5)
				    {
				    	p.sendMessage("§eVoce ganhou 1 chave.");
				    	Account.AddChave(p, 1);
				    	Account.UpdateAccount(p);
				    }
			   }
		   }
		   if ((Account.getPatente(p)).Has(p, Patente.Ultra, false))
		   {
			   valor = valor*2;
			   Account.AddExp(p, "10");
		   }
		     Account.AddCoins(p, valor);
	       p.sendMessage("§eVocê recebeu §6+" + valor + " planets");
		   Account.AddExp(p, "2");
	       ScoreboardAPI.remover(p,"Planets");
	       if (random.nextInt(500) < 5)
	       {
	   		Patente.UpPatende(p);
		    Account.UpdateAccount(p);
			ScoreboardAPI.remover(p, "Patente:");
	       }
		    if (random.nextInt(100) < 20)
	       {
		        p.sendMessage("§eVocê recebeu §6+10 cash");
		        Account.AddCash(p, 10);
		        Account.UpdateAccount(p);
			    ScoreboardAPI.remover(p,"Cash");
	       }
		    if (random.nextInt(200) < 5)
		    {
		    	p.sendMessage("§eVoce ganhou 1 chave.");
		    	Account.AddChave(p, 1);
		    	Account.UpdateAccount(p);
		    }
		    Scoreboard.CriarScoreboard(p);
	  }
}
