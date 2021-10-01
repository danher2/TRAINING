package org.aguzman.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();// este es el que ejecuta los runnables

        //TARGET
        //este este es como runnable, la diferencia esque este retorna un  un resultado, en este caso es un string
        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");
            
            
            try {
                System.out.println("Nombre del thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // si lanza la excepcion interrupe el hilo y lo libera del sleep
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea ...");
            return "Algunn resultado importante de la tarea"; // retorna el generico de tipo string
        };

        
        //EXECUTOR
        Future<String> resultado = executor.submit(tarea); //  se manda a ejecutar la tarea y el se devuelve un objeto de tipo FUture con un generico que es el string de la tarea
        executor.shutdown();
       
        System.out.println("Continuando con la ejecucion del metodo main");
        System.out.println(resultado.isDone());
       
        
        while(!resultado.isDone()){ // mientras no haya terminado
            System.out.println("ejecutando tarea ....");
            TimeUnit.MILLISECONDS.sleep(1500); //
        }
        
        
        System.out.println("Obtenemos resultado de la tarea: " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());



    }
}
