package Core.Background;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.logging.Level;

import java.util.logging.Logger;

public class http_Get
{
    public static void send_Request(String argument)
    {

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "python Command_Line.py "+argument);
        
        builder.redirectErrorStream(true);

        try 
        {
            Process process = builder.start();
            
            BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;

        while (true) 
        {
            line = r.readLine();
        
            if (line == null) { break; }
            
            System.out.println(line);
        }
        }
        catch (IOException ex)
        {
            Logger.getLogger(http_Get.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}