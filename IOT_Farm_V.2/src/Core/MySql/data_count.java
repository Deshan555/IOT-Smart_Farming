
package Core.MySql;

import Core.Background.Bugs_Log;
import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

public class data_count 
{
    public static int count(String table_name)
    {
        String sql = "SELECT * FROM "+table_name+";";
        
         Connection connection = Connector.connection();
         
         int count = 0;
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                count = count + 1;
            }
            
            connection.close();
            
            return count;
        }
        catch(SQLException ERROR)
        {            
            System.out.println(ERROR);
        }
        
        return count;
    }
    
    public static void main(String[] args)
    {
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;
        
        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                    String value = rs.getString("temperature");
                
                    String date =  rs.getString("record_date");
                
                    String time =  rs.getString("record_time");
                
                    System.out.println(value+" "+date+" "+time+"\n");
                }
                
                x++;
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
    }
}
