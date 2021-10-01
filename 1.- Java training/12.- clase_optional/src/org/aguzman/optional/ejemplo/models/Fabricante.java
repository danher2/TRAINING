package org.aguzman.optional.ejemplo.models;

public class Fabricante {

	//atrib
	private String nombre;

	
	//constr
    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    
    
    //getter&setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
