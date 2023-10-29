package dominio;
public class Localidad{
	private String nombre;
	private int numerohabitantes;

	
	public Localidad(String nombre, int numerohabitantes){
		this.nombre = nombre;
		this.numerohabitantes = numerohabitantes;
	}
	public Localidad() {
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setNumerohabitantes(int numerohabitantes){
		this.numerohabitantes = numerohabitantes;
	}
	public String getNombre(){
		return this.nombre;
	}
	public int getNumerohabitantes(){
		return this.numerohabitantes;
	}
	public String toString(){
		String result = ("La localidad" + this.nombre + "tiene" + this.numerohabitantes + " habitantes "); return result;
	}
	public int getTotalNumeroHabitantesMunicipio() {
		return 0;
	}
	public void setNumeroDeHabitantes(int habitantes) {
	}
}

