package com.bolsadeideas.springboot.form.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor") // nombre del componente que se va a inyectar
public class TiempoTranscurridoInterceptor implements HandlerInterceptor{ //se implementa la interfaz
	
	
	//para registrar algun evento en el log o en la traza de nuestra app, es constante, getLogger de argumento nombre de la clase
	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override // interceptor
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// solo se ejecuta  para el metodo post
		if(request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}
//		si es una instancia de un metodo del  controlador
		if(handler instanceof HandlerMethod) { // si el objeto es del tipo del controlador
			HandlerMethod metodo = (HandlerMethod) handler; // lo casteo
			logger.info("es un método del controlador: " + metodo.getMethod().getName()); // saco el nombre de la rut de un metodo en el controlador controlador
		}

		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando ...");
		logger.info("Interceptando: " + handler);
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		// simulando demora
		Random random = new Random();
		Integer demora = random.nextInt(100);
		Thread.sleep(demora); // pausa en milisegundos
		
		return true; // continua con la ejecucion
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// se ejecuta solo si es un methodo post
		if(request.getMethod().equalsIgnoreCase("post")) {
			return; // no retorna nada, retorna un void porque el metodo es void
		}
		
		long tiempoFin = System.currentTimeMillis();
		long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		//si es una instancia de un metodo del  controlador
		if(handler instanceof HandlerMethod && modelAndView != null) { // para que no intercepte otras rutas por ejemplo las de recursos
			modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido); // lo pasamos a la vista con este nombre tiempoTranscurrido
		}
		
		//lo que aparecera en la traza
		logger.info("Tiempo Transcurrido: " + tiempoTranscurrido + " milisegundos");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo ...");

	}

	
}
