/**
 *
 * Projeto: CHub2 
 * Packet: me.acf.MiniGames.Style.Utils
 * Git Config: 
 * Usuario: adriancf
 * -= [Team CHGroup] =-
 *
 */
package me.acf.MiniGames.Style.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.Style.UserData.Style;
import me.hub.API.Util.UtilActionBar;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.UtilTitle;
import me.hub.API.Util.Sound.Sounds;

/**
 *
 * Criado dia 19 de jun de 2016 - 15:57:34
 * Projeto: CHub2
 * por @author αdяiαиcf #Reloads
 * 
 */
public class MGPVP {


	public static void Morreu(PlayerDeathEvent event)
	{
		if (Arcade.estilo.equals(ArcadeType.JOGANDO)){
	    MiniGamesMananger.jogadores.get(event.getEntity()).style = Style.MORTO;
	    
		event.setDeathMessage(null);
	    final Player p = event.getEntity();
		if (((event.getEntity() instanceof Player)) && ((event.getEntity().getKiller() instanceof Player)))
	    {
		    final Player k = p.getKiller();
		    MiniGamesMananger.jogadores.get(k).Matou++;
		    UtilSound.playSound(p, Sounds.SKELETON_DEATH, 10.0F, 1.0F);
			UtilActionBar.ActionBar(p, "§5Você morreu pelo(a) §f"+k.getName()+"§5 caso queira sair digite §f/lobby");
			Bukkit.broadcastMessage("§5§l"+ Bukkit.getServerName() +" §7O jogador §f"+p.getName()+"§7 morreu pelo(a) §f"+k.getName()+"§7 .");
			UtilTitle.sendTitle(p,10,20,10,"§5Morreu p/ §f"+k.getName()+"§5 !","§7§lCaso queira sair digite §f/lobby");
	    }
	    else
	    {
	    	UtilSound.playSound(p, Sounds.SKELETON_DEATH, 10.0F, 1.0F);
			   UtilActionBar.ActionBar(p, "§5Você morreu caso queira sair digite §f/lobby");
			   Bukkit.broadcastMessage("§5§l"+ Bukkit.getServerName() +" §7O jogador §f"+p.getName()+"§7 morreu .");
			   UtilTitle.sendTitle(p,10,20,10,"§5Você morreu !","§7§lCaso queira sair digite §f/lobby");
	    }
	        
 	   p.setHealth(20.0D);
	   p.setFoodLevel(20);
	   p.closeInventory();
	   p.getInventory().setArmorContents(null);
	   p.getInventory().clear();
		}
	}
	
	
}
