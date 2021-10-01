package org.aguzman.api.stream.ejemplos;

import org.aguzman.api.stream.ejemplos.models.Factura;
import org.aguzman.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

//FlatMap = por cada elemento se devuelve una salida distinta un stream diferente para cada item
public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

    	//creamos los usuarios
        Usuario u1 = new Usuario("John", "Doe");
        Usuario u2 = new Usuario("Pepe", "Pérez");

        //creamos una lista de2 facturas para cada usuario
        u1.addFactura(new Factura("compras tecnologias"));
        u1.addFactura(new Factura("compras muebles"));

        u2.addFactura(new Factura("bicicleta"));
        u2.addFactura(new Factura("notebook gamer"));

        //ahora creamos una lista de usuarios
        List<Usuario> usuarios = Arrays.asList(u1, u2); // meto a los usuarios en una list de usuarios
        usuarios.stream() // esa lista de usuarios aqui la convierto en un stream
                .flatMap(u -> u.getFacturas().stream())// el flatmap recorre cada usuario de la lista y como cada usuario tiene dos facturas anadidas en su lista, las obtenemos pero es resultado lo convertimos en stream porque flatmap devuelve un stream
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : cliente ")// se recorren las  facturas obtenidas, se concatenan con el string y ...
                .concat(f.getUsuario().toString()))); //...se le saca el usuario a la que pertenece esa factura

        /*for(Usuario u: usuarios){
            for(Factura f: u.getFacturas()){
                System.out.println(f.getDescripcion());
            }
        }*/
    }
}
