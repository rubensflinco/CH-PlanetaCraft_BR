/**
 * 
 */
package me.acf.KitPvP;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import me.acf.KitPvP.armor.Armor;
import me.acf.KitPvP.kitAPI.Kit;
import me.acf.KitPvP.scoreboard.Scoreboard;
import me.acf.servidor.Servidor;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.API.Chat;
import me.hub.API.Util.UtilHolo;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilServer;
import me.hub.config.Config;
import me.site.account.Account;
import me.site.account.AccountWeb;
import me.site.account.rank.Rank;

/**
 * @author adriancf
 *
 */
public class Entrar extends MiniPlugin {

	/**
	 * @param moduleName
	 * @param plugin
	 */
	public Entrar(JavaPlugin plugin) {
		super("Kit-PvP Entrar", plugin);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Player> joins = new ArrayList<>();
	public int evento = 100;
	
	@EventHandler
	public void Entrar(final PlayerJoinEvent event)
	{
		
		event.setJoinMessage(null);
		
		Chat.ActionBar(event.getPlayer(), "§e§l" + "SEJA BEM-VINDO AO KITPVP DO PLANETACRAFT_BR");
		 event.getPlayer().sendMessage(" ");
		 event.getPlayer().sendMessage("      §f§lSEJA BEM-VINDO; §7§l" + event.getPlayer().getName());
		 event.getPlayer().sendMessage("                 §f§lAO §a§l"+Bukkit.getServer().getServerName());
		 event.getPlayer().sendMessage(" ");
	     event.getPlayer().getInventory().clear();
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.NOTE_PLING, 1, 0);
		 event.getPlayer().setFoodLevel(20);
		 event.getPlayer().setHealth(20);
	     Servidor.AddJoin();
	     event.getPlayer().teleport(Bukkit.getWorld("world").getSpawnLocation());
	     event.getPlayer().setGameMode(GameMode.ADVENTURE);
	     Give(event.getPlayer());
	     Config.addn(event.getPlayer(), "kitpvp.Kit", "Nenhum kit");
	     Config.addn(event.getPlayer(), "kitpvp.regenerar", "6");
	     Config.addn(event.getPlayer(), "kitpvp.sword", "§a§lEspada de Pedra");
	     Scoreboard.CriarScoreboard(event.getPlayer());
	     System.out.print(AccountWeb.Conectar(Main.site + "/API/MG/KP.php?modo=ADD-conta&nick=" + event.getPlayer().getName()));
	     Conta.Loader(event.getPlayer());
	     
		 for (Player all : UtilServer.Jogadores())
		 {
			 all.hidePlayer(event.getPlayer());
		 }
		 
	  	 Entrar.Give(event.getPlayer());
		
		Kit.AddKit(event.getPlayer(), "§9Nenhum ");
	
	     
	     if (!joins.contains(event.getPlayer()))
	    {
	    	 Account.AddExp(event.getPlayer(), "10");
	    	joins.add(event.getPlayer());
	    	if (joins.size() == 666)
	    	{
	    		Bukkit.broadcastMessage("§c§l666 Súscipe ludio ludius " + event.getPlayer().getName());
	    		for (Player j : UtilServer.Jogadores()) {
	    			j.playSound(j.getLocation(), Sound.AMBIENCE_THUNDER, 6.0F, 6.0F);
	    			Chat.ActionBar(event.getPlayer(), "§4§lO JOGADOR NUMERO 666 ENTROU (" + event.getPlayer().getName() + ")");
	    		
	    	}
	    	if (joins.size() == evento)
	    	{
	    		Bukkit.broadcastMessage("§5§lEVENTO §7Você acaba de receber §a+1 Chave.");
	    	    evento = evento+100;
	    		for (Player j : UtilServer.Jogadores()) {
	    		Account.AddChave(j, 1);
	    	    Account.UpdateAccount(j);
	    	    }
	    	    }
	    
	    	}
	    }
	}


	public static void Give(Player p)
	{
	     Armor.Armor(p);
	     for (PotionEffect effect : p.getActivePotionEffects())
	         p.removePotionEffect(effect.getType());
	     if (p.getInventory().getHelmet() == null)
	     {
	    	 p.getInventory().setHelmet(Armor.armor(Material.LEATHER_HELMET,"Capacete de Couro"));
	     }
	     if (p.getInventory().getChestplate() == null)
	     {
	    	 p.getInventory().setChestplate(Armor.armor(Material.LEATHER_CHESTPLATE,"Peitoral de Couro"));
	     }
	     if (p.getInventory().getLeggings() == null)
	     {
	     	 p.getInventory().setLeggings(Armor.armor(Material.LEATHER_LEGGINGS,"Calça de Couro"));
	     }
	     if (p.getInventory().getBoots() == null)
	     {
	    	 p.getInventory().setBoots(Armor.armor(Material.LEATHER_BOOTS, "Bota de Couro"));
	     }
	  	    ItemStack kit = new ItemStack(Material.CHEST);
		    ItemMeta rkit = kit.getItemMeta();
		    rkit.setDisplayName("§e§lSeletor de KIT");
		    kit.setItemMeta(rkit);
		    p.getInventory().setItem(0, kit);
		    
		    ItemStack loja = new ItemStack(Material.EMERALD);
		    ItemMeta rloja = loja.getItemMeta();
		    rloja.setDisplayName("§a§lLoja do Kit-PvP");
		    loja.setItemMeta(rloja);
		    p.getInventory().setItem(2, loja);
		    
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
			meta.setAuthor("_Unix52");
		      item.setItemMeta(meta);
		      p.getInventory().setItem(7, item);
		      
			    ItemStack voltar = new ItemStack(Material.WATCH);
			    ItemMeta rvoltar = loja.getItemMeta();
			    rvoltar.setDisplayName("§a§lLobby");
			    voltar.setItemMeta(rvoltar);
			    p.getInventory().setItem(8, voltar);
			    p.setFireTicks(0);
			   CombatLog.Remover(p);
			    
	}
	

}
