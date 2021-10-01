package org.aguzman.hilos.ejemplos;

import org.aguzman.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        
    	//creamos objetos hilos con la clase que implementa runneable solo con el argumento Runneable target
    	new Thread(new ImprimirFrases("Hola ", "que tal!")).start();
        new Thread(new ImprimirFrases("Quien eres", " tu")).start();
        
        Thread.sleep(100);
        
        Thread h3 = new Thread(new ImprimirFrases("Muchas ", "gracias amigo!"));
        h3.start();
        
        Thread.sleep(100);
        
        System.out.println(h3.getState());// imprimir el estado de este hilo
        // devuelve estado de Block porque esta intentando entrar al metodo pero
        // como es un metodo synchronized esta ciendo ocupado en ese momentopor h1 por eso no puede 
        // acceder y permanece el metodo blockeado hastaa que deje de ocuparlo el h1

    }

    //metodo statico al que los hilos tendra acceso
    // metodo sicronizado para que los hilos no se mezclen
    public synchronized static void imprimirFrases(String frase1, String frase2){
       
    	System.out.print(frase1);

    	//que espere 500 para acceder a la sig frase
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(frase2);
    }
}
