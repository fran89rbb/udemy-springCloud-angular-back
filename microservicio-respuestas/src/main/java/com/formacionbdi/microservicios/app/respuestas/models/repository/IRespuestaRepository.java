package com.formacionbdi.microservicios.app.respuestas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface IRespuestaRepository extends JpaRepository<Respuesta, Long>{

}
