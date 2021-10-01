package org.aguzman.datetime.ejemplos;

import java.time.LocalDate;
import java.time.Period;


// trabajando con periodos de tiempo

public class EjemploPeriod {
    public static void main(String[] args) {
    	
    	//creando fechas para despues calcular periodos
        LocalDate fecha1 = LocalDate.of(2011, 9, 23);
        LocalDate fecha2 = LocalDate.of(2020, 11, 25);
        //con with similar a set, cambiamos las fechas, modifican? si pero devolviendo una nueva instancia (fecha 3) no el mismo objeto (fecha 2) porque es inmutable
        LocalDate fecha3 = fecha2.withMonth(12); // cambia de nomviembre(fecha2) a diciembre(mes 12)
        fecha3 = fecha3.withDayOfMonth(28); // cambia de dia(25 de fecha 2) a dia 28

        System.out.println("fecha 1: " + fecha1);
        System.out.println("fecha 2: " + fecha2);
        System.out.println("fecha 3: " + fecha3);
        
        
        //Devuelve Period  and Obtains a Period consisting of the number of years, months,and days between two dates
        Period periodo = Period.between(fecha1, fecha3);

        System.out.println("imprimiendo objeto periodo: " + periodo); // diferencia entre las dos fechas
        
        //printf = imprimir con formato
        System.out.printf("Periodo entre %s y %s hay %d anios, %d meses y %d dias", 
                fecha1, fecha3, periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}
