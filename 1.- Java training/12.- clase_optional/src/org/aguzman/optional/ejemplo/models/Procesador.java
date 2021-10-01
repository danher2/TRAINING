package org.aguzman.optional.ejemplo.models;

import java.util.Optional;

public class Procesador {
    
	//atrib
	private String nombre;
    private Fabricante fabricante;

    
    //construc
    public Procesador(String nombre, Fabricante fabricante) {
        this.nombre = nombre;
        this.fabricante = fabricante;
    }

    
    //getters&stters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Optional<Fabricante> getFabricante() {
        return Optional.ofNullable(fabricante);
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
