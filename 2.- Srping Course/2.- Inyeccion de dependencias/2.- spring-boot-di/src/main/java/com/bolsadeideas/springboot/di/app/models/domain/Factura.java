package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/*CLASES POJO TMB PUEDEN SER MANEJADAS POR SPRING (TMB SE LE PUEDEN PONER ANOTACIONES)*/
//alcance de los componentes, mantiene una sola instancia del componente

@Component
@RequestScope //deja de ser singleton para ser de tipo request, ciclo de vida esta vinculaldo a la solicitud web actual, durara lo que dura una solicitud http, esto afecta alas anotacion de ciclo de vida como PostConstuct y PreDestroy 
public class Factura implements Serializable{// para que se pueda guardar y trasportar en los medios de almacenamientos en la solicitud http  y volver a resturase el objeto java (clon)
// pide generar un identificador
	private static final long serialVersionUID = 946004357128146951L;

	
	/*DESDE ESTA CLASE FACTURA ACCEDEMOS A LOS METODOS SETTERS Y GETTERS DE CLIENTE 
	 *DE ESA MANERA NO TENEMOS QUE CREAR LAS INSTANCIAS DE ESAS CLASES, LAS CLASES POJO TMB
	 *SE PUEDEN CONVERTIR EN COMPONENTES DE SPRING PARA SER USADOS POR SU CONTENEDOR
	 *sSE INYECTA List<ItemFactura> lo que nos devolvera la lista primaria ubicada en AppConfig */
	
	
	@Value("${factura.descripcion}")//se define en el properties
	private String descripcion;
	
	@Autowired // para inyectar cliente tuvimos que haber hecho ese pojo en componente
	private Cliente cliente; 
	
	@Autowired // ListItem es un objeto que es devuelto por un metodo en  AppConfig inyectamor el metodo list de ItemFactura, previamente convertido a componente por la anotacion Bean
	private List<ItemFactura> items;
	
	
	//Ciclo de vida de componente
	@PostConstruct//annotacion de Java se integra en spring se ejecuta despues de crear el objeto y despues de creada la dependencia, hecho para desarrollar cualquier inicializacion
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Alejandro")); // le concatenamos otro String
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy// para cerrar recursos al bajar 
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
