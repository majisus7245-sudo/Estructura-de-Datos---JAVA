package U2_EstructurasLineales.ejercicios.dinamicas;
import java.util.ArrayList;

import U2_EstructurasLineales.ejercicios.estaticas.*;
public class AplLista {

	public static void main(String[] args) {
		
		Lista<Persona> lista = new Lista();
		
		System.out.println(lista.InsertarOrdenado(new Persona("Pedro","sinaloa",10)));
		System.out.println(lista.InsertarOrdenado(new Persona("Javier","sinaloa",10)));
		System.out.println(lista.InsertarOrdenado(new Persona("Raymundo","sinaloa",10)));
		System.out.println(lista.InsertarOrdenado(new Persona("Alicia","sinaloa",10)));
		System.out.println(lista.InsertarOrdenado(new Persona("Juan4","sinaloa",10)));
		System.out.println(lista.InsertarOrdenado(new Persona("Ximena","sinaloa",10)));
		String [] nombres= {"Raymundo","Pedro","Javier","Ximena","Alicia","Juan4"};
//		System.out.println(lista.Borrar(new Persona("juan","sinaloa",10)));
//		System.out.println(lista.Borrar(new Persona("juan","sinaloa",10)));
		System.out.println(" Tamaño lista "+lista.length());
		
		int pos=0;
		for(int i=0 ; i<nombres.length;i++) {
			if(lista.Borrar(new Persona(nombres[i],"sinaloa",0)))
				System.out.println("Borro "+lista.getDr().toString());
		
		}
		Nodo<Persona> aux = lista.getFrente();
		
		while (aux != null) {
			System.out.println(aux.getInfo().getEstado()+" "+aux.getInfo().getNombre());
			aux=aux.getSig();
		}
		

		System.out.println("ENCONTRO "+lista.Buscar(new Persona("Alicia","sinaloa",0)));
		System.out.println(   );
		for(int i=0 ; i<nombres.length;i++)
		if(lista.Buscar(new Persona(nombres[i],"sinaloa",0)))
			System.out.println("ENCONTRO "+lista.getDr().toString());
	}

}
