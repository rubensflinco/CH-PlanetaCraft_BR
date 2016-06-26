/**
 * 
 */
package me.acf.MiniGames;

/**
 * @author adriancf
 *
 */
public class Arcade {

	public static ArcadeType estilo = ArcadeType.AGUARDANDO;
	
	
	public ArcadeType partida()
	{
		return estilo;
	}
	
	
	public static boolean noInicio()
	{
		if ((estilo == ArcadeType.AGUARDANDO) || (estilo == ArcadeType.INICIANDO))
			return true;
		return false;
	}
	
	
	public enum ArcadeType {
		AGUARDANDO,
		INICIANDO,
		INVENCIVEL,
		JOGANDO,
		FIM;
		
		ArcadeType()
		{
			
		}
	}
	
	
}
