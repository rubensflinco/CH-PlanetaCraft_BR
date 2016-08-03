package me.acf.MiniGames.HungerGames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import me.acf.FormatText.Format;
import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.GameEvents;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.HungerGames.Feast.FeastGeradorCord;
import me.acf.MiniGames.HungerGames.Feast.MiniFeastGeradorCord;
import me.acf.MiniGames.HungerGames.Scoreboard.Scoreboard;
import me.acf.MiniGames.HungerGames.kits.Kit;
import me.acf.MiniGames.HungerGames.kits.Kits;
import me.acf.MiniGames.HungerGames.kits.LojaDeKits;
import me.acf.MiniGames.HungerGames.kits.Menu;
import me.acf.MiniGames.Style.UserData.Style;
import me.acf.MiniGames.eventos.GameIniciandoEvent;
import me.acf.MiniGames.eventos.GameInvencivelEvent;
import me.acf.MiniGames.eventos.GameJogandoEvent;
import me.acf.MiniGames.eventos.Utils.UtilsWin;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.Schematic;
import me.hub.API.Util.UtilSchematic;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.UtilTitle;
import me.hub.API.Util.UtilSchematic.Modo;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.Sound.Sounds;
import me.hub.Scoreboard.ScoreboardAPI;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.config.Config;

public class HungerGames extends MiniPlugin {

	public static MiniGamesMananger arc;
	public static HashMap<Player, Location> locantiga = new HashMap();
	
	public static List <Player> EscolherMapa = new ArrayList<Player>();
	public static int JaFoiOmapa = 0;
	public static HashMap<String, String> VotouMapa = new HashMap();
	public static HashMap<String, String> VotosMapa = new HashMap();
	
	public static int umavez = 0;
	
	public static Schematic schem;
	public static Schematic feast;
	public static Schematic minifeast;
	
	public HungerGames(JavaPlugin plugin) {
		super("", plugin);
		
		// TODO Auto-generated constructor stub
	   // DEV @αdяiαиcf
		arc = new MiniGamesMananger(plugin, "HungerGames");
		arc.necessario = 3;
	    arc.Invencivel = 90;
	    arc.tempo = 60;
	    
	    Main.plugin.getConfig().set("MapaDeJogo", "world");
        Main.plugin.saveConfig();
    	Bukkit.getServer().getLogger().log(Level.CONFIG, "Configuraçoes modificadas e salvas !");
	    
	    Entrar entrar = new Entrar(plugin);
	    Sair Sair = new Sair(plugin);
	    
  	    Kit Kit = new Kit(plugin);
  	    Kits Kits = new Kits();
  	    Menu Menu = new Menu();
  	    LojaDeKits LojaDeKits = new LojaDeKits(plugin);
	}
	
	  @EventHandler
	  public void sopa(PlayerInteractEvent e) {
	      Player p = e.getPlayer();
	      if (((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)) && 
	        (p.getItemInHand().getType() == Material.MUSHROOM_SOUP) && 
	        (p.getHealth() > 0.0D) && (p.getHealth() < 20.0D))
	      {
	          p.getItemInHand().setType(Material.BOWL);
	          p.getInventory().remove(new ItemStack(Material.BOWL, 1));
	          p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BOWL));
	        
	        int regen = Integer.parseInt(Config.retornar(p, "hg.regenerar"));
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
	    public void ScoreBoard(Atualizar event)  {
	      if (event.getType() != ModosUpdate.SLOW) {
	        return;
	      }
	      for (Player p : Bukkit.getOnlinePlayers()) {
	    	  ScoreboardAPI.remover(p);
		      Scoreboard.CriarScoreboard(p);
	      }
	    }
	    
	    @EventHandler
	    public void VoltarArena(Atualizar event)  {
	      if (event.getType() != ModosUpdate.SEC) {
	        return;
	      }
	      
	      for (Player player : Bukkit.getOnlinePlayers()) {
	      if (Arcade.estilo.equals(ArcadeType.JOGANDO)){
	      if (player.getWorld().getName().contains(Main.plugin.getConfig().getString("MapaDeJogo"))){
	    	  
	      }else{
	    	  player.sendMessage("§4ERRO §cUm jogador está fora do mapa original !");
	    	  
	      }}}
	    }
	
	@EventHandler
	public void Iniciando(GameIniciandoEvent event)
	{
		if (arc.tempo <= 0)
		{
			System.out.print("Iniciou");
			
			
			
			for (Player p : UtilServer.Jogadores())
			{
				if (MiniGamesMananger.jogadores.get(p).style.equals(Style.VIVO));
				{
					
				      
			           if (!MiniGamesMananger.Specter.contains(p)) {
					 Main.plugin.getConfig().set("MapaDeJogo", p.getWorld().getName());
					 Main.plugin.saveConfig();
					 
		        	 Location l = new Location(p.getWorld(), 0, 200, 0);
					 UtilSchematic.removePortaSchematic(p.getWorld(), l, schem);
					p.setGameMode(GameMode.SURVIVAL);
					p.getInventory().clear();
					Kit.GiveKit(p);
					UtilSound.playSound(p, Sounds.WITHER_SPAWN, 10.0F, 1.0F); 
			           }
				}
			}
		}
	}
	
	
	@EventHandler
	public void Invencivel(GameInvencivelEvent event)
	{
		if (umavez == 0){
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "worldborder set 1000.9 "+arc.tempo);
		umavez = + 1;
		}
		if (arc.tempo == 20)
		{
			for (Player p : UtilServer.Jogadores())
			{
		Location l = new Location(p.getWorld(), 0, 200, 0);
		UtilSchematic.removeSchematic(p.getWorld(), l, schem);
		}
		}
		if (arc.tempo <= 0)
		{
			System.out.print("Iniciou acabo inv");
			for (Player p : UtilServer.Jogadores())
			{
				p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7PvP foi §fativado §7cuidado !");
				if (!MiniGamesMananger.Specter.contains(p)) {
			   p.setGameMode(GameMode.SURVIVAL);
				}
			}
		}
	}
	
	@EventHandler
	public void EmJogo(GameJogandoEvent event)
	{

	    if (arc.tempo == 350){
	    	MiniFeastGeradorCord.RandomCord();
	    }
    if (arc.tempo == 360){
    	
    	try {
			HungerGames.minifeast = HungerGames.arc.SchematicLoader("MiniFeast.schematic");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Location l = new Location(Bukkit.getWorld("world"), Main.plugin.getConfig().getInt("MiniFeast.cord.X"), Main.plugin.getConfig().getInt("MiniFeast.cord.Y"), Main.plugin.getConfig().getInt("MiniFeast.cord.Z"));
    	// UtilSchematic.removeSchematic(Bukkit.getWorld("world"), l, feast);
    	
    	try {
			HungerGames.minifeast = HungerGames.arc.SchematicPaste(minifeast, l, Modo.Feast);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for (final Player p : UtilServer.Jogadores())
		{
        	UtilTitle.sendTitle(p,20,40,20,"§5Mini Feast naceu !","§7Cordenadas §7X : §f"+Main.plugin.getConfig().getInt("MiniFeast.cord.X")+"§7 Z : §f"+Main.plugin.getConfig().getInt("MiniFeast.cord.Z"));
			p.sendMessage("§5§l"+ Bukkit.getServerName() +" §cMini Feast naceu nas cordenadas X : §f"+Main.plugin.getConfig().getInt("MiniFeast.cord.X")+"§c Z : §f"+Main.plugin.getConfig().getInt("MiniFeast.cord.Z"));
		    UtilSound.playSound(p, Sounds.WITHER_SPAWN, 10.0F, 1.0F); 
		}
    	
    	
 }
    if (arc.tempo == 640){
    	FeastGeradorCord.RandomCord();
    }
        if (arc.tempo == 680){
			for (final Player p : UtilServer.Jogadores())
			{
				p.sendMessage("§5§l"+ Bukkit.getServerName() +" §cFeast vai nacer nas cordenadas X : §f"+Main.plugin.getConfig().getInt("Feast.cord.X")+"§c Z : §f"+Main.plugin.getConfig().getInt("Feast.cord.Z"));
				UtilSound.playSound(p, Sounds.ARROW_HIT, 10.0F, 1.0F); 
	        	try {
					HungerGames.feast = HungerGames.arc.SchematicLoader("Feast.schematic");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	Location l = new Location(Bukkit.getWorld("world"), Main.plugin.getConfig().getInt("Feast.cord.X"), Main.plugin.getConfig().getInt("Feast.cord.Y"), Main.plugin.getConfig().getInt("Feast.cord.Z"));
	        	// UtilSchematic.removeSchematic(Bukkit.getWorld("world"), l, feast);
	        	
	        	try {
					HungerGames.feast = HungerGames.arc.SchematicPaste(feast, l, Modo.PreFeast);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        }
        if (arc.tempo == 700){
			for (final Player p : UtilServer.Jogadores())
			{
				p.sendMessage("§5§l"+ Bukkit.getServerName() +" §6Feast vai nacer nas cordenadas X : §f"+Main.plugin.getConfig().getInt("Feast.cord.X")+"§6 Z : §f"+Main.plugin.getConfig().getInt("Feast.cord.Z"));
				UtilSound.playSound(p, Sounds.ARROW_HIT, 10.0F, 1.0F); 
			}
        }
        if (arc.tempo == 720){
        	
        	
        	try {
				HungerGames.feast = HungerGames.arc.SchematicLoader("Feast.schematic");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	Location l = new Location(Bukkit.getWorld("world"), Main.plugin.getConfig().getInt("Feast.cord.X"), Main.plugin.getConfig().getInt("Feast.cord.Y"), Main.plugin.getConfig().getInt("Feast.cord.Z"));
        	// UtilSchematic.removeSchematic(Bukkit.getWorld("world"), l, feast);
        	
        	try {
				HungerGames.feast = HungerGames.arc.SchematicPaste(feast, l, Modo.Feast);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "worldborder center "+HungerGames.arc.world.getSpawnLocation().getBlockX()+" "+HungerGames.arc.world.getSpawnLocation().getBlockZ()+"");
	  	    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "worldborder set 40.9 300");
	  	    for (final Player p : UtilServer.Jogadores())
			{
	  	    	UtilTitle.sendTitle(p,20,40,20,"§5Feast naceu !","§7Cordenadas §7X : §f"+Main.plugin.getConfig().getInt("Feast.cord.X")+"§7 Z : §f"+Main.plugin.getConfig().getInt("Feast.cord.Z"));
				p.sendMessage("§5§l"+ Bukkit.getServerName() +" §aFeast naceu nas cordenadas X : §f"+Main.plugin.getConfig().getInt("Feast.cord.X")+"§a Z : §f"+Main.plugin.getConfig().getInt("Feast.cord.Z"));
				UtilSound.playSound(p, Sounds.WITHER_SPAWN, 10.0F, 1.0F); 
			}
        	
        	
     }
        if (arc.tempo == 720){
			for (final Player p : UtilServer.Jogadores())
			{
				UtilTitle.sendTitle(p,20,40,20,"§§5Corra para o Feast !","§7A borda do mundo começou a fechar");
				p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7A borda do mundo começou a fechar corra pro §fFeast §7em §f5 Minutos§c elá vai fechar por completo!");
				UtilSound.playSound(p, Sounds.ARROW_HIT, 10.0F, 1.0F); 
			}
        }
        
        if (arc.tempo == 1020){
			for (final Player p : UtilServer.Jogadores())
			{
				UtilTitle.sendTitle(p,20,40,20,"§5A grande Final !","§7Solte os dragões !");
				p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Final da partida batalhe até a morte tome cuidado com os dragão !");
			}
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "summon EnderDragon "+HungerGames.arc.world.getSpawnLocation().getBlockX()+" 85 "+HungerGames.arc.world.getSpawnLocation().getBlockZ()+"");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "summon EnderDragon "+HungerGames.arc.world.getSpawnLocation().getBlockX()+" 80 "+HungerGames.arc.world.getSpawnLocation().getBlockZ()+"");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "summon EnderDragon "+HungerGames.arc.world.getSpawnLocation().getBlockX()+" 75 "+HungerGames.arc.world.getSpawnLocation().getBlockZ()+"");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "summon EnderDragon "+HungerGames.arc.world.getSpawnLocation().getBlockX()+" 70 "+HungerGames.arc.world.getSpawnLocation().getBlockZ()+"");
        }
        
       UtilsWin.Check_Vitoria();
       
	}


	

	
	  @EventHandler
	  public void onVoidDamage(EntityDamageEvent event)
	  {
	    if (event.getCause() == EntityDamageEvent.DamageCause.VOID)
	    {
	      final Entity ent = event.getEntity();
	      if (ent == null) {
	        return;
	      }
	      if (!(ent instanceof Player)) {
	        return;
	      }
	      if ((ent instanceof Player))
	      {
	    	  if (GameEvents.Proteger){
	        ((Player)ent).teleport(ent.getWorld().getSpawnLocation());
			 Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() { public void run() {
			        ((Player)ent).teleport(ent.getWorld().getSpawnLocation());
					      }}, 6L);
	        ((Player)ent).setFallDistance(0.0F);
	        event.setCancelled(true);
	    	  }
	    	  
	    	  if (MiniGamesMananger.Specter.contains(((Player)ent))){
	    		  

		        ((Player)ent).setFallDistance(0.0F);
		        event.setCancelled(true);
	    	  }
	    	  
	      }
	    }
	  }
	
}
