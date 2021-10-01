package org.aguzman.ejemplos.list;

import org.aguzman.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.comparing;

//METODOS PRINCIPALES DE ARRAYLIST	
public class EjemploArrayList {
    public static void main(String[] args) {

        List<Alumno> al = new ArrayList<>();
        
        System.out.println(al + ", size = " + al.size()); //tamano de la lista
        System.out.println("esta vacia = " + al.isEmpty()); //esta vacia? devuelve true si esta vacia
        al.add(new Alumno("Pato", 5));
        al.add(new Alumno("Cata", 6));
        al.add(new Alumno("Luci", 4));
        al.add(2, new Alumno("Jano", 7)); // insertamos en la posiscion 2
        al.set(3, new Alumno("Andres", 3)); //replazaria lucy por andres

        System.out.println(al + ", size = " + al.size());

        al.remove(new Alumno("Jano", 7));// remueve por objeto
        //al.remove(0); //remueve por posicion
        System.out.println(al + ", size = " + al.size());

        boolean b = al.contains(new Alumno("Cata", 6)); //devuelve  un booleano si esta el objeto
        System.out.println("La lista contiene a Cata = " + b);

        
        //convertir el ArrayList en un arreglo
        Object a[] = al.toArray();
        for(int i=0; i<a.length;i++){
            System.out.println("Desde el arreglo = " + a[i]);
        }


    }
}
