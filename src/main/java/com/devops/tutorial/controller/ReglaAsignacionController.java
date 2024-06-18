package com.devops.tutorial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devops.tutorial.model.ReglaAsignacion;
import com.devops.tutorial.service.ReglaAsignacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reglas")
public class ReglaAsignacionController {
    @Autowired
    private ReglaAsignacionService reglaAsignacionService;

    @PostMapping
    public ReglaAsignacion crearRegla(@RequestBody ReglaAsignacion regla) {
        return reglaAsignacionService.guardarRegla(regla);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReglaAsignacion> obtenerReglaPorId(@PathVariable Long id) {
        Optional<ReglaAsignacion> regla = reglaAsignacionService.obtenerReglaPorId(id);
        return regla.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ReglaAsignacion> obtenerTodasLasReglas() {
        return reglaAsignacionService.obtenerTodasLasReglas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReglaAsignacion> actualizarRegla(@PathVariable Long id, @RequestBody ReglaAsignacion detallesRegla) {
        Optional<ReglaAsignacion> reglaExistente = reglaAsignacionService.obtenerReglaPorId(id);
        if (reglaExistente.isPresent()) {
            ReglaAsignacion regla = reglaExistente.get();
            regla.setLimiteInferior(detallesRegla.getLimiteInferior());
            regla.setLimiteSuperior(detallesRegla.getLimiteSuperior());
            regla.setEquivalenciaPunto(detallesRegla.getEquivalenciaPunto());
            return ResponseEntity.ok(reglaAsignacionService.guardarRegla(regla));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegla(@PathVariable Long id) {
        Optional<ReglaAsignacion> regla = reglaAsignacionService.obtenerReglaPorId(id);
        if (regla.isPresent()) {
            reglaAsignacionService.eliminarRegla(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
