package com.bolsadeideas.springboot.error.app.errors;



/*Maneja el error de cuando un usuario no se encontro*/
public class UsuarioNoEncontradoException extends RuntimeException { // hereda de RuntimeException


	public UsuarioNoEncontradoException(String id) {
		// llamamos el constructor del RunTime, mensaje concatenado con el id
		super("Usuario con ID: ".concat(id).concat(" no existe en el sistema"));
	}

	
	// para trasportar y recoonvertir el objeto
	private static final long serialVersionUID = 1L;

}
