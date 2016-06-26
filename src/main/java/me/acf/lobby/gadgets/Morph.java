package me.acf.lobby.gadgets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.morph.Chicken;
import me.acf.lobby.gadgets.morph.Cow;
import me.acf.lobby.gadgets.morph.Enderman;
import me.acf.lobby.gadgets.morph.Pig;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.UtilDisiguise;
import me.hub.config.Config;
import me.libraryaddict.disguise.DisguiseAPI;

public class Morph extends MiniPlugin  {

	
	public static Map<Player, String> MophU = new HashMap<Player, String>();
	public static Map<String, ItemStack> gadgets = new HashMap<String, ItemStack>();
	public Main main;
	public Morph(JavaPlugin plugin) {
		super("MophUs", plugin);
         Cow cow = new Cow(plugin);
         Enderman end = new Enderman(plugin);
         Pig pig = new Pig(plugin);
         Chicken chick = new Chicken(plugin);
	}
	
    
    @EventHandler
    public void onUpdate(PlayerQuitEvent e)
    {
    	MophU.remove(e.getPlayer());
    }
    
    
	  @EventHandler
	  public void Iventarioitens(InventoryClickEvent e)
	  {
	    Player jogador = (Player)e.getWhoClicked();
	    if (jogador.getGameMode() == GameMode.CREATIVE)
		      return;
	    try {
	    if ((e.getInventory().getTitle().contains("Personalizar.")) && 
	    	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	    	    {
	    	      if (e.getSlot() == 17)
	    	      {
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Morph"))
	      	        {
	    	    	  e.getInventory().clear();
	    	    	  
	    	    	  Menu.Pagina(e.getInventory(), "Morph");
	    	    	  }
	    	      
	    	      }

	    	    }
	    } catch (Exception e1) {
		  }
	  }
	  

	  
	  public static void AtivarGadgets(String nome, Player jogador, Entity ent)
	  {
		  if (!Morph.MophU.containsKey(jogador)) {
			  if (Config.GetMorph(jogador, nome).equals("nao"))
			  {
				  jogador.sendMessage("§cVocê não tem o " + nome);
				  return;
			  }
		 Morph.MophU.put(jogador, nome);

		 Gadgets.MsgFormat("Você ativou o morph " + nome, jogador);
	       UtilDisiguise.disguise(ent, jogador);
		  }
		  else
		  {
			  if (Morph.MophU.get(jogador).equals(nome))
			  {
				  Morph.MophU.remove(jogador);
				  Gadgets.MsgFormat("Você removeu o efeito " + nome, jogador);
				  if (DisguiseAPI.isDisguised(jogador))
		                DisguiseAPI.undisguiseToAll(jogador);
		                
				  return;
			  }
			  Gadgets.MsgFormat("Você já esta usando um morph (" + Morph.MophU.get(jogador) + ")", jogador);
		  }
	  }
	  

	  
}
