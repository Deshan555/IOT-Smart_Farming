package Core.Background;

import Core.MySql.Load_BoxB;

import com.sbix.jnotify.NPosition;

import com.sbix.jnotify.NoticeType;

import com.sbix.jnotify.NoticeWindow;

import java.awt.Color;

import java.util.Timer;

import java.util.TimerTask;


public class Water_Level 
{
    public static void tasker()
    {
        Timer t = new Timer();
        
        t.schedule(new TimerTask()
        {
            @Override
        
            public void run() 
            {
                get_level();
                
            }
        }, 0, 15000);
    }
    
    
    public static void get_level()
    {
        Load_BoxB box_b = new Load_BoxB();
        
        Integer data = 0;
        
        try
        {
            data = Integer.valueOf(box_b.load_condition("Water_Level"));
            
            data  = water_lvReformat.data_fix(String.valueOf(data));
        }
        catch(Exception ERROR)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(ERROR));
        }
        
        
        if(data > 80)
        {
            UI.Sensor_Box_Draw.progress2.setForeground(Color.BLUE);
            
            //UI.Sensor_Box_Draw.progress2.setBackground(Color.WHITE);
        }
        else if((data < 80)&&(data >50))
        {
            UI.Sensor_Box_Draw.progress2.setForeground(Color.GREEN);
        }
        else if(data < 50)
        {
            UI.Sensor_Box_Draw.progress2.setForeground(Color.RED);
            
            //UI.Sensor_Box_Draw.progress2.setBackground(Color.WHITE);
            
            //new NoticeWindow(NoticeType.WARNING_NOTIFICATION,"Humidity Level Unstable Please Turn On Sprinkler",NoticeWindow.SHORT_DELAY,NPosition.TOP_RIGHT);
        }
        
        UI.Sensor_Box_Draw.progress2.setValue(data);
        
        //UI.Sensor_Box_Draw.progress2.setValue(data);
        
        //UI.Sensor_Box_Draw.progress3.setValue(data);
    }
}


