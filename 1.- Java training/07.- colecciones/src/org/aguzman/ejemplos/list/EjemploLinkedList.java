package org.aguzman.ejemplos.list;

import org.aguzman.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//LISTA DOBLEMENTE ENLAZADA

public class EjemploLinkedList {
    public static void main(String[] args) {

        LinkedList<Alumno> enlazada = new LinkedList<>();
       
        System.out.println(enlazada + ", size = " + enlazada.size());
        System.out.println("esta vacia = " + enlazada.isEmpty());
        enlazada.add(new Alumno("Pato", 5));
        enlazada.add(new Alumno("Cata", 6));
        enlazada.add(new Alumno("Luci", 4));
        enlazada.add(new Alumno("Jano", 7));
        enlazada.add(new Alumno("Andres", 3));

        System.out.println(enlazada + ", size = " + enlazada.size());

        //metodos propios de LinkedList
        System.out.println("add First, addLast");
        enlazada.addFirst(new Alumno("Zeus", 5));
        enlazada.addLast(new Alumno("Atenea", 6));
        System.out.println(enlazada + ", size = " + enlazada.size());

        
        System.out.println("Primero = " + enlazada.getFirst());
        System.out.println("ultimo = " + enlazada.getLast());
        System.out.println("Indice 2 = " + enlazada.get(2)); // obtener por indice

        //Alumno zeus = enlazada.pop();
        //enlazada.pollLast();
        System.out.println("removeFist-Last");
        enlazada.removeFirst();
        enlazada.removeLast();
        System.out.println(enlazada + ", size = " + enlazada.size());

        enlazada.remove(new Alumno("Jano", 7));// remove por objecto
        System.out.println(enlazada + ", size = " + enlazada.size());

        
        //regresa el indice de un objeto
        System.out.println("IndexOf");
        Alumno a = new Alumno("Lucas", 5);
        enlazada.addLast(a);
        System.out.println("Indice de Lucas = " + enlazada.indexOf(a));

        System.out.println("eliminamos 1 objeto y regresa el nuevo indice de lucas");
        enlazada.remove(2);
        System.out.println(enlazada + ", size = " + enlazada.size());
        System.out.println("Indice de Lucas = " + enlazada.indexOf(a));

        //reemplazar posicion en la lista
        System.out.println("remplazamos la porsicion 3 por lalo");
        enlazada.set(3, new Alumno("Lalo", 7));
        System.out.println(enlazada + ", size = " + enlazada.size());

        //iteramos esta lista con list iterator
        ListIterator<Alumno> li = enlazada.listIterator();

        while(li.hasNext()){ //mientras tenga un siguiente
            Alumno alumno = li.next();//guarde el objeto
            System.out.println(alumno);// y lo imprima
        }
        System.out.println("=================== Previous");
        while(li.hasPrevious()){// mientras tenga un elemento previo
            Alumno alumno = li.previous(); // guarde el objeto
            System.out.println(alumno);// y lo imprima
        }
        
    }
}
