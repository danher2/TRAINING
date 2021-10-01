package com.bolsadeideas.springboot.horariointerceptor.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Autowired
	@Qualifier("horario") // ya que el componente horario es la clase HorarioInterceptor que implementa HandlerInterceptor, con qualifier indicamos que inyectamos esta clase que implementa HandlerInterceptor
	private HandlerInterceptor horario;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) { // agregar el interceptor
//		registry.addInterceptor(horario);// se aplica a todos los controladores incluyendo cerrado
		registry.addInterceptor(horario).excludePathPatterns("/cerrado"); // agrerar interceptor exlucyendo a la ruta "cerrado" del controlador 
	}

}
