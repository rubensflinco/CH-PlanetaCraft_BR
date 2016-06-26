package me.acf.MiniGames.SkyWars;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.MiniGames.HungerGames.Conta;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.site.account.AccountWeb;

public class Sair extends MiniPlugin {

	public Sair(JavaPlugin plugin) {
		super("Sair", plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void Quit(PlayerQuitEvent event)
	{
		Player jogador = event.getPlayer();
		
		Conta.Loader(jogador);
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/SW.php?modo=ADD-conta&nick=" + jogador.getName()));
		
		String mapa = ""+SkyWars.VotouMapa.get(jogador.getName())+"";
     	String GET1 = SkyWars.VotosMapa.get(mapa);
 		if (GET1 == null){
         	int votos2 = 0;
         	SkyWars.VotosMapa.put(""+mapa, ""+votos2);
     		}else{
     		int votos2 = Integer.parseInt(GET1)-1;
     		SkyWars.VotosMapa.put(""+mapa, ""+votos2);
     		}
 		
 		SkyWars.VotouMapa.remove(jogador.getName());
		
	}
}
