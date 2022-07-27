
package Core.Background;

public class water_lvReformat 
{
    public static int data_fix(String data)
    {        
        float val_float = Float.parseFloat(data);
        
        float val = (float) ((val_float/470.0)*100);
        
        return (int)val;
    }
}
