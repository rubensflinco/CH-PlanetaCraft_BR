/**
 * 
 */
package me.hub.loja.event;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.hub.API.Util.UtilInv;

/**
 * @author adriancf
 *
 */
public class InventoryShopErrorEvent {

	private Player comprador;
	private Inventory inv;
    private String erro;
	public InventoryShopErrorEvent(Player jogador, Inventory inv)
	{
		this.comprador = jogador;
		this.inv = inv;
	}
	
	public void CriarErro(String erro)
	{
		this.erro = erro;
		inv.clear();
		try {
		for (int error = 0; 0 <= 53; error++) {
		if (error <= 53)
			UtilInv.AddItem(inv, false, 152,1,(byte) 0, "§cERRO",erro, error);			
		else
			break;
		}
		}
		catch (Exception exception)
	    {
			
	    }
		}
	
	public void OpenErro()
	{
		comprador.openInventory(inv);
	}
	
	
	public String GetErro()
	{
		return erro;
	}
	
	public Player getPlayer()
	{
		return comprador;
	}
}
