package org.aguzman.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

    	//usamos la interfa set y creamos objeto de la clase HasSet generico <> yconstructor vacio
        Set<String> hs = new HashSet<>();
        
//        Agregamos elementos con el metodo del padre Collection add
        System.out.println(hs.add("uno"));
        System.out.println(hs.add("dos"));
        System.out.println(hs.add("tres"));
        System.out.println(hs.add("cuatro"));
        System.out.println(hs.add("cinco"));
        
        //imptimimos el set
        System.out.println(hs);

        boolean b = hs.add("tres"); //add devuelve un booleano
        System.out.println("permite elementos duplicados = " + b);
        System.out.println(hs);

    }
}
