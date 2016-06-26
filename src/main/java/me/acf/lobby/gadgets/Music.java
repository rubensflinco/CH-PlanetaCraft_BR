package me.acf.lobby.gadgets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Chat;
import me.hub.API.Util.Particles;
import me.hub.API.Util.UtilLocation;
import me.hub.API.Util.UtilParticles;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.config.Config;
import me.site.account.Account;
import me.site.account.rank.Rank;

public class Music extends MiniPlugin {

	
	public static Map<String, ItemStack> gadgets = new HashMap<String, ItemStack>();
	public static boolean tocando = false;
	public static Location loc;
	public static String music;
	public static Player p;
	public Main main;
	public Music(JavaPlugin plugin) {
		super("Gadgets", plugin);
        loader();
        
	}

	  @EventHandler
	  public void Iventarioitens(InventoryClickEvent e)
	  {
	    Player jogador = (Player)e.getWhoClicked();
	    try {
	    if ((e.getInventory().getTitle().contains("Personalizar.")) && 
	    	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	    	    {
	    	      if (e.getSlot() == 29)
	    	      {
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Music"))
	      	        {
	    	    	  e.getInventory().clear();
	    	    	  Menu.Pagina(e.getInventory(), "Music");
	    	    	  }
	    	      }
	    	      if (Music.gadgets.containsKey(e.getCurrentItem().getItemMeta().getDisplayName())){
	    	    	  AtivarGadgets(e.getCurrentItem().getItemMeta().getDisplayName(), jogador, e.getCurrentItem().getType());
	    	      }
	    	    }
	    
	  } catch (Exception e1) {
	  }
	  }
	  
	 
	  @EventHandler
	  public void onPlayerInteract(PlayerInteractEvent e)
	  {
	    if ((e.getClickedBlock() != null) && 
	      (e.getClickedBlock().getType() == Material.JUKEBOX)) {
	    	if (e.getClickedBlock().hasMetadata("JUKEBOX"))
	      e.setCancelled(true);
	    }
	  }
	  
	  private void loader()
	  {
		  registrar(Material.GOLD_RECORD, 0, "§aDisco 1", "§eDisco de musica");
		  registrar(Material.GREEN_RECORD, 0, "§aDisco 2", "§eDisco de musica");
		  registrar(Material.RECORD_3, 0, "§aDisco 3", "§eDisco de musica");
		  registrar(Material.RECORD_4, 0, "§aDisco 4", "§eDisco de musica");
		  registrar(Material.RECORD_5, 0, "§aDisco 5", "§eDisco de musica");
		  registrar(Material.RECORD_6, 0, "§aDisco 6", "§eDisco de musica");
		  registrar(Material.RECORD_7, 0, "§aDisco 7", "§eDisco de musica");
		  registrar(Material.RECORD_8, 0, "§aDisco 8", "§eDisco de musica");
		  registrar(Material.RECORD_9, 0, "§aDisco 9", "§eDisco de musica");
		  registrar(Material.RECORD_10, 0, "§aDisco 10", "§eDisco de musica");
		  registrar(Material.RECORD_11, 0, "§aDisco 11", "§eDisco de musica");
		  registrar(Material.RECORD_12, 0, "§aDisco 12", "§eDisco de musica");

		  
	  }
	  
	  public void registrar(Material material, int data ,String nome, String desc)
	  {
			 ItemStack bau = new ItemStack(material,1 ,(short) data);
		      ItemMeta metae = bau.getItemMeta();
		      metae.setDisplayName(nome);
		      metae.setLore(Arrays.asList(new String[] {  desc,"§3","§7>> Tipo: §9RARO§7<<" }));
		      bau.setItemMeta(metae);
		      gadgets.put(nome, bau);
	  }
	  
	  @EventHandler
	  public void Update(Atualizar event)
	  {
		  try {
	    if (event.getType() != ModosUpdate.FASTER) {
	      return;
	    }
	    UtilParticles.display(Particles.NOTE, 0.5f, 0.5f, 0.5f, loc.clone().add(0.5D, 1.0D, 0.5D), 2);
		  }catch (Exception localException) {}
	      
		  
		  }
	  
	  @EventHandler
	  public void PlayerQuit(PlayerQuitEvent e)
	  {
		  if (Music.p == e.getPlayer())
		  {
			    final Block b = loc.getWorld().getBlockAt(loc);
			      final Jukebox jb = (Jukebox)b.getState();
			      jb.setPlaying(null);
		          b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getTypeId());
		          b.setType(Material.AIR);
		          loc = null;
		          p = null;
		          tocando = false;
		          music = null;
		  }
	  }
	  
	  private static void AtivarGadgets(String nome, Player jogador,Material mat)
	  {
		  ItemStack item2 = (ItemStack)Music.gadgets.get(nome);
		   if ((Account.getRank(jogador)).Has(jogador, Rank.VIPM, true))
		   {
		   }else
		  if (Config.GetMusic(jogador, nome).contains("nao"))
		  {
			  Gadgets.MsgFormat("Você não tem o§6 " + nome, jogador);
			  return;
		  }
          if (p == jogador)
          {
        	  if (music == nome) {
        	  final Block b = loc.getWorld().getBlockAt(loc);
		      final Jukebox jb = (Jukebox)b.getState();
		      jb.setPlaying(null);
	          b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getTypeId());
	          b.setType(Material.AIR);
	          loc = null;
	          p = null;
	          Gadgets.MsgFormat("Você desativou o " + nome, jogador);
	          tocando = false;
	          music = null;
        	  return;
        	  }
          }
          if (tocando)
          {
        	  Gadgets.MsgFormat("Ja tem uma musica tocando", jogador);
        	  return;
          }

          music = nome;
          Gadgets.MsgFormat("Você ativou o " + nome, jogador);
		  jogador.playSound(jogador.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
		    final Block b = jogador.getWorld().getBlockAt(jogador.getLocation().add(0, 1, 0));
		    b.setMetadata("JUKEBOX", new FixedMetadataValue(Main.plugin, "BLOCKS"));
		    b.setType(Material.JUKEBOX);
		    final Jukebox jb = (Jukebox)b.getState();
		    jb.setPlaying(mat);
		    loc = b.getLocation();
		    p = jogador;
		    tocando = true;
		    b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getTypeId());
		    Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable()
		    {
		      public void run()
		      {
		        try
		        {
		          jb.setPlaying(null);
		          b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getTypeId());
		          b.setType(Material.AIR);
		          loc = null;
		          p = null;
		          tocando = false;
		          music = null;
		        }
		        catch (Exception localException) {}
		      }
		    }, 2900L);
			   
	  }
	  
	  
	  
	  public static void MsgFormat(String message, Player jogador)
	  {
		  jogador.sendMessage("§b§lGadget §e" + message);
	  }
	  
	  
	  public static boolean Area(Location corner1, Location corner2)
	  {
	    if (corner1.getWorld() != corner2.getWorld()) {
	      return false;
	    }
	    World world = corner1.getWorld();
	    for (int x = corner1.getBlockX(); x <= corner2.getBlockX(); x++) {
	      for (int y = corner1.getBlockY(); y <= corner2.getBlockY(); y++) {
	        for (int z = corner1.getBlockZ(); z <= corner2.getBlockZ(); z++)
	        {
	          Location location = new Location(world, x, y, z);
	          Block block = location.getBlock();
	          if (block.getType() != Material.AIR) {
	            return false;
	          }
	          Entity[] arrayOfEntity;
	          int j = (arrayOfEntity = UtilLocation.getNearbyEntities(location, 2)).length;
	          for (int i = 0; i < j; i++)
	          {
	            Entity entity = arrayOfEntity[i];
	            if (((entity instanceof ItemFrame)) || ((entity instanceof Painting))) {
	              return false;
	            }
	          }
	        }
	      }
	    }
	    return true;
	  }
	  
	  public void onClear() {
	        HandlerList.unregisterAll(this);
	    }
}
