package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.Producto;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@Controller
@RequestMapping("/factura") // ruta base
@SessionAttributes("factura") //mantiene el objeto factura dentro de la sesion hasta que se envie al formulario, persiste la informacion, con el mismo nombre factura con el cual se pasa a la vista
public class FacturaController {

	@Autowired
	private IClienteService clienteService;

	
	//CREAR
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
			RedirectAttributes flash) {

		//obtener al cliente por su id
		Cliente cliente = clienteService.findOne(clienteId);

		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar"; // REDIRIGE A la vista listar
		}

//		creamos la factura
		Factura factura = new Factura();
		factura.setCliente(cliente); // le asignamos a un cliente

		
		
		// pasamos la factura ala vista , asignado a una llave
		model.put("factura", factura);
		model.put("titulo", "Crear Factura");// pasamos un titulo a la factura

		return "factura/form";
	}

	
	
	//CARGAR PRODUCTOS
	//trasforma la salida en json es el auto complete
	
	@GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
		return clienteService.findByNombre(term);
	}

}
