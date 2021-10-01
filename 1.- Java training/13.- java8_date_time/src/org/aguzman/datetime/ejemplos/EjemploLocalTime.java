package org.aguzman.datetime.ejemplos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;



//EJEMPLO CON HORAS

public class EjemploLocalTime {
    public static void main(String[] args) {

    	
    	// misma mecanica se crea una hora (la hora actual)
        LocalTime ahora = LocalTime.now();
        System.out.println(ahora);
        // se obtiene hora por horas, minutos y segundos
        System.out.println("Hora: " + ahora.getHour());
        System.out.println("Minutos: " + ahora.getMinute());
        System.out.println("Seg.: " + ahora.getSecond());
        
        
        // crear una hora personalizada
        LocalTime seisConTreinta = LocalTime.of(6, 30, 59);
        System.out.println(seisConTreinta); // se imprime
        seisConTreinta = LocalTime.parse("18:30:45");// Obtains an instance of LocalTime from a text string  

        System.out.println("seisConTreinta = " + seisConTreinta);
        LocalTime sieteConTreinta = LocalTime.of(6, 30).plus(1, ChronoUnit.HOURS); // sumar hora con plus Returns a copy of this time with the specified amount added
        System.out.println("sieteConTreinta = " + sieteConTreinta);
        boolean esAnterior = LocalTime.of(6, 30, 59).isBefore(LocalTime.parse("07:30"));// boolean para compara de una hora parseada
        System.out.println("esAnterior = " + esAnterior); // devuelve true

        
        // formateador para imprimir y parsear objetos de tiempo y hora
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a"); //crea un formato usando un especificado patron , la "a" para agregar am o pm segun corresponda
        String ahoraFormateado = seisConTreinta.format(df); //Formats this time using the specified formatter,  el quele pasamos al argumento, This time will be passed to the formatter to produce a string.
        System.out.println( "ahora Formateado: " + ahoraFormateado);
        
        ahoraFormateado = df.format(ahora); // pasamos la fecha por argumento, localTime es nieta de TemporalAcceso, el tipo de dato que va en el argumento
        System.out.println("ahoraFormateado = " + ahoraFormateado);
        
        LocalTime max = LocalTime.MAX; // la maxima hora del dia
        LocalTime min = LocalTime.MIN;// la minima hora del dia

        System.out.println("max = " + max);
        System.out.println("min = " + min);

    }
}
