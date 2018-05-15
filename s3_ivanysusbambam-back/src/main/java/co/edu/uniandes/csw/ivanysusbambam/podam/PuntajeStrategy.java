/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.podam;

import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author if.garcia
 */
public class PuntajeStrategy implements AttributeStrategy<Double> {

    /**
     * @return valor del puntaje
     */
    @Override
    public Double getValue() {

        Double l = null;

        do {
            l = (Math.random() * 4) + 1;
        } while (l <= 0);

        return l;
    }

}
