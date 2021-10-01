package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//mediante un pool de threads hace que se ejecuten los flujos de los streams, reduce el tiempo para procesar pero se afecta el rendimiento
// porque todo se procesa separado

public class EjemploStreamParallel {
    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andres", "Guzman"));
        lista.add(new Usuario("Luci", "Martinez"));
        lista.add(new Usuario("Pepe", "Fernandez"));
        lista.add(new Usuario("Cata", "Perez"));
        lista.add(new Usuario("Lalo", "Mena"));
        lista.add(new Usuario("Exequiel", "Doe"));
        lista.add(new Usuario("Bruce", "Lee"));
        lista.add(new Usuario("Bruce", "Willis"));

//        tiempo de inicio y de fin en la ejecucion del stream
        
//      tiempo de inicio
        long t1 = System.currentTimeMillis();// regresa el tiempo actual en milisegundos
        
        
        
        String resultado = lista.stream() // convertimos la lista a stream para poder trabajarla
                .parallel() // retorna un stream equivalenete que es paralelo, se ejecutan todos los elementos de la lista en paralelo
                .map(u -> u.toString().toUpperCase()) // de usuari a Tostring(que concatena nombre con apellido) convierte a mayus
                .peek(n -> { // recorre la lista para reatrear exactamente lo que hace, y muestra o realiza la action provista para cada elemento del stream
                    System.out.println("Nombre Thread: " + Thread.currentThread().getName()
                    + " - " + n);
                }).map(n -> n.toString()).collect(Collectors.joining(",")); //(regresar al ejercicio original quitando esta line y los /**/ del flatmap de abajo)
                
                /*.flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(nombre.contains("bruce".toUpperCase())){ // si encuentra a bruce en mayusculas 
                        return Stream.of(nombre); // haga un stream de bruce
                    }
                    return Stream.empty();// sino devuelva stream vacio
                })
                .findAny().orElse("");// devuelva lo que sea o vacio por defecto
*/
        
        //tiempo final
        long t2 = System.currentTimeMillis();
        
//        total del tiempo de ejecucion
        System.out.println("Tiempo total: " + (t2 - t1));
        System.out.println(resultado); // el primer bruce encontrado
    }
}
