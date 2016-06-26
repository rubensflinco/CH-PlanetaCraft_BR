/**
 * 
 */
package me.acf.FullPvP;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

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
		event.setQuitMessage(null);
		Conta.Remove(event.getPlayer());
		if (CombatLog.EstaEmCombat(event.getPlayer()))
		{
			 event.getPlayer().damage(99999.0D);
			}
		UtilInv.save(event.getPlayer());
	}
}
