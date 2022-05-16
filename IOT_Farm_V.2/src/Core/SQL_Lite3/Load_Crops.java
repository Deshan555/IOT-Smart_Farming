
package Core.SQL_Lite3;

import Core.Background.Bugs_Log;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.logging.Level;

import java.util.logging.Logger;

public class Load_Crops
{
    public static String load_condition(String crop, String condition)
    {
        String value = null;
        
        String SQL = "SELECT "+condition+" FROM crops WHERE crop_name = '"+crop+"'";
        
        Connection connection = Lite_Connector.connect_config();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                value = rs.getString(condition);
            }
            
            connection.close();
            
            return value;
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
            
            try 
            {
                connection.close();
            }
            catch(SQLException ex) 
            {
                Logger.getLogger(Load_Data.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return "null";
        }

    }
    
    public static void main(String[] args)
    {
        System.out.println(load_condition("Tomato", "min_temp"));
    }
}
