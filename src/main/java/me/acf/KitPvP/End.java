/**
 * 
 */
package me.acf.KitPvP;

import java.util.Random;

import me.hub.MiniPlugin;
import me.hub.API.Enchant;
import me.hub.API.Util.UtilEnchant;
import me.hub.API.Util.UtilFirework;
import me.hub.API.Util.UtilHolo;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilServer;
import me.hub.Scoreboard.ScoreboardAPI;
import me.hub.config.Config;
import me.hub.recharge.Recharge;
import me.site.account.Account;
import me.site.account.rank.Rank;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

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
	    	    Location loc = tile.getLocation();
	      		loc.setY(loc.getY() -1);
	    		int block1 = loc.getWorld().getBlockTypeIdAt(loc);
	    		if (block1 == 169)
	    		{
	    		Location loc1 = tile.getLocation();
	    		loc1.setY(loc.getY() -1.5);
	    		EndmagicLOC = loc1;
	    		UtilHolo.HoloPerm(End.EndmagicLOC, "§b§lEndMagic §f§l- §6Gastará §f1 §6§lCHAVE");
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
    	 
    	   if ((Account.getRank(p)).Has(p, Rank.VIP, false))
		   {
    	  premio = Premio(p, r.nextInt(260));
		   }
    	   else
    	   {
    		   premio = Premio(p, r.nextInt(80));
    	   }
    	  if ((premio.contains("nada")) || (premio.contains("Planets"))) 
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
		   {  c = "§a§lCapacete de Ferro";
		   if (p.getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 1)
		   {
			   
		   }
		   else
	          p.getInventory().setHelmet(UtilInv.AddItemReturn(Material.IRON_HELMET, 1, (byte)0, "§a§lCapacete de Ferro", ""));
        	  UtilInv.save(p);	   
		   }
		   if ((Numero > 31) && (Numero < 40))
		   {  c = "§a§lPeitoral de Ferro";
		   if (p.getInventory().getChestplate().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 1)
		   {
			   
		   }
		   else
	          p.getInventory().setChestplate(UtilInv.AddItemReturn(Material.IRON_CHESTPLATE, 1, (byte)0, "§a§lPeitoral de Ferro", ""));
        	  UtilInv.save(p);	   
		   }
		   if ((Numero > 41) && (Numero < 50))
		   {  c = "§a§lCalça de Ferro";
		   if (p.getInventory().getLeggings().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 1)
		   {
			   
		   }
		   else
	          p.getInventory().setLeggings(UtilInv.AddItemReturn(Material.IRON_LEGGINGS, 1, (byte)0, "§a§lCalça de Ferro", ""));
        	  UtilInv.save(p);	   
		   }
		   if ((Numero > 51) && (Numero < 60))
		   {  c = "§a§lBota de Ferro";
		   if (p.getInventory().getBoots().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 1)
		   {
			   
		   }
		   else
	          p.getInventory().setBoots(UtilInv.AddItemReturn(Material.IRON_BOOTS, 1, (byte)0, "§a§lBota de Ferro", ""));
        	  UtilInv.save(p);	   
		   }
		   if ((Numero > 61) && (Numero < 70))
		   {  c = "§a§lEspada de Ferro";

	        	  if (SetarEspada(p,"Espada de Ferro"))
	        	  Config.Set(p, "kitpvp.sword", "§a§lEspada de Ferro");
	          
		   }
		   if ((Numero > 71) && (Numero < 198))
		   {  
			   String kit = randomkit();
			   c = "§a§lKit " + kit;
			   Config.addn(p, "kitpvp.kits." + kit, "sim");
		   
		   }
		   if ((Numero > 199) && (Numero < 200))
		   {  c = "§a§l+10 Planets";
		      Account.AddCoins(p, 10);
		      ScoreboardAPI.remover(p, "Planets");
		      Account.UpdateAccount(p);
		   }
		   if ((Numero > 201) && (Numero < 225))
		   { 
			   c = "§a§lEspada de Diamante";
	           Config.Set(p, "kitpvp.sword", "§a§lEspada de Diamante");
	          
		   }
		   if ((Numero > 226) && (Numero < 230))
		   {
			 c = "§a§lCapacete de Ferro Protection 1";
			 p.getInventory().setHelmet(UtilEnchant.addEnchant(UtilInv.AddItemReturn(Material.IRON_HELMET, 1, (byte)0, "§a§lCapacete de Ferro", ""), Enchant.PROTECTION_ENVIRONMENTAL, 1));
			 UtilInv.save(p);
		   }
		   if ((Numero > 231) && (Numero < 245))
		   {
			 c = "§a§lPeitoral de Ferro Protection 1";
			 p.getInventory().setChestplate(UtilEnchant.addEnchant(UtilInv.AddItemReturn(Material.IRON_CHESTPLATE, 1, (byte)0, "§a§lPeitoral de Ferro", ""), Enchant.PROTECTION_ENVIRONMENTAL, 1));
			 UtilInv.save(p);
		   }
		   if ((Numero > 246) && (Numero < 253))
		   {
			 c = "§a§lCalça de Ferro Protection 1";
			 p.getInventory().setLeggings(UtilEnchant.addEnchant(UtilInv.AddItemReturn(Material.IRON_LEGGINGS, 1, (byte)0, "§a§lCalça de Ferro", ""), Enchant.PROTECTION_ENVIRONMENTAL, 1));
			 UtilInv.save(p);
		   }
		   if ((Numero > 254) && (Numero < 260))
		   {
			 c = "§a§lBota de Ferro Protection 1";
			 p.getInventory().setBoots(UtilEnchant.addEnchant(UtilInv.AddItemReturn(Material.IRON_BOOTS, 1, (byte)0, "§a§lBota de Ferro", ""), Enchant.PROTECTION_ENVIRONMENTAL, 1));
			 UtilInv.save(p);
		   }
		   return c;	   
		  
		   }
	  
	  
	  public static boolean SetarEspada(Player p, String espada)
	  {
		  String sword = Config.retornar(p, "kitpvp.sword");
		  if (espada.contains("Diamante"))
          {
			  if (sword.contains("Pedra"))
				  return true;
			  if (sword.contains("Ferro"))
				  return false;
				  else
					  return true;
          }
		  else
		  if (espada.contains("Ferro"))
          {
			  if (sword.contains("Diamante"))
				  return false;
				  else
					  return true;
          }
		  return false;
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
	    	  return "§ckangaroo";
	      if (n == 6)
	    	  return "§cwither";
	      if (n == 7)
	    	  return "§cconfusion";
		  return "Nenhum";
	  }
}
