package Core;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

public class Presant_Validation 
{
    public static int validation_userID(String index)
    {
        Connection connection =  Connector.connection();
        
        String SQL = "SELECT * FROM attendance WHERE Emp_id = "+index+" AND Date_Record = '"+get_localDate.Date()+"'; ";
            
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
                        
            if(!rs.next())
            {
                System.out.print(rs.getString("emp_name"));
                
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
