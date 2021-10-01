package org.aguzman.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduceInt {
    public static void main(String[] args) {

        Stream<Integer> nombres =  Stream.of(5, 10, 15, 20);
        
        int resultado = nombres.reduce(0, (a,b) -> a+b  ); // reducir los  enteros con la suma, el 0 representa que solo los enteros se sumaran o el valor inicial
        System.out.println(resultado);



    }
}
