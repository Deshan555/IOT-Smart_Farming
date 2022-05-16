/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Background;

import UI.Cyber_Switch;

import java.io.IOException;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;


public class Network_Check implements Runnable
{
    private final Thread thread;
    
    public Network_Check()
    {
        thread = new Thread(this);
    }

    @Override
    public void run()
    {
        Cyber_Switch.cmd.append("\nPinging To http://www.google.com...\n");
        try 
        {
         URL url = new URL("http://www.google.com");
         
         URLConnection connection = url.openConnection();
         
         connection.connect();
         
         Cyber_Switch.cmd.append("Network Check Finished...\n");
        } 
        catch (MalformedURLException e)
        {                  
            Cyber_Switch.cmd.append("\nError : "+String.valueOf(e)+"\n");
        }
        catch (IOException e)
        {         
            Cyber_Switch.cmd.append("\nError : "+String.valueOf(e)+"\n");
        }
    }
    
    public void start()
    {
        thread.start();
    }
}