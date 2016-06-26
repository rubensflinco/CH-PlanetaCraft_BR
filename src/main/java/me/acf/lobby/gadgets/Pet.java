package me.acf.lobby.gadgets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.pet.PetChicken;
import me.acf.lobby.gadgets.pet.PetCow;
import me.acf.lobby.gadgets.pet.PetSheep;
import me.acf.lobby.gadgets.pet.PetZombie;
import me.acf.lobby.perfil.Perfil;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.config.Config;
import me.libraryaddict.disguise.DisguiseAPI;

public class Pet extends MiniPlugin  {

	
	public static Map<Player, String> Pet = new HashMap<Player, String>();
	public static Map<String, ItemStack> gadgets = new HashMap<String, ItemStack>();
	public static Map<String, Entity> Pets = new HashMap<String, Entity>();
	public static boolean iniciando = true;
	public Main main;
	public Pet(JavaPlugin plugin) {
		super("Pet", plugin);
      PetCow cow = new PetCow(plugin);
      PetZombie zombie = new PetZombie(plugin);
      PetSheep slime = new PetSheep(plugin);
      PetChicken chick = new PetChicken(plugin);
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
	    	      if (e.getSlot() == 27)
	    	      {
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Pet"))
	      	        {
	    	    	  e.getInventory().clear();
	    	    	  
	    	    	  Menu.Pagina(e.getInventory(), "Pet");
	    	    	  }
	    	      
	    	      }
	    	      if (gadgets.containsKey(e.getCurrentItem().getItemMeta().getDisplayName())){
	    	    	  AtivarGadgets(e.getCurrentItem().getItemMeta().getDisplayName(), jogador);
	    	      }

	    	    }
	    } catch (Exception e1) {
		  }
	  }
	  
	  @EventHandler
	  public void entrar(PlayerJoinEvent e)
	  {
	      iniciando = false;
	     System.out.print( "Pet remove "+ iniciando);
	     if (!Config.GetPet(e.getPlayer(), "Pet.use").equals("nao"))
	     {
	    	 Pet.put(e.getPlayer(), Config.GetPet(e.getPlayer(), "Pet.use"));
	     }
	  }
	  
	  public static void AtivarGadgets(String nome, Player jogador)
	  {
		  if (!Pet.containsKey(jogador)) {
			  if (Config.GetPet(jogador, nome).contains("nao"))
			  {
				  Gadgets.MsgFormat("Você não tem o§6 " + nome, jogador);
				  return;
			  }
		 Pet.put(jogador, nome);
		Config.Set(jogador, "Pet.use", nome);
         if (nome.contains("Cow"))
        	 PetCow.AddEnt(jogador);
         if (nome.contains("Zombie"))
        	 PetZombie.AddEnt(jogador);
         if (nome.contains("Chicken"))
        	 PetChicken.AddEnt(jogador);
         if (nome.contains("Sheep"))
        	 PetSheep.AddEnt(jogador);
		 Gadgets.MsgFormat("Você ativou o pet " + nome, jogador);
	
		  }
		  else
		  {
			  if (Pet.get(jogador).equals(nome))
			  {
				  Pet.remove(jogador);
				  Gadgets.MsgFormat("Você removeu o pet " + nome, jogador);
				  me.hub.API.pet.Pet.Pets.get(jogador.getName()).remove();
				  me.hub.API.pet.Pet.Pets.remove(jogador.getName());
				  return;
			  }
			  Gadgets.MsgFormat("Você já esta usando um pet.", jogador);
		  }
	  }
	  

	  
}
