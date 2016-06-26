package me.acf.FullPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.API.HomeAPI;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;

public class Delhome implements CommandExecutor {

	public String[] atalhos = new String[] { "delcasa" };
    public String desc = "Remover suas homes";
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
			   Format.Comando("§a§lCASA", "/delhome§a nome", jogador);
				return true;
		   }
		   
		   HomeAPI.RemoveHome(jogador, args[0]);
	
		
		return false;
	  }
	

	

}

