package com.formacionbdi.microservicios.app.cursos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.commons.services.CommonServiceImpl;
import com.formacionbdi.microservicios.app.cursos.clients.IRespuestaFeignClient;
import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.models.repository.ICursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, ICursoRepository> implements ICursoService{
	
	@Autowired
	private IRespuestaFeignClient client;

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdsConRespuestaByAlumno(Long alumnoId) {
		return client.obtenerExamenesIdsConRespuestaByAlumno(alumnoId);
	}

}
