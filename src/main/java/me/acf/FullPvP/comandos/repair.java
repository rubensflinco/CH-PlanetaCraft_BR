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
import me.hub.Main;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.site.account.Account;
import me.site.account.AccountWeb;
import me.site.account.rank.Rank;

public class repair implements CommandExecutor {

	public String[] atalhos = new String[] { "fix","reparar" };
    public String desc = "Reparar";
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		   if (ComandosAPI.VerConsole(sender).equals("sim"))
		   {
			   sender.sendMessage(Message.Console_Não);
  			   return true;
		   }
		  
		   final Player jogador = (Player) sender;
		   if ((Account.getRank(jogador)).Has(jogador, Rank.VIP, true))
		   {try {
				 if (AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=REMOVE-dinheiro&nick=" + jogador.getName() + "&quantidade=1000","OK").contains("OK"))
				 {}
			 } catch (Exception e) {
				 Format.Erro("Você não tem §c1000 FPCoins", jogador);
				 return true; 
			 }
		   
       	UtilInv.repairAll(jogador);
       	Format.Comando("REPARAR", "Itens reparados com §aexito", jogador);;
		   }
		return false;
	  }
	
	

	

}

