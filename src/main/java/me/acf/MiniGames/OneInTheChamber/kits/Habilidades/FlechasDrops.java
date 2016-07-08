package me.acf.MiniGames.OneInTheChamber.kits.Habilidades;

import me.acf.MiniGames.OneInTheChamber.kits.Kit;
import me.hub.MiniPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FlechasDrops extends MiniPlugin {

	public FlechasDrops(JavaPlugin plugin) {
		super("FlechasDrops", plugin);
		// TODO Auto-generated constructor stub
	}
		@EventHandler
		public void onPickup(PlayerPickupItemEvent e) {
			Player p = e.getPlayer();
	    	 Material item = e.getItem().getItemStack().getType();
	    	if (item == Material.ARROW) {
			  if (Kit.verkit(p).contains("FlechasDrops"))
			    {
			    }else{
					e.setCancelled(true);
			    }
			}
		}
	  
}
