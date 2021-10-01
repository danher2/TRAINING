package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);
        
        

        Optional<Usuario> usuario = nombres.findFirst(); // nombres (lista filtrada) retorna un optional y con la primera coincidencia, convierte nuestro flujo a un solo objeto, busca a un solo objeto en particular dentro de un strea
        // System.out.println(usuario.orElse(new Usuario("John", "Doe")).getNombre()); //si no se encuentra pepe me devuelva otro usuario pero solo el nombre
         System.out.println(usuario.orElseGet(() -> new Usuario("John", "Doe")).getNombre());
        if(usuario.isPresent()) { //regresa true si el valor esta presente
            System.out.println(usuario.get()); //o puede ser tmb orElseThrow
        } else {
            System.out.println("No se encontro el objeto!");
        }
        //nombres.forEach(System.out::println);

    }
}
