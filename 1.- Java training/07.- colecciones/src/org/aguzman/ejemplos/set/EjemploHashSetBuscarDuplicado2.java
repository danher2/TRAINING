package org.aguzman.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado2 {
    public static void main(String[] args) {

    	//tenemos lista de peces
        String[] peces = {"Corvina", "Atun", "Lenguado", "Pejerrey", "Robalo", "Atunn", "Lenguado"};

        //creamos  dos Sets unicos y duplicados
        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();
        
        
        for(String pez: peces){//arreglo peces se recorre con foreach
            if(!unicos.add(pez)){// si metoddo add es distinto de true osea devuelve false, el pez esta repetido
                duplicados.add(pez); //agregalo a duplicados
            }
        }
        unicos.removeAll(duplicados);//que quitan los duplicados, removeAll recibe de argumento otro objetoColection y borra los que coincidan con los que tiene en su lista 

        
        //imprimimos las los listas
        System.out.println("Unicos: " + unicos);
        System.out.println("Duplicados: " + duplicados);
    }
}
