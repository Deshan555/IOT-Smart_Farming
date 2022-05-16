package Core;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Log 
{
    public static void add_Log(String status)
    {
        Connection conn = Connector.connection();
        
        String Time = get_localDate.Date()+" | "+get_localDate.Time();
         
        String query = "UPDATE devices SET status = '"+status+"', last_active = '"+Time+"' WHERE device_ID = "+Cache_Reader.reader("device.key")+";";
        
        System.out.println(query);
        
        try
        {
           PreparedStatement preparedStatement = conn.prepareStatement(query);

           preparedStatement.executeUpdate();
           
        }
        catch(SQLException ERROR)
        {
             JOptionPane.showMessageDialog(null,"SQL ERROR : \n"+ERROR);
        }
    }
    
}
