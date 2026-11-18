/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 3
 * Proyecto: Spool
 * Fecha: 13 de octubre del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/
package U2_EstructurasLineales.tareas.spool;

import U2_EstructurasLineales.ejercicios.estaticas.*;

import U0_Diagnostico.utilerias.Rutinas;

class Registro{
	
	private int noComputadora, noHojas;
	private String formato;
	
	public Registro() {
		this.noComputadora = Rutinas.nextInt(1, 5);
		this.noHojas = Rutinas.nextInt(1, 500);
		switch(Rutinas.nextInt(1, 5)) {
		case 1: this.formato = "docx"; break;
		case 2: this.formato = "pptx"; break;
		case 3: this.formato = "pdf"; break;
		case 4: this.formato = "xlsx"; break;
		case 5: this.formato = "txt"; break;
		}
	}
	public String toString() {
		return "- # Computadora: " + noComputadora + "\n" + "# Hojas: " + noHojas + "\n" + "Formato: " + formato + "\n";
	}
}

public class Spool {

	private Cola<Registro> cola;
	private String msg;
	
	public Spool() {
		cola = new Cola(Rutinas.nextInt(20, 50));
	}
	
	public boolean Enviar(Registro registro) {
		if(!cola.Insertar(registro)) {
			msg = "Cola llena, el registro no se pudo enviar.";
			return false;
		}
		msg = "Registro enviado exitosamente. \n" + registro.toString();
		return true;
	}
	public boolean Imprimir() {
		if(!cola.Retirar()) {
			msg = "No hay registros para imprimir.";
			return false;
		}
		msg = "Registro impreso exitosamente. \n" + cola.getDr().toString();
		return true;
	}
	public void EstadoActual() {
		Cola<Registro> aux = new Cola(cola.getMaximo());
		int conObj,conNull, pos, max = cola.getMaximo();
		conObj=conNull=0;
		while(cola.Insertar(null))
			conNull++;
		while(cola.Retirar())
			if(cola.getDr() != null) {
				aux.Insertar(cola.getDr());
				conObj++;
			}
		pos = max - (conObj + conNull);
		Manipular(pos, 0, 1);
		msg = "-------------------Estado actual-------------------\n";
		while(aux.Retirar() && cola.Insertar(aux.getDr())) 
			msg += aux.getDr().toString();
		Manipular(pos, 0, 2);
		if(msg.equals("-------------------Estado actual-------------------\n"))
			msg = "No hay nigun estado del spool";
	}
	public void Manipular(int pos, int i, int op) {
		if(i == pos) {
			return;
		}
		if(op == 1)
			cola.Insertar(null);
		if(op == 2)
			cola.Retirar();
		Manipular(pos, i+1, op);
	}

	public String getMsg() {
		return msg;
	}
		
}
