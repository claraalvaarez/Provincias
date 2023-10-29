package dominio;

public class Provincia {
	private String nombre;
	private Municipio[] municipios;
	private int numeroTotalHabitantesProvincia;


	public Provincia(String nombre) {
		this.nombre = nombre;
		this.municipios = new Municipio[0];
		this.numeroTotalHabitantesProvincia=0;
	}
	public void addMunicipio(Municipio municipio) {
		Municipio[] nuevoArray = new Municipio[municipios.length + 1];

		for (int i=0; i<municipios.length;i++) {
			nuevoArray[i]= municipios[i];

		}

		nuevoArray[municipios.length] = municipio;

		municipios = nuevoArray;

	}

	public void getNumeroTotalDeHabitantes(){
		int totalHabitantes = 0;
		for (Municipio municipio : municipios) {
			totalHabitantes += municipio.getNumeroTotalDeHabitantes();	
		}
		this.numeroTotalHabitantesProvincia=totalHabitantes;

	}
	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Municipio[] getMunicipios(){
		return municipios;
	}

	public void setMunicipios (Municipio[] municipios) {
		this.municipios = municipios;
	}


}

