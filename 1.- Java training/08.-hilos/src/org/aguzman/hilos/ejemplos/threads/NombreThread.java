package org.aguzman.hilos.ejemplos.threads;

//hereda de la clase 
public class NombreThread extends Thread {
     
	
	//constructor
	public NombreThread(String name) {
        super(name); // lamamos al constructor padre (Thread)
    }

	
	//sobreescribimnos el metodo de la clase Thread
    @Override
    public void run() {
        System.out.println("se inicia el metodo run del hilo " + getName());

//        simulamos de 1  9
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName());
        }
        System.out.println("finaliza el hilo");
    }
}
