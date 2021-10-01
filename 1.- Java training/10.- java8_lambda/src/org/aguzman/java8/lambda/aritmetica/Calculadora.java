package org.aguzman.java8.lambda.aritmetica;

import java.util.function.BiFunction;

public class Calculadora {

	// dos metodos que retornan double (al igual que nuestra interfaz funcional)
	
   
	
	
	//tercer argumento representa una funcion tipo Aritmetica que recibira como argumentos a a y b
	public double computar(double a, double b, Aritmetica lambda){// la implementacion lambda del tercer argumento se realiza en donde se llame este metodo computar
        return lambda.operacion(a, b);
    }

	//tercer argumento representa una funcion tipo BiFunction que recibira como argumentos a a y b
    public double computarConBiFunction(double a, double b, BiFunction<Double, Double, Double> lambda){ // la implementacion lambda del tercer argumento se realiza en donde se llame este metodo computarConBiFunction
        return lambda.apply(a, b);
    }
}
