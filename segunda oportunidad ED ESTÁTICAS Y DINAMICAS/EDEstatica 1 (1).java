/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 3
 * Proyecto: Recuperacion Unidad 3
 * Fecha: 13 de diciembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/

package RecuperacionUN3;

import Pilas.Pila;
import UNIDAD_0.Rutinas;

public class EDEstatica {

	public static void main(String[] args) {
		
		Pila<String> nombres = new Pila<>(Rutinas.nextInt(150, 300));
		Pila<Integer> posiciones = new Pila<>(Rutinas.nextInt(50, 100));
		String persona;
		do {
			persona = Rutinas.nextNombre(1);
		}while(nombres.Insertar(persona));
		Integer num;
		do {
			num = Rutinas.nextInt(1, posiciones.getTamañoMaximo());
		}while(posiciones.Insertar(num));
		
		Modificar(nombres, posiciones);
		
		Pila<String> aux = new Pila<>(nombres.getTamañoMaximo());
		while(nombres.Retirar()) {
			if(nombres.getDr() == null)
				continue;
			aux.Insertar(nombres.getDr());
		}
		while(aux.Retirar() && nombres.Insertar(aux.getDr()));	
	}
	
	static void Modificar(Pila<String> nombres, Pila<Integer> posiciones) {
		if(posiciones.Vacia())
			return;
		Pila<String> aux = new Pila<>(nombres.getTamañoMaximo());
		posiciones.Retirar();
		int pos = nombres.getTamañoMaximo() - posiciones.getDr();
		for(int i = 0; i < pos; i++) {
			nombres.Retirar();
			aux.Insertar(nombres.getDr());
		}
		nombres.Retirar();
		nombres.Insertar(null);
		while(aux.Retirar() && nombres.Insertar(aux.getDr()));
		
		Modificar(nombres, posiciones);
	}
	
}
