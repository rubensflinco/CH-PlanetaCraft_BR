/**
 * 
 */
package me.hub.loja.ShopLog;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.json.JSONObject;

import me.site.account.Account;

/**
 * @author adriancf
 *
 */
public class ShopSave {

	public static File file;
	
	public static void ShopCriar()
	{
		  file = new File("plugins/CHub/Shop");
		  if(!file.isDirectory()) {
			 file.mkdir();
		  }
	}
	
	public static void SetarErro(String shop, String pendente)
	{
		 try {
		  File file = new File("plugins/CHub/Shop/" + shop + ".yml");
		  if(!file.exists())
		  {
			 return;
		  }
		  
		  YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		  cfg.set("Shop.ERRO", pendente);
		  cfg.save(file);
		  
		} catch (IOException e) {
          e.printStackTrace();
		}
	}
	
	public static void SetarPendente(String shop, String pendente)
	{
		 try {
		  File file = new File("plugins/CHub/Shop/" + shop + ".yml");
		  if(!file.exists())
		  {
			 return;
		  }
		  
		  YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		  cfg.set("Shop.status", pendente);
		  cfg.save(file);
		  
		} catch (IOException e) {
          e.printStackTrace();
		}
	}
	
	public static void CriarSaveShop(String shop)
	{
		  try {
			  JSONObject obj = new JSONObject(shop);
		  File file = new File("plugins/CHub/Shop/" + obj.getString("ID") + ".yml");
		  if(!file.exists())
		  {
			  file.createNewFile();
		  }
		  
		  YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		  cfg.set("Shop.UUID", obj.getString("ID"));
		  cfg.set("Shop.status", "Pendente");
		  cfg.set("Shop.comprador",obj.getString("Comprador"));
		  cfg.set("Shop.vendedor", obj.getString("Vendedor"));
		  cfg.set("Shop.info.Item", obj.getString("Item"));
          cfg.set("Shop.info.Valor", "" + obj.getInt("Valor"));
          cfg.set("Shop.info.Total", "" + obj.getInt("Total"));
          cfg.set("Shop.info.Formato", "" + obj.getString("Formato"));
		  System.out.println("Salvando configs shop " + obj.getString("ID"));
          cfg.save(file);
		  
		} catch (IOException e) {
           e.printStackTrace();
		}
	}
}
