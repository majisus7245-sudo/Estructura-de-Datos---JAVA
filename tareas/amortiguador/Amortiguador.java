/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 3
 * Proyecto: Amortiguador
 * Fecha: 03 de octubre del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/

package Pilas;

import UNIDAD_0.Rutinas;

public class Amortiguador {

	private Pila<Disco> discos;
	private Pila<Disco> aux;
	private Disco disco1, disco2;
	private int noDiscos;
	private String msg;
	
	public Amortiguador() {
		noDiscos = Rutinas.nextInt(15, 50);
		discos = new Pila(noDiscos);
		for(int i = 0; i < noDiscos; i++)
			discos.Insertar(new Disco(i+1));
	}
	
	public boolean Bache() {
		if(noDiscos < 4)
			return false;
		aux = new Pila(noDiscos-2);
		msg = "Discos que absorbieron la energia:\n";
		for(int i = 0; i < noDiscos; i++) {
			discos.Retirar();
			if(i == 0) {
				disco2 = discos.getDr();
				disco2.setDurabilidad(disco2.getDurabilidad()-Rutinas.nextInt(1, 3));
				msg += discos.getDr().toString();
				continue;
			}
			if(i == noDiscos-1) {
				disco1 = discos.getDr();
				disco1.setDurabilidad(disco1.getDurabilidad()-Rutinas.nextInt(1, 3));
				msg += discos.getDr().toString();
				break;
			}
			aux.Insertar(discos.getDr());
		}
		for(int i = 0; i < aux.getTamañoMaximo()/2; i++) {
			aux.Retirar();
			discos.Insertar(aux.getDr());
		}
		if(disco1.getDurabilidad() >= 30) 
			discos.Insertar(disco1);
		else 
			noDiscos--;
		if(disco2.getDurabilidad() >= 30) 
			discos.Insertar(disco2);
		else 
			noDiscos--;
		while(aux.Retirar() && discos.Insertar(aux.getDr()));
		
		return true;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
