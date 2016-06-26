package me.acf.lobby.gadgets;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.hub.Main;
import me.hub.API.Enchant;
import me.hub.publicidade.PublicidadeMananger;

public class Menu {
	
    public static void GadgetsOPEN(Player p)
    {
      Inventory inv = Bukkit.getServer().createInventory(p, 54, "Personalizar.");
      
      AddItem(inv, false, Material.POTION,1,(byte) 0, "§aEfeitos", "§ePersonalize seu jogador com nossas particulas", 9);
      AddItem(inv, false, Material.BANNER,1,(byte) 0, "§aCapas", "§ePersonalize seu jogador com nossas capas", 11);
      AddItem(inv, false, Material.BOW,1,(byte) 0, "§aGadgets", "§eVários utilitarios para você usar", 22);
      AddItem(inv, false, Material.SADDLE,1,(byte) 0, "§aMontaria", "§eMonte em nossas montarias", 15);
      AddItem(inv, false, Material.MONSTER_EGG,1,(byte) 67, "§aMorph", "§eVocê pode disfarçar", 17);
      AddItem(inv, false, Material.BONE,1,(byte) 0, "§aPet", "§eTenha um pet de seguindo", 27);
      AddItem(inv, false, Material.JUKEBOX,1,(byte) 0, "§aMusic", "§eToque varias musicas pelo servidor", 29);
      AddItem(inv, false, Material.GOLD_CHESTPLATE,1,(byte) 0, "§aArmaduras", "§eVista armaduras em seu personagem", 33);
    
      
      PublicidadeMananger publ = new PublicidadeMananger(inv, p);
     
      
    
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
    	if (pagina.contains("Pet"))
    	{
            for (String gadgets : Pet.gadgets.keySet()) {
            	if (slot < 34)
            	{
               	 inv.setItem(slot, (ItemStack)Pet.gadgets.get(gadgets));
            	}
            	 slot++;
            	 if ((slot == 17) || (slot == 26))
            		 slot = slot + 2;
            }
          	 for (int slot_Inicial = slot; slot_Inicial < 34; slot_Inicial++)
  	        {
    		  if ((slot_Inicial == 17) || (slot_Inicial == 26))
 			  slot_Inicial = slot_Inicial+2;
         	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
         }
    	}
    	if (pagina.contains("Music"))
    	{
            for (String gadgets : Music.gadgets.keySet()) {
            	if (slot < 34)
            	{
               	 inv.setItem(slot, (ItemStack)Music.gadgets.get(gadgets));
            	}
            	 slot++;
            	 if ((slot == 17) || (slot == 26))
            		 slot = slot + 2;
            }
          	 for (int slot_Inicial = slot; slot_Inicial < 34; slot_Inicial++)
  	        {
    		  if ((slot_Inicial == 17) || (slot_Inicial == 26))
 			  slot_Inicial = slot_Inicial+2;
         	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
         }
    	}
    	if (pagina.contains("Morph"))
    	{
            for (String gadgets : Morph.gadgets.keySet()) {
            	if (slot < 34)
            	{
               	 inv.setItem(slot, (ItemStack)Morph.gadgets.get(gadgets));
            	}
            	 slot++;
            	 if ((slot == 17) || (slot == 26))
            		 slot = slot + 2;
            }
          	 for (int slot_Inicial = slot; slot_Inicial < 34; slot_Inicial++)
  	        {
    		  if ((slot_Inicial == 17) || (slot_Inicial == 26))
 			  slot_Inicial = slot_Inicial+2;
         	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
         }
    	}
    	if (pagina.contains("Efeitos"))
    	{
            for (String gadgets : Particles.Efeitos.keySet()) {
            	if (slot < 34)
            	{
               	 inv.setItem(slot, (ItemStack)Particles.Efeitos.get(gadgets));
            	}
            	 slot++;
            	 if ((slot == 17) || (slot == 26))
            		 slot = slot + 2;
            }
          	 for (int slot_Inicial = slot; slot_Inicial < 34; slot_Inicial++)
  	        {
    		  if ((slot_Inicial == 17) || (slot_Inicial == 26))
 			  slot_Inicial = slot_Inicial+2;
         	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
         }
    	}
    	if (pagina.contains("Capas"))
    	{
            for (String gadgets : Particles.gadgets.keySet()) {
            	if (slot < 34)
            	{
               	 inv.setItem(slot, (ItemStack)Particles.gadgets.get(gadgets));
            	}
            	 slot++;
            	 if ((slot == 17) || (slot == 26))
            		 slot = slot + 2;
            }
          	 for (int slot_Inicial = slot; slot_Inicial < 34; slot_Inicial++)
  	        {
    		  if ((slot_Inicial == 17) || (slot_Inicial == 26))
 			  slot_Inicial = slot_Inicial+2;
         	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
         }
    	}
    	if (pagina.contains("Montaria"))
    	{
            for (String gadgets : Mount.Mount.keySet()) {
            	if (slot < 34)
            	{
               	 inv.setItem(slot, (ItemStack)Mount.Mount.get(gadgets));
            	}
            	 slot++;
            	 if ((slot == 17) || (slot == 26))
            		 slot = slot + 2;
            }
          	 for (int slot_Inicial = slot; slot_Inicial < 34; slot_Inicial++)
  	        {
    		  if ((slot_Inicial == 17) || (slot_Inicial == 26))
 			  slot_Inicial = slot_Inicial+2;
         	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
         }
    	}
    	if (pagina.contains("Gadgets"))
    	{
    	
        for (String gadgets : Gadgets.gadgets.keySet()) {
        	 if ((ItemStack)Gadgets.gadgets.get(gadgets) != null)
             {
        
        		  if ((slot == 17) || (slot == 26))
        			  slot = slot+2;
        	 inv.setItem(slot, (ItemStack)Gadgets.gadgets.get(gadgets));
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
