package com.formacionbdi.microservicios.app.cursos.services;

import com.formacionbdi.microservicios.app.commons.services.ICommonService;
import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;

public interface ICursoService extends ICommonService<Curso>{
	
	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdsConRespuestaByAlumno(Long alumnoId);

}
