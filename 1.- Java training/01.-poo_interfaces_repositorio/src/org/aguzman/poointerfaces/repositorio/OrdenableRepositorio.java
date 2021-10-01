package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.List;


public interface OrdenableRepositorio {
	
		//mismo nombre del metodo del crudRepositorio
		// lo que cambian son los argumentos
	    List<Cliente> listar(String campo, Direccion dir);
}
