/**
 *
 * Projeto: CHub2 
 * Packet: me.acf.MiniGames.Style
 * Git Config: 
 * Usuario: adriancf
 * -= [Team CHGroup] =-
 *
 */
package me.acf.MiniGames.Style;

import org.bukkit.entity.Player;

/**
 *
 * Criado dia 19 de jun de 2016 - 15:30:35
 * Projeto: CHub2
 * por @author αdяiαиcf #Reloads
 * 
 */
public class UserData {

	public Player jogador;
	public int Matou = 0;
	public int Morreu = 0;
    public int Tempo_Vivo = 0;
    public String kit = "Nenhum";
    public Style style = Style.VIVO;
    
    public UserData(Player jogador)
    {
    	this.jogador = jogador;
    }
    
    
    
    
    public static enum Style
    {
    	VIVO,
    	MORTO,
    	SPECTADOR;
    	
    }
	
	
}
