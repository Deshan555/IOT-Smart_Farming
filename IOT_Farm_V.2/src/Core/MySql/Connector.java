package Core.MySql;

import Core.SQL_Lite3.Load_Settings;
import java.sql.Connection;

import java.sql.DriverManager;

public class Connector
{
    public static Connection connection()
    {
        Connection conn = null;
        
        String host = Load_Settings.load_data("HOST");
        
        String port = Load_Settings.load_data("PORT");
        
        String user_name = Load_Settings.load_data("UNAME");
        
        String password = Load_Settings.load_data("PASSWORD");
        
        String db_name = Load_Settings.load_data("DBNAME");

        String database_url = "jdbc:mysql://"+host+":"+port+"/"+db_name+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try
        {
           conn = DriverManager.getConnection(database_url, user_name, password);
            
        }
        catch (Exception ERROR)
        {
            System.out.println("Error Message : "+ERROR);
        }
        return conn;
    }
    
}
