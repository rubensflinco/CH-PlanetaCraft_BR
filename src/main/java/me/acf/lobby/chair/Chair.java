package me.acf.lobby.chair;

import java.util.ArrayList;
import java.util.List;

import me.hub.MiniPlugin;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Stairs;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Chair extends MiniPlugin {

	public double sittingheight, distance;
	public boolean sneaking, autorotate, signcheck;
	public int maxchairwidth;
	
	public Chair(JavaPlugin plugin) {
		super("Chair", plugin);
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.hasBlock() && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block block = event.getClickedBlock();
			
			if (block.getTypeId() == 134) {
				Player player = event.getPlayer();
				Stairs stairs = (Stairs)block.getState().getData();
				int chairwidth = 1;
				
				// Check if block beneath chair is solid.
				if(block.getRelative(BlockFace.DOWN).getTypeId() == 0)
					return;
				
				// Check if player is sitting.
				if(!player.isSneaking() && player.getVehicle() != null) {
					player.getVehicle().remove();
					return;
				}
				
				
				Arrow arrow = player.getWorld().spawn(event.getClickedBlock().getLocation().clone().add(0.5,0,0.5), Arrow.class); 
				arrow.setPassenger(event.getPlayer());
                arrow.setCustomName("§cBanco");
//                player.playEffect(player.getLocation(), Effect.RECORD_PLAY, Material.RECORD_3.getId());
				}
			}
		}
	
	
	
	

}