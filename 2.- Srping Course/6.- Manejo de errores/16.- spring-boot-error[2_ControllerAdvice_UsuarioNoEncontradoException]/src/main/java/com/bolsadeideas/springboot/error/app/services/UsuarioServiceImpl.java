package com.bolsadeideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;

@Service // es el service que puede ser inyectado
public class UsuarioServiceImpl implements UsuarioService {

	// referencia a lista
	private List<Usuario> lista;
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>(); // lista vacia
		//agregando usuarios
		this.lista.add(new Usuario(1, "Andrés", "Guzmán"));
		this.lista.add(new Usuario(2, "Pepa", "García"));
		this.lista.add(new Usuario(3, "Lalo", "Mena"));
		this.lista.add(new Usuario(4, "Luci", "Fernández"));
		this.lista.add(new Usuario(5, "Pato", "González"));
		this.lista.add(new Usuario(6, "Paco", "Rodríguez"));
		this.lista.add(new Usuario(7, "Juan", "Gómez"));
	}

	@Override
	public List<Usuario> listar() {
		return this.lista; // devuelve lista
	}

	
	//devuelve un objeto de tipo usuario, mandado el id
	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		for(Usuario u: this.lista) {
			if(u.getId().equals(id)) {
			    resultado = u;
			    break; // rompemos cuando lo encuentre
			}
		}
		
		return resultado; // retornammos el usuario
	}

	@Override 	//devuelve un objeto de tipo usuario, mandado el id, pero USANDO optional
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario); //pregunta si el valor es nulo devuelve true sino lo devuelve vacio
	}

}
