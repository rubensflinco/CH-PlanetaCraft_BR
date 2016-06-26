/**
 * 
 */
package me.acf.SkyBlock;

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
          premio = Premio(p, r.nextInt(139));
    	   
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
	       
		   
		   if ((Numero > 10) && (Numero < 100))
		   {
			   p.getInventory().addItem(UtilInv.AddItemReturn(Material.DIAMOND_BLOCK, 2 , (byte) 0 ,"Bloco de Diamante",""));
			   c = "§c§lBloco de Diamante";
		   }
		  
		   if ((Numero > 105) && (Numero < 107))
		   {
			   p.getInventory().addItem(UtilInv.AddItemReturn(Material.GOLDEN_APPLE, 2 , (byte) 1 ,"Golden Apple",""));
			   c = "§c§lGolden Apple";
		   }
		   if ((Numero > 110) && (Numero < 130))
		   {
			   p.getInventory().addItem(new ItemStack(Material.values()[new Random().nextInt(Material.values().length)]));
		       c = "§c§lItens";
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
