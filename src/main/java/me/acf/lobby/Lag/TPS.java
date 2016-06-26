package me.acf.lobby.Lag;

import java.util.LinkedList;


public class TPS implements Runnable
{
    public static final LinkedList<Float> loggedTps     = new LinkedList<Float>();
    public static int                     loggedTpsSize = 60;
    
    public static float                   tps           = 20.0F;
    
    public static float                   timeSpend     = 0;
    
    public static long                    lastCall      = getMillis() - 3000L;
    public static int                     interval      = 40;
    
    public void addTps(Float tps)
    {
        if((tps != null) && (tps.floatValue() <= 20.0F))
        {
            loggedTps.add(tps);
        }
        if(loggedTps.size() > loggedTpsSize)
            loggedTps.poll();
    }
    
    public static final float getTPS()
    {
        return tps;
    }
    
    public static final float getAverageTPS()
    {
        float amount = 0.0F;
        for (Float f : loggedTps)
        {
            if(f != null)
            {
                amount += f.floatValue();
            }
        }
        return amount / loggedTps.size();
    }
    
    public static final float getTimeTPS()
    {
        return timeSpend;
    }
    
    private static long getMillis()
    {
        return System.currentTimeMillis();
    }
    
    public final void run()
    {
        long currentTime = getMillis();
        long spentTime = (currentTime - lastCall) / 1000L;
        timeSpend = spentTime;
        
        if(spentTime == 0L)
        {
            spentTime = 1L;
        }
        
        float calculatedTps = (float) (interval / spentTime);
        
        if(calculatedTps > 20.0F)
        {
            calculatedTps = 20.0F;
        }
        
        setTps(calculatedTps);
        addTps(calculatedTps);
        
        lastCall = getMillis();
        Ticks[(TickCount % Ticks.length)] = System.currentTimeMillis();

        TickCount += 1;
    }
    
    private void setTps(float newTps)
    {
        tps = newTps;
    }
    
    public static int TickCount = 0;
    public static long[] Ticks = new long[600];
    public static long LastTick = 0L;
    public static double TPS()
    {
      return TPS(100);
    }

    public static double TPS(int ticks)
    {
      if (TickCount < ticks) {
        return 20.0D;
      }
      int target = (TickCount - 1 - ticks) % Ticks.length;
      long elapsed = System.currentTimeMillis() - Ticks[target];

      return ticks / (elapsed / 1000.0D);
    }

    public static long getElapsed(int tickID)
    {
      if (TickCount - tickID >= Ticks.length);
      long time = Ticks[(tickID % Ticks.length)];
      return System.currentTimeMillis() - time;
    }


}