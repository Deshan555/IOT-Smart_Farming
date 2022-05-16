package Core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class get_localDate
{
    public static String LocalDate()
    {
        LocalDateTime myObj = LocalDateTime.now();
        
        String date = String.valueOf(myObj);

        return date;
    }
    
    public static String Date()
    {
        LocalDate myObj = LocalDate.now();
        
        String date = String.valueOf(myObj);

        return date;
    }
    
    public static String Time()
    {
         LocalTime time = LocalTime.now();
        
        String times = String.valueOf(time);

        return times;
    }
}

