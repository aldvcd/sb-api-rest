package com.devops.tutorial.model;

import javax.persistence.*;

@Entity
public class ReglaAsignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double limiteInferior;
    @Column
    private Double limiteSuperior;
    @Column
    private Double equivalenciaPunto;
    
     // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getLimiteInferior() {
        return limiteInferior;
    }
    public void setLimiteInferior(Double limiteInferior) {
        this.limiteInferior = limiteInferior;
    }
    public Double getLimiteSuperior() {
        return limiteSuperior;
    }
    public void setLimiteSuperior(Double limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }
    public Double getEquivalenciaPunto() {
        return equivalenciaPunto;
    }
    public void setEquivalenciaPunto(Double equivalenciaPunto) {
        this.equivalenciaPunto = equivalenciaPunto;
    }

   
}
