package me.acf.FullPvP.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.loja.LojaAPI;
import me.acf.lobby.patentes.Patente;
import me.hub.Main;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.site.account.Account;
import me.site.account.AccountWeb;

public class Loja implements CommandExecutor {

	public String[] atalhos = new String[] { "shop" };
    public String desc = "Ver os comandos de loja";
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
			   Format.Comando("§aLoja", " -  Comandos", jogador);
			   jogador.sendMessage(" ");
			   jogador.sendMessage("§a/loja set §7 - Setar sua loja.");
			   jogador.sendMessage("§a/loja warp <jogador>§7 - teleportar para uma loja");
			   jogador.sendMessage("§a/loja remove §7 - remover sua loja");
			   jogador.sendMessage("§a/loja anuncio §7 - Anunciar sua loja");
				return true;
		   }
		   
		   if (args.length == 2)
		   {
			   if (args[0].equals("warp"))
			   {
				   LojaAPI.TeleportLoja(args[1], jogador);
				   return true;
			   }
		   }
				   
				   
		   if (args[0].equals("set")) {
			   if ((Account.getPatente(jogador)).Has(jogador, Patente.Ultra, true))
			   {
				try {
			    	 String buscar = AccountWeb.Conectar(Main.site + "/API/cash.php?modo=REMOVE&nick=" + jogador.getName() + "&quantidade=100", "OK");
		        	 System.out.println(buscar);
		      	   LojaAPI.AddLoja(jogador, jogador.getLocation());
				   Format.Comando("§a§lLoja", "Sua loja foi criada", jogador);
			    	}	catch (Exception e) {
			    		Format.Erro("Você não tem 100 CASH para criar sua loja", jogador);
			    	}
			   }
		   return true;
		   }
		   if (args[0].equals("anuncio")) {
			   if ((Account.getPatente(jogador)).Has(jogador, Patente.Ultra, true))
			   {
	    if (LojaAPI.TemLoja(jogador.getName())) {
	    	try {
	    	 String buscar = AccountWeb.Conectar(Main.site + "/API/cash.php?modo=REMOVE&nick=" + jogador.getName() + "&quantidade=500", "OK");
        	 System.out.println(buscar);
        	 Bukkit.broadcastMessage("§9§lLOJA §fVenha para a loja do " + jogador.getCustomName() + " §a/loja warp " + jogador.getName());
	    	}	catch (Exception e) {
	    		Format.Erro("Você não tem 500 CASH para anunciar sua loja", jogador);
	    	}
			   
	    }
	    else
	    {
	    	Format.Erro("Você não tem uma loja para anunciar", jogador);
	    }
			   }
	    return true;
		   }
		   if (args[0].equals("remove")) {
			    if (LojaAPI.TemLoja(jogador.getName())) {
					 LojaAPI.RemoveLoja(jogador);
			    }
			    else
			    {
			    	Format.Erro("Você não tem uma loja para remover", jogador);
			    }
			   return true;
		   }
		   try {
		   LojaAPI.TeleportShop(args[0], jogador);
		   return true;
	  } catch(Exception e)
  	{
  	}	   Format.Erro("Comando de loja não encontrado", jogador);
		return false;
	  
	  }

	

}

