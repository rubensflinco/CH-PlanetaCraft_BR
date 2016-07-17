package me.acf.lobby.gadgets.loader;

import java.io.PrintStream;
import java.util.ArrayList;

import me.acf.lobby.gadgets.Gadgets;
import me.hub.API.Util.UtilTime;
import net.minecraft.server.v1_10_R1.ICommand;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;



public abstract class GadGetsLoader
  implements Listener
{
  protected String Efeito = "Gadgets";
  protected JavaPlugin _plugin;

  public GadGetsLoader(String gadgets, JavaPlugin plugin, Material material, String desc)
  {
    this.Efeito = gadgets;
    this._plugin = plugin;



    onEnable();

    RegisterEvents(this);
    registrar(material, gadgets, desc);

  }

  public void registrar(Material material, String nome, String desc)
  {
		 ItemStack bau = new ItemStack(material);
	      ItemMeta metae = bau.getItemMeta();
	      metae.setDisplayName(nome);
	      ArrayList<String> desce = new ArrayList();
	      desce.add(desc);
	      metae.setLore(desce);
	      bau.setItemMeta(metae);
	      
	      Gadgets.gadgets.put(nome, bau);
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
    Log("Iniciando Gadgets");
    Enable();
    AddComandos();
    Log("Gadgets " + Efeito + " " + UtilTime.Convertor(System.currentTimeMillis() - epoch, 1, UtilTime.TimeUnit.FIT) + ".");
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