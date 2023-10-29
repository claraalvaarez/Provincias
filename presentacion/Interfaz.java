package presentacion;
import dominio;
import dominio.Localidad;
import dominio.Municipio;
import dominio.Provincia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interfaz {
    private List<Provincia> provincias;
    private Scanner scanner;

    public Interfaz() {
        provincias = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * 
     */
    public void iniciarPrograma(){
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearLocalidades();
                    break;
                case 2:
                    crearMunicipios();
                    break;
                case 3:
                    crearProvincias();
                    break;
                case 4:
                    mostrarInformacion();
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el programa");
                    break;
                default:
                    System.out.println("La opcion no es valida");
                    break;
            }
            
        } while (opcion |= 5);
    }

   
    private void mostrarInformacion() {
    }

    private void crearProvincias() {
    }

    private void mostrarMenu() {
        System.out.println("----------- MENÚ -----------");
        System.out.println("1. Crear localidades");
        System.out.println("2. Crear municipios");
        System.out.println("3. Crear provincias");
        System.out.println("4. Mostrar informacion");
        System.out.println("5. Salir");
        System.out.print("ingrese una opcion: ");
    }

    private void crearLocalidades() {
        System.out.print("\nIngrese la cantidad de localidades que desa crear: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidad; i++ ) {
            System.out.println("\n--- CREANDO LOCALIDAD " + (i+1) + "---");
            System.out.print("Ingrese el nombre de la localidad: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el numero de habitantes de la localidad: ");
            int habitantes = scanner.nextInt();
            scanner.nextLine();

            Localidad localidad = new Localidad();
            localidad.setNombre(nombre);
            localidad.setNumeroDeHabitantes(habitantes);

            System.out.println("Localidad creada: " + localidad);

            agregarLocalidad(localidad);
        }
    }

    private void agregarLocalidad(Localidad localidad) {
    }

    private void crearMunicipios() {
        System.out.print("\nIngrese la cantidad de municipios que desea crear: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int i=0; i < cantidad; i++ ) {
            System.out.println("\n--- CREANDO MUNICIPIO " + (i + 1) + "---");
            System.out.print("Ingrese el nombre del municipio: ");
            String nombre = scanner.nextLine();

            Municipio municipio = new Municipio(nombre);

            System.out.print("Ingrese la cantidad de localidades que desea agregar al municipio:");
            int cantidadLocalidades = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < cantidadLocalidades; j++) {
                System.out.println("\n--- AGREGANDO LOCALIDAD " + (j + 1) + "AL MUNICIPIO " + (i + 1) + " --- ");
                System.out.print("Ingrese el nombre de la localidad: ");
                String nombreLocalidad = scanner.nextLine();
                System.out.print("Ingrese el numero de habitantes de la localidad:");
                int habitantes = scanner.nextInt();
                scanner.nextLine();

                Localidad localidad = new Localidad();
                localidad.setNombre(nombreLocalidad);
                localidad.setNumeroDeHabitantes(habitantes);

                municipio.agregarLocalidad(localidad);

                System.out.println("Localidad agregada al municipio: " + localidad);

            }

            agregarMunicipio(municipio);
        }
    }
    
    private void crearProvincias() {
        System.out.print("\n Ingrese la cantidad de provincias que desea crear: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- CREANDO PROVINCIA " + (i + 1) + " --- ");
            System.out.print("Ingrese el nombre de la provincia:");
            String nombre = scanner.nextLine();

            Provincia provincia = new Provincia(nombre);

            System.out.print("Ingrese la cantidad de municipios que desea agregar a la provincia:");
            int cantidadMunicipios = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < cantidadMunicipios; j++) {
                System.out.println("\n--- AGREGANDO MUNICIPIO " + (j + 1) + "A LA PROVINCIA" + (i + 1) + " --- ");
                System.out.print("Ingrese el nombre del municipio: ");
                String nombreMunicipio = scanner.nextLine();

                Municipio municipio = new Municipio(nombreMunicipio);

                System.out.print("Ingrese la cantidad de localidades que desea agregar al municipio:");
                int cantidadLocalidades = scanner.nextInt();
                scanner.nextLine();

                for (int k = 0; k < cantidadLocalidades; k++) {
                    System.out.println("\n--- AGREGANDO LOCALIDAD " + (k+ 1) + "AL MUNICIPIO " + (j + 1) + "DE LA PROVINCIA" + (i+1));
                    System.out.print("Ingrese el nombre de la localidad: ");
                    String nombreLocalidad = scanner.nextLine();
                    System.out.print("Ingrese el numero de habitantes de la localidad: ");
                    int habitantes = scanner.nextInt();
                    scanner.nextLine();

                    Localidad localidad = new Localidad();
                    localidad.setNombre(nombreLocalidad);
                    localidad.setNumeroDeHabitantes(habitantes);

                    municipio.agregarLocalidad(localidad);

                    System.out.println("localidad agregada al municipio: " + localidad);
                }

                provincia.agregarMunicipio(municipio);
            }

            agregarProvincia(provincia);
        }
    }
    private void agregarLocalidad(Localidad localidad){
        for (Provincia provincia : procincias) {
            System.out.println("--- AGREGANDO LOCALIDAD A LA PROVINCIA " + provincia.getNombre() + " ---");
            System.out.print("¿Desea agregar la localidad a esta provincia? (S/N):");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase(anotherString: "S")) {
                Municipio municipio = elegirMunicipio(provincia);

                if (municipio != null) {
                    municipio.agregarLocalidad(localidad);
                    System.out.println("Localidad agregada al municipio "+ municipio.getNombre() + "de la provincia" + provincia.getNombre() + ".");
                }

                return;
            }
        }

        System.out.println("No se ha encontrado una provincia a la cual agregar la localidad. Se ha descartado.");

    }

    private void agregarMunicipio(Municipio municipio) {
        for (Provincia provincia : provincias) {
            System.out.println("--- AGREGANDO MUNICIPIO A LA PROVINCIA " + provincia.getNombre() + " ---");
            System.out.print("¿Desea agregar el municipio a esta proviincia? (S/N):");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase(anotherString:"S")) {
                provincia.agregarMunicipio(municipio);
                System.out.println("Municipio agregado a la provincia " + provincia.getNombre() + ".");
                return;
            }
        }

        System.out.println("No se ha encontrado una provincia a la cual agregar el municipio. Se ha descartado.");

    }

    private void agregarProvincia(Provincia provincia) {
        provincias.add(provincia);
        System.out.println("Provincia agregada.");
    }

    private Municipio elegirMunicipio(Provincia provincia) {
        System.out.print("Ingrese el nombre del municipio al que desea agregar la localidad: ");
        String nombreMunicipio = scanner.nextLine();

        for (Municipio municipio : provincia.getMunicipios()) {
            if (municipio.getNombre().equalsIgnoreCase(nombreMunicipio)) {
                return municipio;
            }
        }

        return null;
    }

    private void mostrarInformacion() {
        System.out.println("\n--- INFORMACION ---");

        for (Provincia provincia : provincias {
            System.out.println("Provincia: " + provincia.getNombre());
            system.out.println("Total habitaantes: " + procincia.contarHabitantes());
            System.out.println("Muicipios: ");

            for (Municipio municipio : provincia.getMunicipios()) {
                System.out.println("- " + municipio.getNombre());
                System.out.println( " Habitantes:" municipio.contarHabitantes());
                System.out.println(" Localidades:");

                for (Localidad localidad : municipio.getLocalidades()) {
                    System.out.println("  - " + localidad.getNombre());
                    System.out.println("  Habitantes: " + localidad.getNumeroDeHabitantes());
                }

            }

            System.out.println("-------------------------------------------");

        }
    }

    Run | Debug
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.iniciarPrograma();
    }
    
    }




