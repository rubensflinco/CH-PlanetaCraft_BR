package me.acf.FullPvP.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FullPvP.Teleport;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;

public class shop implements CommandExecutor {

	public String[] atalhos = new String[] { "loja" };
    public String desc = "Ir para loja";
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		   if (ComandosAPI.VerConsole(sender).equals("sim"))
		   {
			   sender.sendMessage(Message.Console_Não);
  			   return true;
		   }
		  
		   final Player jogador = (Player) sender;
		   
		   Teleport.TeleportTempo(new Location(Bukkit.getWorld("world"),100, 100, -21 ), jogador);
		   
		return false;
	  }
	
	

	

}

