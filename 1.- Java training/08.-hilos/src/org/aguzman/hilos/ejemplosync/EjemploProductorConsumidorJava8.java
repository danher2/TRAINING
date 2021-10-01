package org.aguzman.hilos.ejemplosync;


//EJEMPLO TODO HECHO DESDE EL MAIN, SIN HACER LAS CLASES PANADERO Y CONSUMIDOR
import org.aguzman.hilos.ejemplosync.runnable.Consumidor;
import org.aguzman.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        // sustituyendo la clase panadero sele da la funcion aqui con un lambda
        new Thread( () -> { // asignamos la implementacion que se haria creando una clase e implementanto la clsasse runnable
            for(int i = 0; i < 10; i++){
                p.hornear("Pan nº: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        
        //sustituyendo la clase consumidor se le da funcion aqui con lamnda
        new Thread( () -> {
            for(int i = 0 ; i < 10; i++){
                p.consumir();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
