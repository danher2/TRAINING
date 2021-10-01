package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
	
	//desde donde queremos paginar hasta donde
//	de cero a 9 de 10 a 20 ect
    List<Cliente> listar(int desde, int hasta);
}
