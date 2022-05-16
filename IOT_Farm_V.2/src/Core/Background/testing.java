/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Background;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jayashanka Deshan
 */
public class testing 
{
    public static void main(String[] args) throws ParseException
    {
        String sDate1 = "2022-04-13";  
    
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
    
        System.out.println(sDate1+"\t"+date1);  
    }
    
}
