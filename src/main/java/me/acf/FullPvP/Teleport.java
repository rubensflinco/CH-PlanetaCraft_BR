/**
 * 
 */
package me.acf.FullPvP;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.acf.FullPvP.scoreboard.Scoreboard;
import me.acf.KitPvP.CombatLog;
import me.hub.Main;
import me.hub.API.Util.UtilInv;
import me.site.account.Account;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class Teleport {

	public static HashMap<Player, Location> loc = new HashMap<>();
	
	public static void TeleportTempo(final Location location, final Player jogador)
	{
		int x = (int) jogador.getLocation().getX();
		int z = (int) jogador.getLocation().getZ();
		int y = (int) jogador.getLocation().getY();
	     Scoreboard.CriarScoreboard(jogador);
		loc.put(jogador, new Location(jogador.getWorld(), x, y, z));
		  if ((Account.getRank(jogador)).Has(jogador, Rank.VIPM, false))
		   {
			   jogador.teleport(location);
			   loc.remove(jogador);
			   jogador.sendMessage("§aTeleportando...");
			   return;
		   }
		jogador.sendMessage("§aTeleportando você em 3 segundos.");
	   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			   
			   public void run() {
				   if (CombatLog.EstaEmCombat(jogador))
				   {
					   jogador.sendMessage("§cVocê esta em combat.");
					   loc.remove(jogador);
					   return;
				   }
				   if ((jogador.isOnline()) || (jogador != null)) {
				   jogador.teleport(location);
				   loc.remove(jogador);
				   jogador.sendMessage("§aTeleportando...");
				   }
			   }
		 }, 60L);
	   loc.remove(jogador);
	   UtilInv.save(jogador);
	   }

	}

