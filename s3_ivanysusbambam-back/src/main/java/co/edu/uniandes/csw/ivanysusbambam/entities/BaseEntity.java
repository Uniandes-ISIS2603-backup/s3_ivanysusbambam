/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.ivanysusbambam.entities;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Generic entity with ID and name fields to inherit from.
 *
 * This entity sets a standar of fields and functions all entities in a project
 * should have. For example, all entities should be compared by ID when not
 * null, otherwise use the object equals method.
 *
 * @author ISIS2603
 */
@MappedSuperclass
@Stateless
public abstract class BaseEntity implements Serializable {

    /**
     * Id de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la entidad
     */
    private String name;

    /**
     * @return Id de la entidad
     */
    public Long getId() {
        return id;
    }

    /**
     * Seta el id de la entidad al dado por parametro
     *
     * @param id id de la entidad
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return nombre de la enitdad
     */
    public String getName() {
        return name;
    }

    /**
     * Setea el nombre de la entidad al dado por parametro
     *
     * @param name nombre de la entidad
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * metodo equals
     *
     * @param obj objeto a compara
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BaseEntity)) {
            return false;
        }

        if (this.getId() != null && ((BaseEntity) obj).getId() != null) {
            return this.getId().equals(((BaseEntity) obj).getId());
        }
        return super.equals(obj);
    }

    /**
     * @return Hash Code
     */
    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }
}
