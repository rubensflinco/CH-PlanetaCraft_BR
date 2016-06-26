/**
 * 
 */
package me.acf.FullPvP;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.json.JSONObject;

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
	public static HashMap<Player, String> fpcoins = new HashMap<>();
	public static HashMap<String, String> matouo = new HashMap<>();
	public static HashMap<String, String> morreuo = new HashMap<>();
	public static HashMap<String, String> kso = new HashMap<>();
	public static HashMap<String, String> fpcoinso = new HashMap<>();
	
	public static void Loader(Player p)
	{
		try {
	 	JSONObject json = new JSONObject(AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=VER-conta&nick=" + p.getName()));
	    matou.put(p, json.getString("matou"));	
	    morreu.put(p, json.getString("morreu"));
	    ks.put(p, json.getString("ks"));
	    fpcoins.put(p, json.getString("dinheiro"));
		}
		  catch (Exception ex)
		  {
			  p.kickPlayer("§7Erro ao recuperar informações da web, por favor, tente novamente em um minuto avise nossa staff.");
		  }
	}
	
	public static String MostrarDinheiroOFF(String nick)
	{
	
			try {
		 	JSONObject json = new JSONObject(AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=VER-conta&nick=" + nick));
		 	return json.getString("dinheiro");
			}
		 	catch (Exception ex)
			  {
		 		
			  }
		 	return null;
	}
	public static void Loader(String p)
	{
	 	JSONObject json = new JSONObject(AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=VER-conta&nick=" + p));
	    matouo.put(p, json.getString("matou"));	
	    morreuo.put(p, json.getString("morreu"));
	    kso.put(p, json.getString("ks"));
	    fpcoinso.put(p, json.getString("dinheiro"));
	   
	}
	
	public static void Remove(Player p)
	{
		matou.remove(p);
		morreu.remove(p);
		ks.remove(p);
		fpcoins.remove(p);

	}
	public static void Reload(Player p)
	{
		Remove(p);
		Loader(p);
	}
	public static void AddMatou(Player p)
	{
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=ADD-matou&nick=" + p.getName()));
	}
	public static void AddMorreu(Player p)
	{
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=ADD-morreu&nick=" + p.getName()));
	}
}
