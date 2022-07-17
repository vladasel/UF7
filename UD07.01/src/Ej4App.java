import java.util.Hashtable;

import javax.swing.JOptionPane;

/***
 * 
 * @author ionela
 *
 */
public class Ej4App {
	/*
	 * combina los metodos generados en las activ 2 y 3 creando una app que gestione
	 * ventas y control de stock en una misma interfaz. utiliza para ello las
	 * estructuras de datos que creas conveniente
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
			opcion = Integer.parseInt(JOptionPane.showInputDialog("**************meuu***********"
					+ "\n1-introducir artículo" + "\n2-ver un artículo" + "\n3-ver todos los artículos" + "\n4-comprar"
					+ "\n5-salir" + "\n************************\nopcion:"));
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
				comprar(articulos);
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "hasta luego ;)");
				break;
			default:
				JOptionPane.showMessageDialog(null, "la opción introducida no es valida!");
				break;

			}

		} while (opcion != 5);

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

	/***
	 * 
	 * @param cantidadPagada
	 * @param precioTotal
	 * @return cambio
	 */
	public static double cambio(double cantidadPagada, double precioTotal) {
		double cambio = 0;
		cambio = cantidadPagada - precioTotal;
		return cambio;
	}

	public static void comprar(Hashtable<String, Double> articulos) {
		String art;
		int cantidad;
		int cantidadTotal = 0;
		double ivaAplicado;
		double precioSinIva;
		double precioConIva;
		double precioTotalSinIva = 0;
		double precioTotalConIva = 0;

		do {
			art = JOptionPane.showInputDialog("que artículo es: (-1 para acabr de introducir artículos)");// introducimos
																											// el
																											// articulo
			if (articulos.containsKey(art) == true) {// comprobamos q exista
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("cuantos hay: "));
				ivaAplicado = Integer.parseInt(JOptionPane.showInputDialog("que IVA tiene: (21 o 4"));
				precioSinIva = calculaPrecioSinIva(articulos, art, cantidad);
				precioConIva = calculaPrecioConIva(precioSinIva, ivaAplicado);
				precioTotalSinIva += precioSinIva;
				precioTotalConIva += precioConIva;
				cantidadTotal += cantidad;

			} else if (art.equals("-1")) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "el articulo introducido no existe");
			}
		} while (!art.equals("-1"));

		double cantidadPagada = Double.parseDouble(JOptionPane.showInputDialog("articulos comprados: " + cantidadTotal
				+ "\nprecio total sin IVA: " + precioTotalSinIva + "\nprecio total con IVA: " + precioTotalConIva
				+ "\nintroduce la cantidad que vas a pagar: "));
		double cambioDevuelto = cambio(cantidadPagada, precioTotalConIva);
		JOptionPane.showMessageDialog(null, "su cambio es :" + cambioDevuelto);

	}

	/***
	 * 
	 * @param articulos hastable donde buscar el articulo
	 * @param art       articulo introducido
	 * @param cantidad  introducida
	 * @return precio de un articulo en funcion de la cantidad introducida
	 */
	public static double calculaPrecioSinIva(Hashtable<String, Double> articulos, String art, int cantidad) {
		double precio = 0;
		for (String i : articulos.keySet()) {
			if (i.equals(art)) {// buscamar el articulo
				precio = articulos.get(i);// obtener el precio del articulo
			}
		}
		precio = precio * cantidad;// calcular precio en funcion de la cantidad y el precio del articulo
		return precio;// devolver el resultado obtenido

	}

	/***
	 * 
	 * @param precio
	 * @param iva
	 * @return precio con iva
	 */
	public static double calculaPrecioConIva(double precio, double iva) {
		double precioTotal = 0;
		precioTotal = precio + (precio * (iva / 100));
		return precioTotal;

	}

}
