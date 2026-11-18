/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 1
 * Proyecto: Apl Lista
 * Fecha: 29 de agosto del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/
package U0_Diagnostico.tareas.listalogica;

import java.io.*;

public class AplLista {

	public static void main(String[]args) {
	
		ListaLogica l = new ListaLogica();
		String linea, nombre, estado;
		String [] campos;	
		int reg;
		try {
			FileReader fr = new FileReader("clientes.csv");
			BufferedReader bf = new BufferedReader(fr);
//			System.out.println("AA");
			int i = 0;
			while((linea=bf.readLine()) != null) {
				System.gc();
				campos = linea.split(",");
				reg = Integer.parseInt(campos[0]);
				nombre = campos[1];
				estado = campos[2];
//				System.out.println(reg + " " + nombre + " " + estado + " " );
				l.Agregar(reg, nombre, SacarEstado(estado));
				i++;
				System.out.println(i);
				System.gc();
//				if(i == 600) {
//					break;
//				}
			}
			
			bf.close();
		}catch(Exception obj) {
			System.out.println("Algo paso");
			System.out.println(obj.getLocalizedMessage());
		}
		
		
		System.out.println("AAAA");
		
//		l.Agregar(5, "A", SacarEstado("1"));
//		l.Agregar(3, "V", SacarEstado("1"));
//		l.Agregar(1, "T", SacarEstado("1"));
//		l.Agregar(4, "B", SacarEstado("1"));
//		l.Agregar(2, "G", SacarEstado("1"));
//		
//		l.Agregar(6, "A", SacarEstado("2"));
//		l.Agregar(8, "V", SacarEstado("3"));
//		l.Agregar(10, "T", SacarEstado("1"));
//		l.Agregar(9, "B", SacarEstado("5"));
//		l.Agregar(7, "G", SacarEstado("4"));	
//		l.Agregar(1, "T", SacarEstado("1"));
//		l.Agregar(3, "T", SacarEstado("1"));
//		l.Agregar(2, "B", SacarEstado("3"));
		
		l.Imprimir();
		
	}
	private static String SacarEstado(String noEstado) {
		if(noEstado.equals("1")) {
			return "Durango";
		}else if(noEstado.equals("2")) {
			return "Zacatecas";
		}else if(noEstado.equals("3")) {
			return "Sinaloa";
		}else if(noEstado.equals("4")) {
			return "Colima";
		}else{
			return "Jalisco";
		}
	}
	
}
