/**
 * 
 */
package me.acf.MiniGames.SpleggTnT.kits;

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
		KitFerro();
		KitOuro();
		KitDiamante();
	}
	public void KitDefault()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitDefault");
	    pvp.addItem(UtilInv.AddItemReturn(Material.WOOD_SPADE, 1, (byte)0, "§6§lCLICK §c§l| §a§l TnT OvO §c§l| §e§lLv§f§l1", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.WOOD_SPADE,"§9default §a[Gratis]", pvp, "Kit sem habilidade.");
	}
	public void KitFerro()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitFerro");
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_SPADE, 1, (byte)0, "§6§lCLICK §c§l| §a§l TnT OvO §c§l| §e§lLv§f§l2", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.IRON_SPADE,"§9Ferro §c[Pago-Planets]", pvp, "Com esse kit sua velocidade de tiro de ovos aumenta.");
	}
	public void KitOuro()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitOuro");
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLD_SPADE, 1, (byte)0, "§6§lCLICK §c§l| §a§l TnT OvO §c§l| §e§lLv§f§l3", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.GOLD_SPADE,"§9Ouro §6[Vip]", pvp, "Kit sem habilidade.");
	}
	public void KitDiamante()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitDiamante");
	    pvp.addItem(UtilInv.AddItemReturn(Material.DIAMOND_SPADE, 1, (byte)0, "§6§lCLICK §c§l| §a§l TnT OvO §c§l| §e§lLv§f§l4", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.DIAMOND_SPADE,"§9Diamante §5[Vip+]", pvp, "Kit sem habilidade.");
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
