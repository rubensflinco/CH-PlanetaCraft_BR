/**
 * 
 */
package me.hub.loja.event;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.hub.loja.Shop;

/**
 * @author adriancf
 *
 */
public class InventoryShopCheck {

	private Player p;
	private ItemStack item;
	private Inventory inv;
	public InventoryShopCheck(Player p, ItemStack item, Inventory inv)
	{
		this.p = p;
		this.item = item;
		this.inv = inv;
		Verificar();
	}
	
	private void Verificar()
	{
		if (item.getItemMeta().getDisplayName().contains("Comprar"))
		{
			InventoryShopComplete complete = new InventoryShopComplete(p, inv);
			complete.Verificar();
			Shop.shops.remove(p);
		return;
		}
		if (item.getItemMeta().getDisplayName().contains("Cancelar"))
		{
			InventoryShopCancellEvent erro = new InventoryShopCancellEvent(p);
		    erro.SetarCancell();
			Shop.shops.remove(p);
			return;
		}
	}
	
}
