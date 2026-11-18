/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto: Examen unidad 4
 * Fecha: 03 de diciembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/

package ExamenUN4;

import UNIDAD_0.Rutinas;

public class Producto {
	
	private int idProducto;
	private int nivel;
	
	public Producto(int idProducto) {
		this.idProducto = idProducto;
		nivel = 0;
	}
	public Producto(int idProducto, int nivel) {
		this.idProducto = idProducto;
		this.nivel = nivel;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String toString() {
		return Rutinas.PonCeros(idProducto, 5);
	}
	
}
