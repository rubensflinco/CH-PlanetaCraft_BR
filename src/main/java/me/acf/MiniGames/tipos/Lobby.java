/**
 * 
 */
package me.acf.MiniGames.tipos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.plugin.java.JavaPlugin;

import me.hub.MiniPlugin;
import me.hub.API.Util.BlockText;

/**
 * @author adriancf
 *
 */
public class Lobby extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	  private Location _gameText;
	  
	public Lobby(JavaPlugin plugin) {
		super("LobbyGame", plugin);
		World world = Bukkit.getWorld("world");
		world.setTime(6000L);
	    world.setStorm(false);
	    world.setThundering(false);
	    world.setGameRuleValue("doDaylightCycle", "false");
	    world.setAutoSave(false);
	    this._gameText = new Location(world, 0.0D, 130.0D, 50.0D);
	    
	}
	
	
	  public void WriteGameLine(String text, int line, int id, byte data)
	  {
	    Location loc = new Location(this._gameText.getWorld(), this._gameText.getX(), this._gameText.getY(), this._gameText.getZ());
	    if (line > 0) {
	      loc.add(0.0D, line * -6, 0.0D);
	    }
	    BlockFace face = BlockFace.WEST;
	    
	    BlockText.MakeText(text, loc, face, id, data, BlockText.TextAlign.CENTRO, false, false);
	  }
	  
	  
	  public static void CriarBase(Location loc, int data)
	  {
		  SetBlock(loc.clone().add(0.5D,0,0.5D), data);
		  SetBlock(loc.clone().add(-0.5D,0,0.5D), data);
		  SetBlock(loc.clone().add(0.5D, 0.0D, -0.5D), data);
		  SetBlock(loc.clone().add(-0.5D,0,-0.5D), data);
		  SetBlock(loc.clone().add(0.5D,1,0.5D), 44,5);
		  SetBlock(loc.clone().add(-0.5D,1,0.5D), 44,5);
		  SetBlock(loc.clone().add(0.5D, 1.0D, -0.5D), 44,5);
		  SetBlock(loc.clone().add(-0.5D,1,-0.5D), 44,5);
	  }

	  private static void SetBlock(Location loc, int data)
	  {
		  loc.getBlock().setTypeId(159);
		  loc.getBlock().setData((byte) data);
	  }
	  private static void SetBlock(Location loc, int id,int data)
	  {
		  loc.getBlock().setTypeId(id);
		  loc.getBlock().setData((byte) data);
	  }
}
