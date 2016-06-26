/**
 * 
 */
package me.acf.KitPvP.armor;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.hub.API.Util.UtilInv;
import me.hub.config.Config;

/**
 * @author adriancf
 *
 */
public class Armor {

	
	public static void Armor_res(Player p)
	{
	try {
     if (Config.retornar(p, "kitpvp.armadura").contains("sim"))
     {
 		UtilInv.restore_armor(p); 
     }
	}
	catch (Exception e) 
     {
    	 Config.Set(p, "kitpvp.armadura", "sim");
         if (Config.retornar(p, "kitpvp.armadura") == null)
         {
    	 p.getInventory().setHelmet(armor(Material.LEATHER_HELMET,"Capacete de Couro"));
    	 p.getInventory().setChestplate(armor(Material.LEATHER_CHESTPLATE,"Peitoral de Couro"));
    	 p.getInventory().setLeggings(armor(Material.LEATHER_LEGGINGS,"Calça de Couro"));
    	 p.getInventory().setBoots(armor(Material.LEATHER_BOOTS, "Bota de Couro"));
    	 UtilInv.save(p);
         }
     }
	}
	
	public static void Armor(Player p)
	{
	try {
     if (Config.retornar(p, "kitpvp.armadura").contains("sim"))
     {
 		UtilInv.restore_armor(p); 
     }
	}
	catch (Exception e) 
     {
		 if (Config.retornar(p, "kitpvp.armadura") == null)
         {
    	 p.getInventory().setHelmet(armor(Material.LEATHER_HELMET,"Capacete de Couro"));
    	 p.getInventory().setChestplate(armor(Material.LEATHER_CHESTPLATE,"Peitoral de Couro"));
    	 p.getInventory().setLeggings(armor(Material.LEATHER_LEGGINGS,"Calça de Couro"));
    	 p.getInventory().setBoots(armor(Material.LEATHER_BOOTS, "Bota de Couro"));
    	 UtilInv.save(p);
    	 Config.Set(p, "kitpvp.armadura", "sim");
         }
     }
	}
	
	public static ItemStack armor(Material mat,String nome)
	{
		ItemStack item = new ItemStack(mat);
		ItemMeta items = item.getItemMeta();
		items.setDisplayName("§a"+ nome);
		item.setItemMeta(items);
		return item;
	}
}
