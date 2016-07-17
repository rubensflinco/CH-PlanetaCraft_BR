package me.hub;

import java.io.PrintStream;

import me.hub.API.Util.UtilTime;
import net.minecraft.server.v1_10_R1.ICommand;

import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;



public abstract class MiniPlugin
  implements Listener
{
  protected String _moduleName = "Default";
  protected JavaPlugin _plugin;

  public MiniPlugin(String moduleName, JavaPlugin plugin)
  {
    this._moduleName = moduleName;
    this._plugin = plugin;

    onEnable();

    RegisterEvents(this);
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
    Enable();
    AddComandos();
  }

  public final void onDisable()
  {
    Disable();

    Log("Desativado");
  }
  public void Enable() {
  }
  public void Disable() {
  }

  public void AddComandos() {
  }

  public final String GetName() {
    return this._moduleName;
  }

  public final void AddComandos(String teste)
  {
	  
  }



  protected void Log(String message)
  {
    System.out.println(message);
  }
}