package org.aguzman.hilos.ejemplosync.runnable;

import org.aguzman.hilos.ejemplosync.Panaderia;

//implementa de Runnable y  recibe instancia del recurso compartido
public class Consumidor implements Runnable{
    
	//recurso compartido
	private Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10; i++){
            panaderia.consumir();
        }
    }
}
