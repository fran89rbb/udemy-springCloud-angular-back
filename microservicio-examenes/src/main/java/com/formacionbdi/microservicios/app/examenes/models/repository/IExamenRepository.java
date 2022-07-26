package com.formacionbdi.microservicios.app.examenes.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Examen;


public interface IExamenRepository extends JpaRepository<Examen, Long>{

}
