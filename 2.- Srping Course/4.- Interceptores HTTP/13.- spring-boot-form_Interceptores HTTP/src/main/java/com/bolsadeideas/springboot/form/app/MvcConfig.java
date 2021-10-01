package com.bolsadeideas.springboot.form.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*Clase configuracion personalizada*/

@Configuration // indicamos que es clase configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Autowired
	@Qualifier("tiempoTranscurridoInterceptor") // componente  tiempoTranscurridoInterceptor
	private HandlerInterceptor tiempoTranscurridoInterceptor; // inyectamos el tipo que implementa la interfaz HandlerInterceptor

	@Override // sobreescribimos
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(tiempoTranscurridoInterceptor) // se intercepta a todos los controladores
		registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**"); // se intercepta solo a esta ruta , en la ruta form y en lo que venga
	}

}
