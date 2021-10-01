package org.aguzman.hilos.ejemplosync;

import org.aguzman.hilos.ejemplosync.runnable.Consumidor;
import org.aguzman.hilos.ejemplosync.runnable.Panadero;

//ejecucion del main
public class EjemploProductorConsumidor {
    public static void main(String[] args) {
       
    	// instancia de panaderia
    	Panaderia p = new Panaderia();
    	
    	// creamos los hilos paranedo y consumidor e iniciamos los hilos
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
