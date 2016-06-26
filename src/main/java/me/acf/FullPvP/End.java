/**
 * 
 */
package me.acf.FullPvP;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.hub.MiniPlugin;
import me.hub.API.Enchant;
import me.hub.API.Util.UtilFirework;
import me.hub.API.Util.UtilHolo;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilServer;
import me.hub.recharge.Recharge;
import me.site.account.Account;

/**
 * @author adriancf
 *
 */
public class End extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public End(JavaPlugin plugin) {
		super("End", plugin);
		// TODO Auto-generated constructor stub
	}
	
	static Location EndmagicLOC = null;
	
	private static void Sound(Location loc, org.bukkit.Sound sound)
	{
		for (Player p : UtilServer.Jogadores())
		p.playSound(loc, sound, 10F, 1.2F);
	}
	
	@EventHandler
	public void onChunkLoad(ChunkLoadEvent e) {
	    for (BlockState tile : e.getChunk().getTileEntities()) {
	        if (Material.ENDER_PORTAL_FRAME.equals(tile.getBlock().getType())) {
	    	    Location loc = tile.getBlock().getLocation();
	      		loc.setY(loc.getY() -1);
	    		int block1 = loc.getWorld().getBlockTypeIdAt(loc);
	    		if (block1 == 169)
	    		{
	    		Location loc1 = tile.getBlock().getLocation();
	    		loc1.setY(loc.getY() -1.5);
	    		EndmagicLOC = loc1;
	    		UtilHolo.HoloPerm(loc1, "§b§lEndMagic §f§l- §6Gastará §f1 §6§lCHAVE");
	            System.out.println("EndMagic detequitados ");
	            
	        }
	       }
	    }
	}
	
    @EventHandler(priority=EventPriority.NORMAL)
    public void End(PlayerInteractEvent e)
    {
      Player p = e.getPlayer();
      if (((e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
        (e.getClickedBlock().getType() == Material.ENDER_PORTAL_FRAME)))
      {
    	     if (!e.getPlayer().getWorld().getName().equals("world")) {
    	    	 return;
    	     }
    		    Location loc = e.getClickedBlock().getLocation();
    	  		loc.setY(loc.getY() -1);
    			int block1 = loc.getWorld().getBlockTypeIdAt(loc);
    			if (block1 == 169)
    			{
   	   if (Account.getChaveAPI(p) < 1)
	   {
           p.sendMessage("§cOps você não tem chaves para isto!"); 
		   return;
	   }
   	   
   	 if (!Recharge.Instance.use(p, "MagicEnd", 3900L, true, false)) {
	        return;
	      }  
   	      Account.removeChave(p, 1);
   	      Account.UpdateAccount(p);
    	  Random r = new Random();
    	  String premio = null;
          premio = Premio(p, r.nextInt(2600));
    	   
    	  if ((premio.contains("nada")) || (premio.contains("Planets")) || (premio.contains("§c"))) 
    	  {
    		  p.sendMessage("§5§lEND §7Você ganhou§a " + premio);
    		  return;
    	  }
          UtilServer.AnuncioServidor("§5§lEND §6§l" + p.getCustomName() + " §7ganhou§a§l " + premio);
          FireworkEffect effect = 
        	        FireworkEffect.builder()
        	        .flicker(false)
        	        .withColor(Color.YELLOW)
        	        .with(FireworkEffect.Type.BURST)
        	        .trail(false)
        	        .build();
          UtilFirework.playFirework(p.getLocation(), effect);
          Sound(p.getLocation(), org.bukkit.Sound.WITHER_SPAWN);
      }
     }
    }
	  public static String Premio(Player p, int Numero) {
		   String c = "§c§lOps nada";
	       
		   if ((Numero > 15) && (Numero < 30))
		   {
               Random r = new Random();
               int level = r.nextInt(50);
			   p.getInventory().addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.WOOD_AXE, 1, (byte) 0, "§a§lMachado do §5§lEND", ""), level));;
		       c = "§a§lMachado de Madeira §5§lEND §6Level " + level;
		   }
		   if ((Numero > 45) && (Numero < 70))
		   {
               Random r = new Random();
               int level = r.nextInt(60);
			   p.getInventory().addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.STONE_AXE, 1, (byte) 0, "§a§lMachado do §5§lEND", ""), level));;
		       c = "§a§lMachado de Pedra §5§lEND §6Level " + level;
		   }
		   if ((Numero > 90) && (Numero < 100))
		   {
               Random r = new Random();
               int level = r.nextInt(70);
			   p.getInventory().addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.IRON_AXE, 1, (byte) 0, "§a§lMachado do §5§lEND", ""), level));;
		       c = "§a§lMachado de IRON §5§lEND §6Level " + level;
		   }
		   if ((Numero > 120) && (Numero < 130))
		   {
               Random r = new Random();
               int level = r.nextInt(90);
			   p.getInventory().addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 1, (byte) 0, "§a§lMachado do §5§lEND", ""), level));;
		       c = "§a§lMachado de Diamante §5§lEND §6Level " + level;
		   }
		   if ((Numero > 140) && (Numero < 200))
		   {
			   p.getInventory().addItem(UtilInv.AddItemReturn(Material.BEDROCK, 15 , (byte) 0 ,"BedRock",""));
			   c = "§c§lBedRock";
		   }
		   if ((Numero > 200) && (Numero < 500))
		   {
			   p.getInventory().addItem(UtilInv.AddItemReturn(Material.DIAMOND_BLOCK, 64 , (byte) 0 ,"Bloco de Diamante",""));
			   c = "§c§lBloco de Diamante";
		   }
		   if ((Numero > 501) && (Numero < 550))
		   {
			   p.getInventory().addItem(UtilInv.AddItemReturn(Material.BEACON, 64 , (byte) 0 ,"Beacon",""));
			   c = "§c§lBeacon";
		   }
		   if ((Numero > 560) && (Numero < 570))
		   {
			   p.getInventory().addItem(UtilInv.AddItemReturn(Material.GOLDEN_APPLE, 500 , (byte) 1 ,"Golden Apple",""));
			   c = "§c§lGolden Apple";
		   }
		   if ((Numero > 575) && (Numero < 1200))
		   {
			   p.getInventory().addItem(new ItemStack(Material.values()[new Random().nextInt(Material.values().length)]));
		       c = "§c§lItens";
		   }
		   if ((Numero > 1201) && (Numero < 1350))
		   {
               Random r = new Random();
               int level = r.nextInt(50);
			   p.getInventory().addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.WOOD_SWORD, 1, (byte) 0, "§a§lEspada do §5§lEND", ""), level));;
		       c = "§a§lEspada de Madeira §5§lEND §6Level " + level; 
		   }
		   if ((Numero > 1355) && (Numero < 1450))
		   {
               Random r = new Random();
               int level = r.nextInt(60);
			   p.getInventory().addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.IRON_SWORD, 1, (byte) 0, "§a§lEspada do §5§lEND", ""), level));;
		       c = "§a§lEspada de Ferro §5§lEND §6Level " + level; 
		   }
		   if ((Numero > 1455) && (Numero < 1460))
		   {
               Random r = new Random();
               int level = r.nextInt(80);
			   p.getInventory().addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, (byte) 0, "§a§lEspada do §5§lEND", ""), level));;
		       c = "§a§lEspada de Diamante §5§lEND §6Level " + level; 
		   }
		   if ((Numero > 1465) && (Numero < 1470))
		   {
               Random r = new Random();
               int level = 90;
			   p.getInventory().addItem(AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, (byte) 0, "§a§lEspada do §5§lEND §6§lLENDARIA", ""), level));;
		       c = "§a§lEspada de Diamante §6§lLENDARIA §aLevel§e§l 90"; 
		   }
		   if ((Numero > 1471) && (Numero < 1520))
		   {
               Random r = new Random();
               int level = r.nextInt(80);
			   p.getInventory().addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 1, (byte) 0, "§a§lArmadura do §5§lEND", ""), level));;
		       c = "§a§lArmadura do §5§lEND §6Level " + level; 
		   }
		   if ((Numero > 1529) && (Numero < 1670))
		   {
               Random r = new Random();
               int level = r.nextInt(80);
			   p.getInventory().addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 1, (byte) 0, "§a§lArmadura do §5§lEND", ""), level));;
		       c = "§a§lArmadura do §5§lEND §6Level " + level; 
		   }
		   if ((Numero > 1672) && (Numero < 1770))
		   {
               Random r = new Random();
               int level = r.nextInt(80);
			   p.getInventory().addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 1, (byte) 0, "§a§lArmadura do §5§lEND", ""), level));;
		       c = "§a§lArmadura do §5§lEND §6Level " + level; 
		   }
		   if ((Numero > 1772) && (Numero < 1776))
		   {
               Random r = new Random();
               int level = r.nextInt(80);
			   p.getInventory().addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 1, (byte) 0, "§a§lArmadura do §5§lEND", ""), level));;
		       c = "§a§lArmadura do §5§lEND §6Level " + level; 
		   }
		   if ((Numero > 1776) && (Numero < 2600))
		   {
               Random r = new Random();
               int level = r.nextInt(60);
			   p.getInventory().addItem(AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.IRON_LEGGINGS, 1, (byte) 0, "§a§lArmadura do §5§lEND", ""), level));;
		       c = "§a§lArmadura do §5§lEND §6Level " + level; 
		   }
		   if ((Numero > 2605) && (Numero < 2700))
		   {
			   FPConfig.FP(p, "kit.Util.tem", "sim");
	    		
		       c = "§a§lKit UTIL"; 
		   }
		   if ((Numero > 2701) && (Numero < 2800))
		   {
			   FPConfig.FP(p, "kit.Food.tem", "sim");
	    		
		       c = "§a§lKit Food"; 
		   }
		   if ((Numero > 2801) && (Numero < 2900))
		   {
			   FPConfig.FP(p, "kit.Lorde.tem", "sim");
	    		
		       c = "§a§lKit Lorde"; 
		   }
		   return c;	   
		  
		   }
	  
	  
		public static ItemStack AddSwordEnchantRandom(ItemStack item, int level)
		{
		  ItemStack is = item;
	      ItemMeta itemen = item.getItemMeta();
	      itemen.addEnchant(Enchant.DAMAGE_ALL, level+1, true);
	      itemen.addEnchant(Enchant.FIRE_ASPECT, level+1, true);
	      itemen.addEnchant(Enchant.KNOCKBACK, level+1, true);
	      itemen.addEnchant(Enchant.DURABILITY, level+1, true);
	      itemen.addEnchant(Enchant.DAMAGE_ARTHROPODS, level+1, true);
	      itemen.addEnchant(Enchant.DAMAGE_UNDEAD, level+1, true);
	      item.setItemMeta(itemen);
		  
			return is;
		}

		public static ItemStack AddArmorEnchantRandom(ItemStack item, int level)
		{
		  ItemStack is = item;
	      ItemMeta itemen = item.getItemMeta();
	      itemen.addEnchant(Enchant.DURABILITY, level+1, true);
	      itemen.addEnchant(Enchant.PROTECTION_ENVIRONMENTAL, level+1, true);
	      itemen.addEnchant(Enchant.PROTECTION_EXPLOSIONS, level+1, true);
	      itemen.addEnchant(Enchant.PROTECTION_FALL, level+1, true);
	      itemen.addEnchant(Enchant.PROTECTION_PROJECTILE, level+1, true);
	      itemen.addEnchant(Enchant.PROTECTION_FIRE, level+1, true);
	      item.setItemMeta(itemen);
		  
			return is;
		}
		
		
	  private static String randomkit()
	  {
		  Random r = new Random();
	      int n = r.nextInt(7);
	      if (n == 0)
	    	  return "§cviper";
	      if (n == 1)
	    	  return "§cunix";
	      if (n == 2)
	    	  return "§ccamel";
	      if (n == 3)
	    	  return "§cfrosty";
	      if (n == 4)
	    	  return "§csnail";
	      if (n == 5)
	    	  return "§carqueiro";
	      if (n == 6)
	    	  return "§cwither";
	      if (n == 7)
	    	  return "§cconfusion";
		  return "Nenhum";
	  }
}
