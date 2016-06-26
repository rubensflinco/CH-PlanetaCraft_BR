package me.acf.lobby.gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.acf.lobby.gadgets.particles.ParticleEffectAngelWings;
import me.acf.lobby.gadgets.particles.ParticleEffectCapEnd;
import me.acf.lobby.gadgets.particles.ParticleEffectCapFire;
import me.acf.lobby.gadgets.particles.ParticleEffectCapMagic;
import me.acf.lobby.gadgets.particles.ParticleEnchant;
import me.acf.lobby.gadgets.particles.ParticleGreen;
import me.acf.lobby.gadgets.particles.ParticleHeart;
import me.acf.lobby.gadgets.particles.ParticleRain;
import me.hub.Main;
import me.hub.MiniPlugin;
import me.hub.atualizar.Atualizar;
import me.hub.atualizar.ModosUpdate;
import me.hub.config.Config;
import me.site.account.Account;
import me.site.account.rank.Rank;

public class Particles extends MiniPlugin  {

	
	public static Map<Player, String> Particle = new HashMap<Player, String>();
	public static Map<String, ItemStack> gadgets = new HashMap<String, ItemStack>();
	public static Map<String, ItemStack> Efeitos = new HashMap<String, ItemStack>();
    public static ArrayList<Player> move = new ArrayList();
	public Main main;
	public Particles(JavaPlugin plugin) {
		super("Particles", plugin);
		ParticleEffectAngelWings ParticleEffectAngelWings = new ParticleEffectAngelWings(plugin);
		ParticleEffectCapMagic ParticleEffectCapMagic = new ParticleEffectCapMagic(plugin);
		ParticleEffectCapEnd ParticleEffectCapEnd = new ParticleEffectCapEnd(plugin);
		ParticleEffectCapFire ParticleEffectCapFire = new ParticleEffectCapFire(plugin);
        ParticleRain particle = new ParticleRain(plugin);
        ParticleEnchant particlee = new ParticleEnchant(plugin);
        ParticleGreen partic = new ParticleGreen(plugin);
        ParticleHeart heart = new ParticleHeart(plugin);
	}
	
    public static List<String> Moving = new ArrayList();
    final HashMap<UUID, Location> lastBlockLocation = new HashMap();

    @EventHandler
    public void onLoad(PlayerJoinEvent e)
    {
    	Config.add(e.getPlayer(), "Particle.usando", "nenhuma");
    	if (!Config.retornar(e.getPlayer(), "Particle.usando").equals("nenhuma"))
    	{
    		Particle.put(e.getPlayer(), Config.retornar(e.getPlayer(), "Particle.usando"));
    	}
    }
    
    @EventHandler
    public void onUpdate(PlayerQuitEvent e)
    {
    	Particle.remove(e.getPlayer());
    }
    
    @EventHandler
    public void onUpdate(Atualizar e)
    {
      if (e.getType() == ModosUpdate.FASTER)
      {
          for (Player player : Particles.Particle.keySet()) {
        	
        	Location Current = player.getLocation();
        	Location Last = (Location)this.lastBlockLocation.get(player.getUniqueId());
            if (this.lastBlockLocation.get(player.getUniqueId()) == null)
            {
              this.lastBlockLocation.put(player.getUniqueId(), Current);
              Last = (Location)this.lastBlockLocation.get(player.getUniqueId());
            }
            this.lastBlockLocation.put(player.getUniqueId(), player.getLocation());
            if ((Last.getX() != Current.getX()) || (Last.getY() != Current.getY()) || (Last.getZ() != Current.getZ()))
            {
              if (!Moving.contains(player.getName())) {
                Moving.add(player.getName());
              }
            }
            else if (Moving.contains(player.getName())) {
              Moving.remove(player.getName());
            }
           
        }
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
	    	if (e.getSlot() == 9)
  	      {
	  	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Efeitos"))
	        {
	    	  e.getInventory().clear();
	    	  
	    	  Menu.Pagina(e.getInventory(), "Efeitos");
	    	  }
  	      }
	    	      if (e.getSlot() == 11)
	    	      {
	    	    	  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Capas"))
	      	        {
	    	    	  e.getInventory().clear();
	    	    	  
	    	    	  Menu.Pagina(e.getInventory(), "Capas");
	    	    	  }
	    	    
	    	      
	    	      }
	    	      if (Particles.gadgets.containsKey(e.getCurrentItem().getItemMeta().getDisplayName())){
	    	    	  AtivarGadgets(e.getCurrentItem().getItemMeta().getDisplayName(), jogador);
	    	      }
	    	      if (Particles.Efeitos.containsKey(e.getCurrentItem().getItemMeta().getDisplayName())){
	    	    	  AtivarGadgets(e.getCurrentItem().getItemMeta().getDisplayName(), jogador);
	    	      }
	    	      System.out.print(jogador.getName() + " > " + e.getCurrentItem().getItemMeta().getDisplayName());
	    	    }
	    } catch (Exception e1) {
		  }
	  }
	  
	  private static void AtivarGadgets(String nome, Player jogador)
	  {
		  if (nome.contains("Capa"))
		  {
			  if (!(Account.getRank(jogador)).Has(jogador, Rank.VIPM, true))
			   return;
		  }
		  if (nome.contains("Particle"))
		  {
			  if (!(Account.getRank(jogador)).Has(jogador, Rank.VIP, true))
				   return;
		  }
		  if (!Particles.Particle.containsKey(jogador)) {
		 Particles.Particle.put(jogador, nome);
		 Config.Set(jogador, "Particle.usando", nome);
		 Gadgets.MsgFormat("Você ativou o efeito " + nome, jogador);
		  }
		  else
		  {
			  if (Particles.Particle.get(jogador).equals(nome))
			  {
				  Particles.Particle.remove(jogador);
				  Gadgets.MsgFormat("Você removeu o efeito " + nome, jogador);
				  Config.Set(jogador, "Particle.usando", "nenhuma");
				  return;
			  }
				 Particles.Particle.put(jogador, nome);
				 Config.Set(jogador, "Particle.usando", nome);
				 Gadgets.MsgFormat("Você ativou o efeito " + nome, jogador);
		  }
	  }
	  
    public static boolean isMoving(Player p)
    {
      if (Moving.contains(p.getName())) {
        return false;
      }
      return true;
    }
	  
}
