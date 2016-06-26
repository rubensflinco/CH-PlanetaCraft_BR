package me.acf.menu.jogadores;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.acf.lobby.gadgets.Mount;
import me.hub.API.Enchant;
import me.hub.API.Util.UtilServer;
import me.site.account.Account;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Menu {
	
	  public static HashMap<String, Inventory> inventarios = new HashMap();
	
    public static void Jogadores(Player p)
    {
      Inventory inv;
      
      int page = 0;
      ArrayList<String> online = new ArrayList<String>();
      
      
      for (Player jgs : UtilServer.Jogadores())
      {
    	  online.add(jgs.getName());
      }

       int tamanho = 9;

       if (online.size() >= 9)
       {
    	   tamanho = 18;
       }
       if (online.size() >= 18)
       {
    	   tamanho = 27;
       }
       if (online.size() >= 27)
       {
    	   tamanho = 36;
       }
       if (online.size() >= 36)
       {
    	   tamanho = 45;
       }
       if (online.size() >= 45)
       {
    	   tamanho = 54;
       }
      inv = Bukkit.getServer().createInventory(p, tamanho, "Jogadores Online " + online.size());
      inventarios.clear();
      inventarios.put("0", inv);
      int slots = 0;
      
      for (String jogadores : online) {
    	  if (slots >= 45)
    	  {
    		  page++;
    		  AddItem(inv, false, Material.ARROW,1,(byte) 0, "§aProxima pagina " + page +1, "§ePular pagina", 53);
    		  inv = Bukkit.getServer().createInventory(p, 54, "Jogadores " + page);
    		  inventarios.put("" + page, inv);
    		  slots = 0;
    	  }
    	  try {
		    ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		    SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		    Player jog = Bukkit.getPlayerExact(jogadores);
		    String name = Account.getRank(jog).GetTag(true) + "§e " + jog.getName();
		    skullMeta.setOwner(name);
		    skullMeta.setDisplayName(name);
		    skull.setItemMeta(skullMeta);
	        inv.setItem(slots, skull);
    	  }
    	     catch (Exception exception)
		    {
    	   	  AddItem(inv, false, Material.REDSTONE_BLOCK,1,(byte) 0, "§aERRO", "", slots);
		    }
    	  slots++;
    	  
      }
    }
    
    public static void OpenInventario(Player p, String inv)
    {
    	int page = Integer.parseInt(inv)-1;
    	if (page < 0)
    		page = 0;
    	p.openInventory(inventarios.get("" + page));
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
    

}
