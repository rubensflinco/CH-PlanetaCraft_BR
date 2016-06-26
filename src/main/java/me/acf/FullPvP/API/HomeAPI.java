/**
 * 
 */
package me.acf.FullPvP.API;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.FPConfig;
import me.acf.FullPvP.Teleport;
import me.site.account.Account;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class HomeAPI {

	
	public static void AddHome(Player p, String nome, Location loc)
	{
		String s = FPConfig.retorno(p, "home");
		String numero = FPConfig.retorno(p, "homes.numero");
		if ((s == "") || (s == null))
		{
			FPConfig.ADD(p, "homes.numero", "1");
		}
		else
		{
			int casas = Integer.parseInt(numero);
			if (!Account.getRank(p).Has(p, Rank.VIP, false)) {
				if (casas >= 3)
				{
					Format.Erro("Você so pode criar 3 casas.", p);
					return;
				}
			}
			casas = casas+1;
			FPConfig.FP(p, "homes.numero", "" + casas);
		}
		FPConfig.FP(p, "homes." + nome + ".X", "" + (int) loc.getX());
		FPConfig.FP(p, "homes." + nome + ".Y", "" + (int) loc.getY());
		FPConfig.FP(p, "homes." + nome + ".Z", "" + (int) loc.getZ());
		FPConfig.FP(p, "homes." + nome + ".Mundo", loc.getWorld().getName());
		if ((s == "") || (s == null))
		{
			FPConfig.FP(p, "home", nome);
		}
		else
		{
			if (!s.contains(nome))
				FPConfig.FP(p, "home", s + "," + nome);
		}
	}
	
	public static void RemoveHome(Player p, String nome)
	{
		String s = FPConfig.retorno(p, "home");
		if ((s == "") || (s == null))
		{
			Format.Erro("Não foi possivel achar a casa§a " + nome, p);
			return;
		}
		if (!s.contains(nome))
		{
			Format.Erro("Não foi possivel achar a casa§a " + nome, p);
			return;
		}
		if (s.contains(","))
		{
			FPConfig.FP(p, "home", s.replace("," + nome, ""));
		}
		else
		{
			FPConfig.FP(p, "home", null);
		}
		String numero = FPConfig.retorno(p, "homes.numero");
		if ((s == "") || (s == null))
		{
			FPConfig.ADD(p, "homes.numero", "0");
		}
		else
		{
			int casas = Integer.parseInt(numero);
			casas = casas-1;
			FPConfig.FP(p, "homes.numero", "" + casas);
		}
		Format.Comando("§a§lCASA", "Casa§a " + nome + "§7 deletada(o)", p);
		
	}
	
	public static void TeleportHome(Player p, String nome)
	{
		String s = FPConfig.retorno(p, "home");
		if (s == null)
		{
			Format.Erro("Não foi possivel achar a casa§a " + nome, p);
			return;
		}
		if (!s.contains(nome))
		{
			Format.Erro("Não foi possivel achar a casa§a " + nome, p);
			return;
		}
		int x = Integer.parseInt(FPConfig.retorno(p, "homes." + nome + ".X"));
		int y = Integer.parseInt(FPConfig.retorno(p, "homes."+ nome + ".Y"));
		int z = Integer.parseInt(FPConfig.retorno(p, "homes."+ nome + ".Z"));
		String mundo = FPConfig.retorno(p, "homes."+ nome + ".Mundo");
		Location loc = new Location(Bukkit.getWorld(mundo),x,y,z);
		Teleport.TeleportTempo(loc,p);
	}
}
