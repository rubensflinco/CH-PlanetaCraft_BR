package me.acf.lobby.gadgets;


import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.perfil.Perfil;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilAction;
import me.hub.API.Util.UtilBlock;
import me.hub.API.Util.UtilEnt;
import me.hub.API.Util.UtilServer;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;

public class JumpMananger
  extends MiniPlugin
{

  
  public JumpMananger(JavaPlugin pl)
  {
    super("Double Jump", pl);
    
  }
  
  @EventHandler
  public void FlightHop(PlayerToggleFlightEvent event)
  {
    Player player = event.getPlayer();
    if (player.getGameMode() == GameMode.CREATIVE) {
      return;
    }
    if (Perfil.DoubleJump.contains(player))
    	return;
    event.setCancelled(true);
    player.setFlying(false);
    player.setAllowFlight(false);

    UtilAction.velocity(player, 1.4D, 0.2D, 1.0D, true);
    
    player.playEffect(player.getLocation(), Effect.BLAZE_SHOOT, 0);
  }
  
  @EventHandler
  public void FlightUpdate(Atualizar event)
  {
    if (event.getType() != ModosUpdate.TICK) {
      return;
    }

    for (Player player : UtilServer.Jogadores())
    {
   
      if (player.getGameMode() != GameMode.CREATIVE) {
        if ((UtilEnt.isGrounded(player)) || (UtilBlock.solid(player.getLocation().getBlock().getRelative(BlockFace.DOWN))))
        {
        	 if (!Perfil.DoubleJump.contains(player)) {
          player.setAllowFlight(true);
          player.setFlying(false);
        	 }
        }
      }
    }
  }
}
