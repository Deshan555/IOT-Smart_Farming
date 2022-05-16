package Core.SQL_Lite3;

import Cryptography.Encryption;

import java.sql.Connection;

import java.sql.PreparedStatement;

public class Save_SQL 
{
    public static int save_settings(String value_1,String value_2,String value_3,String value_4,String value_5)
    {
        Connection connection = Lite_Connector.connect_config();
        
        String SQL_1 = "UPDATE MY_SQL SET VALUE = '"+Encryption.encrypt(value_1)+"' WHERE TITLE = 'HOST';";
        
        String SQL_2 = "UPDATE MY_SQL SET VALUE = '"+Encryption.encrypt(value_2)+"' WHERE TITLE = 'PORT';";
        
        String SQL_3 = "UPDATE MY_SQL SET VALUE = '"+Encryption.encrypt(value_3)+"' WHERE TITLE = 'UNAME';";
        
        String SQL_4 = "UPDATE MY_SQL SET VALUE = '"+Encryption.encrypt(value_4)+"' WHERE TITLE = 'DBNAME';";
        
        String SQL_5 = "UPDATE MY_SQL SET VALUE = '"+Encryption.encrypt(value_5)+"' WHERE TITLE = 'PASSWORD';";
        
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
            
            preparedStatement = connection.prepareStatement(SQL_4);

            preparedStatement.executeUpdate();
            
             preparedStatement = connection.prepareStatement(SQL_5);

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
