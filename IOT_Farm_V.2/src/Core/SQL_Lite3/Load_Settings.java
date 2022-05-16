
package Core.SQL_Lite3;

import Cryptography.Decryption;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;

public class Load_Settings 
{
    public static String load_data(String setting_type)
    {
        String value = null;
        
        String SQL = "SELECT VALUE FROM MY_SQL WHERE TITLE = '"+setting_type+"';";
        
        Connection connection = Lite_Connector.connect_config();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                value = rs.getString("VALUE");
            }
            
            return Decryption.decrypt(value);
        }
        catch(Exception ERROR)
        {
            return "settings_not_found";
        }
    }
    
    public static String load_table(String setting_type)
    {
        String value = null;
        
        String SQL = "SELECT VALUE FROM SETTINGS WHERE SETTING_TYPE = '"+setting_type+"';";
        
        Connection connection = Lite_Connector.connect_config();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                value = rs.getString("VALUE");
            }
            
            return Decryption.decrypt(value);
        }
        catch(Exception ERROR)
        {
            return "settings_not_found";
        }
    }
}
