 package Core;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class Cache_Reader 
{
    public static String reader(String file_name)
    {
        String user_name = null;
        
        try
        {
            String db_name = file_name;
            
            FileInputStream fis = new FileInputStream(db_name);
            
            Scanner output = new Scanner(fis);    
            
            while (output.hasNext())
            {
                user_name = output.nextLine();          
            }
            
            return user_name;
        }
        catch(Exception error)
        {
            return user_name;
        }
       
    }

}
