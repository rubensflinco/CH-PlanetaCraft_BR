package me.acf.KitPvP;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;
import me.hub.API.Util.Particles;
import me.hub.API.Util.UtilParticles;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;

public class JumpBlocos
  extends MiniPlugin
{
  public static ArrayList<String> jump = new ArrayList();

  public JumpBlocos(JavaPlugin plugin)
  {
    super("JumpBlocos", plugin);
  }
  
  @EventHandler
  public void CkJumpBlocosAPI(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (!Kit.verkit(p).contains("Nenhum")){
      if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SLIME_BLOCK) && (e.getTo().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType() == Material.BEDROCK))
      {
        jump.remove(p.getName());
        p.setVelocity(p.getVelocity().setY(3.0D));
        UtilSound.playSound(p, Sounds.SLIME_WALK2, 1.0F, 1.0F);
        jump.add(p.getName());
      }
      else if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.EMERALD_BLOCK) && (e.getTo().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType() == Material.BEDROCK))
      {
        jump.remove(p.getName());
        p.setVelocity(p.getLocation().getDirection().multiply(5.0D));
        p.setVelocity(new Vector(p.getVelocity().getX(), 1.5D, p.getVelocity().getZ()));
        UtilSound.playSound(p, Sounds.FIREWORK_LAUNCH, 40.0F, 1.0F);
        p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 5);
      
        jump.add(p.getName());
      }
      else if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.ENDER_PORTAL_FRAME) && (e.getTo().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType() == Material.BEDROCK))
      {
        jump.remove(p.getName());
        p.setVelocity(p.getLocation().getDirection().multiply(15.0D));
        p.setVelocity(new Vector(p.getVelocity().getX(), 1.5D, p.getVelocity().getZ()));
        UtilSound.playSound(p, Sounds.FIREWORK_LAUNCH, 40.0F, 1.0F);
        p.getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 5);
  
      }
    }
  }
  
  @EventHandler
  public void onFall(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && 
        (jump.contains(p.getName())))
      {
        e.setCancelled(true);
        jump.remove(p.getName());
      }
    }
  }
  
  @EventHandler
  public void entityDamage(EntityDamageByEntityEvent e)
  {
    if ((e.getDamager() instanceof Player))
    {
      Player player = (Player)e.getDamager();
      if (jump.contains(player.getName()))
      {
        e.setCancelled(true);
        jump.remove(player.getName());
      }
    }
  }
}
