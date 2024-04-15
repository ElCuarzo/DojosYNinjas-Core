package com.elcuarzo.mvc.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elcuarzo.mvc.modelos.Dojos;
import com.elcuarzo.mvc.modelos.Ninjas;
import com.elcuarzo.mvc.repositorio.DojoRepositorio;
import com.elcuarzo.mvc.repositorio.NinjaRepositorio;

@Service
public class Servicio {
	private final DojoRepositorio dojoRep;
	private final NinjaRepositorio ninjaRep;
	
	public Servicio(DojoRepositorio dojoRepositorio, NinjaRepositorio ninjaRepositorio) {
		this.dojoRep = dojoRepositorio;
		this.ninjaRep = ninjaRepositorio;
	}
	
	//Obtener todos los dojos
	public List<Dojos> ObtenerDojos() {
		return dojoRep.findAll();
	}
	
	//Obtener dojo por id
	public Dojos ObtenerDojoPorId(Long id) {
		return dojoRep.findById(id).orElse(null);
	}
	
	//Obtener todos los ninjas
	public List<Ninjas> obtenerNinjas(){
		return ninjaRep.findAll();
	}
	
	//Crear un Dojo
	public Dojos crearUnDojo(Dojos d) {
		 return dojoRep.save(d);
	}
	
	//Crear un Ninja
	public String crearNinja (Long dojoId, String nombre, String apellido, int edad) {
		Optional<Dojos> dojoOpcion = dojoRep.findById(dojoId);
		if (dojoOpcion.isPresent()) {
			Dojos dojo = dojoOpcion.get();
			Ninjas ninja = new Ninjas(nombre,apellido,edad);
			ninja.setDojos(dojo);
			ninjaRep.save(ninja);
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	//Obtener ninjas por Dojo
	public List<Ninjas> obtenerNinjaPorDojo(Long idDojo) {
		return ninjaRep.findByDojoId(idDojo);
	}
}
