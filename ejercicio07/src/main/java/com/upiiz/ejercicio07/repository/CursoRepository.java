package com.upiiz.ejercicio07.repository;

import com.upiiz.ejercicio07.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByNombre(String nombre);
}
