package com.bolsadeideas.springboot.app.view.json;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Component("listar.json") // ruta de lista de tipo json
@SuppressWarnings("unchecked")
public class ClienteListJsonView extends MappingJackson2JsonView {// implementa una vista de tipo json

	@Override
	protected Object filterModel(Map<String, Object> model) {

		//quitamos titulo y page del model
		model.remove("titulo");
		model.remove("page");

		// obtenemos clientes
		Page<Cliente> clientes = (Page<Cliente>) model.get("clientes");
		model.remove("clientes"); // eliminamos clientes de nuevo
		
		// ponemos en el model el contenido de los clientes
		model.put("clientes", clientes.getContent());
		
		return super.filterModel(model);
	}

}
