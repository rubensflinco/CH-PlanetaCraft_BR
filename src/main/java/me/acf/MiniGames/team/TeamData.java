/**
 * 
 */
package me.acf.MiniGames.team;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import me.acf.MiniGames.MiniGamesMananger;
import me.acf.MiniGames.MiniGamesMananger.Time;

/**
 * @author adriancf
 *
 */
public class TeamData {
	
    int jogadores = 0;
    Time time;
    Location loc;
    
	public TeamData(Time team, Location loc)
	{
	  time = team;
	  this.loc = loc;
	  
	}
	
	public void AddJogador(Player p)
	{
		MiniGamesMananger.jogadoteam.put(p, time);
		jogadores++;
	}
	public void RemoverJogador(Player p)
	{
		MiniGamesMananger.jogadoteam.remove(p);
		jogadores--;
	}
	
	public int Jogadores()
	{
		return jogadores;
	}
	public Time Time()
	{
		return time;
	}

}
