package org.aguzman.hilos.ejemplosync;

//esta clase representa un recurso compartido = panaderia
public class Panaderia {
    
	private String pan;
    private boolean disponible;

    //para el productor
    public synchronized void hornear(String masa){
       
    	while(disponible){ // si disponible esta en true, validacion bandera
            try {
                wait(); // esperar a que disponible vuelva a ser falso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.pan = masa;
        System.out.println("Panadero hornea: " + this.pan);
        this.disponible = true; // el pan ya esta disponible
        notify(); // despierta un hilo que esta esperando  en este objeto de monitor
    }

    
    //para el cliente
    public synchronized String consumir(){
        while(!disponible){
            try {
                wait();// hace que el hilo actual espere hasta que otro hilo invoque el notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cliente consume: " + this.pan);
        this.disponible = false;
        notify();
        return pan;
    }
}
