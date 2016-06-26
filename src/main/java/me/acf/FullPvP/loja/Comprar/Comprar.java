/**
 * 
 */
package me.acf.FullPvP.loja.Comprar;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.acf.FormatText.Format;
import me.acf.FullPvP.Conta;
import me.acf.FullPvP.loja.LojaAPI;
import me.hub.Main;
import me.site.account.Account;
import me.site.account.AccountWeb;

/**
 * @author adriancf
 *
 */
public class Comprar {

	
	
	public static void Comprar (Sign s, Player p)
	{
		if (s.getLine(0).contains("[Loja]"))
        {
		  if (s.getLine(3).equalsIgnoreCase("Free"))
	        {
			  if (p.getInventory().firstEmpty() == -1) {
				  Format.Erro("Seu inventario esta cheio.", p);
				  return;
			  }
			  p.getInventory().addItem(LojaAPI.restore(LojaAPI.GerarID(s.getLocation())));
			  Format.Comando("Loja", "Você acaba de comprar o ID " + s.getLine(2) , p);
			  return;
        }
		  try {
			  if (p.getInventory().firstEmpty() == -1) {
				  Format.Erro("Seu inventario esta cheio.", p);
				  return;
			  }
		  String valor = s.getLine(3);
		  if (numeros(valor)) {
            if (AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=REMOVE-dinheiro&nick=" + p.getName() + "&quantidade=" + s.getLine(3),"OK").contains("OK"))
            {
            	System.out.print("OK");
            }
			Conta.Reload(p);
		  Account.UpdateAccount(p);
		  p.getInventory().addItem(LojaAPI.restore(LojaAPI.GerarID(s.getLocation())));
		  Format.Comando("Loja", "Você acaba de comprar o ID " + s.getLine(2) , p);
		  }
		  else
		  {
			  Format.Erro("Você não tem itens para vender", p);
		  }
		  } catch (Exception e) {
			  Format.Erro("Tem algum erro nesta loja", p);
			  e.printStackTrace();
		  }
		  return;
        }
		Location loc = s.getLocation().clone().add(0,-1,0);
		if (loc.getBlock().getType() == Material.CHEST)
		{
			try {
			Chest chest = (Chest)loc.getBlock().getState();
			ItemStack item = LojaAPI.restore(LojaAPI.GerarID(s.getLocation()), "" + s.getLine(0));
			if (ComprarAPI.Venda(item, chest.getInventory(), p))
			{
				if (Integer.parseInt(Conta.fpcoins.get(p)) < Integer.parseInt(s.getLine(3)))
				{
					  Format.Erro("Tem algum erro nesta loja", p);
					return;
				}
				 if (AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=REMOVE-dinheiro&nick=" + p.getName() + "&quantidade=" + s.getLine(3),"OK").contains("OK"))
				 {}
				 if (AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=ADD-dinheiro&nick=" + s.getLine(0) + "&quantidade=" + s.getLine(3),"OK").contains("OK"))
				 {}
				 chest.getInventory().removeItem(item);
				p.getInventory().addItem(item);
			     Conta.Reload(p);
			     Player vendedor = Bukkit.getPlayer(s.getLine(0));
			     if (vendedor != null)
			     {
			    	 if (vendedor.isOnline())
			    	 {
			    		 Conta.Reload(vendedor);
			    	 }
			     }
			}
			else
			{
				Format.Erro("Esta loja não tem estoque deste item", p);
			}
			 } catch (Exception e) {
				 
			 }
			}
		else
		{
			Format.Erro("Não foi possivel encontrar o bau", p);
		}
	}
	
	   public static boolean numeros(String texto) {  
	        if(texto == null)  
	            return false;  
	        for (char letra : texto.toCharArray())  
	            if(letra < '0' || letra > '9')  
	                return false;  
	        return true;  
	          
	    }  
	
	
}
