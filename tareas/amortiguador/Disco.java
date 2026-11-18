/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 3
 * Proyecto: Disco
 * Fecha: 03 de octubre del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/

package Pilas;

import UNIDAD_0.Rutinas;

public class Disco {

	private int noDisco;
	private int durabilidad;
	
	public Disco(int noDisco) {
		this.noDisco = noDisco;
		durabilidad = Rutinas.nextInt(97, 100);
	}
	
	public int getDurabilidad() {
		return durabilidad;
	}
	
	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}

	public String toString() {
		return "\t" + noDisco + " - " + durabilidad + "%\n";
	}
	
}
