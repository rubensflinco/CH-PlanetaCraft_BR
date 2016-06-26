/**
 * 
 */
package me.hub.loja.event;

import org.bukkit.entity.Player;
import org.json.JSONObject;

import me.hub.loja.Shop;
import me.hub.loja.ShopLog.ShopSave;

/**
 * @author adriancf
 *
 */
public class InventoryShopCancellEvent {

	private Player p;
	private JSONObject obj;
	public InventoryShopCancellEvent(Player p)
	{
		this.p = p;
		this.obj = new JSONObject(Shop.shops.get(p));
	}
	
	public void SetarCancell()
	{
		  ShopSave.SetarPendente(obj.getString("ID"), "Cancelado");
		  Shop.shops.remove(p);
	}
	
	public Player getPlayer()
	{
		return p;
	}
	
    public JSONObject getJson()
    {
    	return obj;
    }
}
