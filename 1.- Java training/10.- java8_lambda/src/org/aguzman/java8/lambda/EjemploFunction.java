package org.aguzman.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;


//FUNCTION
public class EjemploFunction {
    public static void main(String[] args) {

//    	Represents a function that accepts one argument and produces a result
//    	<T> the type of the input to the function - <R> the type of the result of the function
    	//recibe un string y retorna un String
        Function<String, String> f1 = param -> "Hola que tal! " + param;
        String resultado = f1.apply("andres");//Aplica esta funcio para el argumento dado
        System.out.println(resultado);

        // ejemplo con referencia de metodos
        Function<String, String> f2 = String::toUpperCase; // metodo de string que convierte el argumento dado en mayuscula
        System.out.println(f2.apply("andres"));// lo convertira en mayus

        
        // recibe dos argumentos  y el tercer es el tipo del return
        BiFunction<String, String, String> f3 = (a, b) -> a.toUpperCase().concat(b.toUpperCase());
        String r2 = f3.apply("andres", "jose");
        System.out.println(r2);

        
        //Bifunction con metodo referenciado, entran dos arg y retorna un int, compareTo devuelve un int
        BiFunction<String, String, Integer> f4 = String::compareTo;// (a, b) -> a.compareTo(b);
        System.out.println(f4.apply("andres", "andres"));

        
        
        BiFunction<String, String, String> f5 = String::concat;// (a, b) -> a.concat(b);
        System.out.println(f5.apply("andres", "jose"));
    }
}
