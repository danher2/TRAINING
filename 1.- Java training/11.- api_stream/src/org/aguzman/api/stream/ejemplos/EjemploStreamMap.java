package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//OPERADOR MAP RETORNA UNA NUEVA INSTANCIA DE UN NUEVO STREAM  CON LOS CAMBIOS  Y EL ANTERIO LO MANTIENE INTACTO POR LO TANTO SEPUEDE REGRESAR AL ESTADO INICIAL
public class EjemploStreamMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena")//of para agregar valores y los imprime
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))//porcada elemento recibido, crea un objeto usuario el cual recibe dos argmentos, en la primera posicion recibe la primera posicion del  elemento divido por el primer espacioy en el segundo argumento la segunda posicion
                .peek(nombre -> System.out.println(nombre + " imprimiendo con peek"))// rastrea cada elemento y lo imprime, parecido al foreach
                .map(usuario -> {//por cada elemento
                    String nombre =  usuario.getNombre().toUpperCase(); // se obtiene solo el nombre y lo convertimos enmayuscula
                    usuario.setNombre(nombre); // lo seteamos en el nombre de cada usuario
                    return usuario; // devolvemos usuario
                });

        
        List<Usuario> lista = nombres.collect(Collectors.toList()); // usamos collect para convertir el stream a List (despues de haber trabajado con el stream)
        lista.forEach(System.out::println);// comprobando la conversion del stream  a list
        //nombres.forEach(System.out::println);

    }
}
