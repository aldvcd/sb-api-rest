package com.devops.tutorial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devops.tutorial.model.UsoPuntos;
import com.devops.tutorial.model.UsoPuntosDetalle;
import com.devops.tutorial.service.UsoPuntosService;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/usos")
public class UsoPuntosController {
    @Autowired
    private UsoPuntosService usoPuntosService;

    @PostMapping
    public UsoPuntos crearUso(@RequestBody UsoPuntos usoPuntos) {
        return usoPuntosService.guardarUso(usoPuntos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsoPuntos> obtenerUsoPorId(@PathVariable Long id) {
        Optional<UsoPuntos> usoPuntos = usoPuntosService.obtenerUsoPorId(id);
        return usoPuntos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UsoPuntos> obtenerTodosLosUsos() {
        return usoPuntosService.obtenerTodosLosUsos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsoPuntos> actualizarUso(@PathVariable Long id, @RequestBody UsoPuntos detallesUso) {
        Optional<UsoPuntos> usoExistente = usoPuntosService.obtenerUsoPorId(id);
        if (usoExistente.isPresent()) {
            UsoPuntos usoPuntos = usoExistente.get();
            usoPuntos.setPuntajeUtilizado(detallesUso.getPuntajeUtilizado());
            usoPuntos.setFecha(detallesUso.getFecha());
            usoPuntos.setConceptoUso(detallesUso.getConceptoUso());
            return ResponseEntity.ok(usoPuntosService.guardarUso(usoPuntos));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUso(@PathVariable Long id) {
        Optional<UsoPuntos> uso = usoPuntosService.obtenerUsoPorId(id);
        if (uso.isPresent()) {
            usoPuntosService.eliminarUso(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{usoId}/detalles")
    public UsoPuntosDetalle crearDetalleUso(@PathVariable Long usoId, @RequestBody UsoPuntosDetalle usoPuntosDetalle) {
        Optional<UsoPuntos> usoPuntos = usoPuntosService.obtenerUsoPorId(usoId);
        if (usoPuntos.isPresent()) {
            usoPuntosDetalle.setUsoPuntos(usoPuntos.get());
            return usoPuntosService.guardarUsoDetalle(usoPuntosDetalle);
        } else {
            throw new RuntimeException("UsoPuntos no encontrado con id " + usoId);
        }
    }

    @DeleteMapping("/detalles/{id}")
    public ResponseEntity<Void> eliminarDetalleUso(@PathVariable Long id) {
        usoPuntosService.eliminarUsoDetalle(id);
        return ResponseEntity.noContent().build();
    }
    //PUNTO 6: Uso de puntos por: concepto de uso, fecha de uso, cliente
    @GetMapping("/usos-por-concepto-fecha-cliente")
    public ResponseEntity<List<UsoPuntos>> obtenerUsosPorConceptoFechaCliente(
        @RequestParam(required = false) String conceptoUso,
        @RequestParam(required = false) Long clienteId) {
    List<UsoPuntos> usos = usoPuntosService.obtenerUsosPorConceptoFechaCliente(conceptoUso, clienteId);
    return ResponseEntity.ok(usos);
    }   
}
