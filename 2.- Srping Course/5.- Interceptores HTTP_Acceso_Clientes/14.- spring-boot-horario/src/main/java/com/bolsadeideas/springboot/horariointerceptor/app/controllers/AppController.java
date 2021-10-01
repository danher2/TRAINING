package com.bolsadeideas.springboot.horariointerceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@Value("${config.horario.apertura}") // inyectamos el valor correspondiente del properties
	private Integer apertura;
	
	@Value("${config.horario.cierre}") // inyectamos el valor correspondiente del properties
	private Integer cierre;
	
	//funciona a traves de un rango de hora
	@GetMapping({"/", "/index"})
	public String index(Model model) { // para mandar a la vista
		model.addAttribute("titulo", "Bienvenido al horario de atención a clientes"); // mandamos a la vista
		return "index"; // retornamos pagina html index
	}
	
	
	@GetMapping("/cerrado") // MISMA ruta del interceptor
	public String cerrado(Model model) {
		
		StringBuilder mensaje = new StringBuilder("Cerrado, por favor visítenos desde las ");
		mensaje.append(apertura);
		mensaje.append(" y las ");
		mensaje.append(cierre);
		mensaje.append(" hrs. Gracias.");
		
		// mandamos atributos a la vista
		model.addAttribute("titulo", "Fuera del horario de atención");
		model.addAttribute("mensaje", mensaje); // mensaje de cerrado
		return "cerrado"; // devuelve la pagina html cerrado
	}
}
