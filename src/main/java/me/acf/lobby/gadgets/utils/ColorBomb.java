package me.acf.lobby.gadgets.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.Main;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilMath;
import me.hub.API.Util.UtilPlayer;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.recharge.Recharge;
import net.minecraft.server.v1_8_R3.EntityItem;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class ColorBomb extends GadGetsLoader

{

	
public ColorBomb(JavaPlugin plugin) {
	super("§aColorBomb", plugin, Material.WOOL, "§eBomba de lâ.");
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
    if (event.getPlayer().getItemInHand() == null) {
      return;
    }
    ItemStack item2 = (ItemStack)Gadgets.gadgets.get(GetName());
    if (event.getItem() == null)
        return;
      if (event.getItem().getItemMeta().getDisplayName() == null)
        return;
    if (!event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(item2.getItemMeta().getDisplayName())) 
        return;
    Player player = event.getPlayer();


    event.setCancelled(true);
    player.updateInventory();
    if (!Recharge.Instance.use(player, GetName(), 12900L, true, false)) {
        return;
      }
    Gadgets.Quantidade(event.getPlayer(), GetName());
    Random random = new Random(); 
    final Item item = player.getWorld().dropItem(player.getEyeLocation().add(player.getLocation().getDirection().multiply(2.0471975511965974D)), new ItemStack(Material.WOOL, 1,(byte) random.nextInt(15)));
    item.setPickupDelay(0);
    setMetadata(item, "colorbomb", player.getName(), Main.plugin);
    item.setVelocity(player.getLocation().getDirection().add(new Vector(0.0D, 0.1313123444543524D, 0.0D)));
    playert.add(event.getPlayer());
    player.getWorld().playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.5F, 1.2F);
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
    {
      public void run()
      {
        
        
        item.remove();
      }
    }, 320L);
  
  }
 catch (Exception e) {
}
}
  
  
  public void setMetadata(Item item, String key, Object value, Main plugin)
  {
    item.setMetadata(key, new FixedMetadataValue(plugin, value));
  }

  @EventHandler
  public void Teleport(PlayerTeleportEvent event)
  {
    if (event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
    	
    	if (playert.contains(event.getPlayer())) {
    Location loc = event.getTo().clone().add(0,2,0);
    UtilPlayer.Teleportar(event.getPlayer(), loc);
    event.setCancelled(true);
    playert.remove(event.getPlayer());
    	}
    
    }
  }
  
  @EventHandler
  public void onUpdate(Atualizar e)
  {
    if (e.getType() == ModosUpdate.TICK)
    {

        for (Entity ent : Bukkit.getWorld("world").getEntities()) {
          if ((ent instanceof Item))
          {
            final Item i = (Item)ent;
            if ((i.hasMetadata("colorbomb")) && 
              (i.getItemStack().getType() == Material.WOOL && 
              (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.AIR) && (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.STATIONARY_WATER) && (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.WATER)))
            {
              Random random = new Random();
              i.getWorld().playSound(i.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
              i.getWorld().playEffect(i.getLocation(), Effect.FIREWORKS_SPARK, 103);
              i.getWorld().playEffect(i.getLocation(), Effect.WITCH_MAGIC, 103);
              i.getWorld().playEffect(i.getLocation(), Effect.FLAME, 103);
              i.getWorld().playEffect(i.getLocation(), Effect.CRIT, 103);
              i.getWorld().playEffect(i.getLocation(), Effect.SLIME, 103);
              final Item item = ent.getWorld().dropItem(ent.getLocation().clone().add(random.nextInt(1),0,random.nextInt(1)), new ItemStack(Material.WOOL, 1,(byte) random.nextInt(15)));
              item.setPickupDelay(500000);
              int aleatorio = random.nextInt(9);
              if (aleatorio == 9)
                  item.setVelocity(new Vector(-0.2, 0.8, 0.2));
              if (aleatorio == 8)
                  item.setVelocity(new Vector(-0.2, 0.8, 0.0));
              if (aleatorio == 7)
              item.setVelocity(new Vector(0.0, 0.8, -0.2));
              if (aleatorio == 6)
              item.setVelocity(new Vector(0.0, 0.8, 0.2));
              if (aleatorio == 5)
              item.setVelocity(new Vector(0.2, 0.8, 0));
              if (aleatorio == 4)
              item.setVelocity(new Vector(0.2, 0.8, 0.2));
              if (aleatorio == 3)
              item.setVelocity(new Vector(-0.2, 0.8, 0));
              if (aleatorio == 2)
              item.setVelocity(new Vector(-0.2, 0.8, -0.2));
              if (aleatorio == 1)
              item.setVelocity(new Vector(0.2, 0.8, -0.2));
              item.setPickupDelay(0);
              final Item item2 = ent.getWorld().dropItem(ent.getLocation().clone().add(random.nextInt(1),0,random.nextInt(1)), new ItemStack(Material.WOOL, 1,(byte) random.nextInt(15)));
              item2.setPickupDelay(500000);
              int aleatorio2 = random.nextInt(9);
              if (aleatorio2 == 9)
                  item2.setVelocity(new Vector(-0.2, 0.8, 0.2));
              if (aleatorio2 == 8)
                  item2.setVelocity(new Vector(-0.2, 0.8, 0.0));
              if (aleatorio2 == 7)
              item2.setVelocity(new Vector(0.0, 0.8, -0.2));
              if (aleatorio2 == 6)
              item2.setVelocity(new Vector(0.0, 0.8, 0.2));
              if (aleatorio2 == 5)
              item2.setVelocity(new Vector(0.2, 0.8, 0)); //
              if (aleatorio2 == 4)
              item2.setVelocity(new Vector(0.2, 0.8, 0.2)); //
              if (aleatorio2 == 3)
              item2.setVelocity(new Vector(-0.2, 0.8, 0)); //
              if (aleatorio2 == 2)
              item2.setVelocity(new Vector(-0.2, 0.8, -0.2)); //
              if (aleatorio2 == 1)
              item2.setVelocity(new Vector(0.2, 0.8, -0.2));//
              item2.setPickupDelay(0);
              final Item item3 = ent.getWorld().dropItem(ent.getLocation().clone().add(random.nextInt(1),0,random.nextInt(1)), new ItemStack(Material.WOOL, 1,(byte) random.nextInt(15)));
              item3.setPickupDelay(500000);
              int aleatorio3 = random.nextInt(9);
              if (aleatorio3 == 9)
                  item3.setVelocity(new Vector(-0.2, 0.8, 0.2));
              if (aleatorio3 == 8)
                  item3.setVelocity(new Vector(-0.2, 0.8, 0.0));
              if (aleatorio3 == 7)
              item3.setVelocity(new Vector(0.0, 0.8, -0.2));
              if (aleatorio3 == 6)
              item3.setVelocity(new Vector(0.0, 0.8, 0.2));
              if (aleatorio3 == 5)
              item3.setVelocity(new Vector(0.2, 0.8, 0));
              if (aleatorio3 == 4)
              item3.setVelocity(new Vector(0.2, 0.8, 0.2));
              if (aleatorio3 == 3)
              item3.setVelocity(new Vector(-0.2, 0.8, 0));
              if (aleatorio3 == 2)
              item3.setVelocity(new Vector(-0.2, 0.8, -0.2));
              if (aleatorio3 == 1)
              item3.setVelocity(new Vector(0.2, 0.8, -0.2));
              item3.setPickupDelay(0);
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
              {
                public void run()
                {
                	item3.remove();
                  item2.remove();
                  item.remove();
                }
              }, 20L);
              for (Entity entity : ent.getNearbyEntities(1.5, 1, 1.5)) {
                  if (entity instanceof Player)
                          entity.setVelocity(new Vector(0, 0.8, 0));
              }
              }
            
          }
        }
      }
    }
}
