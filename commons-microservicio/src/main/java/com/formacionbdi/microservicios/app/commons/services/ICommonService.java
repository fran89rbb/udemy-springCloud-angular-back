package com.formacionbdi.microservicios.app.commons.services;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommonService<E> {
	
	public Iterable<E> findAll();
	
	public Page<E> findAll(Pageable pageable);
	
	public Optional<E> findById(Long id);
	
	public E save(E entity);
	
	public void deleteById(Long id);

}
