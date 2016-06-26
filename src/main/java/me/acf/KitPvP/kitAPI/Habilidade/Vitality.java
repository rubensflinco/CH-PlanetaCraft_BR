/**
 * 
 */
package me.acf.KitPvP.kitAPI.Habilidade;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.KitPvP.kitAPI.Kit;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilInv;

/**
 * @author adriancf
 *
 */
public class Vitality extends MiniPlugin{

	
	  /**
	 * @param moduleName
	 * @param plugin
	 */
	public Vitality(JavaPlugin plugin) {
		super("Kit Vitality", plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	  public void QuandoMatar(PlayerDeathEvent e)
	  {
	    if ((e.getEntity().getKiller() instanceof Player))
	    {
	      Player k = e.getEntity().getKiller();
	      if (Kit.PoderUsar(k, "vitality"))
	      {
	        k.getInventory().remove(Material.BOWL);
	        try
	        {
	          for (int i = 0; i < 36; i++)
	          {
	              k.getInventory().setItem(k.getInventory().firstEmpty(), UtilInv.AddItemReturn(Material.MUSHROOM_SOUP,1 , (byte)1, "§a§lSopa", ""));
	          }
	        }
	        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {}
	        k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	        return;
	      }
	    }
	  }
}
