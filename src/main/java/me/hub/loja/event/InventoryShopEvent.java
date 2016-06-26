/**
 * 
 */
package me.hub.loja.event;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.hub.Main;
import me.hub.API.Util.UtilInv;

/**
 * @author adriancf
 *
 */
public class InventoryShopEvent {

	private Player comprador;
    private ArrayList<Integer> slots = new ArrayList<>();
	private Inventory inventario;
	
	public InventoryShopEvent(Player p)
	{
		this.comprador = p;
		SlotsNaoAdd();
		Inventory inv = Bukkit.getServer().createInventory(p, 54, "Pagamento");
		inventario = inv;
	    CriarInventario();
	    openInventario();
	}
	/**
	 * @return retornar com o comprador
	 */
	public Player getComprador() {
		return comprador;
	}

	/**
	 * @comprador setar o jogador como comprador do produto
	 */
	public void setComprador(Player comprador) {
		this.comprador = comprador;
	}
	
	public void CriarInventario()
	{
		 comprador.closeInventory();
	     Bukkit.getScheduler().runTaskLaterAsynchronously(Main.plugin, new Runnable() {
	            @Override
	            public void run() {
	       	     AddCancel(inventario);
	       AddBuy(inventario);	     
	     
	            }
	            }, 10);
	}
	
	private void AddBuy(Inventory inv)
	{
		
		for (int buy = 9; 0 <= 39; buy++)
		{
			if (!slots.contains(buy)) {
				if (buy <= 39)
				{
			  UtilInv.AddItem(inv, false, Material.STAINED_CLAY,1,(byte)5, "§a§lComprar", buy);	
				}
				else
				{
					break;
				}
				if ((buy == 12) || (buy == 21) || (buy == 30))
			      buy = buy+5;
				  slots.add(buy);
				}
			}
	}
	
	private void AddCancel(Inventory inv)
	{
		for (int cancel = 9; 0 <= 45; cancel++)
		{
			if (!slots.contains(cancel)) {
				if (cancel <= 44)
				{
					  if ((cancel == 9) || (cancel == 18) || (cancel == 27) || (cancel == 36))
							cancel = cancel+5;
				  UtilInv.AddItem(inv, false, Material.STAINED_CLAY,1,(byte)14, "§c§lCancelar", cancel);	
				  slots.add(cancel);
				}
				else
				{
					break;
				}
				}
		}
	}
	
	private void SlotsNaoAdd()
	{
		slots.add(13);
		slots.add(22);
		slots.add(31);
		slots.add(40);
		slots.add(49);
	}
	
	public Inventory getInventario()
	{
		return inventario;
	}
	
	public void openInventario()
	{
		comprador.openInventory(inventario);
	}
	
	public InventoryShopErrorEvent CriarErro()
	{
		return new InventoryShopErrorEvent(comprador, inventario);
	}
	
	public void AddInfo(String info)
	{
		  UtilInv.AddItem(inventario, false, 175,1,(byte) 0, "§e" + info, 4);	
	}
}
