package org.aguzman.poointerfaces.modelo.tres;

public class ClientePremium  extends Cliente implements Comparable<ClientePremium>{
    
	//constructor
	public ClientePremium(String nombre, String apellido) {
        super(nombre, apellido); // el constructor ClientePremiun llama al constructor padre que es cliente
    }

	
	//metodo de Comparable
    @Override
    public int compareTo(ClientePremium o) {
        return 0;
    }
}
