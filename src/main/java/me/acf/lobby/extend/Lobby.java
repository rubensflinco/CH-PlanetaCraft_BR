package me.acf.lobby.extend;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.lobby.Lag.TPS;
import me.acf.lobby.MagicChest.ChestMagic;
import me.antiHack.autoclick.Click;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.Particles;
import me.hub.API.Util.UtilAction;
import me.hub.API.Util.UtilActionBar;
import me.hub.API.Util.UtilNPC;
import me.hub.API.Util.UtilParticles;
import me.hub.API.Util.UtilPlayer;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.Bungee.Bungee;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.comandos.CriadorComandos;
import me.hub.recharge.Recharge;
import me.site.account.Account;
import me.site.account.AccountWeb;
import me.site.account.rank.Rank;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;


public class Lobby extends MiniPlugin{

	public Lobby(JavaPlugin plugin) {
		 super("Lobby", plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin, "me.security.registrar.comandos");
			me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
			Bukkit.getPluginManager().registerEvents(new MobSpawn(), Main.plugin);
			Bukkit.getPluginManager().registerEvents(new ChestMagic(), Main.plugin);
	        
			UtilNPC.SpawnEntity("§a§oFullPvP","§eCarregando...", "§a§oFullPvP","Miner", new Location(Bukkit.getWorld("world"), -47.50,164.50,-64.50, 0,0));
			UtilNPC.SpawnEntity("§a§oKitPvP","§eCarregando...", "§a§oKitPvP","Reav_", new Location(Bukkit.getWorld("world"),-49.50,164.50,-66.50, 0,0));
			UtilNPC.SpawnEntity("§a§oSkyBlock","§eCarregando...", "§a§oSkyBlock","MHF_Chest", new Location(Bukkit.getWorld("world"),-51.50,164.50,-68.50, 0,0));
			UtilNPC.SpawnEntity("§a§oSkyWars","§eCarregando...", "§a§oSkyWars","doodoo123987", new Location(Bukkit.getWorld("world"),-53.50,164.50,-70.50, 0,0));
			UtilNPC.SpawnEntity("§a§oHungerGames","§eCarregando...", "§a§oHungerGames","HellCatcher", new Location(Bukkit.getWorld("world"),-55.50,164.50,-71.50, 0,0));
			UtilNPC.SpawnEntity("§a§oOneInTheChamber","§eCarregando...", "§a§oOneInTheChamber","Twilizer5953", new Location(Bukkit.getWorld("world"),-57.50,164.50,-71.50, 0,0));
			UtilNPC.SpawnEntity("§a§oSpleggTnT","§eCarregando...", "§a§oSpleggTnT","Jotinha_BR", new Location(Bukkit.getWorld("world"),-59.50,164.50,-71.50, 0,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 2","§eCarregando...", "§c§lEM BREVE","BrinePlay", new Location(Bukkit.getWorld("world"),-61.50,164.50,-71.50, 0,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 3","§eCarregando...", "§c§lEM BREVE","BiancaGamer_HD", new Location(Bukkit.getWorld("world"),-63.50,164.50,-70.50, 0,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 4","§eCarregando...", "§c§lEM BREVE","_Unix52", new Location(Bukkit.getWorld("world"),-65.50,164.50,-69.50, 0,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 5","§eCarregando...", "§c§lEM BREVE","maradopt", new Location(Bukkit.getWorld("world"),-67.50,164.50,-67.50, 0,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 6","§eCarregando...", "§c§lEM BREVE","Planetacraft_BR", new Location(Bukkit.getWorld("world"),-68.50,164.50,-65.50, 0,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 7","§eCarregando...", "§c§lEM BREVE","Jotinha_BR", new Location(Bukkit.getWorld("world"),-69.50,164.50,-63.50, -90,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 8","§eCarregando...", "§c§lEM BREVE","MHF_Herobrine", new Location(Bukkit.getWorld("world"),-69.50,164.50,-61.50, -90,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 9","§eCarregando...", "§c§lEM BREVE","Project22", new Location(Bukkit.getWorld("world"),-69.50,164.50,-59.50, -90,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 10","§eCarregando...", "§c§lEM BREVE","BrinePlay", new Location(Bukkit.getWorld("world"),-69.50,164.50,-57.50, -90,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 11","§eCarregando...", "§c§lEM BREVE","BiancaGamer_HD", new Location(Bukkit.getWorld("world"),-68.50,164.50,-55.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 12","§eCarregando...", "§c§lEM BREVE","_Unix52", new Location(Bukkit.getWorld("world"),-67.50,164.50,-53.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 13","§eCarregando...", "§c§lEM BREVE","maradopt", new Location(Bukkit.getWorld("world"),-65.50,164.50,-51.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 14","§eCarregando...", "§c§lEM BREVE","Planetacraft_BR", new Location(Bukkit.getWorld("world"),-63.50,164.50,-50.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 15","§eCarregando...", "§c§lEM BREVE","Jotinha_BR", new Location(Bukkit.getWorld("world"),-61.50,164.50,-49.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 16","§eCarregando...", "§c§lEM BREVE","MHF_Herobrine", new Location(Bukkit.getWorld("world"),-59.50,164.50,-49.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 17","§eCarregando...", "§c§lEM BREVE","BrinePlay", new Location(Bukkit.getWorld("world"),-57.50,164.50,-49.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 18","§eCarregando...", "§c§lEM BREVE","BiancaGamer_HD", new Location(Bukkit.getWorld("world"),-55.50,164.50,-49.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 19","§eCarregando...", "§c§lEM BREVE","_Unix52", new Location(Bukkit.getWorld("world"),-53.50,164.50,-50.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 20","§eCarregando...", "§c§lEM BREVE","maradopt", new Location(Bukkit.getWorld("world"),-51.50,164.50,-51.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 21","§eCarregando...", "§c§lEM BREVE","Planetacraft_BR", new Location(Bukkit.getWorld("world"),-49.50,164.50,-53.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 22","§eCarregando...", "§c§lEM BREVE","Jotinha_BR", new Location(Bukkit.getWorld("world"),-48.50,164.50,-55.50, 180,0));
			UtilNPC.SpawnEntity("§c§lEM BREVE 23","§eCarregando...", "§c§lEM BREVE","MHF_Herobrine", new Location(Bukkit.getWorld("world"),-47.50,164.50,-57.50, 180,0));
			
			Loader(Main.site+ "/API/reikdr.php","lobby");
			
			UtilNPC.DarUpdate_All();
			
	        Top3 top3 = new Top3(plugin);
	}

	
	public static ArrayList<Location> enderchest = new ArrayList<Location>();
	
	  public static ArrayList<ItemStack> Item = new ArrayList<ItemStack>();
	  public Location spawn = Bukkit.getWorld("world").getSpawnLocation();
	    
	  

	  
	  @EventHandler
	  public void Comandos(PlayerCommandPreprocessEvent event) {
	    if ((event.getMessage().toLowerCase().startsWith("/me")) || 
	      (event.getMessage().toLowerCase().startsWith("/bukkit")))
	    {
	      event.getPlayer().sendMessage("§e§lVocê não pode fazer isto..!");
	      event.setCancelled(true);
	    }
	    if (event.getMessage().toLowerCase().startsWith("/ping"))
	    {
	      event.getPlayer().sendMessage("§e§lPong.. §f§lMS §6§l" + UtilPlayer.Ping(event.getPlayer()));
	      event.setCancelled(true);
	    }
	    if (event.getMessage().toLowerCase().startsWith("/pong"))
	    {
	      event.getPlayer().sendMessage("§e§lPing.. §f§lMS §6§l" + UtilPlayer.Ping(event.getPlayer()));
	      event.setCancelled(true);
	    }
	    if (event.getMessage().toLowerCase().startsWith("/ms"))
	    {
	      event.getPlayer().sendMessage("§f§lMS §6§l" + UtilPlayer.Ping(event.getPlayer()));
	      event.setCancelled(true);
	    }
	    
	    
	  }
	  
	   @EventHandler
	   public void BlockBurn(BlockBurnEvent event)
	   {
	       event.setCancelled(true);
	   }
	   
	   @EventHandler
	   public void BlockFade(BlockFadeEvent event) {
	       event.setCancelled(true);    
	   }
	   
	   @EventHandler
	   public void BlockSpread(BlockSpreadEvent event) {
	       event.setCancelled(true);
	   }
	   
	   @EventHandler(priority=EventPriority.LOW)
	   public void playerPortalEvent(PlayerPortalEvent event)
	   {
	     event.setCancelled(true);
	   }
	   @EventHandler(priority=EventPriority.LOW)
	   public void entityPortalEvent(EntityPortalEvent event) {
	     event.setCancelled(true);
	   }

	   @EventHandler
	   public void ItemSpawnEvent(final PlayerDropItemEvent event)
	   {
		

		   event.setCancelled(true);
		   
	   }
	   
		  @EventHandler
		  public void onKDRClick(PlayerInteractEvent e)
		  {
		      Player p = e.getPlayer();
		      Action a = e.getAction();
		      if (a == Action.RIGHT_CLICK_BLOCK) {
		      if (e.getClickedBlock().getType() == Material.BEACON) {
			      Location loc = e.getClickedBlock().getLocation();
		  		loc.setY(loc.getY() -2);
				int block1 = loc.getWorld().getBlockTypeIdAt(loc);
				if (block1 == 57)
				{
					p.sendMessage("§c§lTP §7Teleportando você para Rank de KDR dos minigames !");
					p.teleport(new Location(Bukkit.getWorld("world"), 149,172,-78));
					UtilSound.playSound(new Location(Bukkit.getWorld("world"), 149,172,-78), Sounds.LEVEL_UP, 10.0F, 1.0F);
				    e.setCancelled(true);
		        }
		      }
		      }
		      
		  }
	 
	   @EventHandler
	   public void ItemSpawnEvent(final ItemSpawnEvent event)
	   {
	if ((event.getEntity().getName().contains("melon")) ||(event.getEntity().getName().contains("Tsunami")) ||(event.getEntity().getName().contains("cloth")) || (event.getEntity().getName().contains("tripWireSource"))|| (event.getEntity().getName().contains("fire")))  {
	
	return;	   
	}
		   if (!Item.contains(event.getEntity().getItemStack())) {
	     event.setCancelled(true);
		   }
		   else
		   {
			   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
		       {
		         public void run()
		         {
		           event.getEntity().remove();
		           
		           
		         }
		       }, 10L);

		   }
	   }
	   
	   
	   @EventHandler
	   public void Pickup(PlayerPickupItemEvent event)
	   {
	   
	       event.setCancelled(true);
	     
	   }
	   
	   @EventHandler
	   public void HopperPickup(InventoryPickupItemEvent event) {
	    
	       event.setCancelled(true);
	     
	   }
	   
	   @EventHandler
	   public void BlockBreak(BlockBreakEvent event) {
	     if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
	       return;
	     }
	     event.setCancelled(true);
	   }

	   @EventHandler(priority=EventPriority.LOWEST)
	   public void Explosion(EntityExplodeEvent event) {
	     event.setCancelled(true);
	   }

	   @EventHandler
	   public void VineGrow(BlockSpreadEvent event) {
	     event.setCancelled(true);
	   }

	   @EventHandler
	   public void BlockForm(BlockFormEvent event) {
	     event.setCancelled(true);
	   }

	   @EventHandler
	   public void LeaveDecay(LeavesDecayEvent event) {
	     event.setCancelled(true);
	   }
	   
	
		  // e.getPlayer().getWorld().playEffect(e.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 2);
	   

	   
	   
	   private Color getColor(int i) {
		   Color c = null;
		
		   c=Color.PURPLE;
		   
		
		    
		   return c;
		   }
	   


	   
	   @EventHandler
	   public void Fome(FoodLevelChangeEvent event)
	   {
	 	  Player jogador = (Player)event.getEntity();
	 	  jogador.setFoodLevel(2000);
	 	  event.setCancelled(true);  
	   }
	   
	   @EventHandler(priority=EventPriority.HIGH)
	   public void SemDano(EntityDamageEvent event) {
	     if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
	       event.setCancelled(true);

	       double x = Bukkit.getWorld("world").getSpawnLocation().getX();
	       double y = Bukkit.getWorld("world").getSpawnLocation().getY() + 2.0D;
	       double z = Bukkit.getWorld("world").getSpawnLocation().getZ();
	       Location loc = new Location(event.getEntity().getWorld(), x, y, z);
	       event.getEntity().teleport(loc.clone().add(0.5,0,0.5));
	     }
	     else
	     {
	    	 if (event.getEntityType() == EntityType.PLAYER)
	    	 event.setCancelled(true);
	     }
	   }
	   
	   @EventHandler
		public void removeBlock(EntityChangeBlockEvent e) {	
				e.setCancelled(true);		
		}
	   
	 

	    
	    private ArrayList npc = new ArrayList<Player>();
	    @EventHandler
	    public void SlimeJump(PlayerMoveEvent e) {
	    	
	    	
	    	 Player player = e.getPlayer();
	    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SLIME_BLOCK) {
	    	UtilAction.velocity(player, 1.4D, 0.5D, 1.0D, true);
	    	UtilParticles.display(Particles.VILLAGER_HAPPY, 0.4f, 0.2f, 0.4f, e.getTo().getBlock().getLocation().clone().add(0, 1, 0), 5);
	    	UtilSound.playSound(player.getLocation(), Sounds.PISTON_EXTEND, 0.5F, 0.5F);
	    }
	    }

	    
	    @EventHandler
	    public void Utils(Atualizar event)  {
	      if (event.getType() != ModosUpdate.FAST) {
	        return;
	      }
          int vaca = 0;
          int ovelha = 0;
          new TPS();
     
          Scoreboard.UpdateScoreboard();
          
          Bukkit.getWorld("world").setThunderDuration(0);
          Bukkit.getWorld("world").setThundering(false);
          Bukkit.getWorld("world").setWeatherDuration(0);
          Bukkit.getWorld("world").setStorm(false);
 

	      List<Entity> entities = Bukkit.getWorld("world").getEntities();
    	  for (Entity entity : entities){
    		  if (entity.getType() == EntityType.HORSE)
    		  {
    			  if (entity.getPassenger() == null)
    			  {
    				  entity.remove();
    			  }
    		  }
    		  if (entity.getType() == EntityType.RABBIT)
    		  {
    			  entity.getWorld().playEffect(entity.getLocation().getBlock().getLocation().clone().add(0.5,1,0.5), Effect.MAGIC_CRIT, 2);  
    			  
    		  }
    		  if (entity.getType() == EntityType.ARROW)
    		  {
    			  if (entity.getPassenger() == null)
    			  {
    				  entity.remove();
    			  }
    		  }
    	  }
    	 
    	  for (Player p : UtilServer.Jogadores())
    	  {
   
    		  try {
    		    int level = Integer.parseInt(Account.getNivel(p.getPlayer()));
    		    p.getPlayer().setLevel(level);
    		  }
    		  catch (Exception exception)
			    {
    			  
			    }
  
    		  if (UtilPlayer.Ping(p) > 800)
    		  {
    			  UtilActionBar.ActionBar(p, "§f§lVOCÊ ESTA COM §c§lLAG §f§lSEU PING É DE §6§l" + UtilPlayer.Ping(p) + " / 1500");
    			  
    		  }
    		  if (UtilPlayer.Ping(p) > 1500)
    		  {
    			  p.kickPlayer("§c§lEXTREMO LAG\n§f§lMS: §a§l"+ UtilPlayer.Ping(p));
    		  }
    		  
    		  if (!(Account.getRank(p)).Has(p, Rank.VIP, false))
			   {
			  p.setAllowFlight(false);
			  p.setFlying(false);
			   }
    		  
    	  }
    	  
        	 
	    }
	    
	    @EventHandler
	    public void claymore(PlayerInteractEvent event){
	        if(event.getAction().equals(Action.PHYSICAL)){
	            if(event.getClickedBlock().getTypeId() == 72){
	                Player player = event.getPlayer();
	                Bukkit.getWorld(player.getWorld().getName()).createExplosion(player.getLocation(), 0);
	            }
	        }
	    }

		  @EventHandler
		  public void Iventarioitens(InventoryClickEvent e)
		  {
		    Player jogador = (Player)e.getWhoClicked();
		    if (jogador.getGameMode() == GameMode.CREATIVE)
		      return;
		    e.setCancelled(true);
		  }
		  
		  @EventHandler
		  public void onPlayerInteractNPC(PlayerInteractEntityEvent e) {
				if (e.getRightClicked() instanceof Player)
				{
						try {
		      String nome = UtilNPC.location.get(e.getRightClicked().getLocation()).replace("§a§o", "");
		      
		    	  if (UtilNPC.location.get(e.getRightClicked().getLocation()).contains("§a§o"))
		    	  {
		    		  if (!Recharge.Instance.use(e.getPlayer(), nome, 1000L, false, false)) {
		    	        return;
		    	      }
		    		  String Servidor = AccountWeb.Conectar(Main.site + "/API/sala.php?modo=CONSUTAR_ON&nome=" + nome, "nome");
		    		  if (Servidor == null)
		    		  {
		    			  UtilSound.playSound(e.getPlayer(), Sounds.ANVIL_LAND, 0.5F, 0.2F);
		    			e.getPlayer().sendMessage("§cTodas as salas estão fechadas ou em jogos aguarde!");
		    			  return;
		    		  }
		    		  UtilSound.playSound(e.getPlayer(), Sounds.LEVEL_UP, 0.5F, 0.2F);
	             e.getPlayer().sendMessage("§cLocalizado a sala §a " + Servidor);
			      Bungee.SendPlayerToServer(e.getPlayer(), Servidor);
		    	  }
		    	  
		    	  if (nome.contains("§c§lEM BREVE"))
		    	  {
		    		  e.getPlayer().sendMessage("§4§lNPC §fEi para de cliquar em min meu nome é em breve oque você esta esperando que saia da aqui ?");
		    		  UtilSound.playSound(e.getPlayer(), Sounds.ANVIL_LAND, 0.5F, 0.2F);
		    	  }
				  }catch (Exception ec) {}
		      }
	
				
				}
		  
			public void ReiDoKDR(String nick)
			{
				SpawnEntity(""+nick+"",""+nick+"", new Location(Bukkit.getWorld("world"),-58.396,166,-60.537, -90,-4));
			}
		  
		  
			public void Loader(String url, String modo)
			{
				 URL host = null;
			     String texto = "{'ERRO':'NADA'}";
			      try
			      {
			        host = new URL(url);
			       
			      }
			      catch (MalformedURLException e1)
			      {
			    	   e1.printStackTrace();
			      }
			      URLConnection connection = null;
			      try
			      {
			        connection = host.openConnection();
			   
			        BufferedReader reader = null;
			     
			        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			         
			        String inputLine;
			        while ((inputLine = reader.readLine()) != null)
			        {
			            if (modo.equals("lobby"))
			            {
			            	ReiDoKDR(inputLine);
			            }
			        }
			        reader.close();
			       
			      }
			      catch (IOException e)
			      {
		              e.printStackTrace();
			      }
			}
			
			
		    @EventHandler
		    public void UpdateNPC(Atualizar event)  {
		      if (event.getType() != ModosUpdate.MIN_02) {
		        return;
		      }
		      UtilNPC.DarUpdate_All();
		    }
	
		  

			public void SpawnEntity(String nome,String skin, Location loc)
			{
				NPCRegistry re = CitizensAPI.getNPCRegistry();
				NPC entity = re.createNPC(EntityType.PLAYER, nome);
                entity.setName(nome);
				entity.setProtected(true);
		        entity.isFlyable();
		        entity.data().set(NPC.PLAYER_SKIN_UUID_METADATA, skin);
		        entity.despawn(DespawnReason.PENDING_RESPAWN);
				entity.spawn(loc);
			}
}
