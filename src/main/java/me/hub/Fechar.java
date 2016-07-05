package me.hub;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import me.acf.servidor.Servidor;
import me.site.account.AccountWeb;

public class Fechar {

	 public static void stop()
	 {		
		 Servidor.OFFServidor();
			for (OfflinePlayer list : Bukkit.getServer().getOperators()){
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "deop "+list.getName());
			}
		 if (Main.plugin.getConfig().getString("Carregar").equals("Lobby")) {
				deletarArquivo(new File("logs"));
				deletarArquivo(new File("crash-reports"));
				deletarArquivo(new File("CHLog.log"));
				deletarArquivo(new File("plugins/CHub/config.yml"));
				deletarArquivo(new File("plugins/CHub/comandos.yml"));
				AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
			 }
		 
			 if (Main.plugin.getConfig().getString("Carregar").equals("KitPvP")) {
					deletarArquivo(new File("logs"));
					deletarArquivo(new File("crash-reports"));
					deletarArquivo(new File("CHLog.log"));
					deletarArquivo(new File("plugins/CHub/config.yml"));
					deletarArquivo(new File("plugins/CHub/comandos.yml"));
					AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
			 }
			 
			 if (Main.plugin.getConfig().getString("Carregar").equals("FullPvP")) {
					deletarArquivo(new File("logs"));
					deletarArquivo(new File("crash-reports"));
					deletarArquivo(new File("CHLog.log"));
					deletarArquivo(new File("plugins/CHub/config.yml"));
					deletarArquivo(new File("plugins/CHub/comandos.yml"));
					AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
			 }
			 
			 if (Main.plugin.getConfig().getString("Carregar").equals("SkyBlock")) {
					deletarArquivo(new File("logs"));
					deletarArquivo(new File("crash-reports"));
					deletarArquivo(new File("CHLog.log"));
					deletarArquivo(new File("plugins/CHub/config.yml"));
					deletarArquivo(new File("plugins/CHub/comandos.yml"));
					AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
			 }
			 
			 if (Main.plugin.getConfig().getString("Carregar").equals("SkyWars")) {
					File backupDir = new File("mapas");
					for (File source : backupDir.listFiles())
					 if (source.isDirectory()) {
						 if (source.getName().contains("world")){
						 }else{
					   deletarArquivo(new File(""+source.getName()+""));
						 }
						}
					deletarArquivo(new File("logs"));
					deletarArquivo(new File("crash-reports"));
					deletarArquivo(new File("CHLog.log"));
					deletarArquivo(new File("plugins/CHub/config.yml"));
					deletarArquivo(new File("plugins/CHub/comandos.yml"));
					deletarArquivo(new File("plugins/CHub/UserData"));
					AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
				 }

			 if (Main.plugin.getConfig().getString("Carregar").equals("HungerGames")) {
					deletarArquivo(new File("world"));
					deletarArquivo(new File("logs"));
					deletarArquivo(new File("crash-reports"));
					deletarArquivo(new File("CHLog.log"));
					deletarArquivo(new File("plugins/CHub/config.yml"));
					deletarArquivo(new File("plugins/CHub/comandos.yml"));
					deletarArquivo(new File("plugins/CHub/UserData"));
					AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
				 }
			 
			 if (Main.plugin.getConfig().getString("Carregar").equals("OneInTheChamber")) {
					File backupDir = new File("mapas");
					for (File source : backupDir.listFiles())
					 if (source.isDirectory()) {
						 if (source.getName().contains("world")){
						 }else{
					   deletarArquivo(new File(""+source.getName()+""));
						 }
						}
					deletarArquivo(new File("logs"));
					deletarArquivo(new File("crash-reports"));
					deletarArquivo(new File("CHLog.log"));
					deletarArquivo(new File("plugins/CHub/config.yml"));
					deletarArquivo(new File("plugins/CHub/comandos.yml"));
					deletarArquivo(new File("plugins/CHub/UserData"));
					AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
				 }
			 
			 if (Main.plugin.getConfig().getString("Carregar").equals("SpleggTnT")) {
					File backupDir = new File("mapas");
					for (File source : backupDir.listFiles())
					 if (source.isDirectory()) {
						 if (source.getName().contains("world")){
						 }else{
					   deletarArquivo(new File(""+source.getName()+""));
						 }
						}
					deletarArquivo(new File("logs"));
					deletarArquivo(new File("crash-reports"));
					deletarArquivo(new File("CHLog.log"));
					deletarArquivo(new File("plugins/CHub/config.yml"));
					deletarArquivo(new File("plugins/CHub/comandos.yml"));
					deletarArquivo(new File("plugins/CHub/UserData"));
					AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
				 }
			 
			 if (Main.plugin.getConfig().getString("Carregar").equals("Registro")) {
					deletarArquivo(new File("logs"));
					deletarArquivo(new File("crash-reports"));
					deletarArquivo(new File("CHLog.log"));
					deletarArquivo(new File("plugins/CHub/config.yml"));
					deletarArquivo(new File("plugins/CHub/comandos.yml"));
					deletarArquivo(new File("plugins/CHub/UserData"));
					AccountWeb.Conectar(Main.site + "/API/Salas/reiniciar.php?modo=UMA&servername="+Bukkit.getServerName());
			 }
		 
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

}
