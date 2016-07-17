package me.acf.lobby.extend;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.acf.lobby.gadgets.ViewPlayers;
import me.acf.lobby.perfil.Manager;
import me.acf.servidor.Servidor;
import me.hub.API.Chat;
import me.hub.API.Enchant;
import me.hub.API.Util.BarAPI;
import me.hub.API.Util.UtilEnchant;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilNPC;
import me.hub.API.Util.UtilSound;
import me.hub.API.Util.Sound.Sounds;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Entrar implements Listener {
	
	private boolean Holo = false;
	
	@EventHandler
	public void EventEntrar(final PlayerJoinEvent e)
	{
		
		
		e.setJoinMessage(null);
		

	    Location spawn = Bukkit.getWorld(e.getPlayer().getLocation().getWorld().getName()).getSpawnLocation();
        Scoreboard.CriarScoreboard(e.getPlayer());
	    e.getPlayer().teleport(spawn);
	    e.getPlayer().getInventory().clear();
	    e.getPlayer().setFoodLevel(50000);
        
	    Manager plugin = new Manager(e.getPlayer());
	    plugin.Load();
	    UtilInv.restore(e.getPlayer());
	    Give(e.getPlayer());

        
	    Chat.ActionBar(e.getPlayer(), "§e§l" + "SEJA BEM-VINDO AO LOBBY DO SERVIDOR");
	    e.getPlayer().sendMessage(" ");
	    e.getPlayer().sendMessage("      §f§lSEJA BEM-VINDO; §7§l" + e.getPlayer().getName());
	    e.getPlayer().sendMessage("                 §f§lAO LOBBY §a§l 1");
	    e.getPlayer().sendMessage(" ");
	    UtilSound.playSound(e.getPlayer().getLocation(), Sounds.NOTE_PLING, 1, 0);
	    String text = ChatColor.translateAlternateColorCodes('&', "&aVeja nosso site do servidor &7Click!");
	    
	    BaseComponent[] converted = TextComponent.fromLegacyText(text);
	       
	      TextComponent tc = new TextComponent(converted);
 
          tc.setClickEvent(new ClickEvent(Action.OPEN_URL,"http://planetacraft.com.br/"));
          tc.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aVocê vai para o §7§owww.planetacraft.com.br").create() ) );
          e.getPlayer().spigot().sendMessage(tc);

          Servidor.AddJoin();
          BarAPI.setMessage(e.getPlayer(), "§f§lPLANETACRAFT §6§lMINEGAMES §a§l1.8");
/* 
        Cow hologram = (Cow) e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.COW);
        UtilDisiguise.disguise(hologram, e.getPlayer());
        hologram.remove();
        Maths.CircleEffect(e.getPlayer(), "DRIP_LAVA", 0.0F);
*/
          ViewPlayers.EsconderP(e.getPlayer());
          UtilNPC.AparecerHolo(e.getPlayer());
   	}



	
	
	///Para escrever de tras para frente use Chat.TransParaFrente("MSG")
	
	
	public void Give(Player p)
	{
		
	   	 p.setGameMode(GameMode.ADVENTURE);
		   ItemStack servidores = new ItemStack(Material.COMPASS);
		    ItemMeta rservidores = servidores.getItemMeta();
		    rservidores.setDisplayName("§cServidores");
		    servidores.setItemMeta(rservidores);
		    p.getInventory().setItem(0, servidores);
		    
			   ItemStack lobby = new ItemStack(Material.WATCH);
			    ItemMeta rlobby = lobby.getItemMeta();
			    rlobby.setDisplayName("§eLobby §aCentral");
			    lobby.setItemMeta(rlobby);
			    p.getInventory().setItem(2, lobby);
			      
			    
			    ItemStack pre = new ItemStack(Material.CHEST);
			    ItemMeta rpre = pre.getItemMeta();
			    rpre.setDisplayName("§aGadgets");
			    pre.setItemMeta(rpre);
			    p.getInventory().setItem(4, UtilEnchant.addEnchant(pre, Enchant.DURABILITY, 10));
			    
			    ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
			    SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
			    skullMeta.setOwner(p.getName());
			    skullMeta.setDisplayName("§b" + p.getCustomName());
			    skull.setItemMeta(skullMeta);
		        p.getInventory().setItem(6, skull);
		        
		        ItemStack item = new ItemStack(387, 1);
		        BookMeta meta = (BookMeta)item.getItemMeta();
		        meta.addPage("§m-------------------§r\n"
						+ "Seja Bem-Vindo ao §f§lServidor\n"
						+ "§r§0§l§r§m§0§m-------------------§r§0\n"
						+ "\n"
						+ "§2Por favor, §0tenha um tempo para ler este livro!\n"
						+ "\n"
						+ "\n"
						+ "Parte 1 - Regras\n"
						+ "\n"
						+ "Parte 2 - FAQ\n");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lRegras§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§l1.§r §4Sem§r spam.\n"
						+ "\n"
						+ "§0TEste envio é muitas mensagens ou repetindo a mesma mensagem em um curto período de tempo,.\n");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lRegras§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§l2.§r §4Não§0 abuse de caps.\n"
						+ "\n"
						+ "Este é o envio de mensagens com uma quantidade excessiva de letras maiúsculas.\n");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lRegras§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§l3.§r §4Não§0 utilize hackers (Cheat).\n"
						+ "\n"
						+ "Não toleramos hackers (Cheat,Mods) que deixão o jogador com vantages!\n");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lRegras§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§l4.§r §4Não§0 divulgue links (IPS).\n"
						+ "\n"
						+ "Não use o chat do servidor para divulgar sites,servidores e etec.. Que não seja relacionado ao servidor .\n");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lRegras§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§l6.§r §0Tenha respeito a nossos jogadores e nossa staff.\n");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lRegras§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§rPor favor comunique qualquer erro /programação /exploits ou denuncia.\n"
						+ "§oplanetacraft.com.br");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lFAQ§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§lServidor é piratada e original ?\n"
						+ "\n"
						+ "§r§0Sim. Jogadores piratas com nomes de jogadores original não conseguem entrar"
						+ "\n"
						+ "");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lFAQ§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§lOnde posso comprar VIP (etc..) ?\n"
						+ "\n"
						+ "§r§0Em nossa loja do servidor\n"
						+ "\n"
						+ "§owww.planetacraft.com.br");

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lFAQ§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§lPosso participar da staff ?\n"
						+ "\n"
						+ "§m§rSim você pode mas damos prioridade a jogadores VIP!\n"
						+ "§4§rDivulgamos os links para os testes fique atento"
						+ "\n"
						);

				meta.addPage("§m-------------------\n"
						+ "§r          §2§lFAQ§r§0\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§lSou youtube como tenho a tag ?\n"
						+ "\n"
						+ "§0Entre em contato com nosso suporte skype ou em nosso site:\n"
						+ "Skype: planetacraftbr"
						+ "§oplanetacraft.com.br");

				meta.addPage("§m-------------------\n"
						+ "§r   §6§lObrigado por lê \n\n"
						+ "§m-------------------\n"
						+ "§r\n"
						+ "§0Att _Unix52 (PlanetaCraf)t"
						+ "\n"
						+ "\n"
						+ "\n");


				meta.setTitle("§e§l/Livro");
				meta.setAuthor("Equipe Planetacraft_BR");
			      item.setItemMeta(meta);
			      p.getInventory().setItem(7, item);
			      
			      ItemStack pref = new ItemStack(Material.REDSTONE_COMPARATOR);
				    ItemMeta rpref = pref.getItemMeta();
				    rpref.setDisplayName("§a" + "Preferencias");
				    pref.setItemMeta(rpref);
				    p.getInventory().setItem(8, pref);
					

	}

}
