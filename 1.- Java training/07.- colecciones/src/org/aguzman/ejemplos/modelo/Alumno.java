package org.aguzman.ejemplos.modelo;

import java.util.Objects;


//EJEMPLO CON TREESET Y COMPARABLE

public class Alumno implements Comparable<Alumno>{
    
	
	private String nombre;
    private Integer nota;

    
    //constructor
    public Alumno() {
    }

    public Alumno(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    //getter&setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    //para poder imprimir el objeto
    @Override
    public String toString() {
        return nombre + ", nota=" + nota;
    }

    @Override // metodo de la interfaz comparable que hace el cast del objeto alumno
    public int compareTo(Alumno a) {
        if(this.nombre == null){
            return 0;
        }
        return this.nombre.compareTo(a.nombre);// ordenamos por nombre
       
        
        /*if(this.nota == a.nota){
            return 0;
        }
        if(this.nota > a.nota){
            return 1;
        } else {
            return -1;
        }*/
        /*if(this.nota == null){
            return 0;
        }
        return this.nota.compareTo(a.nota);*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //primero compara por referencia
        if (o == null || getClass() != o.getClass()) return false; // compara por atributos
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) &&
                Objects.equals(nota, alumno.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}
