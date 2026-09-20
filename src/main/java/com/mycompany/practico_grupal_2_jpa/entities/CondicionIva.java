
package com.mycompany.practico_grupal_2_jpa.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */

@Entity
@Table (name = "condicion_iva")
public class CondicionIva extends AuditoriaApp{
    @Column(nullable = false)
    private int codigoAfip;
    @Column(nullable = false)
    private String denominacion;

    public CondicionIva() {
    }

    public CondicionIva(int codigoAfip, String denominacion) {
        this.codigoAfip = codigoAfip;
        this.denominacion = denominacion;
    }

    public int getCodigoAfip() {
        return codigoAfip;
    }

    public void setCodigoAfip(int codigoAfip) {
        this.codigoAfip = codigoAfip;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

}
