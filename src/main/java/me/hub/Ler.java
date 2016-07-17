package me.hub;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import me.acf.MiniGames.API.CopyDirectory;
import me.acf.Robo.RoboMananger;
import me.acf.chat.Chat;
import me.acf.lobby.chair.Chair;
import me.acf.lobby.extend.Entrar;
import me.acf.lobby.extend.Lobby;
import me.acf.lobby.extend.Sair;
import me.acf.lobby.gadgets.Gadgets;
import me.acf.lobby.perfil.Perfil;
import me.acf.lobby.servidores.Bussola;
import me.acf.protocolo.chat.ChatManager;
import me.acf.punish.PunishMananger;
import me.acf.servidor.Servidor;
import me.antiHack.AntiHack;
import me.donate.DonateMananger;
import me.hub.API.BlockRestore;
import me.hub.API.Anuncio.Anuncios;
import me.hub.API.Util.BarAPI;
import me.hub.Admin.Admin;
import me.hub.Bungee.Bungee;
import me.hub.EnchantTable.Enchant;
import me.hub.comandos.CriadorComandos;
import me.hub.comandos.geral.AdminEvents;
import me.hub.publicidade.Publicidade;
import me.hub.recharge.Recharge;
import me.security.LoginManager;
import me.site.account.Account;

public class Ler {

	 private static BlockRestore _blockRestore;
	 
	 static List<String> versions = new ArrayList<String>();
	 
	 public static void Ler()
	 {		 
		 if (Bukkit.getServerName().contains("Robo")){
		 Main.plugin.getConfig().set("Carregar", "Robo");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("Lobby")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 versions.add("MINECRAFT_1_7_5");
			 versions.add("MINECRAFT_1_7_10");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "Lobby");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("Logando")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 versions.add("MINECRAFT_1_7_5");
			 versions.add("MINECRAFT_1_7_10");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "Registro");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("Construcoes")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 versions.add("MINECRAFT_1_7_5");
			 versions.add("MINECRAFT_1_7_10");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "Construcoes");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("SB")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 versions.add("MINECRAFT_1_7_5");
			 versions.add("MINECRAFT_1_7_10");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "SkyBlock");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("FP")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 versions.add("MINECRAFT_1_7_5");
			 versions.add("MINECRAFT_1_7_10");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "FullPvP");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("KP")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 versions.add("MINECRAFT_1_7_5");
			 versions.add("MINECRAFT_1_7_10");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "KitPvP");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("SW")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "SkyWars");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("HG")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "HungerGames");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("OITC")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "OneInTheChamber");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("STNT")){
			 versions = Main.plugin.getConfig().getStringList("versions");
			 versions.add("MINECRAFT_1_10");
			 versions.add("MINECRAFT_1_8");
			 versions.add("MINECRAFT_1_9");
			 versions.add("MINECRAFT_1_9_1");
			 versions.add("MINECRAFT_1_9_2");
			 versions.add("MINECRAFT_1_9_4");
			 Main.plugin.getConfig().addDefault("versions", versions);
		 Main.plugin.getConfig().set("Carregar", "SpleggTnT");
		 Main.plugin.saveConfig();
		 }
		 ChatManager chat = new ChatManager();
		 if (Main.plugin.getConfig().getString("Carregar").equals("Lobby")) {
		    BlockRestore blockRestore = new BlockRestore(Main.plugin);
			new CriadorComandos().Ler_Comandos(Main.plugin);
			  new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.lobby.comandos");
			Hub(blockRestore);
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("KitPvP")) {
			 BlockRestore blockRestore = new BlockRestore(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.KitPvP.comandos");
		    KitPvP(blockRestore);   
		    DonateMananger.USAR = false;
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("FullPvP")) {
			 BlockRestore blockRestore = new BlockRestore(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.FullPvP.comandos");
		    LerFullPvP(blockRestore);   
		    DonateMananger.USAR = false;
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("SkyBlock")) {
			 BlockRestore blockRestore = new BlockRestore(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.SkyBlock.comandos");
		    LerSkyBlock(blockRestore);   
		    DonateMananger.USAR = false;
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("SkyWars")) {
			 BlockRestore blockRestore = new BlockRestore(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.MiniGames.API");
		    LerSkyWars(blockRestore);   
		    DonateMananger.USAR = false;
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("HungerGames")) {
			 BlockRestore blockRestore = new BlockRestore(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin);
		    LerHungerGames(blockRestore);   
		    DonateMananger.USAR = false;
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("OneInTheChamber")) {
			 BlockRestore blockRestore = new BlockRestore(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.MiniGames.API");
		    LerOneInTheChamber(blockRestore);   
		    DonateMananger.USAR = false;
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("SpleggTnT")) {
			 BlockRestore blockRestore = new BlockRestore(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin);
		    new CriadorComandos().Ler_Comandos(Main.plugin, "me.acf.MiniGames.API");
		    LerSpleggTnT(blockRestore);   
		    DonateMananger.USAR = false;
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("Registro")) {
			 LoginManager manager = new LoginManager(Main.plugin);
			 Bungee bungee = new Bungee(Main.plugin);
			 me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
			 new CriadorComandos().Ler_Comandos(Main.plugin, "me.security.registrar.comandos");
		     AdminEvents AdminEvents = new AdminEvents(Main.plugin);
			 Account account = new Account(Main.plugin);
		     Servidor server = new Servidor();
		     
		        PunishMananger punish = new PunishMananger(Main.plugin);
		    	DonateMananger donate = new DonateMananger(Main.plugin);
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("Robo")) {
			 Bungee bungee = new Bungee(Main.plugin);

		     RoboMananger RoboMananger = new RoboMananger(Main.plugin);
			 
			 Account account = new Account(Main.plugin);
		     Servidor server = new Servidor();
		 }
	 }
	 
	 private static void LerSpleggTnT(BlockRestore blockRestore)
	 {
			 _blockRestore = blockRestore;
				System.out.print("Plugins Carregados");
		        Account account = new Account(Main.plugin);
		        Chat chat = new Chat(Main.plugin);
		        me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
		        AdminEvents AdminEvents = new AdminEvents(Main.plugin);

		        PunishMananger punish = new PunishMananger(Main.plugin);
		    	DonateMananger donate = new DonateMananger(Main.plugin);
		    	me.acf.MiniGames.SpleggTnT.SpleggTnT SpleggTnT = new me.acf.MiniGames.SpleggTnT.SpleggTnT(Main.plugin);
		    	
		    	CopyDirectory CopyDirectory = new CopyDirectory();
		    	
		    	CopyDirectory.importWorlds();
		    	
		    	me.acf.MiniGames.SpleggTnT.PVP PVP = new me.acf.MiniGames.SpleggTnT.PVP(Main.plugin);
		    	me.acf.MiniGames.API.Bussola Bussola = new me.acf.MiniGames.API.Bussola(Main.plugin);
		    
		    	me.acf.MiniGames.SpleggTnT.Utils.EventoComandos EventoComandos = new me.acf.MiniGames.SpleggTnT.Utils.EventoComandos(Main.plugin);
		    	me.acf.MiniGames.SpleggTnT.Utils.EscolherMapa EscolherMapa = new me.acf.MiniGames.SpleggTnT.Utils.EscolherMapa(Main.plugin);
		    	
		        Enchant enchant = new Enchant(Main.plugin);
		        Recharge.Initialize(Main.plugin);
		        Bungee bungee = new Bungee(Main.plugin);
		        AntiHack.Initialize(Main.plugin, bungee);
		        Servidor server = new Servidor();
		        Admin admin = new Admin(Main.plugin);
		        BarAPI bar = new BarAPI();
		       
		         if (!Servidor.GetMain())
		        server.ModoGame("ON");
		         else
		        	 System.out.print("Servidor em manutencao");
		         Main.plugin.getServer().setWhitelist(false);
		        Anuncios anun = new Anuncios(Main.plugin);
	 }
	 
	 private static void LerOneInTheChamber(BlockRestore blockRestore)
	 {
			 _blockRestore = blockRestore;
				System.out.print("Plugins Carregados");
		        Account account = new Account(Main.plugin);
		        Chat chat = new Chat(Main.plugin);
		        me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
		    	AdminEvents AdminEvents = new AdminEvents(Main.plugin);

		        PunishMananger punish = new PunishMananger(Main.plugin);
		    	DonateMananger donate = new DonateMananger(Main.plugin);
		    	me.acf.MiniGames.OneInTheChamber.OneInTheChamber OneInTheChamber = new me.acf.MiniGames.OneInTheChamber.OneInTheChamber(Main.plugin);
		    	
		    	CopyDirectory CopyDirectory = new CopyDirectory();
		    	
		    	CopyDirectory.importWorlds();
		    
		   
		    	me.acf.MiniGames.OneInTheChamber.PVP PVP = new me.acf.MiniGames.OneInTheChamber.PVP(Main.plugin);
		    	me.acf.MiniGames.API.Bussola Bussola = new me.acf.MiniGames.API.Bussola(Main.plugin);
		    
		    	me.acf.MiniGames.OneInTheChamber.Utils.EventoComandos EventoComandos = new me.acf.MiniGames.OneInTheChamber.Utils.EventoComandos(Main.plugin);
		    	me.acf.MiniGames.OneInTheChamber.Utils.EscolherMapa EscolherMapa = new me.acf.MiniGames.OneInTheChamber.Utils.EscolherMapa(Main.plugin);
		    	
		        Enchant enchant = new Enchant(Main.plugin);
		        Recharge.Initialize(Main.plugin);
		        Bungee bungee = new Bungee(Main.plugin);
		        AntiHack.Initialize(Main.plugin, bungee);
		        Servidor server = new Servidor();
		        Admin admin = new Admin(Main.plugin);
		        BarAPI bar = new BarAPI();
		       
		         if (!Servidor.GetMain())
		        server.ModoGame("ON");
		         else
		        	 System.out.print("Servidor em manutencao");
		         Main.plugin.getServer().setWhitelist(false);
		        Anuncios anun = new Anuncios(Main.plugin);
	 }
	 
	 private static void LerHungerGames(BlockRestore blockRestore)
	 {
				 _blockRestore = blockRestore;
					System.out.print("Plugins Carregados");
			        Account account = new Account(Main.plugin);
			        Chat chat = new Chat(Main.plugin);
			        me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
			        AdminEvents AdminEvents = new AdminEvents(Main.plugin);

			        PunishMananger punish = new PunishMananger(Main.plugin);
			    	DonateMananger donate = new DonateMananger(Main.plugin);
			    	me.acf.MiniGames.HungerGames.HungerGames HungerGames = new me.acf.MiniGames.HungerGames.HungerGames(Main.plugin);

			    	me.acf.MiniGames.HungerGames.PVP PVP = new me.acf.MiniGames.HungerGames.PVP(Main.plugin);
			    	me.acf.MiniGames.API.Bussola Bussola = new me.acf.MiniGames.API.Bussola(Main.plugin);
			    	
			        Enchant enchant = new Enchant(Main.plugin);
			        Recharge.Initialize(Main.plugin);
			        Bungee bungee = new Bungee(Main.plugin);
			        AntiHack.Initialize(Main.plugin, bungee);
			        Servidor server = new Servidor();
			        Admin admin = new Admin(Main.plugin);
			        BarAPI bar = new BarAPI();
			       
			         if (!Servidor.GetMain())
			        server.ModoGame("ON");
			         else
			        	 System.out.print("Servidor em manutencao");
			         Main.plugin.getServer().setWhitelist(false);
			        Anuncios anun = new Anuncios(Main.plugin);
	 }
	 
	 private static void LerSkyWars(BlockRestore blockRestore)
	 {
			 _blockRestore = blockRestore;
				System.out.print("Plugins Carregados");
		        Account account = new Account(Main.plugin);
		        Chat chat = new Chat(Main.plugin);
		        me.security.SecurityManager security = new me.security.SecurityManager(Main.plugin);
		        AdminEvents AdminEvents = new AdminEvents(Main.plugin);

		        PunishMananger punish = new PunishMananger(Main.plugin);
		    	DonateMananger donate = new DonateMananger(Main.plugin);
		    	me.acf.MiniGames.SkyWars.SkyWars SkyWars = new me.acf.MiniGames.SkyWars.SkyWars(Main.plugin);
		    	
		    	CopyDirectory CopyDirectory = new CopyDirectory();
		    	
		    	CopyDirectory.importWorlds();
		    	
		    	me.acf.MiniGames.SkyWars.PVP PVP = new me.acf.MiniGames.SkyWars.PVP(Main.plugin);
		    	me.acf.MiniGames.API.Bussola Bussola = new me.acf.MiniGames.API.Bussola(Main.plugin);
		    
		    	me.acf.MiniGames.SkyWars.Utils.EventoComandos EventoComandos = new me.acf.MiniGames.SkyWars.Utils.EventoComandos(Main.plugin);
		    	me.acf.MiniGames.SkyWars.Utils.EscolherMapa EscolherMapa = new me.acf.MiniGames.SkyWars.Utils.EscolherMapa(Main.plugin);
		    	
		        Enchant enchant = new Enchant(Main.plugin);
		        Recharge.Initialize(Main.plugin);
		        Bungee bungee = new Bungee(Main.plugin);
		        AntiHack.Initialize(Main.plugin, bungee);
		        Servidor server = new Servidor();
		        Admin admin = new Admin(Main.plugin);
		        BarAPI bar = new BarAPI();
		       
		         if (!Servidor.GetMain())
		        server.ModoGame("ON");
		         else
		        	 System.out.print("Servidor em manutencao");
		         Main.plugin.getServer().setWhitelist(false);
		        Anuncios anun = new Anuncios(Main.plugin);
	 }
	 
	 private static void LerSkyBlock(BlockRestore blockRestore)
	 {
		    _blockRestore = blockRestore;
			System.out.print("Plugins Carregados");
	        Account account = new Account(Main.plugin);
	        Chat chat = new Chat(Main.plugin);
	        AdminEvents AdminEvents = new AdminEvents(Main.plugin);

	        PunishMananger punish = new PunishMananger(Main.plugin);
	    	DonateMananger donate = new DonateMananger(Main.plugin);
	    	me.acf.SkyBlock.SkyBlock manager = new me.acf.SkyBlock.SkyBlock(Main.plugin);
	    	
	        Enchant enchant = new Enchant(Main.plugin);
	        Recharge.Initialize(Main.plugin);
	        Bungee bungee = new Bungee(Main.plugin);
	        AntiHack.Initialize(Main.plugin, bungee);
	        Bussola bussola = new Bussola(Main.plugin);
	        Servidor server = new Servidor();
	        Admin admin = new Admin(Main.plugin);
	        BarAPI bar = new BarAPI();
	       
	         if (!Servidor.GetMain())
	        server.ModoGame("ON");
	         else
	        	 System.out.print("Servidor em manutencao");
	        Main.plugin.getServer().setWhitelist(false);
	        Anuncios anun = new Anuncios(Main.plugin);
	 }
	 private static void LerFullPvP(BlockRestore blockRestore)
	 {
		    _blockRestore = blockRestore;
			System.out.print("Plugins Carregados");
	        Account account = new Account(Main.plugin);
	        Chat chat = new Chat(Main.plugin);
	        AdminEvents AdminEvents = new AdminEvents(Main.plugin);

	        PunishMananger punish = new PunishMananger(Main.plugin);
	    	DonateMananger donate = new DonateMananger(Main.plugin);
	    	me.acf.FullPvP.FullPvPManager manager = new me.acf.FullPvP.FullPvPManager(Main.plugin);
	    	
	        Enchant enchant = new Enchant(Main.plugin);
	        Recharge.Initialize(Main.plugin);
	        Bungee bungee = new Bungee(Main.plugin);
	        AntiHack.Initialize(Main.plugin, bungee);
	        Bussola bussola = new Bussola(Main.plugin);
	        Servidor server = new Servidor();
	        Admin admin = new Admin(Main.plugin);
	        BarAPI bar = new BarAPI();
	       
	         if (!Servidor.GetMain())
	        server.ModoGame("ON");
	         else
	        	 System.out.print("Servidor em manutencao");
	        Main.plugin.getServer().setWhitelist(false);
	        Anuncios anun = new Anuncios(Main.plugin);
	 }
	 
	 private static void KitPvP(BlockRestore blockRestore)
	 {
		 _blockRestore = blockRestore;
			System.out.print("Plugins Carregados");
	        Account account = new Account(Main.plugin);
	        Chat chat = new Chat(Main.plugin);
	        AdminEvents AdminEvents = new AdminEvents(Main.plugin);

	        PunishMananger punish = new PunishMananger(Main.plugin);
	    	DonateMananger donate = new DonateMananger(Main.plugin);
	    	me.acf.KitPvP.KitPvPManager kitpvp = new me.acf.KitPvP.KitPvPManager(Main.plugin);
	    	
	        Enchant enchant = new Enchant(Main.plugin);
	        Recharge.Initialize(Main.plugin);
	        Bungee bungee = new Bungee(Main.plugin);
	        AntiHack.Initialize(Main.plugin, bungee);
	        Servidor server = new Servidor();
	        Admin admin = new Admin(Main.plugin);
	        BarAPI bar = new BarAPI();
	       
	         if (!Servidor.GetMain())
	        server.ModoGame("ON");
	         else
	        	 System.out.print("Servidor em manutencao");
	         Main.plugin.getServer().setWhitelist(false);
	        Anuncios anun = new Anuncios(Main.plugin);
	 }
	 
	@SuppressWarnings("unused")
	private static void Hub (BlockRestore blockRestore)
	{
	    _blockRestore = blockRestore;
		System.out.print("Plugins Carregados");
        Account account = new Account(Main.plugin);
		Bukkit.getPluginManager().registerEvents(new Entrar(), Main.plugin);
		Bukkit.getPluginManager().registerEvents(new Sair(), Main.plugin);
        Chat chat = new Chat(Main.plugin);
        Lobby lobby = new Lobby(Main.plugin);
        Gadgets gadgets = new Gadgets(Main.plugin);
        AdminEvents AdminEvents = new AdminEvents(Main.plugin);

        PunishMananger punish = new PunishMananger(Main.plugin);
    	DonateMananger donate = new DonateMananger(Main.plugin);
      	Chair chair = new Chair(Main.plugin);
        Enchant enchant = new Enchant(Main.plugin);
        Recharge.Initialize(Main.plugin);
        
        Bungee bungee = new Bungee(Main.plugin);
        AntiHack.Initialize(Main.plugin, bungee);
        Bussola bussola = new Bussola(Main.plugin);
        Servidor server = new Servidor();
        Admin admin = new Admin(Main.plugin);
        BarAPI bar = new BarAPI();
        Perfil perfil = new Perfil(Main.plugin);
        Publicidade pu = new Publicidade(Main.plugin);
        me.hub.API.pet.Pet pet = new me.hub.API.pet.Pet(Main.plugin);
         if (!Servidor.GetMain())
        server.ModoGame("ON");
         else
        	 System.out.print("Servidor em manutencao");
         Main.plugin.getServer().setWhitelist(false);
		    DonateMananger.USAR = true;
        Anuncios anun = new Anuncios(Main.plugin);
      }
	
	private static void LerBasico(BlockRestore blockRestore)
	{
	    _blockRestore = blockRestore;
		System.out.print("Plugins Carregados");
        Account account = new Account(Main.plugin);
        Chat chat = new Chat(Main.plugin);
        PunishMananger punish = new PunishMananger(Main.plugin);
    	DonateMananger donate = new DonateMananger(Main.plugin);
      	Chair chair = new Chair(Main.plugin);
        Enchant enchant = new Enchant(Main.plugin);
        Recharge.Initialize(Main.plugin);
        AdminEvents AdminEvents = new AdminEvents(Main.plugin);
        
        Bungee bungee = new Bungee(Main.plugin);
        AntiHack.Initialize(Main.plugin, bungee);
        Bussola bussola = new Bussola(Main.plugin);
        Servidor server = new Servidor();
        Admin admin = new Admin(Main.plugin);
        BarAPI bar = new BarAPI();
        
         if (!Servidor.GetMain())
        server.ModoGame("ON");
         else
        	 System.out.print("Servidor em manutencao");
         Main.plugin.getServer().setWhitelist(false);
        Anuncios anun = new Anuncios(Main.plugin);
      }
	public static BlockRestore GetBlockRestore()
	  {
	    return _blockRestore;
	  }
}
