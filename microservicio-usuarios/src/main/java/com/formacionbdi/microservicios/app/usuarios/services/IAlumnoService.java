package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.List;

import com.formacionbdi.microservicios.app.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.app.commons.services.ICommonService;

public interface IAlumnoService extends ICommonService<Alumno>{
	
	public List<Alumno> findByNombreOrApellido(String termino);

}
