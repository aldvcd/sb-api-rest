package com.devops.tutorial.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.tutorial.model.ParamVencimiento;
import com.devops.tutorial.repository.ParamVencimientoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParamVencimientoService {
    @Autowired
    private ParamVencimientoRepository paramVencimientoRepository;

    public ParamVencimiento guardarParametro(ParamVencimiento parametro) {
        return paramVencimientoRepository.save(parametro);
    }

    public Optional<ParamVencimiento> obtenerParametroPorId(Long id) {
        return paramVencimientoRepository.findById(id);
    }

    public List<ParamVencimiento> obtenerTodosLosParametros() {
        return paramVencimientoRepository.findAll();
    }

    public void eliminarParametro(Long id) {
        paramVencimientoRepository.deleteById(id);
    }
}
