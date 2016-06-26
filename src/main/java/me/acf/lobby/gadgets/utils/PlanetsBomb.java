package me.acf.lobby.gadgets.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.Main;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilFirework;
import me.hub.API.Util.UtilPlayer;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.recharge.Recharge;
import me.site.account.Account;
import net.minecraft.server.v1_8_R3.EntityItem;

public class PlanetsBomb extends GadGetsLoader

{

	
public PlanetsBomb(JavaPlugin plugin) {
	super("§aPlanetsBomb", plugin, Material.GOLD_NUGGET, "§eBomba de Planets.");
}

private ArrayList playert = new ArrayList<Player>();
  


   @EventHandler
   public void Pegar(PlayerPickupItemEvent event)
   {
	   Item item = event.getItem();
	   if (item.hasMetadata("Planets"))
	   {
		   event.getPlayer().playSound(event.getPlayer().getLocation(),Sound.LEVEL_UP,1.5F, 1.2F);
		   Account.AddCoins(event.getPlayer(), 1);
		   event.getPlayer().sendMessage("§f§lVocê recebeu §6§l1 Planet.");
	   }
   }
   
  @EventHandler
  public void Bomb(PlayerInteractEvent event)
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
    final Item item = player.getWorld().dropItem(player.getEyeLocation().add(player.getLocation().getDirection().multiply(2.0471975511965974D)), new ItemStack(Material.GOLD_BLOCK, 1));
    item.setPickupDelay(0);
    setMetadata(item, "Planets", player.getName(), Main.plugin);
    item.setVelocity(player.getLocation().getDirection().add(new Vector(0.0D, 0.1313123444543524D, 0.0D)));
    playert.add(event.getPlayer());
    player.getWorld().playSound(player.getLocation(), Sound.ORB_PICKUP, 1.5F, 1.2F);
    for (Player other : me.hub.API.Util.UtilServer.Jogadores())
		UtilPlayer.message(other, player.getCustomName() + " esta fazendo a festa de §6§lPlanets");
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
  public void onUpdate(Atualizar e)
  {
    if (e.getType() == ModosUpdate.TICK)
    {

        for (Entity ent : Bukkit.getWorld("world").getEntities()) {
          if ((ent instanceof Item))
          {
            final Item i = (Item)ent;
            if ((i.hasMetadata("Planets")) && 
              (i.getItemStack().getType() == Material.GOLD_BLOCK && 
              (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.AIR) && (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.STATIONARY_WATER) && (i.getWorld().getBlockAt(i.getLocation().add(0.0D, -0.20000000298023224D, 0.0D)).getType() != Material.WATER)))
            {
            	 Random random = new Random();
            		UtilFirework.playFirework(i.getLocation(), FireworkEffect.builder().flicker(false).withColor(Color.YELLOW).with(Type.BURST).trail(false).build());
            	    i.getWorld().playSound(i.getLocation(), Sound.FIREWORK_LAUNCH, 1.0F, 1.0F);
      
            	    for (int k = 0; k < 15; k++)
            	    {
            	      final EntityItem ei = new EntityItem(
            	        ((CraftWorld)i.getWorld()).getHandle(), 
            	        i.getLocation().getX(), 
            	        i.getLocation().getY(), 
            	        i.getLocation().getZ(), 
            	        CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.GOLD_NUGGET)))
            	        {
            	          public boolean a(EntityItem entityitem)
            	          {
            	            return false;
            	          }
            	        };
            	        Item item = (Item)ei.getBukkitEntity();
            	        item.setPickupDelay(0);
            	        item.setCustomName("§a§l1x §f§lPlanets §a§lFREE");
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
            	        }, 200L);
              }}
            
          }
        }
      }
    }
}
