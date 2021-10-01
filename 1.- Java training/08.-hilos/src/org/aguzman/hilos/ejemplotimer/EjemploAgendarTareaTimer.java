package org.aguzman.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {

        Timer timer = new Timer();// permite crear tareas y programarlas
        
        
        // programar tarea dentro de 5 segundos
        timer.schedule(new TimerTask(){ //programa una tarea especifica despues del retraso especificado
            @Override // se crea una clase anonima  donde se implementa el metodo run porque Timer task implementa la interfaz runnable
            public void run() {
                System.out.println("Tarea realizada en: " + new Date() + " nombre del Thread: "
                 + Thread.currentThread().getName()); //retorna el nombre del hilo actual
                System.out.println("Finaliza el tiempo");
                timer.cancel(); // termina este timer descartando cualquier tarea programada actual
            }
        }, 5000); // retraso especificado para cumplir la tarea

        
        
        // primero se ejecuta este print y despues de 5 segundos lo de arriba
        System.out.println("Agendamos una tarea para 5 segundos mas ...");
    }
}
