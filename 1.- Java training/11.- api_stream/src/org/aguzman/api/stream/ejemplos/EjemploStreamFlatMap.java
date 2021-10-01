package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;


//FLATMAP
public class EjemploStreamFlatMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .flatMap(u -> {
                    if(u.getNombre().equalsIgnoreCase("Pepe")){ // filtramos por pepe
                        return Stream.of(u); //devolvemos el STREAM de  los objetos u que sean igual a pepe
                    }
                    return Stream.empty(); // si no existe (else) devuelva un stream vacio
                })
                .peek(System.out::println);

        // nombres.forEach(System.out::println);
        System.out.println(nombres.count());

    }
}
