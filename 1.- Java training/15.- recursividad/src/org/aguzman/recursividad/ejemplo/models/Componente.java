package org.aguzman.recursividad.ejemplo.models;

import java.util.ArrayList;
import java.util.List;


//CLASE RECURSIVA una clase que contienen elementos de su mismo tipo

public class Componente {
    private String nombre;
    private List<Componente> hijos; // componentes hijos
    private int nivel; // agregamos atributo nivel para correr con java 8

    
    //constructor
    public Componente(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    
    //getter&setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Componente> getHijos() {
        return hijos;
    }

    public void setHijos(List<Componente> hijos) {
        this.hijos = hijos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
    //metodos para agregar hijos
    public Componente addComponente(Componente c){
        this.hijos.add(c); //agrega los componentes hijos en su propia lista de hijos
        return this; // para encadenar el metodo dado
    }

//    para saber si tiene hijos metodo recursivo , regresa un true si es diferente de vacio, regresa un true si tiene hijos
    public boolean tieneHijos(){ //hasChildren
        return !this.hijos.isEmpty(); // devuelve true si el objeto sobre el cual se invoca este metodo tiene elementos en su lista de hijos
    }
}
