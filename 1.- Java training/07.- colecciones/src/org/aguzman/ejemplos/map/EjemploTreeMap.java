package org.aguzman.ejemplos.map;

import java.util.*;


//TREE MAP MAPA ORDENADO
public class EjemploTreeMap {
    public static void main(String[] args) {

    	
    	//ordena por el largo del nombre  de la llave
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());

        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", 30);

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");

        //guardamos direccion en persona
        persona.put("direccion", direccion);
        System.out.println("persona = " + persona);

    }
}
