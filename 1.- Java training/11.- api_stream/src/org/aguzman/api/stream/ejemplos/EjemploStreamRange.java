package org.aguzman.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {
    public static void main(String[] args) {

        IntStream num =  IntStream.range(5, 20).peek( n -> System.out.println(n));//recorremos el rango, rango del 5 al 20
        
        // int resultado = num.reduce(0, Integer::sum);
        // int resultado = num.sum();
        
        //operaciones estadisticas con streams
        IntSummaryStatistics stats = num.summaryStatistics();//para obtener operaciones estadisticas
        System.out.println("max: " + stats.getMax());//maximo
        System.out.println("min: " + stats.getMin());//min
        System.out.println("sum: " + stats.getSum());//suma
        System.out.println("promedio: " + stats.getAverage());//promedio
        System.out.println("total: " + stats.getCount()); //suma de elementos



    }
}
