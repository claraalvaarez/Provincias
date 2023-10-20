public class Principal{
	public static void main(String[] args) {
		Localidad localidad = new Localidad();
		Municipio municipio = new Municipio();

		localidad.setNombre("Coruña");
		localidad.setNumerohabitantes(1);

		System.out.print(localidad.getNombre()+"tiene"+localidad.getNumerohabitantes()+"habitantes");
		Localidad localidad2 = new Localidad();
		Localidad2.setNombre("Vigo");

		municipio.setNombre("Galicia");
		municipio.addLocalidad(localidad);
		municipio.addLocalidad(localidad2);
		municipio.calcularNumeroTotalHabitantesMunicipio();

		System.out.println(municipio);

		System.out.print(municipio.getTotlNumeroHabitantesMunicipio());
	}
}

