/**
 * 
 */
package me.acf.MiniGames.SpleggTnT.kits;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.FormatText.Format;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.Scoreboard.ScoreboardAPI;
import me.hub.config.Config;
import me.site.account.Account;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class Kit extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Kit(JavaPlugin plugin) {
		super("Kit", plugin);
		// TODO Auto-generated constructor stub
	}

	
	private static HashMap<Player,String> kitapi = new HashMap<>();
	public static HashMap<String,Inventory> kit = new HashMap<>();
	public static Map<String,ItemStack> kits = new HashMap<>();
	public static Map<String,ItemStack> kitsMENU = new HashMap<>();
	
	public static void GiveKit(Player p)
	{
		p.getInventory().clear();
		for (ItemStack item : Kit.kit.get(Kit.verkit(p)))
		{
		 try{
			 p.getInventory().addItem(item);
		} catch (Exception e) {
		}
		}
		
	}
	
	public static void AddKit(Player p, String kit)
	{
	  Config.Set(p, "kitpvp.Kit", kit);
	  kitapi.put(p, kit);
	  ScoreboardAPI.remover(p);
	  System.out.print("Kit> Setado kit do jogador " + p.getName() + " para " + kit);
	}
	
	public static void DelKit(Player p)
	{
		kitapi.remove(p);
	}
	
	public static String verkit(Player p)
	{
		return kitapi.get(p);
	}
	

	public static boolean TemKit(Player p )
	{
		if (!kitapi.get(p).contains("Nenhum kit"))
		{
			return true;
		}
		return false;
		}
	
	@EventHandler
	public void Abrir(PlayerInteractEvent e)
	{
		Player jogador = e.getPlayer();
	    if (jogador.getGameMode() == GameMode.CREATIVE)
	      return;
	    if (e.getItem() == null)
	      return;
	    if (e.getItem().getItemMeta().getDisplayName() == null)
	      return;

	    if ((e.getItem().getType() == Material.CHEST) && (e.getItem().getItemMeta().getDisplayName().contains("Kit")))
	    {
	      Menu.AbrirMenu(jogador);
	      e.setCancelled(true);
	    }
	}
	
	  @EventHandler
	  public void Iventarioitens(InventoryClickEvent e)
	  {
	    Player p = (Player)e.getWhoClicked();
	    try {
	    if ((e.getInventory().getTitle().contains("Kits do "+Main.plugin.getConfig().getString("Carregar"))) && 
	    	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	    	    {
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f-"))
	        {
	           UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
	           e.setCancelled(true);
	           return;
	         }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c<--"))
	        {
	           p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Não contem mais paginas desse lado");
	           UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
	           e.setCancelled(true);
	           return;
	         }
	          
	          if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c-->"))
	        {
	           p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Não contem mais paginas desse lado");
	           UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
	           e.setCancelled(true);
	           return;
	         }
	          
	          if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Loja!"))
	        {
	              e.setCancelled(true);
	              p.closeInventory();
	              p.chat("/loja");
	              return;
	         }
	          String NomeKIT = e.getCurrentItem().getItemMeta().getDisplayName().replace("§a[Gratis]", "").replace("§c[Pago-Planets]", "").replace("§6[Vip]", "").replace("§5[Vip+]", "");
	    	     if (Kit.kit.containsKey(NomeKIT))
	    	    		 {
	    	    	 if (kitapi.get(p).equals(NomeKIT)){
	    		           p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Você já escolheu esse KIT !");
	    		           UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
	    		           e.setCancelled(true);
	    	    	 }else{
	    	    	String Name = e.getCurrentItem().getItemMeta().getDisplayName();
	    	    	 if (Name.contains("§a[Gratis]")){
	    	    		   p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Você selecionou o kit " + NomeKIT);
	    	    	       Kit.AddKit(p, NomeKIT);
	    	    	       UtilSound.playSound(p, Sounds.SUCCESSFUL_HIT, 10.0F, 1.0F);
	    	    	       e.setCancelled(true);
	    	    	       p.closeInventory();
	    	    	 }else
	    	    		 if (Name.contains("§c[Pago-Planets]")){
		    	    	       e.setCancelled(true);
		    	    	       p.closeInventory();
		    	    	       UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
		    	    	       p.sendMessage("§cEM BREVE VAMOS TER ESSE KIT PRA VENDER!");
	    	    		 }else
	    	    		 if (Name.contains("§6[Vip]")){
	    					   if ((Account.getRank(p)).Has(p, Rank.VIP, true))
	    					   {
	    						       p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Você selecionou o kit " + NomeKIT);
	    		    	    	       Kit.AddKit(p, NomeKIT);
	    		    	    	       UtilSound.playSound(p, Sounds.SUCCESSFUL_HIT, 10.0F, 1.0F);
	    		    	    	       e.setCancelled(true);
	    		    	    	       p.closeInventory();
	    	    			 }else{
		    	    			   UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
	  		    	    	       e.setCancelled(true);
	  		    	    	       p.closeInventory();
		    	    			 }
	    	    		 }else
	    	    			 if (Name.contains("§5[Vip+]")){
		    					   if ((Account.getRank(p)).Has(p, Rank.VIPM, true))
		    					   {
		    						       p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Você selecionou o kit " + NomeKIT);
		    		    	    	       Kit.AddKit(p, NomeKIT);
		    		    	    	       UtilSound.playSound(p, Sounds.SUCCESSFUL_HIT, 10.0F, 1.0F);
		    		    	    	       e.setCancelled(true);
		    		    	    	       p.closeInventory();
		    					   }else{
			    	    			   UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
		  		    	    	       e.setCancelled(true);
		  		    	    	       p.closeInventory();
			    	    			 }
	    	    		   }
	    	    	 }
	    	      }
	    	     else
	    	     {
	    	    	 Format.Erro("O kit " + e.getCurrentItem().getItemMeta().getDisplayName() + " não existe!" , p);
	    	     }
	    	    }
	    
	  } catch (Exception e1) {
	  }
	  }
	  
	}
