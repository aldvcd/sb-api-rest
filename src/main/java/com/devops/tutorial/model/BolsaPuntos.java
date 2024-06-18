package com.devops.tutorial.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BolsaPuntos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "param_vencimiento_id")
    private ParamVencimiento paramVencimiento;
    
    @Column
    private Date fechaAsignacion;
    
    @Column
    private int puntajeAsignado;
    
    @Column
    private int puntajeUtilizado;
    
    @Column
    private int saldoPuntos;
    
    @Column
    private Double montoOperacion;

    @Column(name = "regla_asignacion_id")
    private Long reglaAsignacionId;

    // Getters y Setters
    public Long getReglaAsignacionId() {
        return reglaAsignacionId;
    }

    public void setReglaAsignacionId(Long reglaAsignacionId) {
        this.reglaAsignacionId = reglaAsignacionId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ParamVencimiento getParamVencimiento() {
        return paramVencimiento;
    }

    public void setParamVencimiento(ParamVencimiento paramVencimiento) {
        this.paramVencimiento = paramVencimiento;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public int getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public void setPuntajeAsignado(int puntajeAsignado) {
        this.puntajeAsignado = puntajeAsignado;
    }

    public int getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(int puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public int getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntos(int saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public Double getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(Double montoOperacion) {
        this.montoOperacion = montoOperacion;
    }
}