package com.devops.tutorial.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

@Entity
public class UsoPuntos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @Column
    private Date fecha;

    @ManyToOne
    private Concepto conceptoUso;

    @Column
    private int puntajeUtilizado;

    @OneToMany(mappedBy = "usoPuntos", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UsoPuntosDetalle> detalles;

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

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Concepto getConceptoUso() {
        return conceptoUso;
    }

    public void setConceptoUso(Concepto conceptoUso) {
        this.conceptoUso = conceptoUso;
    }

    public List<UsoPuntosDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<UsoPuntosDetalle> detalles) {
        this.detalles = detalles;
    }
}
