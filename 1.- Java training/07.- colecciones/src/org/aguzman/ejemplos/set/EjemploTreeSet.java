package org.aguzman.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {

    	
    	//los treeSet son ordenados
        Set<String> ts = new TreeSet<>((a, b) -> a.compareTo(b));// implementamos la interfaz comparator dentro del constructor  con un lambda y le damos un orden alfabetico ascendente o descendente

        //add metodo que hereda de la interfaz collection y mantiene el orden pero alfabetico y no acepta duplicados
        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("tres");// no lo vuelve a imprimir porque no acepta duplicados
        ts.add("cuatro");
        ts.add("cinco");

        System.out.println("ts = " + ts);
        
        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder()); //mandamos el en constructor el metodo comparator
        // si son numeros los regresa en orden, tienen que ser objetos que sean compatible con la interfaz comparable
        numeros.add(1);
        numeros.add(5);
        numeros.add(4);
        numeros.add(2);
        numeros.add(3);
        numeros.add(10);
        System.out.println("numeros = " + numeros);
    }
}
