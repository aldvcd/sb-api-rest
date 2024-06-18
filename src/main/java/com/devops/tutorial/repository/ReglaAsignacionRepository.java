package com.devops.tutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devops.tutorial.model.ReglaAsignacion;

public interface ReglaAsignacionRepository extends JpaRepository<ReglaAsignacion, Long> {
}
