package com.upiiz.ejercicio07.service;

import com.upiiz.ejercicio07.exception.DuplicateResourceException;
import com.upiiz.ejercicio07.exception.ResourceNotFoundException;
import com.upiiz.ejercicio07.model.Curso;
import com.upiiz.ejercicio07.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    // POST
    public Curso crear(Curso curso) {
        if (repository.existsByNombre(curso.getNombre())) {
            throw new DuplicateResourceException("El curso ya existe");
        }
        return repository.save(curso);
    }

    // GET ALL
    public List<Curso> listar() {
        return repository.findAll();
    }

    // GET BY ID
    public Curso obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
    }

    // PUT
    public Curso actualizar(Long id, Curso curso) {
        Curso existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));

        existente.setNombre(curso.getNombre());
        existente.setNivel(curso.getNivel());
        existente.setDuracionHoras(curso.getDuracionHoras());
        existente.setPrecio(curso.getPrecio());
        existente.setFechaInicio(curso.getFechaInicio());

        return repository.save(existente);
    }

    // DELETE
    public void eliminar(Long id) {
        Curso curso = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        repository.delete(curso);
    }
}
