/**
 * 
 */
package me.acf.MiniGames;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.HungerGames.Conta;
import me.acf.MiniGames.Style.UserData;
import me.acf.MiniGames.Style.Utils.MGPremios;
import me.acf.MiniGames.Style.Utils.MGSpectator;
import me.acf.servidor.Servidor;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Chat;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.comandos.geral.fly;
import me.site.account.Account;
import me.site.account.AccountWeb;

/**
 * @author adriancf
 *
 */
public class GameEvents extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public static boolean ProtegerGG = false;
	public static boolean Proteger = true;
	public static boolean ProtegerInv = true;
	
	public GameEvents(JavaPlugin plugin) {
		super("Events", plugin);
		// TODO Auto-generated constructor stub
	}
	
	  @EventHandler
	  public void Dano(EntityDamageEvent event) {
		  if (Proteger)	  
			  event.setCancelled(true);
		  if (ProtegerInv)	
			  event.setCancelled(true);
	  }
	
	  @EventHandler
	  public void fome(FoodLevelChangeEvent event) {
		  if (ProtegerGG){
			  event.setCancelled(true);
		  }else{
		  if (Proteger)	  
			  event.setCancelled(true);
		  if (ProtegerInv)	
			  event.setCancelled(true);
		  }
	  }
	  @EventHandler
	  public void Drop(PlayerDropItemEvent event)
	  {
		  if (Proteger)	  
			  event.setCancelled(true);
		  if (!MiniGamesMananger.Vivos.contains(event.getPlayer()))
			  event.setCancelled(true);
	  }
	  @EventHandler
	  public void Blocks(BlockDamageEvent event) {
		  if (ProtegerGG){
			  event.setCancelled(true);
			  if (!MiniGamesMananger.Vivos.contains(event.getPlayer()))
				  event.setCancelled(true);
		  }else{
		  if (Proteger)	  
			  event.setCancelled(true);
		  if (!MiniGamesMananger.Vivos.contains(event.getPlayer()))
			  event.setCancelled(true);
		  }
	  }
	  @EventHandler
	  public void Blocks(BlockBreakEvent event) {
		  if (ProtegerGG){
			  event.setCancelled(true);
			  if (!MiniGamesMananger.Vivos.contains(event.getPlayer()))
				  event.setCancelled(true);
		  }else{
		  if (Proteger)	  
			  event.setCancelled(true);
		  if (!MiniGamesMananger.Vivos.contains(event.getPlayer()))
			  event.setCancelled(true);
		  }
	  }
	  @EventHandler
	  public void Blocks(BlockPlaceEvent event) {
		  if (ProtegerGG){
			  event.setCancelled(true);
			  if (!MiniGamesMananger.Vivos.contains(event.getPlayer()))
				  event.setCancelled(true);
		  }else{
		  if (Proteger)	  
			  event.setCancelled(true);
		  if (!MiniGamesMananger.Vivos.contains(event.getPlayer()))
			  event.setCancelled(true);
		  }
	  }

	  @EventHandler
	  public void Interagir(PlayerInteractEvent event) {
		  if (Proteger)	  
			  event.setCancelled(true);
	  }
	  @EventHandler
	  public void Targe(EntityTargetEvent event)
	  {
		  if (Proteger)	  
			  event.setCancelled(true);
		    if ((event.getTarget() instanceof Player)) {
		        Player p = (Player)event.getTarget();
		  if (!MiniGamesMananger.Vivos.contains(p))
			  event.setCancelled(true); 
		    }
		  
	  }
	    @EventHandler
	    public void Pickup(PlayerPickupItemEvent event) {
			  if (Proteger)	  
				  event.setCancelled(true);
			  if (!MiniGamesMananger.Vivos.contains(event.getPlayer()))
				  event.setCancelled(true);
			  		
	    }
	    @EventHandler
	    public void ItemSpawn(ItemSpawnEvent event)
	    {
			  if (Proteger)	  
				  event.setCancelled(true);
	    }
		   @EventHandler
		   public void BlockBurn(BlockBurnEvent event)
		   {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		   }
		   
		   @EventHandler
		   public void BlockFade(BlockFadeEvent event) {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		   }
		   
		   @EventHandler
		   public void BlockSpread(BlockSpreadEvent event) {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		   }
		   
		   @EventHandler(priority=EventPriority.LOW)
		   public void playerPortalEvent(PlayerPortalEvent event)
		   {    		
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		   }
		   @EventHandler
		   public void Explosion(EntityExplodeEvent event) {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  }
		   }

		   @EventHandler
		   public void BlockForm(BlockFormEvent event) {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		   }
		    @EventHandler
		    public void onPotion(PotionSplashEvent event) {
				  if (Proteger)	  
					  event.setCancelled(true);
		    }
		    @EventHandler
		    public void onSpawn(CreatureSpawnEvent event) {
				  if (Proteger)	  
					  event.setCancelled(true);
		    }
		    @EventHandler
		    public void pigZap(PigZapEvent event) {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		    }
		    @EventHandler
		    public void onVechileEnter(VehicleEnterEvent event) {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		    }
		    @EventHandler
		    public void onVechileEvent(VehicleDestroyEvent event) {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		    }

		    @EventHandler
		    public void onVechileMove(VehicleEntityCollisionEvent event) {
				  if (ProtegerGG){
					  event.setCancelled(true);
				  }else{
				  if (Proteger)	  
					  event.setCancelled(true);
				  if (ProtegerInv)	
					  event.setCancelled(true);
				  }
		    }
		   @EventHandler
		   public void LeaveDecay(LeavesDecayEvent event) {
				  if (Proteger)	  
					  event.setCancelled(true);
		   }
		   
		   @EventHandler
		   public void Sair(PlayerQuitEvent event)
		   {
				Player jogador = event.getPlayer();
				
				int jogadores = MiniGamesMananger.jogadores.size()-1;
				
				event.setQuitMessage("§8§lSaiu §f"+jogador.getName()+" §7("+jogadores+"/"+Bukkit.getServer().getMaxPlayers()+")");
				
				if (Arcade.estilo.equals(ArcadeType.JOGANDO)){
				MGPremios.Givar(event.getPlayer(), false);
				}
				
		 		MiniGamesMananger.jogadores.remove(jogador);
		 		MiniGamesMananger.Vivos.remove(jogador);
		 		MiniGamesMananger.Specter.remove(jogador);
		   }
		   
			public ArrayList<Player> joins = new ArrayList<>();
			public int evento = 100;
			
		   @EventHandler
		   public void Entrar(PlayerJoinEvent event)
		   {
			   UserData user = new UserData(event.getPlayer());
			   
			   MiniGamesMananger.jogadores.put(event.getPlayer(),user);
			   
				if ((Arcade.estilo.equals(ArcadeType.INVENCIVEL)) || (Arcade.estilo.equals(ArcadeType.JOGANDO)) || (Arcade.estilo.equals(ArcadeType.FIM))){
					MGSpectator.AddSpectator(event.getPlayer());
				}else{
			        MiniGamesMananger.Vivos.add(event.getPlayer());
				}
				event.setJoinMessage("§8§lEntrou §f"+event.getPlayer().getName()+" §7("+MiniGamesMananger.jogadores.size()+"/"+Bukkit.getServer().getMaxPlayers()+")");
				
			   
			   event.setJoinMessage(null);
			   event.getPlayer().getInventory().clear();
			   event.getPlayer().setLevel(0);
			   event.getPlayer().setExp(0);
			   event.getPlayer().setFoodLevel(30);
			   event.getPlayer().setHealth(20);
			   
			   event.getPlayer().teleport(MiniGamesMananger.world.getSpawnLocation());
			   fly.Desativar(event.getPlayer());
				Chat.ActionBar(event.getPlayer(), "§e§l" + "SEJA BEM-VINDO AO "+Bukkit.getServer().getServerName().toUpperCase() + " DO PLANETACRAFT_BR");
				 event.getPlayer().sendMessage(" ");
				 event.getPlayer().sendMessage("      §f§lSEJA BEM-VINDO; §7§l" + event.getPlayer().getName());
				 event.getPlayer().sendMessage("                 §f§lAO §a§l"+Bukkit.getServer().getServerName().toUpperCase());
				 event.getPlayer().sendMessage(" ");
				 UtilSound.playSound(event.getPlayer(), Sounds.NOTE_PLING, 1, 0);
				 event.getPlayer().setFoodLevel(20);
				 event.getPlayer().setHealth(20);
				 Servidor.AddJoin();
		       
			     if (!joins.contains(event.getPlayer()))
			    {
			    	 Account.AddExp(event.getPlayer(), "10");
			    	joins.add(event.getPlayer());
			    	if (joins.size() == 666)
			    	{
			    		Bukkit.broadcastMessage("§c§l666 Súscipe ludio ludius " + event.getPlayer().getName());
			    		for (Player j : UtilServer.Jogadores()) {
			    			UtilSound.playSound(j, Sounds.AMBIENCE_THUNDER, 6.0F, 6.0F);
			    			Chat.ActionBar(event.getPlayer(), "§4§lO JOGADOR NUMERO 666 ENTROU (" + event.getPlayer().getName() + ")");
			    		
			    	}
			    	if (joins.size() == evento)
			    	{
			    		Bukkit.broadcastMessage("§5§lEVENTO §7Você acaba de receber §a+1 Chave.");
			    	    evento = evento+100;
			    		for (Player j : UtilServer.Jogadores()) {
			    		Account.AddChave(j, 1);
			    	    Account.UpdateAccount(j);
			    	    }
			    	    }
			    
			    	}
			    }
			     
			    
			   
		   }

}
