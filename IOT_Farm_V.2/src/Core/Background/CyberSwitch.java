package Core.Background;

import UI.Cyber_Switch;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class CyberSwitch implements Runnable
{
    private final Thread thread;
    
    public static String redirect;
    
    public CyberSwitch()
    {
        thread = new Thread(this);
    }
    
    public void link_install(String link)
    {
        redirect = link;
    }

    @Override
    public void run()
    {
        Network_Check check = new  Network_Check();
        
        check.start();
        
        try
        {
            URL sprinkler = new URL(redirect);
            
            URLConnection connect = sprinkler.openConnection();

            BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));

            String input_line;
            
            Cyber_Switch.cmd.append("\nServer Reaponding...\n");
            
            while((input_line = input.readLine()) != null)
            {
                Cyber_Switch.cmd.append(input_line+"\n");
            }
            
            input.close();
        }
        catch(Exception error)
        {
            Cyber_Switch.cmd.append("Request Abort : "+error+"\n");
        }
        
        Cyber_Switch.cmd.setCaretPosition(Cyber_Switch.cmd.getDocument().getLength() -1);
    }
    
    public void start()
    {
        thread.start();
    }
}
