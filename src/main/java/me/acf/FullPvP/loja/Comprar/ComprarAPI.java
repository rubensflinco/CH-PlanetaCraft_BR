/**
 * 
 */
package me.acf.FullPvP.loja.Comprar;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.acf.FormatText.Format;

/**
 * @author adriancf
 *
 */
public class ComprarAPI {

	public static boolean Venda(ItemStack s, Inventory inv, Player p)
	{

		 try {
			  ItemStack item = s;
			  if (inventoryContainsItem(inv,item))
			  {
				  int total = totaldesteitem(inv, item);
				  int contidade = item.getAmount()-1; 
			
		
				  if (total <= contidade)
				  {
					  return false;
				  }
				  return true;
			  }
		 } catch (Exception e) {
			  Format.Erro("Tem algum erro nesta loja", p);
		  }
		    return false;
		 
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
