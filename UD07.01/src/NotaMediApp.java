import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;

/***
 * @author ionela
 *
 */
public class NotaMediApp {
	/*
	 * crea una app que calcule la nota media de los alumnos pertenecientes al curso
	 * de programación. una vez calculada la nota media se guardará esta información
	 * en un diccionario de datos que almacene la nota media de cada alumno. todos
	 * estos datos e han de proporcionar por pantalla.
	 */
	public static void main(String[] args) {
		menu();
	}

	// menu
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Hashtable<String, Double> clase = new Hashtable<String, Double>();
		int opcion;
		do {
			System.out.println("\n**********MENU*********************");// opciones a elegir
			System.out.println("1 introducir alumnos y notas");
			System.out.println("2 mostrar media de un alumno");
			System.out.println("3 ver todas las medias");
			System.out.println("4 salir");
			System.out.println("***********************************");
			System.out.println("introduce opción: ");
			opcion = sc.nextInt();

			switch (opcion) {
			// permite introducir varios alumnos y sus notas, los datos se guardan en un
			// hashtable
			case 1:
				clase = introducirAlumnosYnotas();
				System.out.println("datos introducidos!");
				break;

			// muestra la media de un alumo en concreto,pasado por parametro
			case 2:
				System.out.println("opcion 2");
				break;

			// muestra la media de todos los alumos
			case 3:
				System.out.println("opción 3");
				break;

			// sale del menu
			case 4:
				System.out.println("hasta luego ;)");
				break;

			// por si la opcion introducida no corresponde con ningún case
			default:
				System.out.println("la opción introducida no es correcta!");
				break;

			}

		} while (opcion != 4);
		sc.close();
	}

	// introducir alumno y sus notas -->ses guarda el alumno y su media
	public static Hashtable<String, Double> introducirAlumnosYnotas() {
		Scanner scan = new Scanner(System.in);
//variables
		String nombre;
		double nota;
		double suma = 0;
		double media = 0;
		int contadorNotas = 0;

		ArrayList<String> listaAlumnos = new ArrayList<>();
		ArrayList<Double> listaNotas = new ArrayList<>();

		do {// mientras no se introduzca "end" se podrán seguir introduciendo nombres
			System.out.println("introduce el nombre del alumno: ");
			nombre = scan.nextLine();

			if (nombre.equals("end")) {

				break;
			} else {
				listaAlumnos.add(nombre);// despues de introducir el nombre, se guarda en una lista

				do {
					System.out.println("introduce nota:");// se introducen notas mientras no encuentre un -1
					nota = scan.nextDouble();
					scan.nextLine();

					suma = suma + nota;// vamos sumando las notas introducidas
					contadorNotas++;// vamos sumando el numero de notas introducidas

				} while (nota != -1);
				media = suma / contadorNotas - 1;// Calculamos media
				listaNotas.add(media);// intorducimos en una lista la media
			}
		} while (!nombre.equals("end"));
		// actualizamos
		contadorNotas = 0;
		suma = 0;

		scan.close();

		Hashtable<String, Double> clase = new Hashtable<String, Double>();
		for (int i = 0; i < listaAlumnos.size(); i++) {// por cada nombre se guarda una media
			clase.put(listaAlumnos.get(i), listaNotas.get(i));
		}

		return clase;// devolvemos el hastable con los nombres y las medias

	}

	// mostrar media de un alumno
	public static void mostrarMediaAlumno(String nameAlumno) {

	}

	// ver todas las medias
	public static void mostrarMedias() {

	}

}
