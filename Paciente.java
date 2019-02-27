public class Paciente implements Comparable<Paciente>
{
    
	private static int numpaciente =0;
    int id;
    private String nombre;
    public Paciente(String nombre)
    {
        this.nombre = nombre;
        numpaciente++;
        this.id = numpaciente;
    }
    
    public String toString(){
        return id +":"+nombre;
    }

	public int getId() {
		return id;
	}
	public int setId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String setNombre() {
		return nombre;
	}
	
	public int compareTo(Paciente p) {
		
		return this.getNombre().toUpperCase().compareTo(p.getNombre().toUpperCase());
	}

	
	   

}
