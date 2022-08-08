package com.formacionbdi.microservicios.app.respuestas.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.formacionbdi.microservicios.app.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.app.commons.examenes.models.entity.Pregunta;

@Entity
@Table(name = "respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String texto;

	@ManyToOne(fetch = FetchType.LAZY)
	private Alumno alumno;

	@OneToOne(fetch = FetchType.LAZY)
	private Pregunta examen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Pregunta getExamen() {
		return examen;
	}

	public void setExamen(Pregunta examen) {
		this.examen = examen;
	}

}