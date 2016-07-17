package me.acf.lobby.gadgets.montaria;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftLivingEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.loader.HorseLoader;
import me.hub.Main;
import me.hub.API.Util.Particles;
import me.hub.API.Util.UtilParticles;
import net.minecraft.server.v1_10_R1.GenericAttributes;

public class HorseEcologist
  extends HorseLoader
  implements Listener
{

  int i = 0;
  
  public HorseEcologist(JavaPlugin plugin) {
		super("§aHorse Ecologist", plugin, Material.MONSTER_EGG,66, "§eCavalo ecologico.");
  }
  
  
  
  public static void activate(Player p)
  {

    Horse h = (Horse)p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
    h.setVariant(Horse.Variant.HORSE);
    h.setColor(Horse.Color.DARK_BROWN);
    h.setJumpStrength(0.7D);
    h.setAdult();
    h.setCustomName("§f§lCavado do " + p.getDisplayName());
    h.setCustomNameVisible(true);
    h.setDomestication(h.getMaxDomestication());
    h.getInventory().setArmor(new ItemStack(Material.GOLD_BARDING));
    h.getInventory().setSaddle(new ItemStack(Material.SADDLE));
    h.setMaxHealth(1.0D);
    ((CraftLivingEntity)h).getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.3D);
    setMetadata(h, "HGHorse", "ecologist", Main.plugin);
    h.setPassenger(p);
    _Horses.put(p, h);
  }

  

  
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getVehicle() != null) && ((p.getVehicle() instanceof Horse)) && (p.getVehicle().hasMetadata("HGHorse")))
    {
      String st = null;
      List<MetadataValue> pl = p.getVehicle().getMetadata("HGHorse");
      for (MetadataValue s : pl) {
        st = s.asString();
      }
      if (st != "ecologist") {
        return;
      }
      if ((e.getFrom().getBlockX() != e.getTo().getBlockX()) || 
        (e.getFrom().getBlockY() != e.getTo().getBlockY()) || 
        (e.getFrom().getBlockZ() != e.getTo().getBlockZ())) {
    	    byte color = 2;
    	    double r = Math.random();
    	    if (r > 0.8D) {
    	        color = 5;
    	      } else if (r > 0.6D) {
    	        color = 13;
    	      } else if (r > 0.4D) {
    	        color = 5;
    	      } else if (r > 0.2D) {
    	        color = 13;
    	      } else {
    	        color = 5;
    	      }
        Paint(p.getLocation(),color);
        
        UtilParticles.display(Particles.HEART, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, 1, 0), 5);
        UtilParticles.display(Particles.SPELL_MOB_AMBIENT, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, 1, 0), 5);
        UtilParticles.display(Particles.FIREWORKS_SPARK, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, 1, 0), 5);
      
      }
    }
  }
  



}
