package org.aguzman.poointerfaces.repositorio.tres;

import java.util.List;

import org.aguzman.poointerfaces.modelo.tres.Cliente;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
