package me.acf.MiniGames.API;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.MiniGames.MiniGamesMananger;
import me.hub.MiniPlugin;

public class Bussola extends MiniPlugin {

	public Bussola(JavaPlugin plugin) {
		super("Bussola", plugin);
		// TODO Auto-generated constructor stub
	}
	
	  int updateInterval;
	  String name;
	  boolean adventureOverride;
	  boolean survivalOverride;
	  boolean creativeOverride;
	  
		@EventHandler
		  public void CliqueBussola(final PlayerInteractEvent e) {
      if ((e.getPlayer().getItemInHand().getType() == Material.COMPASS)&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
          for (Player p : Bukkit.getServer().getOnlinePlayers())
          {
          if (MiniGamesMananger.Vivos.contains(p)){
            Player closest = getClosestPlayer(p);
            if (closest != null) {
              p.setCompassTarget(closest.getLocation());
            } else {
              p.setCompassTarget(p.getWorld().getSpawnLocation());
            }
            if ((p.getItemInHand() != null) && (p.getItemInHand().getType().equals(Material.COMPASS)))
            {
              String pName = closest == null ? "Ninguém !" : closest.getName();
              double distance = closest == null ? 0.0D : closest.getLocation().distance(p.getLocation());
              double deltaH = closest == null ? 0 : p.getLocation().getBlockY() - closest.getLocation().getBlockY();
              ItemMeta meta = p.getItemInHand().getItemMeta();
              meta.setDisplayName("§f§lJogador próximo: §r§e"+pName+"   §f§lDistância: §r§e"+oneDp(distance)+"   §f§lAltura: §r§e"+oneDp(deltaH)+"");
              p.getItemInHand().setItemMeta(meta);
              e.getPlayer().sendMessage("§c§l"+Bukkit.getServerName()+" §f§lJ-P: §r§e"+pName+"   §f§lD: §r§e"+oneDp(distance)+"   §f§lA: §r§e"+oneDp(deltaH)+"");
            }
          }
      	e.setCancelled(true);
          }
      }
  }
		
		@EventHandler
		  public void MoverBussola(final PlayerMoveEvent e) {
	          for (Player p : Bukkit.getServer().getOnlinePlayers())
	          {
	        	  if (MiniGamesMananger.Vivos.contains(p)){
	            Player closest = getClosestPlayer(p);
	            if (closest != null) {
	              p.setCompassTarget(closest.getLocation());
	            } else {
	              p.setCompassTarget(p.getWorld().getSpawnLocation());
	            }
	            if ((p.getItemInHand() != null) && (p.getItemInHand().getType().equals(Material.COMPASS)))
	            {
	              String pName = closest == null ? "Ninguém !" : closest.getName();
	              double distance = closest == null ? 0.0D : closest.getLocation().distance(p.getLocation());
	              double deltaH = closest == null ? 0 : p.getLocation().getBlockY() - closest.getLocation().getBlockY();
	              ItemMeta meta = p.getItemInHand().getItemMeta();
	              meta.setDisplayName("§f§lJogador próximo: §r§e"+pName+"   §f§lDistância: §r§e"+oneDp(distance)+"   §f§lAltura: §r§e"+oneDp(deltaH)+"");
	              p.getItemInHand().setItemMeta(meta);
	              }
	        	  }
	          }
}
	  
	  private String oneDp(double d)
	  {
	    d = Math.round(d * 10.0D);
	    d /= 10.0D;
	    return Double.toString(d);
	  }
	  
	  private Player getClosestPlayer(Player p)
	  {
	    double distance = 3.4028234663852886E38D;
	    Player close = null;
	    for (Player test : Bukkit.getServer().getOnlinePlayers()) {
	      if ((!test.equals(p)) && (test.getWorld().equals(p.getWorld())))
	      {
	        double testDistance = p.getLocation().distanceSquared(test.getLocation());
	        if (testDistance < distance)
	        {
	          distance = testDistance;
	          close = test;
	        }
	      }
	    }
	    return close;
	  }
	  
	  
	
}
