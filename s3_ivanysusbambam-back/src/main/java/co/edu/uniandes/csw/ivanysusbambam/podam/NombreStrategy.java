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
 * @author f.velasquez
 */
public class NombreStrategy implements AttributeStrategy<String>{

    @Override
    public String getValue() {
        Random r = new Random();
       
        String s = new String();  
        
        byte[] array = new byte[1]; 
        
        byte longCadena; 
        
        do{
            r.nextBytes(array);
            longCadena = array[0];
        }
        while(longCadena <= 0);
        
        char c;
        for(int i = 0; i<longCadena; i++){
            c = (char) r.nextInt(127);
            if(esAlfabetica(c)){
                s+=c;
            }
            else i--;
        }
         
        return s;
    }
    
     /**
     * Verifica si el caracter pasado por parámetro pertenece a (A..Z) U (a..z) U {á,é,í,ó,ú,ü) 
     * @param s la cadena que se busca verificar.
     * @return true si la cadena es alfabética, false de lo contrario.
     */
   private static boolean esAlfabetica(char c){
       
        //se asegura que c es un caracter de la A-Z o de la a-z o espacio o una vocal con tilde o una ü.
        return (c>=65 && c<= 90) || (c>= 97 && c<=122) || (c == 32) ||(c>=160 && c <=165) || (c==130) || (c==129);
        
    }
    
}
