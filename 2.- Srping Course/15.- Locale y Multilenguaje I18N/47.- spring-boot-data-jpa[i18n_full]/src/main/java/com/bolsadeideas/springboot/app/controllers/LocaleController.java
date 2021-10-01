package com.bolsadeideas.springboot.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocaleController {

	@GetMapping("/locale")
	public String locale(HttpServletRequest request) {
		String ultimaUrl = request.getHeader("referer"); // pasamos el noombre del parametros que queremos obtener, referer nos entrega la referencia de nuestro ultimo url
		
		return "redirect:".concat(ultimaUrl);
	}
}
