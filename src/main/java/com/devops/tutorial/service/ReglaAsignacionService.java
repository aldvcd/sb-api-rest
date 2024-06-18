package com.devops.tutorial.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.tutorial.model.ReglaAsignacion;
import com.devops.tutorial.repository.ReglaAsignacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReglaAsignacionService {
    @Autowired
    private ReglaAsignacionRepository reglaAsignacionRepository;

    public ReglaAsignacion guardarRegla(ReglaAsignacion regla) {
        return reglaAsignacionRepository.save(regla);
    }

    public Optional<ReglaAsignacion> obtenerReglaPorId(Long id) {
        return reglaAsignacionRepository.findById(id);
    }

    public List<ReglaAsignacion> obtenerTodasLasReglas() {
        return reglaAsignacionRepository.findAll();
    }

    public void eliminarRegla(Long id) {
        reglaAsignacionRepository.deleteById(id);
    }
}
