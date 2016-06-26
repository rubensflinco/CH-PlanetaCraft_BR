/**
 * 
 */
package me.acf.KitPvP;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;

/**
 * @author adriancf
 *
 */
public class Sair extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Sair(JavaPlugin plugin) {
		super("Sair", plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler(priority=EventPriority.MONITOR)
	public void Sair(PlayerQuitEvent event)
	{
		Kit.DelKit(event.getPlayer());
		event.setQuitMessage(null);
		Conta.Remove(event.getPlayer());
		Kit.arena.remove(event.getPlayer());
		PVP.arena1.remove(event.getPlayer());
		PVP.arena2.remove(event.getPlayer());
		PVP.arena3.remove(event.getPlayer());
		if (CombatLog.EstaEmCombat(event.getPlayer()))
		{
			try {
				event.getPlayer().isDead();
				}catch (Exception exception)
			    {
					
			    }
		}
	}
}
