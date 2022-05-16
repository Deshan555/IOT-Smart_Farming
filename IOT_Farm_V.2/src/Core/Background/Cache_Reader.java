 package Core.Background;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class Cache_Reader 
{
    public static String data(String file_name) throws FileNotFoundException
    {
        String db_name = file_name;
        
        FileInputStream fis = new FileInputStream(db_name);

        Scanner output = new Scanner(fis);
        
        String data = null;

        while (output.hasNext())
        {
            data = output.nextLine();          
        }
        
        return data;
    }

}
