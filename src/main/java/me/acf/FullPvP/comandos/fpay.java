package me.acf.FullPvP.comandos;

import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.acf.FormatText.Format;
import me.acf.FullPvP.Conta;
import me.hub.Main;
import me.hub.API.Util.message.Message;
import me.hub.Scoreboard.ScoreboardAPI;
import me.hub.comandos.ComandosAPI;
import me.site.account.Account;
import me.site.account.AccountWeb;
import me.site.account.rank.Rank;



public class fpay implements CommandExecutor {

	public String[] atalhos = new String[] { "fpcoinspay" };
    public String desc = "Dar Coins ou Cash para alguem";
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		   if (ComandosAPI.VerConsole(sender).equals("sim"))
		   {
			   sender.sendMessage(Message.Console_Não);
  			   return true;
		   }
		  
		   Player jogador = (Player) sender;

			if (args.length  <= 1)
			{
				
				Format.Comando("PAGAR", "/fpay (jogador) (Valor)", jogador);
				return true;
			}
		
		

	            	try {
	            	int contidade = Integer.parseInt(args[2]);
	           	 int taxa = 0;
	            	if (!(Account.getRank(jogador)).Has(jogador, Rank.VIPM, false)) {
	            	    taxa = contidade/250;
	            	}
	           	    int dinheiro = Integer.parseInt(Conta.fpcoins.get(jogador));
	           	    if (args[1].equals(jogador.getName()))
	           	    {
	           	    	Format.Erro("Você não pode realizar translações com você mesmo ", jogador);
	           	    	return true;
	           	    }
	            	if (dinheiro >= contidade)
	            	{
	            		contidade = contidade-taxa;
	           		 String buscar1 = AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=REMOVE-dinheiro&nick=" + args[1] + "&quantidade=" + contidade, "OK");
	    		     System.out.print(buscar1);
	    		     
		             String buscar = AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=REMOVE-dinheiro&nick=" + jogador.getName() + "&quantidade=" + args[2], "OK");
	            	 System.out.println(buscar);
	    		     
	            	 Conta.Reload(jogador);
	            	 ScoreboardAPI.remover(jogador);
	            	 if (!ComandosAPI.JogadorOnline(args[1]).equals("nao"))
	                 {
	            		 Player donete = Bukkit.getPlayerExact(args[1]);
	            		 Format.Comando("PAGAR", "Você recebeu §6" + NumberFormat.getCurrencyInstance().format(contidade) + " do §a" + jogador.getName() + "§7 taxa de §6" + NumberFormat.getCurrencyInstance().format(taxa).replace("$", "").replace(".00", ""), donete);
		            	 Account.UpdateAccount(donete);
		            	 ScoreboardAPI.remover(donete, "Planets");
	                 }
	            	 
	            	 Format.Comando("PAGAR", "Você acaba de mover §a" + NumberFormat.getCurrencyInstance().format(Integer.parseInt(args[2])) + "§7 de sua conta!".replace("$", "").replace(".00", ""), jogador);
                 Format.Comando("PAGAR", "O jogador §6" + args[1] + "§7 recebeu §6" + NumberFormat.getCurrencyInstance().format(contidade) + "§7 taxa de §6" + NumberFormat.getCurrencyInstance().format(taxa).replace("$", "").replace(".00", ""), jogador);
	            	    
	                 
	            	}
	            	else
	            	{
	            		Format.Erro("Você não tem planets para isto!", jogador);
	            	}
	            	}
	                catch (Exception exception)
	    		    {
	                	Format.Erro("Ocorreu um erro ao realizar esta translação", jogador);
	    		    }
	            
	           
			
			
			
		
		return false;
	  }
	

	

}

