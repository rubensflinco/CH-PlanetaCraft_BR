/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.FormatText.Format;
import me.acf.KitPvP.kitAPI.Kit;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.recharge.Recharge;

/**
 * @author adriancf
 *
 */
public class Disable extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Disable(JavaPlugin plugin) {
		super("Kit Ninja", plugin);
		// TODO Auto-generated constructor stub
	}

	  public static HashMap<Player, Player> disable = new HashMap<>();
	  public static HashMap<Player, String> k = new HashMap<Player, String>();
	  
	  
	  @EventHandler
	  public void setartp(EntityDamageByEntityEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
	    {
	      Player p = (Player)e.getEntity();
	      Player d = (Player)e.getDamager();
	     if (Kit.PoderUsar(d, "disable"))
	     {
	    	 if (Kit.NaArena(p))
	      disable.put(d, p);
	     }
	    }
	  }
	  
	  @EventHandler
	  public void disablear(PlayerToggleSneakEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((Kit.PoderUsar(p, "disable")) && 
	      (p.isSneaking())) {
	      if (disable.containsKey(p)) {
	    	  if (!disable.get(p).isOnline())
	    	  {
	    		  Format.Erro("Jogador não esta online para você desativar", p);
	    		  disable.remove(p);
	    		  return;
	    	  }
	    	   if (!Recharge.Instance.use(p, "disable", 46900L, true, false)) {
	               return;
	             }
	    	   disable.get(p).sendMessage("§cVocê foi desativado!!");
	    	   p.sendMessage("§cVocê desativou o " + disable.get(p).getName());
	    	   k.put(disable.get(p), Kit.verkit(disable.get(p)));
	    	   Kit.AddKit(disable.get(p), "§a§lDesativado");
	    	   p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 1.0F, 1.0F);
	    	   disable.get(p).playSound(disable.get(p).getLocation(), Sound.IRONGOLEM_DEATH, 1.0F, 1.0F);
	           Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
		        {
		          public void run()
		          {
		        	  if (p.isOnline())
		        	  {
		        	  Kit.AddKit(disable.get(p), k.get(disable.get(p)));
					   k.remove(disable.get(p));
					   disable.remove(p);
					   disable.get(p).sendMessage("§aVocê foi ativado!!");
					   p.playSound(p.getLocation(), Sound.IRONGOLEM_WALK, 1.0F, 1.0F);
					   disable.get(p).playSound(disable.get(p).getLocation(), Sound.IRONGOLEM_WALK, 1.0F, 1.0F);
		          }
		          }
		        }, 100L);
	      }
	      else
	      {
	    	  Format.Erro("Não tem ninguem para você desativar", p);
	      }
	    }
	  }
	  
}
