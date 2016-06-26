/**
 * 
 */
package me.hub.publicidade;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.hub.MiniPlugin;
import me.site.account.Account;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class Publicidade extends MiniPlugin {

	
	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Publicidade(JavaPlugin plugin) {
		super("Publicidade", plugin);
		// TODO Auto-generated constructor stub
	}

	private static ArrayList<Player> list = new ArrayList<>();
	public static ArrayList<Player> remove = new ArrayList<>();
	public static boolean Verificar(Player p)
	{
		   if ((Account.getRank(p)).Has(p, Rank.VIP, false))
		   {
			   return false;
		   }
	  if (list.contains(p))
	  {
		  return false;
	  }
		return true;
	}
	
	public static void AddPlayer(Player p)
	{
		list.add(p);
	}
	
	@EventHandler
	public void CloseInv(InventoryCloseEvent event)
	{
		if (event.getInventory().getTitle().contains("Publicidade."))
		{
			remove.add((Player) event.getPlayer());
		}
	}
}
