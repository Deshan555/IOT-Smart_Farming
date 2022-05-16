package Core.Background;

import Core.SQL_Lite3.Load_Data;
import static UI.Globle_weather.jLabel14;
import static UI.Globle_weather.jLabel15;
import static UI.Globle_weather.jLabel16;
import static UI.Globle_weather.jLabel18;
import static UI.Globle_weather.jLabel2;
import static UI.Globle_weather.jLabel21;
import static UI.Globle_weather.jLabel24;
import static UI.Globle_weather.jLabel27;
import static UI.Globle_weather.jLabel7;
import java.util.Timer;
import java.util.TimerTask;

public class Task_Schedule 
{
    public static void load_data()
    {
        jLabel2.setText(Load_Data.load_condition("Weather"));
        
        jLabel27.setText(Load_Data.load_condition("Weather")+","+Load_Data.load_condition("Weather_description"));
        
        jLabel24.setText(Load_Data.load_condition("Feel_Like")+" F");
        
        jLabel18.setText(Load_Data.load_condition("Wind_Speed")+" km/h");
        
        jLabel21.setText(Load_Data.load_condition("Pressure")+" MB");
        
        jLabel14.setText("Max Temperature : "+Load_Data.load_condition("Max_Temp")+" F");
        
        jLabel15.setText("Min Temperature : "+Load_Data.load_condition("Min_Temp")+ " F");
        
        jLabel7.setText("Temperature In F : "+Load_Data.load_condition("Temperature")+ " F");
        
        jLabel16.setText(Load_Data.load_condition("Humidity")+"%");
        
        
    }
    
    public static void tasker()
    {
                Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                
                load_data();
            }
        }, 0, 5000);
    }
    
    
    
}
