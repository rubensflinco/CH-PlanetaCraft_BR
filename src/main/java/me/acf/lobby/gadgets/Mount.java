package me.acf.lobby.gadgets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.loader.HorseLoader;
import me.acf.lobby.gadgets.montaria.HorseEcologist;
import me.acf.lobby.gadgets.montaria.HorseFire;
import me.acf.lobby.gadgets.montaria.HorseHorror;
import me.acf.lobby.gadgets.montaria.HorseIce;
import me.acf.lobby.gadgets.montaria.HorseWater;
import me.hub.MiniPlugin;
import me.site.account.Account;
import me.site.account.rank.Rank;

public class Mount extends MiniPlugin {

	
	public static Map<String, ItemStack> Mount = new HashMap<String, ItemStack>();
	public static Map<String, Class> Ative = new HashMap<String, Class>();
	
	public Mount(JavaPlugin plugin) {
		super("Mount", plugin);
         HorseWater water = new HorseWater(plugin);
         HorseFire fire = new HorseFire(plugin);
         HorseHorror horror = new HorseHorror(plugin);
         HorseIce ice = new HorseIce(plugin);
         HorseEcologist eco = new HorseEcologist(plugin);
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
	    	      if (e.getSlot() == 15)
	    	      {
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Montaria"))
	      	        {
	    	    	  e.getInventory().clear();
	    	    	  Menu.Pagina(e.getInventory(), "Montaria");
	    	    	  }
	    	      }
	    	 
	    	      if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Horse"))
	      	        {
	    	    	  return;
	      	        }
	    	      if ((Account.getRank(jogador)).Has(jogador, Rank.VIP, true))
	   		   {
	    	      if (HorseLoader._Horses.containsKey(jogador))
	    	      {
	    	    	  Gadgets.MsgFormat("Você ja esta em uma montaria!", jogador);
	    	    	  return;
	    	      }
	    	      if (!e.getCurrentItem().getItemMeta().getDisplayName().contains("Horse"))
	    	      return;
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Water"))
	    	      {
	    	    	  HorseWater.activate(jogador);
	    	      }
	    	      if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Fire"))
	    	      {
	    	    	  HorseFire.activate(jogador);
	    	      }
	    	      if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Horror"))
	    	      {
	    	    	  HorseHorror.activate(jogador);
	    	      }
	    	      if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Ice"))
	    	      {
	    	    	  HorseIce.activate(jogador);
	    	      }
	    	      if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Ecologist"))
	    	      {
	    	    	  HorseEcologist.activate(jogador);
	    	      }
	   		   }
	    	    }
	    } catch (Exception e1) {
	    	e1.printStackTrace();
		  }
	  }

}
