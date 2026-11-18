/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto: Spool Circular
 * Fecha: 01 de noviembre del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/   /////////NOMBRE INCORRECTO
package U2_EstructurasLineales.tareas.spoolcircular.revisado;

import U2_EstructurasLineales.ejercicios.estaticas.*;

import java.io.Serializable;

import U0_Diagnostico.utilerias.Rutinas;
import U0_Diagnostico.ejercicios.clonacion.Serializacion;

class Registro implements Serializable{ // EL NOMBRE DE ESTA CLASE ES MAS ADECUADO Reporte
	
	private int noComputadora;
	private int totalHojas;
	private int formato;
	private int noHojas;
	
	public Registro() {
		this(Rutinas.nextInt(1, 5),Rutinas.nextInt(1, 200), Rutinas.nextInt(1, 5));
	}
	
	public Registro(int noComputadora, int totalHojas, int formato) {
		this.noComputadora = noComputadora;
		this.totalHojas = totalHojas;
		this.formato = formato;
		noHojas = 0;
	}

	public int getNoHojas() {
		return noHojas;
	}

	public void setNoHojas(int noHojas) {
		this.noHojas = noHojas;
	}

	public int getTotalHojas() {
		return totalHojas;
	}

	public int getFormato() {
		return formato;
	}
	
	
	public String toString() {
		return "# de Computadora: " + noComputadora + "\n# de Hojas: " + totalHojas + "\n# de Formatoo: " + formato;
	}
// EL toString está implementado de manera incorrecta ya que debe de contener return Rutinas.PonCeros(formato,3) ya que con eso lo ordenaremos
	
}

public class SpoolCircular {
	
	private ColaCir <Registro> spool;
	private String msg;
	
	public SpoolCircular() {
		spool = new ColaCir(Rutinas.nextInt(40, 60));
	}
	
	public boolean Insertar(Registro registro) { // EL MÉTODO DEBE LLAMARSE Enviar, ESTÁ RECIBIENDO UN REPORTE
		if(!Verificar(registro)) {
			msg="Ya no hay espacio suficiente para este reporte";
			return false;
		}
		int secciones = Secciones(registro);
		Registro [] registros = new Registro[secciones]; // AQUÍ VAS A GENERAR COPIAS DEL REPORTE ORIGINAL
		int num = registro.getTotalHojas();
		for(int i = 0; i < secciones; i++) {
			registros[i] = Serializacion.Copy(registro);//OK
			if(num >= 50) {
				registros[i].setNoHojas(50);//OK
				num = num - 50;
				continue;
			}
			registros[i].setNoHojas(num);// OK, AUNQUE PUDIERAS ELIMINAR EL IF Y AGREGAR DESPUÉS DE ESTA LONE NUM-=50
		}
		if(spool.Vacia()) {// NO HAY NECESIDAD DE ESTO ESCENARIO
			for(int i = 0; i < secciones; i++)
				spool.Insertar(registros[i]);
			msg="Se ha insertado correctamente el registro";
			return true;
		}
		ColaCir <Registro> aux = new ColaCir(spool.getTamaño());
		int pos;
		pos=num=0;
		while(spool.Retirar() && aux.Insertar(spool.getDr())) {
// AQUI NO DEBES USAR EL ATRIBUTO ESPECIFICO, ESE LO DEFINES EN EL TOSTRING , ¿QUÉ PASA SI TE PIDO QUE SE ORDENE POR DOS CAMPOS?
			if(spool.getDr().getFormato()<registro.getFormato())

				pos = num + 1;
			num++;
		}
		for(int i = 0; i < pos; i++) { // LOS MENORES AL NUEVO
			aux.Retirar();
			spool.Insertar(aux.getDr());
		}
		for(int i = 0; i < secciones; i++)
			spool.Insertar(registros[i]);
		while(aux.Retirar() && spool.Insertar(aux.getDr()));
		msg="Se ha insertado correctamente el registro";
		return true;
	}
	public boolean Imprimir() {
		if(spool.Vacia()) {
			msg="No hay Registros que imprimir";
			return false;
		}
		ColaCir<Registro> clon = Serializacion.Copy(spool);
		clon.Retirar();
		int pos = Secciones(clon.getDr());
		for(int i = 0; i < pos; i++) {
			spool.Retirar();
		}
		msg="Dato impreso: \n"+spool.getDr().toString();
		return true;
	}
	public void EstadoActual() {
		ColaCir<Registro> clon = Serializacion.Copy(spool);
		msg="";
		while(clon.Retirar()) {
			int pos = Secciones(clon.getDr())-1;
			for(int i = 0; i < pos; i++) {
				clon.Retirar();
			}
			msg+="--------------------------- \n";
			msg+=clon.getDr().toString();
		}
	}
	private boolean Verificar(Registro registro) {
		int secciones = Secciones(registro); // OK
		boolean con = true;
		ColaCir <Registro> clonada = Serializacion.Copy(spool);// BIEN CLONADA
		for(int i = 0; i < secciones; i++)
			con = clonada.Insertar(registro);// AQUI ES MAS ADECUADO ESTAR CREANDO UN REPORTE PARA CADA ELEMENTO PARA QUE OCUPE LA MEMORIA QUE REQUIERE REALMENTE, COMO LO IMPLEMENTAS LOS DISTINTOS ELEMENTOS DEL REPORTE ESTARÁN AL MISMO REPORTE
		return con;
	}
	private int Secciones(Registro registro) { // BIEN CALCUADO LAS SECCIONES DEL SPOOL QUE REQUIERE
		int secciones = registro.getTotalHojas()/50;
		if(registro.getTotalHojas()%50!=0)
			secciones++;
		return secciones;
	}

	public String getMsg() {
		return msg;
	}
	
	
}