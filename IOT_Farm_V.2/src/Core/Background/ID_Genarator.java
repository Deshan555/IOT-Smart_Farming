/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Background;

import java.util.Random;

/**
 *
 * @author Jayashanka Deshan
 */
public class ID_Genarator 
{
    public static int id()
    {
        Random rand = new Random();
        
        int random_id = rand.nextInt(99999);

        return random_id;
    }
    
}
