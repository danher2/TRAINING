package org.aguzman.genericsclass.cuatro;

public class Animal {
    private String nombre;
    private String tipo;

    //constructor
    public Animal(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
