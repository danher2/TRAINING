package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/*CLASES POJO TMB PUEDEN SER MANEJADAS POR SPRING (TMB SE LE PUEDEN PONER ANOTACIONES)*/
@Component
@RequestScope
public class Cliente {

	@Value("${cliente.nombre}") // se define en el properties
	private String nombre;

	@Value("${cliente.apellido}")// se define en el properties
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
