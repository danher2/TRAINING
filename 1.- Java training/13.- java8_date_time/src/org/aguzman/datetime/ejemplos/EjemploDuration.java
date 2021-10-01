package org.aguzman.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDateTime;

//duracion entre tiempo y tiempos, calcular tiempo


public class EjemploDuration {
    public static void main(String[] args) {
        
        LocalDateTime fecha1 = LocalDateTime.now(); // fecha actual, fecha inicial
        // fecha1 = fecha1.withMonth(10);
        LocalDateTime fecha2 = LocalDateTime.now().plusHours(3).plusMinutes(20).plusDays(1); // fecha final
        Duration lapsus = Duration.between(fecha1, fecha2);//retunr tipo Duration devuelve diferencia entre fecha inicial y final
        System.out.println("hora inicial: " + fecha1);
        System.out.println("sumamos 1dia,20min y 3hrs: " + fecha2);
        System.out.println("imprimiendo mi objeto lapsus = " + lapsus);
        System.out.println(" diferencia de tiempo imprimimos en minutos: " + lapsus.toMinutes());
        System.out.println("sumando 5hrs la diferencia nueva en minutos seria: " + lapsus.plusHours(5).toMinutes());
    }
}
