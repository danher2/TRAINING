package org.aguzman.optional.ejemplo;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.aguzman.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

    	
    	// para acceder al metodo filtrar me creo un objeto del tipo ComputadorRepositorio y lo guardo en una instancia del tipo Repositorio<Computador>
    	//... que es la interfaz que implemente ComputadorRepositorio, asi que seria  como un objeto hijo en una instancia padre xD
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //filtrar devuelve un optional, si esta presente me devuelva el valor (el elemento) sino esta presente imprima que no se encontro
        repositorio.filtrar("rog").ifPresentOrElse(value -> System.out.println(value),
                () -> System.out.println("No se encontro"));

        //Optional<Computador> pc = repositorio.filtrar("asus rog");

        /*if(pc.isPresent()) {
            System.out.println(pc.get());
        } else {
            System.out.println("No se encontró");
        }*/
    }
}
