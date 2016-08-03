/**
 * 
 */
package me.acf.KitPvP;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.json.JSONObject;

import me.acf.KitPvP.scoreboard.Scoreboard;
import me.hub.Main;
import me.site.account.AccountWeb;

/**
 * @author adriancf
 *
 */
public class Conta {

	public static HashMap<Player, String> matou = new HashMap<>();
	public static HashMap<Player, String> morreu = new HashMap<>();
	public static HashMap<Player, String> ks = new HashMap<>();
	public static HashMap<Player, String> kits = new HashMap<>();

	public static void Loader(Player p)
	{
		try {
	 	JSONObject json = new JSONObject(AccountWeb.Conectar(Main.site + "/API/MG/KP.php?modo=VER-conta&nick=" + p.getName()));
	    matou.put(p, json.getString("matou"));	
	    morreu.put(p, json.getString("morreu"));
	    ks.put(p, json.getString("ks"));
	    kits.put(p, json.getString("kits"));
		}
		  catch (Exception ex)
		  {
			  p.kickPlayer("§7Erro ao recuperar informações da web, por favor, tente novamente em um minuto avise nossa staff.");
		  }
	}
	public static void Remove(Player p)
	{
		matou.remove(p);
		morreu.remove(p);
		ks.remove(p);
		kits.remove(p);
	}
	public static void Reload(Player p)
	{
		Remove(p);
		Loader(p);
	}
	public static void AddMatou(Player p)
	{
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/KP.php?modo=ADD-matou&nick=" + p.getName()));
	}
	public static void AddMorreu(Player p)
	{
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/KP.php?modo=ADD-morreu&nick=" + p.getName()));
	}
}
