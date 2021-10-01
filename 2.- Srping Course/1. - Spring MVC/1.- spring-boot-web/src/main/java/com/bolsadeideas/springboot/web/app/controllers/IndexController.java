package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//se encarga de manejar las peticiones del usuario
@Controller // componente de Spring de tipo controlador
@RequestMapping("/app")//ruta de primer nivel, this annotation is for mapping web requests onto methods in request-handling classeswith flexible method signatures. 
public class IndexController {
	
	//Para inyectar valores a nuestros atributos desde el properties, inyeccion de dependencia aplicada a texto
	@Value("${texto.indexcontroller.index.titulo}")// se inyecta el valor del properties
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}") // se inyecta el valor del properties
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}") // se inyecta el valor del properties
	private String textoListar; //
	
	
	//Annotation for mapping HTTP GET requests onto specific handlermethods. 
	@GetMapping({"/index", "/", "", "/home"})// este metodo puede estar mapeado a mas de una ruta url, solo se separa por coma la diferente ruta
	public String index(Model model) {// interfaz que permite  agregar  atributos a la vista , en este caso sera al ititulo  de nuestro index
		model.addAttribute("titulo", textoIndex); // agregamos un  titulo y un valor
		return "index"; // retorna una vista, la pagina index que creamos ,retorna un string con el nombre de la vista
	}
	
	// si no se especifica el get en el RequestMapping entonces es una peticion get por default, 
	@RequestMapping("/perfil") // para mapear
	public String perfil(Model model) {  // permite asignar atributos al modelo
		
		Usuario usuario = new Usuario(); // se crea un objeto de tipo usuario
		usuario.setNombre("Andrés");
		usuario.setApellido("Guzmán");
		usuario.setEmail("andres@correo.com");
	
		//a travez del objeto model diseñado para añadir atributos al modelo. Permite acceder al modelo global como
		model.addAttribute("usuario", usuario); // "usuario" es el nombre de atributo lo podemos llamar desde el html con ${}, usuario es el valor que se devuelver al llamar a ese atributo
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre())); // titulo tmb ${}
		return "perfil"; // retorna el nombre de la vista (pagina htmlm sin la extension) y lo busca por debajo en recursos/template
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", textoListar);// textolistar tiene el valor de lo que se le especifica en el textos.properties
		
		return "listar"; // retorna un string que es el nombre de la pagina html listar
	}
	
	// metodo con model atribute, tmb los metodos se puede anotar para que su funcianilad tmb se pueda mandar al view
	// este metodo se llama desde la pagina listar.html para que aparezca condicionalmente si la lista esta o no vacia
	// asi como los campos tmb se mandan al view con Model
	// tmb con la anotacion modelAtribute hace que se pueda llamar la implementacion de un metodo desde el view
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrés", "Guzmán", "andres@correo.com"),
				new Usuario("John", "Doe", "john@correo.com"),
				new Usuario("Jane", "Doe", "jane@correo.com"),
				new Usuario("Tornado", "Roe", "roe@correo.com"));
		
		return usuarios; // devuelve una lista de usuarios
	}

}
