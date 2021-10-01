package com.bolsadeideas.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario); // para la persistencia de los datos que no tuvieron erro en la validacion y se queden plasmados en el formulario
		return "form";
	}
	
	@PostMapping("/form")
	//valid para validar las anotaciones de reglas que tengan los atribtos de usuarios
	//BindingResult en caso de que falle la validacion tiene todo el resultado de la falla de la validacion
	// siempre tiene que estar despues del objeto que se valida y el entity siempre tiene que ser  primero qeu Bindign
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		
		model.addAttribute("titulo", "Resultado form");// pasamos primero que nada el titulo al view
		
		// si hay errores en la valicacion
		if(result.hasErrors()) { // si tiene algun error
			Map<String, String> errores = new HashMap<>(); // creamos un HasMap vacio 
			result.getFieldErrors().forEach(err ->{ // devuelve una lista que vamos a recorrer
				// agregamos al map, key el nombre del campo y valor, y un mensaje con el error
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			
			model.addAttribute("error", errores); // se manda la lista de errores al view
			return "form"; // devuelve la vista formulario
		}
		
		// si no hay error en la validacion mandamos el objeto usuario al view
		model.addAttribute("usuario", usuario);

		// y retornamos el html resultado
		return "resultado";
	}

}
