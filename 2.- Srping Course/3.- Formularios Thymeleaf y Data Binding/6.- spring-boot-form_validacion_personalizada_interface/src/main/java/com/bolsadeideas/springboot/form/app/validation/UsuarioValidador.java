package com.bolsadeideas.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

//esta clase se inyectara en el controlador, se inyecta del tipo en concreto la clase no una interfaz
@Component // para que se pueda inyectar con autowired desde el contenedor de Spring
public class UsuarioValidador implements Validator {

	@Override // solo para declarar que clase entity o pojo vamos a validar
	public boolean supports(Class<?> clazz) {
		// retorna true si el objeto que validamos correspond al tipo usuario
		return Usuario.class.isAssignableFrom(clazz); // si la clase Usuario es la clase que se esta psando por argumento a ese tipo devuelve true
	}

	@Override
	public void validate(Object target, Errors errors) { //target = el objeto de tipo usuario
		Usuario usuario = (Usuario)target; // se castea al objeto tipo usuario
		
		//clase helpers de spring, rejectIfEmptyOrWhitespace se le pasa el error, el campo y el mensaje del error (mandamos al properties) 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre"); //Reject the given field with the given error code if the value is emptyor just contains whitespace.
		
		// si el identificador no coincide con la expresion regular
		if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
			errors.rejectValue("identificador", "pattern.usuario.identificador");// se le manda el campo y el mensaje de error del properties
		}

	}

}
