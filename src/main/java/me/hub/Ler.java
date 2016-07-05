package me.hub;


import org.bukkit.Bukkit;

import me.acf.FullPvP.FullPvPManager;
import me.acf.KitPvP.KitPvPManager;
import me.acf.MiniGames.API.CopyDirectory;
import me.acf.MiniGames.HungerGames.HungerGames;
import me.acf.MiniGames.OneInTheChamber.OneInTheChamber;
import me.acf.MiniGames.SkyWars.SkyWars;
import me.acf.MiniGames.SpleggTnT.SpleggTnT;
import me.acf.Robo.RoboMananger;
import me.acf.SkyBlock.SkyBlock;
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
	 
	 public static void Ler()
	 {		 
		 if (Bukkit.getServerName().contains("Robo")){
		 Main.plugin.getConfig().set("Carregar", "Robo");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("Lobby")){
		 Main.plugin.getConfig().set("Carregar", "Lobby");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("Logando")){
		 Main.plugin.getConfig().set("Carregar", "Registro");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("Construcoes")){
		 Main.plugin.getConfig().set("Carregar", "Construcoes");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("SB")){
		 Main.plugin.getConfig().set("Carregar", "SkyBlock");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("FP")){
		 Main.plugin.getConfig().set("Carregar", "FullPvP");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("KP")){
		 Main.plugin.getConfig().set("Carregar", "KitPvP");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("SW")){
		 Main.plugin.getConfig().set("Carregar", "SkyWars");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("HG")){
		 Main.plugin.getConfig().set("Carregar", "HungerGames");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("OITC")){
		 Main.plugin.getConfig().set("Carregar", "OneInTheChamber");
		 Main.plugin.saveConfig();
		 }
		 if (Bukkit.getServerName().contains("STNT")){
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
		     PunishMananger punish = new PunishMananger(Main.plugin);
		     DonateMananger donate = new DonateMananger(Main.plugin);
		     Servidor server = new Servidor();
		 }
		 if (Main.plugin.getConfig().getString("Carregar").equals("Robo")) {
			 Bungee bungee = new Bungee(Main.plugin);

		     RoboMananger RoboMananger = new RoboMananger(Main.plugin);
			 
			 Account account = new Account(Main.plugin);
		     PunishMananger punish = new PunishMananger(Main.plugin);
		     DonateMananger donate = new DonateMananger(Main.plugin);
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
		    	SpleggTnT SpleggTnT = new SpleggTnT(Main.plugin);
		    	
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
		        BarAPI bar = new BarAPI(Main.plugin);
		       
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
		    	OneInTheChamber OneInTheChamber = new OneInTheChamber(Main.plugin);
		    	
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
		        BarAPI bar = new BarAPI(Main.plugin);
		       
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
			    	HungerGames HungerGames = new HungerGames(Main.plugin);

			    	me.acf.MiniGames.HungerGames.PVP PVP = new me.acf.MiniGames.HungerGames.PVP(Main.plugin);
			    	me.acf.MiniGames.API.Bussola Bussola = new me.acf.MiniGames.API.Bussola(Main.plugin);
			    	
			        Enchant enchant = new Enchant(Main.plugin);
			        Recharge.Initialize(Main.plugin);
			        Bungee bungee = new Bungee(Main.plugin);
			        AntiHack.Initialize(Main.plugin, bungee);
			        Servidor server = new Servidor();
			        Admin admin = new Admin(Main.plugin);
			        BarAPI bar = new BarAPI(Main.plugin);
			       
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
		    	SkyWars SkyWars = new SkyWars(Main.plugin);
		    	
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
		        BarAPI bar = new BarAPI(Main.plugin);
		       
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
	    	SkyBlock manager = new SkyBlock(Main.plugin);
	    	
	        Enchant enchant = new Enchant(Main.plugin);
	        Recharge.Initialize(Main.plugin);
	        Bungee bungee = new Bungee(Main.plugin);
	        AntiHack.Initialize(Main.plugin, bungee);
	        Bussola bussola = new Bussola(Main.plugin);
	        Servidor server = new Servidor();
	        Admin admin = new Admin(Main.plugin);
	        BarAPI bar = new BarAPI(Main.plugin);
	       
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
	    	FullPvPManager manager = new FullPvPManager(Main.plugin);
	    	
	        Enchant enchant = new Enchant(Main.plugin);
	        Recharge.Initialize(Main.plugin);
	        Bungee bungee = new Bungee(Main.plugin);
	        AntiHack.Initialize(Main.plugin, bungee);
	        Bussola bussola = new Bussola(Main.plugin);
	        Servidor server = new Servidor();
	        Admin admin = new Admin(Main.plugin);
	        BarAPI bar = new BarAPI(Main.plugin);
	       
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
	    	KitPvPManager kitpvp = new KitPvPManager(Main.plugin);
	    	
	        Enchant enchant = new Enchant(Main.plugin);
	        Recharge.Initialize(Main.plugin);
	        Bungee bungee = new Bungee(Main.plugin);
	        AntiHack.Initialize(Main.plugin, bungee);
	        Servidor server = new Servidor();
	        Admin admin = new Admin(Main.plugin);
	        BarAPI bar = new BarAPI(Main.plugin);
	       
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
        BarAPI bar = new BarAPI(Main.plugin);
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
        BarAPI bar = new BarAPI(Main.plugin);
        
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
