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
public class CedulaStrategy implements AttributeStrategy<Long> {

    /**
     * @return el valor de la cedula
     */
    @Override
    public Long getValue() {
        Random r = new Random();

        Long l = null;

        do {
            l = (long) r.nextInt();
        } while (l <= 0 || String.valueOf(l).length() > 10);

        return l;
    }

}
