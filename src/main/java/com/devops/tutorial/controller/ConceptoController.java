package com.devops.tutorial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devops.tutorial.model.Concepto;
import com.devops.tutorial.service.ConceptoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conceptos")
public class ConceptoController {
    @Autowired
    private ConceptoService conceptoService;

    @PostMapping
    public Concepto crearConcepto(@RequestBody Concepto concepto) {
        return conceptoService.guardarConcepto(concepto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concepto> obtenerConceptoPorId(@PathVariable Long id) {
        Optional<Concepto> concepto = conceptoService.obtenerConceptoPorId(id);
        return concepto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Concepto> obtenerTodosLosConceptos() {
        return conceptoService.obtenerTodosLosConceptos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concepto> actualizarConcepto(@PathVariable Long id, @RequestBody Concepto detallesConcepto) {
        Optional<Concepto> conceptoExistente = conceptoService.obtenerConceptoPorId(id);
        if (conceptoExistente.isPresent()) {
            Concepto concepto = conceptoExistente.get();
            concepto.setDescripcion(detallesConcepto.getDescripcion());
            concepto.setPuntosRequeridos(detallesConcepto.getPuntosRequeridos());
            return ResponseEntity.ok(conceptoService.guardarConcepto(concepto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConcepto(@PathVariable Long id) {
        Optional<Concepto> concepto = conceptoService.obtenerConceptoPorId(id);
        if (concepto.isPresent()) {
            conceptoService.eliminarConcepto(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

