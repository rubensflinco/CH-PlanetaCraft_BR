package me.acf.lobby.gadgets.loader;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import me.acf.lobby.gadgets.Particles;
import me.hub.API.Util.UtilTime;



public class ParticleLoader
  implements Listener
{
  protected String Efeito = "Gadgets";
  protected JavaPlugin _plugin;
  boolean moving;
  protected boolean ignoreMove = false;
  private Player owner;
  
  public ParticleLoader(String gadgets, JavaPlugin plugin, Material material,int data, String desc)
  {
    this.Efeito = gadgets;
    this._plugin = plugin;



    onEnable();

    RegisterEvents(this);
    registrar(false,material, data, gadgets, desc);
  }
  public ParticleLoader(boolean capa,String gadgets, JavaPlugin plugin, Material material,int data, String desc)
  {
    this.Efeito = gadgets;
    this._plugin = plugin;



    onEnable();

    RegisterEvents(this);
    if (!capa)
    registrar(true,material, data, gadgets, desc);
    else
    	registrar(false,material, data, gadgets, desc);
  }
  
  public void registrar(boolean efeito,Material material, int data ,String nome, String desc)
  {
		 ItemStack bau = new ItemStack(material,1 ,(short) data);
	      ItemMeta metae = bau.getItemMeta();
	      metae.setDisplayName(nome);
	      if (!efeito)
	      metae.setLore(Arrays.asList(new String[] {  desc,"§3","§7>> Capas somente §5§lVIP+ §7<<" }));
	      else
	          metae.setLore(Arrays.asList(new String[] {  desc,"§3","§7>> Efeitos somente §5§lVIP<<" }));
	      bau.setItemMeta(metae);
	      if (efeito)
	    	  Particles.Efeitos.put(nome, bau);
	    	  else
	      Particles.gadgets.put(nome, bau);
  }
  
  public PluginManager GetPluginManager()
  {
    return this._plugin.getServer().getPluginManager();
  }

  public BukkitScheduler GetScheduler()
  {
    return this._plugin.getServer().getScheduler();
  }

  public JavaPlugin GetPlugin()
  {
    return this._plugin;
  }

  public void RegisterEvents(Listener listener)
  {
    this._plugin.getServer().getPluginManager().registerEvents(listener, this._plugin);
  }

  public final void onEnable()
  {
    long epoch = System.currentTimeMillis();
    Log("Iniciando Particles");
    Enable();
    AddComandos();
    Log("Particles " + Efeito + " " + UtilTime.Convertor(System.currentTimeMillis() - epoch, 1, UtilTime.TimeUnit.FIT) + ".");
  }

  public final void onDisable()
  {
    Disable();

    Log("Desativando Gadgets");
  }
  public void Enable() {
  }
  public void Disable() {
  }

  public void AddComandos() {
  }

  public final String GetName() {
    return this.Efeito;
  }

  public final void AddComandos(String teste)
  {
	  
  }



  protected void Log(String message)
  {
    System.out.println(message);
  }
}