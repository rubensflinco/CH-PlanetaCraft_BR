/**
 * 
 */
package me.acf.SkyBlock;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.servidor.Servidor;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Chat;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.UtilTablist;
import me.hub.API.Util.Sound.Sounds;
import me.site.account.Account;
import me.site.account.AccountWeb;

/**
 * @author adriancf
 *
 */
public class Entrar extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Entrar(JavaPlugin plugin) {
		super("SkyBlock Entrar", plugin);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Player> joins = new ArrayList<>();
	public int evento = 100;
	
	@EventHandler
	public void Entrar(final PlayerJoinEvent event)
	{
		event.setJoinMessage(null);
		
		UtilTablist.setHeader(event.getPlayer(), "§0 ", "§a§lPlanetacraft§f§l_§e§lBR", "§a ", "§f"+event.getPlayer().getCustomName(), "§c ", "§f§lSALA §f: §a§l"+Bukkit.getServerName(), "§1 ");
		
		UtilTablist.setFooter(event.getPlayer(), "§2 ", "§f§lSITE §f: §a§lwww.planetacraft.com.br", "§3 ", "  §f§lADQUIRIR JÁ §6§lVIP §f§lEM §a§lwww.planetacraft.com.br/loja  ", "§4 ");

		Chat.ActionBar(event.getPlayer(), "§e§l" + "SEJA BEM-VINDO AO SKYBLOCK DO PLANETACRAFT_BR");
		 event.getPlayer().sendMessage(" ");
		 event.getPlayer().sendMessage("      §f§lSEJA BEM-VINDO; §7§l" + event.getPlayer().getName());
		 event.getPlayer().sendMessage("                 §f§lAO §a§l"+Bukkit.getServer().getServerName());
		 event.getPlayer().sendMessage(" ");
		 UtilSound.playSound(event.getPlayer(), Sounds.NOTE_PLING, 1, 0);
		 UtilInv.restore(event.getPlayer());
	     Servidor.AddJoin();
	     event.getPlayer().teleport(Bukkit.getWorld("world").getSpawnLocation());
	     event.getPlayer().setGameMode(GameMode.SURVIVAL);
	     Scoreboard.CriarScoreboard(event.getPlayer());
	     System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/SB.php?modo=ADD-conta&nick=" + event.getPlayer().getName()));
	     Conta.Loader(event.getPlayer());
	     if (!joins.contains(event.getPlayer()))
	    {
	    	 Account.AddExp(event.getPlayer(), "10");
	    	joins.add(event.getPlayer());
	    	if (joins.size() == 666)
	    	{
	    		Bukkit.broadcastMessage("§c§l666 Súscipe ludio ludius " + event.getPlayer().getName());
	    		for (Player j : UtilServer.Jogadores()) {
	    			UtilSound.playSound(j, Sounds.AMBIENCE_THUNDER, 6.0F, 6.0F);
	    			Chat.ActionBar(event.getPlayer(), "§4§lO JOGADOR NUMERO 666 ENTROU (" + event.getPlayer().getName() + ")");
	    		
	    	}
	    	if (joins.size() == evento)
	    	{
	    		Bukkit.broadcastMessage("§5§lEVENTO §7Você acaba de receber §a+1 Chave.");
	    	    evento = evento+100;
	    		for (Player j : UtilServer.Jogadores()) {
	    		Account.AddChave(j, 1);
	    	    Account.UpdateAccount(j);
	    	    }
	    	    }
	    
	    	}
	    }
	}
}
