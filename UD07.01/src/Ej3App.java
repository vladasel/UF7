import java.util.Hashtable;

import javax.swing.JOptionPane;

/***
 * 
 * @author ionela
 *
 */
public class Ej3App {
	/*
	 * crea una base de datos de 10 articulos para controlar el stock de una tienda
	 * por medio de un diccionario de datos(articulo:precio) el usuario podrá
	 * añadir, por medio de interfaz visual articulos nuevos y cantidades de estos
	 * el usuario podrá consultar la infomacion almacenada en el diccionario
	 * referente a un articulo concreto e incluso listar toda la información en la
	 * terminal del programa
	 * 
	 */
	public static void main(String[] args) {
		Hashtable<String, Double> articulos = new Hashtable<String, Double>();

		articulos.put("arroz", 1.5);
		articulos.put("leche", 1.2);
		articulos.put("miel", 4.9);
		articulos.put("macarrones", 0.8);
		articulos.put("atun", 3.5);
		articulos.put("aceite", 6.3);
		articulos.put("pan", 0.9);
		articulos.put("agua", 1.3);
		articulos.put("vino", 13.5);
		articulos.put("harina", 0.90);

		int opcion;

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"**************meuu***********\n1-introducir artículo\n2-ver un artículo\n3-ver todos los artículos\n4-salir\n************************\nopcion:"));
			switch (opcion) {
			case 1:
				introducirArticulo(articulos);
				break;
			case 2:
				verDetalle(articulos);
				break;
			case 3:
				verTodo(articulos);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "hasta luego ;)");
				break;
			default:
				JOptionPane.showMessageDialog(null, "la opción introducida no es valida!");
				break;

			}

		} while (opcion != 4);

	}

	/***
	 * 
	 * @param articulos introduce articulos al diccionario pasado por parametro
	 */
	public static void introducirArticulo(Hashtable<String, Double> articulos) {
		String articulo = JOptionPane.showInputDialog("articulo: ");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("precio: "));
		articulos.put(articulo, precio);

	}

	/***
	 * 
	 * @param articulos lista los detalles de un articulo en concreto del
	 *                  diccionario pasado por parametro
	 */
	public static void verDetalle(Hashtable<String, Double> articulos) {
		String articulo = JOptionPane.showInputDialog("articulo buscado: ");
		if (articulos.containsKey(articulo) == true) {
			JOptionPane.showMessageDialog(null, "el precio del artículo es: \n" + articulos.get(articulo));
		} else {
			JOptionPane.showMessageDialog(null, "el artículo buscado no fue encontrado");
		}

	}

	/***
	 * 
	 * @param articulos lista todos los articulos del diccionario pasado por
	 *                  parametro
	 */
	public static void verTodo(Hashtable<String, Double> articulos) {
		System.out.println("listado artículos y sus precios: ");
		for (String i : articulos.keySet()) {
			System.out.println(i + " -> " + articulos.get(i));
		}
		JOptionPane.showMessageDialog(null, "podrás ver el listado en la consola");

	}

}
