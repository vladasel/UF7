import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JOptionPane;

/***
 * 
 * @author ionela
 *
 */
public class Ej2APP {
	/*
	 * crea una app q gestione el flujo de ventas de una caja de supermercado. el
	 * programa guardara la cantidads del carrito de compra dentro de una lista.
	 * mostrará por pantalla la siguiente info: -IVA aplicado(21% o 4%) -precio
	 * total bruto y precio mas IVA -numero de articulos comprados -cantidad pagada
	 * -cambio a devolver
	 */
	public static void main(String[] args) {
		// diccionario donde se guardarán los articulos que pueden pasar por caja
		Hashtable<String, Double> articulos = new Hashtable<String, Double>();

		articulos.put("arroz", 1.5);
		articulos.put("leche", 1.2);
		articulos.put("miel", 4.9);
		articulos.put("macarrones", 0.8);
		articulos.put("atun", 3.5);
		articulos.put("aceite", 6.3);
		articulos.put("pan", 0.9);
		articulos.put("agua", 1.3);
		String art;
		int cantidad;
		int cantidadTotal = 0;
		double ivaAplicado;
		double precioSinIva;
		double precioConIva;
		double precioTotalSinIva = 0;
		double precioTotalConIva = 0;

		do {
			art = JOptionPane.showInputDialog("que artículo es: (arroz,leche,miel,macarrones,atun,aceite,pan,agua)");// introducimos
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
		System.out.println(precioTotalSinIva);
		System.out.println(precioTotalConIva);

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

}
