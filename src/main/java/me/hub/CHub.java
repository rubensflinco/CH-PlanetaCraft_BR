/**
  *           Main.java, Class CH-Group 25 de jun de 2016 - 18:33:24 by αdяiαиcf #Reloads
  *
  *###################################################################################
  *###################################################################################
  *
  *101101101101   101101101101   101101101101              10110110101    101101101101
  *101      101   101            101                       101            101
  *101      101   101            101                       101            101
  *101101101101   101            101101101101    101101    101            101
  *101      101   101            101                       101   101101   101    101101
  *101      101   101            101                       101      101   101       101
  *101      101   101101101101   101                       101101101101   101 101101101
  *
  *################################################################################### 
  *###################################################################################

                                   adriancf

  @Projeto CHub --- proprietário CH-Group, projeto criado no dia 25 de jun de 2016 as 18:33:24        
   
  Todo o me.hub e Main.java, esta sobre os direitos do CH-Group e de suas dependências.                                                     
  Portantando você, não pode retirar os direitos dos criadores desta class.


                                    @Info
                                   αdяiαиcf
     
    *  Dependências utilizadas por CH-Projets  
    *  Uso de projetos JSon
    *  Uso de Maven
    *  Uso de CGlib
    *  Entre outras...


Ass: αdяiαиcf - Códigos livres


*/



package me.hub;

import org.bukkit.plugin.java.JavaPlugin;

import me.hub.API.Util.UtilHolo;

/**
 * Código por adriancf, Group CH-Project

 */
public class CHub  {
	
	

	
	public static void onLoad()
	{
		System.out.print("Feito");
	}
	
	public static void onEnable()
	{
	    Ler.Ler();
	   System.out.print("Feito");
	   
	}
	
	public static void onDisable()
	{
		try {
		Ler.GetBlockRestore().ForceExpireBlocks();
		UtilHolo.RemoveAllHolo();
		}
		catch (Exception ex)
		{
			
		}
		  Fechar.stop();
     System.out.print("Feito");
	}

}
