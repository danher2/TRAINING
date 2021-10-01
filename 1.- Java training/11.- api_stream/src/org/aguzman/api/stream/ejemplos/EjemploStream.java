package org.aguzman.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//CREANDO UN STREAM
public class EjemploStream {
    public static void main(String[] args) {

    	
    	System.out.println("CREANDO UN STREM CON OF");
    	//creando un Stream (interfaz)  de of
        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepe"); // retorna un stream de los tipos de los elementos indicados
        nombres.forEach(System.out::println); // se imprime

        
        System.out.println("CREANDO UN STREM CON ARRAY");
        String[] arr = {"Pato", "Paco", "Pepa", "Pepe"};
        Stream<String> nombres2 = Arrays.stream(arr); // metodo stream recibe array de la clase helper Arrays, este metodo retorna un stream y le ponemos del tipo string
        nombres2.forEach(System.out::println);

        System.out.println("CREANDO UN STREM CON BUILDER");
        Stream<String> nombres3 = Stream.<String>builder() // retorna un constructor de stream que se castea con un string 
                .add("Pato") // se agregan los elementos del stream
                .add("paco")
                .add("pepa")
                .add("pepe")
                .build(); // contruye el stream y regresa el build construido del tipo String
        nombres3.forEach(System.out::println);

        //creando un stream de una collection, this case will be a List
        System.out.println("CREANDO UN STREM CON LIST");
        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Paco");
        lista.add("Pepe");
        lista.add("Pepa");

        Stream<String> nombres4 = lista.stream();//retorna un stream secuencial de esta lista como su fuente, conversion de la lista a un stream, para poder manupular sus datos
        nombres4.forEach(System.out::println); //se itera el strem

       //DIRECTO
        lista.stream().forEach(System.out::println); // sin necesidad de crear el objeto stream, simplemente directo

    }
}
