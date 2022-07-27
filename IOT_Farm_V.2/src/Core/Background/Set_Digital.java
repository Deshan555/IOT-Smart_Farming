package Core.Background;

import Core.MySql.Load_BoxA;

import Core.MySql.Load_BoxB;

import java.sql.SQLException;

import java.util.Timer;

import java.util.TimerTask;

import java.util.logging.Level;

import java.util.logging.Logger;

public class Set_Digital 
{
    public static void get_Data() throws SQLException
    {
        Load_BoxA box_a = new Load_BoxA();
        
        Load_BoxB box_b = new Load_BoxB();
        
        UI.Sensor_Box.jLabel27.setText(box_a.load_condition("Gas_Value")+" PPM");
        
        UI.Sensor_Box.jLabel29.setText(box_a.load_condition("Temperature")+" C");
                
        UI.Sensor_Box.jLabel32.setText(box_a.load_condition("Heat_Index")+" C");
        
        UI.Sensor_Box.jLabel37.setText(box_a.load_condition("Humidity")+"%");
        
        int get_waterLv = water_lvReformat.data_fix(box_b.load_condition("Water_Level"));
        
        UI.Sensor_Box.jLabel34.setText(String.valueOf(get_waterLv)+"%");
        
        UI.Sensor_Box.jLabel28.setText(box_b.load_condition("Soil_Moisture")+"%");

    }
    
    public static void notice_board() throws SQLException
    {
        Load_BoxA box_a = new Load_BoxA();
        
        Load_BoxB box_b = new Load_BoxB();
        
        String time = box_a.load_condition("Record_Time");
                
        String temp = box_a.load_condition("Temperature");
        
        String humidity = box_a.load_condition("Humidity");
        
        String heat_index = box_a.load_condition("Humidity");
        
        String water_lv = box_b.load_condition("Water_Level");
        
        String soil_lv = box_b.load_condition("Soil_Moisture");
        
        int get_waterLv = water_lvReformat.data_fix(box_b.load_condition("Water_Level"));
        
        UI.Sensor_Box.jTextArea1.append("Update Time : "+time+"\n");
        
        UI.Sensor_Box.jTextArea1.append("------------------GREEN HOUSE------------------\n\n\n");
        
        UI.Sensor_Box.jTextArea1.append("Temperature In Green House : "+temp+"C\n\n");
        
        UI.Sensor_Box.jTextArea1.append("Humidity In Green House : "+humidity+"%\n\n");
        
        UI.Sensor_Box.jTextArea1.append("Feel Like In Green House : "+heat_index+"C\n\n");
        
        UI.Sensor_Box.jTextArea1.append("------------------HYDROPONICS------------------\n\n\n");
        
        UI.Sensor_Box.jTextArea1.append("Water Level In Hydroponics : "+String.valueOf(get_waterLv)+"%\n\n");
        
        UI.Sensor_Box.jTextArea1.append("-----------------SOIL MOSITURE-----------------\n\n\n");
        
        UI.Sensor_Box.jTextArea1.append("Soil Moisture In Indoor : "+soil_lv+"%\n\n");
        
        UI.Sensor_Box.jTextArea1.append("\n\n\n\n");
        
        UI.Sensor_Box.jTextArea1.setCaretPosition(UI.Sensor_Box.jTextArea1.getDocument().getLength() -1);
        

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
                    
                    notice_board();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Set_Digital.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, 0, 10000);
    }
    
}
