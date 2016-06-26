/**
 * 
 */
package me.hub.loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;

import me.acf.FormatText.Format;
import me.hub.MiniPlugin;
import me.hub.loja.ShopLog.ShopSave;
import me.hub.loja.event.InventoryShopCancellEvent;
import me.hub.loja.event.InventoryShopCheck;

/**
 * @author adriancf
 *
 */
public class Shop extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Shop(JavaPlugin plugin) {
		super("Shop", plugin);
       ShopSave.ShopCriar();
	}

	public static HashMap<Player, String> shops = new HashMap<>();
	
	@EventHandler
	public void CloseInv(InventoryCloseEvent event)
	{
		try {
		if (event.getInventory().getTitle().contains("Pagamento"))
		{
			
			  Player p = (Player) event.getPlayer();
			  InventoryShopCancellEvent can = new InventoryShopCancellEvent(p);
			  can.SetarCancell();
		}
		
	 } catch (Exception e) {
	 }
	 }
	
	public static void CriarLoja(ProdutosType item, int total ,int valor, ShopType formato, Player jogador)
	{
		ShopManager shop = new ShopManager(item,total,valor,formato,jogador);
	}
	
	  @EventHandler
	  public void Iventarioitens(InventoryClickEvent e)
	  {
	    Player jogador = (Player)e.getWhoClicked();

	    if ((e.getInventory().getTitle().contains("Pagamento")) && 
	    	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	    	    {
	    	     InventoryShopCheck check = new InventoryShopCheck(jogador, e.getCurrentItem(), e.getInventory());
	    	    }
	    	    }
	  
	  @EventHandler
	  public void Sair(PlayerQuitEvent event)
	  {
			Shop.shops.remove(event.getPlayer());
	  }
	  
	  
	  
}
