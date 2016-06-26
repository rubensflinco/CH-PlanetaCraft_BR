/**
 * 
 */
package me.acf.lobby.loja;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.Menu;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;
import me.hub.loja.ProdutosType;
import me.hub.loja.Shop;
import me.hub.loja.ShopType;

/**
 * @author adriancf
 *
 */
public class Loja extends MiniPlugin {
	
	public Loja(JavaPlugin plugin)
	{
		super("Loja", plugin);
		Shop shop = new Shop(plugin);
		Chaves.put("§b§l1 Chave", UtilInv.AddItemReturn(Material.TRIPWIRE_HOOK, 1, (byte)0, "§b§l1 Chave", "§7Valor:§6§l 7500 Planets"));
		///Cash
		Cash.put("§b§l1k Cash", UtilInv.AddItemReturn(175, 1, (byte)0, "§b§l1k Cash", "§7Valor:§6§l 4000 Planets"));
	}
	
	public static Map<String, ItemStack> Chaves = new HashMap<String, ItemStack>();
	public static Map<String, ItemStack> Cash = new HashMap<String, ItemStack>();
	
	@EventHandler
	public void Abrir(PlayerInteractEvent e)
	{
		Player jogador = e.getPlayer();
	    if (jogador.getGameMode() == GameMode.CREATIVE)
	      return;
	    if (e.getItem() == null)
	      return;
	    if (e.getItem().getItemMeta().getDisplayName() == null)
	      return;

	    if ((e.getItem().getType() == Material.SKULL_ITEM) && (e.getItem().getItemMeta().getDisplayName().equals("§b" + jogador.getCustomName())))
	    {
	      e.setCancelled(true);
	      me.acf.lobby.loja.Menu.GadgetsOPEN(jogador);
	    }
	}
	
	  @EventHandler
	  public void Iventarioitens(InventoryClickEvent e)
	  {
	    Player jogador = (Player)e.getWhoClicked();
	    try {
	    if ((e.getInventory().getTitle().contains("Shop.")) && 
	    	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	    	    {
	   
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§b§lChaves"))
	      	        {
	    	    	  e.getInventory().clear();
	    	    	  me.acf.lobby.loja.Menu.Pagina(e.getInventory(), "Chaves");
	    	    	  }
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§b§lComprar Economia(cash)"))
		      	        {
		    	    	  e.getInventory().clear();
		    	    	  me.acf.lobby.loja.Menu.Pagina(e.getInventory(), "Cash");
		    	    	  }
	    	    	  Verificar(e.getCurrentItem().getItemMeta().getDisplayName(),e.getCurrentItem().getAmount(), jogador);
	    	      
	    	    }
	    
	  } catch (Exception e1) {
	  }
	  }
	
	private void Verificar(String nome,int total , Player jogador)
	{
		if (nome.contains("Chave"))
		{
			int contia = total;
			int valor = contia*1500;
			jogador.sendMessage("" + contia + " " + valor);
			Shop.CriarLoja(ProdutosType.Chaves, contia, valor, ShopType.Planets, jogador);
			return;
		}
		if (nome.contains("Cash"))
		{
			int contia = total*1000;
			int valor = contia*15000;
			jogador.sendMessage("" + contia + " " + valor);
			Shop.CriarLoja(ProdutosType.Cash, contia, valor, ShopType.Planets, jogador);
		}
	}
	

}
