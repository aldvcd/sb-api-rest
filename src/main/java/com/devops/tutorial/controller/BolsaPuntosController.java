package com.devops.tutorial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devops.tutorial.dto.BolsaPuntosClienteDTO;
import com.devops.tutorial.dto.ClienteBolsaPuntosDTO;
import com.devops.tutorial.model.BolsaPuntos;
import com.devops.tutorial.service.BolsaPuntosService;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bolsas")
public class BolsaPuntosController {
    @Autowired
    private BolsaPuntosService bolsaPuntosService;

    @PostMapping
    public BolsaPuntos crearBolsa(@RequestBody BolsaPuntos bolsa) {
        return bolsaPuntosService.guardarBolsa(bolsa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BolsaPuntos> obtenerBolsaPorId(@PathVariable Long id) {
        Optional<BolsaPuntos> bolsa = bolsaPuntosService.obtenerBolsaPorId(id);
        return bolsa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<BolsaPuntos> obtenerTodasLasBolsas() {
        return bolsaPuntosService.obtenerTodasLasBolsas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BolsaPuntos> actualizarBolsa(@PathVariable Long id, @RequestBody BolsaPuntos detallesBolsa) {
        Optional<BolsaPuntos> bolsaExistente = bolsaPuntosService.obtenerBolsaPorId(id);
        if (bolsaExistente.isPresent()) {
            BolsaPuntos bolsa = bolsaExistente.get();
            bolsa.setFechaAsignacion(detallesBolsa.getFechaAsignacion());
            bolsa.setPuntajeAsignado(detallesBolsa.getPuntajeAsignado());
            bolsa.setPuntajeUtilizado(detallesBolsa.getPuntajeUtilizado());
            bolsa.setSaldoPuntos(detallesBolsa.getSaldoPuntos());
            bolsa.setMontoOperacion(detallesBolsa.getMontoOperacion());
            return ResponseEntity.ok(bolsaPuntosService.guardarBolsa(bolsa));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBolsa(@PathVariable Long id) {
        Optional<BolsaPuntos> bolsa = bolsaPuntosService.obtenerBolsaPorId(id);
        if (bolsa.isPresent()) {
            bolsaPuntosService.eliminarBolsa(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/puntos-a-vencer")
    public ResponseEntity<List<BolsaPuntosClienteDTO>> obtenerPuntosAVencer(
            @RequestParam int dias,
            @RequestParam BigInteger clienteId) {
        List<BolsaPuntosClienteDTO> puntosAVencer = bolsaPuntosService.obtenerPuntosAVencerEnDias(dias, clienteId);
        return ResponseEntity.ok(puntosAVencer);
    }

    @GetMapping("/bolsa-cliente-puntos/{clienteId}")
    public ResponseEntity<List<Object>> getClienteBolsaPuntosByClienteId(@PathVariable Long clienteId) {
        List<Object> result = bolsaPuntosService.findClienteBolsaPuntosByClienteId(clienteId);
        return ResponseEntity.ok(result);
    }
}
