package com.elcuarzo.mvc.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcuarzo.mvc.modelos.Dojos;

public interface DojoRepositorio extends CrudRepository<Dojos, Long>{
	List<Dojos> findAll();
}
