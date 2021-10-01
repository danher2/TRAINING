package org.aguzman.datetime.ejemplos;


//Combinacion local date y time, tiempo completo

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaTiempo = LocalDateTime.now(); // fecha con tiempo completo
        System.out.println("fechaTiempo = " + fechaTiempo);

        // fecha completa con tiempo , y, m, d,h,m,seg,
        fechaTiempo = LocalDateTime.of(2020, Month.DECEMBER, 24, 20, 45, 59);
        System.out.println("fechaTiempo = " + fechaTiempo);
        
        // string con el formato estandar de fecha y tiempo
        fechaTiempo = LocalDateTime.parse("2020-12-25T21:45:59.821339800");
        System.out.println("fechaTiempo = " + fechaTiempo);

        
        //se le pueden sumar tiempo y horas
        LocalDateTime fechaTiempo2 = fechaTiempo.plusDays(1).plusHours(3);
        System.out.println("fechaTiempo2 = " + fechaTiempo2);
        System.out.println("fechaTiempo = " + fechaTiempo);
        System.out.println("fechaTiempo3 = " + fechaTiempo.minusHours(5));
        
        Month mes = fechaTiempo.getMonth();
        System.out.println("mes = " + mes);
        
        int dia = fechaTiempo.getDayOfMonth();
        System.out.println("dia: " + dia);

        int anio = fechaTiempo.getYear();
        System.out.println("anio = " + anio);
        
        // convertimos a string la fecha qeu obtenemos
        String formato1 = fechaTiempo.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("formato1 = " + formato1);
        
        // con patron
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
        String formato2 = fechaTiempo.format(df); // df representa el patron
        System.out.println("formato2 = " + formato2); // imprimimos
        
        String formato3 = df.format(fechaTiempo); // le pasamos el nieto de TemporalAcces
        System.out.println("formato3 = " + formato3);


    }
}
