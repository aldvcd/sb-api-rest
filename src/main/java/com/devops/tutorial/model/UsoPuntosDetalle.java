package com.devops.tutorial.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UsoPuntosDetalle {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private UsoPuntos usoPuntos;

    @ManyToOne
    private BolsaPuntos bolsaPuntos;

    @Column
    private int puntajeUtilizado;

    
    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UsoPuntos getUsoPuntos() {
        return usoPuntos;
    }
    public void setUsoPuntos(UsoPuntos usoPuntos) {
        this.usoPuntos = usoPuntos;
    }
    public BolsaPuntos getBolsaPuntos() {
        return bolsaPuntos;
    }
    public void setBolsaPuntos(BolsaPuntos bolsaPuntos) {
        this.bolsaPuntos = bolsaPuntos;
    }
    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }
    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }


}
