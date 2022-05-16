/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Background;

import UI.Cyber_Switch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Jayashanka Deshan
 */
public class cyber_switch 
{
    public static void turn_onA() throws IOException
    {
        URL sprinkler = new URL("http://192.168.1.102/LED1=ON");

        URLConnection connect = sprinkler.openConnection();

        BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));

        String input_line;

        while((input_line = input.readLine()) != null)
        {
            Cyber_Switch.cmd.append(input_line+"\n");
        }

        input.close();
    }
}
