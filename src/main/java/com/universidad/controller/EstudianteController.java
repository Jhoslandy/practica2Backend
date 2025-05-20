package com.universidad.controller;

import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Materia;
import com.universidad.model.Estudiante;
import com.universidad.service.IEstudianteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@Validated
@Tag(name = "Estudiantes", description = "Operaciones para gestionar estudiantes en el sistema universitario")
public class EstudianteController {

    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @Operation(summary = "Listar todos los estudiantes", description = "Obtiene una lista completa de los estudiantes registrados")
    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes() {
        return ResponseEntity.ok(estudianteService.obtenerTodosLosEstudiantes());
    }

    @Operation(summary = "Obtener estudiante por número de inscripción", description = "Busca un estudiante por su número de inscripción único")
    @GetMapping("/inscripcion/{numeroInscripcion}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorNumeroInscripcion(@PathVariable String numeroInscripcion) {
        return ResponseEntity.ok(estudianteService.obtenerEstudiantePorNumeroInscripcion(numeroInscripcion));
    }

    @Operation(summary = "Obtener materias del estudiante", description = "Obtiene todas las materias asociadas a un estudiante por su ID")
    @GetMapping("/{id}/materias")
    public ResponseEntity<List<Materia>> obtenerMateriasDeEstudiante(@PathVariable("id") Long estudianteId) {
        return ResponseEntity.ok(estudianteService.obtenerMateriasDeEstudiante(estudianteId));
    }

    @Operation(summary = "Obtener estudiante con bloqueo", description = "Obtiene un estudiante por ID con bloqueo pesimista para evitar condiciones de carrera")
    @GetMapping("/{id}/lock")
    public ResponseEntity<Estudiante> getEstudianteConBloqueo(@PathVariable Long id) {
        return ResponseEntity.ok(estudianteService.obtenerEstudianteConBloqueo(id));
    }

    @Operation(summary = "Crear un nuevo estudiante", description = "Registra un nuevo estudiante en el sistema")
    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstudianteDTO> crearEstudiante(@Valid @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO nuevoEstudiante = estudianteService.crearEstudiante(estudianteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

    @Operation(summary = "Actualizar estudiante", description = "Actualiza los datos de un estudiante existente por su ID")
    @PutMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(
        @PathVariable Long id,
        @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteDTO);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @Operation(summary = "Dar de baja a un estudiante", description = "Marca a un estudiante como inactivo y registra el motivo de baja")
    @PutMapping("/{id}/baja")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EstudianteDTO> eliminarEstudiante(
        @PathVariable Long id,
        @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO estudianteEliminado = estudianteService.eliminarEstudiante(id, estudianteDTO);
        return ResponseEntity.ok(estudianteEliminado);
    }

    @Operation(summary = "Listar estudiantes activos", description = "Devuelve una lista de todos los estudiantes con estado activo")
    @GetMapping("/activos")
    public ResponseEntity<List<EstudianteDTO>> obtenerEstudianteActivo() {
        return ResponseEntity.ok(estudianteService.obtenerEstudianteActivo());
    }
}
