package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {

        Usuario usuario = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", // crea la lista con of
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))//trabaja la lista creando usuario con nombre y apellido
                .peek(System.out::println)// recorre el strem y devuelve un stream
                .filter(u -> u.getId().equals(5))
                .findFirst().orElseGet(() -> new Usuario("John", "Doe"));// si no se encuentra id 5 devuelva por default otro usuario

        System.out.println(usuario);

    }
}
