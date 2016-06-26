/**
 * 
 */
package me.acf.lobby.loja;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.Morph;
import me.acf.lobby.gadgets.Mount;
import me.acf.lobby.gadgets.Music;
import me.acf.lobby.gadgets.Particles;
import me.acf.lobby.gadgets.Pet;
import me.hub.Main;
import me.hub.API.Enchant;
import me.hub.publicidade.PublicidadeMananger;

/**
 * @author adriancf
 *
 */
public class Menu {

    public static void GadgetsOPEN(Player p)
    {
      Inventory inv = Bukkit.getServer().createInventory(p, 54, "Shop.");
      
      AddItem(inv, false, Material.ENDER_CHEST,1,(byte) 0, "§b§lChaves", "§eCompre chaves para abrir os Magic Chest e os EndMagic", 9);
      AddItem(inv, false, 175,1,(byte) 0, "§b§lComprar Economia(cash)", "§eCompre seus cash para ter vantagens", 13);
     
      PublicidadeMananger publ = new PublicidadeMananger(inv, p);  
    }
    
    private static void AddItem(Inventory inv, boolean encantado, int item,int contidade, byte data,String nome, String meta, int slot)
    {
    	      ItemStack bau = new ItemStack(item, contidade , data);
    	      ItemMeta metae = bau.getItemMeta();
    	      metae.setDisplayName(nome);
    	      ArrayList<String> desce = new ArrayList();
    	      desce.add(meta);
    	      metae.setLore(desce);
    	      bau.setItemMeta(metae);
    	      if (encantado)
    	      inv.setItem(slot, Enchant.addGlow(bau));
    	      else
    	          inv.setItem(slot, bau);
    }
    private static void AddItem(Inventory inv, boolean encantado, Material item,int contidade, byte data,String nome, String meta, int slot)
    {
    	      ItemStack bau = new ItemStack(item, contidade , data);
    	      ItemMeta metae = bau.getItemMeta();
    	      metae.setDisplayName(nome);
    	      ArrayList<String> desce = new ArrayList();
    	      desce.add(meta);
    	      metae.setLore(desce);
    	      bau.setItemMeta(metae);
    	      if (encantado)
    	      inv.setItem(slot, Enchant.addGlow(bau));
    	      else
    	          inv.setItem(slot, bau);
    }
    
    public static void Pagina(final Inventory inv, final String pagina)
    {
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.plugin, new Runnable() {
            @Override
            public void run() {
         
   
                try {
    	int slot = 10;
    	if (pagina.contains("Chaves"))
    	{
    	
        for (String gadgets : Loja.Chaves.keySet()) {
        	 if ((ItemStack)Loja.Chaves.get(gadgets) != null)
             {
        
        		  if ((slot == 17) || (slot == 26))
        			  slot = slot+2;
        	 inv.setItem(slot, (ItemStack)Loja.Chaves.get(gadgets));
               slot++;                  
        	
        }
        	 for (int slot_Inicial = slot; slot_Inicial < 34; slot_Inicial++)
 	        {
   		  if ((slot_Inicial == 17) || (slot_Inicial == 26))
			  slot_Inicial = slot_Inicial+2;
        	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
        }
    	}
    	}
       	if (pagina.contains("Cash"))
    	{
    	
        for (String gadgets : Loja.Cash.keySet()) {
        	 if ((ItemStack)Loja.Cash.get(gadgets) != null)
             {
        
        		  if ((slot == 17) || (slot == 26))
        			  slot = slot+2;
        	 inv.setItem(slot, (ItemStack)Loja.Cash.get(gadgets));
               slot++;                  
        	
        }
        	 for (int slot_Inicial = slot; slot_Inicial < 34; slot_Inicial++)
 	        {
   		  if ((slot_Inicial == 17) || (slot_Inicial == 26))
			  slot_Inicial = slot_Inicial+2;
        	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
        }
    	}
    	}
                
            } catch (Exception e) {
  		      
  		    }
        
            }
           }, 10);
        
    }
}
