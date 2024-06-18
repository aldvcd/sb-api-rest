package com.devops.tutorial.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devops.tutorial.model.Concepto;
import com.devops.tutorial.repository.ConceptoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ConceptoService {
    @Autowired
    private ConceptoRepository conceptoRepository;

    public Concepto guardarConcepto(Concepto concepto) {
        return conceptoRepository.save(concepto);
    }

    public Optional<Concepto> obtenerConceptoPorId(Long id) {
        return conceptoRepository.findById(id);
    }

    public List<Concepto> obtenerTodosLosConceptos() {
        return conceptoRepository.findAll();
    }

    public void eliminarConcepto(Long id) {
        conceptoRepository.deleteById(id);
    }
}
