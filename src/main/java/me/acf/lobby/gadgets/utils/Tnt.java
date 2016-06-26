package me.acf.lobby.gadgets.utils;

import java.util.HashSet;

import me.acf.lobby.extend.Lobby;
import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.API.Util.UtilNPC;
import me.hub.recharge.Recharge;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Tnt extends GadGetsLoader

{


public Tnt(JavaPlugin plugin) {
	super("§aTnt Gun", plugin, Material.TNT, "§eExploda tudo que você ver.");

	}


private HashSet<Entity> Tnt = new HashSet();
  

@EventHandler
public void onExplosion(EntityExplodeEvent e)
{
  if (!(e.getEntity() instanceof TNTPrimed)) {
    return;
  }
  if (!this.Tnt.contains(e.getEntity())) {
    return;
  }
  this.Tnt.remove(e.getEntity());
  e.setCancelled(true);
  for (Entity ent : e.getEntity().getNearbyEntities(6.0D, 6.0D, 6.0D)) {
    if ((ent instanceof Player)) {
   
    	if (ent.getName().contains("§e§o"))
    		return;
    	if (UtilNPC.entitys.containsKey(ent.getName()))
    		return;
        double dX = e.getEntity().getLocation().getX() - ent.getLocation().getX();
        double dY = e.getEntity().getLocation().getY() - ent.getLocation().getY();
        double dZ = e.getEntity().getLocation().getZ() - ent.getLocation().getZ();
        double yaw = Math.atan2(dZ, dX);
        double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + 3.141592653589793D;
        double X = Math.sin(pitch) * Math.cos(yaw);
        double Y = Math.sin(pitch) * Math.sin(yaw);
        double Z = Math.cos(pitch);
        
        Vector vector = new Vector(X, Z, Y);
        ent.setVelocity(vector.multiply(1.321483642374632D).add(new Vector(0.0D, 1.4397268432482635D, 0.0D)));
        ent.getWorld().playEffect(ent.getLocation(), Effect.EXPLOSION_HUGE, 1);
      }
    
  }
}

@EventHandler
public void Tnt(PlayerInteractEvent event)
{
	try {
  final Player p = event.getPlayer();
  if ((event.getAction() != Action.RIGHT_CLICK_AIR) && (event.getAction() != Action.RIGHT_CLICK_BLOCK)) {
    return;
  }
  if (event.getItem() == null)
      return;
    if (event.getItem().getItemMeta().getDisplayName() == null)
      return;
  ItemStack item = (ItemStack)Gadgets.gadgets.get(GetName());
  if (!event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(item.getItemMeta().getDisplayName())) 
    return;
  event.setCancelled(true);
  p.updateInventory();
  if (!Recharge.Instance.use(p, GetName(), 1900L, true, false)) {
      return;
    }
  Gadgets.Quantidade(event.getPlayer(), GetName());
  TNTPrimed tnt = (TNTPrimed)p.getWorld().spawn(p.getLocation().add(0.0D, 2.0D, 0.0D), TNTPrimed.class);
  
  tnt.setVelocity(p.getLocation().getDirection().multiply(0.854321D));
  this.Tnt.add(tnt);
	} catch (Exception e) {
		
	}
}

  
}