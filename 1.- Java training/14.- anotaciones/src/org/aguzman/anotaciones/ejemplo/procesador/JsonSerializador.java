package org.aguzman.anotaciones.ejemplo.procesador;

import org.aguzman.anotaciones.ejemplo.Init;
import org.aguzman.anotaciones.ejemplo.JsonAtributo;
import org.aguzman.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

//PROCESADOR DE ANOTACIONDE DEL OBJETO
//utilizando el api de reflexion de Java


public class JsonSerializador {
	
	
// inicializar el objeto
    public static void inicializarObjeto(Object object){
        
    	if(Objects.isNull(object)){ //si el objeto es nulo
            throw new JsonSerializadorException("El objeto a serializar no puede ser null!"); // lanza la excepcion
        }
    	
       
    	Method[] metodos = object.getClass().getDeclaredMethods(); // regresa todos los metodos de una clase
        
      
        Arrays.stream(metodos).filter(m -> m.isAnnotationPresent(Init.class))// filtramos todos los que tienen anotacion  de tipo Init.class
                .forEach(m-> {
                    m.setAccessible(true); //Establece el indicador de accesibilidad para este objeto reflejado al valor booleano indicado. Un valor de true indica que el objeto reflejado debe suprimir las comprobaciones de control de acceso al lenguaje Java cuando se utilice. Un valor de false indica que el objeto reflejado debe reforzar las comprobaciones de control de acceso al lenguaje Java cuando se utiliza, con la variación indicada en la descripción de la clase.

                    try {
                        m.invoke(object); // se invoca el metodo que se obtiene del tipo que se le manda en el argumento
                    } catch (IllegalAccessException | InvocationTargetException e) {// lanza exceptiones de dos tipos 
                        throw new JsonSerializadorException( // se arroja nuestra excepcion
                                "Error al serializar, no se puede iniciar el objeto"
                        + e.getMessage()); // y el mensaje
                    }
                });
    }

    
    
    //convertir a Json
    public static String convertirJson(Object object){

        if(Objects.isNull(object)){
            throw new JsonSerializadorException("El objeto a serializar no puede ser null!");
        }
        
        
        inicializarObjeto(object);
        
        //regresa un arreglo de los atributos del tipo del objeto que llama este metodo (Productos)
        Field[] atributos = object.getClass().getDeclaredFields(); // obtener campos declarados
        
        
        return Arrays.stream(atributos) // convertimos ese arreglo a stream para procesarlo
                .filter(f -> f.isAnnotationPresent(JsonAtributo.class)) // filtra con true o false los atribuos que tienen la anotacion JsoAtributo
                .map(f -> { 
                    f.setAccessible(true); // acceder a los campos apesar que sean private
                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")// si el atributo nombre (de la clase anotacion) es igual a "" o sea no hay nada
                    		? f.getName() //por el nombre del atributo
                    		: f.getAnnotation(JsonAtributo.class).nombre();// sino, por el nombre que se le da entre parentesis
                   
                    try {
                        Object valor = f.get(object);
                        if(f.getAnnotation(JsonAtributo.class).capitalizar() &&
                        valor instanceof String){
                       
                        	String nuevoValor = (String) valor;
                           
                        	nuevoValor = Arrays.stream(nuevoValor.split(" "))
                            .map(palabra -> palabra.substring(0, 1).toUpperCase()
                            + palabra.substring(1).toLowerCase())
                            .collect(Collectors.joining(" "));

                            f.set(object, nuevoValor);
                        }
                        
                        return "\"" + nombre + "\":\"" + f.get(object) + "\""; // conbertimos del campo field a string json
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException("Error al serializar a json: " + e.getMessage());
                    }
                })
                .reduce("{" , (a,b) -> {
                    if("{".equals(a)){
                        return a + b;
                    }
                    return a + ", " + b;
                }).concat("}");
    }
}
