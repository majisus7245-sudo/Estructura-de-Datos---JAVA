/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto:Cuenta
 * Fecha: 01 de diciembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/
package U3_EstructurasNoLineales.tareas.proyectoabb;

import U0_Diagnostico.utilerias.Rutinas;

public class Cuenta {

	private String cuenta, nombre;
	private int nivel, cargo, abono;
	
	public Cuenta(String cuenta, String nombre, int nivel) {
		this.cuenta = cuenta;
		this.nombre = nombre;
		this.nivel = nivel;
		cargo=abono=0;
	}
	
	public Cuenta(String num) {
		this(ponerCeros(num), Rutinas.nextNombre(1), Nivel(ponerCeros(num)));
	}
	
	private static String ponerCeros(String num) {
		if(num.length()==6)
			return num;
		return ponerCeros(num + "0");
	}
	private static int Nivel(String num) {
		if(Integer.parseInt(num.substring(2,6)) ==0)
			return 1;
		if(Integer.parseInt(num.substring(4,6)) ==0)
			return 2;
		return 3;
	}
	
	public String toString() {
		return cuenta;
	}
	public String toString(int a) {
		return String.format("%-7s %-7s %-25s %-6s %-10d %-6s %-10d","-"+cuenta,"Nombre:", nombre,"Cargo:", cargo, "Abono:" ,abono);
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public int getAbono() {
		return abono;
	}
	public void setAbono(int abono) {
		this.abono = abono;
	}
	public int getNivel() {
		return nivel;
	}
	
}
