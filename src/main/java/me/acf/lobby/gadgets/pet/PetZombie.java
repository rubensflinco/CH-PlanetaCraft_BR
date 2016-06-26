/**
 * 
 */
package me.acf.lobby.gadgets.pet;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.loader.PetLoader;


/**
 * @author adriancf
 *
 */
public class PetZombie extends PetLoader

{
	
	
public PetZombie(JavaPlugin plugin) {
	super("§aPetZombie", plugin, Material.ROTTEN_FLESH,0 ,"§eTenha um zumbi como seu animal.");
	}


public static void AddEnt(Player p)
{
	 Zombie entity = (Zombie)Bukkit.getWorld("world").spawnEntity(Bukkit.getWorld("world").getSpawnLocation(), EntityType.ZOMBIE);
     entity.setBaby(true);
      me.hub.API.pet.Pet.createPet(p, entity);
      
}
}
