
package com.mycompany.practico_grupal_3_jpa.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name="articulo")
public class Articulo extends AuditoriaApp {
    @ManyToOne(fetch = FetchType.LAZY)
    private Rubro rubro;
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private String denominacion;
    @ManyToOne(fetch = FetchType.LAZY)
    private Marca marca;

    public Articulo() {
    }

    public Articulo(Rubro rubro, String codigo, String denominacion, Marca marca) {
        this.rubro = rubro;
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.marca = marca;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    } 
    
}
