
package Core.MySql;

import Core.Background.Bugs_Log;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.logging.Level;

import java.util.logging.Logger;

public class Load_BoxB 
{
    public static String load_condition(String condition) throws SQLException
    {
        String value = null;
        
        String SQL = "SELECT "+condition+" FROM real_time_box_2 WHERE Record_ID = 1689;";
        
        Connection connection = Connector.connection();
        
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
            
            connection.close();
            
            return "null";
        }
    }
}
