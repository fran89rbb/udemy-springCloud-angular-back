package com.formacionbdi.microservicios.app.examenes.services;

import org.springframework.stereotype.Service;

import com.formacionbdi.microservicios.app.commons.services.CommonServiceImpl;
import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.app.examenes.models.repository.IExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, IExamenRepository> implements IExamenService {

}
