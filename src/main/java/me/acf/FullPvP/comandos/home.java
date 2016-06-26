package me.acf.FullPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.FPConfig;
import me.acf.FullPvP.API.HomeAPI;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;

public class home implements CommandExecutor {

	public String[] atalhos = new String[] { "casa" };
    public String desc = "Ir suas homes";
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		   if (ComandosAPI.VerConsole(sender).equals("sim"))
		   {
			   sender.sendMessage(Message.Console_Não);
  			   return true;
		   }
		  
		   final Player jogador = (Player) sender;
		   
		   if (args.length <= 0)
		   {
			   Format.Comando("§a§lCASA", "Suas Casas: §a" + Casas(jogador), jogador);
				return true;
		   }
		   
		   HomeAPI.TeleportHome(jogador, args[0]);
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

