/**
 *
 * Projeto: CHub2 
 * Packet: me.acf.MiniGames.Style.Utils
 * Git Config: 
 * Usuario: adriancf
 * -= [Team CHGroup] =-
 *
 */
package me.acf.MiniGames.Style.Utils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import me.acf.MiniGames.Arcade;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.Arcade.ArcadeType;
import me.acf.MiniGames.Style.UserData.Style;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.Bungee.Bungee;
import me.site.account.AccountWeb;

/**
 *
 * Criado dia 19 de jun de 2016 - 15:57:34
 * Projeto: CHub2
 * por @author αdяiαиcf #Reloads
 * 
 */
public class MGSpectator extends MiniPlugin
{
	public MGSpectator(JavaPlugin plugin) 
	{
		super("MGSpectator", plugin);
	}
	
	
	  
		public static void AddSpectator(final Player p)
		{
		 	   p.setHealth(20.0D);
			   p.setFoodLevel(20);
			   p.closeInventory();
			   p.getInventory().setArmorContents(null);
			   p.getInventory().clear();
		  	   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
			   	      public void run() {
			   		   MiniGamesMananger.Specter.remove(p);
					   MiniGamesMananger.Vivos.remove(p);
					   MiniGamesMananger.Specter.add(p);
					   p.setGameMode(GameMode.SPECTATOR);
					   MiniGamesMananger.jogadores.get(p).style = Style.SPECTADOR;
					   p.getPlayer().getInventory().setHeldItemSlot(4);
					   UtilInv.AddItem(p.getInventory(), false, Material.BOOK, 1,(byte)0, "§aMenu Spectador", 4);
			   	      } 
			   	    }
			   	    , 10L);
		}
		

		@EventHandler
		public void AbrirMenu(PlayerInteractEvent e)
		{
			Player p = e.getPlayer();
			
		  if ((p.getItemInHand().getType() == Material.BOOK) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))) 
		    {
			  UtilSound.playSound(p, Sounds.CHEST_OPEN, 10.0F, 1.0F);
			   MGSpectator.Menu1(p);
			   e.setCancelled(true);
		      }
		}
		
		  @EventHandler
		  public void MenuClick(InventoryClickEvent e)
		  {
		    Player p = (Player)e.getWhoClicked();
		    
		    if (e.getInventory().getTitle().equals("§bTP Players"))
		    {
		      e.setCancelled(true);
		      if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR)) || (!e.getCurrentItem().hasItemMeta()))
		      {
		        p.closeInventory();
		        e.setCancelled(true);
		        return;
		      }
		      if (e.getCurrentItem().getType().equals(Material.SKULL_ITEM))
		      {
		        Player r = Bukkit.getPlayer(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
		        e.setCancelled(true);
		        p.teleport(r);
		        p.closeInventory();
		        return;
		      }
		    }else
		    if ((e.getInventory().getTitle().contains("Spectador")) && 
		    	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
		    	    {
			      if (e.getCurrentItem().getType().equals(Material.THIN_GLASS))
			      {
			    	  UtilSound.playSound(p, Sounds.LEVEL_UP, 0.5F, 0.2F);
			        e.setCancelled(true);
			        p.closeInventory();
			      }else
		        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTP Players"))
		        {
		        	if (Arcade.estilo.equals(ArcadeType.JOGANDO)){
		        		if (MiniGamesMananger.Specter.contains(p)){
		           p.closeInventory();
		           MGSpectator.Menu2(p);
		           UtilSound.playSound(p, Sounds.CHEST_OPEN, 10.0F, 1.0F);
		        		}else{
			        		p.sendMessage("§cOPS §7Você não é um espectador.");
			        		p.closeInventory();
			        		UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);	
		        		}
		        	}else{
		        		p.sendMessage("§cOPS §7Jogo ainda não começou..");
		        		p.closeInventory();
		        		UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
		        	}
		           e.setCancelled(true);
		         }else
		        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVoltar para o Lobby"))
		        {
		        	p.closeInventory();
		        	   Bungee.SendPlayerToServer(p, "lobby");
		        	   UtilSound.playSound(p, Sounds.LEVEL_UP, 10.0F, 1.0F);
			           e.setCancelled(true);
		        }else
		        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Próxima sala"))
		        {
		        	p.closeInventory();
			     String Servidor = AccountWeb.Conectar(Main.site + "/API/sala.php?modo=CONSUTAR_ON&nome=" + Main.plugin.getConfig().getString("Carregar"), "nome");
			    	if (Servidor == null)
			    	 {
			    		UtilSound.playSound(p, Sounds.ANVIL_LAND, 0.5F, 0.2F);
			    	 p.sendMessage("§cTodas as salas de §f"+Main.plugin.getConfig().getString("Carregar")+"§c estão fechadas ou em jogos.");
			    	 }else{
				     p.closeInventory();
				     UtilSound.playSound(p, Sounds.LEVEL_UP, 0.5F, 0.2F);
		             p.sendMessage("§cLocalizado a sala §a " + Servidor);
				     Bungee.SendPlayerToServer(p, Servidor);
			         e.setCancelled(true);
			    	 }
		          }
		      }
		    }
	  
		public static void Menu1(Player p)
		{
			  Inventory inv = Bukkit.createInventory(p, 9, "§aMenu Spectador");
			  
			    ItemStack loja = new ItemStack(264);
			    ItemMeta metaloja = loja.getItemMeta();
			    metaloja.setDisplayName("§9Próxima sala");
			    loja.setItemMeta(metaloja);
			   
			    ItemStack pagina2 = new ItemStack(Material.WOOD_DOOR, 1, (short) 0);
			    ItemMeta paginas2 = pagina2.getItemMeta();
			    paginas2.setDisplayName("§cVoltar para o Lobby");
			    pagina2.setItemMeta(paginas2);

			    ItemStack pagina1 = new ItemStack(Material.COMPASS, 1, (short) 0);
			    ItemMeta paginas1 = pagina1.getItemMeta();
			    paginas1.setDisplayName("§aTP Players");
			    pagina1.setItemMeta(paginas1);

			    inv.setItem(0, pagina1);
			    inv.setItem(4, loja);
			    inv.setItem(8, pagina2);
			    
			    p.openInventory(inv);
		}
		
		public static void Menu2(Player p)
		{
            Inventory inv = Bukkit.createInventory(p, 54, "§bTP Players");
			for (Player online : UtilServer.Jogadores())
			{
				if (MiniGamesMananger.Vivos.contains(online)){
					if (!online.equals(p)){
            ItemStack head = new ItemStack(Material.SKULL_ITEM);
            head.setDurability((short)3);
            SkullMeta headmeta = (SkullMeta)head.getItemMeta();
            headmeta.setOwner(online.getName());
            headmeta.setDisplayName(online.getName());
            List<String> headlore = new ArrayList();
            headlore.add("§f=====§6()§f=====");
            headlore.add("§6Nome §f: " + online.getName());
            headlore.add("§6Vida §f: " + online.getHealthScale());
            headlore.add("§6GameMode §f: " + online.getGameMode());
            headlore.add("§f=====§6()§f=====");
            headmeta.setLore(headlore);
            head.setItemMeta(headmeta);
            inv.addItem(new ItemStack[] { head });
					}
				}
        }
        p.openInventory(inv);
		}
	
	
}
