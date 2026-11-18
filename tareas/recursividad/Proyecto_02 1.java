/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 2
 * Proyecto: Proyecto 2
 * Fecha: 27 de septiembre del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/

package Recursividad;

public class Proyecto_02 {

	public static String PonComas(long cantidad) {
		return PonComas(cantidad + "");
	}
	private static String PonComas(String texto) {
		if(texto.length() <= 3)
			return texto;
		return PonComas(texto.substring(0, texto.length()-3)) + "," + texto.charAt(texto.length()-3) + 
				texto.charAt(texto.length()-2) + texto.charAt(texto.length()-1);
	}
	
	public static String miTrim(String texto) {
		return miTrim(texto, 0);
	}
	private static String miTrim(String texto, int i) {
		System.out.println(texto);
		if(i == texto.length())
			return texto;
		if(texto.charAt(0) == ' ')
			return miTrim(texto.substring(1,texto.length()), i);
		if(texto.charAt(texto.length()-1) == ' ')
			return miTrim(texto.substring(0,texto.length()-1), i);
		if(texto.charAt(i) == ' ' && texto.charAt(i+1) == ' ')
			return miTrim(texto.substring(0, i+1)+texto.substring(i+2,texto.length()),i);
		return miTrim(texto, i+1);
	}
	
	private static String [] unidades = {
			"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", 
		    "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", 
		    "diecisiete", "dieciocho", "diecinueve", "veinte", "veintiuno", 
		    "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", 
		    "veintisiete", "veintiocho", "veintinueve"};
	private static String [] decenas = {"diez","veinte","treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa","cien"};
	private static String [] centenas = {"ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", 
			"seiscientos", "setecientos", "ochocientos", "novecientos"};
	private static String [] secciones = {"","millones ","billones "};
	private static String [] subsecciones = {"","mil "};
	private static String [] especial = {"","un millon ","un billon "};
	private static int p1, p2;
	
	public static String Proteccion(long cantidad) {
		return Proteccion(CeroIzquierda(cantidad + ""), 0, 0, (cantidad+"").length());
	}
	private static String Proteccion(String cantidad, int i, int j, int lon) {
		String texto = "";
		if(cantidad.length() == 0)
			return texto;
		String cadena = cantidad.substring(cantidad.length()-3, cantidad.length());
		p1 = Integer.parseInt(cadena.substring(1, 3));
		p2 = Integer.parseInt(cadena.substring(0, 1));
		if(p1 == 0 && p2 == 0 && j == 1)
			return Proteccion(cantidad.substring(0, cantidad.length()-3),i+1,0, lon);
		if(p1 == 0 && p2 == 0)
			return Proteccion(cantidad.substring(0, cantidad.length()-3),i,j+1,lon);
		if(p1 == 1 && (lon == 7 && i == 1) || (lon == 13 && i == 2)) {
			return especial[i];
		}
		if(p2 == 1 && p1 == 0 && j == 0) {
			texto += "cien " + secciones[i];
			return Proteccion(cantidad.substring(0, cantidad.length()-3),i,j+1,lon) + texto;
		}
		if(p2 == 0 && p1 == 1 && j == 1) {
			texto += "mil " + secciones[i];
			return Proteccion(cantidad.substring(0, cantidad.length()-3),i+1,0,lon) + texto;
		}
		if(p2 == 1 && p1 == 0 && j == 1) {
			texto += "cien " + subsecciones[j];
			if(i == 1)
				texto += "millones ";
			if(i == 2)
				texto += "billones ";
			return Proteccion(cantidad.substring(0, cantidad.length()-3),i,j+1,lon) + texto;
		}
		if(p2 != 0)
			texto += centenas[p2-1] + " ";
		if(p1 != 0) {
			if(p1 < 30)
				texto += unidades[p1-1] + " ";
			else{
				texto += decenas[(Integer.parseInt(cadena.charAt(1)+""))-1] + " ";
				if(Integer.parseInt(cadena.charAt(2)+"") != 0)
					texto += "y " + unidades[(Integer.parseInt(cadena.charAt(2)+"")-1)] + " ";
			}
		}
		texto += subsecciones[j];
		if(j == 0)
			texto += secciones[i]; 
		if(j != 0)
			return Proteccion(cantidad.substring(0, cantidad.length()-3),i+1,0,lon) + texto;
		return Proteccion(cantidad.substring(0, cantidad.length()-3),i,j+1,lon) + texto; 		
	}
	private static String CeroIzquierda(String texto) {
		if(texto.length() == 18)
			return texto;
		if(texto.length() % 3 == 0)
			return texto;
		return CeroIzquierda("0"+texto);
	}
	
}
