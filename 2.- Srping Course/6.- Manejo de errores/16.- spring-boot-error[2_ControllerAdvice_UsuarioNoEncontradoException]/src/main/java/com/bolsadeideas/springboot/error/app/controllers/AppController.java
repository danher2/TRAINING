package com.bolsadeideas.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.bolsadeideas.springboot.error.app.models.domain.Usuario;
import com.bolsadeideas.springboot.error.app.services.UsuarioService;

@Controller
public class AppController {
	
	@Autowired //  inyectamos atributo del tipo de la interfaz
	private UsuarioService usuarioService;

	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
		Integer valor = 100/0;
		// Integer valor = Integer.parseInt("10xaaa");
		return "index";
	}
	
	
	//ver usuario por id
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		//Usuario usuario  = usuarioService.obtenerPorId(id);
		
		/*if(usuario==null) {
			throw new UsuarioNoEncontradoException(id.toString());
		}*/
		//					en vez de implementar el if, usando or ElseThrow If a value is present, returns the value, otherwise throws an exceptionproduced by the exception supplying function.
		Usuario usuario  = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString())); // convertimos el id a String
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}
