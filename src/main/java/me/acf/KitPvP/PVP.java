/**
 * 
 */
package me.acf.KitPvP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.acf.KitPvP.kitAPI.Kit;
import me.acf.KitPvP.scoreboard.Scoreboard;
import me.acf.lobby.patentes.Patente;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Enchant;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
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
	
	public static HashMap<Player,Integer> ks = new HashMap<>();

	
	public PVP(JavaPlugin plugin) {
		super("PVP", plugin);
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void Item(ItemSpawnEvent event)
	{
		event.setCancelled(true);
	}
	
	@EventHandler
	public void respawn(PlayerRespawnEvent e)
	{
		e.getPlayer().getInventory().setArmorContents(null);
		e.getPlayer().getInventory().clear();
		Entrar.Give(e.getPlayer());
		Scoreboard.CriarScoreboard(e.getPlayer());
		final Player p = e.getPlayer();
		UtilSound.playSound(p, Sounds.SKELETON_DEATH, 10.0F, 2.0F);
	    p.setFireTicks(0);
	    Conta.Reload(p);
	    ScoreboardAPI.remover(p);
	    p.closeInventory();
	    Scoreboard.CriarScoreboard(p);
	    Kit.arena.remove(p);
		p.teleport(Bukkit.getWorld("world").getSpawnLocation());
	}
	
	  @EventHandler
	  public void Matar(final PlayerDeathEvent e)
	  {
			final Player p = e.getEntity();
		  try {
		e.setDeathMessage(null);
		UtilSound.playSound(p, Sounds.SKELETON_DEATH, 10.0F, 2.0F);
		p.getInventory().setArmorContents(null);
		p.getInventory().clear();
		Entrar.Give(p);
		for (Player jogadores : UtilServer.Jogadores())
		{
			jogadores.showPlayer(p);
		}
	    p.setFireTicks(0);
	    Conta.AddMorreu(p);
	    Conta.Reload(p);
	    ScoreboardAPI.remover(p);
	    p.closeInventory();
	    Scoreboard.CriarScoreboard(p);
	    Kit.arena.remove(p);
		 for (Player all : UtilServer.Jogadores())
		 {
			 all.hidePlayer(p);
		 }
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	    {
	    public void run()
	    {
	  	Entrar.Give(p);
	  	Kit.AddKit(p, "§9Nenhum ");
		if ((e.getEntity().getKiller() instanceof Player))
	    {
	    final Player k = e.getEntity().getKiller();
	    AddLogKill(p,k);
	    }
	    }
	    }, 10L);
		}  catch (Exception e5) {
			UtilSound.playSound(p, Sounds.SKELETON_DEATH, 10.0F, 2.0F);
				p.getInventory().setArmorContents(null);
				p.getInventory().clear();
				Entrar.Give(p);
			    p.setFireTicks(0);
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
			     {
			       public void run()
			       {
				p.teleport(Bukkit.getWorld("world").getSpawnLocation());
			    Kit.arena.remove(p);
				 for (Player all : UtilServer.Jogadores())
				 {
					 all.hidePlayer(p);
				 }
			       }
			       }, 10L);
			    Conta.AddMorreu(p);
			    Conta.Reload(p);
			    p.closeInventory();
			    ScoreboardAPI.remover(p);
			    Scoreboard.CriarScoreboard(p);
		  }
	  }
	  
	  public void AddLogKill(Player p, Player k)
	  {
		     Conta.AddMatou(k);
		     Conta.Reload(k);
		     ScoreboardAPI.remover(k);
		     Config.addn(p.getPlayer(), "kitpvp.morreu." + k.getName(), "0");
		     Config.addn(k, "kitpvp.matou." + p.getName(), "0");
		     int morreu = Integer.parseInt(Config.retornar(p, "kitpvp.morreu." + k.getName()))+1;
		     Config.Set(p.getPlayer(), "kitpvp.morreu." + k.getName(), "" + morreu);
		     int matou = Integer.parseInt(Config.retornar(k, "kitpvp.matou." + p.getName()))+1;
		     Config.Set(k.getPlayer(), "kitpvp.matou." + p.getName(), "" + matou);
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
		     
		   }
		   catch (Exception e) {
			e.printStackTrace();
			p.sendMessage("§cNão foi possivel setar seu premio!");
			}
	  }
	  
	  
	  
	  
	  public void AddCoins(Player p)
	  {
		  int valor = 10;
		  Random random = new Random();
		  
		   if ((Account.getRank(p)).Has(p, Rank.VIP, false))
		   {
			   valor = valor*4;
		   }
		   if ((Account.getPatente(p)).Has(p, Patente.Ultra, false))
		   {
			   valor = valor*2;
			   Account.AddExp(p, "10");
		   }
		     Account.AddCoins(p, valor);
	       p.sendMessage("§eVocê recebeu §6+" + valor + " planets");
	       Account.UpdateAccount(p);
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
	  
	  @EventHandler(priority=EventPriority.MONITOR)
	  public void Dano(EntityDamageByEntityEvent event)
	  {
		Sounds sound = Sounds.HURT_FLESH;
		float vol = 1.0F;
		float pit = 1.0F;
        Random r = new Random();
	    if ((event.getDamager() instanceof Player))
	    {
	        Player jogador = (Player)event.getDamager();
	        if ((event.getEntity() instanceof Player)){
	        if ((Kit.verkit((Player) event.getEntity()).contains("Nenhum")) || (Kit.verkit(jogador).contains("Nenhum"))){
	        	event.setCancelled(true);
	        	return;
	         }
	        }
	        if (jogador.getItemInHand().getEnchantments() != Enchant.DAMAGE_ALL)
	        {
	        if (jogador.getItemInHand().getType() == Material.AIR)
	        	event.setDamage(0.5);
	        if (jogador.getItemInHand().getType() == Material.WOOD_SWORD) 
	            event.setDamage(2.5D+ r.nextInt(1));
	        if (jogador.getItemInHand().getType() == Material.STONE_SWORD) 
	            event.setDamage(3.0D+ r.nextInt(1));
	        if (jogador.getItemInHand().getType() == Material.GOLD_SWORD) 
	            event.setDamage(3.3D+ r.nextInt(1));
	        if (jogador.getItemInHand().getType() == Material.IRON_SWORD) 
	            event.setDamage(3.5D+ r.nextInt(1));
	        if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD) 
	            event.setDamage(4.0D +r.nextInt(2));
	        }
	        if (jogador.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
	        	event.setDamage(event.getDamage() + 1.5D);
	        }
	        if ((event.getEntity() instanceof Player))
		    {
	        	 Player p = (Player)event.getEntity();
	        	 p.showPlayer(jogador);
	        	 jogador.showPlayer(p);
	  		   CombatLog.AddCombat(jogador, p);
	        if (r.nextInt(100) < 15)
	        {
	        	 p.setVelocity(new Vector());
	             jogador.setVelocity(new Vector());
	        }
	       
	        UtilSound.playSound(jogador, sound, vol, pit);
	        UtilSound.playSound(p, sound, vol, pit);
		    }
	    }
	    
	  }
	  
	  public void KillStreak(Player p, int kill)
	  {
		 if (ks.containsKey(p))
		 {
			 if (kill >= ks.get(p))
			 {
				 Account.AddExp(p, "10");
				 Bukkit.broadcastMessage("§7Jogador " + p.getDisplayName() + "§7 esta com KillStreak§e " + kill);
			     ks.remove(p);
			 }
		 }
		 else
		 {
			 ks.put(p, kill+5);
		 }

	  }
	    

}
