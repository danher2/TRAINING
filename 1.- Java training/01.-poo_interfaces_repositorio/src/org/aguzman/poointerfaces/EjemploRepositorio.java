package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

    	//Crud repositorio es implementado por ClienteListRepositorio
        CrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Bea", "González"));
        repo.crear(new Cliente("Luci", "Martínez"));
        repo.crear(new Cliente("Andrés", "Guzmán"));

        //listamos los clientes creados arriba
        List<Cliente> clientes = repo.listar();
        
        //por cada cliente de la lista clientes que me lo imprima
        clientes.forEach(System.out::println);
        
        System.out.println("===== paginable =====");
        //        paginar clientes del 1 al 4 usando metodo listar casteando repo a PaginableRepositorio
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1, 4);
        paginable.forEach(System.out::println); //porcada cliente  me lo imprima

        
        System.out.println("===== ordenarMIAU =====");
       //hacemos cast a OrdenableRepositorio y llamamos el metodo list
        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio)repo).listar("nombre", Direccion.ASC);
        for(Cliente c: clientesOrdenAsc){
            System.out.println(c);
        }

        System.out.println("===== editar =====");
        Cliente beaActualizar = new Cliente("Bea", "Chaparra");
        beaActualizar.setId(2); //fijar el id 2 de nuevo porque sino se realizaria un id nuevo
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);
        
        System.out.println(" ============= ");
        ((OrdenableRepositorio)repo).listar("nombre", Direccion.ASC).forEach(System.out::println);
        
        System.out.println("===== eliminar ======");
//        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
    }
}
