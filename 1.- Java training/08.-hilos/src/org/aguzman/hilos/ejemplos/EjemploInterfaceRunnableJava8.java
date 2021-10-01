package org.aguzman.hilos.ejemplos;

import org.aguzman.hilos.ejemplos.runnable.ViajeTarea;
 
//IMPLEMENTACION HILOS CON JAVA 8 LAMBDAS
public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

    	//retorna una referencia al objecto hilo ejecutandose actualmente 
        Thread main = Thread.currentThread();
        
        
        //se guarda funcion en viaje aqui se le funcionalidad a la el metodo run de la clase Runnable
       // esta la funcion runneable que vamos a manda en el constructor del thread
        Runnable viaje = () -> {
                for(int i=0; i < 10; i++){
                	
                	//imprime el estado del hilo actual que se ejecuta
                    System.out.println(i + " - " + Thread.currentThread().getName());
                   
                    //try porque el metodo sleep arroja una excepcion
                    try {
                        Thread.sleep( (long)(Math.random() * 1000)); // ponemos a dormir el hilo
                    } catch (InterruptedException e) {
                        e.printStackTrace(); // imprimimos la pila de errores
                    }
                }
                
                //fin del hilo
                System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
                System.out.println(main.getState()); //estado final del hilo
            };
            

          // mandamos en el constructor del thread  el target Runneable y el string
        Thread v1 = new Thread(viaje, "Isla de Pascua");
        Thread v2 = new Thread(viaje, "Robinson Crusoe");
        Thread v3 = new Thread(viaje, "Juan Fernandez");
        Thread v4 = new Thread(viaje, "Isla de Chiloe");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join();
        v2.join();
        v3.join();
        v4.join(); // espera a que termine el hilo
        //Thread.sleep(10000);
        System.out.println("Continuando con la ejecución del método main: " + main.getName());
        //main es el metodo principal
    }
}
