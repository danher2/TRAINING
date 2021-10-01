package org.aguzman.datetime.ejemplos;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;


//TRABAJANDO CON INSTANTES

public class EjemploDuration2 {
    public static void main(String[] args) {
        
    	//primer momento
        Instant i1 = Instant.now(); // DEVUELVE EL INSTANTE ACTUAL
        System.out.println(i1);
        
        //delay 3 seg
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //segundo momento
        Instant i2 = Instant.now();
        
        
        //(diferencia de momentos
        Duration tiempo = Duration.between(i1, i2);
        System.out.println("tiempo = " + tiempo);

    }
}
