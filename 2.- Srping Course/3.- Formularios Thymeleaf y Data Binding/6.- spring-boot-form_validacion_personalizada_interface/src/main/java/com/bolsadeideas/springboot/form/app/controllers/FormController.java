package com.bolsadeideas.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario") // se le da el nombre del objeto que pasamos a la vista, sirve para persistir los datos de los atributos que esten independientes del formulario
public class FormController {
	
	@Autowired // inyectamos el tipo concreto de la clase porque solo es una implementacion
	private UsuarioValidador validador;
	
	@InitBinder // sirve para identificar metodos inicializados con WebDataBinder y que asu vez utilan los objectos de argumentos de los form
	public void initBinder(WebDataBinder binder) { // objeto donde vienen los objetos que  mandamos como argumento en una peticio web
		binder.addValidators(validador); // agrega las validaciones que hayamos hecho para nuestros campos
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.456.789-K");
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		
		//utilizamos la instancia para validar, le pasamos el objeto target (usuario) y erros (result)
		// validador.validate(usuario, result);
		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
			
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
        status.setComplete(); // se elimina de forma automatica el objeto usuario de la sesion
		return "resultado";
	}

}
