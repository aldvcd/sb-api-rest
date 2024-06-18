package com.devops.tutorial.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devops.tutorial.model.UsoPuntos;

public interface UsoPuntosRepository extends JpaRepository<UsoPuntos, Long> {

    @Query(
    nativeQuery = true,
    value = "SELECT * FROM uso_puntos u WHERE " +
    "(:conceptoUso IS NULL OR u.concepto_uso_id = :conceptoUso) AND " +
    "(:clienteId IS NULL OR u.cliente_id = :clienteId)"
    )
    List<UsoPuntos> findByConceptoUsoAndFechaUsoAndClienteId(
        @Param("conceptoUso") String conceptoUso,
        @Param("clienteId") Long clienteId
    );

}
