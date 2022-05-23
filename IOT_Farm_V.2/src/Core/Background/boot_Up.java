/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Background;

import Core.MySql.Connector;
import UI.home;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jayashanka Deshan
 */
public class boot_Up implements Runnable
{
    private final Thread thread;
    
    public boot_Up()
    {
        thread = new Thread(this);
    }
    
    @Override    
    public void run()
    {
        Connection connection =  Connector.connection();
        
        String SQL = "SELECT * FROM to_do";
        
        int counter = 0;
        
        int events = 0;
                    
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                int days = time_management.time_management(rs.getString("TASK_DATE"));
                
                if(days < 7)
                {                    
                    events ++;
                }

                
                counter++;
            }
        }
        catch(SQLException ERROR)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(ERROR));
        }
        
        home Home = new home();
        
        Home.notifications("You Have To "+events+" Upcomming Events Visit Task Section and take action",1);
    }
    
    public void start()
    {
        thread.start();
    }

    
}
