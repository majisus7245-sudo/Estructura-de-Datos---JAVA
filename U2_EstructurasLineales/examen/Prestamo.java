/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 3
 * Proyecto: EXAMEN UNIDAD 3
 * Fecha: 22 de noviembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/
package U2_EstructurasLineales.examen;

import U0_Diagnostico.utilerias.Rutinas;

public class Prestamo {

	private int año, estado, importe;
	
	public Prestamo(int año, int estado, int importe) {
		this.año = año;
		this.estado = estado;
		this.importe = importe;
	}
	
	public String toString() {
		return año + Rutinas.PonCeros(estado, 2) + "";// EL +"" NO ES NECESARIO, AL AÑO EN ESTE CASO SE PUEDE OMITIR EL PONCERO YA QUE ES DE LONG FIJA DE 4
	}

	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public int getAño() {
		return año;
	}
	public int getEstado() {
		return estado;
	}
	
}
