package org.aguzman.recursividad.ejemplo;

import org.aguzman.recursividad.ejemplo.models.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {
    public static void main(String[] args) {
    	
    	//agregando componentes
        Componente pc = new Componente("Gabinete PC ATX");
        Componente poder = new Componente("Fuente Poder 700w");
        Componente placaMadre = new Componente("MainBoard Asus sockets AMD");
        Componente cpu = new Componente("Cpu AMD Ryzen 5 2800");
        Componente ventilador = new Componente("Ventilador CPU");
        Componente disipador = new Componente("Disipador");
        Componente tv =  new Componente("Nvidia RTX 3080 8GB");
        Componente gpu = new Componente("Nvidia GPU RTX");
        Componente gpuRam = new Componente("4GB Ram");
        Componente gpuRam2 = new Componente("4GB Ram");
        Componente gpuVentiladores = new Componente("Ventiladores");
        Componente ram = new Componente("Memoria Ram 32GB");
        Componente ssd = new Componente("Disco SSD 2T");

        // agregando componentes hijos a componentes padres
        cpu.addComponente(ventilador)
                .addComponente(disipador);
        tv.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);
        placaMadre.addComponente(cpu)
                .addComponente(tv)
                .addComponente(ram)
                .addComponente(ssd);
        pc.addComponente(poder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));

        
        // metodo recursivo devuelve un stream de tipo Componente , imprimimos el stream con un foreach
        metodoRecursivoJava8(pc, 0).forEach(c -> System.out.println("\t".repeat(c.getNivel()) + c.getNombre()));

    }

    //metodo recursivo en Java 8 devuelve Stream de tipo Componente
    public static Stream<Componente> metodoRecursivoJava8(Componente c, int nivel){ //c = componente padre
        c.setNivel(nivel); // c de tipo componente, fijamos el nivel dado en el argumento
        return Stream.concat(Stream.of(c), // convertimos de componente a Stream
                c.getHijos().stream().flatMap(hijo -> metodoRecursivoJava8(hijo, nivel + 1))); //por cada hijo invocamos en metodo recursivo

    }

//    metodo recursivo
    public static void metodoRecursivo(Componente c, int nivel){
        System.out.println("\t".repeat(nivel) + c.getNombre()); // tabulador que repita segun la cantidad de niveles, si nivel es uno un tabulador, si nivel es dos dos tabuladores
        if(c.tieneHijos()){ // si c tiene una lista de hijos, regresa un true si tienen hijos y si es true
            for(Componente hijo: c.getHijos()){//cada hijo (Componente hijo)
                metodoRecursivo(hijo, nivel + 1);// se vuelve a llamar sobre si mismo
            }
        }
    }
}
