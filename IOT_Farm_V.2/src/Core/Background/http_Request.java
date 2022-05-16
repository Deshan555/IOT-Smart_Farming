package Core.Background;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class http_Request implements Runnable
{
    private final Thread thread;
    
    public static String redirect;
    
    public http_Request()
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
        try
        {
            URL sprinkler = new URL(redirect);
            
            URLConnection connect = sprinkler.openConnection();

            BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            
            input.close();
        }
        catch(Exception error)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(error));
            
            System.out.println(error);
        }
    }
    
    public void start()
    {
        thread.start();
    }
}
