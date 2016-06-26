/**
 * 
 */
package me.acf.FullPvP.Kits;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.FullPvP.API.KitAPI;
import me.hub.MiniPlugin;
import me.hub.API.Enchant;
import me.hub.API.Util.UtilInv;

/**
 * @author adriancf
 *
 */
public class Kits extends MiniPlugin {

	public Kits(JavaPlugin plugin)
	{
		super("Kits", plugin);
		KitNB();
		KitVIP();
		KitVIPM();
		KitLorde();
		KitVIPLorde();
		KitUtil();
		KitFood();
		KitReset();
	}
	public void KitNB()
	{
	    Inventory pvp = Bukkit.createInventory(null, 9, "KitPvP");
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_SWORD, 2, (byte) 0, "§a§lEspada de IRON", "§6§lKit NB"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_HELMET, 2, (byte) 0, "§a§lCapacete de IRON", "§6§lKit NB"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_CHESTPLATE, 2, (byte) 0, "§a§lPeitoral de IRON", "§6§lKit NB"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_LEGGINGS, 2, (byte) 0, "§a§lCalça de IRON", "§6§lKit NB"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_BOOTS, 2, (byte) 0, "§a§lBota de IRON", "§6§lKit NB"));
	    KitAPI.AddKit("nb", pvp);
	}
	public void KitVIP()
	{
	    Inventory pvp = Bukkit.createInventory(null, 54, "KitVIP");
		Random r = new Random();
	    pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, r.nextInt(10), (byte) 0, "§a§lEspada de DIAMOND", "§6§lKit VIP"), 59));
	    pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, r.nextInt(10), (byte) 0, "§a§lMachado de DIAMOND", "§6§lKit VIP"), 59));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, r.nextInt(10), (byte) 0, "§a§lCapacete de DIAMOND", "§6§lKit VIP"), 59));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, r.nextInt(10), (byte) 0, "§a§lPeitoral de DIAMOND", "§6§lKit VIP") ,59));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, r.nextInt(10), (byte) 0, "§a§lCalça de DIAMOND", "§6§lKit VIP"), 59));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, r.nextInt(10), (byte) 0, "§a§lBota de DIAMOND", "§6§lKit VIP"), 59));
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, r.nextInt(10), (byte) 0, "§a§lPicareta de DIAMOND", "§6§lKit VIP"), 20));
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, r.nextInt(10), (byte) 0, "§a§lPá de DIAMOND", "§6§lKit VIP"), 20));
	    pvp.addItem(AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, r.nextInt(10), (byte) 0, "§a§lArco", "§6§lKit VIP"), 40));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ARROW, r.nextInt(120), (byte) 1, "§a§lFlexa", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLDEN_APPLE, r.nextInt(500), (byte) 1, "§a§lMaçã Dourada", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.BEDROCK, r.nextInt(500), (byte) 1, "§a§lBedRock", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.DIAMOND_BLOCK, r.nextInt(64), (byte) 0, "§a§lBlocos", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLD_BLOCK, r.nextInt(64), (byte) 0, "§a§lBlocos", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_BLOCK, r.nextInt(64), (byte) 0, "§a§lBlocos", "§6§lKit VIP"));
	    KitAPI.AddKit("§6vip", pvp);
	}
	
	
	public void KitVIPMLorde()
	{
	    Inventory pvp = Bukkit.createInventory(null, 54, "KitVIPMLorde");
		pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, (byte) 0, "§a§lEspada de DIAMOND", "§6§lKit Lorde"), 70));
		pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 1, (byte) 0, "§a§lMachado de DIAMOND", "§6§lKit Lorde"), 70));
		pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 1, (byte) 0, "§a§lCapacete de DIAMOND", "§6§lKit Lorde"), 70));
		pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 1, (byte) 0, "§a§lPeitoral de DIAMOND", "§6§lKit Lorde") ,70));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 1, (byte) 0, "§a§lCalça de DIAMOND", "§6§lKit Lorde"), 70));
        pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 1, (byte) 0, "§a§lBota de DIAMOND", "§6§lKit Lorde"), 70));
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 1, (byte) 0, "§a§lPicareta de DIAMOND", "§6§lKit Lorde"), 70));		    
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 1, (byte) 0, "§a§lPá de DIAMOND", "§6§lKit VIP"), 70));
	    pvp.addItem(AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, 1, (byte) 0, "§a§lArco", "§6§lKit Lorde"), 70));
		KitAPI.AddKit("§5§oVIPMLorde", pvp);
	}
	
	public void KitVIPLorde()
	{
	    Inventory pvp = Bukkit.createInventory(null, 54, "KitVIPLorde");
		pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, (byte) 0, "§a§lEspada de DIAMOND", "§6§lKit Lorde"), 60));
		pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 1, (byte) 0, "§a§lMachado de DIAMOND", "§6§lKit Lorde"), 90));
		pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 1, (byte) 0, "§a§lCapacete de DIAMOND", "§6§lKit Lorde"), 90));
		pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 1, (byte) 0, "§a§lPeitoral de DIAMOND", "§6§lKit Lorde") ,90));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 1, (byte) 0, "§a§lCalça de DIAMOND", "§6§lKit Lorde"), 90));
        pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 1, (byte) 0, "§a§lBota de DIAMOND", "§6§lKit Lorde"), 90));
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 1, (byte) 0, "§a§lPicareta de DIAMOND", "§6§lKit Lorde"), 40));		   
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 1, (byte) 0, "§a§lPá de DIAMOND", "§6§lKit VIP"), 50));
	    pvp.addItem(AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, 1, (byte) 0, "§a§lArco", "§6§lKit Lorde"), 50));
		KitAPI.AddKit("§6§oVIPLorde", pvp);
	}
	
	public void KitReset()
	{
	    Inventory pvp = Bukkit.createInventory(null, 54, "KitReset");
		pvp.addItem(AddSwordEnchant(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 5, (byte) 0, "§a§lEspada de DIAMOND", "§6§lKit reset"), 60));
		pvp.addItem(AddSwordEnchant(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 5, (byte) 0, "§a§lMachado de DIAMOND", "§6§lKit reset"), 50));
		pvp.addItem(AddArmorEnchant(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 5, (byte) 0, "§a§lCapacete de DIAMOND", "§6§lreset"), 30));
		pvp.addItem(AddArmorEnchant(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 5, (byte) 0, "§a§lPeitoral de DIAMOND", "§6§lKit reset") ,50));
	    pvp.addItem(AddArmorEnchant(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 5, (byte) 0, "§a§lCalça de DIAMOND", "§6§lKit reset"), 50));
        pvp.addItem(AddArmorEnchant(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 5, (byte) 0, "§a§lBota de DIAMOND", "§6§lKit reset"), 50));
	    pvp.addItem(AddUtilEnchant(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 5, (byte) 0, "§a§lPicareta de DIAMOND", "§6§lKit reset"), 40));		   
	    pvp.addItem(AddUtilEnchant(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 5, (byte) 0, "§a§lPá de DIAMOND", "§6§lKit reset"), 50));
	    pvp.addItem(AddBowEnchant(UtilInv.AddItemReturn(Material.BOW, 5, (byte) 0, "§a§lArco", "§6§lKit Lorde"), 50));
		pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 5, (byte) 0, "§a§lEspada de DIAMOND", "§6§lKit reset"), 60));
		pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 5, (byte) 0, "§a§lMachado de DIAMOND", "§6§lKit reset"), 50));
		pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 5, (byte) 0, "§a§lCapacete de DIAMOND", "§6§lreset"), 30));
		pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 5, (byte) 0, "§a§lPeitoral de DIAMOND", "§6§lKit reset") ,60));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 5, (byte) 0, "§a§lCalça de DIAMOND", "§6§lKit reset"), 60));
        pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 5, (byte) 0, "§a§lBota de DIAMOND", "§6§lKit reset"), 60));
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 5, (byte) 0, "§a§lPicareta de DIAMOND", "§6§lKit reset"), 40));		   
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 5, (byte) 0, "§a§lPá de DIAMOND", "§6§lKit reset"), 50));
	    pvp.addItem(AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, 5, (byte) 0, "§a§lArco", "§6§lKit Lorde"), 50));
	    KitAPI.AddKit("Reset", pvp);
	}
	
	public void KitLorde()
	{
	    Inventory pvp = Bukkit.createInventory(null, 54, "KitLorde");
		Random r = new Random();
		  pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, (byte) 0, "§a§lEspada de DIAMOND", "§6§lKit Lorde"), 30));
		    pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 1, (byte) 0, "§a§lMachado de DIAMOND", "§6§lKit Lorde"), 30));
		    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 1, (byte) 0, "§a§lCapacete de DIAMOND", "§6§lKit Lorde"), 30));
		    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 1, (byte) 0, "§a§lPeitoral de DIAMOND", "§6§lKit Lorde") ,30));
		    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 1, (byte) 0, "§a§lCalça de DIAMOND", "§6§lKit Lorde"), 30));
		    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 1, (byte) 0, "§a§lBota de DIAMOND", "§6§lKit Lorde"), 30));
		    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 1, (byte) 0, "§a§lPicareta de DIAMOND", "§6§lKit Lorde"), 30));
		    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 1, (byte) 0, "§a§lPá de DIAMOND", "§6§lKit VIP"), 30));
		    pvp.addItem(AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, 1, (byte) 0, "§a§lArco", "§6§lKit Lorde"), 30));
		    KitAPI.AddKit("§cLorde", pvp);
	}
	public void KitUtil()
	{
	    Inventory pvp = Bukkit.createInventory(null, 54, "KitUtil");
	    pvp.addItem(UtilInv.AddItemReturn(Material.DIAMOND_BLOCK, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLD_BLOCK, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_BLOCK, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.NETHER_BRICK, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.NETHER_STAR, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.OBSIDIAN, 50, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.WOOL, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ENDER_CHEST, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ENDER_PEARL, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ARMOR_STAND, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.BLAZE_POWDER, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.SLIME_BLOCK, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.SLIME_BALL, 10, (byte) 0, "§a§lBlocos", "§6§lKit Util"));
	    KitAPI.AddKit("§cUtil", pvp);
	}
	public void KitFood()
	{
	    Inventory pvp = Bukkit.createInventory(null, 54, "KitFood");
	    pvp.addItem(UtilInv.AddItemReturn(Material.BEACON, 50, (byte) 0, "§a§lComida", "§6§lKit Food"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.APPLE, 50, (byte) 0, "§a§lComida", "§6§lKit Food"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLDEN_APPLE, 50, (byte) 0, "§a§lComida", "§6§lKit Food"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLDEN_APPLE, 50, (byte) 1, "§a§lComida", "§6§lKit Food"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.CAKE, 50, (byte) 0, "§a§lComida", "§6§lKit Food"));
	    KitAPI.AddKit("§cFood", pvp);
	}
	public void KitVIPM()
	{
	    Inventory pvp = Bukkit.createInventory(null, 54, "KitVIP+");
		Random r = new Random();
	    pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, r.nextInt(10), (byte) 0, "§a§lEspada de DIAMOND", "§6§lKit VIP"), 70));
	    pvp.addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, r.nextInt(10), (byte) 0, "§a§lMachado de DIAMOND", "§6§lKit VIP"), 70));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, r.nextInt(10), (byte) 0, "§a§lCapacete de DIAMOND", "§6§lKit VIP"), 70));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, r.nextInt(10), (byte) 0, "§a§lPeitoral de DIAMOND", "§6§lKit VIP") ,70));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, r.nextInt(10), (byte) 0, "§a§lCalça de DIAMOND", "§6§lKit VIP"), 70));
	    pvp.addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, r.nextInt(10), (byte) 0, "§a§lBota de DIAMOND", "§6§lKit VIP"), 70));
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, r.nextInt(10), (byte) 0, "§a§lPicareta de DIAMOND", "§6§lKit VIP"), 29));
	    pvp.addItem(AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, r.nextInt(10), (byte) 0, "§a§lPá de DIAMOND", "§6§lKit VIP"), 29));
	    pvp.addItem(AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, r.nextInt(10), (byte) 0, "§a§lArco", "§6§lKit VIP"), 50));
	    pvp.addItem(UtilInv.AddItemReturn(Material.ARROW, r.nextInt(120), (byte) 1, "§a§lFlexa", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLDEN_APPLE, r.nextInt(500), (byte) 1, "§a§lMaçã Dourada", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.BEDROCK, r.nextInt(500), (byte) 1, "§a§lBedRock", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.DIAMOND_BLOCK, r.nextInt(64), (byte) 0, "§a§lBlocos", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.GOLD_BLOCK, r.nextInt(64), (byte) 0, "§a§lBlocos", "§6§lKit VIP"));
	    pvp.addItem(UtilInv.AddItemReturn(Material.IRON_BLOCK, r.nextInt(64), (byte) 0, "§a§lBlocos", "§6§lKit VIP"));
	    KitAPI.AddKit("§5vip+", pvp);
	}
	
	public static ItemStack AddUtilEnchantRandom(ItemStack item, int level)
	{
	  ItemStack is = item;
	  Random r = new Random();
      ItemMeta itemen = item.getItemMeta();
      itemen.addEnchant(Enchant.DIG_SPEED, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.LOOT_BONUS_BLOCKS, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.DURABILITY, r.nextInt(level)+1, true);
      if (30 > r.nextInt(100))
    	  itemen.addEnchant(Enchant.SILK_TOUCH, r.nextInt(level)+1, true); 
      item.setItemMeta(itemen);
	  
		return is;
	}
	
	public static ItemStack AddBowEnchantRandom(ItemStack item, int level)
	{
		  ItemStack is = item;
		  Random r = new Random();
	      ItemMeta itemen = item.getItemMeta();
	      itemen.addEnchant(Enchant.ARROW_DAMAGE, r.nextInt(level)+1, true);
	      itemen.addEnchant(Enchant.ARROW_FIRE, r.nextInt(level)+1, true);
	      itemen.addEnchant(Enchant.DURABILITY, r.nextInt(level)+1, true);
	      itemen.addEnchant(Enchant.ARROW_KNOCKBACK, r.nextInt(level)+1, true);
	      if (50 > r.nextInt(100))
	    	  itemen.addEnchant(Enchant.ARROW_INFINITE, r.nextInt(level)+1, true); 
	      item.setItemMeta(itemen);
		  
			return is;
		}
	public static ItemStack AddSwordEnchantRandom(ItemStack item, int level)
	{
	  ItemStack is = item;
	  Random r = new Random();
      ItemMeta itemen = item.getItemMeta();
      itemen.addEnchant(Enchant.DAMAGE_ALL, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.FIRE_ASPECT, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.KNOCKBACK, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.DURABILITY, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.DAMAGE_ARTHROPODS, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.DAMAGE_UNDEAD, r.nextInt(level)+1, true);
      item.setItemMeta(itemen);
	  
		return is;
	}
	
	public static ItemStack AddArmorEnchantRandom(ItemStack item, int level)
	{
	  ItemStack is = item;
	  Random r = new Random();
      ItemMeta itemen = item.getItemMeta();
      itemen.addEnchant(Enchant.DURABILITY, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.PROTECTION_ENVIRONMENTAL, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.PROTECTION_EXPLOSIONS, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.PROTECTION_FALL, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.PROTECTION_PROJECTILE, r.nextInt(level)+1, true);
      itemen.addEnchant(Enchant.PROTECTION_FIRE, r.nextInt(level)+1, true);
      item.setItemMeta(itemen);
	  
		return is;
	}
	///
	public static ItemStack AddUtilEnchant(ItemStack item, int level)
	{
	  ItemStack is = item;

      ItemMeta itemen = item.getItemMeta();
      itemen.addEnchant(Enchant.DIG_SPEED, level, true);
      itemen.addEnchant(Enchant.LOOT_BONUS_BLOCKS, level, true);
      itemen.addEnchant(Enchant.DURABILITY, level, true);
      item.setItemMeta(itemen);
	  
		return is;
	}
	
	public static ItemStack AddBowEnchant(ItemStack item, int level)
	{
		  ItemStack is = item;
		
	      ItemMeta itemen = item.getItemMeta();
	      itemen.addEnchant(Enchant.ARROW_DAMAGE, level, true);
	      itemen.addEnchant(Enchant.ARROW_FIRE, level, true);
	      itemen.addEnchant(Enchant.DURABILITY, level, true);
	      itemen.addEnchant(Enchant.ARROW_KNOCKBACK, level, true);
	      itemen.addEnchant(Enchant.ARROW_INFINITE, level, true); 
	      item.setItemMeta(itemen);
		  
			return is;
		}
	public static ItemStack AddSwordEnchant(ItemStack item, int level)
	{
	  ItemStack is = item;

      ItemMeta itemen = item.getItemMeta();
      itemen.addEnchant(Enchant.DAMAGE_ALL, level, true);
      itemen.addEnchant(Enchant.FIRE_ASPECT, level, true);
      itemen.addEnchant(Enchant.KNOCKBACK, level, true);
      itemen.addEnchant(Enchant.DURABILITY, level, true);
      itemen.addEnchant(Enchant.DAMAGE_ARTHROPODS, level, true);
      itemen.addEnchant(Enchant.DAMAGE_UNDEAD, level, true);
      item.setItemMeta(itemen);
	  
		return is;
	}
	
	public static ItemStack AddArmorEnchant(ItemStack item, int level)
	{
	  ItemStack is = item;

      ItemMeta itemen = item.getItemMeta();
      itemen.addEnchant(Enchant.DURABILITY, level, true);
      itemen.addEnchant(Enchant.PROTECTION_ENVIRONMENTAL, level, true);
      itemen.addEnchant(Enchant.PROTECTION_EXPLOSIONS, level, true);
      itemen.addEnchant(Enchant.PROTECTION_FALL, level, true);
      itemen.addEnchant(Enchant.PROTECTION_PROJECTILE, level, true);
      itemen.addEnchant(Enchant.PROTECTION_FIRE, level, true);
      item.setItemMeta(itemen);
	  
		return is;
	}
}
