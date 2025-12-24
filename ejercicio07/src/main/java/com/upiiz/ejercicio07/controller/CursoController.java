package com.upiiz.ejercicio07.controller;

import com.upiiz.ejercicio07.dto.ApiResponseDTO;
import com.upiiz.ejercicio07.model.Curso;
import com.upiiz.ejercicio07.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cursos")
@Tag(name = "Cursos", description = "Gestión de cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    // CREATE
    @Operation(summary = "Crear curso")
    @PostMapping
    public ResponseEntity<ApiResponseDTO> crear(@Valid @RequestBody Curso curso) {
        Curso creado = service.crear(curso);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseDTO("OK", "Curso creado", creado));
    }

    // READ ALL
    @Operation(summary = "Listar cursos")
    @GetMapping
    public ResponseEntity<ApiResponseDTO> listar() {
        return ResponseEntity.ok(
                new ApiResponseDTO("OK", "Lista de cursos", service.listar()));
    }

    // READ BY ID
    @Operation(summary = "Obtener curso por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(
                new ApiResponseDTO("OK", "Curso encontrado", service.obtener(id)));
    }

    // UPDATE
    @Operation(summary = "Actualizar curso")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Curso curso
    ) {
        return ResponseEntity.ok(
                new ApiResponseDTO("OK", "Curso actualizado",
                        service.actualizar(id, curso)));
    }

    // DELETE
    @Operation(summary = "Eliminar curso")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.ok(
                new ApiResponseDTO("OK", "Curso eliminado", null));
    }
}
