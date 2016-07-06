/**
 * 
 */
package me.acf.KitPvP;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.FormatText.Format;
import me.acf.KitPvP.armor.Armor;
import me.acf.KitPvP.kitAPI.Kit;
import me.acf.KitPvP.kitAPI.Kits;
import me.acf.KitPvP.scoreboard.Scoreboard;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;
import me.hub.comandos.geral.Admin;
import me.hub.config.Config;

/**
 * @author adriancf
 *
 */
public class Arena extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Arena(JavaPlugin plugin) {
		super("Kit-PvP", plugin);
		// TODO Auto-generated constructor stub
	}
	
	 @EventHandler
	    public void manipulate(final PlayerArmorStandManipulateEvent e)
	    {
		 e.setCancelled(true);
		 
	    }
	
	

	public static void GiveKit(Player p)
	{
		p.getInventory().clear();
		p.getInventory().addItem(Kits.Espada(p));
		 Armor.Armor_res(p);
		for (ItemStack item : Kit.kit.get(Kit.verkit(p)))
		{
		 try{
			 p.getInventory().addItem(item);
		} catch (Exception e) {
		}
		}
		 for (int i = 0; i < 35; i++) {
			  int regen = Integer.parseInt(Config.retornar(p, "kitpvp.regenerar"))/2;
		      p.getInventory().addItem(UtilInv.AddItemReturn(Material.MUSHROOM_SOUP, 1, (byte)0, "§e§lSOPA", "§f§lRegenera " + regen));
		    }
		
		 Scoreboard.CriarScoreboard(p);
		
	}
	
	public boolean Verificar(Player p)
	{
		if (Kit.TemKit(p))
		{
			if (Kit.arena.contains(p))
			{
				Format.Erro("Você já esta numa arena!", p);
				Kit.arena.remove(p);
				Entrar.Give(p);
				return false;
			}
			return true;
		}
		Format.Erro("Você não tem kit para ir para arena!", p);
		return false;
	}


}
