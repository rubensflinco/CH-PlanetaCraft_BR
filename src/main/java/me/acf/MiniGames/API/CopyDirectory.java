package me.acf.MiniGames.API;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import me.acf.MiniGames.MiniGamesMananger;
import me.hub.Main;

public class CopyDirectory
{
	/*    */   public static void logInfo(String message) {
		/* 78 */     Main.plugin.getLogger().info(message);
		/*    */   }
		/*    */ 
		/*    */   public void logWarning(String message) {
		/* 82 */     Main.plugin.getLogger().warning(message);
		/*    */   }
		/*    */ 
		/*    */   public static void logSevere(String message) {
		/* 86 */     Main.plugin.getLogger().severe(message);
		/*    */   }
	/*    */   public static void importWorlds() {
		/* 19 */     boolean errors = false;
		/* 20 */     File backupDir = new File("mapas");
		/* 21 */     for (File source : backupDir.listFiles())
		/* 22 */       if (source.isDirectory()) {
	    /* 32 */        MiniGamesMananger.deletarArquivo(new File(""+source.getName()+""));
		/* 23 */         File target = new File(Main.plugin.getServer().getWorldContainer(), source.getName());
		/* 24 */         if ((target.exists()) && (target.isDirectory()) && 
		/* 25 */           (!delete(target))) {
		/* 26 */           logSevere("Falha ao redefinir o mundo \"" + source.getName() + "\" - Não foi possível excluir velho " + 
		/* 27 */             "pasta do mundo.");
		/* 28 */           errors = true;
		/*    */         }
		/*    */         else
		/*    */         {
		/*    */           try
		/*    */           {
		/* 34 */             copyDir(source, target);
		/*    */           } catch (IOException e) {
		/* 36 */             e.printStackTrace();
		/* 37 */             logSevere("Falha ao redefinir o mundo \"" + source.getName() + "\" - Não foi possível importar a " + 
		/* 38 */               "mundo de backup.");
		/* 39 */             errors = true;
		/*    */           }
		/*    */             MiniGamesMananger.CarregarMundo(""+source.getName()+"");
		/* 41 */           logInfo("Importação do mundo \"" + source.getName() + "\" " + (errors ? "falhou!" : "sucedeu!"));
		/* 42 */           errors = false;
		/*    */         }
		/*    */       }
		/*    */   }
	/*    */   private static boolean delete(File file)
	/*    */   {
	/* 72 */     if (file.isDirectory())
	/* 73 */       for (File subfile : file.listFiles())
	/* 74 */         if (!delete(subfile))
	/* 75 */           return false;
	/* 76 */     if (!file.delete())
	/* 77 */       return false;
	/* 78 */     return true;
	/*    */   }
	/*    */   private static void copyDir(File source, File target) throws IOException {
		/* 82 */     if (source.isDirectory()) {
		/* 83 */       if (!target.exists())
		/* 84 */         target.mkdir();
		/* 85 */       String[] files = source.list();
		/* 86 */       for (String file : files) {
		/* 87 */         File srcFile = new File(source, file);
		/* 88 */         File destFile = new File(target, file);
		/* 89 */         copyDir(srcFile, destFile);
		/*    */       }
		/*    */     } else {
		/* 92 */       InputStream in = new FileInputStream(source);
		/* 93 */       OutputStream out = new FileOutputStream(target);
		/* 94 */       byte[] buffer = new byte[1024];
		/*    */       int length;
		/* 97 */       while ((length = in.read(buffer)) > 0)
		/*    */       {
		/* 98 */         out.write(buffer, 0, length);
		/* 99 */       }in.close();
		/* 100 */       out.close();
		/*    */     }
		/*    */   }
}