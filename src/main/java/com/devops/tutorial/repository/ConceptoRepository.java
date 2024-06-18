package com.devops.tutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devops.tutorial.model.Concepto;

public interface ConceptoRepository extends JpaRepository<Concepto, Long> {
}
