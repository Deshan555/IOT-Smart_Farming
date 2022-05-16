package Core;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

public class Presant_Validation 
{
    public static int validation_userID(String index)
    {
        Connection connection =  Connector.connection();
        
        String SQL = "SELECT * FROM employee WHERE Emp_id = "+index+" AND "+Cache_Reader.reader("section.key")+" = 'true';";
            
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
                        
            if(!rs.next())
            {                
                return 0;
            }
            else
            {
                System.out.print("1");
                
                return 1;
            }
        }
        catch(Exception ERROR)
        {
            System.out.println(ERROR);
                       
            return 0;
        }
    }
}
