package com.bolsadeideas.springboot.app.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//PERSONALIZACION DEL LOGIN

@Controller
public class LoginController {

	@GetMapping("/login") // ruta del login, mandamos 5 argumentos
	public String login(@RequestParam(value="error", required=false) String error, //error en el login que no es requerido porque no siempre se envia	
			@RequestParam(value="logout", required = false) String logout, //
			Model model, Principal principal, RedirectAttributes flash) {
		
		//principal de java security siprincipal es dirente de null quiere decri que ya habia iniciado secion
		
		if(principal != null) { // significa que ya habia iniciado sesion
			flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
			return "redirect:/"; // redirigimos a la ruta proncipal
		}
		
		if(error != null) { // si hay un error en el login?
			//mandamos el mensaje a la vista
			model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}
		
		if(logout != null) {// obtenemos bandera de logout si es distinto de nulo agregamos un mensaje
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}
		
		return "login"; // retorna la vista login
	}
}
