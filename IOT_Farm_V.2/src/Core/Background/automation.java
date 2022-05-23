
package Core.Background;

import Core.MySql.Load_BoxA;

import Core.MySql.Load_BoxB;

import static Core.SQL_Lite3.Load_Crops.load_condition;

import Core.SQL_Lite3.Load_Settings;


import java.sql.SQLException;

import java.util.Timer;

 import java.util.TimerTask;

public class automation 
{
    static String link_1 = Load_Settings.load_table("LINK1");
            
    static String link_2 = Load_Settings.load_table("LINK2");
            
    static  String link_3 = Load_Settings.load_table("LINK3");
    
    
    public void condition_check(String crop)
    {
        Load_BoxA box_a = new Load_BoxA();
        
        Load_BoxB box_b = new Load_BoxB();
        
        Request_Make request_1 = new Request_Make();
        
        Request_Make request_2 = new Request_Make();
        
        Request_Make request_3 = new Request_Make();
        
        int min_temp = Integer.valueOf(load_condition(crop, "min_temp"));
        
        int max_temp = Integer.valueOf(load_condition(crop, "max_temp"));
        
        int min_humidity = Integer.valueOf(load_condition(crop, "min_humidity"));
        
        int max_humidity = Integer.valueOf(load_condition(crop, "max_humidity"));
        
        int min_soil = Integer.valueOf(load_condition(crop, "min_soil"));
        
        int max_soil = Integer.valueOf(load_condition(crop, "max_soil"));
                
        try
        {
            double current_temp = Double.parseDouble(box_a.load_condition("Temperature"));
            
            double current_humidity = Double.parseDouble(box_a.load_condition("Humidity"));
            
            double soil_mois = Double.parseDouble(box_b.load_condition("Soil_Moisture"));
            
                        
            if((current_temp > min_temp) && (current_temp < max_temp))
            {
                http_Get.send_Request(link_1+"/off");
            }
            else
            {
                http_Get.send_Request(link_1+"/on");
            }
            
            
            
            if((current_humidity > min_humidity) && (current_humidity < max_humidity))
            {
                http_Get.send_Request(link_2+"/off");
            }
            else
            {
                http_Get.send_Request(link_2+"/on");
            }
            
            
            
            if((soil_mois > min_soil) && (soil_mois < max_soil))
            {
                http_Get.send_Request(link_3+"/off");
            }
            else
            {
                http_Get.send_Request(link_3+"/on");
            }
        }
        catch(SQLException error)
        {
           Core.Background.Bugs_Log.exceptions(String.valueOf(error));
        }
        
    }
       
    public static void tasker()
    {
        Timer t = new Timer();
        
        t.schedule(new TimerTask()
        {
            @Override
        
            public void run() 
            {
                try
                {
                    automation automatic = new automation();
                    
                    automatic.condition_check(Cache_Reader.data("Crop.dat"));
                }
                catch(Exception error)
                {
                    Core.Background.Bugs_Log.exceptions(String.valueOf(error));
                }
                
            }
        }, 0, 15000);
    }
        
}
