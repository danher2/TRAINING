package org.aguzman.poointerfaces.repositorio.tres;

import java.util.List;

import org.aguzman.poointerfaces.modelo.tres.Cliente;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
