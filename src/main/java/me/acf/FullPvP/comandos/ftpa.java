package me.acf.FullPvP.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.hub.comandos.geral.Fake;
import me.hub.recharge.Recharge;

public class ftpa implements CommandExecutor {
	 
	 
    public String[] atalhos = new String[] { "tpa","tpo","call" };
    public String desc = "Teleportar para algum jogador";
    public static HashMap<String, Player> teleport = new HashMap<String,Player>();
    
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
      {
               if (ComandosAPI.VerConsole(sender).equals("sim"))
               {
            	   sender.sendMessage(Message.Console_Não);
                       return true;
               }
               Player jogador = (Player) sender;
        		   if (args.length  <= 0)
       			{
       				Format.Comando("TPA", "/tpa <Jogador>", jogador);
       		
       				return true;
       			}
       			if (args.length >= 1) {
       				if (args[0].equals(jogador.getName()))
       				{
       					Format.Erro("Você quer ir para você mesmo ???", jogador);
       					return true;
       				}
       			 if (Fake.PFake.containsKey(args[0]))
      		   {
       			    if (!Recharge.Instance.use(jogador, "TP", 10900L, true, false)) {
       			        return true;
       			      }
       			    
       				 Player alvo =  Fake.PFake.get(args[0]);
       				 jogador.sendMessage("§f§lTeleport enviado");
       			     alvo.sendMessage("§f§lJogador §6§l" + jogador.getCustomName() + "§f§l quer ir até você!");
       			     alvo.sendMessage("Para aceitar digite§a§l /tpa-sim ou /tpa-não");
       			     teleport.remove(alvo.getName());
                     teleport.put(alvo.getName(), jogador);     
                     
       				 return true;
      		   }
       				 if (ComandosAPI.JogadorOnline(args[0]).equals("nao"))
                       {
       					 Format.Comando("TPA", "Jogador §a" + args[0] + "§7 não esta online.", jogador);
                       return false;
                       }
       	
       			    if (!Recharge.Instance.use(jogador, "TP", 10900L, true, false)) {
       			        return true;
       			      }
       			    
       				 Player alvo =  Bukkit.getPlayerExact(args[0]);
       			     alvo.sendMessage("§f§lJogador §6§l" + jogador.getName() + " quer ir até você!");
       			     alvo.sendMessage("Para aceitar digite§a§l /tpa-sim ou /tpa-não");
       			     teleport.remove(alvo.getName());
                     teleport.put(alvo.getName(), jogador);      			
       			}
    		   
        	   return false;
      }
}