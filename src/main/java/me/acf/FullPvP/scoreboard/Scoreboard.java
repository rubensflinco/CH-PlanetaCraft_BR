package me.acf.FullPvP.scoreboard;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.acf.FullPvP.Conta;
import me.acf.FullPvP.FullPvPManager;
import me.acf.clan.Clan;
import me.hub.Main;
import me.hub.API.Util.UtilNumber;
import me.hub.API.Util.UtilTime;
import me.hub.Scoreboard.ScoreboardAPI;
import me.site.account.Account;
import me.site.account.rank.Rank;



public class Scoreboard {
	  public static HashMap<Player, org.bukkit.scoreboard.Scoreboard> scoreboards = new HashMap();
	  public static String texto = "§f§lFullPvP §6§lPC-BR";
	  private static boolean voltar = false;
	  private static int i = 0;
	 public static void CriarScoreboard(Player j)  {
		   ScoreboardAPI scoreboard = new ScoreboardAPI(Main.NomeDoServidor);
	
		   scoreboard.send(j);
	      
	        
	    }
	 
	

	 public static void UpdateScoreboard()
	 {
		 

		 for (Player player : Bukkit.getOnlinePlayers()) {
			 try {		 
		    ScoreboardAPI.remover(player, "Evento");
		    ScoreboardAPI.add("§c"); //15
	        ScoreboardAPI.add("Grupo: " + Account.getRank(player).GetTag(false)); //15
	        ScoreboardAPI.add("Cash: §a" + UtilNumber.getNumber(Account.getCash(player))); //14
	        ScoreboardAPI.add("Planets: §a" + UtilNumber.getNumber(Account.getCoins(player))); //13
	        ScoreboardAPI.add("FPCoins: §a" + UtilNumber.getNumber(Conta.fpcoins.get(player))); //13
	        ScoreboardAPI.add("§5"); //12
	        ScoreboardAPI.add("§7"); //11
	        ScoreboardAPI.add("§c§fVocê Matou: §a " + UtilNumber.getNumber(Conta.matou.get(player))); //10
	        ScoreboardAPI.add("§a§fVocê Morreu: §a " + UtilNumber.getNumber(Conta.morreu.get(player))); //9
	        ScoreboardAPI.add("§f"); //8    
	        ScoreboardAPI.add("Patente: " + Account.getPatente(player).GetTag(false)); //7
	        ScoreboardAPI.add("Seu Nivel Atualmente: §a" + Account.getNivel(player)); //6
	        ScoreboardAPI.add("§2"); //5
	        if (!Clan.NomeDoClan(player).equals(""))
	        ScoreboardAPI.add("Clan: " + Clan.NomeDoClan(player)); //4
	        else
	        	ScoreboardAPI.add("Clan: " + "Nenhum"); //4
	        String timeLeft = UtilTime.convertres(FullPvPManager.Tempo*1000, 0, UtilTime.TimeUnit.FIT);
	        ScoreboardAPI.add("Evento: " + timeLeft); //3

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
	            ScoreboardAPI.build(player, texto);
		 }
		      catch (Exception exception)
			    {

			    }
		 }
   
		 
	 
	 }
}
