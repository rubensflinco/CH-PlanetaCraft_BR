/**
 * 
 */
package me.acf.FullPvP.loja.Venda;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.acf.FormatText.Format;
import me.acf.FullPvP.Conta;
import me.acf.FullPvP.loja.LojaAPI;
import me.acf.FullPvP.loja.Comprar.ComprarAPI;
import me.hub.Main;
import me.site.account.Account;
import me.site.account.AccountWeb;

/**
 * @author adriancf
 *
 */
public class Venda {

	
	
	public static void Venda(Sign s, Player p)
	{

		if (s.getLine(0).contains("[Loja]"))
        {
		  if (s.getLine(3).equalsIgnoreCase("Free"))
	        {
    
			  ItemStack item = LojaAPI.restore(LojaAPI.GerarID(s.getLocation()));
			
			  if (inventoryContainsItem(p.getInventory(),item))
			  {
			  p.getInventory().removeItem(item);
			  Format.Comando("Loja", "Você acaba de vender o ID " + s.getLine(2) , p);
			  }
			  else
			  {
				  Format.Erro("Você não tem itens para vender", p);
			  }
			  return;
			  }
		  else
		  {
			  ItemStack item = LojaAPI.restore(LojaAPI.GerarID(s.getLocation()));
				if (ComprarAPI.Venda(item, p.getInventory(), p))
				{
				  
				  int total = totaldesteitem(p.getInventory(), item);
				  int contidade = item.getAmount()-1; 
				  try {
					  String v = "" + s.getLine(3);
			if (numeros(v)) {
				  
			  p.getInventory().removeItem(item);
			  Format.Comando("Loja", "Você acaba de vender o ID " + s.getLine(2) , p);
			  
			  if(AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=ADD-dinheiro&nick=" + p.getName() + "&quantidade=" + s.getLine(3)).contains("OK"))
			  {
				  
			  }
			 
			  try {
			  Account.UpdateAccount(p);
			  Conta.Reload(p);
			  }
			  catch (Exception ex)
			  {
				  
			  }
			}
			else
			{
				Format.Erro("Valor da venda não é valido", p);
			}
				  } catch (Exception e) {
					  Format.Erro("Tem algum erro nesta loja", p);
					  e.printStackTrace();
				  }
				  
			  }
			  else
			  {
				  Format.Erro("Você não tem itens para vender", p);
			  }
		  }
		  return;
        }    
		Location loc = s.getLocation().clone().add(0,-1,0);
		if (loc.getBlock().getType() == Material.CHEST)
		{
			try {
			Chest chest = (Chest)loc.getBlock().getState();
			ItemStack item = LojaAPI.restore(LojaAPI.GerarID(s.getLocation()), "" + s.getLine(0));
			if (ComprarAPI.Venda(item, p.getInventory(), p))
			{
                           if (AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=REMOVE-dinheiro&nick=" + s.getLine(0) + "&quantidade=" + s.getLine(3),"OK").contains("OK"))
                           {
                        	   
                           }
				  if(AccountWeb.Conectar(Main.site + "/API/MG/FP.php?modo=ADD-dinheiro&nick=" + p.getName() + "&quantidade=" + s.getLine(3),"OK").contains("OK"))
				  {
					  
				  }
					  Conta.Loader(s.getLine(3));
				  if (Integer.parseInt(Conta.fpcoinso.get(s.getLine(3))) < Integer.parseInt(s.getLine(3)))
					{
						  Format.Erro("Tem algum erro nesta loja", p);
						return;
					}
				  chest.getInventory().addItem(item);
				p.getInventory().removeItem(item);
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
				Format.Erro("Você não tem item para vender", p);
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
	
	
	private static int totaldesteitem(Inventory inventory, ItemStack compareItem)
	{
    int id = compareItem.getTypeId();
    short data = compareItem.getDurability();
    int total = 0;
    for(ItemStack item : inventory.getContents())
    {
        if(item != null && item.getTypeId() == id && item.getDurability() == data)
        total = total + item.getAmount();
    	
    	}
    return total;
}
	private static boolean inventoryContainsItem(Inventory inventory, ItemStack compareItem)
	{
	    int id = compareItem.getTypeId();
	    short data = compareItem.getDurability();
	 
	    for(ItemStack item : inventory.getContents())
	    {
	    	   if(item != null && item.getTypeId() == id && item.getDurability() == data && compareItem.getItemMeta() == null) {
		       if (item.getItemMeta() == null)
	    		   return true;
	    	   
	    	   }
	        if(item != null && item.getTypeId() == id && item.getDurability() == data)
	        {
	        	if (item.getItemMeta() != null) {
	        	if (item.getItemMeta().equals(compareItem.getItemMeta()))
	        		return true;
	        	}
	        }
	        }
	 
	    return false;
	}
}
