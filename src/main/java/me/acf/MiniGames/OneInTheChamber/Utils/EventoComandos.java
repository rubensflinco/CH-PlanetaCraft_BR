package me.acf.MiniGames.OneInTheChamber.Utils;

import me.hub.Main;
import me.hub.MiniPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

	public class EventoComandos extends MiniPlugin {
	
	public EventoComandos(JavaPlugin plugin) {
		super("EventoComandos", plugin);
		
	}

	@EventHandler
	  public void onCommand(PlayerCommandPreprocessEvent e)
	  {
	    Player p = e.getPlayer();
	    
	    if ((e.getMessage().equalsIgnoreCase("/loja"))) {
		      e.setCancelled(true);
		      p.sendMessage("§cEm breve");
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/unload"))) {
		      e.setCancelled(true);
		      Location loc = Bukkit.getServer().getWorld("world").getSpawnLocation();
	        	p.teleport(loc);
	        	Bukkit.getServer().unloadWorld("Mapa2", true);
	        	Bukkit.getWorlds().remove(Bukkit.getWorld("Mapa2"));
	        	p.sendMessage("foi");
	        	
		    }

	    if ((e.getMessage().equalsIgnoreCase("/mg"))) {
	      e.setCancelled(true);
	      p.sendMessage("§c============Comandos Gerais==================");
	      p.sendMessage("§d/mg iniciar (Inciar partida) ");
	      p.sendMessage("§d/mg tp [Nome do mundo] (Teleportar entre mundos)");
	      p.sendMessage("§d/mg setlobby (setar spawn do Lobby de espera)");
	      p.sendMessage("§d/mg setmapa[1,2] nome (setar nome do mapa)");
	      p.sendMessage("§d/mg setmapa[1,2] spect (setar spawn do Lobby de espera dos spect)");
	      p.sendMessage("§d/mg setmapa[1,2] sp[1 a 20] (setar spawn do mapa [1,2])");
	      p.sendMessage("§d/mg setmapa[1,2] modo [facil,normal,dificil] (setar na config a dificultade do mapa)");
	      p.sendMessage("§d/mg setmapa[1,2] tempo [dia,tarde,noite] (setar na config o tempo do mapa)");
	      p.sendMessage("§aPlugin criado por Jotinha_BR e Adriancf ");
	      p.sendMessage("§c=============================================");
	    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg iniciar")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);
		      p.sendMessage("§cEm Breve");
		    }

	    
	    if ((e.getMessage().equalsIgnoreCase("/mg tp lobby")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);
		      if (Bukkit.getWorlds().contains(Bukkit.getWorld("world"))) {
		       Location l = new Location(Bukkit.getServer().getWorld("world"), 0, 60, 0);
		       p.teleport(l);
		      }
		      else
		      {
		    	  p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Mundo não exite !");
		      }
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg tp mapa1"))) {
	      e.setCancelled(true);
	      if (Bukkit.getWorlds().contains(Bukkit.getWorld(Main.plugin.getConfig().getString("Mapa1.Nome"))) && (p.hasPermission("planeta.op"))) {
	    	  p.teleport(Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Mapa1.Nome")).getSpawnLocation());
	      }
	      else
	      {
	    	  p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Mundo não exite !");
	      }
	    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg tp mapa2"))) {
		      e.setCancelled(true);
		      if (Bukkit.getWorlds().contains(Bukkit.getWorld(Main.plugin.getConfig().getString("Mapa2.Nome"))) && (p.hasPermission("planeta.op"))) {
			       p.teleport(Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Mapa2.Nome")).getSpawnLocation());
		      }
		      else
		      {
		    	  p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Mundo não exite !");
		      }
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 tempo dia")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Tempo do §fmapa 1§7 setado como de §fDia");

		      Main.plugin.getConfig().set("Mapa1.Tempo", "Dia");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 tempo tarde")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Tempo do §fmapa 1§7 setado como de §fTarde");

		      Main.plugin.getConfig().set("Mapa1.Tempo", "Tarde");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 tempo noite")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Tempo do §fmapa 1§7 setado como de §fNoite");

		      Main.plugin.getConfig().set("Mapa1.Tempo", "Noite");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 tempo dia")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Tempo do §fmapa 2§7 setado como de §fDia");

		      Main.plugin.getConfig().set("Mapa2.Tempo", "Dia");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 tempo tarde")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Tempo do §fmapa 2§7 setado como de §fTarde");

		      Main.plugin.getConfig().set("Mapa2.Tempo", "Tarde");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 tempo noite")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Tempo do §fmapa 2§7 setado como de §fNoite");

		      Main.plugin.getConfig().set("Mapa2.Tempo", "Noite");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 modo dificil")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Agora o §fmapa 1§7 esta na dificultade §fDificil");

		      Main.plugin.getConfig().set("Mapa1.Modo", "Dificil");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 modo normal")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Agora o §fmapa 1§7 esta na dificultade §fNormal");

		      Main.plugin.getConfig().set("Mapa1.Modo", "Normal");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 modo facil")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Agora o §fmapa 1§7 esta na dificultade §fFacil");

		      Main.plugin.getConfig().set("Mapa1.Modo", "Facil");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 modo dificil")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Agora o §fmapa 2§7 esta na dificultade §fDificil");

		      Main.plugin.getConfig().set("Mapa2.Modo", "Dificil");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 modo normal")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Agora o §fmapa 2§7 esta na dificultade §fNormal");

		      Main.plugin.getConfig().set("Mapa2.Modo", "Normal");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 modo facil")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Agora o §fmapa 2§7 esta na dificultade §fFacil");

		      Main.plugin.getConfig().set("Mapa2.Modo", "Facil");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 agua true")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Aguá esta ativa para dar dano agora no §fmapa 1");

		      Main.plugin.getConfig().set("Mapa1.Agua", "true");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 agua false")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Aguá esta desativada para dar dano agora no §fmapa 1");

		      Main.plugin.getConfig().set("Mapa1.Agua", "false");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 agua true")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Aguá esta ativa para dar dano agora no §fmapa 2");

		      Main.plugin.getConfig().set("Mapa2.Agua", "true");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 agua false")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Aguá esta desativada para dar dano agora no §fmapa 2");

		      Main.plugin.getConfig().set("Mapa2.Agua", "false");
		      Main.plugin.saveConfig();
		      
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setlobby")) && (p.hasPermission("planeta.op"))) {
	      e.setCancelled(true);

	      int x1 = (int)p.getLocation().getX();
	      int y1 = (int)p.getLocation().getY();
	      int z1 = (int)p.getLocation().getZ();
	      
	      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Lobby de Espera setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

	      Main.plugin.getConfig().set("LobbyEspera.X", Integer.valueOf(x1));
	      Main.plugin.getConfig().set("LobbyEspera.Y", Integer.valueOf(y1));
	      Main.plugin.getConfig().set("LobbyEspera.Z", Integer.valueOf(z1));
	      Main.plugin.saveConfig();
	    }
	    
	    //Setar Spawn dos espequitadores do mapa 1 VVV

	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 spect")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Lobby Espectador setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Espectador.Mapa1.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Espectador.Mapa1.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Espectador.Mapa1.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    //Setar Spawn dos espequitadores do mapa 2 VVV

	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 spect")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Lobby Espectador setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Espectador.Mapa2.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Espectador.Mapa2.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Espectador.Mapa2.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    

	    
	    //Setar Spawn dos jogadores do mapa 1 VVV
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp1")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 1 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador1.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador1.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador1.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp2")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 2 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador2.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador2.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador2.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp3")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 3 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador3.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador3.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador3.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp4")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 4 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador4.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador4.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador4.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp5")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 5 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador5.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador5.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador5.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp6")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 6 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador6.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador6.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador6.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp7")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 7 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador7.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador7.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador7.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp8")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 8 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador8.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador8.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador8.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp9")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 9 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador9.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador9.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador9.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp10")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 10 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador10.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador10.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador10.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp11")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 11 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador11.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador11.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador11.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp12")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 12 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador12.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador12.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador12.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp13")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 13 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador13.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador13.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador13.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp14")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 14 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador14.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador14.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador14.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp15")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 15 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador15.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador15.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador15.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp16")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 16 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador16.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador16.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador16.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp17")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 17 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador17.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador17.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador17.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp18")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 18 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador18.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador18.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador18.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp19")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 19 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador19.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador19.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador19.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa1 sp20")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 20 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador20.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador20.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa1.Jogador20.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }

	    
	    //Setar Spawn dos jogadores do mapa 2 VVV
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp1")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 1 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador1.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador1.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador1.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp2")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 2 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador2.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador2.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador2.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp3")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 3 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador3.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador3.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador3.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp4")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 4 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador4.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador4.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador4.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp5")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 5 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador5.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador5.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador5.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp6")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 6 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador6.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador6.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador6.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp7")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 7 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador7.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador7.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador7.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp8")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 8 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador8.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador8.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador8.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp9")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 9 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador9.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador9.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador9.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp10")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 10 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador10.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador10.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador10.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp11")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 11 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador11.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador11.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador11.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp12")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 12 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador12.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador12.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador12.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp13")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 13 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador13.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador13.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador13.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp14")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 14 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador14.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador14.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador14.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp15")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 15 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador15.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador15.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador15.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp16")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 16 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador16.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador16.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador16.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp17")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 17 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador17.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador17.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador17.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp18")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 18 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador18.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador18.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador18.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp19")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 19 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador19.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador19.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador19.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	    
	    if ((e.getMessage().equalsIgnoreCase("/mg setmapa2 sp20")) && (p.hasPermission("planeta.op"))) {
		      e.setCancelled(true);

		      int x1 = (int)p.getLocation().getX();
		      int y1 = (int)p.getLocation().getY();
		      int z1 = (int)p.getLocation().getZ();
		      
		      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Spawn do jogador 20 setado com sucesso em X : " + x1 + " Y : " + y1 + " Z : " + z1 + "");

		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador20.X", Integer.valueOf(x1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador20.Y", Integer.valueOf(y1));
		      Main.plugin.getConfig().set("Spawn.Mapa2.Jogador20.Z", Integer.valueOf(z1));
		      Main.plugin.saveConfig();
		    }
	  }
	  
}
