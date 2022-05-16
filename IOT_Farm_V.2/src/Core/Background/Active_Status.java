
package Core.Background;

import Core.Background.Bugs_Log;
import Core.MySql.Connector;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class Active_Status 
{
    public static String load_status(String condition) throws SQLException
    {
        String value = null;
        
        String SQL = "SELECT status FROM devices WHERE device_ID = "+condition+";";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                value = rs.getString("status");
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
