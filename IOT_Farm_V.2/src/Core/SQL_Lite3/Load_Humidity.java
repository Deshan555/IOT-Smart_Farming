
package Core.SQL_Lite3;

import Core.Background.Bugs_Log;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class Load_Humidity 
{
    public static String load_condition(int KEY) throws SQLException
    {
        String value = null;
        
        String SQL = "SELECT * FROM Humidity WHERE KEY = "+KEY+";";
        
        Connection connection = Lite_Connector.connect();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                value = rs.getString("Value");
            }
            
            connection.close();
            
            return value;
        }
        catch(Exception ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            connection.close();
            
            return "null";
        }
    }
}
