package org.aguzman.optional.ejemplo.repositorio;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.models.Fabricante;
import org.aguzman.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*REPOSITORIO DE COMPUTADORAS*/

// implements Repositorio<T> al igual que las clases genericas
public class ComputadorRepositorio implements Repositorio<Computador> {
   
	//atributos
	private List<Computador> dataSource;

    
    // constructor
    public ComputadorRepositorio() {
        dataSource = new ArrayList<>(); // inicializo la lista
        Procesador proc = new Procesador("I9-9880H", new Fabricante("Intel"));
        Computador asus = new Computador("Asus ROG", "Strix G512");
        asus.setProcesador(proc); // setteo mi procesador en mi asus
        dataSource.add(asus); // agrego mi asus a mi lista de computadoras
        dataSource.add(new Computador("MacBook Pro", "MVVK2CI")); // aqui me agrego otra computadora
    }

    
    
    //metodo de la interfaz generica Repositorio
    // filtra la lista de computaodres
    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream() // despues de recibir el nombre, las lista que crea en el constructor la convierte en stream
                .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase())) // por cada elemento de la lista, le saco el nombre, lo hago minusculas y si contiene el mismo nombre que le envio por argumento
                .findFirst();//... me saca en optional  el primer resultado que coincida con el contains del stream, me saca todo el elemento, no solo el nombre
        
        // para recorrer la lista sin programacion funcional
        /*for(Computador c: dataSource){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c); // que me vuelva el objeto envuelto en un opcional
            }
        }
        return Optional.empty();*/ // sino que me devuelva un optinal vacio
    }

}
