package org.aguzman.anotaciones.ejemplo.models;

import org.aguzman.anotaciones.ejemplo.Init;
import org.aguzman.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Producto {

	//las anotaciones por si misma no tienen ningun efecto en la ejecucion de la aplicacion
	//por lo tanto necesitamos implementar un procesador utilizando reflexion
	
    @JsonAtributo() // los atributos que se convertiran a json
    private String nombre;

    @JsonAtributo(nombre = "costo") // los atributos que se convertiran a json
    private Long precio;

    private LocalDate fecha;

    
    
    
    @Init
    private void init(){
        this.nombre = Arrays.stream(nombre.split(" "))
                .map(palabra -> palabra.substring(0, 1).toUpperCase()
                        + palabra.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    
    
    //getter&setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
