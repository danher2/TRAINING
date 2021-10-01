package com.bolsadeideas.springboot.di.app.models.service;

//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;

//@Primary // permite seleccionar el cadidato que sea por defecto, que sea la implementacion por defecto (porque son dos)
//@Component("miServicioSimple") // se le puede dar un identificador a un componente
public class MiServicio implements IServicio{ // implementa nuestra interfaz IServicio
 
	
	// implementacion del service
	@Override
	public String operacion() {
		return "ejecutando algún proceso importante simple ...";
	}
	
}
