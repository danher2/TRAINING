package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;


//ejemplo con sum
public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {

        IntStream largoNombres = Stream
                .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia", "Pato Guzman", "Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt( u -> u.toString().length()) // retorna a un stream de int y por cada elemto retorna en lenght del mismo
                .peek(System.out::println);

        //capturar el lenght de nombre y apellido
        
        
        //SOLO SE PUEDE PONER UN OPERDOR FINAL EN UN STREAM POR QUE SE CIERRA EL FLUJO DEL STREAM CON EL PRIMER OPERADOR TERMINAL
        
        
        //largoNombres.forEach(System.out::println);
        IntSummaryStatistics stats = largoNombres.summaryStatistics(); // --> OPERADOR TERMINAL QUE ENVUELVE TODO - metodo para realizar operaciones estadisticcas al stream
        
        System.out.println("total: " + stats.getSum()); //suma
        System.out.println("max: " + stats.getMax()); //max
        System.out.println("Min = " + stats.getMin()); //min
        System.out.println("promedio :" + stats.getAverage());// promedio
    }
}
