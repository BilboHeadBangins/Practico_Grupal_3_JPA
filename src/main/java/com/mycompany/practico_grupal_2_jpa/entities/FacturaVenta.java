
package com.mycompany.practico_grupal_2_jpa.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.ToString;

/**
 *
 * @author italo
 */
@ToString
@Entity
@Table(name = "factura_venta")
public class FacturaVenta extends EntityId{
    private Long numero;
    @Column(name="fecha_emision",nullable = false)
    private LocalDate fechaEmision;
    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = true)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="condicion_iva_id", nullable=false)
    private CondicionIva condicionIva;
    @ManyToOne
    @JoinColumn(name="tipo_moneda_id", nullable=false)
    private TipoMoneda tipoMoneda;
    @ManyToOne
    @JoinColumn(name="punto_venta_id", nullable=false)
    private PuntoVenta puntoVenta;

    private double importeCobrado;
    private double importeSaldo;

    @Column(name="importe_total", nullable = false)
    private double importeTotal;
    private String cae;
    private LocalDate caeFechaVencimiento;
    private String resultadoAfip;
    private String motivoRechazo;

    @Column(name = "estado", nullable = false)
    private String estado;
    private LocalDate fechaAnulacion;
    private String observaciones;
    
    @OneToMany(mappedBy="factura", cascade=CascadeType.ALL) 
    private List<FacturaVentaDetalle> detalles = new ArrayList<>();

    public FacturaVenta() {
    }

    public FacturaVenta(Long numero, LocalDate fechaEmision, Cliente cliente, CondicionIva condicionIva,
            TipoMoneda tipoMoneda, PuntoVenta puntoVenta, double importeCobrado,
            double importeSaldo, double importeTotal, String cae, LocalDate caeFechaVencimiento,
            String resultadoAfip, String motivoRechazo, String estado, LocalDate fechaAnulacion, String observaciones) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.cliente = cliente;
        this.condicionIva = condicionIva;
        this.tipoMoneda = tipoMoneda;
        this.puntoVenta = puntoVenta;
        this.importeCobrado = importeCobrado;
        this.importeSaldo = importeSaldo;
        this.importeTotal = importeTotal;
        this.cae = cae;
        this.caeFechaVencimiento = caeFechaVencimiento;
        this.resultadoAfip = resultadoAfip;
        this.motivoRechazo = motivoRechazo;
        this.estado = estado;
        this.fechaAnulacion = fechaAnulacion;
        this.observaciones = observaciones;
    }
    
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CondicionIva getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(CondicionIva condicionIva) {
        this.condicionIva = condicionIva;
    }

    public TipoMoneda getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(TipoMoneda tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public PuntoVenta getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public double getImporteCobrado() {
        return importeCobrado;
    }

    public void setImporteCobrado(double importeCobrado) {
        this.importeCobrado = importeCobrado;
    }

    public double getImporteSaldo() {
        return importeSaldo;
    }

    public void setImporteSaldo(double importeSaldo) {
        this.importeSaldo = importeSaldo;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getCae() {
        return cae;
    }

    public void setCae(String cae) {
        this.cae = cae;
    }

    public LocalDate getCaeFechaVencimiento() {
        return caeFechaVencimiento;
    }

    public void setCaeFechaVencimiento(LocalDate caeFechaVencimiento) {
        this.caeFechaVencimiento = caeFechaVencimiento;
    }

    public String getResultadoAfip() {
        return resultadoAfip;
    }

    public void setResultadoAfip(String resultadoAfip) {
        this.resultadoAfip = resultadoAfip;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDate fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<FacturaVentaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaVentaDetalle> detalles) {
        this.detalles = detalles;
    }
    
}
