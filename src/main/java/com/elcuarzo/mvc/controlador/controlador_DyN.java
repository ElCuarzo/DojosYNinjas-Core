package com.elcuarzo.mvc.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elcuarzo.mvc.modelos.Dojos;
import com.elcuarzo.mvc.modelos.Ninjas;
import com.elcuarzo.mvc.servicio.Servicio;

@Controller
public class controlador_DyN {
	
	private final Servicio servicios;
	
	public controlador_DyN(Servicio servicios) {
		this.servicios = servicios;
	}
	
	@RequestMapping("/dojos/{id}")
	public String index(@PathVariable("id") Long id,
						Model model) {
		Dojos dojo = servicios.ObtenerDojoPorId(id);
		model.addAttribute("dojo", dojo);
		List<Ninjas> ninjas = servicios.obtenerNinjaPorDojo(id);
 		model.addAttribute("ninjas", ninjas);
		return "index.jsp";
	}
	
	@RequestMapping("/nuevo/dojo")
	public String nuevoDojoIndex() {
		return "/nuevoDojo.jsp";
	}
	
	@RequestMapping("/nuevo/ninja")
	public String nuevoNinjaIndex(Model model) {
		List<Dojos> dojos = servicios.ObtenerDojos();
		model.addAttribute("dojos", dojos);
		return"/nuevoNinja.jsp";
	}
	
	@RequestMapping(value="/nuevo/dojo", method = RequestMethod.POST)
	public String nuevoDojo(@RequestParam(value="nombre") String nombre){
		Dojos dojo = new Dojos(nombre);
		servicios.crearUnDojo(dojo);
		return "redirect:/nuevo/ninja";
	}
	
	@RequestMapping(value="/nuevo/ninja", method = RequestMethod.POST)
	public String nuevoNinja(@RequestParam(value="dojoId") Long dojoId,
							 @RequestParam(value="nombre") String nombre,
							 @RequestParam(value="apellido") String apellido,
							 @RequestParam(value="edad") int age) {
		servicios.crearNinja(dojoId, nombre, apellido, age);
		return "redirect:/dojos/" + dojoId;
	}
}
