package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@SuppressWarnings("unused") // para suprimir los warnings (optional)
	@GetMapping("/index") // mapeado a la ruta indel
	public String index() {
		Integer valor = 100/0; // esto da error tmb
		// Integer valor = Integer.parseInt("10xaaa"); // string en un Integer error de tipo 
		return "index"; // retorna index.html, que no esta para que mande un erro
	}
}
