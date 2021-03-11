package pe.edu.unmsm.sgdfd.mat.backend.tramites.util;

public class StringsUtils {
	public static String obtenerCadenaDespuesDePunto(String cadenaConPunto) {
		return cadenaConPunto.substring(cadenaConPunto.lastIndexOf('.') + 1);
	}

	public static String concatenarCadena(Object... objetos) {
		StringBuffer sb = new StringBuffer();
		for (Object objeto : objetos) {
			sb.append(objeto.toString());
		}
		return sb.toString();
	}

	public static String[] obtenerSubCadenas(String cadena, String separador) {
		return cadena.split(separador, 2);
	}

	public static String obtenerCadenaDespuesDe(String cadena, String separador) {
		if (cadena != null && cadena.length() > 0) {
			return cadena.substring(cadena.lastIndexOf(separador) + 1);
		}
		return cadena;
	}

	public static String obtenerCadenaAntesDe(String cadena, String separador) {
		if (cadena != null && cadena.length() > 0) {
			return cadena.substring(0, cadena.lastIndexOf(separador));
		}
		return cadena;
	}

	public static String removerUltimoCaracter(String cadena) {
		if (cadena != null && cadena.length() > 0) {
			cadena = cadena.substring(0, cadena.length() - 1);
		}
		return cadena;
	}

	public static String concatenar(Object... a) {
		String resul = "";
		for (Object el : a) {
			resul = resul + el;
		}
		return resul;
	} 

//	public static String reemplazar(String... a) {
//		if(a.length % 2 == 0){
//			for (int i = 0; i < a.length/2; i++) {
//				String string = a[i];
//			}
//		}
//		
//		return resul;
//	}
}
