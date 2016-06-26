/**
 * 
 */
package me.acf.FullPvP.loja;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.FormatText.Format;
import me.acf.FullPvP.loja.Comprar.Comprar;
import me.acf.FullPvP.loja.Venda.Venda;
import me.acf.FullPvP.scoreboard.Scoreboard;
import me.hub.MiniPlugin;
import me.hub.recharge.Recharge;
import me.site.account.Account;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class LojaManager extends MiniPlugin{

	
    /**
	 * @param moduleName
	 * @param plugin
	 */
	public LojaManager(JavaPlugin plugin) {
		super("Loja", plugin);
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void Quebrar(BlockBreakEvent event)
	{
		try {
		if ((event.getBlock().getType() == Material.SIGN) || (event.getBlock().getType() == Material.SIGN_POST))
		{
			Sign placa = (Sign) event.getBlock().getState();
			if (placa.getLine(0) != null)
			{
				if (placa.getLine(0).equals(event.getPlayer().getName())) {
				LojaAPI.setoff(LojaAPI.GerarID(event.getBlock().getLocation()), event.getPlayer().getName());
				}
				else
				{
					  if ((Account.getRank(event.getPlayer())).Has(event.getPlayer(), Rank.STAFFM, false))
		      		   {
							LojaAPI.setoff(LojaAPI.GerarID(event.getBlock().getLocation()), placa.getLine(0));
							return;
		      		   }
					event.setCancelled(true);
				}
				return;
				}
		}
		if (event.getBlock().getType() == Material.CHEST)
			
		{
			Location loc = event.getBlock().getLocation().clone().add(0,1,0);
			Sign placa = (Sign) loc.getBlock().getState();
			if (placa.getLine(0) != null)
			{
				if (placa.getLine(0).equals(event.getPlayer().getName())) {
				event.setCancelled(false);
				}
				else
				{
					 if ((Account.getRank(event.getPlayer())).Has(event.getPlayer(), Rank.STAFFM, false))
		      		   {
						 return;
		      		   }
					 if ((placa.getLine(1).equalsIgnoreCase("Comprar")) || (placa.getLine(1).equalsIgnoreCase("Vender")))
					event.setCancelled(true);
				}
				return;
				}
		}
		 } catch (Exception e) {
		
		 }
	}
	
	
    @EventHandler(priority=EventPriority.MONITOR)
    public void clicar(PlayerInteractEvent e)
    {
      Player p = e.getPlayer();
      if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && ((e.getClickedBlock().getType() == Material.SIGN_POST) || (e.getClickedBlock().getType() == Material.WALL_SIGN)))
      {
        Sign s = (Sign)e.getClickedBlock().getState();
        if (s.getLine(2).equalsIgnoreCase("§b§lClick"))
        {
        	if (s.getLine(0).contains("[Loja]"))
            {
          	  if ((Account.getRank(e.getPlayer())).Has(e.getPlayer(), Rank.STAFFM, false))
      		   {
          		  ItemStack i = e.getPlayer().getItemInHand();
          		  if (i == null)
          		  {
          			 Format.Comando("Loja", "Você não tem item para isto.", p);
          			  return;
          		  }
          		  if (i.getType() == Material.AIR)
          		  {
          			 Format.Comando("Loja", "Você não tem item para isto.", p);
          			  return;
          		  }
          		  s.setLine(2, "" + i.getTypeId() + ":" + i.getDurability());
          		  s.update();
          		  LojaAPI.UnixShop(i, LojaAPI.GerarID(s.getLocation()));
          		  Format.Comando("Loja", "Placa de Loja Criado com exito!", p);
      		   }
          	  return;
            }
        	
        	ItemStack i = e.getPlayer().getItemInHand();
    		  if (i == null)
    		  {
    			 Format.Comando("Loja", "Você não tem item para isto.", p);
    			  return;
    		  }
    		  if (i.getType() == Material.AIR)
    		  {
    			 Format.Comando("Loja", "Você não tem item para isto.", p);
    			  return;
    		  }
    		  s.setLine(2, "" + i.getTypeId() + ":" + i.getDurability());
    		  s.update();
    		  LojaAPI.save(e.getPlayer(),i, LojaAPI.GerarID(s.getLocation()));
    		  Format.Comando("Loja", "Placa de Loja Criado com exito!", p);
        }
        if (s.getLine(0).equals(e.getPlayer().getName()))
        {
        	Format.Erro("Você quer usar sua propria loja ??", p);
        	return;
        }
        if (s.getLine(1).equalsIgnoreCase("Comprar"))
        {
        	Comprar.Comprar(s,e.getPlayer());
   	     Scoreboard.CriarScoreboard(p);
   	     return;
        }
        if (s.getLine(1).equalsIgnoreCase("Vender"))
        {
   	     Scoreboard.CriarScoreboard(p);
        	Venda.Venda(s,e.getPlayer());
        	return;
        }
        
    }
        }
    
	@EventHandler
    public void Placas(SignChangeEvent event)
    {
    
		 if (event.getLine(0).equalsIgnoreCase("Shop"))
	      {
			 event.setLine(0, event.getPlayer().getName()); // [Loja]
	          event.setLine(2, "§b§lClick");  // Vender ou Comprar
	                                         //ID
	                                         // Valor
	              if (event.getLine(1) == null)
	              {
	            	  event.setLine(1, "Comprar");
	              }
	              if (event.getLine(3) == null)
	              {
	            	  event.setLine(3, "Free");
	              }
	      }
		 else
      if (event.getLine(0).equalsIgnoreCase("UnixShop"))
      {
    	  if ((Account.getRank(event.getPlayer())).Has(event.getPlayer(), Rank.STAFFM, false))
		   {

          event.setLine(0, "§0§l[Loja]"); // [Loja]
          event.setLine(2, "§b§lClick");  // Vender ou Comprar
                                         //ID
                                         // Valor
              if (event.getLine(1) == null)
              {
            	  event.setLine(1, "Comprar");
              }
              if (event.getLine(3) == null)
              {
            	  event.setLine(3, "Free");
              }
		   }
    	  return;
      }
		 if ((event.getLine(1).equals("Comprar")) || (event.getLine(1).equals("Vender")))
				 {
			 event.setLine(0, event.getPlayer().getName());
				 }
      }
	
}
