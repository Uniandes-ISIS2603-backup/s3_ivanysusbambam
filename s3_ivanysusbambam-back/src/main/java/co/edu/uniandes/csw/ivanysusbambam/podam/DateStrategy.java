/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.podam;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author hd.castellanos
 */
public class DateStrategy implements AttributeStrategy<Date> {

    @Override
    public Date getValue() {
        Random r = new Random();
        Calendar c = Calendar.getInstance();
        int maxYear = 9999;
        c.set(Calendar.YEAR, r.nextInt(
                maxYear - c.getActualMinimum(Calendar.YEAR) + 1)
                + c.getActualMinimum(Calendar.YEAR));
        c.set(Calendar.DAY_OF_YEAR, r.nextInt(
                c.getActualMaximum(Calendar.DAY_OF_YEAR) - c.getActualMinimum(Calendar.DAY_OF_YEAR) + 1)
                + c.getActualMinimum(Calendar.DAY_OF_YEAR));
        c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
        c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, c.getActualMinimum(Calendar.MILLISECOND));
        return c.getTime();
    }
}
