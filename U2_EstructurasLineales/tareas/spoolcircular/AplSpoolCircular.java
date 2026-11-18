/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto: Spool Circular
 * Fecha: 01 de noviembre del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/
package U2_EstructurasLineales.tareas.spoolcircular;

import U0_Diagnostico.utilerias.Rutinas;

public class AplSpoolCircular {

	public static void main(String [] args) {
		SpoolCircular spool = new SpoolCircular();
		
		int i = 0, AC = Rutinas.nextInt(10, 30);
		while(i <= AC) {
			System.out.println("___________________" + " " + i + " "+ "___________________\n");
			switch(Rutinas.nextInt(1, 3)) {
			case 1: 
				if(spool.Insertar(new Registro()))
					i++;
			break;
			case 2:
				if(spool.Imprimir())
					i++;
			break;
			case 3:
				spool.EstadoActual();
			break;
			}
		}
		
		
	}
	
}
