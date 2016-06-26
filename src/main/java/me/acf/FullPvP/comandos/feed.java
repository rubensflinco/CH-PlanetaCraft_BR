package me.acf.FullPvP.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.FPConfig;
import me.acf.FullPvP.Teleport;
import me.acf.FullPvP.API.HomeAPI;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.site.account.Account;
import me.site.account.rank.Rank;

public class feed implements CommandExecutor {

	public String[] atalhos = new String[] { "fome" };
    public String desc = "Regenerar sua fome";
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		   if (ComandosAPI.VerConsole(sender).equals("sim"))
		   {
			   sender.sendMessage(Message.Console_Não);
  			   return true;
		   }
		  
		   final Player jogador = (Player) sender;
		   if ((Account.getRank(jogador)).Has(jogador, Rank.VIP, true))
		   {
		   jogador.setFoodLevel(25);
		   }
		return false;
	  }
	
	

	

}

