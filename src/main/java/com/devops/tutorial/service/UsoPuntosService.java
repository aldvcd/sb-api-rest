package com.devops.tutorial.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.tutorial.model.UsoPuntos;
import com.devops.tutorial.model.UsoPuntosDetalle;
import com.devops.tutorial.repository.UsoPuntosRepository;
import com.devops.tutorial.repository.UsoPuntosDetalleRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UsoPuntosService {
    @Autowired
    private UsoPuntosRepository usoPuntosRepository;

    @Autowired
    private UsoPuntosDetalleRepository usoPuntosDetalleRepository;

    public UsoPuntos guardarUso(UsoPuntos usoPuntos) {
        return usoPuntosRepository.save(usoPuntos);
    }

    public Optional<UsoPuntos> obtenerUsoPorId(Long id) {
        return usoPuntosRepository.findById(id);
    }

    public List<UsoPuntos> obtenerTodosLosUsos() {
        return usoPuntosRepository.findAll();
    }

    public void eliminarUso(Long id) {
        usoPuntosRepository.deleteById(id);
    }

    public UsoPuntosDetalle guardarUsoDetalle(UsoPuntosDetalle usoPuntosDetalle) {
        return usoPuntosDetalleRepository.save(usoPuntosDetalle);
    }

    public void eliminarUsoDetalle(Long id) {
        usoPuntosDetalleRepository.deleteById(id);
    }

    public List<UsoPuntos> obtenerUsosPorConceptoFechaCliente(String conceptoUso, Long clienteId) {
        if (conceptoUso == null || clienteId == null) {
            throw new IllegalArgumentException("No se cargaron los parametros necesarios.");
        }
        
        return usoPuntosRepository.findByConceptoUsoAndFechaUsoAndClienteId(conceptoUso, clienteId);
    }
    
}
