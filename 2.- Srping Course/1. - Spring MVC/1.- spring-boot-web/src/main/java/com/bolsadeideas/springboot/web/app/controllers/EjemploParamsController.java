package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*EJEMPLO CON @RequesParam*/

@Controller
@RequestMapping("/params")// ruta base
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {
		return "params/index"; // la ruta al index por medio de la carpeta params en resources
	}

	// pasar parametros mediante la url con anotacion RequestParam
	@GetMapping("/string") // recibe 2 argumentso el primero con la anotacion RequestParam, valor del parametro por default
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "algún valor...") String texto,
			Model model) { // model para enviar atributos java a la pag web (ver.html)
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver"; // devuelve la ruta a la pag html "ver"
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {// en la ruta pueden venir los atributos que se quiera, saludo, nombre etc ya que HttpServletRequest los toma todos
		String saludo = request.getParameter("saludo");// se da por hecho que en la peticio se recibe un atibuto llamado saludo retorna el valor de un parametro dentro de la solicitud y lo convierte a string
		Integer numero = null;
		
		try {
			numero = Integer.parseInt(request.getParameter("numero")); // retorna el valor de un parametro  numero dentro de la solicitud y lo convierte a string
		} catch (NumberFormatException e) {
			numero = 0; // sino hay numero devuelve cero
		}
		
		// devuelve el saludo y el numero que se le manda en la peticion del enlace en el index
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

}
