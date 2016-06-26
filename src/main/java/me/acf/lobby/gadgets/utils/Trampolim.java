package me.acf.lobby.gadgets.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.antiHack.AntiHack;
import me.hub.Main;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilDirection;
import me.hub.API.Util.UtilLocation;
import me.hub.API.Util.UtilMath;
import me.hub.recharge.Recharge;

public class Trampolim extends GadGetsLoader

{


public Trampolim(JavaPlugin plugin) {
	super("§aTrampolim", plugin, Material.HOPPER, "§eCrie um trampolim de jump.");

	}

  public static final char[] SCHEMA = { 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' };
  public final Map<Player, List<Block>> playerBlocks = new HashMap();
  public final Map<Player, Location> playerTrampoline = new HashMap();
  
  @EventHandler
  public void onEvent(final PlayerInteractEvent event)
  {
	  try {
      final Player player = event.getPlayer();
      Location playerLocation = player.getLocation();
      if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
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
      if (!Gadgets.Area(playerLocation.clone().add(-5.0D, 0.0D, -5.0D), playerLocation.clone().add(5.0D, 1.0D, 5.0D)))
      {
    	  Gadgets.MsgFormat("Você não pode criar o Trampolim aqui!", player);
    return;
      }
      Gadgets.Quantidade(event.getPlayer(), GetName());
      UtilDirection.Direction direction = UtilDirection.getCardinalDirection(player);
      Location corner = playerLocation.clone().add(-4.0D, 0.0D, -4.0D);
      Location line = corner.clone();
      Location location = corner.clone();
      final List<Block> blocks = new ArrayList();
      for (int i = 0; i < SCHEMA.length; i++)
      {
        if (i % 7 == 0) {
          location = line.add(1.0D, 0.0D, 0.0D).clone();
        }
        location.add(0.0D, 0.0D, 1.0D);
        if (i == 24) {
          this.playerTrampoline.put(player, location.clone().add(0.0D, 1.0D, 0.0D));
        }
        char type = SCHEMA[i];
        Block block1 = location.getBlock();
        block1.setType(Material.WOOL);
        block1.setData(type == 'A' ? DyeColor.BLUE.getWoolData() : DyeColor.BLACK.getWoolData());
        blocks.add(block1);
      }
      Location blockLocation = playerLocation.clone().add(0.0D, 0.0D, 0.0D);
      Block firstStair = blockLocation.add(direction == UtilDirection.Direction.SOUTH ? -5 : direction == UtilDirection.Direction.NORTH ? 5 : 0, -1.0D, direction == UtilDirection.Direction.WEST ? -5 : direction == UtilDirection.Direction.EAST ? 5 : 0).getBlock();
      Block secondStair = blockLocation.add(direction == UtilDirection.Direction.SOUTH ? 1 : direction == UtilDirection.Direction.NORTH ? -1 : 0, 1.0D, direction == UtilDirection.Direction.WEST ? 1 : direction == UtilDirection.Direction.EAST ? -1 : 0).getBlock();
      firstStair.setType(Material.WOOD_STAIRS);
      firstStair.setData((byte)(direction == UtilDirection.Direction.WEST ? 2 : direction == UtilDirection.Direction.EAST ? 3 : direction == UtilDirection.Direction.NORTH ? 1 : 0));
      secondStair.setType(Material.WOOD_STAIRS);
      secondStair.setData((byte)(direction == UtilDirection.Direction.WEST ? 2 : direction == UtilDirection.Direction.EAST ? 3 : direction == UtilDirection.Direction.NORTH ? 1 : 0));
      blocks.add(firstStair);
      blocks.add(secondStair);
      player.teleport(playerLocation.add(0.0D, 2.0D, 0.0D));
      this.playerBlocks.put(player, blocks);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
        	playerBlocks.remove(player);
        	playerTrampoline.remove(player);
        	for (Block block : blocks) {
        		  block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getTypeId());
        		block.setType(Material.AIR);
        	   
        	}
          
          
        }
      }, 390L);
		} catch (Exception e) {
			
		}
  }
  
  @EventHandler
  public void onRun(PlayerMoveEvent event)
  {
  
      Location location = (Location)this.playerTrampoline.get(event.getPlayer());
      if (location == null) {
        return;
      }
      Entity[] arrayOfEntity;
      int j = (arrayOfEntity = UtilLocation.getNearbyEntities(location, 5)).length;
      for (int i = 0; i < j; i++)
      {
        Entity entity = arrayOfEntity[i];
        if ((entity instanceof Player)) {
          entity.setVelocity(entity.getVelocity().add(new Vector(0.0F, UtilMath.random(1.8F, 3.7F), 0.0F)));
          AntiHack.igonorar.add(event.getPlayer());
        }
      
    }
  }
  

}
