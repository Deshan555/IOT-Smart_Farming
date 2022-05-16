package Core;

import java.sql.Connection;

import java.sql.DriverManager;

public class Connector
{
    public static Connection connection()
    {
        Connection conn = null;
        
        String host = "localhost";
        
        String port = "3306";
        
        String user_name = "root";
        
        String password = "";
        
        String db_name = "data_store";

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
