package org.aguzman.optional.ejemplo;

import org.aguzman.optional.ejemplo.models.Computador;
import org.aguzman.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.aguzman.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

//OrElseThrow, si el objeto no existe no podemos continuar con la ejecucion y tenemos que validar de cierta forma

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        // si no encuentra lo filtrado devuelve una excepcion con el orelseThrow y no permite seguir con la ejecucion del programa
        Computador pc = repositorio.filtrar("rog").orElseThrow(() -> new IllegalStateException());
        System.out.println(pc);

        
        
        //obtener la extension de un archivo con un optional
        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)//String envuelto por unoptional, ofNullable= si archivo es vacio devuelve un optional vacio
                .filter(a -> a.contains(".")) //si el Optional<String> tiene un punto? 
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1)) //substring= Returns a string that is a substring of this string. Thesubstring begins with the character at the specified index andextends to the end of this string.
                													//lastindexof retonrna el index dentro del string de la ultima ocurrencia del string especificado en su argumento
                .orElseThrow(); // si no lo encuentra lanzame una exception
        System.out.println(extension); // imprime la extension


    }
}
