package Core.Background;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class py_executer implements Runnable
{
    private final Thread thread;
        
    public py_executer()
    {
        thread = new Thread(this);
    }
    
    @Override
    public void run()
    {
       try
       {
           ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "python open_weather.py");
           
           builder.redirectErrorStream(true);

           Process p = builder.start();

           BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

           String line;
           
           while (true)
           {
            line = r.readLine();
        
            if (line == null) { break; }
            
            System.out.println(line);
           }
       }
       catch(Exception Error)
       {
           System.out.println();
       }
    }
    
    public void start()
    {
        thread.start();
    }
}
