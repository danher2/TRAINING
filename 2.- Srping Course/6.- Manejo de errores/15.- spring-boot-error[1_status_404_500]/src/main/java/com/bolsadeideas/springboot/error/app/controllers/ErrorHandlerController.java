package com.bolsadeideas.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*Personalizamos Excepciones en nuestras solicitudes Http*/

@ControllerAdvice // captura los lanzamientos de excepcion de las peticiones http y los mapeamos a metodos con el tipo de la excepcion  y lo mandamos a la vista
public class ErrorHandlerController {

	@ExceptionHandler(ArithmeticException.class) // se mapea a una excepcion y se manda el tipo de la exception
	public String aritmeticaError(ArithmeticException ex, Model model) { // retorna un String que es el nombre de la pagina
		
		// mandamos los atributos (objetos errores) a la vista
		model.addAttribute("error", "Error de aritmética");
		model.addAttribute("message", ex.getMessage()); // mensaje del error
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); // el staus code 500
		model.addAttribute("timestamp", new Date()); // mandamos fecha
		
		return "error/generica"; // retorna un html 
	}
	
	
	//guardar un String en un Integer
	@ExceptionHandler(NumberFormatException.class)
	public String numeroFormatoError(NumberFormatException ex, Model model) {
		
		// mandamos los atributos (objetos errores) a la vista
		model.addAttribute("error", "Error: Formato número inválido!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/numero-formato";
	}
}
