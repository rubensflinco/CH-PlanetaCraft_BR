package me.acf.MiniGames.SpleggTnT.Utils;

import java.awt.List;
import java.io.File;

import me.acf.MiniGames.SpleggTnT.SpleggTnT;
import me.hub.Main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TeleportPlayer {

	public static String Regiao1 = "Ninguem";
	public static String Regiao2 = "Ninguem";
	public static String Regiao3 = "Ninguem";
	public static String Regiao4 = "Ninguem";
	public static String Regiao5 = "Ninguem";
	public static String Regiao6 = "Ninguem";
	public static String Regiao7 = "Ninguem";
	public static String Regiao8 = "Ninguem";
	public static String Regiao9 = "Ninguem";
	public static String Regiao10 = "Ninguem";
	public static String Regiao11 = "Ninguem";
	public static String Regiao12 = "Ninguem";
	public static String Regiao13 = "Ninguem";
	public static String Regiao14 = "Ninguem";
	public static String Regiao15 = "Ninguem";
	public static String Regiao16 = "Ninguem";
	public static String Regiao17 = "Ninguem";
	public static String Regiao18 = "Ninguem";
	public static String Regiao19 = "Ninguem";
	public static String Regiao20 = "Ninguem";
	

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
	           
    	   
    	   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
    	   	      public void run() {
    	       	   jogador.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 200));
    	    	   jogador.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 200));
    	    	   SpleggTnT.EscolherMapa.remove(jogador);
    	   	      } 
    	   	    }
    	   	    , 1L);
    	   	  

	   }
	   
		public static void JogadorTeleporteRegiao(Player jogador)
		{
		   if (Regiao1.equals("Ninguem"))
		   {
			   Regiao1 = jogador.getName();
	           Teleportar(jogador, 1);
			   return;
		   }
		   if (Regiao2.equals("Ninguem"))
		   {
			   Regiao2 = jogador.getName();
	           Teleportar(jogador, 2);
			   return;
		   }
		   if (Regiao3.equals("Ninguem"))
		   {
			   Regiao3 = jogador.getName();
	           Teleportar(jogador, 3);
			   return;
		   }
		   if (Regiao4.equals("Ninguem"))
		   {
			   Regiao4 = jogador.getName();
	           Teleportar(jogador, 4);
			   return;
		   }
		   if (Regiao5.equals("Ninguem"))
		   {
			   Regiao5 = jogador.getName();
	           Teleportar(jogador, 5);
			   return;
		   }
		   if (Regiao6.equals("Ninguem"))
		   {
			   Regiao6 = jogador.getName();
	           Teleportar(jogador, 6);
			   return;
		   }
		   if (Regiao7.equals("Ninguem"))
		   {
			   Regiao7 = jogador.getName();
	           Teleportar(jogador, 7);
			   return;
		   }
		   if (Regiao8.equals("Ninguem"))
		   {
			   Regiao8 = jogador.getName();
	           Teleportar(jogador, 8);
			   return;
		   }
		   if (Regiao9.equals("Ninguem"))
		   {
			   Regiao9 = jogador.getName();
	           Teleportar(jogador, 9);
			   return;
		   }
		   if (Regiao10.equals("Ninguem"))
		   {
			   Regiao10 = jogador.getName();
	           Teleportar(jogador, 10);
			   return;
		   }
		   if (Regiao11.equals("Ninguem"))
		   {
			   Regiao11 = jogador.getName();
	           Teleportar(jogador, 11);
			   return;
		   }
		   if (Regiao12.equals("Ninguem"))
		   {
			   Regiao12 = jogador.getName();
	           Teleportar(jogador, 12);
			   return;
		   }
		   if (Regiao13.equals("Ninguem"))
		   {
			   Regiao13 = jogador.getName();
	           Teleportar(jogador, 13);
			   return;
		   }
		   if (Regiao14.equals("Ninguem"))
		   {
			   Regiao14 = jogador.getName();
	           Teleportar(jogador, 14);
			   return;
		   }
		   if (Regiao15.equals("Ninguem"))
		   {
			   Regiao15 = jogador.getName();
	           Teleportar(jogador, 15);
			   return;
		   }
		   if (Regiao16.equals("Ninguem"))
		   {
			   Regiao16 = jogador.getName();
	           Teleportar(jogador, 16);
			   return;
		   }
		   if (Regiao17.equals("Ninguem"))
		   {
			   Regiao17 = jogador.getName();
	           Teleportar(jogador, 17);
			   return;
		   }
		   if (Regiao18.equals("Ninguem"))
		   {
			   Regiao18 = jogador.getName();
	           Teleportar(jogador, 18);
			   return;
		   }
		   if (Regiao19.equals("Ninguem"))
		   {
			   Regiao19 = jogador.getName();
	           Teleportar(jogador, 19);
			   return;
		   }
		   if (Regiao20.equals("Ninguem"))
		   {
			   Regiao20 = jogador.getName();
	           Teleportar(jogador, 20);
			   return;
		   }
		   jogador.sendMessage("§3§l"+ Bukkit.getServerName() +"➤ §6Você foi adicionado no Espectador devido a contidade de jogadores da sala...");
			 jogador.setGameMode(GameMode.SPECTATOR);
			 jogador.setMaxHealth(20);
			 jogador.setHealth(20);
			 jogador.playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F); 
		   
		   
		   
		   
		   
		   
		}
	
	public static void VoltarNaIlha(Player jogador)
	{
	   if (Regiao1.equals(jogador.getName()))
	   {
		   Regiao1 = jogador.getName();
           Teleportar(jogador, 1);
		   return;
	   }
	   if (Regiao2.equals(jogador.getName()))
	   {
		   Regiao2 = jogador.getName();
           Teleportar(jogador, 2);
		   return;
	   }
	   if (Regiao3.equals(jogador.getName()))
	   {
		   Regiao3 = jogador.getName();
           Teleportar(jogador, 3);
		   return;
	   }
	   if (Regiao4.equals(jogador.getName()))
	   {
		   Regiao4 = jogador.getName();
           Teleportar(jogador, 4);
		   return;
	   }
	   if (Regiao5.equals(jogador.getName()))
	   {
		   Regiao5 = jogador.getName();
           Teleportar(jogador, 5);
		   return;
	   }
	   if (Regiao6.equals(jogador.getName()))
	   {
		   Regiao6 = jogador.getName();
           Teleportar(jogador, 6);
		   return;
	   }
	   if (Regiao7.equals(jogador.getName()))
	   {
		   Regiao7 = jogador.getName();
           Teleportar(jogador, 7);
		   return;
	   }
	   if (Regiao8.equals(jogador.getName()))
	   {
		   Regiao8 = jogador.getName();
           Teleportar(jogador, 8);
		   return;
	   }
	   if (Regiao9.equals(jogador.getName()))
	   {
		   Regiao9 = jogador.getName();
           Teleportar(jogador, 9);
		   return;
	   }
	   if (Regiao10.equals(jogador.getName()))
	   {
		   Regiao10 = jogador.getName();
           Teleportar(jogador, 10);
		   return;
	   }
	   if (Regiao11.equals(jogador.getName()))
	   {
		   Regiao11 = jogador.getName();
           Teleportar(jogador, 11);
		   return;
	   }
	   if (Regiao12.equals(jogador.getName()))
	   {
		   Regiao12 = jogador.getName();
           Teleportar(jogador, 12);
		   return;
	   }
	   if (Regiao13.equals(jogador.getName()))
	   {
		   Regiao13 = jogador.getName();
           Teleportar(jogador, 13);
		   return;
	   }
	   if (Regiao14.equals(jogador.getName()))
	   {
		   Regiao14 = jogador.getName();
           Teleportar(jogador, 14);
		   return;
	   }
	   if (Regiao15.equals(jogador.getName()))
	   {
		   Regiao15 = jogador.getName();
           Teleportar(jogador, 15);
		   return;
	   }
	   if (Regiao16.equals(jogador.getName()))
	   {
		   Regiao16 = jogador.getName();
           Teleportar(jogador, 16);
		   return;
	   }
	   if (Regiao17.equals(jogador.getName()))
	   {
		   Regiao17 = jogador.getName();
           Teleportar(jogador, 17);
		   return;
	   }
	   if (Regiao18.equals(jogador.getName()))
	   {
		   Regiao18 = jogador.getName();
           Teleportar(jogador, 18);
		   return;
	   }
	   if (Regiao19.equals(jogador.getName()))
	   {
		   Regiao19 = jogador.getName();
           Teleportar(jogador, 19);
		   return;
	   }
	   if (Regiao20.equals(jogador.getName()))
	   {
		   Regiao20 = jogador.getName();
           Teleportar(jogador, 20);
		   return;
	   }
	   jogador.sendMessage("§3§l"+ Bukkit.getServerName() +"➤ §6Você foi adicionado no Espectador devido a contidade de jogadores da sala...");
		 jogador.setGameMode(GameMode.SPECTATOR);
		 jogador.setMaxHealth(20);
		 jogador.setHealth(20);
		 jogador.playSound(jogador.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F); 
	   
	   
	   
	   
	   
	   
	}
}