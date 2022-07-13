package com.formacionbdi.microservicios.app.examenes.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.commons.controllers.CommonControler;
import com.formacionbdi.microservicios.app.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.app.examenes.models.entity.Pregunta;
import com.formacionbdi.microservicios.app.examenes.services.IExamenService;

@RestController
public class ExamenController extends CommonControler<Examen, IExamenService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
		Optional<Examen> examenOpt = service.findById(id);
		
		if(!examenOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Examen examenDb = examenOpt.get();
		examenDb.setNombre(examen.getNombre());	
		
		List<Pregunta> eliminadas = examenDb.getPreguntas()
		.stream()
		.filter(pbd -> !examen.getPreguntas().contains(pbd))
		.collect(Collectors.toList());
		
		eliminadas.forEach(examenDb::removePregunta);
		
		examenDb.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}

}
