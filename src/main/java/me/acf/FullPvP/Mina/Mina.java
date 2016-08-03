/**
 * 
 */
package me.acf.FullPvP.Mina;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import me.hub.MiniPlugin;

/**
 * @author adriancf
 *
 */
public class Mina extends MiniPlugin {

	
	
	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Mina(JavaPlugin plugin) {
		super("Mina", plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void Minerar(BlockBreakEvent event)
	{
		Block bloco = event.getBlock();
		ItemStack ih = event.getPlayer().getItemInHand();
		for(ProtectedRegion r : WGBukkit.getRegionManager(event.getPlayer().getWorld()).getApplicableRegions(bloco.getLocation())) {
            if (r.getId().contains("mina")) {
            	
            	for (ItemStack item : event.getBlock().getDrops())
            	{
            		if ((ih.getEnchantmentLevel(Enchantment.SILK_TOUCH) >= 1) || (item.getType() == Material.ENDER_CHEST)|| (item.getType() == Material.BOOKSHELF))
            		{
            			event.getPlayer().getInventory().addItem(new ItemStack(bloco.getType(),1,bloco.getData()));
                    	event.setCancelled(true);
                    	event.getPlayer().giveExp(event.getExpToDrop());
                    	event.getBlock().setType(Material.AIR);
            			return;
            		}
            		if (ih.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 1)
            		{
            			
            			if (item.getType().equals(bloco.getType()))
            			{
                			item.setAmount(item.getAmount());
                			event.getPlayer().getInventory().addItem(item);
            			}
            			else {
            			int contia = event.getBlock().getDrops().size() *ih.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
            			item.setAmount(item.getAmount() + contia);
            			event.getPlayer().getInventory().addItem(item);
            			}
            			}
            		else
            		event.getPlayer().getInventory().addItem(item);
            	}
            	event.setCancelled(true);
            	event.getPlayer().giveExp(event.getExpToDrop());
            	event.getBlock().setType(Material.AIR);
                return;
            }
		}


	}
}
