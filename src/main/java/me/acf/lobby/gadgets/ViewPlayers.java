/**
 * 
 */
package me.acf.lobby.gadgets;

import org.bukkit.entity.Player;

import me.acf.lobby.perfil.Perfil;
import me.hub.API.Util.UtilServer;
import me.site.account.Account;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class ViewPlayers {
	
	public static void Esconder(Player p)
	{
		for (Player all : UtilServer.Jogadores())
		{
			 if (!(Account.getRank(all)).Has(all, Rank.VIP, true)) 
				 p.hidePlayer(all);
			 
		}
	}
	
	public static void Revelar(Player p)
	{
		for (Player all : UtilServer.Jogadores())
		{
			if (!me.hub.comandos.geral.Admin.admin.contains(all))
			p.showPlayer(all);
		}
	}
	
	public static void EsconderP(Player p)
	{
		for (Player all : Perfil.VerJogadores)
		{
			all.hidePlayer(p);
		}
	}
}
