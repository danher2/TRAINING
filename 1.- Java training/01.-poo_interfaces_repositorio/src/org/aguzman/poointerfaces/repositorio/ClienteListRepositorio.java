package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//herencia multiple implementa tres interfaces
public class ClienteListRepositorio implements CrudRepositorio,
        OrdenableRepositorio, PaginableRepositorio {

	//lista dataSource de clientes donde se alamacenaran los datos
    private List<Cliente> dataSource;

//    constructor
      public ClienteListRepositorio() {
//    	asignamos un array vacio a la lista dataSource  
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
//    	regresamor la lista
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        
    	Cliente resultado = null;
    	for(Cliente cli: dataSource){
            if(cli.getId() != null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
//    	datasource es una lista y tiene el metodo add para agregar al cliente
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
//    	usamos el metodo de arriba por id para buscar el cliente y le pasamos el id por paramretro
        Cliente c = this.porId(cliente.getId());
        
//        se modifican los datos por el cliente que recibo por argumento
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
//    	dataSource es un arrayList y tiene el metodo remove para removerlo
//    	encontramos al cliente por el metodo porId
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
//        asignamos la lista de clientes en el arrayList y lo guardamos en listaOrdenada
    	List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        
//    	llamamos el metodo sort (ordenar) de List<Cliente> lista ordenada que recibe un lamda
        listaOrdenada.sort((a, b) -> { //a y b son de tipo cliente
                int resultado = 0;
                if(dir == Direccion.ASC){
                    resultado = ordenar(campo, a, b);
                } else if(dir == Direccion.DESC){
                    resultado = ordenar(campo, b, a);
                }
                return resultado;
        });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    public static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id" :
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" :
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" :
                    resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
