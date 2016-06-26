package me.acf.lobby.gadgets.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.Ler;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilPlayer;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.recharge.Recharge;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PaintballGun extends GadGetsLoader

{
	
	
public PaintballGun(JavaPlugin plugin) {
	super("§aPaintBall Gun", plugin, Material.GOLD_BARDING, "§eUma arma de modificação de blocos.");

	}

private HashSet<Projectile> _balls = new HashSet();
private ArrayList playert = new ArrayList<Player>();
  
  

  
  @EventHandler
  public void Shoot(PlayerInteractEvent event)
  {
	  try {
    if ((event.getAction() != Action.RIGHT_CLICK_AIR) && (event.getAction() != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    if (UtilBlock.usable(event.getClickedBlock())) {
      return;
    }
    if (event.getItem() == null)
        return;
      if (event.getItem().getItemMeta().getDisplayName() == null)
        return;
    if (event.getPlayer().getItemInHand().getItemMeta().getDisplayName() == null) 
        return;
    ItemStack item = (ItemStack)Gadgets.gadgets.get(GetName());
    if (!event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(item.getItemMeta().getDisplayName())) 
      return;
    
    Player player = event.getPlayer();
    event.setCancelled(true);
    
    if (!Recharge.Instance.use(event.getPlayer(), GetName(), 800L, true, false)) {
        return;
      }
    Gadgets.Quantidade(event.getPlayer(), GetName());

    
    Projectile proj = UtilPlayer.Disparo(player, EnderPearl.class);
    proj.setVelocity(proj.getVelocity().multiply(2));
    this._balls.add(proj);
    playert.add(player);
    player.getWorld().playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.5F, 1.2F);
		} catch (Exception e) {
			
		}
	  }
  
  @EventHandler
  public void Paint(ProjectileHitEvent event)
  {

    if (!this._balls.remove(event.getEntity())) {
      return;
    }
    Location loc = event.getEntity().getLocation().add(event.getEntity().getVelocity());
    loc.getWorld().playEffect(loc, Effect.STEP_SOUND, 49);
    
    byte color = 2;
    double r = Math.random();
    if (r > 0.8D) {
      color = 4;
    } else if (r > 0.6D) {
      color = 5;
    } else if (r > 0.4D) {
      color = 9;
    } else if (r > 0.2D) {
      color = 14;
    }
    for (Block block : UtilBlock.getInRadius(loc, 5.0D).keySet())
    {
      if (block.getType() == Material.PORTAL) {
        return;
      }
      if (block.getType() == Material.CACTUS) {
        return;
      }
      if (block.getType() == Material.ENDER_CHEST) {
          return;
        }
      if (block.getType() == Material.CHEST) {
          return;
        }
      if (block.getType() == Material.JUKEBOX) {
          return;
        }
      if (block.getType() == Material.ARMOR_STAND) {
          return;
        }
      if (block.getTypeId() == 31) {
          return;
        }
      if (block.getTypeId() == 38) {
          return;
        }
      if (block.getTypeId() == 50) {
          return;
        }
      if (block.getTypeId() == 389) {
          return;
        }
      if (block.getTypeId() == 323) {
          return;
        }
      if (block.getTypeId() == 65) {
          return;
        }
    }
    for (Block block : UtilBlock.getInRadius(loc, 1.5D).keySet()) {
      if (UtilBlock.solid(block)) {
        if (block.getType() == Material.CARPET) {
          Ler.GetBlockRestore().Add(block, 171, color, 4000L);
        } else {
          Ler.GetBlockRestore().Add(block, 159, color, 4000L);
        }
      }
    }
  }
  
  @EventHandler
  public void Teleport(PlayerTeleportEvent event)
  {
    if (event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
    if (playert.contains(event.getPlayer()))
    {
      event.setCancelled(true);
       playert.remove(event.getPlayer());
    }
    }
  }
  
  @EventHandler
  public void cleanupBalls(Atualizar event)
  {
    if (event.getType() != ModosUpdate.SLOW) {
      return;
    }
    for (Iterator<Projectile> ballIterator = this._balls.iterator(); ballIterator.hasNext();)
    {
      Projectile ball = (Projectile)ballIterator.next();
      if ((ball.isDead()) || (!ball.isValid())) {
        ballIterator.remove();
      }
    }
  }
}
