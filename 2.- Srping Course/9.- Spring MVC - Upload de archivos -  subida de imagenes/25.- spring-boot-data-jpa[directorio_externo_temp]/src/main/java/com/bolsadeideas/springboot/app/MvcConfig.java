package com.bolsadeideas.springboot.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//CLASE CONFIGURACION

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	
	//Para agregar directorio de recursos en nuestro proyecto
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		//url a la que se mapea el file
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations("file:/C:/Temp/uploads/"); //directorio fisico
	}
	
	

}
