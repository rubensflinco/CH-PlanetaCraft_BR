package me.acf.lobby.comandos;

import me.hub.Main;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.site.account.Account;
import me.site.account.rank.Rank;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class lobby implements CommandExecutor {

	public String[] atalhos = new String[] { "spawn" };
    public String desc = "Ir para o spawn do servidor";
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		   if (ComandosAPI.VerConsole(sender).equals("sim"))
		   {
			   sender.sendMessage(Message.Console_Não);
  			   return true;
		   }
		  
		   final Player jogador = (Player) sender;
		   jogador.sendMessage("§aTeleportando você em 3 segundos.");
		   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			   
			   public void run() {
			      jogador.teleport(Bukkit.getWorld("world").getSpawnLocation());
			     
			   }
			 }, 60L);
		   // 60 L == 3 sec, 20 ticks == 1 sec
			
		   
		
		return false;
	  }
	

	

}

