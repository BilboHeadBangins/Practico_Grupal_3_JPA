
package com.mycompany.practico_grupal_3_jpa.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name = "marca")
public class Marca extends AuditoriaApp{
    @Column(nullable = false)
    private String denominacion;
    @Column(nullable = false)
    private Integer codigo;

    public Marca() {
    }

    public Marca(String denominacion, Integer codigo) {
        this.denominacion = denominacion;
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
