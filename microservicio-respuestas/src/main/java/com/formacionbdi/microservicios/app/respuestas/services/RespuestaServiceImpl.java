package com.formacionbdi.microservicios.app.respuestas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
import com.formacionbdi.microservicios.app.respuestas.models.repository.IRespuestaRepository;

@Service
public class RespuestaServiceImpl implements IRespuestaService {
	
	@Autowired
	private IRespuestaRepository repository;

	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return repository.saveAll(respuestas);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Respuesta> findByByAlumnoByExamen(Long alumnoId, Long examenId) {
		return repository.findByByAlumnoByExamen(alumnoId, examenId);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestaByAlumno(Long alumnoId) {
		return repository.findExamenesIdsConRespuestaByAlumno(alumnoId);
	}

}
