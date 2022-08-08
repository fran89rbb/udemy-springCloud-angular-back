package com.formacionbdi.microservicios.app.respuestas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface IRespuestaRepository extends JpaRepository<Respuesta, Long>{
	
	@Query("select r from Respuesta r join fetch r.alumno a join fetch r.pregunta p join fetch p.examen e where a.id=?1 and e.id=?2")
	public Iterable<Respuesta> findByByAlumnoByExamen(Long alumnoId, Long examenId);

}
