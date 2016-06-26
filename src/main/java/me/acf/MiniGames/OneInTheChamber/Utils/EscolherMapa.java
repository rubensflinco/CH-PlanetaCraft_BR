package me.acf.MiniGames.OneInTheChamber.Utils;
 
import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.MiniGames.OneInTheChamber.OneInTheChamber;
import me.hub.Main;
import me.hub.MiniPlugin;

		public class EscolherMapa extends MiniPlugin {
			
			public EscolherMapa(JavaPlugin plugin) {
				super("EscolherMapa", plugin);
				
			}


public static void MenuMapas(Player p)
  {
 Inventory inv = Bukkit.getServer().createInventory(p, 9, "Escolha o Mapa");

   ItemStack portal = new ItemStack(Material.ENDER_PORTAL);
ItemMeta metav = portal.getItemMeta();
metav.setDisplayName("§f");
    portal.setItemMeta(metav);
    int line = -1;
	File backupDir = new File("mapas");
	for (File source : backupDir.listFiles())
	 if (source.isDirectory()) {
		 if (source.getName().contains("world")){
		 }else{
	line++;
	ItemStack mapa1 = new ItemStack(Material.WOOL,1 ,(short)line);
	ItemMeta mapa1meta = mapa1.getItemMeta();
	mapa1meta.setDisplayName("§f"+source.getName()+"");
    ArrayList<String> mapa1des = new ArrayList();
    mapa1des.add("§c§lVotos");
		String GET = OneInTheChamber.VotosMapa.get(source.getName());
		if (GET == null){
    mapa1des.add("§f"+0);
		}else{
	mapa1des.add("§f"+GET);
		}
    mapa1des.add("§f§l ");
    mapa1des.add("§6§lModo(Dificuldade)");
    mapa1des.add("§f"+Main.plugin.getConfig().getString(""+source.getName()+".Modo"));
    mapa1des.add("§f§l ");
    mapa1des.add("§e§lTempo(Clima)");
    mapa1des.add("§f"+Main.plugin.getConfig().getString(""+source.getName()+".Tempo"));
    mapa1des.add("§f§l ");
    mapa1meta.setLore(mapa1des);
    mapa1.setItemMeta(mapa1meta);
     inv.setItem(line, mapa1);
    }}
    p.openInventory(inv);
    p.playSound(p.getLocation(), Sound.NOTE_BASS, 40.0F, 1.0F);
    
  }
   
   @EventHandler
   public void onPlayerCLickInventry(InventoryClickEvent e)
   {
     Player p = (Player)e.getWhoClicked();
     if ((e.getInventory().getTitle().equalsIgnoreCase("Escolha o Mapa")) && 
       (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
     {
    	 
    	 e.setCancelled(true);
    	 
    		File backupDir = new File("mapas");
    		for (File source : backupDir.listFiles())
    		 if (source.isDirectory()) {
    			 if (source.getName().contains("world")){
    			 }else{
         if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f"+source.getName()+""))
       {
         e.setCancelled(true);
         String mapa = ""+OneInTheChamber.VotouMapa.get(p.getName())+"";
     	if (mapa.equals(source.getName())){
    		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
    		p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Você ja votou no "+source.getName()+"!");
  	}
    	else
    	{
    		if (!Main.plugin.getConfig().getString(""+source.getName()+".Nome").contains("Sem Nome")){
    			
            if (Main.plugin.getConfig().getString(""+source.getName()+".Tempo").equals("Dia")){
            	Bukkit.getWorld(Main.plugin.getConfig().getString(""+source.getName()+".Nome")).setTime(500);
            }
            if (Main.plugin.getConfig().getString(""+source.getName()+".Tempo").equals("Tarde")){
            	Bukkit.getWorld(Main.plugin.getConfig().getString(""+source.getName()+".Nome")).setTime(12500);
            }
            if (Main.plugin.getConfig().getString(""+source.getName()+".Tempo").equals("Noite")){
            	Bukkit.getWorld(Main.plugin.getConfig().getString(""+source.getName()+".Nome")).setTime(20000);
            }
		    Location l = new Location(Bukkit.getServer().getWorld(Main.plugin.getConfig().getString(""+source.getName()+".Nome")), Main.plugin.getConfig().getInt("Espectador."+source.getName()+".X"), Main.plugin.getConfig().getInt("Espectador."+source.getName()+".Y"), Main.plugin.getConfig().getInt("Espectador."+source.getName()+".Z"));
		    p.teleport(l);
			 if (!OneInTheChamber.EscolherMapa.contains(p)) {
			 p.setGameMode(GameMode.SPECTATOR);
		     p.setMaxHealth(20);
		     p.setHealth(20);
		     p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0F, 1.0F); 
			 OneInTheChamber.EscolherMapa.remove(p);
			 OneInTheChamber.EscolherMapa.add(p);
		      }
		    
	     	String GET1 = OneInTheChamber.VotosMapa.get(mapa);
     		if (GET1 == null){
             	int votos2 = 0;
             	OneInTheChamber.VotosMapa.put(""+mapa, ""+votos2);
         		}else{
         		int votos2 = Integer.parseInt(GET1)-1;
         		OneInTheChamber.VotosMapa.put(""+mapa, ""+votos2);
         		}
	      	
		    
     		OneInTheChamber.VotouMapa.put(""+p.getName(), ""+source.getName());
     		String GET = OneInTheChamber.VotosMapa.get(source.getName());
     		if (GET == null){
         	int votos1 = 0+1;
         	OneInTheChamber.VotosMapa.put(""+source.getName(), ""+votos1);
     		}else{
     		int votos1 = Integer.parseInt(GET)+1;
     		OneInTheChamber.VotosMapa.put(""+source.getName(), ""+votos1);
     		}
      p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 10.0F, 1.0F);
      p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Você votou no : §f "+Main.plugin.getConfig().getString(""+source.getName()+".Nome")+" §7!");
    	 }
    		else
    		{
        		p.playSound(p.getLocation(), Sound.ANVIL_LAND, 10.0F, 1.0F);
        		p.sendMessage("§5§l"+ Bukkit.getServerName() +" §7Esse Mapa esta offline !");
    		}
    	}
         return;
       }
         
     }}
         

              return;
       }

    }
   
 }
