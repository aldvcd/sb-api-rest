package com.devops.tutorial.repository;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devops.tutorial.dto.ClienteBolsaPuntosDTO;
import com.devops.tutorial.model.BolsaPuntos;

public interface BolsaPuntosRepository extends JpaRepository<BolsaPuntos, Long> {

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM BolsaPuntos b WHERE b.fecha_caducidad < :fechaCaducidad" +
        " AND b.saldo_puntos > 0 AND b.puntaje_utilizado < 0"
    )
    List<BolsaPuntos> findBolsasPuntosVencidas(
        @Param("fechaCaducidad") Date ahora
    );

    @Query(
    nativeQuery = true,
    value = "SELECT distinct c.* " +
    "FROM bolsa_puntos bp " +
    "JOIN cliente c ON bp.cliente_id = c.id " +
    "JOIN param_vencimiento pv ON bp.param_vencimiento_id = pv.id " +
    "WHERE DATEDIFF(pv.fecha_fin, CURRENT_DATE) <= :dias " +
    "AND (:clienteId IS NULL OR bp.cliente_id = :clienteId)"
    )
    List<Object[]> findClientesConPuntosAVencer(
        @Param("dias") int dias,
        @Param("clienteId") BigInteger clienteId
    );
    
    @Query(
    nativeQuery = true,
    value = "SELECT c.id AS cliente_id, c.nombre, c.apellido, c.fecha_nacimiento, b.id AS bolsa_puntos_id, r.limite_superior, r.limite_inferior " +
            "FROM bolsa_puntos b " +
            "JOIN cliente c ON b.cliente_id = c.id " +
            "JOIN regla_asignacion r ON b.regla_asignacion_id = r.id " +
            "WHERE c.id = :clienteId"
    )
    List<Object> findClienteBolsaPuntosByClienteId(@Param("clienteId") Long clienteId);



}
