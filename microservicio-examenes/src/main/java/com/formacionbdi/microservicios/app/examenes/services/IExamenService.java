package com.formacionbdi.microservicios.app.examenes.services;

import com.formacionbdi.microservicios.app.commons.services.ICommonService;

import java.util.List;

import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Examen;

public interface IExamenService extends ICommonService<Examen>{
	
	public List<Examen> findByNombre(String term);
	
	public List<Asignatura> findAllAsignaturas();

}
