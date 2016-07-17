/**
 * 
 */
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
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.recharge.Recharge;


/**
 * @author adriancf
 *
 */
public class Cow extends MorphLoader

{
	
	
public Cow(JavaPlugin plugin) {
	super("§aCow", plugin, Material.MONSTER_EGG, 65,"§eTransforme numa vaca.", "§9Comun");

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
	
    if (!Recharge.Instance.use(player, GetName(), 1900L, true, false)) {
        return;
      }    
	
    UtilSound.playSound(player.getLocation(), Sounds.COW_IDLE, 1f, 1f);
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
		  Entity cow = jogador.getWorld().spawnEntity(jogador.getLocation(), EntityType.COW);
		  Morph.AtivarGadgets(GetName(), jogador, cow);
		  cow.remove();
      }
  	    }
  } catch (Exception e1) {
	  }
}
}
