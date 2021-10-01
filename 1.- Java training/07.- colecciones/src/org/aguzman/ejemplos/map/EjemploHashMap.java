package org.aguzman.ejemplos.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class EjemploHashMap {
    public static void main(String[] args) {

    	//no es de COllection sino Map guarda elementos con llave y valor
        
    	//lista de personas
    	Map<String, Object> persona = new HashMap<>();
        
        System.out.println("contiene elementos=" + !persona.isEmpty());
        persona.put(null, "1234"); // guardamos con llave y valor
        persona.put(null, "12345");//no permite este null porque es una key y las key son unicas
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", 30);

        //lista de direcciones
        Map<String, String> direccion = new HashMap<>();
       
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("numero", "120");

        
        persona.put("direccion", direccion);
        System.out.println("persona = " + persona);
        
        //obtenemos por keys  nombre y apellido
        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);
        
        
// tomamos la coleccion guardada dentrp de la coleccion persona por medio del get
        Map<String, String> direccionPersona = (Map<String, String>)persona.get("direccion");
        
        //obtenemos elementos por los keys
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "La playa");
        System.out.println("El pais de " + nombre + " es: " + pais);
        System.out.println("La ciudad de " + nombre + " es: " + ciudad);
        System.out.println("El barrio de " + nombre + " es: " + barrio);
        //String apellidoPaterno = persona.remove("apellidoPaterno");
       
        boolean b = persona.remove("apellidoPaterno", "Doe");//remove por key y value
        System.out.println("eliminado " + b);
        System.out.println("persona = " + persona);// nueva lista
        
        
        //contains por llave
        boolean b2 = persona.containsKey("apellidoPaterno");
        System.out.println("b2 = " + b2);

        
        //contains por value
        b2 = persona.containsValue("john.doe@email.co");
        System.out.println("b2 = " + b2);

        
        //FORMAS DE ITERAR HASMAP
        
        System.out.println("========================== values");
        Collection<Object> valores = persona.values();
        System.out.println("imprimendo valores...");
        for(Object v: valores){
            System.out.println("v = " + v);
        }

        //devuelve un set con las llaves de la colleciont
        System.out.println("========================= keySet  devuelve llaves de la collecion");
        Set<String> llaves = persona.keySet();
        for(String k: llaves){
            System.out.println("k = " + k);
        }

        //iterar llave y valor
        System.out.println("========================== entrySet");
        // simple for each
        for(Map.Entry<String, Object> par: persona.entrySet()){ //retorna una liste set
            Object valor = par.getValue();
            if(valor instanceof Map){ //si valor es una instancia de map
                String nom = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                for(Map.Entry<String, String> parDir: direccionMap.entrySet()){
                    System.out.println(parDir.getKey() + " => " + parDir.getValue());
                }
            }
            else {
                System.out.println(par.getKey() + " => " + valor);
            }
        }

        System.out.println("========================== keySet");
        for(String llave: persona.keySet()){
            Object valor = persona.get(llave);
            if(valor instanceof Map){
                String nom = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                System.out.println("El país de " + nom + ": "
                        + direccionMap.get("pais"));
                System.out.println("El estado de " + nom + ": " + direccionMap.get("estado"));
                System.out.println("La ciudad de " + nom + ": " + direccionMap.get("ciudad"));
            } else {
                System.out.println(llave + " => " + valor);
            }
        }
        
        //creo es la mas  facil jaja
        System.out.println("========================== java 8 forEach");
        persona.forEach((llave, valor) ->{
            System.out.println(llave + " => " + valor);
        });

        System.out.println("total: " + persona.size());
        System.out.println("contiene elementos=" + !persona.isEmpty());
        boolean b3 = persona.replace("nombre", "John", "Andrés");
        System.out.println("b3 = " + b3);
        System.out.println("persona = " + persona);
        
    }
}
