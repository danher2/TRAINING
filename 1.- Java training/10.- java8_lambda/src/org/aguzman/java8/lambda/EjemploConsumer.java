package org.aguzman.java8.lambda;

import org.aguzman.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

    	
    	// permite pasar un solo argumento del tipo del generico y es void
        Consumer<Date> consumidor = fecha -> { // el argumento es del tipo del generico
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");// se hace simplemente lo que se quiera con el argumento dado
            System.out.println(f.format(fecha)); // le pasamos la fecha
        };
        
        //realiza la operation con el argumento dado, accept es el metodo abstracto de Consumer
        consumidor.accept(new Date());

        
        //BioConsumer represents an operation that accepts two input arguments and returns noresult
        // los argumentos son del tipo del generico que se les manda
        // la implementacion es lo que quieras con los dos argumentos que se le envia
        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> System.out.println(nombre + ", tiene " + edad + " años!");

        consumidorBi.accept("pepe", 20); // accept  metodo abstracto de BioConsumer

        
        
        //REFERENCIA DE METODOS
        Consumer<String> consumidor2 = System.out::println; // mensaje -> System.out.println(mensaje)
        consumidor2.accept("Hola mundo lambda");

      //FOREACH  recibe un consumer (la implementacion de un consumer con una expresion lambda)
        List<String> nombres = Arrays.asList("andres", "pepe", "luz", "paco");
        nombres.forEach(nombre -> System.out.print(nombre + ", "));

        
        //SUPPLIER no recibe ningun argumento y solo devuelve un valor lo que retorna en su implementacion
        Supplier<Usuario> creaUsuario = ()-> new Usuario();  
        Usuario usuario = creaUsuario.get(); // retorna el usuario creado

        
        BiConsumer<Usuario, String> asignarNombre = (user, nombre) ->  usuario.setNombre(nombre);
        asignarNombre.accept(usuario, "Andres");
        System.out.println("");
        System.out.println("Nombre usuario: " + usuario.getNombre());

        
      //SUPPLIER no recibe ningun argumento y solo devuelve un valor lo que retorna en su implementacion
        Supplier<String> proveedor = () -> "Hola mundo lambda supplier";
        System.out.println(proveedor.get());
    }
}
