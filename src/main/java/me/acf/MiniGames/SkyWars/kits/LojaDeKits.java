package me.acf.MiniGames.SkyWars.kits;
import me.acf.FormatText.Format;
import me.acf.MiniGames.SkyWars.Conta;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilActionBar;
import me.hub.API.Util.UtilNumber;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.UtilTitle;
import me.hub.API.Util.Sound.Sounds;
import me.site.account.Account;
import me.site.account.AccountWeb;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class LojaDeKits extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public LojaDeKits(JavaPlugin plugin) {
		super("LojaDeKits", plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void LobbyMenu(PlayerCommandPreprocessEvent event)
	{
		Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/loja")){
		       event.setCancelled(true);
		       guiLojaKits(p);
		}
	}
    
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static void guiLojaKits(final Player p)
  {
    final Inventory inv = Bukkit.getServer().createInventory(p, 54,"§9Loja de Kits");
    
    ItemStack Vazio = new ItemStack(Material.THIN_GLASS);
    ItemMeta metaVazio = Vazio.getItemMeta();
    metaVazio.setDisplayName("§f-");
    Vazio.setItemMeta(metaVazio);
  
    ItemStack planets = new ItemStack(266);
    ItemMeta metaplanets = planets.getItemMeta();
    metaplanets.setDisplayName("§3Você tem §f₱ "+UtilNumber.getNumber(Account.getCoins(p)));
    planets.setItemMeta(metaplanets);
    inv.setItem(0, planets);
   
    ItemStack pagina2 = new ItemStack(Material.CARPET, 1, (short) 14);
    ItemMeta paginas2 = pagina2.getItemMeta();
    paginas2.setDisplayName("§c-->");
    pagina2.setItemMeta(paginas2);

    ItemStack pagina1 = new ItemStack(Material.CARPET, 1, (short) 14);
    ItemMeta paginas1 = pagina1.getItemMeta();
    paginas1.setDisplayName("§c<--");
    pagina1.setItemMeta(paginas1);

    inv.setItem(0, pagina1);
    inv.setItem(1, Vazio);
    inv.setItem(2, Vazio);
    inv.setItem(3, Vazio);
    inv.setItem(4, planets);
    inv.setItem(5, Vazio);
    inv.setItem(6, Vazio);
    inv.setItem(7, Vazio);
    inv.setItem(8, pagina2);
    
	  for (final String s : Kit.kitsLOJAMENU.keySet())
	  {
          final String NomeKIT = s.replace("§a[Gratis]", "").replace("§c[Pago-Planets]", "").replace("§6[Vip]", "").replace("§5[Vip+]", "");
	   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
	   	      public void run() {
		  				if (!Conta.kits.get(p).contains(NomeKIT.replace("§9", ""))){
		  			    inv.addItem(Kit.kitsLOJAMENU.get(s));
		  			}
	   	      }
	   	    }
	   	    , 2L);
	  }
	  
    p.openInventory(inv);
    UtilSound.playSound(p, Sounds.CHEST_OPEN, 10.0F, 1.0F);
  }
  
  // Logo abaixo menu GUI onde add a função dos incones
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    
    if ((e.getInventory().getTitle().equalsIgnoreCase("§9Loja de Kits")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c<--"))
    {
       p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Não contem mais paginas desse lado");
       UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
       p.closeInventory();
       e.setCancelled(true);
       return;
     }
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c-->"))
    {
       p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Não contem mais paginas desse lado");
       UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
       p.closeInventory();
       e.setCancelled(true);
       return;
     }
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Você tem §f₱ "+UtilNumber.getNumber(Account.getCoins(p))))
    {
          e.setCancelled(true);
          p.closeInventory();
          UtilActionBar.ActionBar(p, "§5Você tem §f₱ "+UtilNumber.getNumber(Account.getCoins(p)));
	      UtilTitle.sendTitle(p,10,30,10,"§5Você tem :","§f₱ "+UtilNumber.getNumber(Account.getCoins(p)));
          p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Você tem §f₱" + UtilNumber.getNumber(Account.getCoins(p)) + "§7 !" );
  		UtilSound.playSound(p, Sounds.SUCCESSFUL_HIT, 10.0F, 1.0F);
          return;
     }
      
      String NomeKIT = e.getCurrentItem().getItemMeta().getDisplayName().replace("§a[Gratis]", "").replace("§c[Pago-Planets]", "").replace("§6[Vip]", "").replace("§5[Vip+]", "");
	     if (Kit.kit.containsKey(NomeKIT))
	    		 {
 	    	       e.setCancelled(true);
 	    	       p.closeInventory();
			  		if (!Conta.kits.get(p).contains(NomeKIT)){
			  	   String buscar = AccountWeb.Conectar(Main.site + "/API/MG/SW.php?modo=LOJA-Kit&nick="+p.getName()+"&quantidade="+Kit.kitsLOJApreco.get(NomeKIT)+"&kit="+NomeKIT.replace("§9", "")+"", "KIT");
 	    	       p.sendMessage(buscar.replace("&", "§").replace("pular", "\n"));
 	    	      Conta.Reload(p);
			  		}else{
					   p.sendMessage("§5§l"+ Bukkit.getServerName() +" §cVocê já tem o kit " + NomeKIT);
		    	        UtilSound.playSound(p, Sounds.ANVIL_LAND, 10.0F, 1.0F);
			  		}
	      }
	     else
	     {
	    	 Format.Erro("O kit " + e.getCurrentItem().getItemMeta().getDisplayName() + " não existe!" , p);
	     }

    }
  }
}
