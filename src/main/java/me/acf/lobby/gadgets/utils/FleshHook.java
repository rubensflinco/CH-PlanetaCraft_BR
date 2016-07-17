package me.acf.lobby.gadgets.utils;

import java.util.HashMap;
import java.util.List;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.Main;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.recharge.Recharge;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class FleshHook extends GadGetsLoader

{

	
public FleshHook(JavaPlugin plugin) {
	super("§aFleshHook", plugin, Material.TRIPWIRE_HOOK, "§eArremesse os jogadore para você.");
	}

HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap();

@EventHandler
public void Melon(PlayerInteractEvent event)
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
  ItemStack item2 = (ItemStack)Gadgets.gadgets.get(GetName());
  if (!event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(item2.getItemMeta().getDisplayName())) 
      return;
  event.setCancelled(true);
  
  p.updateInventory();
  if (!Recharge.Instance.use(event.getPlayer(), GetName(), 1100L, true, false)) {
      return;
    }
  Gadgets.Quantidade(event.getPlayer(), GetName());
  final Item item = p.getWorld().dropItem(p.getEyeLocation().add(p.getLocation().getDirection().multiply(2.0471975511965974D)), new ItemStack(Material.TRIPWIRE_HOOK));
  item.setPickupDelay(0);
  setMetadata(item, "flesh", p.getName(), Main.plugin);
  item.setVelocity(p.getLocation().getDirection().add(new Vector(0.0D, 0.1313123444543524D, 0.0D)));
  Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
  {
    public void run()
    {
      
      
      item.remove();
    }
  }, 30L);
	} catch (Exception e) {
		
	}
}
public void setMetadata(Item item, String key, Object value, Main plugin)
{
  item.setMetadata(key, new FixedMetadataValue(plugin, value));
}



@EventHandler
public void onPickUp(PlayerPickupItemEvent e)
{
  Player p = e.getPlayer();
  Item item = e.getItem();
  if (item.hasMetadata("flesh"))
  {
    e.setCancelled(true);
    try
    {
      Player player = null;
      List<MetadataValue> pl = item.getMetadata("flesh");
      for (MetadataValue s : pl) {
        player = Bukkit.getPlayer(s.asString());
      }
      if (p.hasMetadata("NPC")) {
        return;
      }
      if (p.getName() == player.getName()) {
        return;
      }
    
      p.playEffect(EntityEffect.HURT);
      item.remove();
      double dX = p.getLocation().getX() - player.getLocation().getX();
      double dY = p.getLocation().getY() - player.getLocation().getY();
      double dZ = p.getLocation().getZ() - player.getLocation().getZ();
      double yaw = Math.atan2(dZ, dX);
      double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + 3.141592653589793D;
      double X = Math.sin(pitch) * Math.cos(yaw);
      double Y = Math.sin(pitch) * Math.sin(yaw);
      double Z = Math.cos(pitch);
      
      Vector vector = new Vector(X, Z, Y);
      p.setVelocity(vector.multiply(2.5D).add(new Vector(0.0D, 1.45D, 0.0D)));
    }
    catch (Exception localException) {}
  }
}

@EventHandler
public void onUpdate(Atualizar e)
{
  if (e.getType() == ModosUpdate.TICK)
  {
    for (Player p : Bukkit.getOnlinePlayers())
    {
      
      for (Entity ent : p.getWorld().getEntities()) {
        if ((ent instanceof Item))
        {
          Item i = (Item)ent;
          if (i.hasMetadata("flesh"))
          {
            if ((i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.AIR) && 
              (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.STATIONARY_WATER) && 
              (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.WATER)) {
              return;
            }
            i.getWorld().playEffect(i.getLocation(), Effect.CRIT, 2);
	  	      
            UtilSound.playSound(i.getLocation(), Sounds.CLICK, 0.1F, 1.0F);
          } 
        }
      }
    }
  }
}
  
}