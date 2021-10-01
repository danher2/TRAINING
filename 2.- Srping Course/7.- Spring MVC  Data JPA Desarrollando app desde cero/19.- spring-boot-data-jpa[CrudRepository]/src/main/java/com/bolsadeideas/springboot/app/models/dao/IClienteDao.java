package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

// no tiene ninguna anotacion pero si se puede inyectar Interfaz especial
public interface IClienteDao extends CrudRepository<Cliente, Long>{


}
