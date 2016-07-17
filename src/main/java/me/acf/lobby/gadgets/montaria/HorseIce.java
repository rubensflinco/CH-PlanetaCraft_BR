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

public class HorseIce
  extends HorseLoader
  implements Listener
{

  int i = 0;
  
  public HorseIce(JavaPlugin plugin) {
		super("§aHorse Ice", plugin, Material.MONSTER_EGG,56, "§eCavalo do gelo.");
  }
  
  
  
  public static void activate(Player p)
  {

    Horse h = (Horse)p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
    h.setVariant(Horse.Variant.HORSE);
    h.setColor(Horse.Color.WHITE);
    h.setJumpStrength(0.5D);
    h.setAdult();
    h.setCustomName("§f§lCavado do " + p.getDisplayName());
    h.setCustomNameVisible(true);
    h.setDomestication(h.getMaxDomestication());
    h.getInventory().setArmor(new ItemStack(Material.DIAMOND_BARDING));
    h.getInventory().setSaddle(new ItemStack(Material.SADDLE));
    h.setMaxHealth(1.0D);
    ((CraftLivingEntity)h).getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.3D);
    setMetadata(h, "HGHorse", "ice", Main.plugin);
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
      if (st != "ice") {
        return;
      }
      if ((e.getFrom().getBlockX() != e.getTo().getBlockX()) || 
        (e.getFrom().getBlockY() != e.getTo().getBlockY()) || 
        (e.getFrom().getBlockZ() != e.getTo().getBlockZ())) {

        Paint(p.getLocation(),174,(byte) 0);
        
        UtilParticles.display(Particles.SNOW_SHOVEL, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, 1, 0), 5);
        UtilParticles.display(Particles.FIREWORKS_SPARK, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, 1, 0), 5);
        UtilParticles.display(Particles.ENCHANTMENT_TABLE, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, 1, 0), 5);
      
      }
    }
  }
  



}
