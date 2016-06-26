package me.acf.MiniGames.HungerGames;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.HungerGames.kits.Kit;
import me.acf.MiniGames.Style.Utils.MGSpectator;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilSchematic.Modo;
import me.site.account.AccountWeb;

public class Entrar extends MiniPlugin {
	

	
	public Entrar(JavaPlugin plugin) {
	super("Entrar", plugin);
		// TODO Auto-generated constructor stub
	}
	
	public static int primeiro = 0;

	@EventHandler
	public void Entrou(PlayerJoinEvent event)
	{

		Player jogador = event.getPlayer();
		
		Conta.Loader(jogador);
		System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/HG.php?modo=ADD-conta&nick=" + jogador.getName()));
		
		jogador.getPlayer().getInventory().setHeldItemSlot(0);
		
		Kit.AddKit(jogador, "§9default ");
		
		if (primeiro == 0){
		primeiro = primeiro + 1;
		
	         System.out.print("Iniciando GG");
	       HungerGames.arc.world.setSpawnLocation(0, 200, 0);
	       HungerGames.locantiga.put(jogador.getPlayer(), HungerGames.arc.world.getSpawnLocation());

	  				try {
	  				HungerGames.schem = HungerGames.arc.SchematicLoaderPaste("spawn.schematic", HungerGames.arc.world.getSpawnLocation(), Modo.SetSpawn);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	  	         
	  	     Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "worldborder center "+HungerGames.arc.world.getSpawnLocation().getBlockX()+" "+HungerGames.arc.world.getSpawnLocation().getBlockZ()+"");
	  	     Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "worldborder set 2");
	  	     Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "worldborder set 150.9 30");
	  	     
		}


       if (Arcade.noInicio())
       {

    	   jogador.getInventory().clear();

    	   UtilInv.AddItem(event.getPlayer().getInventory(), false, Material.CHEST, 1,(byte)0, "§aKit", 0);
    	   
    	   event.getPlayer().teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
       }
       

	}
	

}
