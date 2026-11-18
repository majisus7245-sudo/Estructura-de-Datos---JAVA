/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto: Spool Circular
 * Fecha: 01 de noviembre del 2024
 * Maestro: Dr. Garcia Clemente Gerardo*/

package Colas;

import java.io.Serializable;

import UNIDAD_0.Rutinas;
import ClonacionFuerte.Serializacion;

class Registro implements Serializable{
	
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
	
}

public class SpoolCircular {
	
	private ColaCir <Registro> spool;
	private String msg;
	
	public SpoolCircular() {
		spool = new ColaCir(Rutinas.nextInt(40, 60));
	}
	
	public boolean Insertar(Registro registro) {
		if(!Verificar(registro)) {
			msg="Ya no hay espacio suficiente para este reporte";
			return false;
		}
		int secciones = Secciones(registro);
		Registro [] registros = new Registro[secciones];
		int num = registro.getTotalHojas();
		for(int i = 0; i < secciones; i++) {
			registros[i] = Serializacion.Copy(registro);
			if(num >= 50) {
				registros[i].setNoHojas(50);
				num = num - 50;
				continue;
			}
			registros[i].setNoHojas(num);
		}
		if(spool.Vacia()) {
			for(int i = 0; i < secciones; i++)
				spool.Insertar(registros[i]);
			msg="Se ha insertado correctamente el registro";
			return true;
		}
		ColaCir <Registro> aux = new ColaCir(spool.getTamaño());
		int pos;
		pos=num=0;
		while(spool.Retirar() && aux.Insertar(spool.getDr())) {
			if(spool.getDr().getFormato()<registro.getFormato())
				pos = num + 1;
			num++;
		}
		for(int i = 0; i < pos; i++) {
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
		int secciones = Secciones(registro);
		boolean con = true;
		ColaCir <Registro> clonada = Serializacion.Copy(spool);
		for(int i = 0; i < secciones; i++)
			con = clonada.Insertar(registro);
		return con;
	}
	private int Secciones(Registro registro) {
		int secciones = registro.getTotalHojas()/50;
		if(registro.getTotalHojas()%50!=0)
			secciones++;
		return secciones;
	}

	public String getMsg() {
		return msg;
	}
	
	
}