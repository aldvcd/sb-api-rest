package com.devops.tutorial.repository;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devops.tutorial.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(
    nativeQuery = true,
    value = "SELECT * FROM cliente c WHERE (" +
            "(LOWER(c.nombre) LIKE LOWER(CONCAT('%',:nombre, '%')) OR :nombre IS NULL) AND " +
            "(LOWER(c.apellido) LIKE LOWER(CONCAT('%',:apellido, '%')) OR :apellido IS NULL) AND " +
            "(c.fecha_nacimiento = :fechaNacimiento OR :fechaNacimiento IS NULL))"
    )
    List<Cliente> findClientesPorNombreApellidoYCumpleanios(
        @Param("nombre") String nombre,
        @Param("apellido") String apellido,
        @Param("fechaNacimiento") Date fechaNacimiento
    );




}
