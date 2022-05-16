/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Background;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import Core.SQL_Lite3.Lite_Connector;
import Core.SQL_Lite3.Load_Data;

/**
 *
 * @author Jayashanka Deshan
 */
public class Bugs_Log 
{
    public static void exceptions(String message)
    {
        String file_name = get_localDate.LocalDate()+"Bugs.dat";
        
        try
        {
            FileOutputStream details = new FileOutputStream(file_name,true);

            PrintWriter file = new PrintWriter(details);

            BufferedWriter store = new BufferedWriter(file);
            
            store.write(get_localDate.LocalDate()+"[ "+message+" ]\n");
                
            store.newLine();

            store.close();

            file.close();
        }
        catch(IOException Error)
        {
            Bugs_Log.exceptions(String.valueOf(Error));
        }
    }
}
