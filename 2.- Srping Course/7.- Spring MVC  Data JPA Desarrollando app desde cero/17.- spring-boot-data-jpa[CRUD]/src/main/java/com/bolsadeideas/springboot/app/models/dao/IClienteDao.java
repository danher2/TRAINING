package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

//CRUD

public interface IClienteDao {
	
	public List<Cliente> findAll();

	public void save(Cliente cliente);// recibe el objeto mapeado a la tabla y se guarda el objeto en la tabla
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);

}
