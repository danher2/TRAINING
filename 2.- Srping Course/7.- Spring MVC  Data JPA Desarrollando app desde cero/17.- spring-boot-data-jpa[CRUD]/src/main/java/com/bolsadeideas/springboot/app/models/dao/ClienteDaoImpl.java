package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Repository// decoramos con la anotacion Repository, marcar la clase como componente de persistencia, de acceso a datos
public class ClienteDaoImpl implements IClienteDao {// interfaz

	//es como la clase repository
	@PersistenceContext // va a inyectarlo segun la configuracion para usar de automatico la database H2
	private EntityManager em; // maneja las clases de identidades, el ciclo de vida, las actualiza las elimina etc

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true) //marcamos el metodo como transaccional y solo de lectura porque es una consulta, toma el contenido del metodo y lo envuelve dentro de una transaccion
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList(); // consulta  retorna la lista de tipo cliente
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id); //se  le envia el tipo de objeto y el id
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		// que el id sea distinto de null y es mayor que cero vamos a editar
		/* cuando creamos cliente no lleva id pero cuando lo consultamos viene de la bbdd con id
		 * es por eso que sabemos quea ese cliente lo podemos actualizar*/
		if (cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente); // actualiza los datos existentes
		} else {
			em.persist(cliente); //creamo un nuevo cliente, toma el objeto y lo guarda en el contexto de jpa una vez que se hace el commit se registra en la bddd
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id)); // eliminar cliente por id
	}

}
