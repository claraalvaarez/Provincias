package dominio;
import java.util.Arrays;
public class Municipio {
	private String nombre;
	private Localidad[] localidades; // Array de Localidad
	private int totalNumeroHabitantesMunicipio;

	public Municipio(String nombre, Localidad[] localidades){
		this.nombre = nombre;
	        this.localidades = localidades;
		this.totalNumeroHabitantesMunicipio=0;
	}
	public Municipio() {
		this.nombre = "";
		this.localidades = new Localidad[0]; // Crear un array de localidades vacio
	}
	public Municipio(String nombre2) {
    }
    public void calcularNumeroTotalHabitantesMunicipio() {
		int totalHabitantes = 0;
		for (Localidad localidad : localidades) {
			this.totalNumeroHabitantesMunicipio += localidad.getTotalNumeroHabitantesMunicipio();
		}
	}
	// Método para agregar una localidad al municipio
	public void addLocalidad(Localidad localidad) {
		// Crear un nuevo array de localidades con una longitud 1 mayor que el actual
		Localidad[] nuevoArray = new Localidad[localidades.length + 1];

		// Copiar las localidades existentes al nuevo array
		for (int i = 0; i< localidades.length; i++) {
			nuevoArray[i] = localidades[i];
		}
		
		// Agregar la nueva localidad al final del nuevo array
		nuevoArray[localidades.length] = localidad;

		// Reemplazar el array de localidades actual con el nuevo array
		nuevoArray[localidades.length] = localidad;

		// Reemplazar el array de localidades actual con el nuevo array
		localidades = nuevoArray;
	}
	@Override
	public String toString() {
		return "Municipio{" +
			"nombre='" + nombre + '\'' +
			", localidades=" + Arrays.toString(localidades) +
			", totalNumeroHabitantesMunicipio=" + totalNumeroHabitantesMunicipio +'}';
	}
	public int getNumeroTotalDeHabitantes() {
		return 0;
	}
}
	


