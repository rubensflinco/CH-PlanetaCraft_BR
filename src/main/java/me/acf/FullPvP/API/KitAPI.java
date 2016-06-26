/**
 * 
 */
package me.acf.FullPvP.API;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.acf.FormatText.Format;
import me.acf.FullPvP.Conta;
import me.acf.FullPvP.FPConfig;
import me.acf.FullPvP.scoreboard.Scoreboard;
import me.acf.lobby.patentes.Patente;
import me.hub.API.Util.UtilTime;
import me.site.account.Account;
import me.site.account.rank.Rank;


/**
 * @author adriancf
 *
 */
public class KitAPI {

	public static HashMap<String, Inventory> kit = new HashMap<>();
    public static List<String> kits = new ArrayList<>();
	public static HashMap<String, String> permkit = new HashMap<>();
    
	public static String SeusKits(Player p)
	{
		String kit = "§aNenhum Kit";
		for (String s : kits)
		{
			if (s.contains("§6")) {
				  if ((Account.getRank(p)).Has(p, Rank.VIP, false))
				   {
						if (kit.contains(","))
						{
							kit = kit + "," + s; 
						}
						else
						{
							kit = s + ",";
						}
				   }
			}
			else
				if (s.contains("§5")) {
					  if ((Account.getRank(p)).Has(p, Rank.VIPM, false))
					   {
							if (kit.contains(","))
							{
								kit = kit + "," + s; 
							}
							else
							{
								kit = s + ",";
							}
					   }
				}
				else
	    	if (s.contains("§c"))
	    	{
	    		try {
	    		if (FPConfig.retorno(p, "kit." + s.replace("§c", "") + ".tem").equals("sim"))
	    		{
	    			if (kit.contains(","))
					{
						kit = kit + "," + s; 
					}
					else
					{
						kit = s + ",";
					}	
	    		}
	    		else
	    		{
	    	
	    		
	    		}
	    		} catch (Exception e) {
	 
	    	
	    		}
	    	
	    	}
			else
			if (kit.contains(","))
			{
				kit = kit + "," + s; 
			}
			else
			{
				kit = s + ",";
			}
		}
		
		return kit;
	}
    
    
	public static void AddKit(String nome, Inventory inv)
	{
		kit.put(nome.replace("§5", "").replace("§6", "").replace("§c", "").replace("§o", ""), inv);
		kits.add(nome);
		permkit.put(nome.replace("§5", "").replace("§6", "").replace("§c", "").replace("§o", ""), nome);
		System.out.print("Kit> " + nome + " adicionado!");
	}
	
    public static void GiveKit(String nome, Player p)
    {
    	if (!kit.containsKey(nome))
    	{
    		Format.Erro("O kit§a " + nome + " não existe", p);
    		return;
    	}

    	if (!verificar(nome, p))
    	return;
	    
    	if (nome.contains("Reset"))
    	{
  			   if (!Tempo(p, nome,99999))
    				return;
  			 Conta.Reload(p);
  			 Scoreboard.CriarScoreboard(p);
  			   
    	}
    	
		for (ItemStack item : kit.get(nome))
		{
		 try{
			 {
				 if (p.getInventory().firstEmpty() == -1) {
					 if (item != null)
					p.getWorld().dropItem(p.getLocation(), item); 
				 }else
				 {
					 if (item != null)
				 p.getInventory().addItem(item);
				 }
			 }
			 } catch (Exception e) {
		}
		}
		
    }

    public static boolean Tempo(Player p, String nome, int temp)
    {
     	  Calendar calendar = new GregorianCalendar();
	      SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
	      Date date = new Date();
	      calendar.setTime(date);
	      
    	  try {
    	  String s1 = FPConfig.retorno(p, "kit." + nome);
    
		  Date d1 = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse(s1);

		  
 
	      
	      String s2 = out.format(calendar.getTime());
	      Date d2 = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").parse(s2);
	      long sec = d1.getTime() - d2.getTime();
	        if (sec < 0)
	        {
	      calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + temp);
	      FPConfig.FP(p, "kit." + nome + "", out.format(calendar.getTime()));
	        return true;
	        }
	      String  tempo = UtilTime.convertString(sec, 0, UtilTime.TimeUnit.FIT);
         Format.Comando("KIT", "Para usar o kit " + nome + " você deve esperar " + tempo, p);	        
	    return false;
  		} catch (Exception e) {

  		}
   	  
		    calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + temp);
	  	      FPConfig.FP(p, "kit." + nome + "", out.format(calendar.getTime()));
	  	    return true;
    }
    public static boolean verificar(String nome, Player p)
    {	
    	if (KitAPI.permkit.get(nome).contains("§5§o"))
	{
		   if ((Account.getRank(p)).Has(p, Rank.VIPM, true))
		   {
			   if ((Account.getPatente(p)).Has(p, Patente.Legendario, true))
			   {
			   if (!Tempo(p, nome,3))
					return false;	
			   return true;
			   }
			   else
				   return false;
		   }
		   return false;

	}

	if (KitAPI.permkit.get(nome).contains("§6§o"))
	{
		   if ((Account.getRank(p)).Has(p, Rank.VIP, true))
		   {
			   if ((Account.getPatente(p)).Has(p, Patente.Legendario, true))
			   {
			   if (!Tempo(p, nome,3))
					return false;	
			   return true;
			   }
			   else
				   return false;
		   }
		   else 
			   return false;
	}
	
	if (KitAPI.permkit.get(nome).contains("§5"))
	{
		   if ((Account.getRank(p)).Has(p, Rank.VIPM, true))
		   {
			   if (!Tempo(p, nome,1))
				return false;	
			   p.sendMessage("§c§lAVISO §cItens e encantamentos dos kit VIP são aleatorios cada vez que o servidor reiniciar muda.");			
		   return true;
		   }
		   else 
			   return false;
	}
	
	if (KitAPI.permkit.get(nome).contains("§6"))
	{
		   if ((Account.getRank(p)).Has(p, Rank.VIP, true))
		   {
			  
			   if (!Tempo(p, nome,1))
					return false;	
			   p.sendMessage("§c§lAVISO §cItens e encantamentos dos kit VIP são aleatorios cada vez que o servidor reiniciar muda.");
		return true;
		   }
		   else 
			   return false;
	}
	
	if (KitAPI.permkit.get(nome).contains("§c"))
	{
		try {
		if (FPConfig.retorno(p, "kit." + nome + ".tem").equals("sim"))
		{
			   if (!Tempo(p, nome,1))
				return false;
			   
			   return true;
		}
		else
		{
			Format.Erro("Você não tem este kit§a " + nome, p);
			return false;
		}
		} catch (Exception e) {
			Format.Erro("Você não tem este kit§a " + nome, p);
		return false;
		} 	
	}
	return true;
	}

}
