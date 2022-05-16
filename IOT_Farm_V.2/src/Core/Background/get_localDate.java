package Core.Background;

import java.text.SimpleDateFormat;

import java.time.LocalDate;

import java.util.Locale;

public class get_localDate
{
    public static String LocalDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        LocalDate localDate = LocalDate.now();
        
        String date = String.valueOf(localDate);

        return date;
    }
}

