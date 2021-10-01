package com.bolsadeideas.springboot.di.app.models.service;

//import org.springframework.stereotype.Component;

//@Component("miServicioComplejo") // se le puede dar nombre al componente, tmb se puede usar la clase service, por semantica
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante complicado...";
	}
	
}
