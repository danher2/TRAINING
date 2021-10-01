package org.aguzman.api.stream.ejemplos.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nombre;
    private String apellido;
    private Integer id;
    private static int ultimoId;

    private List<Factura> facturas;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = ++ultimoId;
        this.facturas = new ArrayList<>(); // creamos la lista de facturas
    }

    //metodos para factura
    public List<Factura> getFacturas() {
        return facturas;
    }

    public void addFactura(Factura factura) {
        this.facturas.add(factura); // esa factura la agrego a la lista de facturas
        factura.setUsuario(this); // le anado esa factura al usuario que esta invocando este mismo metodo addFactura
        						// this = corresponde al usuario en cuestion (u1,u2), en usuario agregamos la factura pero a su vez en factura agregamos al usuario 
    }							 // this = es una referencia al objeto invocado que invoca al metodo addFactura en este caso u1 o u2 (es decir, el objeto sobre el que se llama el método) y ese mismo usuario es el que  se settea en setUsuario

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    // El método equals es usado en las colecciones de tipo List, Set, y también Map para determinar si un objeto ya está incluida en la colección, 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(apellido, usuario.apellido);
    }

    
    //el método hashCode es usado en los Map para encontrar el objeto asociado a la clave.
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
