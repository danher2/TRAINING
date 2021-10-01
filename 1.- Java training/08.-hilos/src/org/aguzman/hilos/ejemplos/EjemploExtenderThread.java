package org.aguzman.hilos.ejemplos;

import org.aguzman.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
       
    	Thread hilo = new NombreThread("Jhon Doe");
        hilo.start(); //se levanta el hilo con el start
        
        
//        cada hilo corre en paralelo
        
        //Thread.sleep(2);
       Thread hilo2 = new NombreThread("Maria");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("Pepe");
        hilo3.start();
        System.out.println(hilo.getState()); //devuelve el  estado del hilo
    }
}
