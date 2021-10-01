package org.aguzman.generics.tres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aguzman.poointerfaces.modelo.tres.Cliente;
import org.aguzman.poointerfaces.modelo.tres.ClientePremium;

public class EjemploGenericos {
    public static void main(String[] args) {

    	//lista generica de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres", "Guzmán")); // se le agrega un cliente a la lista clientes
        Cliente andres = clientes.iterator().next();// retorna un clilente

        
        
        //arreglo de clientes
        Cliente[] clientesArreglo = {new Cliente("Luci", "Martínez"), new Cliente("Andres", "Guzmán")};
       
        //Arreglo de numeros int
        Integer[] enterosArreglo = {1,2,3};

        //convertimos el arreglo clientesArreglo  a una lista con fromArrayToList
        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        
        // al igual aqui convertimos un arreglo a list
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        //imprimimos la lista de clientes
        clientesLista.forEach(System.out::println);
        
        //imprimimos lista de numeros
//        enterosLista.forEach(System.out::println);

        
        //se utiliza el fromArrayToList con los dos genericos T y G este metodo solo retorna una lista pero imprime en su paso al []G
        List<String> nombres = fromArrayToList(new String[]{"Andres", "Pepe","Luci", "Bea", "John"}, enterosArreglo);
        nombres.forEach(System.out::println); // imprime la lista de nombres que retorna el metodo

        
        List<ClientePremium> clientesPremiumList = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Paco", "Fernandez")});

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientesPremiumList); // clientesPremiumList clase hija de cliente

        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.9, 11.6, 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Maximo de zanahoria, arandanos, manzana es: "
                + maximo("zanahoria", "arandano", "manzana"));

    }

    // retorna una lista generia del metodo generico y recibe como argumento un arreglo generico, usado para Convertir cualquier tipo de datp
    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c); // solo regresa  la lista
    }

    //limitamos el metodo a que el generico sea solo de tipo nombre
    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
// limitamos a que el metodo generico  solo sea de tipo cliente o las clases que la heredan y que implemente la  interfaz generica comparable
    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    //metodo dos tipos genericos retorna una lista de T
    //el g se itera o se imprime
    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento: x){ // itero el arreglo x del tipo G
            System.out.println( elemento);
        }
        return Arrays.asList(c); //convierto c en lista
    }

    
    
    // recibe como parametro un list de tipo cliente y sus hijos = ? =>
    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }
    
    
    
    
    
// Devuelve un generico que sea o que extienda de  un tipo COmparable
//   compara el objeto mayor
    public static <T extends Comparable<T >> T maximo(T a, T b, T c){
        T max = a; // por defecto el mayor es a
        if(b.compareTo(max) > 0){// si b es mayor qque max (a)
            max = b; //ahora b sea max
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max; // devuelve el numero mayor
    }
}
