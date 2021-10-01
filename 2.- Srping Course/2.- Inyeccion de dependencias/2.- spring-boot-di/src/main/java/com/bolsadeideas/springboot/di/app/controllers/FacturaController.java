package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;



@Controller
@RequestMapping("/factura") //permite escanear el controllador a una ruta base
public class FacturaController {
	
	@Autowired // Autowired crea las instancias por nosotros
	private Factura factura; // inyectamos factura que seria como nuestro servicio
	
	@GetMapping("/ver") // ruta para  el servicio
	public String ver(Model model) {
		//mandamos atributos a la vista
		model.addAttribute("factura", factura); // pasamos TODO el objeto factura
		model.addAttribute("titulo", "Ejemplo Factura con inyección de dependencia"); // mandamos tmb titulo
		return "factura/ver"; // retorna la pagina html ver
	}

}
