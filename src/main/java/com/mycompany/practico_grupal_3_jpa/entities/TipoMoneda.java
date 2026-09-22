
package com.mycompany.practico_grupal_3_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table(name = "tipo_moneda")
public class TipoMoneda extends AuditoriaApp{
    @Column(nullable = false)
    private String codigoAfip;
    @Column(nullable = false)
    private String denominacion;
    @Column(nullable = false)
    private String simbolo;

    public TipoMoneda() {
    }

    public TipoMoneda(String codigoAfip, String denominacion, String simbolo) {
        this.codigoAfip = codigoAfip;
        this.denominacion = denominacion;
        this.simbolo = simbolo;
    }

    public String getCodigoAfip() {
        return codigoAfip;
    }

    public void setCodigoAfip(String codigoAfip) {
        this.codigoAfip = codigoAfip;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    
}
