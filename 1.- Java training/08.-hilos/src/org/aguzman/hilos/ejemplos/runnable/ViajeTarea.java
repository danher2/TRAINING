package org.aguzman.hilos.ejemplos.runnable;


//implementa la interfaz Runneable
public class ViajeTarea implements Runnable{
    
	
	private String nombre;

    
	public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    
    //metodo de Runneable sobrescrito
    @Override
    public void run() {
        for(int i=0; i < 10; i++){
            System.out.println(i + " - " + nombre);
            try {
                Thread.sleep( (long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente me voy de viaje a: " + nombre);

    }
}
