package org.aguzman.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;


public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // lo usaremos para hacer el beep
        AtomicInteger contadorAtomic = new AtomicInteger(3); // usamos el contador atomico
       
        Timer timer = new Timer(); 
        
        timer.schedule(new TimerTask(){ //implementacion al vuelo (clase anonima)
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement(); // decrementa por uno el valor actual, retorna el valor previo, se va repitiendo
                if(i > 0) { // nota que no es un for sino un if
                    toolkit.beep(); // emite un sonido
                    System.out.println("Tarea " +i+ " periodica en: "
                            + new Date() + " nombre del Thread: "
                            + Thread.currentThread().getName());
                } else { // sino
                    System.out.println("Finaliza el tiempo");
                    timer.cancel(); //finalizar este timer
                }
            }
        }, 0, 10000);// intervalo de tiempo, que pasa si una tarea lleva mas de 10 seg en ejecutarse? pues como pasaron los 10 seg se ejecuta la siguiente

        //esto se ejecutara primero
        System.out.println("Agendamos una tarea inmediata que se repite cada 10 seg ...");
    }
}
