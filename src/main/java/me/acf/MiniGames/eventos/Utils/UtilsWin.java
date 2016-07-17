package me.acf.MiniGames.eventos.Utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.Style.Utils.MGPremios;
import me.acf.lobby.Lag.TPS;
import me.acf.lobby.gadgets.utils.Firework;
import me.hub.Main;
import me.hub.API.Chat;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.UtilTitle;
import me.hub.API.Util.Sound.Sounds;
import me.hub.Bungee.Bungee;
import me.hub.NMS.CustomEntityFirework_1_8_5_R03;

public class UtilsWin {

	public static String wim;
	
	public static void Check_Vitoria()
	{
		if (MiniGamesMananger.Vivos.size() > 1) 
			return;
		
		Player ganhador = null;
		for (Player p : MiniGamesMananger.Vivos)
		{ ganhador = p; }
		if (!Arcade.estilo.equals(ArcadeType.FIM)){
			UtilsWin.Vitoria(ganhador);
			if (ganhador == null)
				wim = "Ninguem";
			else
				wim = ganhador.getName();
		}
		
		Arcade.estilo = ArcadeType.FIM;
		
		
		for (final Player p : UtilServer.Jogadores())
		MiniGamesMananger.Vivos.remove(p);
		
	}
	
	
	
	
	
	public static void Vitoria(Player jogador)
	{
		
		
		String msg;
		
	  if (jogador == null)
	  {
			msg = "§f§lNinguem";
			System.out.print("Não tivemos vencedores :(");
	  }
	  else
	  {
		  msg = " " + jogador.getName();
		  
	  }
		if (wim == "Ninguem"){
	  MGPremios.Givar(jogador, true);
	  
	  Bukkit.broadcastMessage(" ");
	  Bukkit.broadcastMessage("                   §f§lVENCEDOR DESTA PARTIDA ");
	  Bukkit.broadcastMessage("                          §e§l " + msg.toUpperCase());
	  Bukkit.broadcastMessage(" ");
	  for (Player player : UtilServer.Jogadores()) {
		  UtilSound.playSound(player, Sounds.LEVEL_UP, 2f, 1f);
	  Chat.ActionBar(player, "§f§lJOGADOR §a§l" + msg.toUpperCase() + "§f§l GANHOU ESTA PARTIDA");
	  }
	  jogador.setGameMode(GameMode.SPECTATOR);
	  
	  Location loc = jogador.getLocation();
	  
	  if (TPS.getTPS() < 18.5D) return;
 	 Type type = Type.BALL; 
      for (int i=0; i > 20; i++)
      {
    	  try {
			Thread.sleep(500);
			Random r = new Random();  
	        int r1i = r.nextInt(16) + 1;
	        int r2i = r.nextInt(16) + 1;
	        int fw = r.nextInt(23);
	        Color c1 = Firework.getColor(r1i);
            Color c2 = Firework.getColor(r2i);
            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
            jogador.getWorld().playEffect(loc, Effect.FIREWORKS_SPARK, 2);
            UtilSound.playSound(jogador, Sounds.FIREWORK_LAUNCH, 0.1F, 1.0F);
            CustomEntityFirework_1_8_5_R03.spawn(jogador.getLocation().clone().add(+0.5,0,0.5), effect);  
            jogador.getLocation().add(0,1,0);
            type = Type.BURST;
    	  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
      }
		}
	  
		UtilTitle titulo = new UtilTitle("§f"+msg.toUpperCase()+"§5 Ganhou!","§7§lReiniciando...",4,9,4);
		titulo.broadcast();
		
	   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
	   	      public void run() {
	   	    	Bungee.SendAllPlayers("lobby");
	  	   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
		   	      public void run() {
		   	    	Bungee.SendAllPlayers("lobby");
			  	   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
				   	      public void run() {
				   	    	Bungee.SendAllPlayers("lobby");
				   			Bukkit.getServer().shutdown();
				   	      } 
				   	    }
				   	    , 40L);
		   	      } 
		   	    }
		   	    , 20L);
	   	      } 
	   	    }
	   	    , 160L);
	}
	
	
	
}
