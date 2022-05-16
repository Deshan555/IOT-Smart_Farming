/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.SQL_Lite3;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import Core.Background.Bugs_Log;

/**
 *
 * @author Jayashanka Deshan
 */
public class Lite_Connector 
{
    public static Connection connect()
    {
        Connection conn = null;
        
        try
        {
            String url = "jdbc:sqlite:weather.db";// db parameters

            conn = DriverManager.getConnection(url);// create a connection to the database
            
        }
        catch(SQLException error)
        {
            Bugs_Log.exceptions(String.valueOf(error));
        }
        
        return conn;
    }
    
    public static Connection connect_config()
    {
        Connection conn = null;
        
        try
        {
            String url = "jdbc:sqlite:Config.db";// db parameters

            conn = DriverManager.getConnection(url);// create a connection to the database
            
        }
        catch(SQLException error)
        {
            Bugs_Log.exceptions(String.valueOf(error));
        }
        
        return conn;
    }
    
}
