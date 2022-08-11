package com.formacionbdi.microservicios.app.respuestas.services;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface IRespuestaService {

	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);
	
	public Iterable<Respuesta> findByByAlumnoByExamen(Long alumnoId, Long examenId);

	public Iterable<Long> findExamenesIdsConRespuestaByAlumno(Long alumnoId);
}
