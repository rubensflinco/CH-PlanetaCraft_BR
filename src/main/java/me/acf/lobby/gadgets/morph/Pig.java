
package me.acf.lobby.gadgets.morph;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.Menu;
import me.acf.lobby.gadgets.Morph;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.acf.lobby.gadgets.loader.MorphLoader;
import me.hub.recharge.Recharge;


/**
 * @author adriancf
 *
 */
public class Pig extends MorphLoader

{
	
	
public Pig(JavaPlugin plugin) {
	super("§aPig", plugin, Material.MONSTER_EGG, 90,"§eTransforme num Porco.", "§9Comun");

	}

@EventHandler
public void Audio(PlayerInteractEvent event)
{
	Player player = event.getPlayer();
try {
	if (!Morph.MophU.get(player).equals(GetName()))
		return;

	if (!(event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK))
		   return;
	
    if (!Recharge.Instance.use(player, GetName(), 2900L, true, false)) {
        return;
      }    
	
	player.getWorld().playSound(player.getLocation(), Sound.PIG_IDLE, 1f, (float)(0.75 + Math.random() * 0.5));
} catch (Exception e) {
	
}

}

@EventHandler
public void Iventarioitens(InventoryClickEvent e)
{
  Player jogador = (Player)e.getWhoClicked();
  try {
  if ((e.getInventory().getTitle().contains("Personalizar.")) && 
  	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
  	    {
	  if (e.getCurrentItem().getItemMeta().getDisplayName().equals(GetName()))
      {
		  Entity cow = jogador.getWorld().spawnEntity(jogador.getLocation(), EntityType.PIG);
		  Morph.AtivarGadgets(GetName(), jogador, cow);
		  cow.remove();
      }
  	    }
  } catch (Exception e1) {
	  }
}
}
