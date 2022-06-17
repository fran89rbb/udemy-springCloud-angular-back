package com.formacionbdi.microservicios.app.cursos.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.commons.controllers.CommonControler;
import com.formacionbdi.microservicios.app.commons.services.ICommonService;
import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;

@RestController
public class CursoController extends CommonControler<Curso, ICommonService<Curso>>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
		Optional<Curso> cursoDb = this.service.findById(id);
		
		if(cursoDb.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoUpdate = cursoDb.get();
		cursoUpdate.setNombre(curso.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoUpdate));
	}

}
