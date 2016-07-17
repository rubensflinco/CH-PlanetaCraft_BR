package me.acf.lobby.gadgets.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilFirework;
import me.hub.API.Util.UtilPlayer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.recharge.Recharge;




import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderTeleport extends GadGetsLoader

{

	
public EnderTeleport(JavaPlugin plugin) {
	super("§aEnderTeleport", plugin, Material.ENDER_PEARL, "§eTeleporte para longe com seu EnderTeleport.");
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
    if (event.getItem() == null)
        return;
      if (event.getItem().getItemMeta().getDisplayName() == null)
        return;
    ItemStack item2 = (ItemStack)Gadgets.gadgets.get(GetName());
    if (!event.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(item2.getItemMeta().getDisplayName())) 
        return;
    Player player = event.getPlayer();


    event.setCancelled(true);
    player.updateInventory();
    if (!Recharge.Instance.use(player, GetName(), 1900L, true, false)) {
        return;
      }    
    Gadgets.Quantidade(event.getPlayer(), GetName());
    Projectile proj = UtilPlayer.Disparo(player, EnderPearl.class);
    proj.setVelocity(proj.getVelocity().multiply(1));
    proj.setPassenger(player);
    this._balls.add(proj);
    playert.add(event.getPlayer());
    UtilSound.playSound(player.getLocation(), Sounds.CHICKEN_EGG_POP, 1.5F, 1.2F);
		} catch (Exception e) {
			
		}
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
	FireworkEffect effect = FireworkEffect.builder().flicker(false).withColor(Color.PURPLE).with(Type.BALL).trail(true).build();
    UtilFirework.playFirework(event.getTo(), effect);
	
	
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
