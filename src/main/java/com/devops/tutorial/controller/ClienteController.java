package com.devops.tutorial.controller;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import com.devops.tutorial.model.Cliente;
import com.devops.tutorial.service.ClienteService;

import ch.qos.logback.classic.Logger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private static final org.jboss.logging.Logger logger = LoggerFactory.logger(ClienteController.class);
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente detallesCliente) {
        Optional<Cliente> clienteExistente = clienteService.obtenerClientePorId(id);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNombre(detallesCliente.getNombre());
            cliente.setApellido(detallesCliente.getApellido());
            cliente.setNumeroDocumento(detallesCliente.getNumeroDocumento());
            cliente.setTipoDocumento(detallesCliente.getTipoDocumento());
            cliente.setNacionalidad(detallesCliente.getNacionalidad());
            cliente.setEmail(detallesCliente.getEmail());
            cliente.setTelefono(detallesCliente.getTelefono());
            cliente.setFechaNacimiento(detallesCliente.getFechaNacimiento());
            logger.infof("Cliente creado con éxito: {}", cliente);
            return ResponseEntity.ok(clienteService.guardarCliente(cliente));
            
        } else {
            logger.infof("Error: {}");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.obtenerClientePorId(id);
        if (cliente.isPresent()) {
            clienteService.eliminarCliente(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Punto 7 - consulta de clientes por: nombre (aproximación), apellido(aproximación), cumpleaños
    @GetMapping("/clientes-por-nombre-apellido-cumpleanios")
    public ResponseEntity<List<Cliente>> obtenerClientesPorNombreApellidoYCumpleanios(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) java.util.Date fechaNacimiento) {
        List<Cliente> clientes = clienteService.obtenerClientesPorNombreApellidoYCumpleanios(nombre, apellido, fechaNacimiento);
        return ResponseEntity.ok(clientes);
    }
}
