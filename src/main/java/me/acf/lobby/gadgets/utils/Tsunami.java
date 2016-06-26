package me.acf.lobby.gadgets.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.antiHack.AntiHack;
import me.hub.Main;
import me.hub.API.Util.Particles;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilDirection;
import me.hub.API.Util.UtilLocation;
import me.hub.API.Util.UtilMath;
import me.hub.API.Util.UtilParticles;
import me.hub.API.Util.UtilPlayer;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.recharge.Recharge;
import net.minecraft.server.v1_8_R3.EntityItem;

public class Tsunami extends GadGetsLoader

{


public Tsunami(JavaPlugin plugin) {
	super("§aTsunami", plugin, Material.ARROW, "§eCrie um tsunami.");

	}

private HashSet<Projectile> _balls = new HashSet();
private ArrayList playert = new ArrayList<Player>();
  
  @EventHandler
  public void onEvent(final PlayerInteractEvent event)
  {
	 try {
      final Player player = event.getPlayer();
      Location playerLocation = player.getLocation();
      if ((event.getAction() != Action.RIGHT_CLICK_AIR) && (event.getAction() != Action.RIGHT_CLICK_BLOCK)) {
          return;
        }
      
      if (event.getPlayer().getItemInHand() == null) {
          return;
        }
        if (event.getItem() == null)
            return;
          if (event.getItem().getItemMeta().getDisplayName() == null)
            return;
        ItemStack item2 = (ItemStack)Gadgets.gadgets.get(GetName());
        if (!event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(item2.getItemMeta().getDisplayName())) 
            return;
        event.setCancelled(true);
        if (!Recharge.Instance.use(event.getPlayer(), GetName(), 1900L, true, false)) {
            return;
          }
     
        
        Projectile proj = UtilPlayer.Disparo(player, EnderPearl.class);
        proj.setVelocity(proj.getVelocity().multiply(2));
        this._balls.add(proj);
        playert.add(player);
        player.getWorld().playSound(player.getLocation(), Sound.WATER, 1.5F, 1.2F);
        Gadgets.Quantidade(event.getPlayer(), GetName());
	 
	} catch (Exception e) {
		
	}

     
  }
  @EventHandler
  public void Paint(ProjectileHitEvent event)
  {

    if (!this._balls.remove(event.getEntity())) {
      return;
    }
    Random random = new Random();
    final Entity i = event.getEntity();
    i.getWorld().playSound(i.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
    i.getWorld().playEffect(i.getLocation(), Effect.EXPLOSION_LARGE, 103);
    for (int k = 0; k < 5; k++)
    {
      final EntityItem ei = new EntityItem(
        ((CraftWorld)i.getWorld()).getHandle(), 
        i.getLocation().getX(), 
        i.getLocation().getY(), 
        i.getLocation().getZ(), 
        CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.WATER_BUCKET)))
        {
          public boolean a(EntityItem entityitem)
          {
            return false;
          }
        };
        Item item = (Item)ei.getBukkitEntity();
        item.setPickupDelay(0);
        item.setCustomName("§9§lTsunami");
        item.setCustomNameVisible(true);
        item.setVelocity(new Vector(random.nextDouble() - 0.5D, random.nextDouble() / 2.0D, random.nextDouble() - 0.5D).multiply(0.75D));
        ((CraftWorld)i.getWorld()).getHandle().addEntity(ei);
        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable()
        {
          public void run()
          {
            try
            {
              ((CraftWorld)i.getWorld()).getHandle().removeEntity(ei);
            }
            catch (Exception localException) {}
          }
        }, 100L);
      }  
  }
  
  @EventHandler
  public void onPickUp(PlayerPickupItemEvent e)
  {
	  try {
    Player p = e.getPlayer();
    Item item = e.getItem();
    if (item.getCustomName().contains("Tsunami"))
    {
      e.setCancelled(true);
      if (item.getItemStack().getType() == Material.WATER_BUCKET)
      {
        p.playSound(p.getLocation(), Sound.WATER, 1.5F, 1.0F);
        item.remove();
      }
    }
	  } catch (Exception e1) {
			
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
    if (event.getType() != ModosUpdate.TICK) {
      return;
    }
    for (Entity ent : Bukkit.getWorld("world").getEntities()) {
    	if ((ent instanceof Projectile))
        {
    		if (_balls.contains(ent))
    		{
    			Location loc1 = ent.getLocation().clone().add(UtilMath.randomDouble(-1.5, 1.5), UtilMath.randomDouble(0, .5) - 0.75, UtilMath.randomDouble(-1.5, 1.5));
                Location loc2 = ent.getLocation().clone().add(UtilMath.randomDouble(-1.5, 1.5), UtilMath.randomDouble(1.3, 1.8) - 0.75, UtilMath.randomDouble(-1.5, 1.5));
                for (int i = 0; i < 6; i++) {
                    UtilParticles.display(Particles.EXPLOSION_NORMAL, 0.2d, 0.2d, 0.2d, loc1, 1);
                    UtilParticles.display(Particles.DRIP_WATER, 0.4d, 0.4d, 0.4d, loc2, 2);
                    UtilParticles.display(Particles.DRIP_WATER, 0.7d, 0.7d, 0.7d, loc2, 2);
                    UtilParticles.display(Particles.DRIP_WATER, 0.8d, 0.8d, 0.8d, loc2, 2);
                    UtilParticles.display(Particles.EXPLOSION_NORMAL, 0.2d, 0.2d, 0.2d, loc1, 1);
                    UtilParticles.display(Particles.DRIP_WATER, 0.5d, 0.5d, 0.5d, loc2, 2);
                    UtilParticles.display(Particles.EXPLOSION_NORMAL, 0.3d, 0.3d, 0.3, loc1, 1);
                    UtilParticles.display(Particles.DRIP_WATER, 0.6d, 0.6d, 0.6d, loc2, 2);
                }
    		}
        }
  }
    }
  
 

}
