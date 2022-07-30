package com.formacionbdi.microservicios.app.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Examen;


public interface IExamenRepository extends JpaRepository<Examen, Long>{
	
	@Query("select e from Examen e where e.nombre like %?1%")
	public List<Examen> findByNombre(String term);

}
