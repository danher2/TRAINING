package com.bolsadeideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller //indica que es un controlador
public class FormController {
	
	
	//este get es para mostrar el formulario
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario usuarios");
		return "form"; // si es ruta /form pero metodo get, aparezca formulario
	}
	
	//llenado de dato
	@PostMapping("/form") // misma ruta /form pero metodo post
	public String procesar(Model model, 
			//del objeto httpRequest spring va a extraer  estos nombres de campo que se definen 
			//con el name o el alias del name que es el value en el form.html
			@RequestParam(name="username") String username, // lo extrae del input name username del form
			@RequestParam String password, 
			@RequestParam String email) {
		
		// creamos un objeto usuario aqui se hace la logica
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("usuario", usuario);

		
		return "resultado";
	}

}
