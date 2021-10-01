package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;


//to provide additional methods to retrieve entities using the pagination andsorting abstraction.
public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{


}
