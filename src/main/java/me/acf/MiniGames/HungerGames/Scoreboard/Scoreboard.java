package me.acf.MiniGames.HungerGames.Scoreboard;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.HungerGames.HungerGames;
import me.acf.MiniGames.HungerGames.kits.Kit;
import me.acf.MiniGames.SkyWars.SkyWars;
import me.hub.Main;
import me.hub.API.Util.UtilNumber;
import me.hub.Scoreboard.ScoreboardAPI;
import me.site.account.Account;
import me.site.account.rank.Rank;



public class Scoreboard {
	  public static HashMap<Player, org.bukkit.scoreboard.Scoreboard> scoreboards = new HashMap();
	  public static String texto = "§f§lHungerGames §6§lPC-BR";
	  private static boolean voltar = false;
	  private static int i = 0;
		 public static void CriarScoreboard(Player j)  {
			   ScoreboardAPI scoreboard = new ScoreboardAPI(Main.NomeDoServidor);
		
			   scoreboard.send(j);
			   
			   UpdateScoreboard();
		    }
	 
		 public static void UpdateScoreboard()
		 {
			 for (Player player : Bukkit.getOnlinePlayers()) {
				 try {
				int jgn = MiniGamesMananger.necessario;
				
				ScoreboardAPI.add("§1 "); //12
			    if ((Arcade.estilo.equals(ArcadeType.INVENCIVEL)) || (Arcade.estilo.equals(ArcadeType.JOGANDO))){
			    ScoreboardAPI.add("§fVivos §f: §a"+MiniGamesMananger.Vivos.size()+""); //11
			    ScoreboardAPI.add("§f§fMortos §f: §a"+MiniGamesMananger.Specter.size()+" "); //10
			    ScoreboardAPI.add("§f§fJogadores §f: §a"+MiniGamesMananger.jogadores.size()+"  "); //9
			    }else{
		        ScoreboardAPI.add("§fMax-Players §f: §a"+Bukkit.getMaxPlayers()+" "); //11
		        ScoreboardAPI.add("§fMin-Players §f: §a"+jgn+"  "); //10
		        ScoreboardAPI.add("§fJogadores §f: §a"+MiniGamesMananger.jogadores.size()+"   "); //9
			    }
		        ScoreboardAPI.add("§2 "); //8
		        ScoreboardAPI.add("§fSeu-Kit §f: §7["+Kit.verkit(player).replace(" ", "")+"§7]"); //7
		        ScoreboardAPI.add("§3 "); //6
		        ScoreboardAPI.add("§fCash §f: §a"+UtilNumber.getNumber(Account.getCash(player))); //5
		        ScoreboardAPI.add("§fPlanets §f: §a"+UtilNumber.getNumber(Account.getCoins(player))); //4
		        ScoreboardAPI.add("§4 "); //3
		        ScoreboardAPI.add("§fEvento §f: §aNenhum"); //2
		        ScoreboardAPI.add("§5 "); //1
		      


		         for (Player online : Bukkit.getOnlinePlayers()) {
				    	String rank = "" + Account.getRank(online);
				    	if (Account.getRank(online).Has(online, Rank.VIP, false))
				    	{
				    	player.getPlayer().getScoreboard().getTeam(rank.replace("+", "M")).addPlayer(online);
				    	online.getPlayer().getScoreboard().getTeam(rank.replace("+", "M")).addPlayer(online);
			            ScoreboardAPI.scoreboard.getTeam(rank.replace("+", "M")).addPlayer(online);
				    	}
			         }
		            ((CraftPlayer)player.getPlayer()).getHandle().displayName = Account.getRank(player.getPlayer()).GetTag(false) + " " + Account.getPatente(player.getPlayer()).Cor+ player.getPlayer().getName();
		            ((CraftPlayer)player.getPlayer()).getHandle().setCustomName(Account.getRank(player.getPlayer()).GetTag(false) + " "+ Account.getPatente(player.getPlayer()).Cor+ player.getPlayer().getName());
		            ((CraftPlayer)player.getPlayer()).getHandle().setCustomNameVisible(true);
					if (Arcade.estilo.equals(ArcadeType.AGUARDANDO)){
					     ScoreboardAPI.build(player, "§a§l"+Bukkit.getServerName()+" §c§l| §f§lAguardando");
						}
						if (Arcade.estilo.equals(ArcadeType.INICIANDO)){
						 ScoreboardAPI.build(player, "§a§l"+Bukkit.getServerName()+" §c§l| §f§lIniciando");
						}
						if (Arcade.estilo.equals(ArcadeType.INVENCIVEL)){
						 ScoreboardAPI.build(player, "§a§l"+Bukkit.getServerName()+" §c§l| §f§lPvP Offline");
						}
						if (Arcade.estilo.equals(ArcadeType.JOGANDO)){
						 ScoreboardAPI.build(player, "§a§l"+Bukkit.getServerName()+" §c§l| §f§lBatalhando");
						}
						if (Arcade.estilo.equals(ArcadeType.FIM)){
						 ScoreboardAPI.build(player, "§a§l"+Bukkit.getServerName()+" §c§l| §f§lFIM ");
					}
				 } catch (Exception exception) { }	
			 }
		 }


		 
}
