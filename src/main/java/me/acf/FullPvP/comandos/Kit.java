package me.acf.FullPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.API.KitAPI;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.hub.recharge.Recharge;

public class Kit implements CommandExecutor {

	public String[] atalhos = new String[] { "kits" };
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
			   Format.Comando(" §a§lKit", "Seus kits: \n §a§lKit §c- §f/kit §a" + KitAPI.SeusKits(jogador).replace(",", "\n §a§lKit §c- §f/kit §a"), jogador);
				return true;
		   }
		   KitAPI.GiveKit(args[0], jogador);
		return false;
	  }
}

