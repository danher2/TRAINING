package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

//	utilizamos method query, no requiere implementacion  porque es un method query, lo hace por debajo
	public Usuario findByUsername(String username);
}
