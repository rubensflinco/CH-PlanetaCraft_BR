/**
 * 
 */
package me.acf.KitPvP.kitAPI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.acf.KitPvP.kitAPI.Habilidade.Anchor;
import me.acf.KitPvP.kitAPI.Habilidade.Barbarian;
import me.acf.KitPvP.kitAPI.Habilidade.Berserker;
import me.acf.KitPvP.kitAPI.Habilidade.Camel;
import me.acf.KitPvP.kitAPI.Habilidade.Confusion;
import me.acf.KitPvP.kitAPI.Habilidade.Disable;
import me.acf.KitPvP.kitAPI.Habilidade.Drain;
import me.acf.KitPvP.kitAPI.Habilidade.Fireman;
import me.acf.KitPvP.kitAPI.Habilidade.Fisherman;
import me.acf.KitPvP.kitAPI.Habilidade.ForceField;
import me.acf.KitPvP.kitAPI.Habilidade.Frosty;
import me.acf.KitPvP.kitAPI.Habilidade.Hulk;
import me.acf.KitPvP.kitAPI.Habilidade.Kangaroo;
import me.acf.KitPvP.kitAPI.Habilidade.Laucher;
import me.acf.KitPvP.kitAPI.Habilidade.Ninja;
import me.acf.KitPvP.kitAPI.Habilidade.Phantom;
import me.acf.KitPvP.kitAPI.Habilidade.Poseidon;
import me.acf.KitPvP.kitAPI.Habilidade.Snail;
import me.acf.KitPvP.kitAPI.Habilidade.Speed;
import me.acf.KitPvP.kitAPI.Habilidade.Stomper;
import me.acf.KitPvP.kitAPI.Habilidade.Unix;
import me.acf.KitPvP.kitAPI.Habilidade.Urgal;
import me.acf.KitPvP.kitAPI.Habilidade.Vacuum;
import me.acf.KitPvP.kitAPI.Habilidade.Viper;
import me.acf.KitPvP.kitAPI.Habilidade.Vitality;
import me.acf.KitPvP.kitAPI.Habilidade.Wither;
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
		KitPvP();
		KitArcher();
		KitVitality();
		KitViper();
		KitNinja();
		KitStomper();
		KitUnix();
		KitAnchor();
		KitPhantom();
		KitKangaroo();
		KitPoseidon();
		KitFireman();
		KitDisable();
		KitFisherman();
		KitUrgal();
		KitForceField();
		KitSnail();
		KitSpeed();
		KitVacuum();
		KitConfusion();
		KitCamel();
		KitFrosty();
		KitHulk();
		KitDrain();
		KitBerserker();
		KitWither();
		KitBarbarian();
		KitLaucher();
	}
	public void KitPvP()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitPvP");
	    AddKit(Material.STONE_SWORD,"§9pvp §a[Gratis]", pvp, "Kit sem habilidade.");
	}
	
	public void KitViper()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitViper");
	    AddKit(Material.SPIDER_EYE,"§9viper §c[Pago-Planets]", pvp, "Coloca veneno no jogador que você bater.");
	    Viper viper = new Viper(Main.plugin);
	}
	
	public void KitConfusion()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitConfusion");
	    AddKit(Material.SEEDS,"§9confusion §c[Pago-Planets]", pvp, "Batendo no jogador você pode deixar ele com confusão.");
	    Confusion viper = new Confusion(Main.plugin);
	}
	
	public void KitAnchor()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitAnchor");
	    AddKit(Material.WOOD_SWORD,"§9anchor §5[Vip+]", pvp, null);
	    Anchor anchor = new Anchor(Main.plugin);
	}
	public void KitStomper()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitStomper");
	    AddKit(Material.IRON_BOOTS,"§9stomper §6[Vip]", pvp, "Quando você pular em cima de uma pessoa você vai dar o dano que você levaria nelá.");
	    Stomper stomper = new Stomper(Main.plugin);
	}
	public void KitDisable()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitDisable");
	    AddKit(Material.REDSTONE_BLOCK,"§9disable §5[Vip+]", pvp, null);
	    Disable disable = new Disable(Main.plugin);
	}
	public void KitBarbarian()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitBabarian");
	    AddKit(Material.WOOD_SWORD,"§9barbarian §5[Vip+]", pvp, null);
	    Barbarian disable = new Barbarian(Main.plugin);
	}
	public void KitUnix()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitfUnix");
	    AddKit(Material.REDSTONE,"§9unix §5[Vip+]", pvp, "Você tem 10% de chance de tirar 4 coração a mais.");
	    Unix unix = new Unix(Main.plugin);
	}
	public void KitNinja()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitNinja");
	    AddKit(Material.IRON_SWORD,"§9ninja §6[Vip]", pvp, "Batendo em um jogador e depois abertando shift você é teleportado.");
	    Ninja ninja = new Ninja(Main.plugin);
	}
	public void KitCamel()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitCamel");
	    AddKit(Material.SANDSTONE,"§9camel §c[Pago-Planets]", pvp, null);
	    Camel ninja = new Camel(Main.plugin);
	}
	public void KitFrosty()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitFrosty");
	    AddKit(Material.SNOW_BLOCK,"§9frosty §c[Pago-Planets]", pvp, "Você anda mais rapido sobre a neve.");
	    Frosty ninja = new Frosty(Main.plugin);
	}
	public void KitWither()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitWither");
	    AddKit(Material.NETHER_STAR,"§9wither §c[Pago-Planets]", pvp, null);
	    Wither ninja = new Wither(Main.plugin);
	}
	public void KitVitality()
    {
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitVitality");
	    AddKit(Material.MUSHROOM_SOUP,"§9vitality §6[Vip]", pvp, null);
	    Vitality kit = new Vitality(Main.plugin);
	}
	
	public void KitPoseidon()
    {
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitPoseidon");
	    AddKit(Material.WATER_BUCKET,"§9poseidon §6[Vip]", pvp, "Quando você estiver dentro da água você vai dar mais dano.");
	    Poseidon kit = new Poseidon(Main.plugin);
	}
	
	public void KitFireman()
    {
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitFireman");
	    AddKit(Material.LAVA_BUCKET,"§9fireman §6[Vip]", pvp, null);
	    Fireman kit = new Fireman(Main.plugin);
	}
	public void KitSnail()
    {
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitSnail");
	    AddKit(Material.SOUL_SAND,"§9snail §c[Pago-Planets]", pvp, "Batendo no jogador você pode deixar ele lerdo.");
	    Snail kit = new Snail(Main.plugin);
	}
	public void KitSpeed()
    {
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitSpeed");
	    AddKit(Material.ICE,"§9speed §6[Vip]", pvp, null);
	    Speed kit = new Speed(Main.plugin);
	}
	public void KitPhantom()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitPhantom");
	    pvp.addItem(UtilInv.AddItemReturn(Material.FEATHER, 1, (byte)0, "§a§lKit Phantom", ""));
	    AddKit(Material.FEATHER,"§9phantom §6[Vip]", pvp, "Você pode voar cliquando na pena.");
	    Phantom phantom = new Phantom(Main.plugin);
	}

	
	public void KitHulk()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitHulk");
	    pvp.addItem(UtilInv.AddItemReturn(Material.SADDLE, 1, (byte)0, "§a§lKit Hulk", ""));
	    AddKit(Material.SADDLE,"§9hulk §6[Vip]", pvp, null);
	    Hulk phantom = new Hulk(Main.plugin);
	}
	
	public void KitBerserker()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitBerserker");
	    AddKit(Material.APPLE,"§9berserker §5[Vip+]", pvp, null);
	    Berserker phantom = new Berserker(Main.plugin);
	}
	public void KitVacuum()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitVacuum");
	    pvp.addItem(UtilInv.AddItemReturn(Material.ENDER_PEARL, 1, (byte)0, "§a§lKit Vacuum", ""));
	    AddKit(Material.ENDER_PEARL,"§9vacuum §6[Vip]", pvp, "Puxa jogadores procimos para perto de você.");
	    Vacuum phantom = new Vacuum(Main.plugin);
	}
	
	public void KitForceField()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitForceField");
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_FENCE, 1, (byte)0, "§a§lKit ForceField", ""));
	    AddKit(Material.IRON_FENCE,"§9forcefield §5[Vip+]", pvp, "Você pode bater um jogadores ao seu redor durante um tempo.");
	    ForceField phantom = new ForceField(Main.plugin);
	}
	public void KitDrain()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitDrain");
	    pvp.addItem(UtilInv.AddItemReturn(Material.EYE_OF_ENDER, 1, (byte)0, "§a§lKit Drain", ""));
	    AddKit(Material.EYE_OF_ENDER,"§9drain §5[Vip+]", pvp, null);
	    Drain phantom = new Drain(Main.plugin);
	}

	public void KitUrgal()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitUrgal");
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLD_NUGGET, 3, (byte)0, "§a§lKit Urgal", ""));
	    AddKit(Material.GOLD_NUGGET,"§9urgal §5[Vip+]", pvp, "Cliquando nas pepitas de ouro você ganha força.");
	    Urgal urgal = new Urgal(Main.plugin);
	}
	public void KitFisherman()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitFisherman");
	    pvp.addItem(UtilInv.AddItemReturn(Material.FISHING_ROD, 1, (byte)0, "§a§lKit Fisherman", ""));
	    AddKit(Material.FISHING_ROD,"§9fisherman §c[Pago-Planets]", pvp, null);
	    Fisherman fisherman = new Fisherman(Main.plugin);
	}
	public void KitLaucher()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitLaucher");
	    pvp.addItem(UtilInv.AddItemReturn(Material.FISHING_ROD, 1, (byte)0, "§a§lKit Laucher", ""));
	    AddKit(Material.FISHING_ROD,"§9laucher §6[Vip]", pvp, null);
	    Laucher fisherman = new Laucher(Main.plugin);
	}
	public void KitKangaroo()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitKangaroo");
	    pvp.addItem(UtilInv.AddItemReturn(Material.FIREWORK, 1, (byte)0, "§a§lKit Kangaroo", ""));
	    AddKit(Material.FIREWORK,"§9kangaroo §c[Pago-Planets]", pvp, "Você pode dar um super pulo.");
	    Kangaroo kangaroo = new Kangaroo(Main.plugin);
	}
	public void KitArcher()
	{
	      Inventory archer = Bukkit.createInventory(null, 9, "KitAcher");
		  ItemStack arco = new ItemStack(Material.BOW);
	      ItemMeta im = arco.getItemMeta();
		  im.setDisplayName("§a§oArco");
		  arco.setItemMeta(im);
		  arco.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		  arco.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
		  arco.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
		  arco.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
	      archer.addItem(arco);
	      archer.addItem(UtilInv.AddItemReturn(Material.ARROW, 1, (byte)0, "flecha", "Arco"));
		  AddKit(Material.BOW,"§9arqueiro §a[Gratis]", archer, "Ganha um arco com knockback.");
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
		lore.add("§f+ §aSopas");
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
