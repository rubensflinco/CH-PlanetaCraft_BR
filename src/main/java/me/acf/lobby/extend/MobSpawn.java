package me.acf.lobby.extend;

import java.util.Random;

import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.Vector;

import me.site.account.Account;
import me.site.account.rank.Rank;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

public class MobSpawn implements Listener {
	
	public static boolean NoAI = false;
	
	@EventHandler
	public void Mob(CreatureSpawnEvent e)
	{
	
		
		if ((e.getEntity().getType() == EntityType.ARMOR_STAND) || (e.getEntity().getType() == EntityType.PLAYER))
	   return;
  
		if ((e.getEntity().getType() == EntityType.COW) || (e.getEntity().getType() == EntityType.HORSE) || (e.getEntity().getType() == EntityType.PIG)|| (e.getEntity().getType() == EntityType.RABBIT) || (e.getEntity().getType() == EntityType.SHEEP) || (e.getEntity().getType() == EntityType.ARROW) || (e.getEntity().getType() == EntityType.CHICKEN)) 
		{
			e.getEntity().setCustomName("§f§l" + e.getEntity().getName());
			e.getEntity().setCustomNameVisible(true);
			return;
		}
     if (NoAI)
        noAI(e.getEntity());

	}
	
	

	@EventHandler
	public void Entity(PlayerInteractEntityEvent e)
	{
		if (e.getRightClicked().hasMetadata("PET"))
		{
			return;
		}
	    if ((e.getRightClicked() instanceof Cow))
	    {
	    	e.getRightClicked().setPassenger(e.getPlayer());
	    
	    }
	    if ((e.getRightClicked() instanceof Rabbit))
	    {
	    	e.getRightClicked().setPassenger(e.getPlayer());
	    
	    }
	    if (e.getPlayer().getGameMode() == GameMode.CREATIVE)
	    {
	    	if (Account.getRank(e.getPlayer()).Has(e.getPlayer(), Rank.DEV, true))
	    	{
	    		   if ((e.getRightClicked() instanceof Player))
	    			   return;
	    		   
	    		e.getRightClicked().remove();
	    		    
	    	}
	    }
	}
	
	@EventHandler
	public void HitMob(EntityDamageEvent e)
	{

		if (e.getEntity().hasMetadata("PET"))
		{
			return;
		}
		if (e.getEntityType() == EntityType.SHEEP)		
		{
			       Random r = new Random();
			       ((Sheep)e.getEntity()).setColor(DyeColor.getByData((byte) r.nextInt(16)));
			       ((Sheep)e.getEntity()).setCustomName("§f§lSheep");
			       ((Sheep)e.getEntity()).setBaby();
			   
		}
		else
		if (e.getEntityType() == EntityType.COW)
		{
			
			
			if (e.getEntity().getName().contains("Baby"))
			{
				((Cow)e.getEntity()).setAdult();
				((Cow)e.getEntity()).setCustomName("§f§lCow Adult");
	            e.setCancelled(true);
			}
			else
			{

			((Cow)e.getEntity()).setBaby();
            ((Cow)e.getEntity()).setCustomName("§f§lCow Baby");
            e.setCancelled(true);
			}           
		}
		else
		if (e.getEntityType() == EntityType.RABBIT)
		{
            e.setCancelled(true);
            e.getEntity().setVelocity(new Vector(e.getEntity().getVelocity().getY(), 0.3D, e.getEntity().getVelocity().getZ()));
		}    
		if (e.getEntityType() == EntityType.ARMOR_STAND)
		{
			e.setCancelled(false);
		}
		else
			e.setCancelled(true);
		
	}
	
	
	public static void noAI(Entity bukkitEntity) {
	    net.minecraft.server.v1_8_R3.Entity nmsEntity = ((CraftEntity) bukkitEntity).getHandle();
	    NBTTagCompound tag = nmsEntity.getNBTTag();
	    if (tag == null) {
	        tag = new NBTTagCompound();
	    }
	    nmsEntity.c(tag);
	    tag.setInt("NoAI", 1);
	    tag.setInt("Silent", 1);
	    nmsEntity.f(tag);
	}
}
