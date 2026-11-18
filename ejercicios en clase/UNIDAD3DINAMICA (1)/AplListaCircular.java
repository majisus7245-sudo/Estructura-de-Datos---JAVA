package UNIDAD3DINAMICA;
import UNIDAD3ESTATICAS.*;
public class AplListaCircular {

	public static void main(String[] args) {
		ListaCircular <Persona>lista = new ListaCircular();
		
		lista.InsertarFrente(new Persona(Rutinas.nextNombre(1),
										Rutinas.nextColor(),
										Rutinas.nextInt(10,20)));
		
		lista.InsertarFrente(new Persona(Rutinas.nextNombre(1),
				Rutinas.nextColor(),
				Rutinas.nextInt(10,20)));
		lista.InsertarFrente(new Persona(Rutinas.nextNombre(1),
				Rutinas.nextColor(),
				Rutinas.nextInt(10,20)));
		lista.InsertarFrente(new Persona(Rutinas.nextNombre(1),
				Rutinas.nextColor(),
				Rutinas.nextInt(10,20)));
		System.out.println("Total de nodos "+lista.getLength());
		Nodo<Persona> aux = lista.getFrente();
		while (aux != null) {
			System.out.println(aux.getInfo().getNombre());
			if(aux == lista.getFin())
				break;
			aux=aux.getSig();
		}
		System.out.println("________________");
		aux=lista.getFrente();
		for(int i=0 ; i<lista.getLength() ; i++,aux=aux.getSig()) {
			System.out.println(aux.getInfo().getNombre());
			;
		}
	}

}
