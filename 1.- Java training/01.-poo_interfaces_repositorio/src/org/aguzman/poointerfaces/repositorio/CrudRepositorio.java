package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.List;

//crud repositorio
public interface CrudRepositorio {
    List<Cliente> listar();
    
    //retorna el cliente por id
    Cliente porId(Integer id);
    
    //crea in cliente en nuestro repositorio
    void crear(Cliente cliente);
    //void no regresa nada
    void editar(Cliente cliente);
    
    //delete borra por id
    void eliminar(Integer id);
}
