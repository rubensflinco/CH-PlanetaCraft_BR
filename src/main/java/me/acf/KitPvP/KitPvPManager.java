/**
 * 
 */
package me.acf.KitPvP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.acf.FormatText.Format;
import me.acf.KitPvP.kitAPI.BarKit;
import me.acf.KitPvP.kitAPI.Kit;
import me.acf.KitPvP.kitAPI.Kits;
import me.acf.KitPvP.kitAPI.Menu;
import me.acf.KitPvP.scoreboard.Scoreboard;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.lobby.Lag.TPS;
import me.acf.lobby.extend.MobSpawn;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilPlayer;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.Bungee.Bungee;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.blood.Blood;
import me.hub.comandos.CriadorComandos;
import me.hub.comandos.geral.Admin;
import me.hub.comandos.geral.head;
import me.hub.config.Config;
import me.hub.recharge.Recharge;
import me.site.account.Account;
import me.site.account.rank.Rank;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPCRegistry;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author adriancf
 *
 */
public class KitPvPManager extends MiniPlugin{

	/**
	 * @param moduleName
	 * @param plugin
	 */
	
    public static NPCRegistry registry = CitizensAPI.getNPCRegistry();
   
	public KitPvPManager(JavaPlugin plugin) {
		super("Kit-PvP", plugin);
		PVP pvp = new PVP(plugin);;
		Sair sair = new Sair(plugin);
		Blood blod = new Blood(plugin);
		Kits kits = new Kits();
		Kit kit = new Kit(plugin);
		Arena arena = new Arena(plugin);
		Entrar entra = new Entrar(plugin);
	    head.desativar = true;
		JumpBlocos jump = new JumpBlocos(plugin);
	    new CriadorComandos().Ler_Comandos(Main.plugin, "me.security.registrar.comandos");
		 me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
		 
	   	  List<Entity> entities = Bukkit.getWorld("world").getEntities();
	   	  for (Entity ov : entities){
	   	  if (ov.getType() == EntityType.ENDERMITE)
	   			  ov.remove();
	         }
		  	  
			MiniGamesMananger.PlanetsWEB(EntityType.ENDERMITE, "§fTecnologia §7§lPlanets§1§lWEB", new Location(Bukkit.getWorld("world"),-1304,57,636));
		
	}

	public void Disable()
	{
	
	}
	
    public static void TEst(Player p)
    {
     p.sendBlockChange(new Location(p.getWorld(), -1300, 58, 639), Material.DIAMOND_BLOCK, (byte) 0);
    }
	
	public static void SpawnOvelha(EntityType e, String nome, Location loc)
	{
		Endermite Endermite = (Endermite) loc.getWorld().spawnEntity(loc, e);
		Endermite.setCustomName(nome);
		Endermite.setCustomNameVisible(true);
        MobSpawn.noAI(Endermite);
	}

	   
	  @EventHandler
	  public void Comandos(PlayerCommandPreprocessEvent event) {
		  if (CombatLog.EstaEmCombat(event.getPlayer()))
		  {
			Format.Erro("Você esta em pvp com o §a" + CombatLog.combat.get(event.getPlayer()).getName(), event.getPlayer());
			  return;
		  }
	    if ((event.getMessage().toLowerCase().startsWith("/me")) || 
	      (event.getMessage().toLowerCase().startsWith("/bukkit")))
	    {
	      event.getPlayer().sendMessage("§e§lVocê não pode fazer isto..!");
	      event.setCancelled(true);
	    }
	    if (event.getMessage().toLowerCase().startsWith("/ping"))
	    {
	      event.getPlayer().sendMessage("§e§lPong..");
	      event.setCancelled(true);
	    }
	    if (event.getMessage().toLowerCase().startsWith("/pong"))
	    {
	      event.getPlayer().sendMessage("§e§lPing..");
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
		 if (Kit.arena.contains(event.getPlayer()))
		 {
			 Material item = event.getItemDrop().getItemStack().getType();
	         if ((item == Material.MUSHROOM_SOUP) || (item == Material.BOWL)) {
			 event.getItemDrop().remove();
			 event.setCancelled(false);
	         }
	         else
	        	 event.setCancelled(true);
			 return;
		 }
		   event.setCancelled(true);
		   
	   }
	 
		@EventHandler
		public void Abrir(PlayerInteractEvent e)
		{
			Player jogador = e.getPlayer();
		    if (jogador.getGameMode() == GameMode.CREATIVE)
		      return;
		    if (e.getItem() == null)
		      return;
		    if (e.getItem().getItemMeta().getDisplayName() == null)
		      return;

		    if ((e.getItem().getType() == Material.CHEST) && (e.getItem().getItemMeta().getDisplayName().equals("§e§lSeletor de KIT")))
		    {
		      Menu.AbrirMenu(jogador);
		      e.setCancelled(true);
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

	   @EventHandler
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

	       if (event.getEntity() instanceof Player) {
	    	   Player  p = (Player) event.getEntity();
	    	      if (Kit.arena.contains(p))
			       {   
	    	    	  p.setHealth(0);
	    	    	  return;
			       }
	       }
	       double x = Bukkit.getWorld("world").getSpawnLocation().getX();
	       double y = Bukkit.getWorld("world").getSpawnLocation().getY() + 2.0D;
	       double z = Bukkit.getWorld("world").getSpawnLocation().getZ();
	       Location loc = new Location(event.getEntity().getWorld(), x, y, z);
	       event.getEntity().teleport(loc.clone().add(0.5,0,0.5));
	     }
	     else
	     {
			   if (event.getEntity() instanceof Player)
			   {
			       if (!Kit.verkit((Player) event.getEntity()).contains("Nenhum"))
			       {
			    	   return;
			       }
			   }
		       event.setCancelled(true);
		       
	     }
	   }
	   
	   @EventHandler
		public void removeBlock(EntityChangeBlockEvent e) {
			
				e.setCancelled(true);
			
		}
	   
		  @EventHandler
		  public void Iventarioitens(InventoryClickEvent e)
		  {
		    Player jogador = (Player)e.getWhoClicked();
		    if (jogador.getGameMode() == GameMode.CREATIVE)
		      return;
		    if (!Kit.arena.contains(jogador))
		    e.setCancelled(true);
		  }

    @EventHandler
    public void Utils(Atualizar event)  {
      if (event.getType() != ModosUpdate.FAST) {
        return;
      }

      new TPS();
      Scoreboard.UpdateScoreboard();
      
      Bukkit.getWorld("world").setTime(0);
      Bukkit.getWorld("world").setThunderDuration(0);
      Bukkit.getWorld("world").setThundering(false);
      Bukkit.getWorld("world").setWeatherDuration(0);
      Bukkit.getWorld("world").setStorm(false);
      me.hub.Admin.Admin.SumirStaff();
    
	  for (Player p : UtilServer.Jogadores())
	  {
		  for (Player all : UtilServer.Jogadores())
		  {
		  if (Kit.verkit(p).contains("Nenhum")){
			  all.hidePlayer(p);
		  }else{
			  if (Admin.admin.contains(p)){
				  all.hidePlayer(p);
			  }else{
			  all.showPlayer(p);
			  }
		  }
		  }
		  
	      BarKit.BarKit(p);
		  if (UtilPlayer.Ping(p) > 800)
		  {
			  me.hub.API.Chat.ActionBar(p, "§f§lVOCÊ ESTA COM §c§lLAG §f§lSEU PING É DE §6§l" + UtilPlayer.Ping(p) + " / 1500");
			  
		  }
		  if (UtilPlayer.Ping(p) > 1500)
		  {
			  p.kickPlayer("§c§lEXTREMO LAG\n§f§lMS: §a§l"+ UtilPlayer.Ping(p));
		  }
		  if (Kit.arena.contains(p))
		  {
			  if (!(Account.getRank(p)).Has(p, Rank.STAFF, false))
			   {
			  p.setAllowFlight(false);
			  p.setFlying(false);
			   }
		  }
	  
	  }
    	 
    }
    
    @EventHandler
    public void Placas(SignChangeEvent event)
    {
    
      if (event.getLine(0).equalsIgnoreCase("[KitPvP]"))
      {
    	  if ((Account.getRank(event.getPlayer())).Has(event.getPlayer(), Rank.STAFF, false))
		   {
        if (event.getLine(1).equalsIgnoreCase("Sopa"))
        {
          event.setLine(0, "§f§lKit§0§lPvP");
          event.setLine(1, "");
          event.setLine(2, "§a§lSopas");
        }
        else if (event.getLine(1).equalsIgnoreCase("reparar"))
        {
        	 event.setLine(0, "§f§lKit§0§lPvP");
        	 event.setLine(1, "");
             event.setLine(2, "§a§lReparar");
        }
      }
      }
    }
    
    @EventHandler
    public void clicar(PlayerInteractEvent e)
    {
      Player p = e.getPlayer();
      if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (
    	        (e.getClickedBlock().getType() == Material.SIGN_POST) || (e.getClickedBlock().getType() == Material.WALL_SIGN)))
    	      {
    	        Sign s = (Sign)e.getClickedBlock().getState();
    	        if (s.getLine(0).equalsIgnoreCase("§f§lKit§0§lPvP"))
    	        {
    	        	if (!Kit.arena.contains(p))
    	        	{
    	        		Format.Erro("Esta placa é de exemplo!", p);
    	        		return;
    	        	}
    	        	  if (!Recharge.Instance.use(p, "Placas", 2900L, true, false)) {
    	        	        return;
    	        	      }  
    	          ItemMeta im;
    	          if (s.getLine(2).equalsIgnoreCase("§a§lSopas"))
    	          {
    	              Inventory sop = Bukkit.createInventory(p, 54, "§1Sopas [54]");
    	              for (int i = 0; i < sop.getSize(); i++)
    	              {
    	                sop.setItem(i, UtilInv.AddItemReturn(Material.MUSHROOM_SOUP, 1, (byte)0, "§e§lSOPA", "§a§oPLACA"));
    	              }
    	              p.openInventory(sop);
    	      
    	          }
    	          if (s.getLine(2).equalsIgnoreCase("§a§lReparar"))
    	          {
    	        	  Random r = new Random();
    	        	  if (r.nextInt(100) > 15) {
    	        	UtilInv.repairAll(p);
    	        	Format.Comando("Placa", "Itens reparados com §aexito", p);
    	        	  }
    	        	  else
    	        	  {
    	        		  Format.Comando("Placa", "Itens reparados com §aerros", p);
    	        		  UtilSound.playSound(p, Sounds.IRONGOLEM_HIT, 1.0F, 1.0F);
    	        	  }
    	            }
    	          }
    	        }
      if ((e.getItem() == null) || (e.getItem().getItemMeta() == null))
    	  return;
      
    	  if (e.getItem().getItemMeta().getDisplayName() != null)
    		  return;
      if (e.getItem().getItemMeta().getDisplayName().contains("Lobby"))
      {
    	  Bungee.SendPlayerToServer(p, "lobby");
    	  return;
      }
     
      }
    
    @EventHandler(priority=EventPriority.HIGHEST)
    public void regenerar(PlayerInteractEvent e)
    {
      Player p = e.getPlayer();
      if (((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)) && 
        (p.getItemInHand().getType() == Material.MUSHROOM_SOUP) && 
        (p.getHealth() > 0.0D) && (p.getHealth() < 20.0D))
      {
          p.getItemInHand().setType(Material.BOWL);
          p.getInventory().remove(new ItemStack(Material.BOWL, 1));
          p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BOWL));
        
        int regen = Integer.parseInt(Config.retornar(p, "kitpvp.regenerar"));
        int feed = 20;
    	  Random r = new Random();
    	  if (r.nextInt(100) < 2) {
     		  Format.Erro("Não foi possivel tomar sua sopa.", p);
    		  return;
    	  }
        if (p.getHealth() + regen <= 20.0D) {
          p.setHealth(p.getHealth() + regen);
        } else {
          p.setHealth(20.0D);
        }
        if (p.getFoodLevel() + feed <= 20) {
          p.setFoodLevel(p.getFoodLevel() + feed);
        } else {
          p.setFoodLevel(20);
        }
      }
    }
    
    @EventHandler
    public void click(PlayerInteractEvent e)
    {
      Player p = e.getPlayer();
      if ((e.getAction() == Action.RIGHT_CLICK_BLOCK))
      {
    	  if (p.getGameMode() == GameMode.CREATIVE)
    		  return;
    	  e.setCancelled(true);
      }
    }
    
	@EventHandler
	public void Click(PlayerInteractEntityEvent event)
	{
		
			if (event.getRightClicked() instanceof Player)
			{
				if (event.getRightClicked().getCustomName().contains("Tutorial"))
				{
				  event.getPlayer().sendMessage("§f§lESCOLHA UM §a§lKIT §f§lNO SEU BAU.");
				  event.getPlayer().sendMessage("§f§lPARA IR §c§lPVP §f§lESCOLHA UMA §a§lOVELHA");
				}
			}
	}
}
