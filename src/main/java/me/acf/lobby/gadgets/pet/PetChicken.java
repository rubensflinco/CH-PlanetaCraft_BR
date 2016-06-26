/**
 * 
 */
package me.acf.lobby.gadgets.pet;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.acf.lobby.gadgets.Menu;
import me.acf.lobby.gadgets.Morph;
import me.acf.lobby.gadgets.loader.GadGetsLoader;
import me.acf.lobby.gadgets.loader.MorphLoader;
import me.acf.lobby.gadgets.loader.PetLoader;
import me.hub.API.pet.Pet;
import me.hub.recharge.Recharge;


/**
 * @author adriancf
 *
 */
public class PetChicken extends PetLoader

{
	
	
public PetChicken(JavaPlugin plugin) {
	super("§aPetChicken", plugin, Material.EGG,0 ,"§eTenha uma galinha como seu animal.");
	}

public static void AddEnt(Player p)
{
	  Chicken entity = (Chicken)Bukkit.getWorld("world").spawnEntity(p.getLocation(), EntityType.CHICKEN);
      entity.setBaby();
      me.hub.API.pet.Pet.createPet(p, entity);
      
}



}
