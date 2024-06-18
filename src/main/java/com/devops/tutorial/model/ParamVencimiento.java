package com.devops.tutorial.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ParamVencimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaFin;
    @Column
    private int diasDuracion;
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public int getDiasDuracion() {
        return diasDuracion;
    }
    public void setDiasDuracion(int diasDuracion) {
        this.diasDuracion = diasDuracion;
    }

}
