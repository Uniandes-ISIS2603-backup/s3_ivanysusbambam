/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.ivanysusbambam.dtos;

import co.edu.uniandes.csw.ivanysusbambam.entities.AutomovilEntity;

/**
 *
 * @author a.bravo
 */
public class AutomovilDetailDTO extends AutomovilDTO{
    public AutomovilDetailDTO(){
    }
    public AutomovilDetailDTO(AutomovilEntity entity){
        super(entity);
    }
    @Override
    public AutomovilEntity toEntity(){
        AutomovilEntity autoE = super.toEntity();
        return autoE;
    }
}
