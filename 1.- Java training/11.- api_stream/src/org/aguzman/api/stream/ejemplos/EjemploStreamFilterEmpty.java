package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {
    public static void main(String[] args) {

        long count = Stream
                .of("Pato Guzman", "Paco Gonzalez", "", "Pepe Mena",
                        "")
                .filter(elemento -> elemento.isEmpty()) // filtrar los elementos vacios
                .peek(vacios -> System.out.println(vacios)) // recorre lista de vacios xD
                .count(); //tamano del stream ya trabajado
        
        System.out.println("count = " + count);

        
    }
}
