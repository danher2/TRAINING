package org.aguzman.ejemplos.set;

import org.aguzman.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {

        Set<Alumno> sa = new HashSet<>();
        // List<Alumno> sa = new LinkedList<>();
        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Andres", 3));
        sa.add(new Alumno("Zeus2", 2));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Lucas", 2));
        sa.add(new Alumno("Lucas", 3));
        System.out.println(sa);

        /*System.out.println("Utilizando un for clasico"); // solo para List
        for(int i = 0 ; i<sa.size(); i++){
            Alumno a = sa.get(i);
            System.out.println(a.getNombre());
        }*/
        
        //COMO ITERAR UN SET
        
        System.out.println("Iterando un set usando un foreach");
        for(Alumno a: sa){
            System.out.println(a.getNombre());
        }

        System.out.println("Iterando un set usando while y iterator");
        Iterator<Alumno> it = sa.iterator();
        while(it.hasNext()){ // mientras tenga un siguiente elemento
            Alumno a = it.next();// retorna un Alumno porque estamos usando genericos
            System.out.println(a.getNombre());// imprimimos el nombre
        }

        
        System.out.println("Iterando un set usando Stream forEach (lambda)");
        sa.forEach(a -> System.out.println(a.getNombre()));
        
//        optimizando
        System.out.println("Iterando un set usando Stream forEach");
        sa.forEach(System.out::println);
    }
}
