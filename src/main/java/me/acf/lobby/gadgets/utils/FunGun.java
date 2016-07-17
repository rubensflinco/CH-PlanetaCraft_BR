package me.acf.lobby.gadgets.utils;

import java.util.HashSet;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilPlayer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.recharge.Recharge;

public class FunGun extends GadGetsLoader

{
	
	
public FunGun(JavaPlugin plugin) {
	super("§aFunGun", plugin, Material.BLAZE_ROD, "§eSeja feliz.");

	}

private HashSet<Projectile> _balls = new HashSet();
  

  
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
    if (!Recharge.Instance.use(player, GetName(), 1900L, true, false)) {
        return;
      }
    Gadgets.Quantidade(event.getPlayer(), GetName());
    Projectile proj = UtilPlayer.Disparo(player, Snowball.class);
    proj.setVelocity(proj.getVelocity().multiply(2));
    this._balls.add(proj);

    UtilSound.playSound(player.getLocation(), Sounds.CAT_HISS, 1.5F, 1.2F);  
  
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
    for (double local = 0; local < 1; local = local+0.1)
    {
    loc.getWorld().playEffect(loc.clone().add(local,local,local), Effect.LAVA_POP, 16);
    loc.getWorld().playEffect(loc.clone().add(local,local,local), Effect.HEART, 20);
    loc.getWorld().playEffect(loc.clone().add(local,local,local), Effect.FLAME, 20);
    loc.getWorld().playEffect(loc.clone().add(local,local,local), Effect.LAVADRIP, 20);
    }
    _balls.remove(event.getEntity());
    UtilSound.playSound(loc, Sounds.CAT_MEOW, 1.5F, 1.2F);
   
    
    
  }
}
