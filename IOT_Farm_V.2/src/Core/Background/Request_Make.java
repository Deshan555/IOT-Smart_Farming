/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Background;

import Core.SQL_Lite3.Load_Settings;

import Core.SQL_Lite3.Switch_Status;

public class Request_Make
{
    http_Request open = new http_Request();
    
    static String link_1 = Load_Settings.load_table("LINK1");
            
    static String link_2 = Load_Settings.load_table("LINK2");
            
    static  String link_3 = Load_Settings.load_table("LINK3");
    
    
    public void switch_1_turnOn()
    {
        Switch_Status.save_Status("1", "A");
        
        open.link_install(link_1+"/on");
                
        open.start();
    }
    
    public void switch_1_turnOff()
    {
        Switch_Status.save_Status("1", "D");
        
        open.link_install(link_1+"/off");
                
        open.start();
    }
        
    public void switch_2_turnOn()
    {
        Switch_Status.save_Status("2", "A");
        
        open.link_install(link_2+"/on");
                
        open.start();
    }
        
    public void switch_2_turnOff()
    {
        Switch_Status.save_Status("2", "D");
        
        open.link_install(link_2+"/off");
                
        open.start();
    }
        
    public void switch_3_turnOn()
    {
        Switch_Status.save_Status("3", "A");
        
        open.link_install(link_3+"/on");
        
        System.out.println(link_3);
                
        open.start();
    }
        
    public void switch_3_turnOff()
    {
        Switch_Status.save_Status("3", "D");
        
        open.link_install(link_3+"/off");
        
        System.out.println(link_3);
                
        open.start();
    }
}
