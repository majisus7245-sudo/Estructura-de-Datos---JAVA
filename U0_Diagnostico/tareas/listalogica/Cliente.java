/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 1
 * Proyecto: Orden logico
 * Fecha: 29 de agosto del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/
package U0_Diagnostico.tareas.listalogica;

import U0_Diagnostico.utilerias.Rutinas;

public class Cliente {

	private String nomCliente;
	private String nomEstado;
	private int siguiente, id;
	
	public Cliente(int id, String nomCliente, String nomEstado) {
		this.id = id;
		this.nomCliente = nomCliente;
		this.nomEstado = nomEstado;
		siguiente = -1;
	}

	public int getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(int siguiente) {
		this.siguiente = siguiente;
	}
	
	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getNomEstado() {
		return nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return Rutinas.PonBlancos(nomEstado, 40) + Rutinas.PonBlancos(nomCliente, 40);
	}
	
}
