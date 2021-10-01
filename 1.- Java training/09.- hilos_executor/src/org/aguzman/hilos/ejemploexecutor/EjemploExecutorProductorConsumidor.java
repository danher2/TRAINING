package org.aguzman.hilos.ejemploexecutor;

import org.aguzman.hilos.ejemplosync.Panaderia;
import org.aguzman.hilos.ejemplosync.runnable.Consumidor;
import org.aguzman.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

//Productor consumidor con Executors Framework
public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

    	//cantidad de hilos  que pueden executarse al mismo tiempo
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamano del pool: " + executor.getPoolSize()); // debe ser 2
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size()); // debe ser 0

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

       //se ejecutan al mismo tiempo debe tener un pool minimo de 2
        Future<?> futuro1 = executor.submit(consumidor); //<?> no regresa nada porque es runnable
        Future<?> futuro2 = executor.submit(productor);

        System.out.println("Tamanoo del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecución del metodo main");
    }
}
