package org.aguzman.anotaciones.ejemplo;

import java.lang.annotation.*;

//ESTRUCTURA PARECIDA A UNA INTERFAZ
//como convertir a un objeto cuialquiera a un objeto json
// la anotacion tmb tiene anotaciones, la metadata, las anotaciones se pueden aplicar a un atributo, metodo o clase


@Documented // nuestra anotacion se va a documentar en la api doc
@Target(ElementType.FIELD)//donde se aplicaran las anotaciones, indica el contexto en que el tipo de anotacion es aplicable = campos
@Retention(RetentionPolicy.RUNTIME)//Indica cuánto tiempo deben conservarse las anotaciones con el tipo anotado
public @interface JsonAtributo { 
   
	//atributos de configuracion
	
	String nombre() default ""; // vacio por default esto es lo que puede ir en parenteris  depues de poner la anotacion arriba del atributo
    boolean capitalizar() default false;


}
