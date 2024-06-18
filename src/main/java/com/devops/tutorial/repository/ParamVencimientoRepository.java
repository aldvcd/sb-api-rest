package com.devops.tutorial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devops.tutorial.model.ParamVencimiento;

public interface ParamVencimientoRepository extends JpaRepository<ParamVencimiento, Long> {
}
