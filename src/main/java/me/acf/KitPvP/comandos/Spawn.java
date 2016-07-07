package me.acf.KitPvP.comandos;

import me.acf.KitPvP.CombatLog;
import me.acf.KitPvP.Entrar;
import me.acf.KitPvP.PVP;
import me.acf.KitPvP.kitAPI.Kit;
import me.hub.Main;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.site.account.Account;
import me.site.account.rank.Rank;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

	public String[] atalhos = new String[] { "spawn" };
    public String desc = "Ir para o spawn do servidor";
    public HashMap<Player, Location> loc = new HashMap<>();
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		   if (ComandosAPI.VerConsole(sender).equals("sim"))
		   {
			   sender.sendMessage(Message.Console_Não);
  			   return true;
		   }
		  
		   final Player jogador = (Player) sender;
		   jogador.sendMessage("§aTeleportando você em 3 segundos.");
		   loc.put(jogador, new Location(Bukkit.getWorld("world"), jogador.getLocation().getX(), jogador.getLocation().getY(), jogador.getLocation().getZ()));
		   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			   
			   public void run() {
				   if (CombatLog.EstaEmCombat(jogador))
				   {
					   jogador.sendMessage("§cVocê esta em combat.");
					   return;
				   }
				   if (!loc.get(jogador).equals(new Location(Bukkit.getWorld("world"), jogador.getLocation().getX(), jogador.getLocation().getY(), jogador.getLocation().getZ())))
				   {
					   jogador.sendMessage("§cVocê se mecheu");
					   return;
				   }
			      jogador.teleport(Bukkit.getWorld("world").getSpawnLocation());
			      jogador.setHealth(20.0D);
				  jogador.getInventory().setArmorContents(null);
				  jogador.getInventory().clear();
				  jogador.setFireTicks(0);
				  jogador.closeInventory();
				  Kit.arena.remove(jogador);
				  Entrar.Give(jogador);
				  Kit.AddKit(jogador, "§9Nenhum ");
					 for (Player all : UtilServer.Jogadores())
					 {
						 all.hidePlayer(jogador);
					 }
			   }
			 }, 60L);
		   // 60 L == 3 sec, 20 ticks == 1 sec
			
		   
		
		return false;
	  }
	

	

}

