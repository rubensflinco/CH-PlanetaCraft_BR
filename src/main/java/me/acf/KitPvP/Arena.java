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
	
	@EventHandler
	public void Click(PlayerInteractEntityEvent event)
	{
	    if ((event.getRightClicked() instanceof ArmorStand) || (event.getRightClicked() instanceof Sheep)) {{
		  if (Verificar(event.getPlayer()))
		  {
			  if (event.getRightClicked().getCustomName() == null)
				  return;
			  
		    if (event.getRightClicked().getCustomName().contains("Arena 1"))
		    {
				  PVP.arena1.add(event.getPlayer());
				  Kit.arena.add(event.getPlayer());
				  GiveKit(event.getPlayer());
				  Random r = new Random();
		    	  Arena1(event.getPlayer(),r.nextInt(5));
		    	  event.getRightClicked().setCustomName("§5§lArena 1 §f"+PVP.arena1.size()+"/∞");
		    	
		    }
		    if (event.getRightClicked().getCustomName().contains("Arena 2"))
		    {
				  PVP.arena2.add(event.getPlayer());
				  Kit.arena.add(event.getPlayer());
				  GiveKit(event.getPlayer());
				  Random r = new Random();
		    	  Arena2(event.getPlayer(),r.nextInt(5));
		    	  event.getRightClicked().setCustomName("§5§lArena 2 §f"+PVP.arena2.size()+"/∞");
		    	
		    }
		    if (event.getRightClicked().getCustomName().contains("Arena 3"))
		    {
				  PVP.arena3.add(event.getPlayer());
				  Kit.arena.add(event.getPlayer());
				  GiveKit(event.getPlayer());
				  Random r = new Random();
		    	  Arena3(event.getPlayer(),r.nextInt(5));
		    	  event.getRightClicked().setCustomName("§5§lArena 3 §f"+PVP.arena3.size()+"/∞");
		    	
		    }
		  }
		}
	    }
	}
	

	public void GiveKit(Player p)
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

/*     Cords da Arena 1 Spawns
       1504, 73, 1524
	   1522, 76, 1456
	   1437, 75, 1474
       1604, 83, 151  
       1660, 81, 1476
	   1414, 84, 1634
*/
	public void Arena1(Player p, int aleatorio)
	{
		if (aleatorio <= 1)
			p.teleport(new Location(p.getWorld(), 1504, 79, 1524));
		if (aleatorio == 2)
			p.teleport(new Location(p.getWorld(), 1522, 78, 1456));
		if (aleatorio == 3)
			p.teleport(new Location(p.getWorld(), 1437, 78, 1474));
		if (aleatorio == 4)
			p.teleport(new Location(p.getWorld(), 1660, 89, 1476));
		if (aleatorio == 5)
			p.teleport(new Location(p.getWorld(), 1414, 85, 1634));
	}
	
	public void Arena2(Player p, int aleatorio)
	{
		p.teleport(new Location(p.getWorld(), 35000, 78, 35000));
	}
	public void Arena3(Player p, int aleatorio)
	{
		p.teleport(new Location(p.getWorld(), -65078, 87, -64883));
	}
}
