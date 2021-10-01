package org.aguzman.java8.lambda.aritmetica;



@FunctionalInterface //creamos una interfaz funcional
public interface Aritmetica {
	    double operacion(double a, double b);// nuestro metodo abstracto, retorna un double y recibe dos argumentos double
}
