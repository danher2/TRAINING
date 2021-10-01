package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

//JPA conjunto de interfaces como se tiene que implementar la persistencia
// hibernet proveedor de JPA
//H2 database para desarrolla, solo en memoria viene dentro del proyecto, la base de datos se crea en auntomatico cuando se levanta y se destruye cuando se baja


@Controller // para indicar que es un controlador
@SessionAttributes("cliente") // se va a guardar en los atributos de la sesion el objeto cliente mapeado al formulario, guarda al objeto cliente y lo pasa a la vista y todos sus datos quedan persistendes hasta que se envie al metodo guardar
public class ClienteController {

	@Autowired // inyectamos la implementacion del tipo de la interfaz (solo hay una no necesitamos qualifier), busca un bean registrado en el contenedor que implementa la interfaz
	private IClienteDao clienteDao;

	@RequestMapping(value = "/listar", method = RequestMethod.GET) // es un RequestMapping donde damos la ruta y el tipo de peticion
	public String listar(Model model) { // importamos la clase model para pasar datos ala vista
		// pasamso 2 atributos a ala vista el titulo  y la lista
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";  // retronamos la pagina html listar
	}
	
	@RequestMapping(value = "/form") // ruta de form y se omite el get, se encarga de mostrar el formulario
	public String crear(Map<String, Object> model) { // recibe el Map, recibe un String(desde el front) y retorna el objeto

		Cliente cliente = new Cliente(); // se crrea el objeto vacio
//		 se manda a la vista los atributos
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		
		return "form"; // regresa el form
	}
	
//	devuelve cliente para poderlo editar
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) { // map se recibe un String y se retorna un Object
		
		Cliente cliente = null; // se crea cliente
		
		if(id > 0) { // si el id es mayor a cero
			cliente = clienteDao.findOne(id); // lo busque el repositorio
		} else { //sino
			return "redirect:/listar"; // redirige a la lista
		}
		//pasamos los datos a la vista
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "form"; // devolvemos el formulario
	}
	
	
	// para guardar el cliente
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	//@Valid para que valide los campos validados de Cliente, BindingResul siempre va seguido del objeto mapeado (cliente)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) { //eliminamos el objeto cliente de la sesio con SessionStatus (buena practica)
		
		
		if(result.hasErrors()) { // si hay algun error en la peticion, por ejemplo los campons no se validaron bien
			model.addAttribute("titulo", "Formulario de Cliente"); // retornamos el titulo
			return "form"; // y retornamos el form a la vista
		}
		
		clienteDao.save(cliente);// se guarda al objeto
		status.setComplete();
		return "redirect:listar";// redirige hacia la url listar
	}
	
	
	
	
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			clienteDao.delete(id);
		}
		return "redirect:/listar"; // redirige a listar
	}
}