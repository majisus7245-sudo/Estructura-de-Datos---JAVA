package ClonacionFuerte;
import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import UNIDAD2.Recursiva;
import UNIDAD3ESTATICAS.*;
class Cancion <T> implements Serializable {
	int id; 
	String name; 
	T [] arreglo;

	public Cancion() {
		this(0,"");
	}
	public Cancion( int id, String name )
	{
		this.id = id;
		this.name = name;
		arreglo=(T[]) new Object[10];
	}
	public void Agregar(int i, T dato) {

		arreglo[i]=dato;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T[] getArreglo() {
		return arreglo;
	}

}

public class AplClonar {

	public static void main(String[] args) {

//		Cola<Integer> cola=new Cola(10);
//
//		for(int i=0 ; i<5 ; i++)
//			System.out.println(cola.Insertar(new Integer(i)));
//		System.out.println("se clona y se intentan insertar 10 datos mas");	
//		Cola<Integer> clonada=Serializacion.Copy(cola);
//		for(int i=6 ; i<16 ; i++)
//			System.out.println(clonada.Insertar(new Integer(i)));
//
//		System.out.println("Contenido de la original");
//		cola=clonada;	
//		while(cola.Retirar())
//			System.out.println(cola.getDr());
		
		Cancion<String> canciones=new Cancion();
		Cancion<String> cancionesClonada=new Cancion();
		canciones.Agregar(0,"LOBA");
		canciones.Agregar(1,"TRISTE");
		canciones.Agregar(2,"REYMUNDO");
		
		cancionesClonada=Serializacion.Copy(canciones);
		canciones.Agregar(3,"LOBA1");
		canciones.Agregar(4,"TRISTE1");
		canciones.Agregar(5,"REYMUNDO1");		
		
		Object [] c1= canciones.getArreglo();
		System.out.println("Tamaño arreglo "+c1.length);
		for (int i=0 ; i<c1.length;i++)
			System.out.println(c1[i]);
		System.out.println("________ clonada  ________");
		c1=cancionesClonada.getArreglo();
		for (int i=0 ; i<c1.length;i++)
			System.out.println(c1[i]);		
	}




}
