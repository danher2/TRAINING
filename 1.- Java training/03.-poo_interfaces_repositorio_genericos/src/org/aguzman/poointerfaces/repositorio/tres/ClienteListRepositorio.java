package org.aguzman.poointerfaces.repositorio.tres;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.aguzman.poointerfaces.modelo.tres.Cliente;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio {

    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
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
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }
//______________________________________________________________________________
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        
    	List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        
    	listaOrdenada.sort((a, b) -> {
                int resultado = 0;
               
//                System.out.print(resultado + ", ");
                
                if(dir == Direccion.ASC){
                    resultado = ordenar(campo, a, b);
                } else if(dir == Direccion.DESC){
                    resultado = ordenar(campo, b, a);
                }
                
//                System.out.print("inicio " + resultado + ", ");
                return resultado;
        });
        return listaOrdenada;
    }
//    ___________________________________________________________________________________

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    
    //ordenar
    public static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id":
                    resultado = a.getId().compareTo(b.getId());
//            case "nombre":
//                    resultado = a.getNombre().compareTo(b.getNombre());
//            case "apellido":
//                    resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
