/**
 * 
 */
package me.acf.MiniGames.SkyWars.kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.hub.API.Util.UtilInv;
import me.hub.config.Config;

/**
 * @author adriancf
 *
 */
public class Kits {

	public Kits()
	{
		KitDefault();
	}
	public void KitDefault()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitDefault");
	    pvp.addItem(UtilInv.AddItemReturn(Material.APPLE, 3, (byte)0, "§aMaça kit default", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.APPLE,"§9default §a[Gratis]", pvp, "Kit sem habilidade.");
	}
	public void KitVidaExtra()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitVidaExtra");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.APPLE,"§9VidaExtra §5[Vip+]", pvp, "Você tem 2 vidas no jogo.");
	}
	
	public void AddKit(Material item, String nome, Inventory inv, String desc)
	{
		String NomeKIT = nome.replace("§a[Gratis]", "").replace("§c[Pago-Planets]", "").replace("§6[Vip]", "").replace("§5[Vip+]", "");
		ItemStack is = new ItemStack(item);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(nome);
		ArrayList<String> lore = new ArrayList();
		lore.add("§1 ");
		lore.add("§6§lDescrição");
		if (desc == null){
		lore.add("§f* EM BREVE");
		}else{
	    lore.add("§f* "+desc);
		}
		lore.add("§2 ");
		lore.add("§c§lItems");
		for (ItemStack invI : inv.getContents()){
			if (invI != null){
		if (invI.getItemMeta().getDisplayName() == null){}else{
		lore.add("§f+ "+invI.getItemMeta().getDisplayName());	
		}
		}
		}
		im.setLore(lore);
		is.setItemMeta(im);
		Kit.kits.put(NomeKIT, is);
		Kit.kit.put(NomeKIT, inv);
		Kit.kitsMENU.put(nome, is);
	}
	
	
	public static ItemStack Espada(Player p)
	{
		String espada = Config.retornar(p, "kitpvp.sword");
		ItemStack item = null;
		if (espada.contains("Pedra"))
			item = new ItemStack(Material.STONE_SWORD);
		if (espada.contains("Ferro"))
			item = new ItemStack(Material.IRON_SWORD);
		if (espada.contains("Diamante"))
			item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta i = item.getItemMeta();
		i.setDisplayName(espada);
		item.setItemMeta(i);
		
		
	return item;
	}
}
