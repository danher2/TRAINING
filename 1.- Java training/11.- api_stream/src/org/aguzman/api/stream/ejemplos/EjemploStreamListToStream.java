package org.aguzman.api.stream.ejemplos;


//CONVERTIR UN LIST A UN STREAM
import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres", "Guzman"));
        lista.add(new Usuario("Luci", "Martinez"));
        lista.add(new Usuario("Pepe", "Fernandez"));
        lista.add(new Usuario("Cata", "Perez"));
        lista.add(new Usuario("Lalo", "Mena"));
        lista.add(new Usuario("Exequiel", "Doe"));
        lista.add(new Usuario("Bruce", "Lee"));
        lista.add(new Usuario("Bruce", "Willis"));

        
        //convertir esto en un stream de tipo Usuario con  lista.stream --> listo!
        
        Stream<String> nombres = lista.stream()//convertimos un stream de usuario en un stream de string
                .map(u -> u.getNombre().toUpperCase()
                        .concat(" ")
                        .concat(u.getApellido().toUpperCase())) //con vertimos los strings a mayuscula
                .flatMap(nombre -> { // hace un flat pero a la lista original
                    if(nombre.contains(("pepe").toUpperCase())){ // devuelve los bruce (obvio estan en mayusculas)
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase) // para que lo convierta en minuscula
                .peek(System.out::println); // los recorra y los imprima como el foreach

        System.out.println(nombres.count()); // count operador terminal
    }
}
