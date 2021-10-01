package org.aguzman.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

    	
    	
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);//  para manejar varios thread en total 3
        																					// el 3 indica que se ejecutan las 3 al mismo tiempo
        																					// ponemos 1 si queremos que se ejecuten en forma secuencial
        // tamano del pool 0 ( antes de los hilos)
        System.out.println("Tamano del pool: " + executor.getPoolSize()); //tamano del pool
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size()); // tamano de tareas en cola
       
        // 3 threads
        
        //tarea 1
        Callable<String> tarea = () -> {
        	
            System.out.println("Inicio de la tarea...");
            //retardo de 3 segs
            try {
                System.out.println("Nombre del thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            
            System.out.println("Finaliza la tarea ...");
            return "Algunn resultado importante de la tarea";
        };

        
//      tarea2
        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3 ...");
            //retardo de 3 seg
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        
        //excecutors de las tareas
        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        
        //tamano del pool 3 (despues de los hilos)
        System.out.println("Tamano del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size()); // devuelve el numero de tareas ejecutadas por el executor actual

        executor.shutdown(); // apaga los hilos en el orden en que fueron executados
        System.out.println("Continuando con la ejecucion del metodo main");

        
        //System.out.println(resultado.isDone());
        while( !(resultado.isDone() && resultado2.isDone() && resultado3.isDone()) ){ // mientras ninguno de los 3 hilos haya terminado
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultado.isDone()? "finaliza": "en proceso",
                    resultado2.isDone()? "finaliza": "en proceso",
                    resultado3.isDone()? "finaliza": "en proceso"));
            // que espere 1 seg entre cada impresion de informacion de los 3
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        
        // impresiones su las tareas han finalizado
        System.out.println("Obtenemos resultado1 de la tarea: " + resultado.get());
        System.out.println("Finaliza la tarea1: " + resultado.isDone());

        System.out.println("Obtenemos resultado2 de la tarea: " + resultado2.get());
        System.out.println("Finaliza la tarea2: " + resultado2.isDone());

        System.out.println("Obtenemos resultado3 de la tarea: " + resultado3.get());
        System.out.println("Finaliza la tarea3: " + resultado3.isDone());



    }
}
