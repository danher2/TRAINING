package com.bolsadeideas.springboot.web.app;

/*CLASE CONFIGURACION
 * 
 * para configurar el nuevo archivo de properties*/

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({ // arreglo, se ubica en los recursos que es el classpath, si tenemos mas se separa por coma dentro del arreglo
	@PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {

}
