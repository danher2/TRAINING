package com.bolsadeideas.springboot.app.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bolsadeideas.springboot.app.models.entity.Cliente;


//clase xml wraper

@XmlRootElement(name="clientes") // este es el nombre del elemento Root Xml
public class ClienteList {
	
	@XmlElement(name="cliente") // cliente en singular
	public List<Cliente> clientes;

	//constru
	public ClienteList() {}


	public ClienteList(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
// metodo get
	public List<Cliente> getClientes() {
		return clientes;
	}


}
