/**
 * 
 */
package me.hub.publicidade;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.hub.Main;
import me.hub.API.Util.UtilTime;
/**
 * @author adriancf
 *
 */
public class PublicidadeMananger {

	private Inventory invp;
	private Player jogador;
	private int second = 0;
	private int data = 15;
	private int contidade = 15;
	public PublicidadeMananger(final Inventory inv ,final Player p)
	{
		invp = inv;
		jogador = p;
		
		 Bukkit.getScheduler().runTaskLaterAsynchronously(Main.plugin, new Runnable() {
	            @Override
	            public void run() {
		if (Publicidade.Verificar(p))
		{
		      Inventory i = Bukkit.getServer().createInventory(p, 54, "Publicidade.");
		   	  p.openInventory(i);
		      AddPublic(i);

		}
		else {
			p.openInventory(inv);
		}
	            }
		   }, 15);
	}
	
	private void AddPublic(final Inventory inv)
	{
		new BukkitRunnable()
   	    {
	      @SuppressWarnings({ "deprecation", "unused" })
	      public void run()
  	       {
	    	  if (Publicidade.remove.contains(jogador))
	    	  {
	    		  cancel();
	    		  Publicidade.remove.remove(jogador);
	    	  }
	    	  try {
	        contidade -= 1;
	        long milliseconds = contidade*1000;
	        String timeLeft = UtilTime.convertString(milliseconds, 0, UtilTime.TimeUnit.FIT);
	        AddItem(inv,new String[] {
				      ChatColor.RESET + timeLeft+ " Aguarde...", 
				      "", 
				      ChatColor.RESET + "§aVocê ama nosso servidor ?", 
				      ChatColor.RESET + "Você pode ajudar nosso servidor", 
				      ChatColor.RESET + "Comprando VIP em nossas lojas tenha vantages", 
				      ChatColor.RESET + "Assim nos conseguiremos manter o nosso servidor online", 
				      "", 
				      ChatColor.RESET + "§eNossos VIP estão disponiveis em.", 
				      "", 
				      ChatColor.RESET + "§awww.planetacraft.com.br/loja" });
	        switch  (contidade)
	        {
	        case 0: 
	        	jogador.openInventory(invp);
	        	Publicidade.AddPlayer(jogador);
	        	
	        	cancel();
	        	
	        }
	    	  } catch (Exception e) {
			    	
	   			try {
				
					cancel();
				} catch (Throwable e2) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	   		    }
	     
  	       }
   	    }
	      .runTaskTimer(Main.plugin, 0L, 20L);
	}
		
	
	
    private void AddItem(Inventory inv,String[] strings)
     {
    	
    	
    	      ItemStack bau = new ItemStack(Material.WOOL, contidade, (byte)data);
    	      ItemMeta metae = bau.getItemMeta();
    	      metae.setDisplayName("§a§lPublicidade");
    	      metae.setLore(Arrays.asList(strings));
    	      bau.setItemMeta(metae);
    	      inv.setItem(22, bau);
    	      if (data == 15)
    	    	  data = 14;
    	    	  else
    	    		  data = 15;
    }
}
