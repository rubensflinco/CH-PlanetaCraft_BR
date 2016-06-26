/**
 * 
 */
package me.hub.loja;

import java.io.File;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.json.JSONObject;

import me.hub.Main;
import me.hub.loja.ShopLog.ShopSave;
import me.hub.loja.event.InventoryShopEvent;

/**
 * @author adriancf
 *
 */
public class ShopManager {

	ProdutosType nome;
	int valor;
	int total;
	ShopType formato;
	Player jogador;	
	public ShopManager(ProdutosType item, int total ,int valor, ShopType formato, Player jogador)
	{
	 this.nome = item;
	 this.valor = valor;
	 this.total = total;
	 this.formato = formato;
	 this.jogador = jogador;
	 
	 System.out.print("Loja> Criando loja para o jogador " + jogador.getName() + " de " + item);
	 Save();
	 SetInventoryShop();
	}
	
	public void SetInventoryShop()
	{
		InventoryShopEvent event = new InventoryShopEvent(jogador);
	    event.AddInfo(nome + " X" + total + " - " + valor + " " + formato.GetTag());
	}
	
	public void Save()
	{
	     Bukkit.getScheduler().runTaskLaterAsynchronously(Main.plugin, new Runnable() {
	            @Override
	            public void run() {
		String id = ""+UUID.randomUUID();
		  File file = new File("plugins/CHub/Shop/" + id + ".yml");
		  if(file.exists())
		  {
			  Random r = new Random();
			  id = id + "" + r.nextInt(9999999);
		  }
		JSONObject json = new JSONObject();
		json.put("Comprador", jogador.getName());
        json.put("Vendedor", "Sistema");
		json.put("ID", id);
	    json.put("Item", nome);
	    json.put("Valor", valor);
	    json.put("Total", total);
	    json.put("Formato", formato);
	    System.out.println("Criando Loja > Shop@"+json.toString());
	    ShopSave.CriarSaveShop(json.toString());
	    Shop.shops.put(jogador, json.toString());
	            }
         }, 10);
	}
	
}
