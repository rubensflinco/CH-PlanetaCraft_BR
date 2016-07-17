/**
 * 
 */
package me.acf.MiniGames.HungerGames.kits.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.FormatText.Format;
import me.acf.MiniGames.HungerGames.kits.Kit;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import me.hub.recharge.Recharge;

/**
 * @author adriancf
 *
 */
public class Ninja extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Ninja(JavaPlugin plugin) {
		super("Kit Ninja", plugin);
		// TODO Auto-generated constructor stub
	}

	  public static HashMap<Player, Player> teleport = new HashMap<>();
	  public static ArrayList<Player> noteleport = new ArrayList<>();
	  
	  @EventHandler
	  public void setartp(EntityDamageByEntityEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
	    {
	      Player p = (Player)e.getEntity();
	      Player d = (Player)e.getDamager();
			  if (Kit.verkit(d).contains("Ninja"))
			    {
	      teleport.put(d, p);
	     }
	    }
	  }
	  @EventHandler
	  public void teleportar(PlayerToggleSneakEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((Kit.verkit(p).contains("Ninja")) && 
	      (p.isSneaking())) {
	      if (teleport.containsKey(p)) {
	    	  if (!teleport.get(p).isOnline())
	    	  {
	    		  Format.Erro("Jogador não esta online para você se teleportar", p);
	    		  teleport.remove(p);
	    		  return;
	    	  }
	    	  if (noteleport.contains(teleport.get(p)))
	    	  {
	    		  Format.Erro("Desculpe mais você não pode teleportar para este alvo.", p);
	    		  teleport.remove(p);
	    		  return;
	    	  }
	    	   if (!Recharge.Instance.use(p, "ninja", 10900L, true, false)) {
	               return;
	             }
	    	   p.teleport(teleport.get(p).getLocation());
	    	   UtilSound.playSound(p, Sounds.ENDERMAN_TELEPORT, 1.0F, 1.0F);
	    	   teleport.remove(p);
	      }
	      else
	      {
	    	  Format.Erro("Não tem ninguem para se teleportar", p);
	      }
	    }
	  }
	  
}
