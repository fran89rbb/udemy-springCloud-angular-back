package com.formacionbdi.microservicios.app.usuarios.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formacionbdi.microservicios.app.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.app.commons.controllers.CommonControler;
import com.formacionbdi.microservicios.app.usuarios.services.IAlumnoService;

@RestController
public class AlumnoControler extends CommonControler<Alumno, IAlumnoService>{
	
	@GetMapping("/alumnos-por-curso")
	public ResponseEntity<?> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids){
		return ResponseEntity.ok(service.findAllById(ids));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Alumno> alumnoDb = service.findById(id);
		
		if(alumnoDb.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoEditar = alumnoDb.get();
		alumnoEditar.setNombre(alumno.getNombre());
		alumnoEditar.setApellido(alumno.getApellido());
		alumnoEditar.setEmail(alumno.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoEditar)); 
	}
	
	@GetMapping("filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombreOrApellido(term));
	}

	@PostMapping("/crear-con-foto")
	public ResponseEntity<?> crearConFoto(@Valid Alumno alumno, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {
		if(!archivo.isEmpty()) {
			alumno.setFoto(archivo.getBytes());
		}
		return super.crear(alumno, result);
	}
	
	@PutMapping("/editar-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid Alumno alumno, BindingResult result, @PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException{
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Alumno> alumnoDb = service.findById(id);
		
		if(alumnoDb.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoEditar = alumnoDb.get();
		alumnoEditar.setNombre(alumno.getNombre());
		alumnoEditar.setApellido(alumno.getApellido());
		alumnoEditar.setEmail(alumno.getEmail());
		
		if(!archivo.isEmpty()) {
			alumnoEditar.setFoto(archivo.getBytes());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoEditar)); 
	}
	
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Long id){
		Optional<Alumno> alumnoDb = service.findById(id);
			
		if(alumnoDb.isEmpty() || alumnoDb.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource imagen = new ByteArrayResource(alumnoDb.get().getFoto());
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
	}

}
