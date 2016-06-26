package me.acf.Robo;

import java.io.File;

import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.GameEvents;
import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.HungerGames.Scoreboard.Scoreboard;
import me.acf.MiniGames.tipos.Lobby;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.site.account.AccountWeb;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

	public class RoboMananger extends MiniPlugin {

		public RoboMananger(JavaPlugin plugin) {
			super("Robo", plugin);
		}
		
	    @EventHandler
	    public void AtualizarSalas(Atualizar event)  {
			 if (Main.plugin.getConfig().getString("Carregar").equals("Lobby")) {
			      if (event.getType() != ModosUpdate.MIN_32) {
				        return;
				      }
			      Bukkit.getServer().shutdown();
				 }
			 
				 if (Main.plugin.getConfig().getString("Carregar").equals("KitPvP")) {
				      if (event.getType() != ModosUpdate.HORAS_5) {
					        return;
					      }
				      Bukkit.getServer().shutdown();
				 }
				 
				 if (Main.plugin.getConfig().getString("Carregar").equals("FullPvP")) {
				      if (event.getType() != ModosUpdate.HORAS_5) {
					        return;
					      }
				      Bukkit.getServer().shutdown();
				 }
				 
				 if (Main.plugin.getConfig().getString("Carregar").equals("SkyBlock")) {
				      if (event.getType() != ModosUpdate.HORAS_5) {
					        return;
					      }
				      Bukkit.getServer().shutdown();
				 }
				 
				 if (Main.plugin.getConfig().getString("Carregar").equals("Registro")) {
				      if (event.getType() != ModosUpdate.MIN_32) {
					        return;
					      }
				      Bukkit.getServer().shutdown();
				 }
	    }
    
}
