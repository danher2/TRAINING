package org.aguzman.java8.lambda;

import org.aguzman.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;


//PREDICATE, SIEMPRE DEVUELVE UN BOOLEAN
public class EjemploPredicate {
    public static void main(String[] args) {

    	
    	//Predicate recibe argumento de cualquier tipo
        Predicate<Integer> test = num -> num > 10;
        boolean r = test.test(11); //test evalua el predicate en el argumento dado
        System.out.println("r = " + r);

        Predicate<String> t2 = role -> role.equals("ROLE_ADMIN"); // metodo equals simepre retorna un boolean
        System.out.println(t2.test("ROLE_ADMIN"));

        //similar pero recibe dos argumentos e igual devuelve un boolean
        BiPredicate<String, String> t3 = String::equals;// (a, b) -> a.equals(b);
        System.out.println(t3.test("andres", "andres")); // se evalua el predicate
        
        
        BiPredicate<Integer, Integer> t4 = (i, j) -> j > i;
        boolean r2 = t4.test(5, 10); //se evalua el predicate
        System.out.println(r2); //true

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("maria");
        b.setNombre("cata");
        
        // lo mismo
        BiPredicate<Usuario, Usuario> t5 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println(t5.test(a, b));
    }
}
