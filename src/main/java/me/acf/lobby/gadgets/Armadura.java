package me.acf.lobby.gadgets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.armor.Armor;
import me.hub.Main;
import me.hub.MiniPlugin;

public class Armadura extends MiniPlugin  {

	
	public static Map<Player, String> MophU = new HashMap<Player, String>();
	public static Map<String, ItemStack> gadgets = new HashMap<String, ItemStack>();
	public Main main;
	public Armadura(JavaPlugin plugin) {
		super("Armadura", plugin);
	}
	
    
    @EventHandler
    public void onUpdate(PlayerQuitEvent e)
    {
    	MophU.remove(e.getPlayer());
    }
    
    
	  @EventHandler
	  public void Iventarioitens(InventoryClickEvent e)
	  {
	    Player jogador = (Player)e.getWhoClicked();
	    if (jogador.getGameMode() == GameMode.CREATIVE)
		      return;
	    try {
	    if ((e.getInventory().getTitle().contains("Personalizar.")) && 
	    	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	    	    {
	    	      if (e.getSlot() == 33)
	    	      {
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Armaduras"))
	      	        {
	    	    	  e.getInventory().clear();
	    	    	  
	    	    	  Armor.Criar(e.getInventory());
	    	    	  }
	    	      
	    	      }
                      Armor.Vestir(e.getCurrentItem(), jogador);
	    	    }
	    } catch (Exception e1) {
		  }
	  }
	  

	  
	
	  
}
