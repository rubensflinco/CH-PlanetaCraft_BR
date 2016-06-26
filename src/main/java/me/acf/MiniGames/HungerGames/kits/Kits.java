/**
 * 
 */
package me.acf.MiniGames.HungerGames.kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.acf.MiniGames.HungerGames.kits.Habilidades.Confusion;
import me.acf.MiniGames.HungerGames.kits.Habilidades.ForceField;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Frosty;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Kangaroo;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Ninja;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Phantom;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Poseidon;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Snail;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Stomper;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Unix;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Urgal;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Vacuum;
import me.acf.MiniGames.HungerGames.kits.Habilidades.Viper;
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
		KitNinja();
		KitViper();
		KitUnix();
		KitPhantom();
		KitKangaroo();
		KitForceField();
		KitUrgal();
		KitVacuum();
		KitSnail();
		KitPoseidon();
		KitFrosty();
		KitStomper();
		KitConfusion();
	}
	public void KitDefault()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitDefault");
	    pvp.addItem(UtilInv.AddItemReturn(Material.APPLE, 3, (byte)0, "§aMaça default", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.APPLE,"§9default §a[Gratis]", pvp, "Kit sem habilidade.");
	}
	public void KitNinja()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitNinja");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.ENDER_PEARL,"§9Ninja §6[Vip]", pvp, "Batendo em um jogador e depois abertando shift você é teleportado.");
	    Ninja ninja = new Ninja(Main.plugin);
	}
	public void KitViper()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitViper");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.SPIDER_EYE,"§9Viper §c[Pago-Planets]", pvp, "Coloca veneno no jogador que você bater.");
	    Viper viper = new Viper(Main.plugin);
	}
	public void KitUnix()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitfUnix");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.REDSTONE,"§9Unix §5[Vip+]", pvp, "Você tem 10% de chance de tirar 4 coração a mais.");
	    Unix unix = new Unix(Main.plugin);
	}
	public void KitPhantom()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitPhantom");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.FEATHER, 1, (byte)0, "§a§lKit Phantom", ""));
	    AddKit(Material.FEATHER,"§9Phantom §6[Vip]", pvp, "Você pode voar cliquando na pena.");
	    Phantom phantom = new Phantom(Main.plugin);
	}
	public void KitKangaroo()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitKangaroo");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.FIREWORK, 1, (byte)0, "§a§lKit Kangaroo", ""));
	    AddKit(Material.FIREWORK,"§9Kangaroo §c[Pago-Planets]", pvp, "Você pode dar um super pulo.");
	    Kangaroo kangaroo = new Kangaroo(Main.plugin);
	}
	public void KitForceField()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitForceField");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_FENCE, 1, (byte)0, "§a§lKit ForceField", ""));
	    AddKit(Material.IRON_FENCE,"§9Forcefield §5[Vip+]", pvp, "Você pode bater um jogadores ao seu redor durante um tempo.");
	    ForceField phantom = new ForceField(Main.plugin);
	}
	public void KitUrgal()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitUrgal");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLD_NUGGET, 2, (byte)0, "§a§lKit Urgal", ""));
	    AddKit(Material.GOLD_NUGGET,"§9Urgal §5[Vip+]", pvp, "Cliquando nas pepitas de ouro você ganha força.");
	    Urgal urgal = new Urgal(Main.plugin);
	}
	public void KitVacuum()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitVacuum");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ENDER_PEARL, 1, (byte)0, "§a§lKit Vacuum", ""));
	    AddKit(Material.ENDER_PEARL,"§9Vacuum §6[Vip]", pvp, "Puxa jogadores procimos para perto de você.");
	    Vacuum phantom = new Vacuum(Main.plugin);
	}
	public void KitSnail()
    {
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitSnail");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.SOUL_SAND,"§9Snail §c[Pago-Planets]", pvp, "Batendo no jogador você pode deixar ele lerdo.");
	    Snail kit = new Snail(Main.plugin);
	}
	public void KitPoseidon()
    {
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitPoseidon");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.WATER_BUCKET,"§9Poseidon §6[Vip]", pvp, "Quando você estiver dentro da água você vai dar mais dano.");
	    Poseidon kit = new Poseidon(Main.plugin);
	}
	public void KitFrosty()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitFrosty");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.SNOW_BLOCK,"§9Frosty §c[Pago-Planets]", pvp, "Você anda mais rapido sobre a neve.");
	    Frosty ninja = new Frosty(Main.plugin);
	}
	public void KitStomper()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitStomper");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.IRON_BOOTS,"§9Stomper §6[Vip]", pvp, "Quando você pular em cima de uma pessoa você vai dar o dano que você levaria nelá.");
	    Stomper stomper = new Stomper(Main.plugin);
	}
	public void KitConfusion()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitConfusion");
	    pvp.addItem(UtilInv.AddItemReturn(Material.COMPASS, 1, (byte)0, "§aBussola §6CLICK", ""));
	    AddKit(Material.SEEDS,"§9Confusion §c[Pago-Planets]", pvp, "Batendo no jogador você pode deixar ele com confusão.");
	    Confusion viper = new Confusion(Main.plugin);
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
