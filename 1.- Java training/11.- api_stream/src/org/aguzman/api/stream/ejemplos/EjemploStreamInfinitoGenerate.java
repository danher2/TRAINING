package org.aguzman.api.stream.ejemplos;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

//GENERATE permite crear un flujo infinito y le podemos dar limite

public class EjemploStreamInfinitoGenerate {
    public static void main(String[] args) {

        AtomicInteger contador = new AtomicInteger(0); // probamos con un contador
        
        Stream.generate(() -> { // regresa un stream infinito recibe un SUPPLIER (en este caso retorna un int por el contador)

            try {
                TimeUnit.SECONDS.sleep(2); // le damos un delay una pausa
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return contador.incrementAndGet();
        })
        .limit(7)// aqui le damos limite
        .forEach(System.out::println); // lo recorremos
    }
}
