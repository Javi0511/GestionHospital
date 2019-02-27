

public class Hospital 
{ 
    private Paciente tpacientes[];
    private int contadorpacientes;
    public Hospital(int numpacientes)
    {
        tpacientes = new Paciente[numpacientes];
        contadorpacientes=0;
    }

    // Ingreso de un paciente al hospital
    public boolean ingreso(Paciente p) {
    	for (int i=1; i<tpacientes.length; i++) {
			if (tpacientes[i] == null){
				
				tpacientes[i] = p;
				contadorpacientes++;
				break;
    
			}
		}
    	return true;
	}
    // Ingreso de un paciente grave al hospital
    public boolean ingreso(PacienteGrave p, TipoGravedad gravedad ) {
    	for (int i=1; i<tpacientes.length; i++) {
			if (tpacientes[i] == null){
				
				tpacientes[i] = p;
				contadorpacientes++;
				break;
				
    
			}
		}
    	return true;
	}
    // Alta del paciente - se borra de la tabla
    public boolean alta ( int id_paciente){
    	for (int i=1; i< contadorpacientes; i++) {
			if (tpacientes[i].getId() == id_paciente){	
				tpacientes[i] = null;
				contadorpacientes--;
			}
		}
    	return true;
	} 
      
    
    // Devuelve el paciente con el identidador indicado o null si no existe
    public Paciente buscar(int id){
    	for(int i=1;i<tpacientes.length;i++) {
    		
    		if (tpacientes[i]!=null) {
    			if (tpacientes[i].getId()==id) {
    				
    				return tpacientes[i];
    			}
    		}
    	}
    	return null;
    }
    
    // Imprime por consola la lista de pacientes
    public void listapacientes (){
    	
    	for (int i=1; i< this.tpacientes.length; i++) {
    		
    		if (tpacientes[i] != null) {
    		System.out.println(tpacientes[i]);
    		}
    	}
    		
    }    
       
    // Devuelve el mas grave o el caso de paciente con la misma gravedad el
    // que su identificador sea mas bajo.
    public Paciente pacienteMasUrgente(){
    	
    if (contadorpacientes ==1) {
    	return tpacientes[0];
    }
    if (contadorpacientes == 0) {
    	return null;
    }
    PacienteGrave maxg = null;
   
    for (int i=1; i< contadorpacientes;i++) {
    	Paciente aux =tpacientes[i];
    	if (aux instanceof PacienteGrave) {
    		PacienteGrave aux2 = (PacienteGrave) aux;
    		if (maxg ==null) {
    			maxg=aux2;
    		}if (aux2.getGravedad().ordinal()==maxg.getGravedad().ordinal()) {
    			maxg = aux2;
    		}
    		if (aux2.getGravedad().ordinal()==maxg.getGravedad().ordinal()){
    			if (aux2.getId() < maxg.getId()) {
    				maxg=aux2;
    			}
    		}
    	}
    }
    if (maxg==null) {
    	Paciente max = null;
    	for (int i=1; i < contadorpacientes; i++) {
    		if (tpacientes[i].id  <tpacientes[i-1].getId()) {
    			max = tpacientes[i];
    		}else max=tpacientes[i-1];
    	}return max;
    	
    }else return maxg;  
        
    }
    //ordenar pacientes
    public void ordenar() {
    	for (int i=0; i<tpacientes.length-1;i++) {
    		if(i!=tpacientes.length-1) {
    			if(tpacientes[i]==null &&tpacientes[i+1]!=null) {
    				tpacientes[i]=tpacientes[i+1];
    				tpacientes[i+1]=null;
    			}
    		}
    	}
    }
}
