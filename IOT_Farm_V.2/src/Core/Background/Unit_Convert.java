
package Core.Background;

public class Unit_Convert 
{
    public static int FtoC(int unit)
    {
        int celsius = (unit - 32)* 5/9;
        
        return celsius;
    }
    
    public static String KtoC(String base)
    {
        double unit = Double.parseDouble(base);
        
        double c = unit - 273.15;
        
        int convert = (int) c;
        
        return String.valueOf(convert); 
    }
    
    //56.7
    
    public static int presantage(String base)
    {
        double unit = Double.parseDouble(base);
        
        double c = ((unit - 273.15)/56.7)*100;
        
        int convert = (int) c;
        
        return convert; 
    }
    
}
