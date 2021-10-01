package org.aguzman.optional.ejemplo;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.aguzman.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {

    	
    	// objeto  ComputadorRepositorio en una instancia padre de la interfaz Repositorio<Computador> por que la implementa
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        // Computador defecto = new Computador("HP Omen", "LA0001");

        //filtrar recibe un argumento y si esta en la lista repositoio  devuelve un optional de tipo computador 
        // sino (orElse que devuelve del tipo del objeto) devuele otra computadora por defecto
        // en los dos casos devuelve un obj de tipo computador por lo que se guar da en pc que tmb es de tipo computador
        Computador pc = repositorio.filtrar("rog").orElse(valorDefecto());
        System.out.println(pc); // si filtrar encuentra el rog como quiera hace el orElse y lo imprime

        
        // a diferencia del orElseGet que retorna un lamba suppplier(que no recibe argumentos)
        pc = repositorio.filtrar("macbook pro").orElseGet(( )->  valorDefecto() );
       
        System.out.println(pc); // a diferencia del orElse , orElseGet es llamado  si filtrar sale true

    }

    //computador por defecto
    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto!!!");
        return new Computador("HP Omen", "LA0001"); // regresa un objeto computador por defecto
    }
}
