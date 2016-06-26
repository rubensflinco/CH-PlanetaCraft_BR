package me.acf.lobby.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.hub.Main;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.hub.recharge.Recharge;
import me.site.account.Account;
import me.site.account.rank.Rank;

public class tpano implements CommandExecutor {
	 
	 
    public String[] atalhos = new String[] { "tpa-nao","tpa-não","tpadeny" };
    public String desc = "Teleportar para algum jogador";

    
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
      {
               if (ComandosAPI.VerConsole(sender).equals("sim"))
               {
            	   sender.sendMessage(Message.Console_Não);
                       return true;
               }
               final Player jogador = (Player) sender;
        	  
       	  
       	    
       			if (tpa.teleport.containsKey(jogador.getName()))
       			{
       			  if (!Recharge.Instance.use(jogador, "TP-Não", 1000L, false, false)) {
  			        return true;
  			      }
       			 tpa.teleport.get(jogador.getName()).sendMessage("§f§Teleporte negado!");
          	     tpa.teleport.remove(jogador.getName());
         
       			}
       			else
       			{
       				Format.Erro("Ops você não tem teleportes!", jogador);
       			}
       			
    		   
        	   return false;
      }
}