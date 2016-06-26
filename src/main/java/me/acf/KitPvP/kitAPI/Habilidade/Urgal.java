/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.acf.MiniGames.HungerGames.kits.Kit;
import me.hub.MiniPlugin;
import me.hub.recharge.Recharge;

/**
 * @author adriancf
 *
 */
public class Urgal extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Urgal(JavaPlugin plugin) {
		super("Kit Urgal", plugin);
		// TODO Auto-generated constructor stub
	}

	
	  @EventHandler
	  public void Urgal(PlayerInteractEvent event)
	  {
	    if (event.getAction().name().contains("RIGHT"))
	    {
	      Player p = event.getPlayer();
	      if ((Kit.verkit(p).contains("Urgal")) &&  
	        (event.getItem() != null) && (event.getItem().getType() == Material.GOLD_NUGGET))
	      {
	        event.setCancelled(true);
	 	   if (!Recharge.Instance.use(p, "Urgal", 26900L, true, false)) {
               return;
             }
	        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0), true);
	        
	        event.getItem().setAmount(event.getItem().getAmount() - 1);
	        if (event.getItem().getAmount() == 0) {
	          p.setItemInHand(new ItemStack(0));
	        }
	      }
	    }
	  }
}
