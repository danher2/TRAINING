package com.bolsadeideas.springboot.app.view.xml;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

// renderiza la vista del xml

@Component("listar.xml") // se puede inyctar, se exporta ellistado del cliente
public class ClienteListXmlView extends MarshallingView {

	@Autowired
	public ClienteListXmlView(Jaxb2Marshaller marshaller) {
		super(marshaller); // llamos el constructor del padre
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		//no se necesitan en el model
		model.remove("titulo");
		model.remove("page");
		
		
		Page<Cliente> clientes = (Page<Cliente>) model.get("clientes"); // casteamos la lista clientes a Page<Cliente>
		
		model.remove("clientes"); // ahora borramos de la vista la lista clientes
		
		// guardamos en el model el cliente list junto con el listado del model
		model.put("clienteList", new ClienteList(clientes.getContent()));

		// renderiza la vista
		super.renderMergedOutputModel(model, request, response);
	}

}
