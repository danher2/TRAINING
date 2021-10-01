package org.aguzman.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;


//Trabajar con Zonas horarias de diferentes zonas

public class EjemploZonedDateTime {
    public static void main(String[] args) {

    	// partir de una fecha local
        LocalDateTime fechaLocal = LocalDateTime.parse("2021/09/23 12:45" // devuelve un LocalDateTime y usa un formato string que parte de una hora especifica
                , DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")); // formato
        
        System.out.println("imprimiendo fecha local: " + fechaLocal);
        
        //Zona horaria de new York
         ZoneId newYork = ZoneId.of("America/New_York"); // ZoneId zona horaria de nueva york
         ZonedDateTime zonaNy = ZonedDateTime.of(fechaLocal, ZoneOffset.of("-04:00"));
         System.out.println("new york: " + newYork);
         System.out.println("imprimiendo zona de new York: " + zonaNy);
        
         
        ZonedDateTime zonaNy2 = fechaLocal.atZone(ZoneOffset.of("-04:00"));
        System.out.println("Horario de partida en New York: " + zonaNy2);

        //ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = zonaNy2.withZoneSameInstant(ZoneOffset.of("+02:00")).plusHours(8);
        System.out.println("Hora de llegada en Madrid: " + zonaMadrid);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
        System.out.println("Detalles del viaje a espania:");
        System.out.println("Partida NY: " + f.format(zonaNy2));
        System.out.println("llegada Madrid: " + f.format(zonaMadrid));

        
        //la api provee todas las zonas horarioas
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
