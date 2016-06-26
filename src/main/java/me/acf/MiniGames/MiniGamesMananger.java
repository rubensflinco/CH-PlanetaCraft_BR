package me.acf.MiniGames;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.Style.UserData;
import me.acf.MiniGames.Style.UserData.Style;
import me.acf.MiniGames.Style.Utils.MGSpectator;
import me.acf.MiniGames.eventos.GameIniciandoEvent;
import me.acf.MiniGames.eventos.GameInvencivelEvent;
import me.acf.MiniGames.eventos.GameJogandoEvent;
import me.acf.MiniGames.team.TeamData;
import me.acf.MiniGames.tipos.Lobby;
import me.acf.servidor.Servidor;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Chat;
import me.hub.API.Util.Schematic;
import me.hub.API.Util.UtilSchematic;
import me.hub.API.Util.UtilSchematic.Modo;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilTime;
import me.hub.API.Util.UtilTitle;
import me.hub.Bungee.Bungee;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.blood.Blood;
import me.site.account.AccountWeb;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

/**
 * @author adriancf
 *
 */
public class MiniGamesMananger extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	
	public static int tempo = 0;
    public static String fechousala = "Aberta";
    public static String game = "Carregando";
    public static int necessario = 2;
    public static int Invencivel = 2;
    private boolean anuncioplayer = false; 
	private int max = 0;
	private float level = 0.99F;
	public Sound spawn = Sound.WITHER_SPAWN;
	public static UtilTitle tituloIniciando = new UtilTitle("§a","§6Iniciando MiniGame",0,3,0);
	public static UtilTitle tituloInvisibilidade = new UtilTitle("§a","§6Ativando PvP",0,3,0);
	
	public static HashMap<Player,UserData> jogadores = new HashMap<>();
	public static ArrayList<Player> Vivos = new ArrayList<>();
	public static ArrayList<Player> Specter = new ArrayList<>();
	
	public static HashMap<Player, Time> jogadoteam = new HashMap<>();
	private static HashMap<Entity, TeamData> ovelhas = new HashMap<>();
	
	public LadoTeam lado = LadoTeam.east;
	public Location teamselection = world.getSpawnLocation(); 
    public static World world = Bukkit.getWorld("world"); 
	public MiniGamesMananger(JavaPlugin plugin,String MiniGame) {
		super("MiniGame", plugin);
	    this.game = MiniGame;
	    Lobby lob = new Lobby(Main.plugin);
	    GameEvents event = new GameEvents(Main.plugin);
	    Blood blod = new Blood(Main.plugin);
	    MGSpectator MGSpectator = new MGSpectator(Main.plugin);
	}

	@EventHandler
	public void LobbyMenu(PlayerCommandPreprocessEvent event)
	{
		Player p = event.getPlayer();
		if (event.getMessage().equals("/lobby")){
		       event.setCancelled(true);
			   p.playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 1.0F);
			   MGSpectator.Menu1(p);
		}
		if (event.getMessage().equals("/hub")){
			   event.setCancelled(true);
			   p.playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 1.0F);
			   MGSpectator.Menu1(p);
		}
		if (event.getMessage().equals("/sair")){
			   event.setCancelled(true);
			   p.playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 1.0F);
			   MGSpectator.Menu1(p);
		}
		if (event.getMessage().equals("/leave")){
			   event.setCancelled(true);
			   p.playSound(p.getLocation(), Sound.CHEST_OPEN, 10.0F, 1.0F);
			   MGSpectator.Menu1(p);
		}
	}
	
	public void SetMaximo(int players)
	{
		this.max = players;
	}
	
	public void CriarTime(Time nome)
	{
		    Location loc = teamselection;
			Lobby.CriarBase(loc, nome.retorno());
		    SpawnEntity(EntityType.SHEEP, "", loc.clone().add(-0.15,2.50,0.50),nome);
			System.out.print("Criando time " + nome + " Selector (X: " + loc.getX() + ", Y: " + loc.getY() + ", Z:" + loc.getZ() + ")");
		   if (lado.equals(lado.east))
			teamselection.add(3.0D,0,0);
		   if (lado.equals(lado.west))
				teamselection.add(-3.0D,0,0);
		   if (lado.equals(lado.south))
				teamselection.add(0,0,3.0D);
		   if (lado.equals(lado.north))
				teamselection.add(0,0,-3.0D);
	}
	
	public enum LadoTeam {
		east,
		west,
		south,
		north;
	}
	
	public enum Time {
		Amarelo(4,DyeColor.YELLOW,"§e§lAmarelo"),
		Vermelho(14,DyeColor.RED,"§c§lVermelho"),
		Verder(5,DyeColor.GREEN,"§a§lVerde"),
		Azul(3,DyeColor.BLUE,"§b§lAzul");
		int id;
		DyeColor cor;
		String nome;
		Time(int id,DyeColor cor, String nome)
		{
			this.id = id;
			this.cor = cor;
			this.nome = nome;
		}
		public int retorno()
		{
			return id;
		}
	}
	
	public void Som(Sound sound)
	{
		 for (Player online : UtilServer.Jogadores()) {
			 online.playSound(online.getLocation(), sound, 10.0F, 1.0F);
		 }
	}
	
	public void Format()
	{
        long milliseconds = tempo * 1000;
        String timeLeft = UtilTime.convertString(milliseconds, 0, UtilTime.TimeUnit.FIT);
        for (Player p : UtilServer.Jogadores())
        {
        	Chat.ActionBar(p, "§a§lIniciando em §e§l" + timeLeft);
        	p.setLevel(tempo);
        }
        if (tempo == 60) {
        	Bukkit.broadcastMessage("§5§l"+ Bukkit.getServerName() +" §7Iniciando em §a§l1 Minuto");
        	Som(Sound.NOTE_STICKS);
        }
        if (tempo == 30) {
        	Bukkit.broadcastMessage("§5§l"+ Bukkit.getServerName() +" §7Iniciando em §a§l30 Segundos");
        	Som(Sound.NOTE_STICKS);
        }
        if (tempo == 10) {
        	Bukkit.broadcastMessage("§5§l"+ Bukkit.getServerName() +" §7Iniciando em §6§l10 Segundos");
        	Som(Sound.NOTE_STICKS);
        }
        if (tempo <= 5) {
        	Bukkit.broadcastMessage("§5§l"+ Bukkit.getServerName() +" §7Iniciando em §c§l" + tempo + " Segundos");
        	Som(Sound.CLICK);
        }
        if (tempo == 3) {
		tituloIniciando.setTitle("§a3");
		tituloIniciando.broadcast();
        }
        if (tempo == 2) {
    		tituloIniciando.setTitle("§62");
    		tituloIniciando.broadcast();
        }
        if (tempo == 1) {
    		tituloIniciando.setTitle("§c1");
    		tituloIniciando.broadcast();
        }
        if (tempo == 0) {
    		tituloIniciando.setTitle("§cGO");
    		tituloIniciando.broadcast();
        }
		if (tempo <= 100)
		{
			 for (Player online : UtilServer.Jogadores()) {
				 online.setExp(level);
				 level =- 0.1F;
			 }
		}
		
	}
	
	public void Format_Inv()
	{
        long milliseconds = tempo * 1000;
        String timeLeft = UtilTime.convertString(milliseconds, 0, UtilTime.TimeUnit.FIT);
        for (Player p : UtilServer.Jogadores())
        {
        	Chat.ActionBar(p, "§a§lPvP vai ativar em §e§l" + timeLeft);
            if (tempo == 3) {
            	tituloInvisibilidade.setTitle("§a3");
            	tituloInvisibilidade.broadcast();
                }
                if (tempo == 2) {
                	tituloInvisibilidade.setTitle("§62");
                	tituloInvisibilidade.broadcast();
                }
                if (tempo == 1) {
                	tituloInvisibilidade.setTitle("§c1");
                	tituloInvisibilidade.broadcast();
                }
                if (tempo == 0) {
                	tituloInvisibilidade.setTitle("§cGO");
                	tituloInvisibilidade.broadcast();
                }
        }
	}

	
	@EventHandler
	public void Secs(Atualizar event)
	{
		if (event.getType() == ModosUpdate.SEC)
		{
			if (Arcade.estilo.equals(ArcadeType.INICIANDO))
			{
				tempo--;
				System.out.print(tempo);
				Format();
	            Bukkit.getPluginManager().callEvent(new GameIniciandoEvent());
	            if (tempo <= 0) {
	            	Som(spawn);
	            	  Arcade.estilo = ArcadeType.INVENCIVEL;
	            	  GameEvents.Proteger = false;
		            	tempo = Invencivel; 
	            }
			}
			if (Arcade.estilo.equals(ArcadeType.INVENCIVEL))
			{
				tempo--;
	            Bukkit.getPluginManager().callEvent(new GameInvencivelEvent());
	            for (Player p : MiniGamesMananger.jogadores.keySet()) {
		        	if (MiniGamesMananger.jogadores.get(p).style == Style.VIVO)
		        	   MiniGamesMananger.jogadores.get(p).Tempo_Vivo++;
		           }
	            Format_Inv();
	            if (tempo <= 0) {
	                  tempo = 0; 
	            	  Arcade.estilo = ArcadeType.JOGANDO;
	            	  GameEvents.ProtegerInv = false;
	            }
	            if (fechousala.contains("Aberta")){
	            	Servidor.ModoGame("INICIANDO");
	            	fechousala = "INICIANDO";
	            }
			}
			if (Arcade.estilo.equals(ArcadeType.JOGANDO))
			{
				tempo++;
		           Bukkit.getPluginManager().callEvent(new GameJogandoEvent());
		           
		           for (Player p : MiniGamesMananger.jogadores.keySet()) {
		        	if (MiniGamesMananger.jogadores.get(p).style == Style.VIVO)
		        	   MiniGamesMananger.jogadores.get(p).Tempo_Vivo++;
		           }
		            if (fechousala.contains("INICIANDO")){
		            	Servidor.ModoGame("EM-JOGO");
		            	fechousala = "EM-JOGO";
		            }
			}
		}
	}
	
	@EventHandler
	public void Atualizar(Atualizar event)
	{
		if (event.getType() == ModosUpdate.FAST)
		{
	    	  List<Entity> entities = world.getEntities();
	    	  for (Entity ov : entities){
	    	  if (ov.getType() == EntityType.SHEEP)
	    	  {
	    		  if (ovelhas.containsKey(ov))
	    		  {
	    			  ov.setCustomName("§fTime " + ovelhas.get(ov).Time().nome + "§f, " + ovelhas.get(ov).Jogadores() + " Jogadores");
	    		      ov.setCustomNameVisible(true);
	    		  }
	    	  }
	    	  if (jogadores.size() >= necessario)
	    	  {
	    		  if (Arcade.noInicio())
	    		  Arcade.estilo = ArcadeType.INICIANDO;
	    	  }
	    	  else
	    	  {
	    		  if (Arcade.noInicio())
	    		  {
	    			 Arcade.estilo = ArcadeType.AGUARDANDO;
	    		  }
	    	  }
		}
		}
	}
	
	public Schematic SchematicLoader(String file) throws IOException
	{
		Schematic schem = UtilSchematic.loadSchematic(new File(Main.plugin.getDataFolder(),file));
	    return schem;
	}
	
	public Schematic SchematicLoaderPaste(String file,Location loc,Modo modo) throws IOException
	{
		Schematic schem = UtilSchematic.loadSchematic(new File(Main.plugin.getDataFolder(),file));
	    UtilSchematic.pasteSchematic(world, loc, schem, modo);
	    return schem;
	}
	
	public Schematic SchematicPaste(Schematic schem,Location loc,Modo modo) throws IOException
	{
	    UtilSchematic.pasteSchematic(world, loc, schem, modo);
	    return schem;
	}
	
	 public static void CarregarMundo(String nome)
	 {
		 Bukkit.getServer().getLogger().log(Level.INFO, "Carregado Mundo -> "+nome+" !");	
		Bukkit.getServer().createWorld(WorldCreator.name(""+nome+""));
		Bukkit.getWorlds().add(Bukkit.getWorld(""+nome+""));
		
		int line = 0;
		for (Entity e : Bukkit.getServer().getWorld(""+nome+"").getEntities())
		{
			if (e.getType() == EntityType.RABBIT){
				Location l = e.getLocation();
			      int x1 = (int)l.getX();
			      int y1 = (int)l.getY();
			      int z1 = (int)l.getZ();
			      
			      Bukkit.getServer().getConsoleSender().sendMessage("§5§l"+ Bukkit.getServerName() +" §7Lobby Espectador setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

			      Main.plugin.getConfig().set("Espectador."+nome+".X", Integer.valueOf(x1));
			      Main.plugin.getConfig().set("Espectador."+nome+".Y", Integer.valueOf(y1));
			      Main.plugin.getConfig().set("Espectador."+nome+".Z", Integer.valueOf(z1));
			      Main.plugin.saveConfig();
			      e.remove();
			}
			if (e.getType() == EntityType.ENDER_CRYSTAL){
				Location l = e.getLocation();
				  line++;
			      int x1 = (int)l.getX();
			      int y1 = (int)l.getY();
			      int z1 = (int)l.getZ();
			      
			      Bukkit.getServer().getConsoleSender().sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador "+line+" setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

			      Main.plugin.getConfig().set("Spawn."+nome+".Jogador"+line+".X", Integer.valueOf(x1));
			      Main.plugin.getConfig().set("Spawn."+nome+".Jogador"+line+".Y", Integer.valueOf(y1));
			      Main.plugin.getConfig().set("Spawn."+nome+".Jogador"+line+".Z", Integer.valueOf(z1));
			      Main.plugin.saveConfig();
			      e.remove();
			}
		}
    	  if (!Main.plugin.getConfig().contains("Jogadores.IniciarEm20s")) {
    	Main.plugin.getConfig().set("Jogadores.IniciarEm20s", Integer.valueOf(10));
    	  }
    	Main.plugin.getConfig().set("Jogadores.Nessarios", Integer.valueOf(necessario));
    	Main.plugin.getConfig().set("Jogadores.Maximo", Integer.valueOf(Bukkit.getServer().getMaxPlayers()));
        Main.plugin.getConfig().set("MapaDeJogo", "world");
        Main.plugin.getConfig().set(""+nome+".Nome", ""+nome+"");
        Main.plugin.getConfig().set(""+nome+".Modo", "Sem Modo");
        Main.plugin.getConfig().set(""+nome+".Tempo", "Dia");
        Main.plugin.getConfig().set(""+nome+".Agua", "false");
        Main.plugin.getConfig().set(""+nome+".Votos", Integer.valueOf(0));
        Main.plugin.saveConfig();
    	Bukkit.getServer().getLogger().log(Level.CONFIG, "§aConfiguraçoes modificadas e salvas !");
		
	 }
	 public void CarregarDeletar(String nome)
	 {
		 deletarArquivo(new File(nome));
		Bukkit.getServer().createWorld(new WorldCreator(nome));
	 }
	
	  public static void deletarArquivo(File arquivo)
	  {
	    if (arquivo.isDirectory())
	    {
	      String[] string = arquivo.list();
	      for (int i = 0; i < string.length; i++) {
	        deletarArquivo(new File(arquivo, string[i]));
	      }
	    }
	    arquivo.delete();
	  }
	
	
	public void SpawnEntity(EntityType e, String nome, Location loc,Time team)
	{
		NPCRegistry re = CitizensAPI.getNPCRegistry();
		NPC entity = re.createNPC(e, nome);
		entity.spawn(loc);
		TeamData data = new TeamData(team, loc);
		ovelhas.put(entity.getEntity(), data);
		entity.getEntity().setCustomName("§fTime " + team.nome + "§f, " + data.Jogadores() + " Jogadores");
		((Sheep)entity.getEntity()).setColor(team.cor);
		entity.getEntity().setCustomNameVisible(true);
		entity.setProtected(true);
	}
	

	
	
}
