package me.acf.lobby.gadgets.utils;

import java.util.Random;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.Main;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.recharge.Recharge;
import net.minecraft.server.v1_8_R3.EntityItem;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class MelonBomba extends GadGetsLoader

{

	
public MelonBomba(JavaPlugin plugin) {
	super("§aMelonBomb", plugin, Material.MELON_BLOCK, "§eDispare bombas de melão.");
	}

  

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
    ItemStack item3 = (ItemStack)Gadgets.gadgets.get(GetName());
    if (!event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(item3.getItemMeta().getDisplayName())) 
      return;
  
  event.setCancelled(true);
  p.updateInventory();
  if (!Recharge.Instance.use(event.getPlayer(), GetName(), 1900L, true, false)) {
      return;
    }
  Gadgets.Quantidade(event.getPlayer(), GetName());
  final Item item = p.getWorld().dropItem(p.getEyeLocation().add(p.getLocation().getDirection().multiply(2.0471975511965974D)), new org.bukkit.inventory.ItemStack(Material.MELON_BLOCK));
  item.setPickupDelay(0);
  item.setCustomName("GAD");
  setMetadata(item, "GAD", p.getName(), Main.plugin);
  item.setVelocity(p.getLocation().getDirection().add(new Vector(0.0D, 0.1313123444543524D, 0.0D)));
  
  final Item item2 = p.getWorld().dropItem(p.getEyeLocation().add(p.getLocation().getDirection().multiply(2.0471975511965974D)), new org.bukkit.inventory.ItemStack(Material.MELON_BLOCK));
  item2.setPickupDelay(0);
  item2.setCustomName("GAD");
  setMetadata(item2, "GAD", p.getName(), Main.plugin);
  item2.setVelocity(p.getLocation().getDirection().add(new Vector(0.0D, 0.1313123444543524D, 0.0D)));
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
  if (item.hasMetadata("GAD"))
  {
    e.setCancelled(true);
    if (item.getItemStack().getType() == Material.MELON)
    {
      p.playSound(p.getLocation(), Sound.EAT, 1.5F, 1.0F);
      item.remove();
      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 2));
    }
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
          final Item i = (Item)ent;
          if ((i.hasMetadata("GAD")) && 
            (i.getItemStack().getType() == Material.MELON_BLOCK) && 
            (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.AIR) && (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.STATIONARY_WATER) && (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.WATER))
          {
            i.remove();
            Random random = new Random();
            i.getWorld().playSound(i.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
            i.getWorld().playEffect(i.getLocation(), Effect.STEP_SOUND, 103);
            for (int k = 0; k < 5; k++)
            {
              final EntityItem ei = new EntityItem(
                ((CraftWorld)i.getWorld()).getHandle(), 
                i.getLocation().getX(), 
                i.getLocation().getY(), 
                i.getLocation().getZ(), 
                CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.MELON)))
                {
                  public boolean a(EntityItem entityitem)
                  {
                    return false;
                  }
                };
                Item item = (Item)ei.getBukkitEntity();
                item.setPickupDelay(0);
                setMetadata(item, "GAD", p.getName(), Main.plugin);
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
          }
        }
      }
    }
  }
  
}