package org.aguzman.ejemplos.set;

import org.aguzman.ejemplos.modelo.Alumno;

import static java.util.Comparator.comparing;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {

    	
    	//creamos un set de tipo alumno
        //Set<Alumno> sa = new TreeSet<>((a, b) -> b.getNota().compareTo(a.getNota()));
       
    	//ordena descendentemente con respecto a las notas
    	Set<Alumno> sa = new TreeSet<>(comparing((Alumno a) -> a.getNombre() ).reversed());
        
        //agregamos alumnos, todos lo objetos que se agreguen tienen que ser objetos que implemente la interfaz comparable
        //por tanto la clase Alumno debe implementar la intefaz comparable
        sa.add(new Alumno("Pato", 5));
        sa.add(new Alumno("Cata", 6));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Jano", 7));
        sa.add(new Alumno("Andres", 3));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus", 8));
        
        //imprimimos el set
        System.out.println(sa);
    }
}
