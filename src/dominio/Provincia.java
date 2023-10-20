package dominio;
import java.until.ArrayList;
import Java.util.List;

public class Provincia {
	private String nombre;
	private List<Municipio> municipios;

	public Provincia(String nombre) {
		this.nombre = nombre;
		municipios = new ArrayList<>();
	}
	public void agregarMunicipio(Municipio municipio) {
		municipios.add(municipio);
	}

	public int contarHabitantes() {
		int totalHabitantes = 0;

		for (Municipio municipio : municipios) {
			totalHabitantes += municipio.contarHabitantes();
		}

		return totalHabitantes;
	}

	@Override
	Public String toString() {
		return "Provincia: " + nombre + ", Total habitantes: "+ contarHabitantes();
	}
}

