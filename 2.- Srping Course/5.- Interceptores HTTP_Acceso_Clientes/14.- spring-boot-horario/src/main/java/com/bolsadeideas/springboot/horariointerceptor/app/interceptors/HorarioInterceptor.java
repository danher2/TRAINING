package com.bolsadeideas.springboot.horariointerceptor.app.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*DEL INTERCEPTOR SE MANDA A LA VISTA*/


@Component("horario") // le damos un nombre al componente interceptor
// implementamos handleInterceptor
public class HorarioInterceptor implements HandlerInterceptor {
	@Value("${config.horario.apertura}")// inyectamos el valor correspondiente del properties
	private Integer apertura;
	
	@Value("${config.horario.cierre}")// inyectamos el valor correspondiente del properties
	private Integer cierre;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Calendar calendar = Calendar.getInstance();// obtiene la hora actual
		int hora = calendar.get(Calendar.HOUR_OF_DAY); // obtenemos la hora y dia
		
		if(hora >= apertura && hora < cierre) { // dentro del rango
//			entonces...
			StringBuilder mensaje = new StringBuilder("Bienvenidos al horario de atencion a clientes"); // para crear string que sean mutable, que se pueda modificar sin crear mas instancias
			// mutamos, cambiamos o modficamos la misma instancia
			mensaje.append(", atendemos desde las ");
			mensaje.append(apertura); //apertura
			mensaje.append("hrs. ");
			mensaje.append("hasta las ");
			mensaje.append(cierre); // cierre
			mensaje.append("hrs. ");
			mensaje.append("Gracias por su visita.");
			request.setAttribute("mensaje", mensaje.toString()); // mandamos todo el mensaje desde el interceptor hasta a la vista, convertimos el StringBuilder a un string que al final estamos concatenando
			return true; // si todo esto se cumple devolvemos un true
		}
		// sino devolvemos un false
		response.sendRedirect(request.getContextPath().concat("/cerrado")); // si es false redirigimos a otra pagina
		return false; // para que no marque el error de interceptar otros recursos
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String mensaje = (String) request.getAttribute("mensaje"); // obtenemos el atributo mensaje mandado a la vista y lo casteamos a String
		
		// para que no salga error, revisar porque sale mal
		if(modelAndView != null && handler instanceof HandlerMethod) { // si modelAndView es diferente de null y es una instancia de la ruta del controlador
		    modelAndView.addObject("horario", mensaje); // agregamos el horario y lo pasamos a la vista
		}
	}

}
