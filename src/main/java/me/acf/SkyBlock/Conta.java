/**
 * 
 */
package me.acf.SkyBlock;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.JSONObject;

import me.acf.KitPvP.scoreboard.Scoreboard;
import me.hub.Main;
import me.site.account.Account;
import me.site.account.AccountWeb;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class Conta {

	public static HashMap<Player, String> matou = new HashMap<>();
	public static HashMap<Player, String> morreu = new HashMap<>();
	public static HashMap<Player, String> ks = new HashMap<>();

	public static void Loader(Player p)
	{
		try {
	 	JSONObject json = new JSONObject(AccountWeb.Conectar(Main.site + "/API/MG/SB.php?modo=VER-conta&nick=" + p.getName()));
	    matou.put(p, json.getString("matou"));	
	    morreu.put(p, json.getString("morreu"));
	    ks.put(p, json.getString("ks"));
		}
		  catch 
		  (Exception ex)
		  {
			  p.kickPlayer("§7Erro ao recuperar informações da web, por favor, tente novamente em um minuto avise nossa staff.");
		  }
		if (Account.getRank(p).Has(p, Rank.MEMBRO, false))
    	{
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " group set membro"); 
    	}
		if (Account.getRank(p).Has(p, Rank.VIP, false))
    	{
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " group set vip"); 
    	}
		if ((Account.getRank(p).Has(p, Rank.VIPM, false)) || (Account.getRank(p).Has(p, Rank.MIDIA, false)))
    	{
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " group set vipm"); 
    	}
		if ((Account.getRank(p).Has(p, Rank.STAFF, false)) || (Account.getRank(p).Has(p, Rank.STAFFM, false)))
    	{
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " group set staff"); 
    	}
		if ((Account.getRank(p).Has(p, Rank.DONO, false)) || (Account.getRank(p).Has(p, Rank.DEV, false)) || (Account.getRank(p).Has(p, Rank.STAFFM, false)))
    	{
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " group set dono"); 
    	}
	}
	public static void Remove(Player p)
	{
		matou.remove(p);
		morreu.remove(p);
		ks.remove(p);
	}
	public static void Reload(Player p)
	{
		Remove(p);
		Loader(p);
	}
	public static void AddMatou(Player p)
	{
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/SB.php?modo=ADD-matou&nick=" + p.getName()));
	}
	public static void AddMorreu(Player p)
	{
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/SB.php?modo=ADD-morreu&nick=" + p.getName()));
	}
}
