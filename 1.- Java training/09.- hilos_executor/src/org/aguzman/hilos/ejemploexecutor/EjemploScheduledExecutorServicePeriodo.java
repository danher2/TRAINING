package org.aguzman.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduledExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

    	//cantidad de tareas que se ejecutaran de forma periodica
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main ...");

        AtomicInteger contador = new AtomicInteger(5); //contador de 5 seg
        // CountDownLatch lock = new CountDownLatch(5);
       
        //Devuelve un Runnable
        Future<?> future = executor.scheduleAtFixedRate(() -> { // ejecuta cada repitidas veces
            System.out.println("Hola mundo tarea ...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                // lock.countDown();
               System.out.println( contador.getAndDecrement()); // segun el nmero que le mandamos a su constructor en este caso decrementa en 5 seg
           System.out.println(contador.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 1000, 2000,TimeUnit.MILLISECONDS);

        // lock.await();
        // future.cancel(true);
        // TimeUnit.SECONDS.sleep(10);
        
        //esto hace que itere el contador y se repita
        while(contador.get() >= 0){
            
        	if(contador.get() == 0){ // cuando llegue a cero
                future.cancel(true); // apaaga el executor
                contador.getAndDecrement(); // volvemos decrementar lo que dara valor de -1 y se sale del while porque la condicion del while es >= 0
                System.out.println(contador.get() + " aqui se sale del while y continua con otra tarea"); // debe dar -1
        	}
        }
        
        System.out.println("Alguna otra tarea en el main ...."); // continua segun con otra tarea y asi sucesivamente
        executor.shutdown();
    }
}
