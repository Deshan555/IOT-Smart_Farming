package Core.Background;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

public class time_management 
{
   public static int time_management(String return_day)
   {		
	//Parsing the date
	LocalDate dateBefore = LocalDate.parse(get_localDate.LocalDate());
	
        LocalDate dateAfter = LocalDate.parse(return_day);
		
	//calculating number of days in between
	long days = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        
        int days_ = (int)days;
		
	//displaying the number of days
	System.out.println(days);
        
        return days_;       
   }
}