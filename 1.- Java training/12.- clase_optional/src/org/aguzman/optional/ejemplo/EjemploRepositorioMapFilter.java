package org.aguzman.optional.ejemplo;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.models.Fabricante;
import org.aguzman.optional.ejemplo.models.Procesador;
import org.aguzman.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.aguzman.optional.ejemplo.repositorio.Repositorio;

/*CUANDO EL STREAM ES UN OPTIONAL Y QUIERAS RECORRERO Y DE CADA ELEMENTO OPTIONAL CONVERTIR A OBJETO USAS FALTMAP
 * SI SOLO QUIERE RECORRER EL STREAM  Y DEVOLVER EL OBJETO EN EL USAS MAP
 * FLATMAP = DEVUELVE UN STREAM DEL OBJETO Básicamente fusiona todos los objetos en uno solo
 * MAP = DEVUELVE EL OBJETO  */
//PARA CONVERTIR DE OPTIONAL A UN TIPO CEPU O PROCESARO O FABRICANTE
// CONVERTIR DE OPTIONAL A UN TIPO DE OBJETO


public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        
        
        String f = repositorio.filtrar("asus")// filtrar de optional de tipo compuador
                .flatMap(c -> c.getProcesador())// si tengo un optional tipo computador, entonces le extraigo su procesador y pero con flatMap lo convierto optional<Procesador> a un objeto de tipo procesador
                .flatMap(p -> p.getFabricante() ) // lo mismo sucede al extrer el fabricante del procesador, en este punto ya tengo un objeto de tipo fabricante
                .filter(fab -> "intel".equalsIgnoreCase(fab.getNombre())) //sacar solo el fabricante intel (en el caso de que tenga mas) equalsIgnorecase =  son inguales sin tomar en cuenta mayusculas y minusculas
                .map(fabricante -> fabricante.getNombre())
                .orElse("Desconocido"); 

        System.out.println(f);


    }

}
