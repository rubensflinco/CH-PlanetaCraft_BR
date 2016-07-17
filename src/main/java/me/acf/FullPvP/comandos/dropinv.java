 package me.acf.FullPvP.comandos;

import java.io.PrintStream;
import java.util.Random;

import me.acf.FullPvP.Kits.Kits;
import me.hub.Main;
import me.hub.API.Chat;
import me.hub.API.Util.UtilInv;
import me.hub.API.Util.UtilServer;
import me.hub.API.Util.UtilTime;
import me.hub.API.Util.message.Message;
import me.hub.comandos.ComandosAPI;
import me.site.account.Account;
import me.site.account.rank.Rank;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

public class dropinv
  implements CommandExecutor
{
  public String[] atalhos = { "dinv" };
  public String desc = "Regenerar sua fome";
  public static int contidade = 60;
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (ComandosAPI.VerConsole(sender).equals("sim"))
    {
      sender.sendMessage(Message.Console_Não);
      return true;
    }
    Player jogador = (Player)sender;
    if (Account.getRank(jogador).Has(jogador, Rank.STAFFM, false)) {
      Droper();
    }
    return false;
  }
  
  public static ItemStack item()
  {
    Random random = new Random();
    Material[] materials = Material.values();
    int size = materials.length;
    int index = random.nextInt(size);
    Material randomMaterial = materials[index];
    return new ItemStack(randomMaterial, random.nextInt(64));
  }
  
  public static void Droper()
  {
    new BukkitRunnable()
    {
      public void run()
      {
        dropinv.contidade -= 1;
        long milliseconds = dropinv.contidade * 1000;
        String timeLeft = UtilTime.convertString(milliseconds, 0, UtilTime.TimeUnit.FIT);
        for (Player p : UtilServer.Jogadores())
        {
          Chat.ActionBar(p, "§4§lDROP INV §b§l" + timeLeft);
          Random random = new Random();
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { dropinv.item() });
          p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLDEN_APPLE, 20, (byte)1) });
          if (Account.getRank(p).Has(p, Rank.VIPM, true)) {
            if (random.nextInt(50) < 10)
            {
              Inventory pvp = p.getInventory();
              pvp.addItem(new ItemStack[] { new ItemStack(Material.GOLDEN_APPLE, 500, (byte)1) });
              pvp.addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, 0, "§a§lEspada de DIAMOND", ""), 90) });
              pvp.addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 1, 0, "§a§lMachado de DIAMOND", ""), 90) });
              pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 1, 0, "§a§lCapacete de DIAMOND", ""), 100) });
              pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 1, 0, "§a§lPeitoral de DIAMOND", ""), 100) });
              pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 1, 0, "§a§lCal§a de DIAMOND", ""), 100) });
              pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 1, 0, "§a§lBota de DIAMOND", ""), 100) });
              pvp.addItem(new ItemStack[] { Kits.AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 1, 0, "§a§lPicareta de DIAMOND", ""), 40) });
              pvp.addItem(new ItemStack[] { Kits.AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 1, 0, "§a§lP§ de DIAMOND", "§6§lKit VIP"), 50) });
              pvp.addItem(new ItemStack[] { Kits.AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, 1, 0, "§a§lArco", ""), 80) });
            }
          }

          if (random.nextInt(15) < 5) {
            p.getInventory().addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.WOOD_SWORD, 1, 0, "§a§lEspada de DIAMOND", ""), 90) });
          }
          if (random.nextInt(15) < 5)
          {
            Inventory pvp = p.getInventory();
            pvp.addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, 0, "§a§lEspada de DIAMOND", ""), 20) });
            pvp.addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 1, 0, "§a§lMachado de DIAMOND", ""), 30) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 1, 0, "§a§lCapacete de DIAMOND", ""), 20) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 1, 0, "§a§lPeitoral de DIAMOND", ""), 20) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 1, 0, "§a§lCal§a de DIAMOND", ""), 30) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 1, 0, "§a§lBota de DIAMOND", ""), 20) });
            pvp.addItem(new ItemStack[] { Kits.AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 1, 0, "§a§lPicareta de DIAMOND", ""), 40) });
            pvp.addItem(new ItemStack[] { Kits.AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 1, 0, "§a§lP§ de DIAMOND", "§6§lKit VIP"), 30) });
            pvp.addItem(new ItemStack[] { Kits.AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, 1, 0, "§a§lArco", ""), 20) });
          }
          if (random.nextInt(55) < 5)
          {
            Inventory pvp = p.getInventory();
            
            pvp.addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, 0, "§a§lEspada de DIAMOND", ""), 60) });
            pvp.addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 1, 0, "§a§lMachado de DIAMOND", ""), 90) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 1, 0, "§a§lCapacete de DIAMOND", ""), 90) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 1, 0, "§a§lPeitoral de DIAMOND", ""), 90) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 1, 0, "§a§lCal§a de DIAMOND", ""), 90) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 1, 0, "§a§lBota de DIAMOND", ""), 90) });
            pvp.addItem(new ItemStack[] { Kits.AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 1, 0, "§a§lPicareta de DIAMOND", ""), 40) });
            pvp.addItem(new ItemStack[] { Kits.AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 1, 0, "§a§lP§ de DIAMOND", "§6§lKit VIP"), 50) });
            pvp.addItem(new ItemStack[] { Kits.AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, 1, 0, "§a§lArco", ""), 50) });
          }
          if (random.nextInt(100) < 10)
          {
            Inventory pvp = p.getInventory();
            
            pvp.addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_SWORD, 1, 0, "§a§lEspada de DIAMOND", ""), 90) });
            pvp.addItem(new ItemStack[] { Kits.AddSwordEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_AXE, 1, 0, "§a§lMachado de DIAMOND", ""), 90) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HELMET, 1, 0, "§a§lCapacete de DIAMOND", ""), 100) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_CHESTPLATE, 1, 0, "§a§lPeitoral de DIAMOND", ""), 100) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_LEGGINGS, 1, 0, "§a§lCal§a de DIAMOND", ""), 100) });
            pvp.addItem(new ItemStack[] { Kits.AddArmorEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_BOOTS, 1, 0, "§a§lBota de DIAMOND", ""), 100) });
            pvp.addItem(new ItemStack[] { Kits.AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_PICKAXE, 1, 0, "§a§lPicareta de DIAMOND", ""), 40) });
            pvp.addItem(new ItemStack[] { Kits.AddUtilEnchantRandom(UtilInv.AddItemReturn(Material.DIAMOND_HOE, 1, 0, "§a§lP§ de DIAMOND", "§6§lKit VIP"), 50) });
            pvp.addItem(new ItemStack[] { Kits.AddBowEnchantRandom(UtilInv.AddItemReturn(Material.BOW, 1, 0, "§a§lArco", ""), 80) });
          }
        }
        switch (dropinv.contidade)
        {
        case 0: 
          cancel();
          dropinv.contidade = 60;
        }
      }
    }.runTaskTimer(Main.plugin, 0L, 20L);
  }
}
