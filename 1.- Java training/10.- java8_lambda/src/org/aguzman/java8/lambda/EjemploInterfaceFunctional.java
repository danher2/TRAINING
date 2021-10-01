package org.aguzman.java8.lambda;

import org.aguzman.java8.lambda.aritmetica.Aritmetica;
import org.aguzman.java8.lambda.aritmetica.Calculadora;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {

    	//se implementa la funcionalidad  de nuestra interfaz funcional en un objeto del Tipo
        Aritmetica suma = (a, b) -> a + b;
        Aritmetica resta = (a, b) -> a - b;

        
        Calculadora cal = new Calculadora();

        //con Aritmetica ( tmb se le puede dar la funcionalidad directo en el tercer argumento)
        System.out.println(cal.computar(10, 5, suma));
        System.out.println(cal.computar(10, 5, resta));
        System.out.println(cal.computar(10, 5, (a ,b) -> a * b)); // multimplicacion

        
        //con BiFunction
        System.out.println(cal.computarConBiFunction(10, 5, (a, b) -> a+b));
    }
}
