package me.acf.FullPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.Teleport;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.hub.recharge.Recharge;

public class ftpaccept implements CommandExecutor {
	 
	 
    public String[] atalhos = new String[] { "tpa-sim","tpaccept","tpasim" };
    public String desc = "Teleportar para algum jogador";

    
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
      {
               if (ComandosAPI.VerConsole(sender).equals("sim"))
               {
            	   sender.sendMessage(Message.Console_Não);
                       return true;
               }
               final Player jogador = (Player) sender;
        	  
       	  
       	    
       			if (ftpa.teleport.containsKey(jogador.getName()))
       			{
       			  if (!Recharge.Instance.use(jogador, "TP-Sim", 1000L, false, false)) {
  			        return true;
  			      }


       			 jogador.sendMessage("§a§lTeleporte aceito");
       			 Teleport.TeleportTempo(jogador.getLocation(), ftpa.teleport.get(jogador.getName()));
  			     ftpa.teleport.remove(jogador.getName());
      
       			}
       			else
       			{
       				Format.Erro("Você não tem teleportes!", jogador);
       			}
       			
    		   
        	   return false;
      }
}