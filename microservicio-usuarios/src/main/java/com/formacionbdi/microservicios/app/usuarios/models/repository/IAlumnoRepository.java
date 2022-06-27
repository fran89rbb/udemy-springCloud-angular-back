package com.formacionbdi.microservicios.app.usuarios.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.microservicios.app.commons.alumnos.models.entity.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long>{

}
