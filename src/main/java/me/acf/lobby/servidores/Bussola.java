package me.acf.lobby.servidores;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.hub.MiniPlugin;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.recharge.Recharge;

public class Bussola extends MiniPlugin{
	
	public static HashMap loc = new HashMap<String, Location>();
    public Bussola(JavaPlugin plugin) {
		super("Bussola", plugin);
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

	    if ((e.getItem().getType() == Material.COMPASS) && (e.getItem().getItemMeta().getDisplayName().contains("Servidores")))
	    {
	    	if (!Recharge.Instance.use(e.getPlayer(), GetName(), 5000L, true, false)) {
	            return;
	          }
	      jogador.sendMessage("§9§lINFO §fClique em um §7NPC §fcom o nome do jogo que você desejá jogar !");
	      jogador.teleport(new Location(Bukkit.getWorld("world"), -46,164,-61, 90,0));
	      UtilSound.playSound(new Location(Bukkit.getWorld("world"), -46,164,-61), Sounds.LEVEL_UP, 10.0F, 1.0F);
	      e.setCancelled(true);
	    }
	}


   
}
