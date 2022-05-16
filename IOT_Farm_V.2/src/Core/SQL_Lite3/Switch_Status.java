package Core.SQL_Lite3;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Statement;


public class Switch_Status 
{
    static Connection connection = Lite_Connector.connect_config();
    
    public static String load_Switch(String SID)
    {
        String status = null;
        
        String SQL = "SELECT Status FROM Switches WHERE SID = "+SID+";";
                
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                status  = rs.getString("Status");
            }
            
            return status;
        }
        catch(Exception ERROR)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(ERROR));
            
            System.out.println(ERROR);
            
            return "D";
        }
    }
    
    public static void save_Status(String SID, String status)
    {
        String SQL_1 = "UPDATE Switches SET Status = '"+status+"' WHERE SID = "+SID+";";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_1);

            preparedStatement.executeUpdate();
            
        }
        catch(Exception error)
        {
            System.out.println(error);
            
            Core.Background.Bugs_Log.exceptions(String.valueOf(error));
        }
    }
    
    public static void main(String[] args)
    {
        //save_Status("1","A");
        
        System.out.println(load_Switch("2"));
    }
}
