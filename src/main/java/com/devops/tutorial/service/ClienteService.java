package com.devops.tutorial.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.tutorial.model.Cliente;
import com.devops.tutorial.repository.ClienteRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> obtenerClientesPorNombreApellidoYCumpleanios(String nombre, String apellido, java.util.Date fechaNacimiento) {
        Date sqlDate = fechaNacimiento != null ? new Date(fechaNacimiento.getTime()) : null;
        return clienteRepository.findClientesPorNombreApellidoYCumpleanios(nombre, apellido, sqlDate);
    }
}
