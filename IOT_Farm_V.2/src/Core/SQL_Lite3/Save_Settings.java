package Core.SQL_Lite3;

import Cryptography.Encryption;
import java.sql.Connection;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Save_Settings 
{
    public static int save_settings(String value_1,String value_2,String value_3)
    {
        Connection connection = Lite_Connector.connect_config();
        
        String SQL_1 = "UPDATE SETTINGS SET VALUE = '"+Encryption.encrypt(value_1)+"' WHERE SETTING_TYPE = 'LINK1';";
        
        String SQL_2 = "UPDATE SETTINGS SET VALUE = '"+Encryption.encrypt(value_2)+"' WHERE SETTING_TYPE = 'LINK2';";
        
        String SQL_3 = "UPDATE SETTINGS SET VALUE = '"+Encryption.encrypt(value_3)+"' WHERE SETTING_TYPE = 'LINK3';";
                
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_1);

            preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement(SQL_1);

            preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement(SQL_2);

            preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement(SQL_3);

            preparedStatement.executeUpdate();
                                
            return 1;
        }
        catch(Exception ERROR)
        {
            System.out.println(ERROR);
            
            return 0;
        }
    }
}
