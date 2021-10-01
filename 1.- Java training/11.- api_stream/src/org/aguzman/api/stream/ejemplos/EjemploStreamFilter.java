package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))// filter recibe un predicate (retorna boolean)  si el elememto dado es igual que pepe
                .peek(System.out::println); // recorra la lista filtrada

        List<Usuario> lista = nombres.collect(Collectors.toList()); // se convierte el stream filtrado en una lista y se imprime
        lista.forEach(System.out::println);
        //nombres.forEach(System.out::println);

    }
}
