/**
 * 
 */
package me.acf.FullPvP.VIP;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import me.hub.MiniPlugin;
import me.hub.API.Util.UtilAction;
import me.hub.API.Util.UtilAlg;
import me.hub.API.Util.UtilServer;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.site.account.Account;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class AreaVIP extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public AreaVIP(JavaPlugin plugin) {
		super("AreaVIP", plugin);
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void Teleport (PlayerTeleportEvent event)
	{
		if (event.getTo().getWorld().getName().equals("world")) {

			for(ProtectedRegion r : WGBukkit.getRegionManager(event.getTo().getWorld()).getApplicableRegions(event.getTo())) {
            if (r.getId().contains("vip")) {
  			  if ((Account.getRank(event.getPlayer()).Has(event.getPlayer(), Rank.VIP, false)))
  		     		   {}
  			  else
  			  {
  				event.setCancelled(true);
  			  }
            }
        }
     		   
		}
	}
	
	
	@EventHandler
	public void Interact(PlayerInteractEvent event)
	{
		if (event.getPlayer().getWorld().getName().equals("world")) {

			for(ProtectedRegion r : WGBukkit.getRegionManager(event.getPlayer().getWorld()).getApplicableRegions(event.getPlayer().getLocation())) {
            if (r.getId().contains("vip")) {
  			  if ((Account.getRank(event.getPlayer()).Has(event.getPlayer(), Rank.VIP, false)))
  		     		   {}
  			  else
  			  {
  				event.setCancelled(true);
  				event.getPlayer().teleport(event.getPlayer().getWorld().getSpawnLocation());
  				
  			  }
            }
        }
     		   
		}
	}
	
	
	@EventHandler
	public void Verificar(Atualizar event)
	{
		if (event.getType() != ModosUpdate.FAST)
		{
			return;
		}
		for (Player p : UtilServer.Jogadores()) {
			
		if (p.getWorld().getName().equals("world")) {

			for(ProtectedRegion r : WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation())) {
            if (r.getId().contains("vip")) {
  			  if ((Account.getRank(p).Has(p, Rank.VIP, false)))
  		     		   {}
  			  else
  			  {
  				Location spawnLocation = p.getWorld().getSpawnLocation().clone().add(0,20,0);
  				 UtilAction.velocity(p, UtilAlg.getTrajectory(p.getLocation(), spawnLocation).multiply(-1), 1.5D, true, 0.8D, 0.0D, 1.0D, true);
  			  if (r.getId().contains("vip"))
  			  {
  				p.teleport(p.getWorld().getSpawnLocation());
  			  }
  			  }
            }
            if ((r.getId().contains("pvp")) || (r.getId().contains("arena"))) {
            	if (p.getGameMode() == GameMode.SURVIVAL)
            	{
            		p.setAllowFlight(false);
            		p.setFlying(false);
            	}
            }
        }
     		   
		}
		}
	}
	

}
