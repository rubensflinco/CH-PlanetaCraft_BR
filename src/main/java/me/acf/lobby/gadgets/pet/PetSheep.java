/**
 * 
 */
package me.acf.lobby.gadgets.pet;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Slime;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.loader.PetLoader;


/**
 * @author adriancf
 *
 */
public class PetSheep extends PetLoader

{
	
	
public PetSheep(JavaPlugin plugin) {
	super("§aPetSheep", plugin, Material.WOOL,2 ,"§eTenha uma slime como seu animal.");
	}


public static void AddEnt(Player p)
{
	 Sheep entity = (Sheep)Bukkit.getWorld("world").spawnEntity(Bukkit.getWorld("world").getSpawnLocation(), EntityType.SHEEP);
     entity.setBaby();
      me.hub.API.pet.Pet.createPet(p, entity);
      
}


}
