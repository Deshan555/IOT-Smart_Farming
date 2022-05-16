
package Core.Background;

import static UI.Sensor_Box_Draw.chart_1;

import com.deshan.chart.ModelChartLine;

import java.util.ArrayList;

import java.util.List;

import java.util.Timer;

import java.util.TimerTask;

import Core.MySql.Load_BoxA;

public class Temp_Chart
{
    
    public static List<ModelChartLine> list = new ArrayList<>();
    

    public static void update_dataPanel()
    {
        Load_BoxA box_a = new Load_BoxA();
        
        try
        { 
            UI.Sensor_Box_Draw.jTextArea2.append(box_a.load_condition("Record_Time")+"\t\t\tTemperature : "+box_a.load_condition("Temperature")+"F\n\n");
        }
        catch(Exception error)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(error));
        }     
    }
        
    public static void update_chart()
    {
        Load_BoxA box_a = new Load_BoxA();
        
        try
        {
            list.add(new ModelChartLine("Data", Double.parseDouble(box_a.load_condition("Temperature"))));
        }
        catch(Exception error)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(error));
        }
        chart_1.setModel(list);
    }
    
    
    public static void tasker()
    {
        Timer t = new Timer();
        
        t.schedule(new TimerTask()
        {
            @Override
        
            public void run() 
            {
                
                update_chart();
                
                update_dataPanel();
                  
            }
        }, 0, 15000);
    }
}
