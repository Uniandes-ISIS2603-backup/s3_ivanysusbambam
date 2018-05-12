/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.podam;


import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author if.garcia
 */
public class TelefonoStrategy implements AttributeStrategy<Integer>{

    @Override
    public Integer getValue() {
        Random r = new Random();
       String num1 = String.valueOf((int) (Math.random() * 9));
        String num2 = String.valueOf((int) (Math.random() * 9));
        String num3 = String.valueOf((int) (Math.random() * 9));
        String num4 = String.valueOf((int) (Math.random() * 9));
        String num5 = String.valueOf((int) (Math.random() * 9));
        String num6 = String.valueOf((int) (Math.random() * 9));
        String num7 = String.valueOf((int) ((Math.random() * 8)+1));
        
        return  Integer.valueOf(num7+num6+num5+num4+num3+num2+num1);
                
        
        
    }
    
}
