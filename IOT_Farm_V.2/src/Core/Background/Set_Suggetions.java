package Core.Background;

import Core.MySql.Load_BoxA;
import Core.MySql.Load_BoxB;

import java.sql.SQLException;

import java.util.Timer;

import java.util.TimerTask;

import java.util.logging.Level;

import java.util.logging.Logger;

public class Set_Suggetions
{
    public static void get_Data() throws SQLException
    {
        Load_BoxA box_a = new Load_BoxA();
        
        Load_BoxB box_b = new Load_BoxB();
        
        double value = Double.parseDouble(box_a.load_condition("Temperature"));
                
        int myInt = (int) value;
        
        int soil_moisture = (int)Double.parseDouble(box_b.load_condition("Soil_Moisture"));
        
        int humidity = (int)Double.parseDouble(box_a.load_condition("Humidity"));
        
        //UI.Sensor_Box.jLabel27.setText(box_a.load_condition("Gas_Value")+" PPM");
        
        UI.Suggetions.bar_1.setValue(myInt);
        
        UI.Suggetions.bar_2.setValue(humidity);
        
        UI.Suggetions.bar_3.setValue(soil_moisture);
                
       // UI.Sensor_Box.jLabel32.setText(box_a.load_condition("Heat_Index")+" F");
        
        //UI.Sensor_Box.jLabel37.setText(box_a.load_condition("Humidity")+"%");
        
        //UI.Sensor_Box.jLabel34.setText(box_b.load_condition("Water_Level")+"%");

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
                    get_Data();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Set_Digital.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 10000);
    }
    
}
