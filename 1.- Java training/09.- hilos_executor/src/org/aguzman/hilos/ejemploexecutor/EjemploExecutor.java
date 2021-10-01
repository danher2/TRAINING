package org.aguzman.hilos.ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor(); // crea un ejecutor que ejecuta una tarea a lavez

        
        // se implementa la interfaz runnable con un lamba
        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5); // forma mas simpre de sleep
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //interrupe la ejecucion del hilo actual y de esa forma se libera. se despierta el sleep
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea ...");
        };
        
        //se regista la tarea en el ejecutor , y se le pasa la Runnable task
        executor.submit(tarea); // enviamos la tarea  a ejecucion
        executor.shutdown(); // apaga el ejecutor una ves que las tareas actuales y las tareas en cola se terminen de ejecutar
//       
        System.out.println("Continuando con la ejecucion del metodo main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS); // se va a ejecutar primero que e runnable porque le dimos 2 seg
        System.out.println("Continuando con la ejecución del método main 2");
    }
}
