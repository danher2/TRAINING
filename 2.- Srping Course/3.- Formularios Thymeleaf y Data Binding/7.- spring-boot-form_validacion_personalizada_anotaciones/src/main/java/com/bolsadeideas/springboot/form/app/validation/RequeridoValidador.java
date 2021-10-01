package com.bolsadeideas.springboot.form.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;


//Aqui esta la logica de la anotacion Requerido
//ConstraintValidator<Requerido,TipoCampo>
public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || !StringUtils.hasText(value)) { // StringUtils helper, clase de utilidad de Spring, si es distinto a vacio y si tiene texto
			return false;
		}
		return true;
	}

}
