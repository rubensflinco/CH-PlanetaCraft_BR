package me.acf.FullPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.API.HomeAPI;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;

public class Sethome implements CommandExecutor {

	public String[] atalhos = new String[] { "setcasa" };
    public String desc = "Setar suas homes";
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
			   Format.Comando("§a§lCASA", "/sethome§a nome", jogador);
				return true;
		   }
		   
		   HomeAPI.AddHome(jogador, args[0], jogador.getLocation());
		   Format.Comando("§a§lCASA", "Sua casa§a " + args[0] + "§7 foi criada", jogador);
		
		return false;
	  }
	

	

}

