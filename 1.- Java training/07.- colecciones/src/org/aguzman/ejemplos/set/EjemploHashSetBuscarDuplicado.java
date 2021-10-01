package org.aguzman.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado {
    public static void main(String[] args) {

        String[] peces = {"Corvina", "Lenguado", "Pejerrey", "Robalo", "Atun", "Lenguado"};

        //registrar estos elementos en un set y demostrar cual esta duplicado
        //Porque un hashset? porque el hasset no permite duplicados
        Set<String> unicos = new HashSet<>();
        
        for(String pez: peces){
            if(!unicos.add(pez)){//si al agregar un pez, esta repetido, el metodo add devuelve un false
                System.out.println("Elemento Duplicado: " + pez);//elemento duplicado
            }
        }
        System.out.println(unicos.size() + " elementos no duplicados: " + unicos);
    }
}
