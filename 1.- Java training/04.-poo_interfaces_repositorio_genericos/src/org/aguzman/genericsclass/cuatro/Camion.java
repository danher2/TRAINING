package org.aguzman.genericsclass.cuatro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//T tipo object generico
public class Camion<T> implements Iterable<T> {

    private List<T> objetos;
    private int max;

    //constructor
    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void add(T objeto){
        if(this.objetos.size() <= max) {
            this.objetos.add(objeto);
        } else {
        	//lanzamos excepcion
            throw new RuntimeException("no hay mas espacio.");
        }
    }

    @Override
    public Iterator<T> iterator() {
    	
        return this.objetos.iterator();
    }
}
