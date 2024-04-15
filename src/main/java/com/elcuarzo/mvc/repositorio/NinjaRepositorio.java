package com.elcuarzo.mvc.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcuarzo.mvc.modelos.Ninjas;

public interface NinjaRepositorio extends CrudRepository<Ninjas, Long>{
	List<Ninjas> findAll();
	List<Ninjas> findByDojoId(Long idDojo);
}
