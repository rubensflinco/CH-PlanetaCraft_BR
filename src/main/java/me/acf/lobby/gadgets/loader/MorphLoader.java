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

import me.acf.lobby.gadgets.Morph;
import me.acf.lobby.gadgets.Particles;
import me.hub.API.Util.UtilTime;



public class MorphLoader
  implements Listener
{
  protected String Efeito = "Gadgets";
  protected JavaPlugin _plugin;
  boolean moving;
  protected boolean ignoreMove = false;
  private Player owner;
  
  public MorphLoader(String gadgets, JavaPlugin plugin, Material material,int data, String desc, String tipo)
  {
    this.Efeito = gadgets;
    this._plugin = plugin;



    onEnable();

    RegisterEvents(this);
    registrar(material, data, gadgets, desc, tipo);
  }

  
  public void registrar(Material material, int data ,String nome, String desc,String tipo)
  {
		 ItemStack bau = new ItemStack(material,1 ,(short) data);
	      ItemMeta metae = bau.getItemMeta();
	      metae.setDisplayName(nome);
	      metae.setLore(Arrays.asList(new String[] {  desc,"§3","§7>> Tipo: " + tipo +  " §7<<" }));
	      bau.setItemMeta(metae);
	      Morph.gadgets.put(nome, bau);
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
    Log("Iniciando Morph");
    Enable();
    AddComandos();
    Log("Morph " + Efeito + " " + UtilTime.Convertor(System.currentTimeMillis() - epoch, 1, UtilTime.TimeUnit.FIT) + ".");
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