/**
 * 
 */
package me.acf.FullPvP;

import org.bukkit.entity.Player;

import me.hub.config.Config;

/**
 * @author adriancf
 *
 */
public class FPConfig {

	
	public static void FP(Player p, String config, String valor)
	{
		Config.Set(p, "fullpvp."+config, valor);
	}
	
	public static void ADD(Player p, String config, String valor)
	{
		Config.addn(p, "fullpvp."+config, valor);
	}
	public static String retorno(Player p, String config)
	{
		return Config.retornar(p, "fullpvp."+config);
	}
}
