package org.aguzman.optional.ejemplo.repositorio;

import org.aguzman.optional.ejemplo.models.Computador;

import java.util.Optional;


//interfaz repositorio que se puede reutilizar utilizando generics, al igual que las clases genericas
// en este caso es un repositorio de computadoras, pero puede ser un respositorio de otra cosa
// tvs, productos, abanicos, etc
public interface Repositorio<T> {

	// un solo metodo recibe un string y devuelve un computador en particular
	// este metodo optional solo es usado para el caso especifico del tipo de  Computador pero puedes hacer otros metodos esoecifics
	// aqui solo la interfaz se hace generica para que veas que se puede utilizar en mas casos, como las clases genericas
    Optional<Computador> filtrar(String nombre);

}
