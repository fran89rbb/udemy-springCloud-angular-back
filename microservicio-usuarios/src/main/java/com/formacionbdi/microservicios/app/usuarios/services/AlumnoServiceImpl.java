package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.app.commons.services.CommonServiceImpl;
import com.formacionbdi.microservicios.app.usuarios.models.repository.IAlumnoRepository;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, IAlumnoRepository> implements IAlumnoService{

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String termino) {
		// TODO Auto-generated method stub
		return repository.findByNombreOrApellido(termino);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return repository.findAllById(ids);
	}

}
