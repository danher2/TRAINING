package org.aguzman.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {

        Stream<String> nombres =  Stream.of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia", "Paco Gonzalez", "Paco Gonzalez", "Paco Gonzalez")
                .distinct(); // sacamos los repetidos
        
        String resultado = nombres.reduce("resultado concatenacion ", (a, b) -> a+ " # " + b); //los unimos con un numeral a representa al primer elemento recorrido o al anterior y b al actual  
        System.out.println(resultado);



    }
}
