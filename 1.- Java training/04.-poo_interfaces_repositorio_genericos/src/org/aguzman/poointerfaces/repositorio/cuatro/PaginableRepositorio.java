package org.aguzman.poointerfaces.repositorio.cuatro;

import java.util.List;

import org.aguzman.poointerfaces.modelo.cuatro.Cliente;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
