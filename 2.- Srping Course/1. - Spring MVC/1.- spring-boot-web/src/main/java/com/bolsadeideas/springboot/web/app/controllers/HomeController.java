package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // es un controlador
public class HomeController {

	//metodo que redirige al index controller, vaya al metodo index
	@GetMapping("/")
	public String home() {
		return "forward:/app/index"; // con forward redirige a la ruta de la pagina principal de nuestro proyecto
		/*forward = rutas propias del proyecto
		 * redirect = rutas externas*/
	
	}
}


