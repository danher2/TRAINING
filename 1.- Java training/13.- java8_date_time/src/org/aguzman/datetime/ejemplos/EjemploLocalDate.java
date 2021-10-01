package org.aguzman.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {

    	// lo mas simpre creamos una fecha, no se utiliza new, es clase static, obtiene la fecha actual
        LocalDate fechaActual = LocalDate.now(); 
        System.out.println("fechaActual = " + fechaActual);
        
        // regresa the primitive int value for the day-of-month        
        System.out.println("Dia: " + fechaActual.getDayOfMonth());
        
        
        Month mes = fechaActual.getMonth();
        System.out.println("Mes: " + mes);
        System.out.println("Numero del mes: " + mes.getValue());
        System.out.println("Mes espanol: " + mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"))); //getDisplayName  , recibe el estilo de texto  (full) y el lenguaje local da la representacion textual del mes, new Locale, recibe el lenguaje y el pais - Construct a locale from language and country

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Numero del dia: " + diaSemana.getValue());
        System.out.println("Nombre del dia: " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        System.out.println("Anio: " + fechaActual.getYear());
        System.out.println("Dia del ano: " + fechaActual.getDayOfYear());
        System.out.println("Era: " + fechaActual.getEra());
        
        
        
        //Obtains an instance of LocalDate from a year, month and day. 
        fechaActual = LocalDate.of(2020, 12, 25); // retorna un localdate
        System.out.println("fechaActual = " + fechaActual);
        
        fechaActual = LocalDate.of(2020, Month.NOVEMBER, 11); // retorna un local date, LocalDate java.time.LocalDate.of(int year, Month month, int dayOfMonth)
        System.out.println("fechaActual = " + fechaActual);
        
        fechaActual = LocalDate.parse("2020-02-01"); // retorna una instancia de local date desde un string
        System.out.println("fechaActual = " + fechaActual);
        
        LocalDate diaDeManiana = LocalDate.now().plusDays(1);// regresa el tiempo actual mas un 1 agregado
        System.out.println("diaDeManiana = " + diaDeManiana);
        
        LocalDate mesAnterioMismoDia = LocalDate.now().minus(1, ChronoUnit.MONTHS); // menos un mes anterior
        System.out.println("mesAnterioMismoDia = " + mesAnterioMismoDia);

        DayOfWeek miercoles = LocalDate.parse("2020-11-11").getDayOfWeek();// regresa el dia de la semana dada en el parse method
        System.out.println("miercoles = " + miercoles);

        int once = LocalDate.of(2020, 11, 11).getDayOfMonth(); // regresa el numero de dia de esa fecha dada en entero
        System.out.println("once: " + once);
        
        boolean esBisiesto = LocalDate.now().isLeapYear(); // booelan true or false, checks if the year is a leap year, according to the ISO prolepticcalendar system rules.

        System.out.println("esBisiesto = " + esBisiesto);
        
        boolean esAntes = LocalDate.of(2020, 11, 11).isBefore(LocalDate.parse("2020-11-10")); //Checks if this date is before the specified date. 
        System.out.println("esAntes = " + esAntes);
        
        boolean esDespues = LocalDate.parse("2020-11-11").isAfter(LocalDate.parse("2020-11-10")); //Checks if this date is after the specified date. 
        System.out.println("esDespues = " + esDespues);
        
        esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(1));
        System.out.println("esDespues = " + esDespues);
    }
}
