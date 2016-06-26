package me.acf.lobby.gadgets.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import me.acf.lobby.Lag.TPS;
import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.hub.Main;
import me.hub.API.Util.UtilBlock;
import me.hub.NMS.CustomEntityFirework_1_8_5_R03;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.recharge.Recharge;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Firework extends GadGetsLoader

{

	
	
public Firework(JavaPlugin plugin) {
	super("§aParty FireWork", plugin, Material.FIREWORK, "§eDispare varios fogos.");
	      
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
    if (!Recharge.Instance.use(player, GetName(), 10900L, true, false)) {
        return;
      }
    Gadgets.Quantidade(event.getPlayer(), GetName());
    final Item item = player.getWorld().dropItem(player.getEyeLocation().add(player.getLocation().getDirection().multiply(2.0471975511965974D)), new ItemStack(Material.FIREWORK));
    item.setPickupDelay(0);
    setMetadata(item, "firework", player.getName(), Main.plugin);
    item.setVelocity(player.getLocation().getDirection().add(new Vector(0.0D, 1.1313123444543524D, 0.0D)));
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
    {
      public void run()
      {
        
        
        item.remove();
      }
    }, 60L);
		} catch (Exception e) {
			
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
      for (Player p : Bukkit.getOnlinePlayers())
      {
        
        for (Entity ent : p.getWorld().getEntities()) {
          if ((ent instanceof Item))
          {
            Item i = (Item)ent;
            if (i.hasMetadata("firework"))
            {
                if (TPS.getTPS() < 18.5D) return;
            	 Type type = Type.BALL; 
 	            Random r = new Random();  
 	            int r1i = r.nextInt(16) + 1;
 	            int r2i = r.nextInt(16) + 1;
 	            int fw = r.nextInt(23);
 	            Color c1 = getColor(r1i);
 	            Color c2 = getColor(r2i);
 	            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
 	            i.getWorld().playEffect(i.getLocation(), Effect.FIREWORKS_SPARK, 2);
 	            i.getWorld().playSound(i.getLocation(), Sound.FIREWORK_LAUNCH, 0.1F, 1.0F);
 	            CustomEntityFirework_1_8_5_R03.spawn(i.getLocation().clone().add(+0.5,0,0.5), effect);
            } 
          }
          }
        }
      
    }
  }
  public static Color getColor(int i) {
	  Color c = null;
	  if(i==1){
	  c=Color.AQUA;
	  }
	  if(i==2){
	  c=Color.BLACK;
	  }
	  if(i==3){
	  c=Color.BLUE;
	  }
	  if(i==4){
	  c=Color.FUCHSIA;
	  }
	  if(i==5){
	  c=Color.GRAY;
	  }
	  if(i==6){
	  c=Color.GREEN;
	  }
	  if(i==7){
	  c=Color.LIME;
	  }
	  if(i==8){
	  c=Color.MAROON;
	  }
	  if(i==9){
	  c=Color.NAVY;
	  }
	  if(i==10){
	  c=Color.OLIVE;
	  }
	  if(i==11){
	  c=Color.ORANGE;
	  }
	  if(i==12){
	  c=Color.PURPLE;
	  }
	  if(i==13){
	  c=Color.RED;
	  }
	  if(i==14){
	  c=Color.SILVER;
	  }
	  if(i==15){
	  c=Color.TEAL;
	  }
	  if(i==16){
	  c=Color.WHITE;
	  }
	  if(i==17){
	  c=Color.YELLOW;
	  }
	   
	  return c;
	  }
	   
}
