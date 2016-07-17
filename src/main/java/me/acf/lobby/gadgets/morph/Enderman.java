
package me.acf.lobby.gadgets.morph;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.lobby.gadgets.Menu;
import me.acf.lobby.gadgets.Morph;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.acf.lobby.gadgets.loader.MorphLoader;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilFirework;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.recharge.Recharge;



/**
 * @author adriancf
 *
 */
public class Enderman extends MorphLoader

{
	
	
public Enderman(JavaPlugin plugin) {
	super("§aEnderman", plugin, Material.MONSTER_EGG, 58,"§eTransforme num Enderman.", "§9Raro");

	}


@EventHandler
public void teleport(PlayerInteractEvent event)
{try {
	Player player = event.getPlayer();

	if (player.getGameMode() == GameMode.CREATIVE)
		return;

	if (!Morph.MophU.get(player).equals(GetName()))
		return;

    if (((event.getAction() == Action.LEFT_CLICK_AIR) || 
    	      (event.getAction() == Action.LEFT_CLICK_BLOCK))) 
    	     
    	    {


	   if (!Recharge.Instance.use(player, GetName(), 2900L, true, false)) {
	        return;
	      }  

	
	Block lastSmoke = player.getLocation().getBlock();

	int curRange = 0;
	while (curRange <= 16)
	{
		Location newTarget = player.getLocation().add(new Vector(0,0.2,0)).add(player.getLocation().getDirection().multiply(curRange));

		curRange++;
		if (UtilBlock.airFoliage(newTarget.getBlock()) || 
				UtilBlock.airFoliage(newTarget.getBlock().getRelative(BlockFace.UP)))
		{


		
		if (!lastSmoke.equals(newTarget.getBlock()))
		{
			lastSmoke.getWorld().playEffect(lastSmoke.getLocation(), Effect.SMOKE, 4);
		}

		lastSmoke = newTarget.getBlock();
	}
	}

	
	curRange -= 0.4;
	if (curRange < 0)
		curRange = 0;

	
	Location loc = lastSmoke.getLocation();

	if (curRange > 0)
	{
		
		FireworkEffect effect = FireworkEffect.builder().flicker(false).withColor(Color.BLACK).with(Type.BALL).trail(false).build();

		try 
		{
			UtilFirework.playFirework(player.getEyeLocation(), effect);
			UtilSound.playSound(player.getLocation(), Sounds.ZOMBIE_UNFECT, 2f, 2f);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		player.teleport(loc.clone().add(0,5,0));

		
		try 
		{
			UtilFirework.playFirework(player.getEyeLocation(), effect);
			UtilSound.playSound(player.getLocation(), Sounds.ZOMBIE_UNFECT, 2f, 2f);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

    	    }
	player.setFallDistance(0);
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
		  Entity cow = jogador.getWorld().spawnEntity(jogador.getLocation(), EntityType.ENDERMAN);
		  Morph.AtivarGadgets(GetName(), jogador, cow);
		  cow.remove();
      }
  	    }
  } catch (Exception e1) {
	  }
}
}
