package com.formacionbdi.microservicios.app.examenes.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Asignatura;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Long> {

}
