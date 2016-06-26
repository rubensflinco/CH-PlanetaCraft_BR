/**
 * 
 */
package me.acf.MiniGames.eventos;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
 
public class GameJogandoEvent extends Event implements Cancellable{
 
       
        public static HandlerList handlers = new HandlerList();
        public boolean cancelled = false;
       
        public GameJogandoEvent(){
                
        }
       
       
        @Override
        public boolean isCancelled() {
                return cancelled;
        }
 
        @Override
        public void setCancelled(boolean cancel) {
                cancelled = cancel;
        }
 
        public static HandlerList getHandlerList(){
                return handlers;
        }
       
        @Override
        public HandlerList getHandlers() {
                return handlers;
        }
 
       
       
}