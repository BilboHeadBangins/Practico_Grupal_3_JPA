package com.mycompany.practico_grupal_3_jpa.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name="cliente")
public class Cliente extends AuditoriaApp{
    @Column(nullable = false)
    private String cuitCuil;
    @Column(nullable = false)
    private String denominacion;
    @OneToOne
    @JoinColumn(name = "contacto_id", nullable = false)
    private Contacto contacto;
    @OneToOne
    @JoinColumn(name="domicilio_id", nullable = false)
    private Domicilio domicilio;  

    public Cliente() {
    }

    public Cliente(String cuitCuil, String denominacion, Contacto contacto, Domicilio domicilio) {
        this.cuitCuil = cuitCuil;
        this.denominacion = denominacion;
        this.contacto = contacto;
        this.domicilio = domicilio;
    }

    public String getCuitCuil() {
        return cuitCuil;
    }

    public void setCuitCuil(String cuitCuil) {
        this.cuitCuil = cuitCuil;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
  
}
