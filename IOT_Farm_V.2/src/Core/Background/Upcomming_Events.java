package Core.Background;

import Core.MySql.Connector;
import com.deshan.swing.noticeboard.ModelNoticeBoard;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jayashanka Deshan
 */
public class Upcomming_Events 
{
    
    public static void noticeboard_update()
    {
        //noticeBoard1
        
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
                    UI.task.noticeBoard.addDate(rs.getString("TASK_DATE"));
                
                    UI.task.noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), rs.getString("LOCATION_data"), String.valueOf(days)+" Available", rs.getString("Activity")+"\n"));
                
                    UI.task.noticeBoard.scrollToTop();
                    
                    events ++;
                }

                
                counter++;
            }
        }
        catch(SQLException ERROR)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(ERROR));
        }
        
       // UI.task.jLabel4.setText("TODO LIST : total tasks("+String.valueOf(counter)+")");
       
       UI.task.jLabel14.setText("UPCOMMING EVENTS ("+events+")");
       
       UI.task.jLabel18.setText("0"+String.valueOf(counter));
       
       UI.task.jLabel19.setText("0"+String.valueOf(events));
    }
}
