package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*PathVariable vs RequestParam
 * sirven pa lo mismo, para enviar parametro en la url
 * ResquestParam
 * extrae el para con el nombre desde el objeto httprequest
 * PathVariable(recomendado)
 * un parametro en la ruta de spring que estamos mapeando*/

@Controller
@RequestMapping("/variables")// ruta base
public class EjemploVariablesRutaController {
	
	@GetMapping("/")// se mapea a la raiz de variables
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");
		return "variables/index"; // retorna a la pag de index.html (que es la pagina que tiene las urls que a su vez estas tienen las peticiones )
	}
	
	@GetMapping("/string/{texto}")//ruta que contiene una variable con nombre del parametro , model lo recibimos por default
    public String variables(@PathVariable String texto, Model model) { //Annotation which indicates that a method parameter should be bound to a URI templatevariable

		// se prepara atributos para que puedan ser llamados desde ver.html de variables por medio de thymeleaf
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
		return "variables/ver";
	}

	//pasar varios parametros dentro de una ruta
	@GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) { // se capturan esos parametro con PathVariable
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto
				+ " y el número enviado en el path es: " + numero);
		return "variables/ver";
	}
	
}
