import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

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

			opcion = Integer.parseInt(JOptionPane.showInputDialog("**********MENU*********************"
					+ "\n1 introducir alumnos y notas(end para acabar nombres,0 para acabar notas)"
					+ "\n2 mostrar media de un alumno" + "\n3 ver todas las medias" + "\n4 salir"
					+ "\n***********************************" + "\nopcion:  "));

			switch (opcion) {
			// permite introducir varios alumnos y sus notas, los datos se guardan en un
			// hashtable
			case 1:
				clase = introducirAlumnosYnotas();
				JOptionPane.showMessageDialog(null, "datos introducidos!");
				break;

			// muestra la media de un alumo en concreto,pasado por parametro
			case 2:
				mostrarMediaAlumno(clase);
				break;

			// muestra la media de todos los alumos
			case 3:
				mostrarMedias(clase);
				JOptionPane.showMessageDialog(null, "datos mostrados por consola");

				break;

			// sale del menu
			case 4:
				JOptionPane.showMessageDialog(null, "hasta luego ;)");
				break;

			// por si la opcion introducida no corresponde con ningún case
			default:
				JOptionPane.showMessageDialog(null, "la opción introducida no es correcta!");
				break;

			}

		} while (opcion != 4);
		sc.close();
	}

	// introducir alumno y sus notas -->ses guarda el alumno y su media
	public static Hashtable<String, Double> introducirAlumnosYnotas() {
//variables
		String nombre;
		double nota;
		double suma = 0;
		double media = 0;
		int contadorNotas = 0;

		ArrayList<String> listaAlumnos = new ArrayList<>();
		ArrayList<Double> listaNotas = new ArrayList<>();

		do {// mientras no se introduzca "end" se podrán seguir introduciendo nombres

			nombre = JOptionPane.showInputDialog("introduce el nombre del alumno:   ");

			if (nombre.equals("end")) {

				break;
			} else {
				listaAlumnos.add(nombre);// despues de introducir el nombre, se guarda en una lista

				do {
					// se introducen notas mientras no encuentre un -1
					nota = Integer.parseInt(JOptionPane.showInputDialog("introduce nota:  "));

					suma = suma + nota;// vamos sumando las notas introducidas
					contadorNotas++;// vamos sumando el numero de notas introducidas

				} while (nota != 0);
				media = suma / (contadorNotas - 1);// Calculamos media
				listaNotas.add(media);// intorducimos en una lista la media
				// actualizamos

				contadorNotas = 0;
				suma = 0;
			}

		} while (!nombre.equals("end"));

		Hashtable<String, Double> clase = new Hashtable<String, Double>();
		for (int i = 0; i < listaAlumnos.size(); i++) {// por cada nombre se guarda una media
			clase.put(listaAlumnos.get(i), listaNotas.get(i));
		}

		return clase;// devolvemos el hastable con los nombres y las medias

	}

	// mostrar media de un alumno
	public static void mostrarMediaAlumno(Hashtable<String, Double> clase) {
		String nameAlumno = JOptionPane.showInputDialog(null, "nombre del alumno:");
		if (clase.containsKey(nameAlumno) == true) {
			JOptionPane.showMessageDialog(null, "la media de " + nameAlumno + " es\n" + clase.get(nameAlumno));
		} else {
			JOptionPane.showMessageDialog(null, "el alumno introducido no existe");
		}

	}

	// ver todas las medias
	public static void mostrarMedias(Hashtable<String, Double> clase) {
		for (String i : clase.keySet()) {
			System.out.println(i + " " + clase.get(i));
		}

	}

}
