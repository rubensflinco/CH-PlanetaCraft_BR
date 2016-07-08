/**
 * 
 */
package me.acf.MiniGames.OneInTheChamber.kits;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.acf.MiniGames.OneInTheChamber.kits.Habilidades.FlechasDrops;
import me.acf.MiniGames.OneInTheChamber.kits.Habilidades.MorteDaVida;
import me.hub.Main;
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
		KitFlechasDrops();
		KitMorteDaVida();
	}
	public void KitDefault()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitDefault");
	    pvp.addItem(UtilInv.AddItemReturn(Material.STONE_AXE, 1, (byte)0, "§aMachado default", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.BOW, 1, (byte)0, "§aArco default", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ARROW, 1, (byte)0, "", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.STONE_AXE,"§9default §a[Gratis]", pvp, "Kit sem habilidade.");
	}
	public void KitFlechasDrops()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitFlechasDrops");
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_AXE, 1, (byte)0, "§aMachado FlechasDrops", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.BOW, 1, (byte)0, "§aArco FlechasDrops", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ARROW, 2, (byte)0, "", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.IRON_AXE,"§9FlechasDrops §6[Vip]", pvp, "Consegue pegar todas flechas dropas no chão.");
	    FlechasDrops FlechasDrops = new FlechasDrops(Main.plugin);
	}
	public void KitMorteDaVida()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitMorteDaVida");
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_AXE, 1, (byte)0, "§aMachado MorteDaVida", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.BOW, 1, (byte)0, "§aArco MorteDaVida", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ARROW, 3, (byte)0, "", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_HELMET, 1, (byte)0, "§aCapacete MorteDaVida", ""));
	    AddKit(Material.IRON_HELMET,"§9MorteDaVida §5[Vip+]", pvp, "Regenera 5 coração quando mata alguem.");
	    MorteDaVida MorteDaVida = new MorteDaVida(Main.plugin);
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
