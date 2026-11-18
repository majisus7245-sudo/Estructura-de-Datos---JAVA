/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 1
 * Proyecto: Lista Logica
 * Fecha: 29 de agosto del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/
package U0_Diagnostico.tareas.listalogica;

import java.io.*;

public class ListaLogica {
	static Cliente [] clientes;
	static Cliente[] aux;
	static int sig, asig, reg, inicio = -1;
	
	public ListaLogica() {
		clientes = new Cliente[0];
	}
	
	public void Agregar(int reg, String Cliente, String Estado) {
		//Si llega un dato mas grande agrandar el arreglo
		if(reg > clientes.length) {
			aux = clientes;
			clientes = new Cliente[reg];
			for(int i = 0; i < aux.length; i++) 
				clientes[i] = aux[i];
		}
		if(clientes[reg-1] != null) 
			return;
		clientes[reg-1] = new Cliente(reg-1,Cliente, Estado);
		//Insertar inicio
		if(inicio == -1) {
			inicio = reg -1;
			return;
		}
		//Verificar si es menor al primero
		if(clientes[reg-1].toString().compareTo(clientes[inicio].toString()) <= 0) {
			clientes[reg-1].setSiguiente(inicio);
			inicio = reg -1;
			return;
		}
		sig = inicio;
		asig = -1;//posicion anterior
		//Buscar la posicion
		while(sig != -1 && clientes[reg-1].toString().compareTo(clientes[sig].toString()) >= 0) {
			asig = sig;
			sig = clientes[sig].getSiguiente();
		}
		
		//Guardar el valor del atributo siguiente
		clientes[reg-1].setSiguiente(sig);
		if(asig != -1) {
			clientes[asig].setSiguiente(reg-1);
		}
	}	
	
	public void Imprimir() {
		System.out.println("Valor inicial: " + inicio);
		String cadena="";
		sig = inicio;
		while(sig != -1) {
			cadena += String.format("%-5d %-25s %-25s %-5d \n", clientes[sig].getId(),clientes[sig].getNomEstado(), clientes[sig].getNomCliente(), clientes[sig].getSiguiente());
			sig = clientes[sig].getSiguiente();
		}
//		for(int i = 0; i < clientes.length; i++) {
//			if(clientes[i] == null)
//				continue;
////			System.out.println(i);
//			cadena += String.format("%5d %25s %25s %5d \n", i, clientes[i].getNomEstado(), clientes[i].getNomCliente(), clientes[i].getSiguiente());
//		}
		System.out.println(cadena);
	}
}
