package Core.Background;

import Core.MySql.Load_BoxA;

import com.sbix.jnotify.NPosition;

import com.sbix.jnotify.NoticeType;

import com.sbix.jnotify.NoticeWindow;

import java.awt.Color;

import java.util.Timer;

import java.util.TimerTask;


public class Humidity_Bar 
{

    
    public static void tasker()
    {
        Timer t = new Timer();
        
        t.schedule(new TimerTask()
        {
            @Override
        
            public void run() 
            {
                get_Humidity();
                
            }
        }, 0, 15000);
    }
    
    
    public static void get_Humidity()
    {
        Load_BoxA box_a = new Load_BoxA();
        
        Integer data = 0;
        try
        {
            data = Integer.valueOf(box_a.load_condition("Humidity"));
        }
        catch(Exception ERROR)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(ERROR));
        }
        
        
        if(data > 80)
        {
            UI.Sensor_Box_Draw.progress1.setForeground(Color.BLUE);
            
            UI.Sensor_Box_Draw.progress1.setBackground(Color.WHITE);
        }
        else if((data < 80)&&(data >50))
        {
            UI.Sensor_Box_Draw.progress1.setForeground(Color.GREEN);
        }
        else if(data < 50)
        {
            UI.Sensor_Box_Draw.progress1.setForeground(Color.RED);
            
            UI.Sensor_Box_Draw.progress1.setBackground(Color.WHITE);
            
            new NoticeWindow(NoticeType.WARNING_NOTIFICATION,"Humidity Level Unstable Please Turn On Sprinkler",NoticeWindow.SHORT_DELAY,NPosition.TOP_RIGHT);
        }
        
        UI.Sensor_Box_Draw.progress1.setValue(data);
        
        //UI.Sensor_Box_Draw.progress2.setValue(data);
        
        //UI.Sensor_Box_Draw.progress3.setValue(data);
    }
}


