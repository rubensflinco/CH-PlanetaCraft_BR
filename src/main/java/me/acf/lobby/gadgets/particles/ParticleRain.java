/**
 * 
 */
package me.acf.lobby.gadgets.particles;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.Particles;
import me.acf.lobby.gadgets.loader.ParticleLoader;
import me.hub.API.Util.UtilParticles;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;



/**
 * @author adriancf
 *
 */
public class ParticleRain extends ParticleLoader {

    boolean x = true;
    boolean o = false;
   public ParticleRain(JavaPlugin plugin)
   {
		super(false,"§bParticleRain", plugin, Material.WATER_BUCKET,0, "§eCriei uma nuvem.");
   }
	
    @EventHandler
    public void onUpdate(Atualizar e)
    {
      if (e.getType() == ModosUpdate.TICK)
      {
          for (Player player : Particles.Particle.keySet()) {
        	  if (Particles.Particle.get(player).equals(GetName()))
        	  {
          	if (Particles.isMoving(player))
          	{
          	
          		
          		 UtilParticles.display(me.hub.API.Util.Particles.CLOUD, 0.6f, 0.1f, 0.6f, player.getLocation().add(0, 3.5, 0), 8);
          		UtilParticles.display(me.hub.API.Util.Particles.DRIP_WATER, 0.4f, 0.1f, 0.4f, player.getLocation().add(0, 3.5, 0), 2);
          		UtilParticles.display(me.hub.API.Util.Particles.EXPLOSION_NORMAL, 0.6f, 0.1f, 0.6f, player.getLocation().add(0, 3.5, 0), 8);
          	}
          	else
          	{
          		UtilParticles.display(me.hub.API.Util.Particles.SNOWBALL, 0.6f, 0.1f, 0.6f, player.getLocation().add(0, 1, 0), 2);
          	}
        	  }
          }
      }
    }
    
    public static void ParticleRain()
    {
    	
    }
}
