package com.devops.tutorial.dto;
import com.devops.tutorial.model.Cliente;
import java.sql.Date;

public class ClienteBolsaPuntosDTO {
    private Long clienteId;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Long bolsaPuntosId;
    private Double limiteSuperior;
    private Double limiteInferior;

    public ClienteBolsaPuntosDTO(Cliente cliente, Long bolsaPuntosId, Double limiteSuperior, Double limiteInferior) {
        this.clienteId = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.fechaNacimiento = (Date) cliente.getFechaNacimiento();
        this.bolsaPuntosId = bolsaPuntosId;
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
    }

    // Getters y Setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getBolsaPuntosId() {
        return bolsaPuntosId;
    }

    public void setBolsaPuntosId(Long bolsaPuntosId) {
        this.bolsaPuntosId = bolsaPuntosId;
    }

    public Double getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Double limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public Double getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Double limiteInferior) {
        this.limiteInferior = limiteInferior;
    }
}
