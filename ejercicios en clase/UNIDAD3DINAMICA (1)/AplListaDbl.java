package UNIDAD3DINAMICA;
import UNIDAD3ESTATICAS.*;
public class AplListaDbl {

	public static void main(String[] args) {
		ListaDbl<Persona> lista = new ListaDbl();

		
		lista.InsertarOrdenado(new Persona("Juan","Sinaloa",20));
		lista.InsertarOrdenado(new Persona("Alicia","Sinaloa",20));
		lista.InsertarOrdenado(new Persona("Raymundo","Campeche",20));
		lista.InsertarOrdenado(new Persona("Chistian","Sinaloa",20));
		lista.InsertarOrdenado(new Persona("Paul","Sinaloa",20));
		lista.InsertarOrdenado(new Persona("Zoila","Campeche",20));
		lista.InsertarOrdenado(new Persona("Jade","Sinaloa",20));
		lista.InsertarOrdenado(new Persona("Jesus","Campeche",20));
		lista.InsertarOrdenado(new Persona("Victor","Sinaloa",20));
		System.out.println("Buscando a Raymundo que es de Campeche");
		System.out.println(lista.Buscar(new Persona("Raymundo","Sinaloa",20)));
		//while(lista.Borrar(1));
		
		NodoDbl<Persona> aux=lista.getFrente();
		while (aux != null) {
			System.out.println(aux.getInfo());

			aux=aux.getSig();
		}
	}

}

	