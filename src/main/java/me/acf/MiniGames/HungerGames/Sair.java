package me.acf.MiniGames.HungerGames;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.hub.Main;
import me.hub.MiniPlugin;

public class Sair extends MiniPlugin {

	public Sair(JavaPlugin plugin) {
		super("Sair", plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void Quit(PlayerQuitEvent event)
	{
		final Player jogador = event.getPlayer();
		
	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
	   public void run() {
		Conta.Remove(jogador);
	        }
	    }
	   , 5L);
	  
	}
	
}
