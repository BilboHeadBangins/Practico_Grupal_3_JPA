package com.mycompany.practico_grupal_3_jpa.entities;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.ToString;

/**
 *
 * @author italo
 */
@ToString
@MappedSuperclass
public abstract class AuditoriaApp extends EntityId{
    @Column(name="fecha_alta",nullable = false)
    protected LocalDateTime fechaAlta;
    @Column(name="fecha_baja")
    protected LocalDateTime fechaBaja;
    @Column(name="fecha_modificacion",nullable = false)
    protected LocalDateTime fechaModificacion;
    @ManyToOne
    @JoinColumn(name = "usuario_carga", nullable=false)
    protected Usuario usuarioCarga;
    @ManyToOne
    @JoinColumn(name = "usuario_baja")
    protected Usuario usuarioBaja;
    @ManyToOne
    @JoinColumn(name = "usuario_modificacion", nullable=false)
    protected Usuario usuarioModificacion;

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getUsuarioCarga() {
        return usuarioCarga;
    }

    public void setUsuarioCarga(Usuario usuarioCarga) {
        this.usuarioCarga = usuarioCarga;
    }

    public Usuario getUsuarioBaja() {
        return usuarioBaja;
    }

    public void setUsuarioBaja(Usuario usuarioBaja) {
        this.usuarioBaja = usuarioBaja;
    }

    public Usuario getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Usuario usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
    
}
