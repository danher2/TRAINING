package org.aguzman.poointerfaces.repositorio.cuatro;

import java.util.List;

import org.aguzman.poointerfaces.modelo.cuatro.Cliente;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
