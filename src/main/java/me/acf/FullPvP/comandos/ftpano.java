package me.acf.FullPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.hub.recharge.Recharge;

public class ftpano implements CommandExecutor {
	 
	 
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
        	  
       	  
       	    
       			if (ftpa.teleport.containsKey(jogador.getName()))
       			{
       			  if (!Recharge.Instance.use(jogador, "TP-Não", 1000L, false, false)) {
  			        return true;
  			      }
       			  jogador.sendMessage("§6§lTeleport negado!");
       			ftpa.teleport.get(jogador.getName()).sendMessage("§6§lTeleporte negado!");
          	     ftpa.teleport.remove(jogador.getName());
         
       			}
       			else
       			{
       				Format.Erro("Ops você não tem teleportes!", jogador);
       			}
       			
    		   
        	   return false;
      }
}