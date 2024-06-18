package com.devops.tutorial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devops.tutorial.model.ParamVencimiento;
import com.devops.tutorial.service.ParamVencimientoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parametros-vencimiento")
public class ParamVencimientoController {
    @Autowired
    private ParamVencimientoService paramVencimientoService;

    @PostMapping
    public ParamVencimiento crearParametro(@RequestBody ParamVencimiento parametro) {
        return paramVencimientoService.guardarParametro(parametro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParamVencimiento> obtenerParametroPorId(@PathVariable Long id) {
        Optional<ParamVencimiento> parametro = paramVencimientoService.obtenerParametroPorId(id);
        return parametro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ParamVencimiento> obtenerTodosLosParametros() {
        return paramVencimientoService.obtenerTodosLosParametros();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParamVencimiento> actualizarParametro(@PathVariable Long id, @RequestBody ParamVencimiento detallesParametro) {
        Optional<ParamVencimiento> parametroExistente = paramVencimientoService.obtenerParametroPorId(id);
        if (parametroExistente.isPresent()) {
            ParamVencimiento parametro = parametroExistente.get();
            parametro.setFechaInicio(detallesParametro.getFechaInicio());
            parametro.setFechaFin(detallesParametro.getFechaFin());
            parametro.setDiasDuracion(detallesParametro.getDiasDuracion());
            return ResponseEntity.ok(paramVencimientoService.guardarParametro(parametro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarParametro(@PathVariable Long id) {
        Optional<ParamVencimiento> parametro = paramVencimientoService.obtenerParametroPorId(id);
        if (parametro.isPresent()) {
            paramVencimientoService.eliminarParametro(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
