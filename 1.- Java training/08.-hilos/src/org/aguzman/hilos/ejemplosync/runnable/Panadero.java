package org.aguzman.hilos.ejemplosync.runnable;

import org.aguzman.hilos.ejemplosync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

//el panadero implementa la interfaz runnable
public class Panadero implements Runnable{
   
	// instancia del recurso compartido,el objeto monitor con los metodos sincronizados
	private Panaderia panaderia;

//	constructor
    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    
    //el panadero va a hornear hasta 10 veces
    // desde el metodo run accedo al metodo sincronizado que esta en otra clase
    // los metodos sincronizados se hacen en una sola clase(recurso compartido)
    //y se llaman desde la clase que implementa Runnable
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            panaderia.hornear("Pan nº: " + i); // accediendo al metodo sinconizado ornear
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
