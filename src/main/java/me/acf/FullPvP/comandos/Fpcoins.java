package me.acf.FullPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.Conta;
import me.acf.FullPvP.FPConfig;
import me.acf.FullPvP.API.HomeAPI;
import me.hub.API.Util.UtilNumber;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;

public class Fpcoins implements CommandExecutor {

	public String[] atalhos = new String[] { "coinsfp" };
    public String desc = "Ver seus coins no fullpvp";
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		   if (ComandosAPI.VerConsole(sender).equals("sim"))
		   {
			   sender.sendMessage(Message.Console_Não);
  			   return true;
		   }
		  
		   final Player jogador = (Player) sender;
		   
		   
			   Format.Comando("FPCoins", "Seus FPCoins:§a " + UtilNumber.getNumber(Conta.fpcoins.get(jogador)), jogador);

			   return false;
	  }
	
	public String Casas(Player p)
	{
		String casas = FPConfig.retorno(p, "home");
		if ((casas == "") || (casas == null))
		{
			return "§aVocê não tem nenhuma casa";
		}
		casas = casas.replace(",", " ");
		return casas;
	}

	

}

