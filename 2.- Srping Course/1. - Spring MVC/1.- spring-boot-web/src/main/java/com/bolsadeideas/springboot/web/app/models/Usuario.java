package com.bolsadeideas.springboot.web.app.models;

/*CLASE POJO, CLASE SIMPLE DE JAVBA CON ATRIBUTOS Y SETTER & GETTER, DESACOMPLADA DE CUALQUIER FRAMEWORK
 * LIBRE DE IMPLEMENTACIONES Y HERENCIA Y SON MUY REUTILIZABLES
 * representan los datos de nuestra applicacion
 * se utiliza con JPA cuando mapeamos a las tablas*/

public class Usuario {

	private String nombre;
	private String apellido;
	private String email;

	
	//constructores
	public Usuario() {
	}

	public Usuario(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	
//	getter para acceder a datos y setters para modificarlos o crearlos
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
