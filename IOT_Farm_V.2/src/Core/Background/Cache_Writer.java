package Core.Background;

import java.io.BufferedWriter;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.PrintWriter;

public class Cache_Writer
{
    public static String add_data(String city_name,String db_file) throws IOException
    {
        String file_name = db_file;
        
        FileOutputStream details = new FileOutputStream(file_name);

        PrintWriter file = new PrintWriter(details);

        BufferedWriter store = new BufferedWriter(file);

        store.write(city_name);
                
        store.newLine();

        store.close();

        file.close();

        System.out.print("Data Successfully Entered To "+file_name+"\n");
        
        String message = "Data Successfully Entered To "+file_name;
        
        return message;

    }
}

