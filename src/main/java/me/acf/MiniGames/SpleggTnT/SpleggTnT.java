package me.acf.MiniGames.SpleggTnT;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.GameEvents;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.SpleggTnT.Scoreboard.Scoreboard;
import me.acf.MiniGames.SpleggTnT.Utils.TeleportPlayer;
import me.acf.MiniGames.SpleggTnT.kits.Kit;
import me.acf.MiniGames.SpleggTnT.kits.Kits;
import me.acf.MiniGames.SpleggTnT.kits.Menu;
import me.acf.MiniGames.Style.UserData.Style;
import me.acf.MiniGames.eventos.GameIniciandoEvent;
import me.acf.MiniGames.eventos.GameInvencivelEvent;
import me.acf.MiniGames.eventos.GameJogandoEvent;
import me.acf.MiniGames.eventos.Utils.UtilsWin;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilServer;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;

public class SpleggTnT extends MiniPlugin {

	public static MiniGamesMananger arc;
	public static String world = "Default";
	public static List <Player> EscolherMapa = new ArrayList<Player>();
	public static int JaFoiOmapa = 0;
	public static HashMap<String, String> VotouMapa = new HashMap();
	public static HashMap<String, String> VotosMapa = new HashMap();
	
	public SpleggTnT(JavaPlugin plugin) {
		super("", plugin);
		
		// TODO Auto-generated constructor stub
	   // DEV @αdяiαиcf
		arc = new MiniGamesMananger(plugin, "SpleggTnT");
		arc.necessario = 2;
	    arc.Invencivel = 20;
	    arc.tempo = 60;
	    
	    Entrar entrar = new Entrar(plugin);
	    Sair sair = new Sair(plugin);
	    Kit Kit = new Kit(plugin);
		Kits Kits = new Kits();
		Menu Menu = new Menu();
	}
	
	
    @EventHandler
    public void ScoreBoard(Atualizar event)  {
      if (event.getType() != ModosUpdate.SLOW) {
        return;
      }
      for (Player player : Bukkit.getOnlinePlayers()) {
      Scoreboard.CriarScoreboard(player);
      }
    }
    
    @EventHandler
    public void VoltarArena(Atualizar event)  {
      if (event.getType() != ModosUpdate.SEC) {
        return;
      }
      
      for (Player player : Bukkit.getOnlinePlayers()) {
      if ((Arcade.estilo.equals(ArcadeType.INVENCIVEL)) || (Arcade.estilo.equals(ArcadeType.JOGANDO))){
      if (player.getWorld().getName().contains(Main.plugin.getConfig().getString("MapaDeJogo"))){
    	  
      }else{
    	  player.sendMessage("§4ERRO §cUm jogador está fora do mapa original !");
    	  TeleportPlayer.VoltarNaIlha(player);
      }}}
    }
	
	@EventHandler
	public void Iniciando(GameIniciandoEvent event)
	{
		if (arc.tempo <= 0)
		{
			System.out.print("Iniciou");
			for (final Player p : UtilServer.Jogadores())
			{
				if (MiniGamesMananger.jogadores.get(p).style.equals(Style.VIVO))
				{
					final File backupDir = new File("mapas");
					for (File source : backupDir.listFiles())
					 if (source.isDirectory()) {
						 if (source.getName().contains("world")){
						 }else{
								String GET = SpleggTnT.VotosMapa.get(source.getName());
								if (GET == null){
						        Main.plugin.getConfig().set(""+source.getName()+".Votos", Integer.valueOf(0));
						        Main.plugin.saveConfig();
								}else{
								Main.plugin.getConfig().set(""+source.getName()+".Votos", Integer.valueOf(GET));
								Main.plugin.saveConfig();
								}
						 }}
					
					int line = 0;
					for (final File source : backupDir.listFiles())
					 if (source.isDirectory()) {
						 if (source.getName().contains("world")){
						 }else{
							 String GET = SpleggTnT.VotosMapa.get(source.getName());
							 if (GET == null){
					    	   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
					    	   	      public void run() {
					    	   	    	  if (JaFoiOmapa >= 1){
					    	   	    	  }else{
									        Main.plugin.getConfig().set("MapaDeJogo", Main.plugin.getConfig().getString(""+source.getName()+".Nome"));
									        Main.plugin.saveConfig();
									        p.sendMessage("§3 " );
									        p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7O jogo vai começar no §f"+Main.plugin.getConfig().getString(""+source.getName()+".Nome")+"§7 !" );
									        p.sendMessage("§3 " );
									        JaFoiOmapa = 2;
					    	   	    	  }
					    	   	      }
					    	   	    }
					    	   	    , 10L);
							 }else{
							 if (Integer.parseInt(GET) >= 1){
								  if (JaFoiOmapa >= 1){
			    	   	    	  }else{
							        Main.plugin.getConfig().set("MapaDeJogo", Main.plugin.getConfig().getString(""+source.getName()+".Nome"));
							        Main.plugin.saveConfig();
							        p.sendMessage("§3 " );
							        p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7O jogo vai começar no §f"+Main.plugin.getConfig().getString(""+source.getName()+".Nome")+"§7 !" );
							        p.sendMessage("§3 " );
							        JaFoiOmapa = 1;
			    	   	    	  }
							 }
							 }
								
		 }
			}
				      
			           if (Main.plugin.getConfig().getString(""+Main.plugin.getConfig().getString("MapaDeJogo")+".Nome") == Main.plugin.getConfig().getString("MapaDeJogo")){
			                if (Main.plugin.getConfig().getString(""+Main.plugin.getConfig().getString("MapaDeJogo")+".Tempo").equals("Dia")){
			                	Bukkit.getWorld(Main.plugin.getConfig().getString("MapaDeJogo")).setTime(500);
			                }
			                if (Main.plugin.getConfig().getString(""+Main.plugin.getConfig().getString("MapaDeJogo")+".Tempo").equals("Tarde")){
			                	Bukkit.getWorld(Main.plugin.getConfig().getString("MapaDeJogo")).setTime(12500);
			                }
			                if (Main.plugin.getConfig().getString(""+Main.plugin.getConfig().getString("MapaDeJogo")+".Tempo").equals("Noite")){
			                	Bukkit.getWorld(Main.plugin.getConfig().getString("MapaDeJogo")).setTime(20000);
			                }
			            }
					
			           if (!MiniGamesMananger.Specter.contains(p)) {
				      TeleportPlayer.JogadorTeleporteRegiao(p);

					p.setGameMode(GameMode.SURVIVAL);
					p.getInventory().clear();
					Kit.GiveKit(p);
			           }
				}
			}
		}
	}
	
	@EventHandler
	  public void Clique(final PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    if (GameEvents.Proteger){
	    if (!SpleggTnT.EscolherMapa.contains(p)) {
    if ((p.getItemInHand().getType() == Material.SAPLING)&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
    	me.acf.MiniGames.SpleggTnT.Utils.EscolherMapa.MenuMapas(p);
    	e.setCancelled(true);
    }
	    }else{
	        if ((p.getItemInHand().getType() == Material.SAPLING)&& ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
	        	me.acf.MiniGames.SpleggTnT.Utils.EscolherMapa.MenuMapas(p);
	        	e.setCancelled(true);
	        }
	    }
    
	    }
    
	}
	
	@EventHandler
	public void Invencivel(GameInvencivelEvent event)
	{
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
		UtilsWin.Check_Vitoria();
	}
	
	
	  @EventHandler
	  public void onVoidDamage(EntityDamageEvent event)
	  {
	    if (event.getCause() == EntityDamageEvent.DamageCause.VOID)
	    {
	      Entity ent = event.getEntity();
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
