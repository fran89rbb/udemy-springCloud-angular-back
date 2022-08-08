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
		// TODO Auto-generated method stub
		return repository.saveAll(respuestas);
	}

}
