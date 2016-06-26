/**
 * 
 */
package me.acf.lobby.gadgets.armor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.acf.FormatText.Format;
import me.acf.lobby.gadgets.Gadgets;
import me.hub.API.Enchant;
import me.hub.config.Config;

/**
 * @author adriancf
 *
 */
public class Armor {

	public static HashMap<Integer, ItemStack> armor = new HashMap<>();
	public static HashMap<ItemStack,Inventory> ver = new HashMap<>();
	
    private static void AddItem(Inventory inv, boolean encantado, Material item,int contidade, byte data, String nome, int slot)
    {
    	      ItemStack bau = new ItemStack(item, contidade , data);
    	      ItemMeta metae = bau.getItemMeta();
    	      metae.setDisplayName("§a" + nome);
    	      metae.setLore(Arrays.asList(new String[] {  "","§3","§7>> Tipo: §9Lendario §7<<" }));
    	      bau.setItemMeta(metae);
    	      armor.put(slot, bau);
    	      ver.put(bau, inv);
    	      if (encantado)
    	      inv.setItem(slot, Enchant.addGlow(bau));
    	      else
    	          inv.setItem(slot, bau);
    }
    private static void AddItem(Inventory inv, boolean encantado, Material item,int contidade, byte data,String nome, String meta, int slot)
    {
    	      ItemStack bau = new ItemStack(item, contidade , data);
    	      ItemMeta metae = bau.getItemMeta();
    	      metae.setDisplayName(nome);
    	      ArrayList<String> desce = new ArrayList();
    	      desce.add(meta);
    	      metae.setLore(desce);
    	      bau.setItemMeta(metae);
    	      if (encantado)
    	      inv.setItem(slot, Enchant.addGlow(bau));
    	      else
    	          inv.setItem(slot, bau);
    }
    
    public static void Vestir(ItemStack item,Player jogador)
    {
    	if (ver.containsKey(item)) {
    		if (Config.GetArmor(jogador, item.getItemMeta().getDisplayName()).equals("nao"))
    		{
    			  Gadgets.MsgFormat("Você não tem o§6 " + item.getItemMeta().getDisplayName(), jogador);
    			return;
    		}
    	if (item.getItemMeta().getDisplayName().contains("§aCapacete"))
    	{
    		try {
    		if (jogador.getInventory().getHelmet().equals(item))
    		{
    			jogador.playSound(jogador.getLocation(), Sound.HORSE_SADDLE, 0.1F, 0.1F);
    			jogador.getInventory().setHelmet(null);
    	    	Gadgets.MsgFormat("Você removeu o " + item.getItemMeta().getDisplayName(), jogador);
    			return;
    		}
    		   } catch (Exception e1) {}
    		jogador.getInventory().setHelmet(item);
    	}
    	if (item.getItemMeta().getDisplayName().contains("§aPeitoral"))
    	{
    		try {
    		if (jogador.getInventory().getChestplate().equals(item))
    		{
    			jogador.playSound(jogador.getLocation(), Sound.HORSE_SADDLE, 0.1F, 0.1F);
    	    	Gadgets.MsgFormat("Você removeu o " + item.getItemMeta().getDisplayName(), jogador);
    	 		jogador.getInventory().setChestplate(null);
    	    	return;
    		}
    	    } catch (Exception e1) {}
    		jogador.getInventory().setChestplate(item);
    	}
    	if (item.getItemMeta().getDisplayName().contains("§aCalça"))
    	{
    		try {
    		if (jogador.getInventory().getLeggings().equals(item))
    		{
    			jogador.playSound(jogador.getLocation(), Sound.HORSE_SADDLE, 0.1F, 0.1F);
    	    	Gadgets.MsgFormat("Você removeu o " + item.getItemMeta().getDisplayName(), jogador);
    	    	jogador.getInventory().setLeggings(null);
    	    	return;
    		}
    		   } catch (Exception e1) {}
    		jogador.getInventory().setLeggings(item);
    	}
    	if (item.getItemMeta().getDisplayName().contains("§aBota"))
    	{
    		try {
    		if (jogador.getInventory().getBoots().equals(item))
    		{
    			jogador.playSound(jogador.getLocation(), Sound.HORSE_SADDLE, 0.1F, 0.1F);
    	    	Gadgets.MsgFormat("Você removeu o " + item.getItemMeta().getDisplayName(), jogador);
    	    	jogador.getInventory().setBoots(null);
    	    	return;
    		}
    		   } catch (Exception e1) {}
    		jogador.getInventory().setBoots(item);
    	}
    	
    	jogador.playSound(jogador.getLocation(), Sound.HORSE_SADDLE, 0.1F, 0.1F);
    	Gadgets.MsgFormat("Você vestiu o " + item.getItemMeta().getDisplayName(), jogador);
    }
    }
    
    public static void Criar(Inventory inv)
    {
    	 AddItem(inv, false, Material.GOLD_HELMET,1,(byte) 0, "Capacete de Ouro", 19);
    	 AddItem(inv, false, Material.IRON_HELMET,1,(byte) 0, "Capacete de Ferro", 20);
    	 AddItem(inv, false, Material.DIAMOND_HELMET,1,(byte) 0, "Capacete de Diamante", 21);
    	 AddItem(inv, false, Material.CHAINMAIL_HELMET,1,(byte) 0, "Capacete de Chainmail", 22);
    	 AddItem(inv, false, Material.GOLD_CHESTPLATE,1,(byte) 0, "Peitoral de Ouro", 28);
    	 AddItem(inv, false, Material.IRON_CHESTPLATE,1,(byte) 0, "Peitoral de Ferro", 29);
    	 AddItem(inv, false, Material.DIAMOND_CHESTPLATE,1,(byte) 0, "Peitoral de Diamante", 30);
    	 AddItem(inv, false, Material.CHAINMAIL_CHESTPLATE,1,(byte) 0, "Peitoral de Chainmail", 31);
    	 AddItem(inv, false, Material.GOLD_LEGGINGS,1,(byte) 0, "Calça de Ouro", 37);
    	 AddItem(inv, false, Material.IRON_LEGGINGS,1,(byte) 0, "Calça de Ferro", 38);
    	 AddItem(inv, false, Material.DIAMOND_LEGGINGS,1,(byte) 0, "Calça de Diamente", 39);
    	 AddItem(inv, false, Material.CHAINMAIL_LEGGINGS,1,(byte) 0, "Calça de Chainmail", 40);
    	 AddItem(inv, false, Material.GOLD_BOOTS,1,(byte) 0, "Bota de Ouro", 46);
    	 AddItem(inv, false, Material.IRON_BOOTS,1,(byte) 0, "Bota de Ferro", 47);
    	 AddItem(inv, false, Material.DIAMOND_BOOTS,1,(byte) 0, "Bota de Diamante", 48);
    	 AddItem(inv, false, Material.CHAINMAIL_BOOTS,1,(byte) 0, "Bota de Chainmail", 49);
    	 for (int slot_Inicial = 18; slot_Inicial < 54; slot_Inicial++)
	        {
    		 if (!armor.containsKey(slot_Inicial))
      	 AddItem(inv, false, Material.INK_SACK,1,(byte) 8, "§c??", "", slot_Inicial);
      }
    }
}


