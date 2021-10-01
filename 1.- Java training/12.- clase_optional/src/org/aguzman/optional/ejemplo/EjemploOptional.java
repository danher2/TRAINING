package org.aguzman.optional.ejemplo;

import java.util.Optional;

/*CLASE OPTIONAL-> para representar que un valor este presente o ausente y evita cualquier cualqueir lanzamiento de exception nullpointer exception
 * a diferencia de las lista con optional solo se puede guardar un objeto*/

public class EjemploOptional {
    public static void main(String[] args) {
        
        String nombre = "Andres";
        Optional<String> opt = Optional.of(nombre);  // si el valor es present de vuelve true y recibe un generico
        System.out.println("opt = " + opt); // optional[Andres] el valor esta presente en el optional
        
        System.out.println(opt.isPresent()); // return true if there is a value present
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get()); // si el valor es presente lo devuelve sino lanza una excepcion NoSuchElementException
        }

        System.out.println(opt.isEmpty()); // devuelve true si esta vacio

        opt.ifPresent( valor -> System.out.println("Hola " + valor));// el ejecutable es un consumer, osea tmb se puede codificar funcionalmente (con lambas)

        nombre = "DaniBoy";
        opt = Optional.ofNullable(nombre);// retorna un optional con el valor, si no hay valor devuelve un optional vacio
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        //ifPresenteOrElse recibe dos argumentos: Consumer y Runnable, el consumer es un void que trabaja conel valor dado
        // y el Runnable trabaja en segundo plano para verificar si el valor es vacio devuelva otra cosa por default
        opt.ifPresentOrElse(valor -> System.out.println("Hola " + valor),
                () -> System.out.println("No esta presente"));

        
        // si el valor es present, retorna con el get sino "no esta presente"
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get());
        } else {
            System.out.println("No está presente");
        }

        
        Optional<String> optEmpty = Optional.empty(); // regresa instacias optional vacias
        System.out.println("optEmpty = " + optEmpty);
        System.out.println(optEmpty.isPresent()); // false, porque optEmpty es un optional vacio
    }
}
