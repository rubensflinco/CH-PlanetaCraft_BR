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

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.Style.UserData;
import me.hub.API.Util.UtilTime;
import me.hub.API.module.C;
import me.site.account.Account;
import me.site.account.rank.Rank;


/**
 *
 * Criado dia 19 de jun de 2016 - 16:25:50
 * Projeto: CHub2
 * por @author αdяiαиcf #Reloads
 * 
 */
public class MGPremios {

	public static String Line = C.cDGreen + C.Strike + "=============================================";
	public static int Vitoria = 50;
	public static int Participar = 1;
	public static int Matar = 3;
	public static int Cash = 10;
	public static int Chaves = 1;
	public static int Mortes = -2;
	public static int Patente = 3;
	
	private static String Format_GiveBosster(int Valor)
	{
		return "  §a+ " + Valor + "§9 Booster Planets";
	}
	private static String Format_GiveCash(int Valor)
	{
		return "  §a+ " + Valor + "§e Cash §a(+Bonus)";
	}
	
	private static String Format_Give(int Valor)
	{
		return "  §a+ " + Valor + "§7 Por §e";
	}
	
	private static String Format_Remove(int Valor)
	{
		return "  §c- " + Valor + "§7 Por §e";
	}
	
	private static String Format_Statos(String statos, String resposta)
	{
		return "  §7§l " + statos + "§f§l  §a§l " + resposta;
	}
	
	
	private static int Patente(Player p, boolean msg)
	{
		int total = 0;
		int normal = 10; 
		int extra = 0;
		
		if ((Account.getPatente(p)).Has(p, me.acf.lobby.patentes.Patente.Amador, false))
		  total = normal; 
		
		if ((Account.getPatente(p)).Has(p, me.acf.lobby.patentes.Patente.Chef, false))
		 { total += 2; extra +=2; }
		
		if ((Account.getPatente(p)).Has(p, me.acf.lobby.patentes.Patente.ExpMaster, false))
		 { total += 2; extra +=2; }
		
		if ((Account.getPatente(p)).Has(p, me.acf.lobby.patentes.Patente.Jotinha, false))
		 { total += 2; extra +=2; }
		
		if ((Account.getPatente(p)).Has(p, me.acf.lobby.patentes.Patente.Legendario, false))
		 { total += 2; extra +=2; }
		
		if ((Account.getPatente(p)).Has(p, me.acf.lobby.patentes.Patente.Titan, false))
		 { total += 2; extra +=2; }
		
		if ((Account.getPatente(p)).Has(p, me.acf.lobby.patentes.Patente.unix, false))
		 { total += 5; extra +=5; }
		
		if (msg) {
		if ((Account.getPatente(p)).Has(p, me.acf.lobby.patentes.Patente.Amador, false))
		{
			if (normal == 0)
			p.sendMessage(Format_Give(total) + "ter Patente" );
			else
				p.sendMessage(Format_Give(total) + "ter Patente §a(+" + extra + " Bonus)" );	
		}
		}
		return total;
	}
	
	public static int BosterLevel(Player p, boolean msg)
	{
		int total = 0;
		for (int l = 0; l >= Account.getNivel_Int(p); l++)
		   total++;	
		 total -= total/2;
		 if (msg) {
		 if (total > 0)
			p.sendMessage(Format_GiveBosster(total));
		 }
		return total;
	}
	
	public static int TempoVivo(Player p, boolean msg)
	{
		int total = 2;
		
		UserData jog = MiniGamesMananger.jogadores.get(p);
		long milliseconds = jog.Tempo_Vivo*1000;
	    String timeLeft = UtilTime.convertString(milliseconds, 0, UtilTime.TimeUnit.FIT);
	    
	    total += jog.Tempo_Vivo/60;
	    
	    if (total <= 0)
	    total = 2;
	    
	    if (total >= 100)
	    total = 100;
	    
	    if (msg)
	    p.sendMessage(Format_Give(total) + " §e" + timeLeft + " de jogo");
	    		
	    return total;
	}
	
	
	
	public static void Givar(Player p, boolean win)
	{
		int Total = 0;
		boolean Cash = false;
		Random random = new Random();
		int vip = 0;
		int vip_m = 0;
		int kills = MiniGamesMananger.jogadores.get(p).Matou*Matar;
		int morrer = MiniGamesMananger.jogadores.get(p).Morreu*Mortes;
		int Tirar_Staff = 0;
		Total += Participar;
		Total += kills;
		Total -= morrer;
		Total += TempoVivo(p, false);
		Total += Patente(p, false);
		  if ((Account.getRank(p)).Has(p, Rank.VIP, false))
			   { vip = Total*2; Total += Total*2; }
		  if ((Account.getRank(p)).Has(p, Rank.VIPM, false))
		       { vip_m = Total*3; Total += Total*3; }                    
		  if ((Account.getRank(p)).Has(p, Rank.STAFF, false))
			   { Tirar_Staff = Total/2; Total -= Total/2; }
		  if (random.nextInt(100) < 25)
		    Cash = true;
	      
		  if (win)
			  Total += Vitoria;
		    
		  
		if (p.isOnline())
		{
			UserData jog = MiniGamesMananger.jogadores.get(p);
		    p.sendMessage("");
			p.sendMessage(Line);
			p.sendMessage("§f§lGanhos na partida - §7§l" + Bukkit.getServerName());
			p.sendMessage("");
			p.sendMessage(Format_Give(Vitoria) + "ganhar a partida");
		    p.sendMessage(Format_Give(kills) + "ter " + jog.Matou + " kills");
		    p.sendMessage(Format_Remove(morrer) + "ter " + jog.Morreu + " morte(s)");
            p.sendMessage(Format_Give(Participar) + "Participar da partida");
            System.out.print(Patente(p, true));
            System.out.print(TempoVivo(p, true));
            if ((Account.getRank(p)).Has(p, Rank.VIP, false))
            	p.sendMessage(Format_Give(vip) + "ser " + Rank.VIP.GetTag(true));
            if ((Account.getRank(p)).Has(p, Rank.VIPM, false))
            	p.sendMessage(Format_Give(vip_m) + "ser " + Rank.VIPM.GetTag(true));
            if ((Account.getRank(p)).Has(p, Rank.STAFF, false))
            	p.sendMessage(Format_Remove(Tirar_Staff) + "ser " + Rank.STAFF.GetTag(true));
            if (Cash)
            	p.sendMessage(Format_GiveCash(MGPremios.Cash));
            p.sendMessage("");
            if (Cash)
            	p.sendMessage("§f§lTotal a receber:§6§l " + Total + " Planets§f§l e §6§l " + MGPremios.Cash + " Cash");
            else
                p.sendMessage("§f§lTotal a receber:§6§l " + Total + " Planets");
            p.sendMessage(Line);
            
		}
		
		Account.AddCoins(p, Total);
		if (Cash)
	     Account.AddCash(p, MGPremios.Cash);
	}
	
}
