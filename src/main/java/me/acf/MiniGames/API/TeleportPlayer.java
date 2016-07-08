package me.acf.MiniGames.API;

import java.io.File;
import java.util.HashMap;
import java.util.Random;
import me.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class TeleportPlayer {

	public static HashMap<Player, String> TP = new HashMap();
	

	   public static void Teleportar(final Player jogador, final int numero) {
		      Location loc = jogador.getLocation();
		      World wrld = loc.getWorld();
		      java.util.List<LivingEntity> mobs = wrld.getLivingEntities();
		      
	           for (LivingEntity ent : mobs)
	           {
	             if (!(ent instanceof Player) && !(ent instanceof ArmorStand)) {
	               ent.remove();
	             }
	           }
		      
				File backupDir = new File("mapas");
				for (File source : backupDir.listFiles())
				 if (source.isDirectory()) {
					 if (source.getName().contains("world")){
					 }else{
				           if (Main.plugin.getConfig().get("Spawn."+Main.plugin.getConfig().getString("MapaDeJogo")+".Jogador" + numero + ".X") == null){
				        	   Location l = new Location(Bukkit.getServer().getWorld(Main.plugin.getConfig().getString(""+Main.plugin.getConfig().getString("MapaDeJogo")+".Nome")), Main.plugin.getConfig().getInt("Spawn."+Main.plugin.getConfig().getString("MapaDeJogo")+".Jogador1.X"), Main.plugin.getConfig().getInt("Spawn."+Main.plugin.getConfig().getString("MapaDeJogo")+".Jogador1.Y"), Main.plugin.getConfig().getInt("Spawn."+Main.plugin.getConfig().getString("MapaDeJogo")+".Jogador1.Z"));
				        	   jogador.teleport(l);
				           }else{
			        	   Location l = new Location(Bukkit.getServer().getWorld(Main.plugin.getConfig().getString(""+Main.plugin.getConfig().getString("MapaDeJogo")+".Nome")), Main.plugin.getConfig().getInt("Spawn."+Main.plugin.getConfig().getString("MapaDeJogo")+".Jogador" + numero + ".X"), Main.plugin.getConfig().getInt("Spawn."+Main.plugin.getConfig().getString("MapaDeJogo")+".Jogador" + numero + ".Y"), Main.plugin.getConfig().getInt("Spawn."+Main.plugin.getConfig().getString("MapaDeJogo")+".Jogador" + numero + ".Z"));
			        	   jogador.teleport(l);
				           }}}
	   }
	   
		public static void JogadorTeleporteRegiao()
		{
		  int numero = 0;
		   for (Player player : Bukkit.getOnlinePlayers()) {
			 numero = numero+1;
			 TP.put(player, ""+numero);
			 Teleportar(player, numero);
		   }
		}
	
	public static void VoltarNaIlha(Player jogador)
	{
		int tp = Integer.parseInt(TP.get(jogador));
        Teleportar(jogador, tp);
	}
	
	public static void JogadorTeleporteRandoOITC(Player p)
	{
		Random r = new Random();
        int RandoTP = 1 + r.nextInt(Bukkit.getMaxPlayers());
		  int numero = 0;
		   for (Player player : Bukkit.getOnlinePlayers()) {
			 numero = numero+1;
		        if (RandoTP == numero)
		        {
		         Teleportar(p, numero);
		        }
		   }
	}
	
}