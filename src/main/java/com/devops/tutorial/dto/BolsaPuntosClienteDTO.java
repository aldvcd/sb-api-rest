package com.devops.tutorial.dto;


import com.devops.tutorial.model.Cliente;

public class BolsaPuntosClienteDTO {
   
    private Cliente cliente;

    public BolsaPuntosClienteDTO(Cliente cliente) {

        this.cliente = cliente;
    }

    // Getters y Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
