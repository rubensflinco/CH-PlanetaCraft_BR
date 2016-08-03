package me.acf.lobby.gadgets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.utils.ColorBomb;
import me.acf.lobby.gadgets.utils.EnderTeleport;
import me.acf.lobby.gadgets.utils.Firework;
import me.acf.lobby.gadgets.utils.FleshHook;
import me.acf.lobby.gadgets.utils.FunGun;
import me.acf.lobby.gadgets.utils.MelonBomba;
import me.acf.lobby.gadgets.utils.PaintballGun;
import me.acf.lobby.gadgets.utils.PlanetsBomb;
import me.acf.lobby.gadgets.utils.Tnt;
import me.acf.lobby.gadgets.utils.Trampolim;
import me.acf.lobby.gadgets.utils.Tsunami;
import me.acf.lobby.loja.Loja;
import me.acf.lobby.perfil.Perfil;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Util.UtilActionBar;
import me.hub.API.Util.UtilLocation;
import me.hub.config.Config;

public class Gadgets extends MiniPlugin {

	
	public static Map<String, ItemStack> gadgets = new HashMap<String, ItemStack>();
	public Main main;
	public Gadgets(JavaPlugin plugin) {
		super("Gadgets", plugin);
		PlanetsBomb planets = new PlanetsBomb(plugin);
		ColorBomb colorbomb = new ColorBomb(plugin);
		PaintballGun paintball = new PaintballGun(plugin);
	    Tnt tnt = new Tnt(plugin);
	    MelonBomba melonbomba = new MelonBomba(plugin);
	    EnderTeleport EnderTeleport = new EnderTeleport(plugin);
	    FleshHook fleshHook = new FleshHook(plugin);
	    Firework firework = new Firework(plugin);
	    FunGun fugun = new FunGun(plugin);
	    Mount mount = new Mount(plugin);
	    Trampolim trampolim = new Trampolim(plugin);
        Tsunami tsunami = new Tsunami(plugin);
        Particles particles = new Particles(plugin);
        Morph morph = new Morph(plugin);
        Pet pet = new Pet(plugin);
        Music music = new Music(plugin); 
        Armadura armor = new Armadura(plugin);
        JumpMananger jump = new JumpMananger(plugin);
        Loja loja = new Loja(plugin);
	}

	@EventHandler
	public void Abrir(PlayerInteractEvent e)
	{
		Player jogador = e.getPlayer();
	    if (jogador.getGameMode() == GameMode.CREATIVE)
	      return;
	    if (e.getItem() == null)
	      return;
	    if (e.getItem().getItemMeta().getDisplayName() == null)
	      return;

	    if ((e.getItem().getType() == Material.CHEST) && (e.getItem().getItemMeta().getDisplayName().equals("§aGadgets")))
	    {
	      Menu.GadgetsOPEN(jogador);
	      e.setCancelled(true);
	    }
	}
	
	  @EventHandler
	  public void Iventarioitens(InventoryClickEvent e)
	  {
	    Player jogador = (Player)e.getWhoClicked();
	    try {
	    if ((e.getInventory().getTitle().contains("Personalizar.")) && 
	    	      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	    	    {
	    	      if (e.getSlot() == 22)
	    	      {
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Gadgets"))
	      	        {
	    	    	  e.getInventory().clear();
	    	    	  Menu.Pagina(e.getInventory(), "Gadgets");
	    	    	  }
	    	      }
	    	      if (Gadgets.gadgets.containsKey(e.getCurrentItem().getItemMeta().getDisplayName())){
	    	    	  AtivarGadgets(e.getCurrentItem().getItemMeta().getDisplayName(), jogador);
	    	      }
	    	    }
	    
	  } catch (Exception e1) {
	  }
	  }
	  
	  public static void AddQuantidade(Player jogador, String nome, int valor)
	  {

	      int level = Integer.parseInt(Config.GetGadgets(jogador, nome));
	      level = level + valor;

	      UtilActionBar.ActionBar(jogador, nome + " §9》§a§l" + level+"§9《");
	      Config.SetGadgets(jogador, nome, "" + level);
	  }
	  
	  
	  public static void Quantidade(Player jogador, String nome)
	  {

		  
	      int level = Integer.parseInt(Config.GetGadgets(jogador, nome))-1;
	      Config.SetGadgets(jogador, nome, "" + level);
	      if (level <= 0)
			  {
		    	  jogador.getInventory().setItem(5, null);
		    	  UtilActionBar.ActionBar(jogador, nome + " §4》§c§lACABOU§4《");
		    	  return;
			  }
	      
	      UtilActionBar.ActionBar(jogador, nome + " §9》§a§l" + level+"§9《");
	   
	  }
	  
	  private static void AtivarGadgets(String nome, Player jogador)
	  {
		  ItemStack item2 = (ItemStack)Gadgets.gadgets.get(nome);
		  if ((jogador.getInventory().getItem(5) != null) && (jogador.getInventory().getItem(5).getItemMeta().getDisplayName().contains(item2.getItemMeta().getDisplayName())))
  		{
			  jogador.getInventory().setItem(5, null);
			  MsgFormat("Você desativou o§6 " + nome, jogador);
			  return;
		  }
		  if ((Config.GetGadgets(jogador, nome).equals("0")) || (Config.GetGadgets(jogador, nome).contains("Não encontrado!")))
		  {
			  MsgFormat("Você não tem o§6 " + nome, jogador);
			return;  
		  }
		  jogador.getInventory().setItem(5, (ItemStack)Gadgets.gadgets.get(nome));
		  MsgFormat("Você ativou o§6 " + nome, jogador);
	  }
	  
	  
	  
	  public static void MsgFormat(String message, Player jogador)
	  {
			if (!Perfil.Notification.contains(jogador))
		  jogador.sendMessage("§b§lGadget §e" + message);
	  }
	  
	  
	  public static boolean Area(Location corner1, Location corner2)
	  {
	    if (corner1.getWorld() != corner2.getWorld()) {
	      return false;
	    }
	    World world = corner1.getWorld();
	    for (int x = corner1.getBlockX(); x <= corner2.getBlockX(); x++) {
	      for (int y = corner1.getBlockY(); y <= corner2.getBlockY(); y++) {
	        for (int z = corner1.getBlockZ(); z <= corner2.getBlockZ(); z++)
	        {
	          Location location = new Location(world, x, y, z);
	          Block block = location.getBlock();
	          if (block.getType() != Material.AIR) {
	            return false;
	          }
	          Entity[] arrayOfEntity;
	          int j = (arrayOfEntity = UtilLocation.getNearbyEntities(location, 2)).length;
	          for (int i = 0; i < j; i++)
	          {
	            Entity entity = arrayOfEntity[i];
	            if (((entity instanceof ItemFrame)) || ((entity instanceof Painting))) {
	              return false;
	            }
	          }
	        }
	      }
	    }
	    return true;
	  }
	  
	  public void onClear() {
	        HandlerList.unregisterAll(this);
	    }
}
