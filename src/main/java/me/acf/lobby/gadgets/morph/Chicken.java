/**
 * 
 */
package me.acf.lobby.gadgets.morph;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

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
public class Chicken extends MorphLoader

{
	
	
public Chicken(JavaPlugin plugin) {
	super("§aChicken", plugin, Material.MONSTER_EGG, 93,"§eTransforme numa galinha.", "§9Raro");

	}

private static ArrayList<Entity> ovo = new ArrayList<>();

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
	
	Vector offset = player.getLocation().getDirection();
	if (offset.getY() < 0)
		offset.setY(0);

	Egg egg = player.getWorld().spawn(player.getLocation().add(0, 0.5, 0).add(offset), Egg.class);
	egg.setVelocity(player.getLocation().getDirection().add(new Vector(0,0.2,0)));
	egg.setShooter(player);
	ovo.add(egg);

	UtilSound.playSound(player.getLocation(), Sounds.CHICKEN_EGG_POP, 0.5f, 1f);
} catch (Exception e) {
	
}

}

@EventHandler
public void EggHit(ProjectileHitEvent event)
{
	if (event.getEntity() instanceof Egg)
	{
		if (!ovo.contains(event.getEntity()))
		return;
		UtilSound.playSound(event.getEntity().getLocation(), Sounds.CHICKEN_WALK, 0.5f, 1f);
		UtilSound.playSound(event.getEntity().getLocation(), Sounds.EXPLODE, 0.5f, 1f);
		event.getEntity().remove();
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
		  Entity cow = jogador.getWorld().spawnEntity(jogador.getLocation(), EntityType.CHICKEN);
		  Morph.AtivarGadgets(GetName(), jogador, cow);
		  cow.remove();
      }
  	    }
  } catch (Exception e1) {
	  }
}
}
