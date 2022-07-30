package com.formacionbdi.microservicios.app.examenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.microservicios.app.commons.services.CommonServiceImpl;
import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.app.examenes.models.repository.IAsignaturaRepository;
import com.formacionbdi.microservicios.app.examenes.models.repository.IExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService {
	
	@Autowired
	IAsignaturaRepository asignaturaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAllAsignaturas() {
		// TODO Auto-generated method stub
		return asignaturaRepository.findAll();
	}

}
