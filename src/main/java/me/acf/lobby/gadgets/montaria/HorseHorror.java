package me.acf.lobby.gadgets.montaria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.acf.lobby.gadgets.loader.HorseLoader;
import me.hub.Main;
import me.hub.API.Util.Particles;
import me.hub.API.Util.UtilParticles;
import net.minecraft.server.v1_8_R3.GenericAttributes;

public class HorseHorror
  extends HorseLoader
  implements Listener
{

  int i = 0;
  
  public HorseHorror(JavaPlugin plugin) {
		super("§aHorse Horror", plugin, Material.MONSTER_EGG,58, "§eCavalo do terror.");
  }
  
  static Map<Bat, ArmorStand> bats = new HashMap<>();
  
  private static void Ghost(Location loc)
  {

	        for (int i = 0; i < 2; i++) {
	            Bat bat = loc.getWorld().spawn(loc.add(0, 1, 0), Bat.class);
	            ArmorStand ghost = bat.getWorld().spawn(bat.getLocation(), ArmorStand.class);
	            ghost.setSmall(true);
	            ghost.setGravity(false);
	            ghost.setVisible(false);
	            ghost.setHelmet(new ItemStack(Material.SKULL_ITEM, 1, (byte) 1));
	            ItemStack chestplateBlack = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
	            LeatherArmorMeta chestplatemeta = (LeatherArmorMeta) chestplateBlack.getItemMeta();
	            chestplatemeta.setColor(Color.BLACK);
	            ghost.setChestplate(chestplateBlack);
	            ghost.setItemInHand(new ItemStack(Material.IRON_HOE));
	            bat.setPassenger(ghost);
	            bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 160, 1));
	            bats.put(bat, ghost);
	        }
	        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.plugin, new Runnable() {
	            @Override
	            public void run() {
	                killBats();
	            }
	        }, 100);
	    
  }
  
  private static void killBats() {
      for (Bat bat : bats.keySet()) {
          bats.get(bat).remove();
          bat.remove();
     
      }
  }
  
  public static void activate(Player p)
  {

    Horse h = (Horse)p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
    h.setVariant(Horse.Variant.HORSE);
    h.setVariant(Horse.Variant.SKELETON_HORSE);
    h.setJumpStrength(0.9D);
    h.setAdult();
    h.setCustomName("§f§lCavado do " + p.getDisplayName());
    h.setCustomNameVisible(true);
    h.setDomestication(h.getMaxDomestication());
    h.getInventory().setSaddle(new ItemStack(Material.SADDLE));
    h.setMaxHealth(1.0D);
    ((CraftLivingEntity)h).getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.2D);
    setMetadata(h, "HGHorse", "Horror", Main.plugin);
    h.setPassenger(p);
    _Horses.put(p, h);
    Ghost(p.getVehicle().getLocation().clone().add(0,2,0));
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
      if (st != "Horror") {
        return;
      }

      Paint(p.getLocation(),173,(byte) 0);
        p.getWorld().playSound(p.getVehicle().getLocation(), Sound.HORSE_SKELETON_IDLE, 1.5F, 1.2F);
        UtilParticles.display(Particles.FLAME, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, -1, 0), 5);
        UtilParticles.display(Particles.CRIT, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, -1, 0), 5);
        UtilParticles.display(Particles.SMOKE_LARGE, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, 1, 0), 5);
        UtilParticles.display(Particles.DRIP_LAVA, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, 1, 0), 5);
        UtilParticles.display(Particles.PORTAL, 0.4f, 0.2f, 0.4f, p.getVehicle().getLocation().clone().add(0, -1, 0), 5);
    }
  }
  



}
