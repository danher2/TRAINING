package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

//Esta clase es para los metodos que tienen que ser componentes Bean porque se inyectaran

@Configuration //Indicates that a class declares one or more @Bean methods
public class AppConfig {
	
	@Bean("miServicioSimple") // Bean para convertir el metodo o registrar el componenete
	@Primary
	public IServicio registrarMiServicio() {
		return new MiServicio();// retorna la clase que implementa la interfaz
 	}
	
	@Bean("miServicioComplejo")//anotacion Bean indica que lo que retorna este metodo sera un objeto convertido a componente y manegjado por Srping Container
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	@Bean("itemsFactura") // devuelve una lista que sera convertida a componente para que sea manejado por el contenedor y se pueda INYECTAR
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("Camara Sony", 100);
		Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);
		
		return Arrays.asList(linea1, linea2); // retornamos componente de tipo list
	}

	@Bean("itemsFacturaOficina")// metodo  devuelve lista y es convertida a bean para que despues pueda ser inyectada con Autowire
	@Primary // porque hay dos metodos que duelvenven ListItemFactura y que son Bean entonces le decimos cual buscar primero
	public List<ItemFactura> registrarItemsOficina(){
		Producto producto1 = new Producto("Monitor LG LCD 24", 250);
		Producto producto2 = new Producto("Notebook Asus", 500);
		Producto producto3 = new Producto("Impresora HP Multifuncional", 80);
		Producto producto4 = new Producto("Escritorio Oficina", 300);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 1);
		ItemFactura linea3 = new ItemFactura(producto3, 1);
		ItemFactura linea4 = new ItemFactura(producto4, 1);
		
		return Arrays.asList(linea1, linea2, linea3, linea4);
	}
	
}
