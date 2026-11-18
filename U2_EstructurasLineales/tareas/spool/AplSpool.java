/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 3
 * Proyecto: AplSpool
 * Fecha: 13 de octubre del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/
package U2_EstructurasLineales.tareas.spool;

import U0_Diagnostico.utilerias.Rutinas;

public class AplSpool {

	public static void main(String[] args) {
		
		Spool spool = new Spool();
		
		int i = 0, AC = Rutinas.nextInt(10, 30);
		while(i <= AC) {
			System.out.println("___________________" + " " + i + " "+ "___________________\n");
			switch(Rutinas.nextInt(1, 3)) {
			case 1: 
				if(spool.Enviar(new Registro()))
					i++;
				System.out.println(spool.getMsg());
			break;
			case 2:
				if(spool.Imprimir())
					i++;
				System.out.println(spool.getMsg());
			break;
			case 3:
				spool.EstadoActual();
				System.out.println(spool.getMsg());
			break;
			}
		}
		
	}

}
