package me.acf.lobby.extend;


import me.acf.servidor.Servidor;
import me.hub.API.Util.UtilInv;
import me.hub.NMS.NPC;
import me.hub.Scoreboard.ScoreboardAPI;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Sair implements Listener {
	

@EventHandler
public void ESair(PlayerQuitEvent e)
{

	NPC.ejectNetty(e.getPlayer());
	e.setQuitMessage(null);
	ScoreboardAPI.remover(e.getPlayer());
	Servidor.AddLeave();
	if (!me.hub.comandos.geral.Admin.admin.contains(e.getPlayer()))
	  UtilInv.save(e.getPlayer());
}

}
