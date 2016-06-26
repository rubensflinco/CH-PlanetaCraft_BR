/**
 * 
 */
package me.acf.KitPvP;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.hub.Main;

/**
 * @author adriancf
 *
 */
public class CombatLog {

	public static HashMap<Player, Player> combat = new HashMap<>();
	
	
	
	public static void AddCombat(final Player p, final Player alvo)
	{
		if ((combat.containsKey(p)) || (combat.containsKey(alvo)))
			return;
		combat.put(p, alvo);
		combat.put(alvo, p);
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	     {
	       public void run()
	       {
	    	combat.remove(p);   
	    	combat.remove(alvo); 
	       }
	       
          }, 290L);
	}
	
	public static boolean EstaEmCombat(Player p)
	{
		if (combat.containsKey(p))
			return true;
		return false;
	}
	
	public static void Remover(Player p)
	{
		try {
		combat.remove(p);
		combat.remove(combat.get(p));
		} catch (Exception e) {
		}
		}
		
		
}
