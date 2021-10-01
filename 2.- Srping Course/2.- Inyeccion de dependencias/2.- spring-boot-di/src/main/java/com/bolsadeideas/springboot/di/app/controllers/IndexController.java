package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller // anotacion que indica que es un controlador
public class IndexController {
	
	@Autowired // inyeccion de dependencias de mi clase service
	@Qualifier("miServicioComplejo") // se inyecta a traves del nombre del componente, @Qualifier permite seleccionar que implementacion concreta de la interfaz (clase )vamos a usar
	private IServicio servicio; // inyectamos  la implementacion a travez de la interfaz

	@GetMapping({"/", "", "/index"}) // se mapea este metodo a diferentes rutas (dentro de un arreglo)
	public String index(Model model) { // enviamos un objeto model para mandar atributos a la vista
		
		model.addAttribute("objeto", servicio.operacion()); // mandamos a la vista
		return "index";
	}
	
	
}
