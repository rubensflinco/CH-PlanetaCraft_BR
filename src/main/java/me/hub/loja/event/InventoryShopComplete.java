/**
 * 
 */
package me.hub.loja.event;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.json.JSONObject;

import me.acf.FormatText.Format;
import me.acf.lobby.extend.Scoreboard;
import me.hub.Main;
import me.hub.API.Util.UtilInv;
import me.hub.Scoreboard.ScoreboardAPI;
import me.hub.loja.Shop;
import me.hub.loja.ShopLog.ShopSave;
import me.site.account.Account;
import me.site.account.AccountWeb;

/**
 * @author adriancf
 *
 */
public class InventoryShopComplete {

	private Player p;
	private JSONObject obj;
	private Inventory inv;
	public InventoryShopComplete(Player p, Inventory inv)
	{
		this.p = p;
		this.obj = new JSONObject(Shop.shops.get(p));
		this.inv = inv;
	}
	
	public void Verificar()
	{
	  String tipo = obj.getString("Item");
	  if (tipo.equals("Cash"))
	  {
		if(Comprar(obj.getInt("Valor"), obj.getString("Formato")))
		{
			  ShopSave.SetarPendente(obj.getString("ID"), "Completo");
			  Account.AddCash(p, obj.getInt("Total"));
			  Format.Comando("SHOP", "Você completo sua compra com exito. §6ID: " + obj.getString("ID"), p);
				try {
					for (int error = 0; 0 <= 53; error++) {
						if (error <= 53)
							UtilInv.AddItem(inv, false, 133,1,(byte) 0, "§a§lCompleto","§5§oCompra completa", error);			
						else
							break;
						}
					}
					catch (Exception exception)
				    {
				    }
				Shop.shops.remove(p);
			    Account.UpdateAccount(p);
			    ScoreboardAPI.remover(p);
			  return;
		}
		else {
		InventoryShopErrorEvent error = new InventoryShopErrorEvent(p,this.inv);
		error.CriarErro("Você não tem saldo para isto!");
		error.OpenErro();
		ShopSave.SetarPendente(obj.getString("ID"), "ERRO");
		ShopSave.SetarErro(obj.getString("ID"), "Sem saldo para isto!");
		  Format.Comando("SHOP", "Sua compra tem erros. §6ID: " + obj.getString("ID"), p);
		  Shop.shops.remove(p);
		}
	  }
	  if (tipo.equals("Chaves"))
	  {
		if(Comprar(obj.getInt("Valor"), obj.getString("Formato")))
		{
			  ShopSave.SetarPendente(obj.getString("ID"), "Completo");
			  Account.AddChave(p, obj.getInt("Total"));
			  Format.Comando("SHOP", "Você completo sua compra com exito. §6ID: " + obj.getString("ID"), p);
				try {
					for (int error = 0; 0 <= 53; error++) {
					if (error <= 53)
						UtilInv.AddItem(inv, false, 133,1,(byte) 0, "§a§lCompleto","§5§oCompra completa", error);			
					else
						break;
					}
					
					}
					catch (Exception exception)
				    {
				    }
				Shop.shops.remove(p);
			    Account.UpdateAccount(p);
			    ScoreboardAPI.remover(p);
			  return;
		}
		else {
		InventoryShopErrorEvent error = new InventoryShopErrorEvent(p,this.inv);
		error.CriarErro("Você não tem saldo para isto!");
		error.OpenErro();
		ShopSave.SetarPendente(obj.getString("ID"), "ERRO");
		ShopSave.SetarErro(obj.getString("ID"), "Sem saldo para isto!");
		  Format.Comando("SHOP", "Sua compra tem erros. §6ID: " + obj.getString("ID"), p);
		  Shop.shops.remove(p);
		}
	  }
	  
	}
	
	private boolean Comprar(int valor,String moeda)
	{
	
		if (moeda.equals("Cash"))
		{

			String buscar = AccountWeb.Conectar(Main.site + "/API/cash.php?modo=VENDA&nick=" + p.getName() + "&quantidade=" + valor);
       if (buscar.contains("OK"))
		    return true;
		}
		if (moeda.equals("Planets"))
		{
			String buscar = AccountWeb.Conectar(Main.site + "/API/planets.php?modo=VENDA&nick=" + p.getName() + "&quantidade=" + valor);
			  if (buscar.contains("OK"))
		    return true;
		}
		if (moeda.equals("Coins"))
		{
		}
		
		
		return false;
	}
}
