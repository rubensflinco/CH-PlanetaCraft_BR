/**
 * 
 */
package me.acf.MiniGames.HungerGames.kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.hub.Main;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;

/**
 * @author adriancf
 *
 */
public class Menu {
        public static boolean allkits = false;
	
	
	public static void AbrirMenu(final Player p)
	{
		  final Inventory inv = Bukkit.getServer().createInventory(p, 54, "Kits do "+Main.plugin.getConfig().getString("Carregar"));
		    ItemStack Vazio = new ItemStack(Material.THIN_GLASS);
		    ItemMeta metaVazio = Vazio.getItemMeta();
		    metaVazio.setDisplayName("§f-");
		    Vazio.setItemMeta(metaVazio);
		  
		    ItemStack loja = new ItemStack(264);
		    ItemMeta metaloja = loja.getItemMeta();
		    metaloja.setDisplayName("§9Loja!");
		    loja.setItemMeta(metaloja);
		    inv.setItem(0, loja);
		   
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
		    inv.setItem(4, loja);
		    inv.setItem(5, Vazio);
		    inv.setItem(6, Vazio);
		    inv.setItem(7, Vazio);
		    inv.setItem(8, pagina2);
		  for (final String s : Kit.kitsMENU.keySet())
		  {
		   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
		   	      public void run() {
		  			if (s.contains("§a[Gratis]")){
		  			    inv.addItem(Kit.kitsMENU.get(s));
		  				}
				   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
				   	      public void run() {
				  			if (s.contains("§c[Pago-Planets]")){
				  			    inv.addItem(Kit.kitsMENU.get(s));
				  				}
						   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
						   	      public void run() {
						  			if (s.contains("§6[Vip]")){
						  			    inv.addItem(Kit.kitsMENU.get(s));
						  				}
								   	  Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
								   	      public void run() {
								  			if (s.contains("§5[Vip+]")){
								  			    inv.addItem(Kit.kitsMENU.get(s));
								  				}
								   	      } 
								   	    }
								   	    , 2L);
						   	      } 
						   	    }
						   	    , 2L);
				   	      } 
				   	    }
				   	    , 2L);
		   	      } 
		   	    }
		   	    , 2L);
		  }
		  p.openInventory(inv);
		  UtilSound.playSound(p, Sounds.CHEST_OPEN, 10.0F, 1.0F);
	}
}
