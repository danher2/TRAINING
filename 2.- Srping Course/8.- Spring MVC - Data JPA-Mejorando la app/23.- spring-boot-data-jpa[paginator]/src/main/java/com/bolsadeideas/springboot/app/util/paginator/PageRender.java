package com.bolsadeideas.springboot.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

//clase para calcular parametro desde donde hasta donde tiene que partir y de esa forma ir recorriendo nuestros registros
//mostrar de 10 a 10 o de 5 en 5 las paginas en e paginador
public class PageRender<T> {

	//atributos
	private String url;
	
	//listado paginable de los clientes, lista de clientes
	private Page<T> page;

	//para hacer el calculo
	private int totalPaginas;

	// numero de elementos por pagina
	private int numElementosPorPagina;

	private int paginaActual;

	private List<PageItem> paginas;

	// constructor
	public PageRender(String url, Page<T> page) {
		
		//pasamos url, lista de clientes (page) e iniciamos lista con elemento de PAgeItem
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();

		//elementos mostrados por pagina
		numElementosPorPagina = 6;
		//total de paginas
		totalPaginas = page.getTotalPages();
		
		// numero de pagina, le sumamos uno porque empieza desde cero
		paginaActual = page.getNumber() + 1;

		// mostrar desde hasta
		int desde, hasta; // desde y hasta los dos son numeros enteros
		
		// si el total de paginas es menor o igual que el numero de elemenpos por pagina
		if (totalPaginas <= numElementosPorPagina) {
			desde = 1;
			hasta = totalPaginas;
		} else {
			if (paginaActual <= numElementosPorPagina / 2) {
				desde = 1;
				hasta = numElementosPorPagina;
			} else if (paginaActual >= totalPaginas - numElementosPorPagina / 2) {
				desde = totalPaginas - numElementosPorPagina + 1;
				hasta = numElementosPorPagina;
			} else {
				desde = paginaActual - numElementosPorPagina / 2;
				hasta = numElementosPorPagina;
			}
		}

		// recorremos la lista de paginas desde hasta
		for (int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde + i));
		}

	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public boolean isHasNext() {
		return page.hasNext();
	}

	public boolean isHasPrevious() {
		return page.hasPrevious();
	}

}
