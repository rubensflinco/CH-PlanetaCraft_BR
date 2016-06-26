package me.acf.lobby.gadgets.loader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import me.acf.lobby.gadgets.Mount;
import me.hub.Ler;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilTime;



public class HorseLoader
  implements Listener
{
  protected String Efeito = "Gadgets";
  protected JavaPlugin _plugin;
  public static HashMap<Player, Horse> _Horses = new HashMap<>();

  
  public HorseLoader(String gadgets, JavaPlugin plugin, Material material,int data, String desc)
  {
    this.Efeito = gadgets;
    this._plugin = plugin;



    onEnable();

    RegisterEvents(this);
    registrar(material, data, gadgets, desc);
  }

  @EventHandler
  public void onShift(VehicleExitEvent e)
  {
    Player p = (Player)e.getExited();
    if ((e.getVehicle() != null) && ((e.getVehicle() instanceof Horse)) && (e.getVehicle().hasMetadata("HGHorse")))
    {
      String st = null;
      List<MetadataValue> pl = e.getVehicle().getMetadata("HGHorse");
      for (MetadataValue s : pl) {
        st = s.asString();
      }
      p.getVehicle().remove();
      p.eject();
      this._Horses.remove(p);

    }
  }
  
  public void Paint(Location l, int bloco,byte color)
  {
    for (Block block : UtilBlock.getInRadius(l, 5.0D).keySet())
    {
      if (block.getType() == Material.PORTAL) {
        return;
      }
      if (block.getType() == Material.CACTUS) {
        return;
      }
      if (block.getType() == Material.IRON_PLATE) {
        return;
      }
      if (block.getType() == Material.SIGN) {
        return;
      }
      if (block.getType() == Material.WALL_SIGN) {
        return;
      }
      if (block.getType() == Material.SIGN_POST) {
        return;
      }
    }
    for (Block block : UtilBlock.getInRadius(l, 2.5D).keySet()) {
      if (UtilBlock.solid(block)) {
        if ((block.getType() != Material.STAINED_CLAY) && 
          (block.getType() != Material.JUKEBOX) && 
          (block.getType() != Material.CHEST) && 
          (block.getType() != Material.SIGN_POST) && 
          (block.getType() != Material.WALL_SIGN) && 
          (block.getType() != Material.SIGN) && 
          ((block.getType() != Material.WOOL) || (block.getData() != 15)) && 
          ((block.getType() != Material.WOOL) || (block.getData() != 11)) && 
          (UtilBlock.fullSolid(block)) && 
          (!badGrassBlock(block))) {
          Ler.GetBlockRestore().Add(block, bloco, color, 4000L);
        }
      }
    }
  }
  
  public void Paint(Location l, byte color)
  {
    for (Block block : UtilBlock.getInRadius(l, 5.0D).keySet())
    {
      if (block.getType() == Material.PORTAL) {
        return;
      }
      if (block.getType() == Material.CACTUS) {
        return;
      }
      if (block.getType() == Material.IRON_PLATE) {
        return;
      }
      if (block.getType() == Material.SIGN) {
        return;
      }
      if (block.getType() == Material.WALL_SIGN) {
        return;
      }
      if (block.getType() == Material.SIGN_POST) {
        return;
      }
    }
    for (Block block : UtilBlock.getInRadius(l, 2.5D).keySet()) {
      if (UtilBlock.solid(block)) {
        if ((block.getType() != Material.STAINED_CLAY) && 
          (block.getType() != Material.JUKEBOX) && 
          (block.getType() != Material.CHEST) && 
          (block.getType() != Material.SIGN_POST) && 
          (block.getType() != Material.WALL_SIGN) && 
          (block.getType() != Material.SIGN) && 
          ((block.getType() != Material.WOOL) || (block.getData() != 15)) && 
          ((block.getType() != Material.WOOL) || (block.getData() != 11)) && 
          (UtilBlock.fullSolid(block)) && 
          (!badGrassBlock(block))) {
          Ler.GetBlockRestore().Add(block, 159, color, 4000L);
        }
      }
    }
  }
  
  public static void setMetadata(Horse h, String key, Object value, JavaPlugin plugin)
  {
    h.setMetadata(key, new FixedMetadataValue(plugin, value));
  }

  public static float randomRangeFloat(float min, float max)
  {
    return (float)(Math.random() < 0.5D ? (1.0D - Math.random()) * (max - min) + min : Math.random() * (max - min) + min);
  }
  
  public boolean badGrassBlock(Block b)
  {
    if ((b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.LONG_GRASS) || 
      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.DOUBLE_PLANT) || 
      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.YELLOW_FLOWER) || 
      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.RED_ROSE) || 
      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.CROPS) || 
      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.CARROT) || 
      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.POTATO) || 
      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.MELON_STEM) || 
      (b.getWorld().getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)).getType() == Material.PUMPKIN_STEM)) {
      return true;
    }
    return false;
  }
  
  
  @EventHandler
  public void onQuit(PlayerQuitEvent e)
  {
	  e.getPlayer().leaveVehicle();
    if ((e.getPlayer().getVehicle() != null) && ((e.getPlayer().getVehicle() instanceof Horse)) && (e.getPlayer().getVehicle().hasMetadata("HGHorse")))
    {
      String st = null;
      List<MetadataValue> pl = e.getPlayer().getVehicle().getMetadata("HGHorse");
      for (MetadataValue s : pl) {
        st = s.asString();
      }
      e.getPlayer().remove();
      e.getPlayer().eject();
      this._Horses.remove(e.getPlayer());

    }
  }
  
  @EventHandler
  public void onHorseDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Horse))
    {
      Horse s = (Horse)e.getEntity();
      if (this._Horses.containsValue(s)) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void onHorseDamage(EntityDamageByEntityEvent e)
  {
    if ((e.getDamager() instanceof Horse))
    {
      Horse s = (Horse)e.getDamager();
      if (this._Horses.containsValue(s)) {
        e.setCancelled(true);
      }
    }
  }
  
  
  public void registrar(Material material, int data ,String nome, String desc)
  {
		 ItemStack bau = new ItemStack(material,1 ,(short) data);
	      ItemMeta metae = bau.getItemMeta();
	      metae.setDisplayName(nome);
	      metae.setLore(Arrays.asList(new String[] {  desc,"§3","§7>> Montaria somente §6§lVIP §7<<" }));
	      bau.setItemMeta(metae);
	      
	       Mount.Mount.put(nome, bau);
  }
  public PluginManager GetPluginManager()
  {
    return this._plugin.getServer().getPluginManager();
  }

  public BukkitScheduler GetScheduler()
  {
    return this._plugin.getServer().getScheduler();
  }

  public JavaPlugin GetPlugin()
  {
    return this._plugin;
  }

  public void RegisterEvents(Listener listener)
  {
    this._plugin.getServer().getPluginManager().registerEvents(listener, this._plugin);
  }

  public final void onEnable()
  {
    long epoch = System.currentTimeMillis();
    Log("Iniciando Montaria");
    Enable();
    AddComandos();
    Log("Montaria " + Efeito + " " + UtilTime.Convertor(System.currentTimeMillis() - epoch, 1, UtilTime.TimeUnit.FIT) + ".");
  }

  public final void onDisable()
  {
    Disable();

    Log("Desativando Gadgets");
  }
  public void Enable() {
  }
  public void Disable() {
  }

  public void AddComandos() {
  }

  public final String GetName() {
    return this.Efeito;
  }

  public final void AddComandos(String teste)
  {
	  
  }



  protected void Log(String message)
  {
    System.out.println(message);
  }
}