/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 5
 * Proyecto: Proyecto de Ordenamiento
 * Fecha: 07 de diciembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/

package Ordenamiento;

import java.io.File;
import java.io.RandomAccessFile;

import UNIDAD_0.Rutinas;

class Persona{
	
	private String nombre, color;
	private int edad, estatura;
	private char vig;
	
	public Persona(String nombre, int edad, int estatura, String color, char vig) {
		this.nombre = nombre;
		this.edad = edad;
		this.estatura = estatura;
		this.color = color;
		this.vig = vig;
	}
	public String  toString() {
		return Rutinas.PonBlancos(color, 15) + Rutinas.PonBlancos(nombre, 40);
	}
	public String getNombre() {
		return nombre;
	}
	public String getColor() {
		return color;
	}
	public int getEdad() {
		return edad;
	}
	public int getEstatura() {
		return estatura;
	}
	public char getVig() {
		return vig;
	}
}

public class OrdenamientoExterno {

	static private RandomAccessFile arch=null;
	
	public void QuickSort(String archivo) {
		if(!Abrir(archivo)) {
			System.out.println("Hubo un error con el archivo");
			return;
		}
		try {
			QuickSort(0, (arch.length()/69)-1);
		}catch(Exception obj) {
			return;
		}
		if(!Cerrar()) {
			System.out.println("No se pudo cerrar el archivo");
			return;
		}
		
	}
	private void QuickSort(long izq, long der) {
		long i, j;
		i = izq;
		j = der;
		Persona pivote, aux1, aux2;	
		pivote = Crear((izq+der)/2);
		do {
			while(i < der){
				aux1 = Crear(i);
				if(aux1.toString().compareTo(pivote.toString())<0)
					i++;
				else
					break;
			}
			while(j > izq) {
				aux1 = Crear(j);
				if(pivote.toString().compareTo(aux1.toString()) < 0)
					j--;
				else
					break;
			}
			if(i <= j) {
				aux1 = Crear(i);
				aux2 = Crear(j);
				Sobreescribir(aux2, i);
				Sobreescribir(aux1, j);
				i++;
				j--;
			}
			
		}while(i<=j);
		if(izq < j)
			QuickSort(izq, j);
		if(i < der)
			QuickSort(i, der);
	}
	private void Sobreescribir(Persona persona, long i) {
		try {
			arch.seek(i*69);
			arch.writeUTF(persona.getNombre());
			arch.writeInt(persona.getEdad());
			arch.writeInt(persona.getEstatura());
			arch.writeUTF(persona.getColor());
			arch.writeChar(persona.getVig());
		}catch(Exception obj) {
			return;
		}
	}
	private Persona Crear(long i) {
		try {
			arch.seek(i*69);
			return new Persona(arch.readUTF(),arch.readInt(),arch.readInt(),arch.readUTF(),arch.readChar());
		}catch(Exception obj) {
			return null;
		}
	}
	public boolean Imprimir(String archivo) {
		if(!Abrir(archivo)) {
			System.out.println("Hubo un error al abrir el archivo");
			return false;
		}
		String nombre,color;
		int edad,estatura;
		char vig='A';
		try {
			arch.seek(0);
			long noReg = arch.length() / 69;
			System.out.println("TOTAL DE REGISTROS = "+noReg);
			for(int i=0 ; i<noReg ; i++) {
				nombre=arch.readUTF(); // 40+2
				edad=arch.readInt();   // 4
				estatura=arch.readInt(); // 4
				color=arch.readUTF(); // 15+2
				vig=arch.readChar();   // 2
				System.out.printf("%-40s  %5d  %5d  %-15s  %1s\n",nombre,edad,estatura,color,vig+"");		
			}
			System.out.println("TOTAL DE REGISTROS = "+noReg);
		} catch (Exception obj) {
			return false;
		}
		if(!Cerrar()) {
			System.out.println("Hubo un error al cerrar el archivo");
			return false;
		}
		return true;
	}
	private boolean Abrir(String archivo) {
		File ar = new File(archivo);
		if(!ar.exists()) {
			return false;
		}
		try {
			arch = new RandomAccessFile(archivo, "rw");
			return true;
		}catch(Exception obj) {
			return false;
		}
	}
	private boolean Cerrar() {
		try {
			arch.close();
		} catch (Exception obj) {
			return false;
		}
		return true;
	}
}
