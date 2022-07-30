package com.formacionbdi.microservicios.app.cursos.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.app.commons.controllers.CommonControler;
import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.services.ICursoService;

@RestController
public class CursoController extends CommonControler<Curso, ICursoService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Curso> cursoDb = this.service.findById(id);
		
		if(!cursoDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoUpdate = cursoDb.get();
		cursoUpdate.setNombre(curso.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoUpdate));
	}
	
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
		Optional<Curso> cursoDb = this.service.findById(id);
		
		if(!cursoDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoUpdate = cursoDb.get();
		alumnos.forEach(a -> cursoUpdate.addAlumno(a));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoUpdate));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Curso> cursoDb = this.service.findById(id);
		
		if(!cursoDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoUpdate = cursoDb.get();
		cursoUpdate.removeAlumno(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoUpdate));
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id){
		Curso curso = service.findCursoByAlumnoId(id);
		return ResponseEntity.ok(curso);
	}
	
	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id){
		Optional<Curso> cursoDb = this.service.findById(id);
		
		if(!cursoDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoUpdate = cursoDb.get();
		examenes.forEach(e -> cursoUpdate.addExamen(e));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoUpdate));
	}
	
	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id){
		Optional<Curso> cursoDb = this.service.findById(id);
		
		if(!cursoDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoUpdate = cursoDb.get();
		cursoUpdate.removeExamen(examen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoUpdate));
	}

}
